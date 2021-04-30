package com.sparta.eng82.openweatherapi.framework.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.MultipleCityDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.CloudDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.CoordinatesDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.MainConditionsDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.PrecipitationDTO;

import java.util.ArrayList;
import java.util.stream.Stream;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MultipleCityDTOImpl implements MultipleCityDTO {

    @JsonProperty("cod")
    private Integer statusCode;

    @JsonProperty("cnt")
    private Integer cnt;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("list")
    @JsonDeserialize(contentAs = CityDTOImpl.class)
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
    public boolean numberOfCitiesEqualsCount() {
        return cities.size() == getCount();
    }

    @Override
    public boolean listOfCityContainsNullValue() {
        return getCityDTOStream()
                .allMatch(this::isNull);
    }

    public boolean checkSnowIsPositiveOrNullForEveryCity() {
        return getSnowDTOStream()
                .allMatch(PrecipitationDTO::checkValuesArePositive);
    }

    public boolean checkRainIsPositiveOrNullForEveryCity() {
        return getRainDTOStream()
                .allMatch(PrecipitationDTO::checkValuesArePositive);
    }

    @Override
    public boolean checkCloudCoverageIsBetween0and100ForEveryCity() {
        return getCloudDTOStream()
                .allMatch(CloudDTO::isBetween0and100);
    }

    @Override
    public boolean checkLongitudeIsBetweenNegative180and180ForEveryCity() {
        return getCoordinatesDTOStream()
                .allMatch(CoordinatesDTO::isLongitudeBetweenNegative180and180);
    }

    @Override
    public boolean checkLatitudeIsBetweenNegative90and90ForEveryCity() {
        return getCoordinatesDTOStream()
                .allMatch(CoordinatesDTO::isLatitudeBetweenNegative90and90);
    }

    @Override
    public boolean checkMaxTempIsGreaterThanMinTempForEveryCity() {
        return getMainConditionsDTOStream()
                .allMatch(MainConditionsDTO::maxTempGreaterThanMinTemp);
    }

    @Override
    public boolean checkHumidityIsBetween0and100ForEveryCity() {
        return getMainConditionsDTOStream()
                .allMatch(MainConditionsDTO::humidityBetween0and100);
    }

    @Override
    public boolean checkTemperaturesAreGreaterThan0KForEveryCity() {
        return getMainConditionsDTOStream()
                .allMatch(MainConditionsDTO::tempGreaterThanZeroK);
    }

    private Stream<CityDTO> getCityDTOStream() {
        return cities.stream();
    }

    private Stream<PrecipitationDTO> getSnowDTOStream() {
        return getCityDTOStream()
                .map(CityDTO::getSnowDTO);
    }

    private Stream<PrecipitationDTO> getRainDTOStream() {
        return getCityDTOStream()
                .map(CityDTO::getRainDTO);
    }

    private Stream<CloudDTO> getCloudDTOStream() {
        return getCityDTOStream()
                .map(CityDTO::getCloudDTO);
    }

    private Stream<CoordinatesDTO> getCoordinatesDTOStream() {
        return getCityDTOStream()
                .map(CityDTO::getCoordinatesDTO);
    }

    private Stream<MainConditionsDTO> getMainConditionsDTOStream() {
        return getCityDTOStream()
                .map(CityDTO::getMainConditionsDTO);
    }
}
