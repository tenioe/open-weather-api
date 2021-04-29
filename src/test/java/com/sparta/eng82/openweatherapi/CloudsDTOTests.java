package com.sparta.eng82.openweatherapi;

import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import com.sparta.eng82.openweatherapi.framework.EndPoint;
import com.sparta.eng82.openweatherapi.framework.Injector;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.MultipleCityDTO;
import org.junit.jupiter.api.*;

public class CloudsDTOTests {

    static CityDTO cityDTO;
    static MultipleCityDTO multipleCityDTO;

    @Nested
    @DisplayName("Tests for single city responses")
    class TestingResponsesForSingleCities {
        @BeforeEach
        void setUp() {
            cityDTO = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "Memphis"));
        }

        @Test
        @DisplayName("Check the cloud coverage is between 0 and 100")
        void checkTheCloudCoverageIsBetween0And100() {
            Assertions.assertTrue(cityDTO.getCloudDTO().isBetween0and100());
            System.out.println(cityDTO.getCloudDTO().getCloudCoverage());
        }
    }

    @Nested
    @DisplayName("Tests for multiple city responses")
    class TestingMultipleCityResponses {
        @BeforeEach
        void setUp() {
            multipleCityDTO = Injector.injectDTO((ConnectionManager.getConnection(EndPoint.BY_BBOX, "12,32,15,37,10")));
        }

        @Test
        @DisplayName("Check multiple cities cloud coverages are between 0 and 100")
        void checkMultipleCitiesCloudCoveragesAreBetween0And100() {
            for(CityDTO city : multipleCityDTO.getCities()) {
                Assertions.assertTrue(city.getCloudDTO().isBetween0and100());
            }
        }
    }


}
