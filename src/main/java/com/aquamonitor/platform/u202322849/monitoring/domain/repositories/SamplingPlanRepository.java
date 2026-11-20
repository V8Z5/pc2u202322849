package com.aquamonitor.platform.u202322849.monitoring.domain.repositories;

import com.aquamonitor.platform.u202322849.monitoring.domain.model.aggregates.SamplingPlan;

/**
 * Persistence contract for registering plans.
 * @author Marlon Packard Viza Quispe
 */
public interface SamplingPlanRepository {
    SamplingPlan save(SamplingPlan plan);
}
