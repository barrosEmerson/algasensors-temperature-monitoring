package com.barrositcompany.algasenrors.tempature.monitoring.domain.repository;

import com.barrositcompany.algasenrors.tempature.monitoring.domain.model.SensorId;
import com.barrositcompany.algasenrors.tempature.monitoring.domain.model.TemperatureLog;
import com.barrositcompany.algasenrors.tempature.monitoring.domain.model.TemperatureLogId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperratureLogRepository extends JpaRepository<TemperatureLog, TemperatureLogId> {
    Page<TemperatureLog> findAllBySensorId(SensorId sensorId, Pageable pageable);
}
