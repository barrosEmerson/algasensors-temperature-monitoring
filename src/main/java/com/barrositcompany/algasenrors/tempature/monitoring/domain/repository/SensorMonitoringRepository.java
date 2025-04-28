package com.barrositcompany.algasenrors.tempature.monitoring.domain.repository;

import com.barrositcompany.algasenrors.tempature.monitoring.domain.model.SensorId;
import com.barrositcompany.algasenrors.tempature.monitoring.domain.model.SensorMonitoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorMonitoringRepository extends JpaRepository<SensorMonitoring, SensorId> {
}
