package com.sparta.eng82.openweatherapi;

import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import com.sparta.eng82.openweatherapi.framework.EndPoint;
import com.sparta.eng82.openweatherapi.framework.Injector;
import com.sparta.eng82.openweatherapi.framework.dto.MultipleCityDTOImpl;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import org.junit.jupiter.api.*;

public class MainConditionsDTOTests {

    static CityDTO cityDTO;
    static MultipleCityDTOImpl multipleCityDTO;

    @BeforeAll
    static void init() {
        cityDTO = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "Memphis"));
        multipleCityDTO = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CIRCLE, "5", "5", "5"));
    }

    @Nested
    @DisplayName("Check that values are valid for single city")
    class checkThatValuesAreValidForSingleCity {

        @Test
        @DisplayName("Check if max temperature is greater than min temperature")
        void checkIfMaxTemperatureIsGreaterThanMinTemperature() {
            Assertions.assertTrue(cityDTO.getMainConditionsDTO().maxTempGreaterThanMinTemp());
        }

        @Test
        @DisplayName("Check if humidity between 0 and 100")
        void checkIfHumidityBetween0And100() {
            Assertions.assertTrue(cityDTO.getMainConditionsDTO().humidityBetween0and100());
        }


        @Test
        @DisplayName("Check if all temperatures are greater than 0")
        void checkIfAllTemperaturesAreGreaterThan0() {
            Assertions.assertTrue(cityDTO.getMainConditionsDTO().tempGreaterThanZeroK());
        }
    }

    @Nested
    @DisplayName("Check that values are valid for multiple city")
    class checkThatValuesAreValidForMultipleCity {

        @Test
        @DisplayName("Check if max temperature is greater than min temperature")
        void checkIfMaxTemperatureIsGreaterThanMinTemperature() {
            Assertions.assertTrue(multipleCityDTO.getCities().get(0).getMainConditionsDTO().maxTempGreaterThanMinTemp());
        }

        @Test
        @DisplayName("Check if humidity between 0 and 100")
        void checkIfHumidityBetween0And100() {
            Assertions.assertTrue(multipleCityDTO.getCities().get(0).getMainConditionsDTO().humidityBetween0and100());
        }


        @Test
        @DisplayName("Check if all temperatures are greater than 0")
        void checkIfAllTemperaturesAreGreaterThan0() {
            Assertions.assertTrue(multipleCityDTO.getCities().get(0).getMainConditionsDTO().tempGreaterThanZeroK());
        }
    }
}
