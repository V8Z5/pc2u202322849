package com.aquamonitor.platform.u202322849.monitoring.application.commandservices;

import com.aquamonitor.platform.u202322849.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202322849.monitoring.application.commands.CreateSamplingPlanCommand;
import com.aquamonitor.platform.u202322849.shared.application.result.ApplicationError;
import com.aquamonitor.platform.u202322849.shared.application.result.Result;

/**
 * Defines the write operations of the monitoring context.
 * @author Marlon Packard Viza Quispe
 */
public interface SamplingPlanCommandService {
    /**
     * Registers a sampling plan.
     * @param command values supplied for the new plan
     * @return the persisted aggregate or a categorized application error
     */
    Result<SamplingPlan, ApplicationError> handle(CreateSamplingPlanCommand command);
}
