package com.aquamonitor.platform.u202322849.monitoring.domain.model.valueobjects;

import com.aquamonitor.platform.u202322849.shared.domain.RuleViolation;

/**
 * Represents the validated sampling plan code.
 * @author Marlon Packard Viza Quispe
 */
public record PlanCode(String code) {
    public PlanCode {
        if (code == null || code.isBlank()) throw new RuleViolation("code", "Plan code is required.");
    }
}
