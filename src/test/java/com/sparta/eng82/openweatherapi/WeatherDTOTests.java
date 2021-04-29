package com.sparta.eng82.openweatherapi;

import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import com.sparta.eng82.openweatherapi.framework.EndPoint;
import com.sparta.eng82.openweatherapi.framework.Injector;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeatherDTOTests {

    static CityDTO cityDTO;

    @BeforeAll
    static void init() {
        cityDTO = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "Memphis"));
    }

    @Test
    @DisplayName("Check weather id matches group")
    void checkWeatherIdMatchesGroup() {
        Assertions.assertTrue(cityDTO.getWeatherDTO().get(0).checkWeatherIdMatchesGroup());
    }

    @Test
    @DisplayName("Check weather icon matches description")
    void checkWeatherIconMatchesDescription() {
        Assertions.assertTrue(cityDTO.getWeatherDTO().get(0).checkWeatherIconMatchesDescription());
    }

    @Test
    @DisplayName("Check weather id matches description")
    void checkWeatherIdMatchesDescription() {
        Assertions.assertTrue(cityDTO.getWeatherDTO().get(0).checkWeatherIdMatchesDescription());
    }
}
