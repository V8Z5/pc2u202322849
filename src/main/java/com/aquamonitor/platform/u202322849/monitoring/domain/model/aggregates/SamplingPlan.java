package com.aquamonitor.platform.u202322849.monitoring.domain.model.aggregates;

import com.aquamonitor.platform.u202322849.monitoring.domain.model.valueobjects.*;
import com.aquamonitor.platform.u202322849.shared.domain.RuleViolation;
import com.aquamonitor.platform.u202322849.shared.domain.model.aggregates.AbstractDomainAggregateRoot;
import java.time.Instant;

/**
 * Aggregate that validates a sampling plan and records its creation instant.
 * @author Marlon Packard Viza Quispe
 */
public final class SamplingPlan extends AbstractDomainAggregateRoot<SamplingPlan> {
    private Long id;
    private final Instant createdAt = Instant.now();
    private final Instant updatedAt = createdAt;
    private final PlanCode planCode;
    private final StationId stationId;
    private final SamplingWindow samplingWindow;
    private final SampleVolume sampleVolume;
    private final Integer priorityLevel;
    private final SamplingPlanStatus status;
    private final String samplingNotes;

    public SamplingPlan(PlanCode planCode,
                        StationId stationId,
                        SamplingWindow samplingWindow,
                        SampleVolume sampleVolume,
                        Integer priorityLevel,
                        SamplingPlanStatus status,
                        String samplingNotes) {
        if (planCode == null) throw new RuleViolation("code", "Plan code is required.");
        if (stationId == null) throw new RuleViolation("station", "A station UUID is required.");
        if (samplingWindow == null) throw new RuleViolation("dates", "Both sampling dates are required.");
        if (sampleVolume == null) throw new RuleViolation("quantity", "Volume must be a positive integer.");
        if (priorityLevel == null || priorityLevel < 1 || priorityLevel > 5) throw new RuleViolation("priority", "Priority must be between 1 and 5.");
        if (status == null) throw new RuleViolation("status", "Status cannot be null.");
        this.planCode = planCode;
        this.stationId = stationId;
        this.samplingWindow = samplingWindow;
        this.sampleVolume = sampleVolume;
        this.priorityLevel = priorityLevel;
        this.status = status;
        this.samplingNotes = samplingNotes;
    }

    public void assignId(long id) {
        if (this.id != null) throw new IllegalStateException("Identity already assigned.");
        this.id = id;
    }
    public Long id() { return id; }
    public PlanCode planCode() { return planCode; }
    public StationId stationId() { return stationId; }
    public SamplingWindow samplingWindow() { return samplingWindow; }
    public SampleVolume sampleVolume() { return sampleVolume; }
    public Integer priorityLevel() { return priorityLevel; }
    public SamplingPlanStatus status() { return status; }
    public String samplingNotes() { return samplingNotes; }
    public Instant createdAt() { return createdAt; }
    public Instant updatedAt() { return updatedAt; }
}
