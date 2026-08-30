package courtsim.experiment;


import courtsim.model.DoctrineArea;
import courtsim.simulation.ScenarioReport;
import courtsim.simulation.SegmentReport;
import courtsim.util.Values;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


final class CampaignCalibrationEvaluator
{
	private static final Path DEFAULT_CALIBRATION_TARGETS = Path.of("config/calibration-targets.csv");
	private static final Path CALIBRATION_TARGET_DIR = Path.of("config/calibration");
	private static final Map<String, String> CALIBRATION_PROFILE_SCENARIOS = Map.ofEntries(
			Map.entry("scdb-postwar-merits-1946-2024", "us-supreme-court-benchmark"),
			Map.entry("scdb-modern-merits-2000-2024", "us-supreme-court-benchmark"),
			Map.entry("scotus-emergency-2024-2025", "us-supreme-court-benchmark"),
			Map.entry("gallup-court-confidence-2024", "us-supreme-court-benchmark"),
			Map.entry("germany-bverfg-2024", "german-constitutional-court"),
			Map.entry("france-conseil-qpc", "french-constitutional-council"),
			Map.entry("canada-charter-dialogue-1982-2007", "canadian-supreme-court"),
			Map.entry("canada-scc-recent", "canadian-supreme-court"),
			Map.entry("canada-scc-2024", "canadian-supreme-court"),
			Map.entry("south-africa-constcourt-recent", "south-african-constitutional-court"),
			Map.entry("uk-supreme-court-2024-2025", "uk-supreme-court"),
			Map.entry("uk-human-rights-doi-2025", "uk-supreme-court"),
			Map.entry("echr-2024", "echr-treaty-court"),
			Map.entry("cjeu-2024", "cjeu-court-of-justice")
	);
	
	private static double weightedAverage(List<CampaignRow> rows, MetricReader reader) {
		int totalCases = rows.stream().mapToInt(row -> row.report().totalCases()).sum();
		if (totalCases == 0) {
			return 0.0;
		}
		double sum = 0.0;
		for (CampaignRow row : rows) {
			sum += reader.value(row.report()) * row.report().totalCases();
		}
		return sum / totalCases;
	}
	
	private static double legitimacyTrustGradient(List<CampaignRow> rows) {
		double meanTrust = rows.stream().mapToDouble(row -> row.report().publicTrust()).average().orElse(0.0);
		double meanLegitimacy = rows.stream().mapToDouble(row -> row.report().legitimacy()).average().orElse(0.0);
		double covariance = 0.0;
		double variance = 0.0;
		for (CampaignRow row : rows) {
			double trustDelta = row.report().publicTrust() - meanTrust;
			covariance += trustDelta * (row.report().legitimacy() - meanLegitimacy);
			variance += trustDelta * trustDelta;
		}
		if (variance <= 0.000001) {
			return 0.0;
		}
		return covariance / variance;
	}
	
	private static List<String> parseCsvLine(String line) {
		List<String> values = new ArrayList<>();
		StringBuilder current = new StringBuilder();
		boolean quoted = false;
		for (int i = 0; i < line.length(); i++) {
			char character = line.charAt(i);
			if (character == '"') {
				if (quoted && i + 1 < line.length() && line.charAt(i + 1) == '"') {
					current.append('"');
					i++;
				} else {
					quoted = !quoted;
				}
			} else if (character == ',' && !quoted) {
				values.add(current.toString());
				current.setLength(0);
			} else {
				current.append(character);
			}
		}
		values.add(current.toString());
		return values;
	}
	
	private static String calibrationValue(List<String> row, Map<String, Integer> columns, String key, String defaultValue) {
		Integer index = columns.get(key);
		if (index == null || index >= row.size()) {
			return defaultValue;
		}
		String value = row.get(index).trim();
		return value.isEmpty() ? defaultValue : value;
	}
	
	private static String positional(List<String> row, int index) {
		if (index < 0 || index >= row.size()) {
			return "";
		}
		return row.get(index).trim();
	}
	
	private static double optionalDouble(String value) {
		if (value == null || value.isBlank()) {
			return Double.NaN;
		}
		return Double.parseDouble(value.trim());
	}
	
	private static int optionalInt(String value) {
		if (value == null || value.isBlank()) {
			return 0;
		}
		return Integer.parseInt(value.trim());
	}
	
	List<CalibrationRow> evaluate(List<CampaignRow> rows) throws IOException {
		Map<String, Map<String, CalibrationObservation>> observedByProfile = new LinkedHashMap<>();
		observedByProfile.put("*", observedValues(rows));
		List<CalibrationRow> calibrationRows = new ArrayList<>();
		for (CalibrationTarget target : targets()) {
			Map<String, CalibrationObservation> observed = observedByProfile.computeIfAbsent(
					target.profileKey(),
					ignored -> observedValues(profileRows(rows, target.profileKey()))
			);
			CalibrationObservation observation = observed.getOrDefault(target.key(), new CalibrationObservation(0.0, 0));
			double value = observation.value();
			boolean within = value >= target.lowerBound() && value <= target.upperBound();
			double gap = within ? 0.0 : Math.min(Math.abs(value - target.lowerBound()), Math.abs(value - target.upperBound()));
			calibrationRows.add(new CalibrationRow(target, value, observation.sampleSize(), within, gap));
		}
		return List.copyOf(calibrationRows);
	}
	
	private List<CampaignRow> profileRows(List<CampaignRow> rows, String profileKey) {
		String scenarioKey = CALIBRATION_PROFILE_SCENARIOS.get(profileKey);
		if (scenarioKey == null) {
			return rows;
		}
		List<CampaignRow> filtered = rows.stream()
		                                 .filter(row -> row.report().scenarioKey().equals(scenarioKey))
		                                 .toList();
		return filtered.isEmpty() ? rows : filtered;
	}
	
	private Map<String, CalibrationObservation> observedValues(List<CampaignRow> rows) {
		Map<String, CalibrationObservation> observed = new LinkedHashMap<>();
		int totalCases = rows.stream().mapToInt(row -> row.report().totalCases()).sum();
		for (DoctrineArea doctrineArea : DoctrineArea.values()) {
			int doctrineCases = rows.stream()
			                        .flatMap(row -> row.report().doctrineReports().stream())
			                        .filter(segment -> segment.segmentKey().equals(doctrineArea.name().toLowerCase()))
			                        .mapToInt(SegmentReport::totalCases)
			                        .sum();
			observed.put("doctrine_mix." + doctrineArea.name().toLowerCase(), new CalibrationObservation(Values.ratio(doctrineCases, totalCases), totalCases));
		}
		int emergencyOrders = rows.stream().mapToInt(row -> row.report().emergencyOrders()).sum();
		int emergencyReliefs = rows.stream().mapToInt(row -> row.report().emergencyReliefs()).sum();
		int intakeFilings = rows.stream().mapToInt(row -> row.report().intakeFilings()).sum();
		int reviewedCases = rows.stream().mapToInt(row -> row.report().reviewedCases()).sum();
		int meritsReviews = rows.stream().mapToInt(row -> row.report().meritsReviews()).sum();
		int meritsInvalidations = rows.stream().mapToInt(row -> row.report().meritsInvalidations()).sum();
		observed.put("review_rate", new CalibrationObservation(Values.ratio(reviewedCases, totalCases), totalCases));
		observed.put("emergency_relief_rate", new CalibrationObservation(Values.ratio(emergencyReliefs, emergencyOrders), emergencyOrders));
		observed.put("merits_invalidation_rate", new CalibrationObservation(Values.ratio(meritsInvalidations, meritsReviews), meritsReviews));
		observed.put("intake_acceptance_rate", new CalibrationObservation(Values.ratio(reviewedCases, intakeFilings), intakeFilings));
		observed.put("case_selection_access", new CalibrationObservation(weightedAverage(rows, ScenarioReport::caseSelectionAccess), totalCases));
		observed.put("emergency_reason_giving_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::emergencyReasonGivingRate), emergencyOrders));
		observed.put("emergency_vote_disclosure_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::emergencyVoteDisclosureRate), emergencyOrders));
		observed.put("emergency_public_disagreement_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::emergencyPublicDisagreementRate), emergencyOrders));
		observed.put("government_emergency_win_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::governmentEmergencyWinRate), emergencyOrders));
		observed.put("merits_follow_up_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::meritsFollowUpRate), emergencyOrders));
		observed.put("override_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::overrideRate), totalCases));
		observed.put("weak_form_declaration_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::weakFormDeclarationRate), totalCases));
		observed.put("suspended_declaration_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::suspendedDeclarationRate), totalCases));
		observed.put("legislative_response_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::legislativeResponseRate), totalCases));
		observed.put("invalidation_legislative_response_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::invalidationLegislativeResponseRate), totalCases));
		observed.put("legislative_response_delay", new CalibrationObservation(weightedAverage(rows, ScenarioReport::averageLegislativeResponseDelay), totalCases));
		observed.put("timely_legislative_response_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::timelyLegislativeResponseRate), totalCases));
		observed.put("legislative_response_credibility", new CalibrationObservation(weightedAverage(rows, ScenarioReport::legislativeResponseCredibility), totalCases));
		observed.put("pre_enactment_review_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::preEnactmentReviewRate), totalCases));
		observed.put("abstract_review_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::abstractReviewRate), totalCases));
		observed.put("preliminary_reference_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::preliminaryReferenceRate), totalCases));
		observed.put("appeal_route_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::appealRouteRate), totalCases));
		observed.put("direct_action_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::directActionRate), totalCases));
		observed.put("rights_impact_statement_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::rightsImpactStatementRate), totalCases));
		observed.put("ombudsman_trigger_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::ombudsmanTriggerRate), totalCases));
		observed.put("public_defender_participation_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::publicDefenderParticipationRate), totalCases));
		observed.put("compliance_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::complianceRate), totalCases));
		observed.put("legislative_reenactment_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::legislativeReenactmentRate), totalCases));
		observed.put("invalidation_legislative_reenactment_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::invalidationLegislativeReenactmentRate), totalCases));
		observed.put("public_trust", new CalibrationObservation(weightedAverage(rows, ScenarioReport::publicTrust), totalCases));
		observed.put("direct_court_cost", new CalibrationObservation(weightedAverage(rows, ScenarioReport::directCourtCost), totalCases));
		observed.put("upstream_screening_cost", new CalibrationObservation(weightedAverage(rows, ScenarioReport::upstreamScreeningCost), totalCases));
		observed.put("capacity_strain_cost", new CalibrationObservation(weightedAverage(rows, ScenarioReport::capacityStrainCost), totalCases));
		observed.put("total_institutional_cost", new CalibrationObservation(weightedAverage(rows, ScenarioReport::totalInstitutionalCost), totalCases));
		observed.put("legitimacy_trust_gradient", new CalibrationObservation(legitimacyTrustGradient(rows), rows.size()));
		return observed;
	}
	
	private List<CalibrationTarget> targets() throws IOException {
		List<CalibrationTarget> targets = new ArrayList<>();
		for (Path targetFile : targetFiles()) {
			targets.addAll(targets(targetFile));
		}
		return targets.isEmpty() ? defaultTargets("built-in-defaults") : List.copyOf(targets);
	}
	
	private List<Path> targetFiles() throws IOException {
		if (Files.isDirectory(CALIBRATION_TARGET_DIR)) {
			try (var stream = Files.list(CALIBRATION_TARGET_DIR)) {
				List<Path> files = stream
						.filter(path -> Files.isRegularFile(path) && path.getFileName().toString().endsWith(".csv"))
						.sorted()
						.toList();
				if (!files.isEmpty()) {
					return files;
				}
			}
		}
		if (Files.exists(DEFAULT_CALIBRATION_TARGETS)) {
			return List.of(DEFAULT_CALIBRATION_TARGETS);
		}
		return List.of();
	}
	
	private List<CalibrationTarget> targets(Path targetFile) throws IOException {
		List<CalibrationTarget> targets = new ArrayList<>();
		List<String> lines = Files.readAllLines(targetFile);
		if (lines.isEmpty()) {
			return targets;
		}
		List<String> header = parseCsvLine(lines.get(0));
		Map<String, Integer> columns = new LinkedHashMap<>();
		for (int i = 0; i < header.size(); i++) {
			columns.put(header.get(i), i);
		}
		for (int i = 1; i < lines.size(); i++) {
			String line = lines.get(i).trim();
			if (line.isEmpty() || line.startsWith("#")) {
				continue;
			}
			List<String> parts = parseCsvLine(line);
			targets.add(new CalibrationTarget(
					calibrationValue(parts, columns, "profileKey", "default"),
					calibrationValue(parts, columns, "court", "unspecified court"),
					calibrationValue(parts, columns, "timePeriod", "unspecified period"),
					calibrationValue(parts, columns, "targetKey", positional(parts, 0)),
					calibrationValue(parts, columns, "label", positional(parts, 1)),
					Double.parseDouble(calibrationValue(parts, columns, "lowerBound", positional(parts, 2))),
					Double.parseDouble(calibrationValue(parts, columns, "upperBound", positional(parts, 3))),
					optionalDouble(calibrationValue(parts, columns, "observedValue", "")),
					optionalInt(calibrationValue(parts, columns, "n", "0")),
					calibrationValue(parts, columns, "unit", "share"),
					calibrationValue(parts, columns, "method", "documented-range"),
					calibrationValue(parts, columns, "reliability", "medium"),
					Boolean.parseBoolean(calibrationValue(parts, columns, "useForValidation", "true")),
					calibrationValue(parts, columns, "note", positional(parts, 4)),
					calibrationValue(parts, columns, "sourceName", targetFile.getFileName().toString()),
					calibrationValue(parts, columns, "sourceUrl", ""),
					targetFile.toString()
			));
		}
		return targets;
	}
	
	private List<CalibrationTarget> defaultTargets(String source) {
		String sourceUrl = "https://scdb.la.psu.edu/data/2025-release-01/";
		return List.of(
				new CalibrationTarget("fallback-scdb-modern", "U.S. Supreme Court", "2000-2024 terms", "doctrine_mix.speech", "Speech docket share", 0.039, 0.080, 0.060, 0, "share", "SCDB issue-area proxy", "high", true, "SCDB issueArea 3 share in 2000-2024 case-centered data.", source, sourceUrl, source),
				new CalibrationTarget("fallback-scdb-modern", "U.S. Supreme Court", "2000-2024 terms", "doctrine_mix.equality", "Civil-rights and privacy docket share", 0.137, 0.191, 0.164, 0, "share", "SCDB issue-area proxy", "high", true, "SCDB issueArea 2 and 5 less election-law issue subset.", source, sourceUrl, source),
				new CalibrationTarget("fallback-scdb-modern", "U.S. Supreme Court", "2000-2024 terms", "doctrine_mix.criminal_procedure", "Criminal procedure docket share", 0.230, 0.289, 0.260, 0, "share", "SCDB issue-area proxy", "high", true, "SCDB issueArea 1 share in 2000-2024 case-centered data.", source, sourceUrl, source),
				new CalibrationTarget("fallback-scdb-modern", "U.S. Supreme Court", "2000-2024 terms", "doctrine_mix.federalism", "Federalism docket share", 0.037, 0.078, 0.058, 0, "share", "SCDB issue-area proxy", "high", true, "SCDB issueArea 10 and 11 share in 2000-2024 case-centered data.", source, sourceUrl, source)
		);
	}
	
	@FunctionalInterface
	private interface MetricReader
	{
		double value(ScenarioReport report);
	}
}
