package com.sparta.eng82.openweatherapi.framework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sparta.eng82.openweatherapi.framework.dto.component.*;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.*;

import java.util.ArrayList;

public class CityDTOImpl implements CityDTO {

    @JsonProperty("coord")
    @JsonDeserialize(as = CoordinatesDTOImpl.class)
    private CoordinatesDTO coordinatesDTO;

    @JsonProperty("weather")
    @JsonDeserialize(contentAs = WeatherDTOImpl.class)
    private ArrayList<WeatherDTO> weatherDTOs;

    @JsonProperty("base")
    private String base;

    @JsonProperty("main")
    @JsonDeserialize(as = MainConditionsDTOImpl.class)
    private MainConditionsDTO mainConditionsDTO;

    @JsonProperty("visibility")
    private Integer visibility;

    @JsonProperty("wind")
    @JsonDeserialize(as = WindDTOImpl.class)
    private WindDTO windDTO;

    @JsonProperty("clouds")
    @JsonDeserialize(as = CloudDTOImpl.class)
    private CloudDTO cloudDTO;

    @JsonProperty("rain")
    @JsonDeserialize(as = PrecipitationDTOImpl.class)
    private PrecipitationDTO rainDTO;

    @JsonProperty("snow")
    @JsonDeserialize(as = PrecipitationDTOImpl.class)
    private PrecipitationDTO snowDTO;

    @JsonProperty("dt")
    private Integer deltaTime;

    @JsonProperty("sys")
    @JsonDeserialize(as = SystemValuesDTOImpl.class)
    private SystemValuesDTO systemValuesDTO;

    @JsonProperty("timezone")
    private Integer timezone;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("cod")
    private Integer statusCode;

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public CloudDTO getCloudDTO() {
        return cloudDTO;
    }

    @Override
    public CoordinatesDTO getCoordinatesDTO() {
        return coordinatesDTO;
    }

    @Override
    public MainConditionsDTO getMainConditionsDTO() {
        return mainConditionsDTO;
    }

    @Override
    public PrecipitationDTO getRainDTO() {
        return rainDTO;
    }

    @Override
    public PrecipitationDTO getSnowDTO() {
        return snowDTO;
    }

    @Override
    public SystemValuesDTO getSystemValuesDTO() {
        return systemValuesDTO;
    }

    @Override
    public ArrayList<WeatherDTO> getWeatherDTO() {
        return weatherDTOs;
    }

    @Override
    public WindDTO getWindDTO() {
        return windDTO;
    }

    @Override
    public String getBase() {
        return base;
    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public Integer getVisibility() {
        return visibility;
    }

    @Override
    public Integer getTimezone() {
        return timezone;
    }

    @Override
    public String getCityName() {
        return name;
    }

    @Override
    public Integer getDeltaTime() {
        return deltaTime;
    }
}
