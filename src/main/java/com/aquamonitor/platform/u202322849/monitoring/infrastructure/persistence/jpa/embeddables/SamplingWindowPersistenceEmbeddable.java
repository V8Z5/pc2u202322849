package com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.embeddables;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import java.time.LocalDate;

/**
 * Stores the sampling period in the plan row.
 * @author Marlon Packard Viza Quispe
 */
@Embeddable
public class SamplingWindowPersistenceEmbeddable {
    @Column(name = "sampling_window_start_date", nullable = false)
    private LocalDate samplingWindowStartDate;
    @Column(name = "sampling_window_end_date", nullable = false)
    private LocalDate samplingWindowEndDate;

    protected SamplingWindowPersistenceEmbeddable() {}

    public SamplingWindowPersistenceEmbeddable(LocalDate samplingWindowStartDate, LocalDate samplingWindowEndDate) {
        this.samplingWindowStartDate = samplingWindowStartDate;
        this.samplingWindowEndDate = samplingWindowEndDate;
    }
}
