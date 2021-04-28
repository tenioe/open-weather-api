package com.sparta.eng82.openweatherapi.framework.interfaces.dto.component;

import com.sparta.eng82.openweatherapi.framework.interfaces.DTOChecker;

public interface SystemValuesDTO extends DTOChecker {
    Integer getID();

    String getCountry();

    Integer getSunrise();

    Integer getSunset();

    boolean isSunriseBeforeSunset();
}
