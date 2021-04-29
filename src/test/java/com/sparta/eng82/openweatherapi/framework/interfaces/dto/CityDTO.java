package com.sparta.eng82.openweatherapi.framework.interfaces.dto;

import com.sparta.eng82.openweatherapi.framework.interfaces.DTOChecker;
import com.sparta.eng82.openweatherapi.framework.interfaces.StatusCodeResponse;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.*;

import java.util.ArrayList;

public interface CityDTO extends DTOChecker, StatusCodeResponse {

    CloudDTO getCloudDTO();

    CoordinatesDTO getCoordinatesDTO();

    MainConditionsDTO getMainConditionsDTO();

    PrecipitationDTO getRainDTO();

    PrecipitationDTO getSnowDTO();

    SystemValuesDTO getSystemValuesDTO();

    ArrayList<WeatherDTO> getWeatherDTO();

    WindDTO getWindDTO();

    String getBase();

    Integer getID();

    Integer getVisibility();

    Integer getTimezone();

    String getCityName();

    Integer getDeltaTime();

    boolean areWeatherIdsNotNull();

    boolean areWeatherGroupsNotNull();

    boolean areWeatherDescriptionsNotNull();

    boolean areWeatherIconIdsNotNull();

    boolean areWeatherIdsIntegers();

    boolean areWeatherGroupsStrings();

    boolean areWeatherDescriptionsStrings();

    boolean areWeatherIconIdsStrings();

    boolean doWeatherIdsMatchGroup();

    boolean doWeatherIdsMatchDescription();

    boolean doWeatherIconIdsMatchDescription();
}
