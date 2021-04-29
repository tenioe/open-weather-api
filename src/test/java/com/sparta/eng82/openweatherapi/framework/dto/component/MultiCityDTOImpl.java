package com.sparta.eng82.openweatherapi.framework.dto.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.MultipleCityDTO;

import java.util.ArrayList;

public class MultiCityDTOImpl implements MultipleCityDTO {

    @JsonProperty("cod")
    private Integer statusCode;

    @JsonProperty("cnt")
    private Integer cnt;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("message")
    private String message;

    @JsonProperty("list")
    private ArrayList<CityDTO> cities;

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public ArrayList<CityDTO> getCities() {
        return cities;
    }

    @Override
    public Integer getCount() {
        return isNull(cnt) ? count : cnt;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean numberOfCitiesEqualsCount() {
        return cities.size() == getCount();
    }

    @Override
    public boolean listOfCityContainsNullValue() {
        return cities.stream()
                .anyMatch(this::isNull);
    }
}
