package com.aquamonitor.platform.u202322849.monitoring.application.commands;

import com.aquamonitor.platform.u202322849.monitoring.domain.model.valueobjects.SamplingPlanStatus;
import java.util.UUID;
import java.time.LocalDate;

/**
 * Carries the values requested for a new plan.
 * @author Marlon Packard Viza Quispe
 */
public record CreateSamplingPlanCommand(
        String planCode,
        UUID stationId,
        LocalDate samplingWindowStartDate,
        LocalDate samplingWindowEndDate,
        Integer sampleVolumeQuantity,
        String sampleVolumeUnit,
        Integer priorityLevel,
        SamplingPlanStatus status,
        String samplingNotes) {}
