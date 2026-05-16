package courtsim.simulation;


import courtsim.util.Values;


public record WorldSpec(
		int caseCount,
		int reviewPeriods,
		double appointmentPolarization,
		double rightsThreatRate,
		double emergencyPressure,
		double legislativeConflict,
		double publicTrust,
		double partisanPressure,
		double partyFragmentation,
		double governmentControl,
		double electoralTimePressure,
		double civilSocietyCapacity,
		double implementationCapacity,
		double legalTraditionCompatibility
)
{
	public WorldSpec {
		if (caseCount <= 0) {
			throw new IllegalArgumentException("caseCount must be positive");
		}
		if (reviewPeriods <= 0) {
			throw new IllegalArgumentException("reviewPeriods must be positive");
		}
		appointmentPolarization = Values.clamp01(appointmentPolarization);
		rightsThreatRate = Values.clamp01(rightsThreatRate);
		emergencyPressure = Values.clamp01(emergencyPressure);
		legislativeConflict = Values.clamp01(legislativeConflict);
		publicTrust = Values.clamp01(publicTrust);
		partisanPressure = Values.clamp01(partisanPressure);
		partyFragmentation = Values.clamp01(partyFragmentation);
		governmentControl = Values.clamp01(governmentControl);
		electoralTimePressure = Values.clamp01(electoralTimePressure);
		civilSocietyCapacity = Values.clamp01(civilSocietyCapacity);
		implementationCapacity = Values.clamp01(implementationCapacity);
		legalTraditionCompatibility = Values.clamp01(legalTraditionCompatibility);
	}
	
	public static WorldSpec baseline(int caseCount) {
		return new WorldSpec(caseCount, 4, 0.62, 0.36, 0.28, 0.42, 0.58, 0.55, 0.46, 0.54, 0.42, 0.58, 0.62, 0.68);
	}
	
	public WorldSpec withCaseCount(int newCaseCount) {
		return new WorldSpec(
				newCaseCount,
				reviewPeriods,
				appointmentPolarization,
				rightsThreatRate,
				emergencyPressure,
				legislativeConflict,
				publicTrust,
				partisanPressure,
				partyFragmentation,
				governmentControl,
				electoralTimePressure,
				civilSocietyCapacity,
				implementationCapacity,
				legalTraditionCompatibility
		);
	}
	
	public WorldSpec withReviewPeriods(int newReviewPeriods) {
		return new WorldSpec(
				caseCount,
				newReviewPeriods,
				appointmentPolarization,
				rightsThreatRate,
				emergencyPressure,
				legislativeConflict,
				publicTrust,
				partisanPressure,
				partyFragmentation,
				governmentControl,
				electoralTimePressure,
				civilSocietyCapacity,
				implementationCapacity,
				legalTraditionCompatibility
		);
	}
	
	public WorldSpec withAppointmentPolarization(double value) {
		return new WorldSpec(caseCount, reviewPeriods, value, rightsThreatRate, emergencyPressure, legislativeConflict, publicTrust, partisanPressure, partyFragmentation, governmentControl, electoralTimePressure, civilSocietyCapacity, implementationCapacity, legalTraditionCompatibility);
	}
	
	public WorldSpec withRightsThreatRate(double value) {
		return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, value, emergencyPressure, legislativeConflict, publicTrust, partisanPressure, partyFragmentation, governmentControl, electoralTimePressure, civilSocietyCapacity, implementationCapacity, legalTraditionCompatibility);
	}
	
	public WorldSpec withEmergencyPressure(double value) {
		return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, value, legislativeConflict, publicTrust, partisanPressure, partyFragmentation, governmentControl, electoralTimePressure, civilSocietyCapacity, implementationCapacity, legalTraditionCompatibility);
	}
	
	public WorldSpec withLegislativeConflict(double value) {
		return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, emergencyPressure, value, publicTrust, partisanPressure, partyFragmentation, governmentControl, electoralTimePressure, civilSocietyCapacity, implementationCapacity, legalTraditionCompatibility);
	}
	
	public WorldSpec withPublicTrust(double value) {
		return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, emergencyPressure, legislativeConflict, value, partisanPressure, partyFragmentation, governmentControl, electoralTimePressure, civilSocietyCapacity, implementationCapacity, legalTraditionCompatibility);
	}
	
	public WorldSpec withPartisanPressure(double value) {
		return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, emergencyPressure, legislativeConflict, publicTrust, value, partyFragmentation, governmentControl, electoralTimePressure, civilSocietyCapacity, implementationCapacity, legalTraditionCompatibility);
	}
	
	public WorldSpec withPartyFragmentation(double value) {
		return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, emergencyPressure, legislativeConflict, publicTrust, partisanPressure, value, governmentControl, electoralTimePressure, civilSocietyCapacity, implementationCapacity, legalTraditionCompatibility);
	}
	
	public WorldSpec withGovernmentControl(double value) {
		return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, emergencyPressure, legislativeConflict, publicTrust, partisanPressure, partyFragmentation, value, electoralTimePressure, civilSocietyCapacity, implementationCapacity, legalTraditionCompatibility);
	}
	
	public WorldSpec withElectoralTimePressure(double value) {
		return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, emergencyPressure, legislativeConflict, publicTrust, partisanPressure, partyFragmentation, governmentControl, value, civilSocietyCapacity, implementationCapacity, legalTraditionCompatibility);
	}
	
	public WorldSpec withCivilSocietyCapacity(double value) {
		return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, emergencyPressure, legislativeConflict, publicTrust, partisanPressure, partyFragmentation, governmentControl, electoralTimePressure, value, implementationCapacity, legalTraditionCompatibility);
	}
	
	public WorldSpec withImplementationCapacity(double value) {
		return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, emergencyPressure, legislativeConflict, publicTrust, partisanPressure, partyFragmentation, governmentControl, electoralTimePressure, civilSocietyCapacity, value, legalTraditionCompatibility);
	}
	
	public WorldSpec withLegalTraditionCompatibility(double value) {
		return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, emergencyPressure, legislativeConflict, publicTrust, partisanPressure, partyFragmentation, governmentControl, electoralTimePressure, civilSocietyCapacity, implementationCapacity, value);
	}
}
