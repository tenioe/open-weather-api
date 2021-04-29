package com.sparta.eng82.openweatherapi;

import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import com.sparta.eng82.openweatherapi.framework.EndPoint;
import com.sparta.eng82.openweatherapi.framework.Injector;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.SystemValuesDTO;
import org.junit.jupiter.api.*;

public class SystemValuesDTOTests {
    private static SystemValuesDTO systemValuesDTO;

    @BeforeAll
    static void beforeAll() {
        systemValuesDTO = ((CityDTO) Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "london"))).getSystemValuesDTO();
    }

    @Nested
    @DisplayName("Check values are not null")
    class ValuesNotNull {
        @Test
        @DisplayName("Check id is not null")
        void checkIdIsNotNull() {
            Assertions.assertNotNull(systemValuesDTO.getID());
        }

        @Test
        @DisplayName("Check country is not null")
        void checkCountryIsNotNull() {
            Assertions.assertNotNull(systemValuesDTO.getCountry());
        }

        @Test
        @DisplayName("Check sunrise is not null")
        void checkSunriseIsNotNull() {
            Assertions.assertNotNull(systemValuesDTO.getSunrise());
        }

        @Test
        @DisplayName("Check sunset is not null")
        void checkSunsetIsNotNull() {
            Assertions.assertNotNull(systemValuesDTO.getSunset());
        }
    }

    @Nested
    @DisplayName("Check values are correct type")
    class ValuesCorrectType {
        @Test
        @DisplayName("Check id is Integer")
        void checkIdIsInteger() {
            Assertions.assertEquals(Integer.class, systemValuesDTO.getID().getClass());
        }

        @Test
        @DisplayName("Check country is String")
        void checkCountryIsString() {
            Assertions.assertEquals(String.class, systemValuesDTO.getCountry().getClass());
        }

        @Test
        @DisplayName("Check sunrise is Integer")
        void checkSunriseIsInteger() {
            Assertions.assertEquals(Integer.class, systemValuesDTO.getSunrise().getClass());
        }

        @Test
        @DisplayName("Check sunset is Integer")
        void checkSunsetIsInteger() {
            Assertions.assertEquals(Integer.class, systemValuesDTO.getSunset().getClass());
        }
    }

    @Nested
    @DisplayName("Check values are valid")
    class ValuesAreValid {
        @Test
        @DisplayName("Check sunrise is before sunset")
        void checkSunriseBeforeSunset() {
            Assertions.assertTrue(systemValuesDTO.isSunriseBeforeOrEqualToSunset());
        }

        @Test
        @DisplayName("Check country length is 2")
        void checkCountryLengthIs2() {
            Assertions.assertTrue(systemValuesDTO.isCountryLength2());
        }

        @Test
        @DisplayName("Check country is upper case")
        void checkCountryIsUpperCase() {
            Assertions.assertTrue(systemValuesDTO.isCountryUpperCase());
        }
    }
}
