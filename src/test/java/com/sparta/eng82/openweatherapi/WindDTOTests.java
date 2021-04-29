package com.sparta.eng82.openweatherapi;

import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import com.sparta.eng82.openweatherapi.framework.EndPoint;
import com.sparta.eng82.openweatherapi.framework.Injector;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WindDTOTests {
    static CityDTO cityDTO;

    @BeforeAll
    static void init() {
        cityDTO = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "London"));
    }

    @Test
    @DisplayName("Is speed greater than zero")
    void isSpeedGreaterThanZero() {
        Assertions.assertTrue(cityDTO.getWindDTO().isSpeedGreaterThanZero());
    }

    @Test
    @DisplayName("Is gust greater than zero")
    void isGustGreaterThanZero() {
        Assertions.assertTrue(cityDTO.getWindDTO().isGustGreaterThanZero());
    }

    @Test
    @DisplayName("Is degree between 0 and 360")
    void isDegreeBetween0And360() {
        Assertions.assertTrue(cityDTO.getWindDTO().isDegreeBetween0And360());
    }
}
