package com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.repositories;

import com.aquamonitor.platform.u202322849.monitoring.infrastructure.persistence.jpa.entities.SamplingPlanPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides Spring Data access to sampling plan rows.
 * @author Marlon Packard Viza Quispe
 */
public interface SamplingPlanPersistenceRepository extends JpaRepository<SamplingPlanPersistenceEntity, Long> {}
