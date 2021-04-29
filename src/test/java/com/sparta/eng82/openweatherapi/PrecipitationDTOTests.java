package com.sparta.eng82.openweatherapi;

import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import com.sparta.eng82.openweatherapi.framework.EndPoint;
import com.sparta.eng82.openweatherapi.framework.Injector;
import com.sparta.eng82.openweatherapi.framework.dto.CityDTOImpl;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import org.junit.jupiter.api.*;


public class PrecipitationDTOTests {
    static CityDTOImpl cityDTO;

    @BeforeAll
    static void setupAll(){
        cityDTO = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "memphis"));
    }

    @Test
    @DisplayName("Check getters for a single city")
    void checkGetters() {
        System.out.println(cityDTO.getRainDTO().getOneHourMillis());
        System.out.println(cityDTO.getRainDTO().getThreeHourMillis());

        System.out.println(cityDTO.getSnowDTO().getOneHourMillis());
        System.out.println(cityDTO.getSnowDTO().getThreeHourMillis());

    }

    @Test
    @DisplayName("Test returned values are positive for a single city")
    void testReturnedValuesArePositive() {
        Assertions.assertTrue(cityDTO.getRainDTO().checkValuesArePositive());
        Assertions.assertTrue(cityDTO.getSnowDTO().checkValuesArePositive());

    }


}
