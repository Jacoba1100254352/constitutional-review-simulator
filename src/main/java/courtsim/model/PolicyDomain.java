package courtsim.model;

import java.util.Locale;

public enum PolicyDomain {
    CIVIL_RIGHTS("civil-rights"),
    CRIMINAL_JUSTICE("criminal-justice"),
    GOVERNANCE("governance"),
    ELECTIONS("elections"),
    EMERGENCY_SECURITY("emergency-security"),
    ECONOMIC_REGULATION("economic-regulation"),
    ADMINISTRATION("administration");

    private final String key;

    PolicyDomain(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }

    public static PolicyDomain fromKey(String value) {
        if (value == null || value.isBlank()) {
            return GOVERNANCE;
        }
        String normalized = value.trim()
                .toLowerCase(Locale.ROOT)
                .replace('_', '-')
                .replace(' ', '-');
        for (PolicyDomain domain : values()) {
            if (domain.key.equals(normalized) || domain.name().toLowerCase(Locale.ROOT).replace('_', '-').equals(normalized)) {
                return domain;
            }
        }
        return GOVERNANCE;
    }
}
