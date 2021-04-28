package com.sparta.eng82.openweatherapi.framework.interfaces.dto;

import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.*;
import com.sparta.eng82.openweatherapi.framework.interfaces.DTOChecker;
import com.sparta.eng82.openweatherapi.framework.interfaces.StatusCodeResponse;

public interface CityDTO extends DTOChecker, StatusCodeResponse {

    CloudDTO getCloudDTO();
    CoordinatesDTO getCoordinatesDTO();
    MainConditionsDTO getMainConditionsDTO();
    PrecipitationDTO getPrecipitationDTO();
    SystemValuesDTO getSystemValuesDTO();
    WeatherDTO getWeatherDTO();
    WindDTO getWindDTO();

    String getBase();
    Integer getID();
    Integer getVisibility();
    Integer getTimezone();
    String getCityName();
    Integer getDeltaTime();
}
