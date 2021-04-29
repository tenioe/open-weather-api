package com.sparta.eng82.openweatherapi.framework.interfaces.dto.component;

import com.sparta.eng82.openweatherapi.framework.interfaces.DTOChecker;

public interface WeatherDTO extends DTOChecker {

    Integer getWeatherId();

    String getWeatherGroup();

    String getWeatherDescription();

    String getWeatherIconId();

    boolean checkWeatherIdMatchesGroup();

    boolean checkWeatherIdMatchesDescription();

    boolean checkWeatherIconMatchesDescription();
}
