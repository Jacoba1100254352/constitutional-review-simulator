"""Independently calculable inference and preference fixtures for the registered study."""

import copy
from itertools import product
import math
import random
import unittest

from historical_data import load_protocol
import historical_robustness_analysis as analysis


class HistoricalAnalysisMeasurementTests(unittest.TestCase):
    def test_bootstrap_samples_whole_paired_runs_and_preserves_constant_differences(self):
        plan = analysis.bootstrap_plan(3, 100, 91)
        result = analysis.paired_summary([101, 202, 303], [100, 201, 302], plan)
        self.assertEqual((result["difference"], result["lower"], result["upper"], result["monteCarloSE"]), (1, 1, 1, 0))
        self.assertEqual(plan, analysis.bootstrap_plan(3, 100, 91))
        self.assertNotEqual(plan, analysis.bootstrap_plan(3, 100, 92))
        # Independent direct index sampling must reproduce the compressed counts exactly.
        rng = random.Random(91)
        direct = [[rng.randrange(3) for _ in range(3)] for _ in range(100)]
        for selected, block in zip(direct, plan.blocks):
            self.assertEqual(sorted(selected), sorted(i for i, count in block for _ in range(count)))

    def test_exhaustive_two_run_interval_and_mc_standard_error(self):
        plan = analysis.BootstrapPlan(2, (((0, 2),), ((0, 1), (1, 1)), ((0, 1), (1, 1)), ((1, 2),)))
        result = analysis.paired_summary([0, 2], [0, 0], plan)
        self.assertEqual(result["difference"], 1)
        self.assertAlmostEqual(result["lower"], 0.075)
        self.assertAlmostEqual(result["upper"], 1.925)
        self.assertAlmostEqual(result["monteCarloSE"], 1)
        # Equal-run, not pooled by a hypothetical variable conditional denominator.
        rates = analysis.paired_summary([1, 0], [0, 0], plan)
        self.assertEqual(rates["difference"], 0.5)
        self.assertNotEqual(rates["difference"], 1 / 101)

    def test_resampling_and_percentile_reject_invalid_grains(self):
        for args in ((1, 2000, 1), (3, 1, 1)):
            with self.assertRaises(ValueError):
                analysis.bootstrap_plan(*args)
        for blocks in ((((0, 1),), ((0, 2),)), (((0, 1), (0, 1)), ((0, 2),)), (((2, 2),), ((0, 2),))):
            with self.assertRaises(ValueError):
                analysis.BootstrapPlan(2, blocks)
        with self.assertRaises(ValueError):
            analysis.paired_summary([1, 2], [1], analysis.bootstrap_plan(2, 2, 1))
        for values, p in (([], 0.5), ([1], -1), ([float("nan")], 0.5)):
            with self.assertRaises(ValueError):
                analysis.percentile(values, p)

    def test_linear_percentile_matches_independent_order_statistic_formula(self):
        values = [7, -1, 8, 3, 0]
        ordered = sorted(values)
        for p in (0, 0.025, 0.2, 0.5, 0.975, 1):
            position = p * 4
            low, high = int(math.floor(position)), int(math.ceil(position))
            expected = ordered[low] + (position - low) * (ordered[high] - ordered[low])
            self.assertAlmostEqual(analysis.percentile(values, p), expected)

    def test_strict_practical_thresholds_do_not_turn_small_or_opposite_effects_into_stable_claims(self):
        examples = [([0.02, 0.03], 1, "stable"), ([-0.02, -0.03], -1, "stable"),
                    ([0.02, -0.03], 1, "sign-reversing"), ([0.01, 0.02], 1, "mixed/weak"),
                    ([-0.02, -0.03], 1, "mixed/weak"), ([0, 0], 1, "mixed/weak"),
                    ([0.02, 0.03], 0, "descriptive-only")]
        for values, expected_sign, classification in examples:
            with self.subTest(values=values, sign=expected_sign):
                result = analysis.pattern(values, [x - 0.1 for x in values], [x + 0.1 for x in values], expected_sign, 0.01)
                self.assertEqual(result["classification"], classification)
                self.assertEqual(result["intervalsAboveZero"] + result["intervalsBelowZero"], 0)
                self.assertEqual(result["positiveCells"] + result["negativeCells"] + result["nearZeroCells"], 2)

    def test_claim_binding_inventory_preserves_all_registered_components(self):
        components = analysis.load_components()
        self.assertEqual(len(components), 22)
        registered = {(claim, metric) for claim, metrics in analysis.REGISTERED.items() for metric in metrics}
        self.assertEqual(len(registered), 19)
        self.assertTrue(registered.issubset({(row["claim"], row["metric"]) for row in components}))
        self.assertTrue(all(row["expectedSign"] == 0 for row in components if row["role"] != "registered-component"))

    def test_dirichlet_uses_registered_uniform_log_transform_without_fitted_rescaling(self):
        weights = analysis.dirichlet_weights(1000, 12, 2026091202)
        self.assertEqual(weights, analysis.dirichlet_weights(1000, 12, 2026091202))
        rng = random.Random(2026091202)
        expected_raw = [-math.log(rng.random()) for _ in range(12)]
        self.assertEqual(weights[0], tuple(x / math.fsum(expected_raw) for x in expected_raw))
        self.assertTrue(all(all(w > 0 for w in row) and abs(math.fsum(row) - 1) < 1e-12 for row in weights))
        for dimension in range(12):
            self.assertLess(abs(math.fsum(row[dimension] for row in weights) / 1000 - 1 / 12), 0.01)
        self.assertEqual(analysis.oriented_vector({"a": 0.2, "b": 0.8}, ["a"], ["b"]), [0.2, 1 - 0.8])
        self.assertAlmostEqual(analysis.weighted_score([0.2, 0.8], [0.25, 0.75]), 0.65)
        with self.assertRaises(ValueError):
            analysis.oriented_vector({"a": 0.2}, ["a"], ["a"])

    def test_leadership_splits_exact_and_near_ties_without_order_bias(self):
        self.assertEqual(analysis.leader_credits({"a": 0.5, "b": 0.5, "c": 0.1}), {"a": 0.5, "b": 0.5, "c": 0})
        near = analysis.leader_credits({"a": 0.5, "b": 0.5 + 0.5e-12, "c": 0.1})
        self.assertEqual(near, {"a": 0.5, "b": 0.5, "c": 0})
        separated = analysis.leader_credits({"a": 0.5, "b": 0.5 + 2e-12})
        self.assertEqual(separated, {"a": 0, "b": 1})
        self.assertEqual(analysis.weighted_signs([-0.1, 0, 0.1])["reversesAcrossWeights"], True)

    @staticmethod
    def normative_fixture():
        protocol = copy.deepcopy(load_protocol())
        protocol.update(simulationRuns=2, weightMetricsHigher=["benefit"], weightMetricsLower=["cost"])
        scenarios = protocol["stressScenarioKeys"] + protocol["stressAblations"]
        pairs = [(0.3, 0.1), (0.6, 0.4), (0.5, 0.7), (0.9, 0.3), (0.4, 0.2), (0.5, 0.5), (0.6, 0.3), (0.1, 0.3)]
        cell = {scenario: {"benefit": [benefit, benefit], "cost": [cost, cost],
                           "emergencyOrders": [0, 1], "legislativeResponseRate": [0, 0],
                           "emergencyReasonGivingRate": [0, 1], "meritsFollowUpRate": [0, 1],
                           "timelyLegislativeResponseRate": [0, 0]}
                for scenario, (benefit, cost) in zip(scenarios, pairs)}
        return protocol, cell

    def test_same_preferences_and_competitors_are_used_for_response_replacement(self):
        protocol, cell = self.normative_fixture()
        cells = {("profile", "baseline"): cell, ("profile", "alternative"): copy.deepcopy(cell)}
        weights = [(1.0, 0.0), (0.0, 1.0)]
        result = analysis.normative_analysis(cells, protocol, weights)
        leaders = result["-leadership.csv"]
        for variant in ("full-response", "half-response", "no-response"):
            rows = [r for r in leaders if r["context"] == "baseline" and r["responseVariant"] == variant]
            self.assertEqual(len(rows), 4)
            self.assertEqual(math.fsum(r["leadershipShare"] for r in rows), 1)
            self.assertEqual([r["scenario"] for r in rows[:3]], protocol["stressScenarioKeys"][:3])
        effect = result["-response-weight-effects.csv"][0]
        self.assertAlmostEqual(effect["meanDifference"], -0.15)
        self.assertEqual(effect["negativeDraws"], 1)
        self.assertEqual(effect["tiedDraws"], 1)
        self.assertTrue(all(not row["reversesAcrossGrid"] for row in result["-weight-grid-reversals.csv"]))
        for variant, scenario in product(("full-response", "half-response", "no-response"), protocol["stressScenarioKeys"][:3]):
            repeated = [r["leadershipShare"] for r in leaders if r["responseVariant"] == variant and r["scenario"] == scenario]
            self.assertEqual(repeated[0], repeated[1])

    def test_grid_reversals_keep_weight_identity_fixed(self):
        protocol, cell = self.normative_fixture()
        opposite = copy.deepcopy(cell)
        current, reasoned = protocol["stressScenarioKeys"][:2]
        opposite[current]["benefit"], opposite[reasoned]["benefit"] = opposite[reasoned]["benefit"], opposite[current]["benefit"]
        result = analysis.normative_analysis({("p", "a"): cell, ("p", "b"): opposite}, protocol, [(1.0, 0.0)])
        row = next(row for row in result["-weight-grid-reversals.csv"] if row["left"] == current and row["right"] == reasoned)
        self.assertTrue(row["reversesAcrossGrid"])
        self.assertEqual((row["positiveCells"], row["negativeCells"], row["tiedCells"]), (1, 1, 0))

    def test_claim_matrix_keeps_measurement_limits_separate_from_numeric_patterns(self):
        fixture = [{"kind": "base", "metric": "averageTimeToReview", "classification": "mixed/weak"},
                   {"kind": "base", "metric": "timelyLegislativeResponseRate", "classification": "stable"},
                   {"kind": "ablation", "metric": "rightsProtection", "classification": "descriptive-only"}]
        result = analysis.claim_matrix(fixture)
        self.assertEqual(len(result), 2)
        self.assertEqual(result[0]["evidenceStatus"], "unsupported-design-duration-measure")
        self.assertEqual(result[1]["evidenceStatus"], "conditional-response-populations-not-comparable")

    def test_empty_conditional_runs_are_not_pooled_as_failed_events(self):
        vectors = {"emergencyOrders": [0, 1], "emergencyReasonGivingRate": [0, 1],
                   "meritsFollowUpRate": [0, 1], "legislativeResponseRate": [0, 0],
                   "timelyLegislativeResponseRate": [0, 0]}
        result = analysis.denominator_diagnostics(vectors, 80)
        self.assertEqual(result["runsWithoutEmergencyOrders"], 1)
        self.assertEqual(result["pooledReasonsPerOrder"], 1)
        self.assertEqual(result["pooledTimelyPerResponse"], "")
        self.assertEqual(result["legislativeResponses"], 0)
        self.assertNotEqual(result["pooledReasonsPerOrder"], sum(vectors["emergencyReasonGivingRate"]) / 2)
        vectors["emergencyReasonGivingRate"] = [0, 0.5]
        with self.assertRaises(ValueError):
            analysis.denominator_diagnostics(vectors, 80)


if __name__ == "__main__":
    unittest.main()
