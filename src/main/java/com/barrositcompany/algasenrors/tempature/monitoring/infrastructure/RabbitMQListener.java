package com.barrositcompany.algasenrors.tempature.monitoring.infrastructure;

import com.barrositcompany.algasenrors.tempature.monitoring.api.model.TemperatureLogDataDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMQListener {


    @SneakyThrows
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME) // Headers are optional
    public void hancle(@Payload TemperatureLogDataDTO temperatureLogDataDTO,
                       @Headers Map<String, Object> headers) {
        log.info("Received message: {}", temperatureLogDataDTO);
        log.info("Headers: {}", headers);
        // Process the message here

        Thread.sleep(Duration.ofSeconds(5));
    }
}
