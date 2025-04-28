package com.barrositcompany.algasenrors.tempature.monitoring.api.controller;

import com.barrositcompany.algasenrors.tempature.monitoring.api.model.TemperatureLogOutputDTO;
import com.barrositcompany.algasenrors.tempature.monitoring.domain.model.SensorId;
import com.barrositcompany.algasenrors.tempature.monitoring.domain.repository.TemperratureLogRepository;
import io.hypersistence.tsid.TSID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sensors/{sensorId}/temperatures")
@RequiredArgsConstructor
public class TemperatureLogController {

    private final TemperratureLogRepository temperratureLogRepository;

    @GetMapping
    public Page<TemperatureLogOutputDTO> search(@PathVariable TSID sensorId, @PageableDefault Pageable pageable) {
        return temperratureLogRepository.findAllBySensorId(new SensorId(sensorId), pageable)
                .map(log -> TemperatureLogOutputDTO.builder()
                        .id(log.getId().getValue())
                        .sensorId(log.getSensorId().getValue())
                        .registeredAt(log.getRegisteredAt())
                        .value(log.getValue())
                        .build());
    }
}
