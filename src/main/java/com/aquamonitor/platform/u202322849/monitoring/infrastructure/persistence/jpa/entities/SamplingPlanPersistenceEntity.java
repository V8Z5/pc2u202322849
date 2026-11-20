package com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.entities;

import com.aquamonitor.platform.u202322849.monitoring.domain.model.valueobjects.SamplingPlanStatus;
import java.util.UUID;
import com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.embeddables.SamplingWindowPersistenceEmbeddable;
import com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.embeddables.SampleVolumePersistenceEmbeddable;
import jakarta.persistence.*;
import java.time.Instant;

/**
 * Maps a plan to the sampling_plans table.
 * @author Marlon Packard Viza Quispe
 */
@Entity
@Table(name = "sampling_plans", uniqueConstraints = @UniqueConstraint(name = "uk_sampling_plans_plan_code", columnNames = "plan_code"))
public class SamplingPlanPersistenceEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "plan_code", nullable = false)
    private String planCode;
    @Column(name = "station_id", nullable = false)
    private UUID stationId;
    @Embedded
    private SamplingWindowPersistenceEmbeddable samplingWindow;
    @Embedded
    private SampleVolumePersistenceEmbeddable sampleVolume;
    @Column(name = "priority_level", nullable = false)
    private Integer priorityLevel;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SamplingPlanStatus status;
    @Column(name = "sampling_notes", columnDefinition = "TEXT")
    private String samplingNotes;
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected SamplingPlanPersistenceEntity() {}

    public SamplingPlanPersistenceEntity(
            String planCode,
            UUID stationId,
            SamplingWindowPersistenceEmbeddable samplingWindow,
            SampleVolumePersistenceEmbeddable sampleVolume,
            Integer priorityLevel,
            SamplingPlanStatus status,
            String samplingNotes,
            Instant createdAt,
            Instant updatedAt) {
        this.planCode = planCode;
        this.stationId = stationId;
        this.samplingWindow = samplingWindow;
        this.sampleVolume = sampleVolume;
        this.priorityLevel = priorityLevel;
        this.status = status;
        this.samplingNotes = samplingNotes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() { return id; }
}
