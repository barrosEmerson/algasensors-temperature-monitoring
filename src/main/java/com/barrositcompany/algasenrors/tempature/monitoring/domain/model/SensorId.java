package com.barrositcompany.algasenrors.tempature.monitoring.domain.model;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class SensorId implements Serializable {
    private static final long serialVersionUID = 1L;

    private TSID value;

    public SensorId(TSID id) {
        Objects.requireNonNull(id);
        this.value = id;
    }

    public SensorId(Long id) {
        Objects.requireNonNull(id);
        this.value = TSID.from(id);
    }

    public SensorId(String id) {
        Objects.requireNonNull(id);
        this.value = TSID.from(id);

    }

    @Override
    public String toString() {
        return value.toString();
    }
}
