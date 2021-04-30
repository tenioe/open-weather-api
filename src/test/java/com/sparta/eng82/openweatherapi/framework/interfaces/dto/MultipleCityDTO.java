package com.sparta.eng82.openweatherapi.framework.interfaces.dto;

import com.sparta.eng82.openweatherapi.framework.interfaces.DTOChecker;
import com.sparta.eng82.openweatherapi.framework.interfaces.StatusCodeResponse;

import java.util.ArrayList;

public interface MultipleCityDTO extends DTOChecker, StatusCodeResponse {

    ArrayList<CityDTO> getCities();

    Integer getCount();

    boolean numberOfCitiesEqualsCount();

    boolean listOfCityContainsNullValue();

    boolean checkSnowIsPositiveOrNullForEveryCity();

    boolean checkRainIsPositiveOrNullForEveryCity();

    boolean checkCloudCoverageIsBetween0and100ForEveryCity();

    boolean checkLongitudeIsBetweenNegative180and180ForEveryCity();

    boolean checkLatitudeIsBetweenNegative90and90ForEveryCity();

    boolean checkMaxTempIsGreaterThanMinTempForEveryCity();

    boolean checkHumidityIsBetween0and100ForEveryCity();

    boolean checkTemperaturesAreGreaterThan0KForEveryCity();
}
