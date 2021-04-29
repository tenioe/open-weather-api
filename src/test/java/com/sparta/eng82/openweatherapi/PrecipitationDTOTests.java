package com.sparta.eng82.openweatherapi;

import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import com.sparta.eng82.openweatherapi.framework.EndPoint;
import com.sparta.eng82.openweatherapi.framework.Injector;
import com.sparta.eng82.openweatherapi.framework.dto.CityDTOImpl;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.MultipleCityDTO;
import org.junit.jupiter.api.*;


public class PrecipitationDTOTests {
    static CityDTOImpl cityDTO;
    static MultipleCityDTO multipleCityDTO;

    @BeforeAll
    static void setupAll(){
        cityDTO = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "nashville"));
        multipleCityDTO =  Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CIRCLE, "64","-16","10"));

    }

    @Test
    @DisplayName("Check getters for a single city")
    void checkGetters() {
        System.out.println("Rain 1H: "+cityDTO.getRainDTO().getOneHourMillis());
        System.out.println("Rain 3H: "+cityDTO.getRainDTO().getThreeHourMillis());

        System.out.println("Snow 1H: "+cityDTO.getSnowDTO().getOneHourMillis());
        System.out.println("Snow 3H: "+cityDTO.getSnowDTO().getThreeHourMillis());

    }

    @Test
    @DisplayName("Test returned values are positive for a single city")
    void testReturnedValuesArePositive() {
        Assertions.assertTrue(cityDTO.getRainDTO().checkValuesArePositive());
        Assertions.assertTrue(cityDTO.getSnowDTO().checkValuesArePositive());
    }

    @Test
    @DisplayName("Test getters function correctly in multi city queries")
    void testGettersFunctionCorrectlyInMultiCityQueries() {
        for (CityDTO currCity:  multipleCityDTO.getCities()){
            System.out.println(currCity.getCityName());
            System.out.println(currCity.getRainDTO().getOneHourMillis());
            System.out.println(currCity.getRainDTO().getOneHourMillis());
            System.out.println(currCity.getSnowDTO().getOneHourMillis());
            System.out.println(currCity.getSnowDTO().getThreeHourMillis());
        }
        
    }

    @Test
    @DisplayName("Test all values are positive or null")
    void testAllValuesArePositiveOrNull() {
        for (CityDTO currCity:  multipleCityDTO.getCities()){
            Assertions.assertTrue(currCity.getRainDTO().checkValuesArePositive());
            Assertions.assertTrue(currCity.getSnowDTO().checkValuesArePositive());
        }
        
    }


}
