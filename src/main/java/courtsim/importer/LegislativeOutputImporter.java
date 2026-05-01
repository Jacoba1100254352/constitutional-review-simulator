package courtsim.importer;

import courtsim.model.LegislativeSignal;
import courtsim.util.Values;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class LegislativeOutputImporter {
    private LegislativeOutputImporter() {
    }

    public static List<LegislativeSignal> read(Path path) throws IOException {
        if (path == null) {
            return List.of();
        }
        List<String> lines = Files.readAllLines(path);
        if (lines.isEmpty()) {
            return List.of();
        }
        List<String> header = parseCsvLine(lines.get(0));
        Map<String, Integer> columns = new LinkedHashMap<>();
        for (int i = 0; i < header.size(); i++) {
            columns.put(header.get(i), i);
        }

        List<LegislativeSignal> signals = new ArrayList<>();
        for (int lineIndex = 1; lineIndex < lines.size(); lineIndex++) {
            String line = lines.get(lineIndex).trim();
            if (line.isEmpty()) {
                continue;
            }
            List<String> row = parseCsvLine(line);
            String caseKey = value(row, columns, "caseKey", "row-" + lineIndex);
            String scenarioKey = value(row, columns, "scenarioKey", "unknown-scenario");
            String scenarioName = value(row, columns, "scenario", scenarioKey);
            signals.add(new LegislativeSignal(
                    caseKey,
                    scenarioKey,
                    scenarioName,
                    number(row, columns, "avgSupport", 0.55),
                    number(row, columns, "welfare", 0.55),
                    number(row, columns, "legitimacy", 0.55),
                    number(row, columns, "lowSupport", 0.10),
                    number(row, columns, "weakPublicMandatePassage", 0.12),
                    number(row, columns, "minorityHarm", 0.12),
                    number(row, columns, "concentratedHarmPassage", 0.10),
                    number(row, columns, "lobbyCapture", 0.18),
                    number(row, columns, "publicAlignment", 0.55),
                    number(row, columns, "publicPreferenceDistortion", 0.16),
                    number(row, columns, "policyShift", 0.12),
                    number(row, columns, "proposerGain", 0.12),
                    number(row, columns, "reversalRate", 0.05),
                    number(row, columns, "statusQuoVolatility", 0.10),
                    number(row, columns, "fastLaneRate", 0.08),
                    number(row, columns, "highRiskLaneRate", 0.08),
                    number(row, columns, "challengeRate", 0.08)
            ));
        }
        return List.copyOf(signals);
    }

    private static String value(List<String> row, Map<String, Integer> columns, String key, String defaultValue) {
        Integer index = columns.get(key);
        if (index == null || index >= row.size()) {
            return defaultValue;
        }
        String value = row.get(index).trim();
        return value.isEmpty() ? defaultValue : value;
    }

    private static double number(List<String> row, Map<String, Integer> columns, String key, double defaultValue) {
        String text = value(row, columns, key, "");
        if (text.isEmpty()) {
            return defaultValue;
        }
        try {
            return Values.clamp01(Double.parseDouble(text));
        } catch (NumberFormatException exception) {
            return defaultValue;
        }
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

    public static String describeImport(List<LegislativeSignal> signals) {
        if (signals.isEmpty()) {
            return "synthetic docket";
        }
        long scenarioCount = signals.stream().map(LegislativeSignal::scenarioKey).distinct().count();
        return String.format(Locale.ROOT, "%d imported legislative rows across %d scenarios", signals.size(), scenarioCount);
    }
}

