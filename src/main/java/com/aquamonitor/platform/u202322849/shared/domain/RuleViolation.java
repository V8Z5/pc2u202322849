package com.aquamonitor.platform.u202322849.shared.domain;


/**
 * Identifies a rejected domain value and its localized message key.
 * @author Marlon Packard Viza Quispe
 */
public class RuleViolation extends IllegalArgumentException {
    private final String key;

    public RuleViolation(String key, String explanation) {
        super(explanation);
        this.key = key;
    }

    public String key() { return key; }
}
