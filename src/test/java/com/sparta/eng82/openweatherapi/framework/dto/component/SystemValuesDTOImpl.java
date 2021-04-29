package com.sparta.eng82.openweatherapi.framework.dto.component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.SystemValuesDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemValuesDTOImpl implements SystemValuesDTO {

    private int id;
    private String country;
    private int sunrise;
    private int sunset;

    @JsonProperty("id")
    @Override
    public Integer getID() {
        return id;
    }

    @JsonProperty("country")
    @Override
    public String getCountry() {
        return country;
    }

    @JsonProperty("sunrise")
    @Override
    public Integer getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunset")
    @Override
    public Integer getSunset() {
        return sunset;
    }

    @Override
    public boolean isSunriseBeforeSunset() {
        return sunrise < sunset;
    }
}
