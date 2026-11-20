package com.aquamonitor.platform.u202322849.monitoring.domain.model.valueobjects;

import com.aquamonitor.platform.u202322849.shared.domain.RuleViolation;

/**
 * Represents the validated water sample volume.
 * @author Marlon Packard Viza Quispe
 */
public record SampleVolume(Integer quantity, String unit) {
    public SampleVolume {
        if (quantity == null || quantity <= 0) throw new RuleViolation("quantity", "Volume must be a positive integer.");
        if (unit == null || unit.isBlank()) throw new RuleViolation("unit", "Volume unit is required.");
    }
    /**
     * Adds an integer amount without modifying this volume.
     * @param additionalVolume positive amount in the same unit
     * @return a new volume containing the sum
     */
    public SampleVolume addVolume(Integer additionalVolume) {
        if (additionalVolume == null || additionalVolume <= 0 || additionalVolume > Integer.MAX_VALUE - quantity)
            throw new RuleViolation("increment", "Volume increment must be positive and fit within the integer range.");
        return new SampleVolume(quantity + additionalVolume, unit);
    }
}
