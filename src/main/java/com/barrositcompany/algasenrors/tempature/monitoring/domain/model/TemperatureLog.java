package com.barrositcompany.algasenrors.tempature.monitoring.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TemperatureLog {

    @Id
    @AttributeOverride(name= "value", column = @Column(name = "id", columnDefinition = "uuid"))
    private TemperatureLogId id;
    @Embedded
    @AttributeOverride(name= "value", column = @Column(name = "sensor_id", columnDefinition = "bigint"))
    private SensorId sensorId;
    @Column(name = "\"value\"")
    private Double value;
    private OffsetDateTime registeredAt;




}
