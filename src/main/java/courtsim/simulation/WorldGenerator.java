package courtsim.simulation;

import courtsim.model.CaseFile;
import courtsim.model.CaseType;
import courtsim.model.CourtWorld;
import courtsim.model.LegislativeSignal;
import courtsim.util.Values;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class WorldGenerator {
    public CourtWorld generate(WorldSpec spec, long seed, List<LegislativeSignal> importedSignals) {
        Random random = new Random(seed);
        List<CaseFile> docket = new ArrayList<>();
        for (int i = 0; i < spec.caseCount(); i++) {
            if (!importedSignals.isEmpty()) {
                docket.add(fromLegislativeSignal(spec, importedSignals.get(i % importedSignals.size()), i, random));
            } else {
                docket.add(syntheticCase(spec, i, random));
            }
        }
        return new CourtWorld(spec, List.copyOf(docket));
    }

    private CaseFile syntheticCase(WorldSpec spec, int index, Random random) {
        double policyPosition = Values.signedClamp(random.nextGaussian() * (0.32 + spec.partisanPressure() * 0.38));
        double rightsThreat = Values.clamp01(spec.rightsThreatRate() * 0.58 + random.nextDouble() * 0.42 + Math.abs(policyPosition) * 0.10 - 0.05);
        double publicSupport = Values.clamp01(0.52 + random.nextGaussian() * 0.20 - rightsThreat * 0.16);
        double mandate = Values.clamp01(publicSupport * 0.62 + (1.0 - spec.legislativeConflict()) * 0.20 + random.nextDouble() * 0.16);
        double urgency = Values.clamp01(spec.emergencyPressure() * 0.60 + random.nextDouble() * 0.40 + Math.max(0.0, rightsThreat - 0.62) * 0.14);
        double ambiguity = Values.clamp01(0.24 + random.nextDouble() * 0.46 + spec.legislativeConflict() * 0.16);
        double salience = Values.clamp01(rightsThreat * 0.38 + Math.abs(policyPosition) * 0.22 + random.nextDouble() * 0.38);
        double lowerConflict = Values.clamp01(random.nextDouble() * 0.44 + ambiguity * 0.24 + spec.legislativeConflict() * 0.20);
        double executivePressure = Values.clamp01(spec.partisanPressure() * 0.20 + urgency * 0.18 + random.nextDouble() * 0.22);
        double conflictRisk = Values.clamp01(Math.abs(policyPosition) * 0.20 + executivePressure * 0.18 + random.nextDouble() * 0.22);
        CaseType type = typeFor(rightsThreat, urgency, salience, lowerConflict, random);
        return new CaseFile(
                "synthetic-" + (index + 1),
                type,
                policyPosition,
                rightsThreat,
                publicSupport,
                mandate,
                urgency,
                ambiguity,
                salience,
                lowerConflict,
                executivePressure,
                conflictRisk,
                spec.publicTrust(),
                "synthetic"
        );
    }

    private CaseFile fromLegislativeSignal(WorldSpec spec, LegislativeSignal signal, int index, Random random) {
        double sign = Values.stableSigned(signal.scenarioKey() + ":" + signal.caseKey());
        double policyPosition = Values.signedClamp(
                sign * Values.clamp01(signal.policyShift() * 0.80 + signal.proposerGain() * 0.45 + spec.partisanPressure() * 0.20)
        );
        double rightsThreat = Values.clamp01(
                spec.rightsThreatRate() * 0.22
                        + (1.0 - signal.welfare()) * 0.24
                        + signal.lowSupportPassage() * 0.16
                        + signal.weakPublicMandatePassage() * 0.17
                        + signal.minorityHarm() * 0.10
                        + signal.concentratedHarmPassage() * 0.08
                        + signal.lobbyCapture() * 0.08
                        + random.nextDouble() * 0.06
        );
        double publicSupport = Values.clamp01(
                signal.averageSupport() * 0.55
                        + signal.publicAlignment() * 0.22
                        + signal.legitimacy() * 0.14
                        + random.nextGaussian() * 0.04
        );
        double mandate = Values.clamp01(
                signal.averageSupport() * 0.42
                        + signal.welfare() * 0.22
                        + signal.publicAlignment() * 0.22
                        + signal.legitimacy() * 0.14
        );
        double urgency = Values.clamp01(
                spec.emergencyPressure() * 0.25
                        + signal.fastLaneRate() * 0.26
                        + signal.highRiskLaneRate() * 0.24
                        + signal.challengeRate() * 0.14
                        + random.nextDouble() * 0.16
        );
        double ambiguity = Values.clamp01(
                0.22
                        + signal.publicPreferenceDistortion() * 0.30
                        + signal.statusQuoVolatility() * 0.26
                        + signal.reversalRate() * 0.22
                        + random.nextDouble() * 0.12
        );
        double salience = Values.clamp01(
                rightsThreat * 0.34
                        + signal.policyShift() * 0.22
                        + signal.statusQuoVolatility() * 0.16
                        + signal.weakPublicMandatePassage() * 0.12
                        + random.nextDouble() * 0.16
        );
        double lowerConflict = Values.clamp01(
                signal.reversalRate() * 0.42
                        + signal.statusQuoVolatility() * 0.22
                        + spec.legislativeConflict() * 0.16
                        + random.nextDouble() * 0.16
        );
        double executivePressure = Values.clamp01(
                signal.lobbyCapture() * 0.26
                        + signal.proposerGain() * 0.20
                        + spec.partisanPressure() * 0.18
                        + random.nextDouble() * 0.16
        );
        double conflictRisk = Values.clamp01(
                signal.lobbyCapture() * 0.24
                        + Math.abs(policyPosition) * 0.18
                        + executivePressure * 0.14
                        + random.nextDouble() * 0.12
        );
        CaseType type = typeFor(rightsThreat, urgency, salience, lowerConflict, random);
        return new CaseFile(
                "leg-" + (index + 1) + "-" + signal.scenarioKey(),
                type,
                policyPosition,
                rightsThreat,
                publicSupport,
                mandate,
                urgency,
                ambiguity,
                salience,
                lowerConflict,
                executivePressure,
                conflictRisk,
                spec.publicTrust(),
                signal.scenarioKey()
        );
    }

    private CaseType typeFor(double rightsThreat, double urgency, double salience, double lowerConflict, Random random) {
        if (urgency > 0.68 && random.nextDouble() < 0.72) {
            return CaseType.EMERGENCY;
        }
        if (rightsThreat > 0.58 && random.nextDouble() < 0.65) {
            return CaseType.RIGHTS_CLAIM;
        }
        if (salience + lowerConflict > 1.16 && random.nextDouble() < 0.62) {
            return CaseType.STRUCTURAL_CONFLICT;
        }
        return CaseType.ORDINARY;
    }
}

