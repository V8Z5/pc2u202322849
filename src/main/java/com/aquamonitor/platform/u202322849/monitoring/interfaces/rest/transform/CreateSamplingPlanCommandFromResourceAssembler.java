package com.aquamonitor.platform.u202322849.monitoring.interfaces.rest.transform;

import com.aquamonitor.platform.u202322849.monitoring.application.commands.CreateSamplingPlanCommand;
import com.aquamonitor.platform.u202322849.monitoring.interfaces.rest.resources.CreateSamplingPlanResource;

/**
 * Builds a creation command from the incoming REST resource.
 * @author Marlon Packard Viza Quispe
 */
public final class CreateSamplingPlanCommandFromResourceAssembler {
    private CreateSamplingPlanCommandFromResourceAssembler() {}

    /**
     * Builds a creation command from the incoming REST resource.
     * @param input incoming request
     * @return creation command
     */
    public static CreateSamplingPlanCommand toCommand(CreateSamplingPlanResource input) {
        return new CreateSamplingPlanCommand(
                input.planCode,
                input.stationId,
                input.samplingWindowStartDate,
                input.samplingWindowEndDate,
                input.sampleVolumeQuantity,
                input.sampleVolumeUnit,
                input.priorityLevel,
                input.status,
                input.samplingNotes);
    }
}
