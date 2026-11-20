package com.aquamonitor.platform.u202322849.monitoring.interfaces.rest.resources;

import com.aquamonitor.platform.u202322849.monitoring.domain.model.valueobjects.SamplingPlanStatus;
import java.util.UUID;
import java.time.LocalDate;

/**
 * Describes the registered plan without exposing internal audit data.
 * @author Marlon Packard Viza Quispe
 */
public record SamplingPlanResource(
        Long id,
        String planCode,
        UUID stationId,
        LocalDate samplingWindowStartDate,
        LocalDate samplingWindowEndDate,
        Integer sampleVolumeQuantity,
        String sampleVolumeUnit,
        Integer priorityLevel,
        SamplingPlanStatus status,
        String samplingNotes) {}
