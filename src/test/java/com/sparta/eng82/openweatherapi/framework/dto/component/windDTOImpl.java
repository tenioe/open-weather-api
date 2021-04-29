package com.sparta.eng82.openweatherapi.framework.dto.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.WindDTO;

public class windDTOImpl implements WindDTO {
    private Double speed;
    private Double degree;
    private Double gust;

    @JsonProperty("speed")
    @Override
    public Double getSpeed() {
        return speed;
    }

    @JsonProperty("deg")
    @Override
    public Double getDegree() {
        return degree;
    }

    @JsonProperty("gust")
    @Override
    public Double getGust() {
        return gust;
    }

    @Override
    public Boolean isSpeedBelowZero() {
        return speed < 0;
    }

    @Override
    public Boolean isGustBelowZero() {
        return gust < 0;
    }

    @Override
    public Boolean isDegreeBelowZeroOrAbove360() {
        return degree < 0 || degree > 360;
    }


}
