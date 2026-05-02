package courtsim.simulation;

import courtsim.institution.AppointmentMethod;
import courtsim.institution.ConstitutionalReviewProcess;
import courtsim.institution.CostProfileKey;
import courtsim.institution.CourtFactory;
import courtsim.institution.DesignConfiguration;
import courtsim.institution.DocketControl;
import courtsim.institution.DocketProcedure;
import courtsim.institution.LegislativeOverrideRule;
import courtsim.institution.RecusalRule;
import courtsim.institution.RemovalStandard;
import courtsim.institution.ReviewArchetype;
import courtsim.institution.ReviewStructure;
import courtsim.institution.ReviewTiming;
import courtsim.institution.TermLimit;
import courtsim.institution.VotingThreshold;
import courtsim.model.CourtWorld;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class ScenarioCatalog {
    private static final List<String> DEFAULT_SCENARIO_KEYS = List.of(
            "current-federal-court",
            "eighteen-year-terms",
            "fifteen-justice-commission",
            "supermajority-invalidation",
            "strict-recusal-court",
            "reasoned-emergency-review",
            "panel-en-banc-review",
            "dual-cross-checking-courts",
            "constitutional-council",
            "legislative-override-court",
            "accountability-retention-court",
            "independence-accountability-hybrid"
    );

    private ScenarioCatalog() {
    }

    public static List<Scenario> defaultScenarios() {
        return scenariosForKeys(DEFAULT_SCENARIO_KEYS);
    }

    public static List<String> defaultScenarioKeys() {
        return DEFAULT_SCENARIO_KEYS;
    }

    public static List<String> scenarioKeys() {
        return entries().stream().map(ScenarioEntry::key).toList();
    }

    public static List<Scenario> allScenarios() {
        return entries().stream().map(ScenarioEntry::scenario).toList();
    }

    public static List<Scenario> scenariosForKeys(List<String> keys) {
        Map<String, Scenario> byKey = new LinkedHashMap<>();
        for (ScenarioEntry entry : entries()) {
            byKey.put(entry.key(), entry.scenario());
        }
        List<Scenario> scenarios = new ArrayList<>();
        for (String key : keys) {
            Scenario scenario = byKey.get(key);
            if (scenario == null) {
                throw new IllegalArgumentException("Unknown scenario key: " + key);
            }
            scenarios.add(scenario);
        }
        return scenarios;
    }

    private static List<ScenarioEntry> entries() {
        return List.of(
                entry("current-federal-court", config(
                        "Current-style federal supreme court",
                        AppointmentMethod.PRESIDENTIAL_SENATE,
                        9,
                        TermLimit.LIFE_TENURE,
                        RemovalStandard.IMPEACHMENT_ONLY,
                        RecusalRule.SELF_POLICING,
                        DocketProcedure.FAST_SHADOW_DOCKET,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.NONE,
                        0.16,
                        0.88,
                        0.18,
                        0.42,
                        0.36,
                        0.58,
                        0.62
                )),
                entry("eighteen-year-terms", config(
                        "Staggered 18-year nonrenewable terms",
                        AppointmentMethod.PRESIDENTIAL_SENATE,
                        9,
                        TermLimit.NONRENEWABLE_18_YEAR,
                        RemovalStandard.IMPEACHMENT_ONLY,
                        RecusalRule.SELF_POLICING,
                        DocketProcedure.FAST_SHADOW_DOCKET,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.NONE,
                        0.08,
                        0.78,
                        0.30,
                        0.44,
                        0.44,
                        0.58,
                        0.62
                )),
                entry("fifteen-justice-commission", config(
                        "Fifteen-justice supermajority commission court",
                        AppointmentMethod.SUPERMAJORITY_COMMISSION,
                        15,
                        TermLimit.NONRENEWABLE_18_YEAR,
                        RemovalStandard.MISCONDUCT_COMMISSION,
                        RecusalRule.MANDATORY_CONFLICT,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.NONE,
                        0.00,
                        0.72,
                        0.38,
                        0.66,
                        0.58,
                        0.62,
                        0.64
                )),
                entry("supermajority-invalidation", config(
                        "Supermajority required to invalidate laws",
                        AppointmentMethod.PRESIDENTIAL_SENATE,
                        9,
                        TermLimit.LIFE_TENURE,
                        RemovalStandard.IMPEACHMENT_ONLY,
                        RecusalRule.SELF_POLICING,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.SUPERMAJORITY_TO_INVALIDATE,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.NONE,
                        0.12,
                        0.84,
                        0.22,
                        0.56,
                        0.46,
                        0.56,
                        0.76
                )),
                entry("strict-recusal-court", config(
                        "Strict recusal with substitute justices",
                        AppointmentMethod.SUPERMAJORITY_COMMISSION,
                        12,
                        TermLimit.NONRENEWABLE_18_YEAR,
                        RemovalStandard.MISCONDUCT_COMMISSION,
                        RecusalRule.RANDOM_SUBSTITUTION,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.NONE,
                        0.00,
                        0.70,
                        0.42,
                        0.76,
                        0.58,
                        0.62,
                        0.62
                )),
                entry("reasoned-emergency-review", config(
                        "Reasoned emergency orders with merits follow-up",
                        AppointmentMethod.PRESIDENTIAL_SENATE,
                        9,
                        TermLimit.NONRENEWABLE_18_YEAR,
                        RemovalStandard.IMPEACHMENT_ONLY,
                        RecusalRule.MANDATORY_CONFLICT,
                        DocketProcedure.MERITS_FOLLOW_UP,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.NONE,
                        0.06,
                        0.80,
                        0.30,
                        0.80,
                        0.54,
                        0.64,
                        0.66
                )),
                entry("panel-en-banc-review", config(
                        "Panel review with en banc safety valve",
                        AppointmentMethod.MERIT_SORTITION,
                        15,
                        TermLimit.NONRENEWABLE_18_YEAR,
                        RemovalStandard.MISCONDUCT_COMMISSION,
                        RecusalRule.MANDATORY_CONFLICT,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.PANEL_EN_BANC,
                        LegislativeOverrideRule.NONE,
                        0.00,
                        0.68,
                        0.42,
                        0.72,
                        0.62,
                        0.62,
                        0.58
                )),
                entry("dual-cross-checking-courts", config(
                        "Dual supreme courts with cross-checking invalidations",
                        AppointmentMethod.SUPERMAJORITY_COMMISSION,
                        18,
                        TermLimit.NONRENEWABLE_18_YEAR,
                        RemovalStandard.MISCONDUCT_COMMISSION,
                        RecusalRule.STRICT_TRANSPARENCY,
                        DocketProcedure.FULL_COURT_EMERGENCY,
                        VotingThreshold.CONCURRENT_MAJORITY,
                        ReviewStructure.CROSS_CHECKING_COURTS,
                        LegislativeOverrideRule.NONE,
                        0.00,
                        0.74,
                        0.40,
                        0.82,
                        0.66,
                        0.66,
                        0.70
                )),
                entry("constitutional-council", config(
                        "Pre-enactment constitutional council",
                        AppointmentMethod.MERIT_SORTITION,
                        12,
                        TermLimit.SHORT_RENEWABLE,
                        RemovalStandard.MISCONDUCT_COMMISSION,
                        RecusalRule.STRICT_TRANSPARENCY,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.HIGH_CONSTITUTIONAL_THRESHOLD,
                        ReviewStructure.CONSTITUTIONAL_COUNCIL,
                        LegislativeOverrideRule.NONE,
                        0.00,
                        0.58,
                        0.55,
                        0.86,
                        0.72,
                        0.70,
                        0.74
                )),
                entry("legislative-override-court", config(
                        "Judicial review with delayed legislative override",
                        AppointmentMethod.PRESIDENTIAL_SENATE,
                        9,
                        TermLimit.NONRENEWABLE_18_YEAR,
                        RemovalStandard.IMPEACHMENT_ONLY,
                        RecusalRule.MANDATORY_CONFLICT,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.DELAYED_MAJORITY_OVERRIDE,
                        0.08,
                        0.72,
                        0.46,
                        0.64,
                        0.52,
                        0.60,
                        0.58
                )),
                entry("accountability-retention-court", config(
                        "Retention-election accountability court",
                        AppointmentMethod.POPULAR_RETENTION,
                        9,
                        TermLimit.SHORT_RENEWABLE,
                        RemovalStandard.RETENTION_ELECTION,
                        RecusalRule.MANDATORY_CONFLICT,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.REFERENDUM_OVERRIDE,
                        0.05,
                        0.46,
                        0.78,
                        0.70,
                        0.48,
                        0.54,
                        0.48
                )),
                entry("independence-accountability-hybrid", config(
                        "Hybrid court balancing independence and accountability",
                        AppointmentMethod.SUPERMAJORITY_COMMISSION,
                        15,
                        TermLimit.NONRENEWABLE_18_YEAR,
                        RemovalStandard.MISCONDUCT_COMMISSION,
                        RecusalRule.RANDOM_SUBSTITUTION,
                        DocketProcedure.MERITS_FOLLOW_UP,
                        VotingThreshold.SUPERMAJORITY_TO_INVALIDATE,
                        ReviewStructure.PANEL_EN_BANC,
                        LegislativeOverrideRule.SUPERMAJORITY_OVERRIDE,
                        0.00,
                        0.68,
                        0.46,
                        0.82,
                        0.70,
                        0.68,
                        0.72
                )),
                entry("dual-supreme-courts", config(
                        "Dual supreme courts with independent agreement requirement",
                        AppointmentMethod.SUPERMAJORITY_COMMISSION,
                        18,
                        TermLimit.NONRENEWABLE_18_YEAR,
                        RemovalStandard.MISCONDUCT_COMMISSION,
                        RecusalRule.STRICT_TRANSPARENCY,
                        DocketProcedure.FULL_COURT_EMERGENCY,
                        VotingThreshold.SUPERMAJORITY_TO_INVALIDATE,
                        ReviewStructure.DUAL_SUPREME_COURTS,
                        LegislativeOverrideRule.NONE,
                        0.00,
                        0.78,
                        0.36,
                        0.80,
                        0.64,
                        0.66,
                        0.74
                )),
                entry("legislative-selection-court", config(
                        "Legislatively selected high-accountability court",
                        AppointmentMethod.LEGISLATIVE_SELECTION,
                        9,
                        TermLimit.SHORT_RENEWABLE,
                        RemovalStandard.MISCONDUCT_COMMISSION,
                        RecusalRule.MANDATORY_CONFLICT,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.SUPERMAJORITY_OVERRIDE,
                        0.18,
                        0.42,
                        0.70,
                        0.68,
                        0.44,
                        0.54,
                        0.52
                )),
                entry("us-supreme-court-benchmark", systemConfig(
                        "U.S. Supreme Court benchmark",
                        AppointmentMethod.PRESIDENTIAL_SENATE,
                        9,
                        TermLimit.LIFE_TENURE,
                        RemovalStandard.IMPEACHMENT_ONLY,
                        RecusalRule.SELF_POLICING,
                        DocketProcedure.FAST_SHADOW_DOCKET,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.NONE,
                        ReviewArchetype.DISCRETIONARY_APPELLATE_LEAVE,
                        ReviewTiming.POST_ENACTMENT,
                        DocketControl.DISCRETIONARY_CERTIORARI,
                        CostProfileKey.US_SUPREME_COURT,
                        0.16, 0.88, 0.18, 0.42, 0.36, 0.58, 0.62
                )),
                entry("german-constitutional-court", systemConfig(
                        "German Federal Constitutional Court",
                        AppointmentMethod.SUPERMAJORITY_COMMISSION,
                        16,
                        TermLimit.NONRENEWABLE_18_YEAR,
                        RemovalStandard.MISCONDUCT_COMMISSION,
                        RecusalRule.STRICT_TRANSPARENCY,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.SUPERMAJORITY_TO_INVALIDATE,
                        ReviewStructure.PANEL_EN_BANC,
                        LegislativeOverrideRule.NONE,
                        ReviewArchetype.CONSTITUTIONAL_COMPLAINT,
                        ReviewTiming.POST_ENACTMENT,
                        DocketControl.COMPLAINT_ADMISSIBILITY,
                        CostProfileKey.GERMAN_CONSTITUTIONAL_COURT,
                        0.00, 0.82, 0.34, 0.78, 0.70, 0.72, 0.76
                )),
                entry("french-constitutional-council", systemConfig(
                        "French Constitutional Council",
                        AppointmentMethod.PRESIDENTIAL_SENATE,
                        9,
                        TermLimit.SHORT_RENEWABLE,
                        RemovalStandard.MISCONDUCT_COMMISSION,
                        RecusalRule.STRICT_TRANSPARENCY,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.HIGH_CONSTITUTIONAL_THRESHOLD,
                        ReviewStructure.CONSTITUTIONAL_COUNCIL,
                        LegislativeOverrideRule.NONE,
                        ReviewArchetype.PRE_ENACTMENT_COUNCIL,
                        ReviewTiming.MIXED_TIMING,
                        DocketControl.REFERRAL_GATED,
                        CostProfileKey.FRENCH_CONSTITUTIONAL_COUNCIL,
                        0.06, 0.58, 0.54, 0.76, 0.62, 0.60, 0.70
                )),
                entry("canadian-supreme-court", systemConfig(
                        "Canadian Supreme Court with override context",
                        AppointmentMethod.SUPERMAJORITY_COMMISSION,
                        9,
                        TermLimit.LIFE_TENURE,
                        RemovalStandard.IMPEACHMENT_ONLY,
                        RecusalRule.MANDATORY_CONFLICT,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.DELAYED_MAJORITY_OVERRIDE,
                        ReviewArchetype.DISCRETIONARY_APPELLATE_LEAVE,
                        ReviewTiming.POST_ENACTMENT,
                        DocketControl.LEAVE_TO_APPEAL,
                        CostProfileKey.CANADIAN_SUPREME_COURT,
                        0.02, 0.76, 0.34, 0.70, 0.58, 0.64, 0.66
                )),
                entry("south-african-constitutional-court", systemConfig(
                        "South African Constitutional Court",
                        AppointmentMethod.SUPERMAJORITY_COMMISSION,
                        11,
                        TermLimit.NONRENEWABLE_18_YEAR,
                        RemovalStandard.MISCONDUCT_COMMISSION,
                        RecusalRule.MANDATORY_CONFLICT,
                        DocketProcedure.MERITS_FOLLOW_UP,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.NONE,
                        ReviewArchetype.MIXED_ABSTRACT_CONCRETE,
                        ReviewTiming.POST_ENACTMENT,
                        DocketControl.LEAVE_TO_APPEAL,
                        CostProfileKey.SOUTH_AFRICAN_CONSTITUTIONAL_COURT,
                        0.00, 0.74, 0.42, 0.72, 0.60, 0.72, 0.64
                )),
                entry("uk-supreme-court", systemConfig(
                        "UK Supreme Court declaration model",
                        AppointmentMethod.MERIT_SORTITION,
                        12,
                        TermLimit.LIFE_TENURE,
                        RemovalStandard.IMPEACHMENT_ONLY,
                        RecusalRule.MANDATORY_CONFLICT,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.DELAYED_MAJORITY_OVERRIDE,
                        ReviewArchetype.DECLARATION_ONLY_PARLIAMENTARY,
                        ReviewTiming.POST_ENACTMENT,
                        DocketControl.LEAVE_TO_APPEAL,
                        CostProfileKey.UK_SUPREME_COURT,
                        0.00, 0.62, 0.52, 0.74, 0.66, 0.54, 0.70
                )),
                entry("india-supreme-court", systemConfig(
                        "India Supreme Court high-volume hybrid",
                        AppointmentMethod.MERIT_SORTITION,
                        34,
                        TermLimit.LIFE_TENURE,
                        RemovalStandard.IMPEACHMENT_ONLY,
                        RecusalRule.MANDATORY_CONFLICT,
                        DocketProcedure.MERITS_FOLLOW_UP,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.PANEL_EN_BANC,
                        LegislativeOverrideRule.NONE,
                        ReviewArchetype.MIXED_ABSTRACT_CONCRETE,
                        ReviewTiming.POST_ENACTMENT,
                        DocketControl.MANDATORY_WITH_FILTERS,
                        CostProfileKey.INDIA_SUPREME_COURT,
                        0.04, 0.72, 0.36, 0.58, 0.48, 0.70, 0.50
                )),
                entry("brazil-stf", systemConfig(
                        "Brazil STF abstract and concrete review",
                        AppointmentMethod.PRESIDENTIAL_SENATE,
                        11,
                        TermLimit.LIFE_TENURE,
                        RemovalStandard.IMPEACHMENT_ONLY,
                        RecusalRule.MANDATORY_CONFLICT,
                        DocketProcedure.FULL_COURT_EMERGENCY,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.NONE,
                        ReviewArchetype.MIXED_ABSTRACT_CONCRETE,
                        ReviewTiming.MIXED_TIMING,
                        DocketControl.MANDATORY_WITH_FILTERS,
                        CostProfileKey.BRAZIL_STF,
                        0.08, 0.70, 0.34, 0.66, 0.52, 0.66, 0.52
                )),
                entry("echr-treaty-court", systemConfig(
                        "European Court of Human Rights treaty court",
                        AppointmentMethod.SUPERMAJORITY_COMMISSION,
                        46,
                        TermLimit.NONRENEWABLE_18_YEAR,
                        RemovalStandard.MISCONDUCT_COMMISSION,
                        RecusalRule.STRICT_TRANSPARENCY,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.PANEL_EN_BANC,
                        LegislativeOverrideRule.NONE,
                        ReviewArchetype.SUPRANATIONAL_TREATY,
                        ReviewTiming.POST_ENACTMENT,
                        DocketControl.COMPLAINT_ADMISSIBILITY,
                        CostProfileKey.ECHR,
                        0.00, 0.78, 0.30, 0.82, 0.68, 0.76, 0.62
                )),
                entry("cjeu-court-of-justice", systemConfig(
                        "Court of Justice of the European Union",
                        AppointmentMethod.SUPERMAJORITY_COMMISSION,
                        27,
                        TermLimit.SHORT_RENEWABLE,
                        RemovalStandard.MISCONDUCT_COMMISSION,
                        RecusalRule.STRICT_TRANSPARENCY,
                        DocketProcedure.REASONED_EMERGENCY_PANEL,
                        VotingThreshold.SIMPLE_MAJORITY,
                        ReviewStructure.FULL_COURT,
                        LegislativeOverrideRule.NONE,
                        ReviewArchetype.SUPRANATIONAL_TREATY,
                        ReviewTiming.MIXED_TIMING,
                        DocketControl.REFERRAL_GATED,
                        CostProfileKey.CJEU,
                        0.00, 0.72, 0.42, 0.78, 0.72, 0.62, 0.66
                ))
        );
    }

    private static ScenarioEntry entry(String key, DesignConfiguration configuration) {
        Scenario scenario = new ConfiguredScenario(key, configuration);
        return new ScenarioEntry(key, scenario);
    }

    private static DesignConfiguration config(
            String label,
            AppointmentMethod appointmentMethod,
            int courtSize,
            TermLimit termLimit,
            RemovalStandard removalStandard,
            RecusalRule recusalRule,
            DocketProcedure docketProcedure,
            VotingThreshold votingThreshold,
            ReviewStructure reviewStructure,
            LegislativeOverrideRule overrideRule,
            double appointmentSkew,
            double independence,
            double accountability,
            double transparency,
            double coalitionNorm,
            double rightsPriority,
            double stabilityPreference
    ) {
        return new DesignConfiguration(
                label,
                appointmentMethod,
                courtSize,
                termLimit,
                removalStandard,
                recusalRule,
                docketProcedure,
                votingThreshold,
                reviewStructure,
                overrideRule,
                appointmentSkew,
                independence,
                accountability,
                transparency,
                coalitionNorm,
                rightsPriority,
                stabilityPreference
        );
    }

    private static DesignConfiguration systemConfig(
            String label,
            AppointmentMethod appointmentMethod,
            int courtSize,
            TermLimit termLimit,
            RemovalStandard removalStandard,
            RecusalRule recusalRule,
            DocketProcedure docketProcedure,
            VotingThreshold votingThreshold,
            ReviewStructure reviewStructure,
            LegislativeOverrideRule overrideRule,
            ReviewArchetype reviewArchetype,
            ReviewTiming reviewTiming,
            DocketControl docketControl,
            CostProfileKey costProfileKey,
            double appointmentSkew,
            double independence,
            double accountability,
            double transparency,
            double coalitionNorm,
            double rightsPriority,
            double stabilityPreference
    ) {
        return new DesignConfiguration(
                label,
                appointmentMethod,
                courtSize,
                termLimit,
                removalStandard,
                recusalRule,
                docketProcedure,
                votingThreshold,
                reviewStructure,
                overrideRule,
                reviewArchetype,
                reviewTiming,
                docketControl,
                costProfileKey,
                appointmentSkew,
                independence,
                accountability,
                transparency,
                coalitionNorm,
                rightsPriority,
                stabilityPreference
        );
    }

    private record ScenarioEntry(String key, Scenario scenario) {
    }

    private record ConfiguredScenario(String key, DesignConfiguration configuration) implements Scenario {
        @Override
        public String name() {
            return configuration.label();
        }

        @Override
        public courtsim.institution.ReviewProcess buildProcess(CourtWorld world, Random random, int reviewPeriod) {
            return new ConstitutionalReviewProcess(
                    configuration,
                    world.spec(),
                    CourtFactory.create(configuration, world.spec(), random, reviewPeriod),
                    configuration.periodTurnoverRate()
            );
        }
    }
}
