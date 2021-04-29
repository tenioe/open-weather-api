package com.sparta.eng82.openweatherapi.framework.dto.component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.SystemValuesDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemValuesDTOImpl implements SystemValuesDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("country")
    private String country;

    @JsonProperty("sunrise")
    private int sunrise;

    @JsonProperty("sunset")
    private int sunset;

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public Integer getSunrise() {
        return sunrise;
    }

    @Override
    public Integer getSunset() {
        return sunset;
    }

    @Override
    public boolean isSunriseBeforeOrEqualToSunset() {
        return sunrise <= sunset;
    }

    @Override
    public boolean isCountryLength2() {
        return country.length() == 2;
    }

    @Override
    public boolean isCountryUpperCase() {
        return country.chars().allMatch(Character::isUpperCase);
    }
}
