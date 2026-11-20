package com.aquamonitor.platform.u202322849.monitoring.domain.model.valueobjects;

import com.aquamonitor.platform.u202322849.shared.domain.RuleViolation;
import java.util.UUID;

/**
 * Represents the validated external station identity.
 * @author Marlon Packard Viza Quispe
 */
public record StationId(UUID value) {
    public StationId {
        if (value == null) throw new RuleViolation("station", "A station UUID is required.");
    }
}
