package com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.adapters;

import com.aquamonitor.platform.u202322849.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202322849.monitoring.domain.repositories.SamplingPlanRepository;
import com.aquamonitor.platform.u202322849.monitoring.domain.exceptions.DuplicatePlanCodeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.repositories.SamplingPlanPersistenceRepository;
import com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.assemblers.SamplingPlanPersistenceAssembler;
import java.sql.SQLException;

/**
 * Persists the aggregate and translates MySQL unique-code violations.
 * @author Marlon Packard Viza Quispe
 */
@Repository
public class SamplingPlanRepositoryImpl implements SamplingPlanRepository {
    private final SamplingPlanPersistenceRepository rows;

    public SamplingPlanRepositoryImpl(SamplingPlanPersistenceRepository rows) { this.rows = rows; }

    @Override
    public SamplingPlan save(SamplingPlan plan) {
        try {
            plan.assignId(rows.saveAndFlush(SamplingPlanPersistenceAssembler.toPersistenceFromDomain(plan)).getId());
            return plan;
        } catch (DataIntegrityViolationException ex) {
            for (Throwable cause = ex; cause != null; cause = cause.getCause()) {
                if (cause instanceof SQLException sql && sql.getErrorCode() == 1062
                        && sql.getMessage().contains("uk_sampling_plans_plan_code")) {
                    throw new DuplicatePlanCodeException(ex);
                }
            }
            throw ex;
        }
    }
}
