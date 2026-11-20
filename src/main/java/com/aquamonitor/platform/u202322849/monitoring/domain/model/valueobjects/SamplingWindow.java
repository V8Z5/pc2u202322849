package com.aquamonitor.platform.u202322849.monitoring.domain.model.valueobjects;

import com.aquamonitor.platform.u202322849.shared.domain.RuleViolation;
import java.time.LocalDate;

/**
 * Represents the validated sampling period.
 * @author Marlon Packard Viza Quispe
 */
public record SamplingWindow(LocalDate startDate, LocalDate endDate) {
    public SamplingWindow {
        if (startDate == null || endDate == null) throw new RuleViolation("dates", "Both sampling dates are required.");
        if (!endDate.isAfter(startDate)) throw new RuleViolation("order", "End date must follow start date.");
    }
    /**
     * Checks the inclusive sampling period.
     * @param checkDate date to check
     * @return whether the date belongs to this window
     */
    public boolean contains(LocalDate checkDate) {
        if (checkDate == null) throw new RuleViolation("check", "A date to check is required.");
        return !checkDate.isBefore(startDate) && !checkDate.isAfter(endDate);
    }
}
