package com.barrositcompany.algasenrors.tempature.monitoring.api.model;

import io.hypersistence.tsid.TSID;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Data
public class TemperatureLogDataDTO {

    private UUID id;
    private TSID sensorId;
    private OffsetDateTime registeredAt;
    private Double value;
}
