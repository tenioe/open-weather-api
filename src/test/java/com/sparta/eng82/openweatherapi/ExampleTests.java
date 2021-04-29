package com.sparta.eng82.openweatherapi;

import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import com.sparta.eng82.openweatherapi.framework.EndPoint;
import com.sparta.eng82.openweatherapi.framework.Injector;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.MultipleCityDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.SystemValuesDTO;
import org.junit.jupiter.api.*;

public class ExampleTests {

    static CityDTO cityDTOMemphis;
    static CityDTO cityDTONashville;
    static CityDTO cityDTOLondon;

    static MultipleCityDTO multipleCityDTOBbox;
    static MultipleCityDTO multipleCityDTOCircle1;
    static MultipleCityDTO multipleCityDTOCircle2;

    static SystemValuesDTO systemValuesDTO;

    @BeforeAll
    static void init() {
        cityDTOMemphis = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "Memphis"));
        cityDTONashville = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "Nashville"));
        cityDTOLondon = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "London"));

        multipleCityDTOBbox = Injector.injectDTO((ConnectionManager.getConnection(EndPoint.BY_BBOX, "12,32,15,37,10")));
        multipleCityDTOCircle1 = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CIRCLE, "5", "5", "5"));
        multipleCityDTOCircle2 = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CIRCLE, "64", "-16", "10"));

        systemValuesDTO = ((CityDTO) Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "london"))).getSystemValuesDTO();

    }

    @Nested
    class CloudDTOTests {
        @Nested
        @DisplayName("Tests for single city responses")
        class TestingResponsesForSingleCities {
            @Test
            @DisplayName("Check the cloud coverage is between 0 and 100")
            void checkTheCloudCoverageIsBetween0And100() {
                Assertions.assertTrue(cityDTOMemphis.getCloudDTO().isBetween0and100());
                System.out.println(cityDTOMemphis.getCloudDTO().getCloudCoverage());
            }
        }

        @Nested
        @DisplayName("Tests for multiple city responses")
        class TestingMultipleCityResponses {
            @Test
            @DisplayName("Check multiple cities cloud coverages are between 0 and 100")
            void checkMultipleCitiesCloudCoveragesAreBetween0And100() {
                for (CityDTO city : multipleCityDTOBbox.getCities()) {
                    Assertions.assertTrue(city.getCloudDTO().isBetween0and100());
                }
            }
        }
    }

    @Nested
    class CoordinatesDTOTests {
        @Nested
        @DisplayName("Check that values are valid for single city")
        class checkThatValuesAreValidForSingleCity {
            @Test
            @DisplayName("Check if Longitude is between -180 and 180")
            void checkIfLongitudeIsBetween180And180() {
                Assertions.assertTrue(cityDTOMemphis.getCoordinatesDTO().isLongitudeBetweenNegative180and180());
                Assertions.assertTrue(multipleCityDTOCircle1.getCities().get(0).getCoordinatesDTO().isLongitudeBetweenNegative180and180());

            }

            @Test
            @DisplayName("Check if Latitude is between -90 and 90")
            void checkIfLatitudeIsBetween90And90() {
                Assertions.assertTrue(cityDTOMemphis.getCoordinatesDTO().isLatitudeBetweenNegative90and90());
            }
        }

        @Nested
        @DisplayName("Check that values are valid for multiple city")
        class checkThatValuesAreValidForMultipleCity {
            @Test
            @DisplayName("Check if Longitude is between -180 and 180")
            void checkIfLongitudeIsBetween180And180() {
                Assertions.assertTrue(multipleCityDTOCircle1.getCities().get(0).getCoordinatesDTO().isLongitudeBetweenNegative180and180());
            }

            @Test
            @DisplayName("Check if Latitude is between -90 and 90")
            void checkIfLatitudeIsBetween90And90() {
                Assertions.assertTrue(multipleCityDTOCircle1.getCities().get(0).getCoordinatesDTO().isLatitudeBetweenNegative90and90());
            }
        }
    }

    @Nested
    class MainConditionsDTOTests {
        @Nested
        @DisplayName("Check that values are valid for single city")
        class checkThatValuesAreValidForSingleCity {

            @Test
            @DisplayName("Check if max temperature is greater than min temperature")
            void checkIfMaxTemperatureIsGreaterThanMinTemperature() {
                Assertions.assertTrue(cityDTOMemphis.getMainConditionsDTO().maxTempGreaterThanMinTemp());
            }

            @Test
            @DisplayName("Check if humidity between 0 and 100")
            void checkIfHumidityBetween0And100() {
                Assertions.assertTrue(cityDTOMemphis.getMainConditionsDTO().humidityBetween0and100());
            }

            @Test
            @DisplayName("Check if all temperatures are greater than 0")
            void checkIfAllTemperaturesAreGreaterThan0() {
                Assertions.assertTrue(cityDTOMemphis.getMainConditionsDTO().tempGreaterThanZeroK());
            }
        }

        @Nested
        @DisplayName("Check that values are valid for multiple city")
        class checkThatValuesAreValidForMultipleCity {

            @Test
            @DisplayName("Check if max temperature is greater than min temperature")
            void checkIfMaxTemperatureIsGreaterThanMinTemperature() {
                Assertions.assertTrue(multipleCityDTOCircle1.getCities().get(0).getMainConditionsDTO().maxTempGreaterThanMinTemp());
            }

            @Test
            @DisplayName("Check if humidity between 0 and 100")
            void checkIfHumidityBetween0And100() {
                Assertions.assertTrue(multipleCityDTOCircle1.getCities().get(0).getMainConditionsDTO().humidityBetween0and100());
            }

            @Test
            @DisplayName("Check if all temperatures are greater than 0")
            void checkIfAllTemperaturesAreGreaterThan0() {
                Assertions.assertTrue(multipleCityDTOCircle1.getCities().get(0).getMainConditionsDTO().tempGreaterThanZeroK());
            }
        }
    }

    @Nested
    class PrecipitationDTOTests {
        @Test
        @DisplayName("Check getters for a single city")
        void checkGetters() {
            System.out.println("Rain 1H: " + cityDTONashville.getRainDTO().getOneHourMillis());
            System.out.println("Rain 3H: " + cityDTONashville.getRainDTO().getThreeHourMillis());
            System.out.println("Snow 1H: " + cityDTONashville.getSnowDTO().getOneHourMillis());
            System.out.println("Snow 3H: " + cityDTONashville.getSnowDTO().getThreeHourMillis());
        }

        @Test
        @DisplayName("Test returned values are positive for a single city")
        void testReturnedValuesArePositive() {
            Assertions.assertTrue(cityDTONashville.getRainDTO().checkValuesArePositive());
            Assertions.assertTrue(cityDTONashville.getSnowDTO().checkValuesArePositive());
        }

        @Test
        @DisplayName("Test getters function correctly in multi city queries")
        void testGettersFunctionCorrectlyInMultiCityQueries() {
            for (CityDTO currCity : multipleCityDTOCircle2.getCities()) {
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
            for (CityDTO currCity : multipleCityDTOCircle2.getCities()) {
                Assertions.assertTrue(currCity.getRainDTO().checkValuesArePositive());
                Assertions.assertTrue(currCity.getSnowDTO().checkValuesArePositive());
            }
        }
    }

    @Nested
    class SystemValueDTOTests {
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

    @Nested
    class WeatherDTOTests {
        @Test
        @DisplayName("Check all weather ids match groups")
        void checkAllWeatherIdsMatchGroups() {
            Assertions.assertTrue(cityDTOMemphis.doWeatherIdsMatchGroup());
        }

        @Test
        @DisplayName("Check all weather icon ids match descriptions")
        void checkAllWeatherIconIdsMatchDescriptions() {
            Assertions.assertTrue(cityDTOMemphis.doWeatherIconIdsMatchDescription());
        }

        @Test
        @DisplayName("Check all weather ids match descriptions")
        void checkAllWeatherIdsMatchDescriptions() {
            Assertions.assertTrue(cityDTOMemphis.doWeatherIdsMatchDescription());
        }

        @Test
        @DisplayName("Check all weather ids are not null")
        void checkAllWeatherIdsAreNotNull() {
            Assertions.assertTrue(cityDTOMemphis.areWeatherIdsNotNull());
        }

        @Test
        @DisplayName("Check all weather groups are not null")
        void checkAllWeatherGroupsAreNotNull() {
            Assertions.assertTrue(cityDTOMemphis.areWeatherGroupsNotNull());
        }

        @Test
        @DisplayName("Check all weather descriptions are not null")
        void checkAllWeatherDescriptionsAreNotNull() {
            Assertions.assertTrue(cityDTOMemphis.areWeatherGroupsNotNull());
        }

        @Test
        @DisplayName("Check all weather icon ids are not null")
        void checkAllWeatherIconIdsAreNotNull() {
            Assertions.assertTrue(cityDTOMemphis.areWeatherIconIdsNotNull());
        }

        @Test
        @DisplayName("Check all weather ids are integers")
        void checkAllWeatherIdsAreIntegers() {
            Assertions.assertTrue(cityDTOMemphis.areWeatherIdsIntegers());
        }

        @Test
        @DisplayName("Check all weather groups are strings")
        void checkAllWeatherGroupsAreStrings() {
            Assertions.assertTrue(cityDTOMemphis.areWeatherGroupsStrings());
        }

        @Test
        @DisplayName("Check all weather descriptions are strings")
        void checkAllWeatherDescriptionsAreStrings() {
            Assertions.assertTrue(cityDTOMemphis.areWeatherDescriptionsStrings());
        }

        @Test
        @DisplayName("Check all weather icon ids are strings")
        void checkAllWeatherIconIdsAreStrings() {
            Assertions.assertTrue(cityDTOMemphis.areWeatherIconIdsStrings());
        }
    }

    @Nested
    class WindDTOTests {
        @Test
        @DisplayName("Is speed greater than zero")
        void isSpeedGreaterThanZero() {
            Assertions.assertTrue(cityDTOLondon.getWindDTO().isSpeedGreaterThanZero());
        }

        @Test
        @DisplayName("Is gust greater than zero")
        void isGustGreaterThanZero() {
            Assertions.assertTrue(cityDTOLondon.getWindDTO().isGustGreaterThanZero());
        }

        @Test
        @DisplayName("Is degree between 0 and 360")
        void isDegreeBetween0And360() {
            Assertions.assertTrue(cityDTOLondon.getWindDTO().isDegreeBetween0And360());
        }
    }
}
