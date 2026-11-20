package com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.assemblers;

import com.aquamonitor.platform.u202322849.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.entities.SamplingPlanPersistenceEntity;
import com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.embeddables.SampleVolumePersistenceEmbeddable;
import com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.embeddables.SamplingWindowPersistenceEmbeddable;

/**
 * Maps a validated aggregate to its MySQL representation.
 * @author Marlon Packard Viza Quispe
 */
public final class SamplingPlanPersistenceAssembler {
    private SamplingPlanPersistenceAssembler() {}

    /**
     * Maps values and audit instants before insertion.
     * @param plan the aggregate to store
     * @return an unsaved persistence entity
     */
    public static SamplingPlanPersistenceEntity toPersistenceFromDomain(SamplingPlan plan) {
        var window = new SamplingWindowPersistenceEmbeddable(plan.samplingWindow().startDate(), plan.samplingWindow().endDate());
        var volume = new SampleVolumePersistenceEmbeddable(plan.sampleVolume().quantity(), plan.sampleVolume().unit());
        return new SamplingPlanPersistenceEntity(plan.planCode().code(), plan.stationId().value(),
                window, volume, plan.priorityLevel(), plan.status(), plan.samplingNotes(), plan.createdAt(), plan.updatedAt());
    }
}
