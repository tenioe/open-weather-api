package com.sparta.eng82.openweatherapi.framework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.*;

public class CityDTOImpl implements CityDTO {

    @JsonProperty("coord")
    private CoordinatesDTO coordinatesDTO;

    @JsonProperty("weather")
    private WeatherDTO weatherDTO;

    @JsonProperty("base")
    private String base;

    @JsonProperty("main")
    private MainConditionsDTO mainConditionsDTO;

    @JsonProperty("visibility")
    private Integer visibility;

    @JsonProperty("wind")
    private WindDTO windDTO;

    @JsonProperty("clouds")
    private CloudDTO cloudDTO;

    @JsonProperty("rain")
    private PrecipitationDTO rainDTO;

    @JsonProperty("snow")
    private PrecipitationDTO snowDTO;

    @JsonProperty("dt")
    private Integer deltaTime;

    @JsonProperty("sys")
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
    public WeatherDTO getWeatherDTO() {
        return weatherDTO;
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
