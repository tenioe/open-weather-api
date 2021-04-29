package com.sparta.eng82.openweatherapi;

import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import com.sparta.eng82.openweatherapi.framework.EndPoint;
import com.sparta.eng82.openweatherapi.framework.Injector;
import com.sparta.eng82.openweatherapi.framework.dto.MultipleCityDTOImpl;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import org.junit.jupiter.api.*;

public class CoordinatesDTOTests {

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
        @DisplayName("Check if Longitude is between -180 and 180")
        void checkIfLongitudeIsBetween180And180() {
            Assertions.assertTrue(cityDTO.getCoordinatesDTO().isLongitudeBetweenNegative180and180());
            Assertions.assertTrue(multipleCityDTO.getCities().get(0).getCoordinatesDTO().isLongitudeBetweenNegative180and180());

        }


        @Test
        @DisplayName("Check if Latitude is between -90 and 90")
        void checkIfLatitudeIsBetween90And90() {
            Assertions.assertTrue(cityDTO.getCoordinatesDTO().isLatitudeBetweenNegative90and90());
        }
    }

    @Nested
    @DisplayName("Check that values are valid for single city")
    class checkThatValuesAreValidForMultipleCity {
        @Test
        @DisplayName("Check if Longitude is between -180 and 180")
        void checkIfLongitudeIsBetween180And180() {
            Assertions.assertTrue(multipleCityDTO.getCities().get(0).getCoordinatesDTO().isLongitudeBetweenNegative180and180());

        }


        @Test
        @DisplayName("Check if Latitude is between -90 and 90")
        void checkIfLatitudeIsBetween90And90() {
            Assertions.assertTrue(multipleCityDTO.getCities().get(0).getCoordinatesDTO().isLatitudeBetweenNegative90and90());

        }
    }

}
