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
    @DisplayName("Check all weather ids match groups")
    void checkAllWeatherIdsMatchGroups() {
        Assertions.assertTrue(cityDTO.doWeatherIdsMatchGroup());
    }

    @Test
    @DisplayName("Check all weather icon ids match descriptions")
    void checkAllWeatherIconIdsMatchDescriptions() {
        Assertions.assertTrue(cityDTO.doWeatherIconIdsMatchDescription());
    }

    @Test
    @DisplayName("Check all weather ids match descriptions")
    void checkAllWeatherIdsMatchDescriptions() {
        Assertions.assertTrue(cityDTO.doWeatherIdsMatchDescription());
    }

    @Test
    @DisplayName("Check all weather ids are not null")
    void checkAllWeatherIdsAreNotNull() {
        Assertions.assertTrue(cityDTO.areWeatherIdsNotNull());
    }
}
