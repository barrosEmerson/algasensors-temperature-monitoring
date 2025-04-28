package com.barrositcompany.algasenrors.tempature.monitoring.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SensorAlertInputDTO {

    private Double minTemperature;
    private Double maxTemperature;
}
