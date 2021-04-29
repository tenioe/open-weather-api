package com.sparta.eng82.openweatherapi.framework;

import com.sparta.eng82.openweatherapi.framework.dto.CityDTOImpl;
import com.sparta.eng82.openweatherapi.framework.interfaces.StatusCodeResponse;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.MultipleCityDTO;

public enum EndPoint {

    BASE_URL("api.openweathermap.org/data/2.5/", CityDTOImpl.class),
    BY_CITY_NAME("weather?q={city name},{state code},{country code}", CityDTOImpl.class),
    BY_CITY_ID("weather?id={city id}", CityDTOImpl.class),
    BY_COORDS("weather?lat={lat}&lon={lon}", CityDTOImpl.class),
    BY_ZIP("weather?zip={zip code},{country code}", CityDTOImpl.class),
    BY_BBOX("box/city?bbox={bbox}", MultipleCityDTO.class),
    BY_CIRCLE("find?lat={lat}&lon={lon}&cnt={cnt}", MultipleCityDTO.class);

    private final String url;
    private final Class<? extends StatusCodeResponse> clazz;

    EndPoint(String url, Class<? extends StatusCodeResponse> clazz) {
        this.url = url;
        this.clazz = clazz;
    }

    public String getUrl() {
        return url;
    }

    public Class<? extends StatusCodeResponse> getDTOClass() {
        return clazz;
    }
}
