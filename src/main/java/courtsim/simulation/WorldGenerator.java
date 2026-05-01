package courtsim.simulation;

import courtsim.model.CaseFile;
import courtsim.model.CaseType;
import courtsim.model.CourtWorld;
import courtsim.model.DoctrineArea;
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
        DoctrineArea doctrineArea = randomDoctrine(random);
        int reviewPeriod = reviewPeriod(spec, index);
        double policyPosition = Values.signedClamp(random.nextGaussian() * (0.32 + spec.partisanPressure() * 0.38));
        double rightsThreat = Values.clamp01((spec.rightsThreatRate() * 0.58 + random.nextDouble() * 0.42 + Math.abs(policyPosition) * 0.10 - 0.05)
                * doctrineArea.rightsWeight());
        double publicSupport = Values.clamp01(0.52 + random.nextGaussian() * 0.20 - rightsThreat * 0.16);
        double mandate = Values.clamp01(publicSupport * 0.62 + (1.0 - spec.legislativeConflict()) * 0.20 + random.nextDouble() * 0.16);
        double urgency = Values.clamp01((spec.emergencyPressure() * 0.60 + random.nextDouble() * 0.40 + Math.max(0.0, rightsThreat - 0.62) * 0.14)
                * emergencyDoctrineWeight(doctrineArea));
        double ambiguity = Values.clamp01((0.24 + random.nextDouble() * 0.46 + spec.legislativeConflict() * 0.16)
                * doctrineArea.ambiguityWeight());
        double salience = Values.clamp01((rightsThreat * 0.38 + Math.abs(policyPosition) * 0.22 + random.nextDouble() * 0.38)
                * doctrineArea.salienceWeight());
        double lowerPanelSkew = Values.signedClamp(random.nextGaussian() * (0.18 + spec.appointmentPolarization() * 0.28));
        boolean governmentWin = governmentWin(publicSupport, rightsThreat, lowerPanelSkew, random);
        double lowerConflict = Values.clamp01((random.nextDouble() * 0.44 + ambiguity * 0.24 + spec.legislativeConflict() * 0.20)
                * doctrineArea.conflictWeight());
        double certiorariPressure = certiorariPressure(rightsThreat, salience, lowerConflict, lowerPanelSkew, governmentWin);
        double timeToReview = timeToReview(urgency, lowerConflict, ambiguity, certiorariPressure, random);
        double executivePressure = Values.clamp01(spec.partisanPressure() * 0.20 + urgency * 0.18 + random.nextDouble() * 0.22);
        double conflictRisk = Values.clamp01(Math.abs(policyPosition) * 0.20 + executivePressure * 0.18 + random.nextDouble() * 0.22);
        CaseType type = typeFor(rightsThreat, urgency, salience, lowerConflict, random);
        return new CaseFile(
                "synthetic-" + (index + 1),
                type,
                doctrineArea,
                reviewPeriod,
                policyPosition,
                rightsThreat,
                publicSupport,
                mandate,
                urgency,
                ambiguity,
                salience,
                lowerConflict,
                lowerPanelSkew,
                certiorariPressure,
                timeToReview,
                governmentWin,
                executivePressure,
                conflictRisk,
                spec.publicTrust(),
                "synthetic"
        );
    }

    private CaseFile fromLegislativeSignal(WorldSpec spec, LegislativeSignal signal, int index, Random random) {
        DoctrineArea doctrineArea = importedDoctrine(signal, random);
        int reviewPeriod = reviewPeriod(spec, index);
        double sign = Values.stableSigned(signal.scenarioKey() + ":" + signal.caseKey());
        double policyPosition = Values.signedClamp(
                sign * Values.clamp01(signal.policyShift() * 0.80 + signal.proposerGain() * 0.45 + spec.partisanPressure() * 0.20)
        );
        double rightsThreat = Values.clamp01((
                spec.rightsThreatRate() * 0.22
                        + (1.0 - signal.welfare()) * 0.24
                        + signal.lowSupportPassage() * 0.16
                        + signal.weakPublicMandatePassage() * 0.17
                        + signal.minorityHarm() * 0.10
                        + signal.concentratedHarmPassage() * 0.08
                        + signal.lobbyCapture() * 0.08
                        + random.nextDouble() * 0.06
        ) * doctrineArea.rightsWeight());
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
        double urgency = Values.clamp01((
                spec.emergencyPressure() * 0.25
                        + signal.fastLaneRate() * 0.26
                        + signal.highRiskLaneRate() * 0.24
                        + signal.challengeRate() * 0.14
                        + random.nextDouble() * 0.16
        ) * emergencyDoctrineWeight(doctrineArea));
        double ambiguity = Values.clamp01((
                0.22
                        + signal.publicPreferenceDistortion() * 0.30
                        + signal.statusQuoVolatility() * 0.26
                        + signal.reversalRate() * 0.22
                        + random.nextDouble() * 0.12
        ) * doctrineArea.ambiguityWeight());
        double salience = Values.clamp01((
                rightsThreat * 0.34
                        + signal.policyShift() * 0.22
                        + signal.statusQuoVolatility() * 0.16
                        + signal.weakPublicMandatePassage() * 0.12
                        + random.nextDouble() * 0.16
        ) * doctrineArea.salienceWeight());
        double lowerPanelSkew = Values.signedClamp(
                sign * Values.clamp01(signal.lobbyCapture() * 0.26 + signal.proposerGain() * 0.18 + spec.partisanPressure() * 0.16)
                        + random.nextGaussian() * 0.08
        );
        boolean governmentWin = governmentWin(publicSupport, rightsThreat, lowerPanelSkew, random);
        double lowerConflict = Values.clamp01((
                signal.reversalRate() * 0.42
                        + signal.statusQuoVolatility() * 0.22
                        + spec.legislativeConflict() * 0.16
                        + random.nextDouble() * 0.16
        ) * doctrineArea.conflictWeight());
        double certiorariPressure = Values.clamp01(
                certiorariPressure(rightsThreat, salience, lowerConflict, lowerPanelSkew, governmentWin)
                        + signal.challengeRate() * 0.12
                        + signal.highRiskLaneRate() * 0.12
        );
        double timeToReview = timeToReview(urgency, lowerConflict, ambiguity, certiorariPressure, random);
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
                doctrineArea,
                reviewPeriod,
                policyPosition,
                rightsThreat,
                publicSupport,
                mandate,
                urgency,
                ambiguity,
                salience,
                lowerConflict,
                lowerPanelSkew,
                certiorariPressure,
                timeToReview,
                governmentWin,
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

    private static DoctrineArea randomDoctrine(Random random) {
        DoctrineArea[] areas = DoctrineArea.values();
        return areas[random.nextInt(areas.length)];
    }

    private static DoctrineArea importedDoctrine(LegislativeSignal signal, Random random) {
        if (signal.highRiskLaneRate() > 0.24 || signal.fastLaneRate() > 0.24) {
            return DoctrineArea.EMERGENCY_POWERS;
        }
        if (signal.minorityHarm() > 0.22 || signal.concentratedHarmPassage() > 0.20) {
            return DoctrineArea.EQUALITY;
        }
        if (signal.weakPublicMandatePassage() > 0.20 || signal.publicPreferenceDistortion() > 0.22) {
            return DoctrineArea.ELECTION_LAW;
        }
        if (signal.lobbyCapture() > 0.24) {
            return DoctrineArea.ADMINISTRATIVE_STATE;
        }
        return randomDoctrine(random);
    }

    private static int reviewPeriod(WorldSpec spec, int index) {
        int period = (int) (((long) index * spec.reviewPeriods()) / Math.max(spec.caseCount(), 1));
        return Math.min(Math.max(period, 0), spec.reviewPeriods() - 1);
    }

    private static boolean governmentWin(double publicSupport, double rightsThreat, double panelSkew, Random random) {
        double score = 0.44 + publicSupport * 0.22 - rightsThreat * 0.24 + panelSkew * 0.16 + random.nextGaussian() * 0.12;
        return score > 0.45;
    }

    private static double certiorariPressure(
            double rightsThreat,
            double salience,
            double lowerCourtConflict,
            double lowerPanelSkew,
            boolean governmentWin
    ) {
        double rightsTension = governmentWin ? rightsThreat * 0.22 : (1.0 - rightsThreat) * 0.06;
        return Values.clamp01(
                0.18
                        + rightsTension
                        + salience * 0.24
                        + lowerCourtConflict * 0.28
                        + Math.abs(lowerPanelSkew) * 0.12
        );
    }

    private static double timeToReview(
            double urgency,
            double lowerCourtConflict,
            double ambiguity,
            double certiorariPressure,
            Random random
    ) {
        return Values.clamp01(
                0.54
                        - urgency * 0.30
                        - certiorariPressure * 0.12
                        + lowerCourtConflict * 0.14
                        + ambiguity * 0.12
                        + random.nextGaussian() * 0.08
        );
    }

    private static double emergencyDoctrineWeight(DoctrineArea doctrineArea) {
        return doctrineArea == DoctrineArea.EMERGENCY_POWERS ? 1.32 : 1.0;
    }
}
