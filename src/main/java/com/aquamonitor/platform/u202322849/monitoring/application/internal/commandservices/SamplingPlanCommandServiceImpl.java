package com.aquamonitor.platform.u202322849.monitoring.application.internal.commandservices;

import com.aquamonitor.platform.u202322849.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202322849.monitoring.domain.model.valueobjects.*;
import com.aquamonitor.platform.u202322849.monitoring.application.commands.CreateSamplingPlanCommand;
import com.aquamonitor.platform.u202322849.monitoring.domain.repositories.SamplingPlanRepository;
import com.aquamonitor.platform.u202322849.monitoring.domain.exceptions.DuplicatePlanCodeException;
import com.aquamonitor.platform.u202322849.shared.application.result.Result;
import com.aquamonitor.platform.u202322849.shared.domain.RuleViolation;
import com.aquamonitor.platform.u202322849.monitoring.application.commandservices.SamplingPlanCommandService;
import com.aquamonitor.platform.u202322849.shared.application.result.ApplicationError;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Executes the creation command and returns its business outcome.
 * @author Marlon Packard Viza Quispe
 */
@Service
public class SamplingPlanCommandServiceImpl implements SamplingPlanCommandService {
    private static final Logger LOG = LoggerFactory.getLogger(SamplingPlanCommandServiceImpl.class);
    private final SamplingPlanRepository plans;

    public SamplingPlanCommandServiceImpl(SamplingPlanRepository plans) { this.plans = plans; }

    /**
     * Registers a plan under a unique code.
     * @param command input values from the client
     * @return the saved plan or a localized error key
     */
    @Override
    public Result<SamplingPlan, ApplicationError> handle(CreateSamplingPlanCommand command) {
        try {
            var plan = new SamplingPlan(new PlanCode(command.planCode()), new StationId(command.stationId()),
                    new SamplingWindow(command.samplingWindowStartDate(), command.samplingWindowEndDate()),
                    new SampleVolume(command.sampleVolumeQuantity(), command.sampleVolumeUnit()),
                    command.priorityLevel(), command.status(), command.samplingNotes());
            return Result.success(plans.save(plan));
        } catch (RuleViolation ex) {
            return Result.failure(ApplicationError.validationError("sampling plan", ex.key()));
        } catch (DuplicatePlanCodeException ex) {
            return Result.failure(ApplicationError.conflict("plan_code", "duplicate"));
        } catch (RuntimeException ex) {
            LOG.error("Could not register sampling plan", ex);
            return Result.failure(ApplicationError.unexpected("plan registration", "internal"));
        }
    }
}
