package com.sparta.eng82.openweatherapi.framework.dto.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.WindDTO;

public class WindDTOImpl implements WindDTO {

    @JsonProperty("speed")
    private Double speed;

    @JsonProperty("deg")
    private Double degree;

    @JsonProperty("gust")
    private Double gust;

    @Override
    public Double getSpeed() {
        return speed;
    }

    @Override
    public Double getDegree() {
        return degree;
    }

    @Override
    public Double getGust() {
        return gust;
    }

    @Override
    public Boolean isSpeedGreaterThanZero() {
        return speed >= 0;
    }

    @Override
    public Boolean isGustGreaterThanZero() {
        if (gust == null) {
            return true;
        }
        return gust >= 0;
    }

    @Override
    public Boolean isDegreeBetween0And360() {
        return degree >= 0 && degree <= 360;
    }
}
