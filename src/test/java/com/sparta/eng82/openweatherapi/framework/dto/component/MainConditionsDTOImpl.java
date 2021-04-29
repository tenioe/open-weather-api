package com.sparta.eng82.openweatherapi.framework.dto.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.MainConditionsDTO;

public class MainConditionsDTOImpl implements MainConditionsDTO {
    @JsonProperty("temp")
    private Double actualTemperature;

    @JsonProperty("feels_like")
    private Double feelsTemperature;

    @JsonProperty("temp_min")
    private Double minTemperature;

    @JsonProperty("temp_max")
    private Double maxTemperature;

    @JsonProperty("pressure")
    private Integer pressure;

    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("sea_level")
    private Integer seaLevelPressure;

    @JsonProperty("grnd_level")
    private Integer groundLevelPressure;

    public MainConditionsDTOImpl() {
    }

    @Override
    public Double getActualTemperature() {
        return actualTemperature;
    }

    @Override
    public Double getFeelsTemperature() {
        return feelsTemperature;
    }

    @Override
    public Double getMinTemperature() {
        return minTemperature;
    }

    @Override
    public Double getMaxTemperature() {
        return maxTemperature;
    }

    @Override
    public Integer getPressure() {
        return pressure;
    }

    @Override
    public Integer getSeaLevelPressure() {
        return seaLevelPressure;
    }

    @Override
    public Integer getGroundLevelPressure() {
        return groundLevelPressure;
    }

    @Override
    public Integer getHumidity() {
        return humidity;
    }

    @Override
    public boolean maxTempGreaterThanMinTemp() {
        return maxTemperature >= minTemperature;
    }

    @Override
    public boolean humidityBetween0and100() {
        return humidity >= 0 && humidity <= 100;
    }

    @Override
    public boolean tempGreaterThanZeroK() {
        return actualTemperature >= 0 && feelsTemperature >= 0 && minTemperature >= 0 && maxTemperature >= 0;
    }
}
