package com.aquamonitor.platform.u202322849.monitoring.interfaces.rest.transform;

import com.aquamonitor.platform.u202322849.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202322849.monitoring.interfaces.rest.resources.SamplingPlanResource;

/**
 * Builds an outgoing REST resource from the created aggregate.
 * @author Marlon Packard Viza Quispe
 */
public final class SamplingPlanResourceFromEntityAssembler {
    private SamplingPlanResourceFromEntityAssembler() {}

    /**
     * Builds an outgoing REST resource from the created aggregate.
     * @param plan saved aggregate
     * @return response resource
     */
    public static SamplingPlanResource toResource(SamplingPlan plan) {
        return new SamplingPlanResource(plan.id(),
                plan.planCode().code(),
                plan.stationId().value(),
                plan.samplingWindow().startDate(),
                plan.samplingWindow().endDate(),
                plan.sampleVolume().quantity(),
                plan.sampleVolume().unit(),
                plan.priorityLevel(),
                plan.status(),
                plan.samplingNotes());
    }
}
