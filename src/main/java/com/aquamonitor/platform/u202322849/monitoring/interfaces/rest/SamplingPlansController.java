package com.aquamonitor.platform.u202322849.monitoring.interfaces.rest;

import com.aquamonitor.platform.u202322849.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202322849.shared.application.result.Result;
import com.aquamonitor.platform.u202322849.shared.interfaces.rest.*;
import com.aquamonitor.platform.u202322849.monitoring.application.commandservices.SamplingPlanCommandService;
import com.aquamonitor.platform.u202322849.monitoring.interfaces.rest.resources.*;
import com.aquamonitor.platform.u202322849.monitoring.interfaces.rest.transform.CreateSamplingPlanCommandFromResourceAssembler;
import com.aquamonitor.platform.u202322849.monitoring.interfaces.rest.transform.SamplingPlanResourceFromEntityAssembler;
import com.aquamonitor.platform.u202322849.shared.application.result.ApplicationError;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.*;

/**
 * Handles the registration endpoint for monitoring stations.
 * @author Marlon Packard Viza Quispe
 */
@RestController
@RequestMapping("/api/v1/sampling-plans")
public class SamplingPlansController {
    private final SamplingPlanCommandService commandService;
    private final ErrorResponses errors;

    public SamplingPlansController(SamplingPlanCommandService commandService, ErrorResponses errors) {
        this.commandService = commandService;
        this.errors = errors;
    }

    /**
     * Registers a water sampling plan.
     * @param input flat representation of the new plan
     * @return the created resource or a localized error message
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    @Operation(summary = "Register a water sampling plan")
    @ApiResponse(responseCode = "201", description = "Plan registered", content = @Content(schema = @Schema(implementation = SamplingPlanResource.class)))
    @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = MessageResource.class)))
    @ApiResponse(responseCode = "409", description = "Duplicate plan code", content = @Content(schema = @Schema(implementation = MessageResource.class)))
    @ApiResponse(responseCode = "500", description = "Unexpected failure", content = @Content(schema = @Schema(implementation = MessageResource.class)))
    public ResponseEntity<?> create(@RequestBody CreateSamplingPlanResource input) {
        return switch (commandService.handle(CreateSamplingPlanCommandFromResourceAssembler.toCommand(input))) {
            case Result.Success<SamplingPlan, ApplicationError> success ->
                    ResponseEntity.status(201).body(SamplingPlanResourceFromEntityAssembler.toResource(success.value()));
            case Result.Failure<SamplingPlan, ApplicationError> failure ->
                    errors.response(switch (failure.error().code()) {
                        case "PLAN_CODE_CONFLICT" -> 409;
                        case "UNEXPECTED_ERROR" -> 500;
                        default -> 400;
                    }, failure.error().details());
        };
    }
}
