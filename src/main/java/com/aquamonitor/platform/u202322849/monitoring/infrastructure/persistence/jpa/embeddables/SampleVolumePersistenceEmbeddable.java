package com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.embeddables;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;

/**
 * Stores the sample volume in the plan row.
 * @author Marlon Packard Viza Quispe
 */
@Embeddable
public class SampleVolumePersistenceEmbeddable {
    @Column(name = "sample_volume_quantity", nullable = false)
    private Integer sampleVolumeQuantity;
    @Column(name = "sample_volume_unit", nullable = false)
    private String sampleVolumeUnit;

    protected SampleVolumePersistenceEmbeddable() {}

    public SampleVolumePersistenceEmbeddable(Integer sampleVolumeQuantity, String sampleVolumeUnit) {
        this.sampleVolumeQuantity = sampleVolumeQuantity;
        this.sampleVolumeUnit = sampleVolumeUnit;
    }
}
