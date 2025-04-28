package com.barrositcompany.algasenrors.tempature.monitoring.domain.repository;

import com.barrositcompany.algasenrors.tempature.monitoring.api.model.SensorAlertOutputDTO;
import com.barrositcompany.algasenrors.tempature.monitoring.domain.model.SensorAlert;
import com.barrositcompany.algasenrors.tempature.monitoring.domain.model.SensorId;
import io.hypersistence.tsid.TSID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorAlertRepository extends JpaRepository<SensorAlert, SensorId> {

}

