package com.barrositcompany.algasenrors.tempature.monitoring.api.controller;

import com.barrositcompany.algasenrors.tempature.monitoring.api.model.SensorAlertInputDTO;
import com.barrositcompany.algasenrors.tempature.monitoring.api.model.SensorAlertOutputDTO;
import com.barrositcompany.algasenrors.tempature.monitoring.domain.model.SensorAlert;
import com.barrositcompany.algasenrors.tempature.monitoring.domain.model.SensorId;
import com.barrositcompany.algasenrors.tempature.monitoring.domain.repository.SensorAlertRepository;
import io.hypersistence.tsid.TSID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/sensors/{sensorId}/alert")
@RequiredArgsConstructor
public class SensorAlertController {

    private final SensorAlertRepository sensorAlertRepository;

    @GetMapping
    public SensorAlertOutputDTO search(@PathVariable TSID sensorId){
        SensorAlert sensorAlert = sensorAlertRepository.findById(new SensorId(sensorId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return SensorAlertOutputDTO.builder()
                .id(sensorAlert.getId().getValue())
                .maxTemperature(sensorAlert.getMaxTemperature())
                .minTemperature(sensorAlert.getMinTemperature())
                .build();

    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public SensorAlertOutputDTO update(@PathVariable TSID sensorId, @RequestBody SensorAlertInputDTO input){
        SensorAlert sensorAlert = sensorAlertRepository.findById(new SensorId(sensorId))
                .orElse(SensorAlert.builder()
                        .id(new SensorId(sensorId))
                        .maxTemperature(input.getMaxTemperature())
                        .minTemperature(input.getMinTemperature())
                        .build());

        sensorAlert.setMaxTemperature(input.getMaxTemperature());
        sensorAlert.setMinTemperature(input.getMinTemperature());

        sensorAlert = sensorAlertRepository.save(sensorAlert);

        return SensorAlertOutputDTO.builder()
                .id(sensorAlert.getId().getValue())
                .maxTemperature(sensorAlert.getMaxTemperature())
                .minTemperature(sensorAlert.getMinTemperature())
                .build();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable TSID sensorId) {
        SensorAlert sensorAlert = sensorAlertRepository.findById(new SensorId(sensorId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        sensorAlertRepository.delete(sensorAlert);
    }
}
