package com.sparta.eng82.openweatherapi;

import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import com.sparta.eng82.openweatherapi.framework.EndPoint;
import com.sparta.eng82.openweatherapi.framework.Injector;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.WeatherDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    @Test
    @DisplayName("Check weather id is not null")
    void checkWeatherIdIsNotNull() {
        Assertions.assertNotNull(cityDTO.getWeatherDTO().get(0));

    }

    @Test
    @DisplayName("Check all id are not null")
    void checkAllIdAreNotNull() {
       Assertions.assertTrue(cityDTO.areWeatherIdsNotNull());
    }
}
