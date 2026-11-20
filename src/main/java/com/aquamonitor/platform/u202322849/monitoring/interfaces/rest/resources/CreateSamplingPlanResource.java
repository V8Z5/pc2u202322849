package com.aquamonitor.platform.u202322849.monitoring.interfaces.rest.resources;

import com.aquamonitor.platform.u202322849.monitoring.domain.model.valueobjects.SamplingPlanStatus;
import java.util.UUID;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Accepts flat JSON fields and distinguishes an omitted status from null.
 * @author Marlon Packard Viza Quispe
 */
public class CreateSamplingPlanResource {
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    public String planCode;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    public UUID stationId;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    public LocalDate samplingWindowStartDate;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    public LocalDate samplingWindowEndDate;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    public Integer sampleVolumeQuantity;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    public String sampleVolumeUnit;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    public Integer priorityLevel;
    @JsonSetter(nulls = Nulls.FAIL)
    @Schema(defaultValue = "PENDING")
    public SamplingPlanStatus status = SamplingPlanStatus.PENDING;
    public String samplingNotes;
}
