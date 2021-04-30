package com.sparta.eng82.openweatherapi;

import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import com.sparta.eng82.openweatherapi.framework.EndPoint;
import com.sparta.eng82.openweatherapi.framework.Injector;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.SystemValuesDTO;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WithoutFrameworkTests {

    static CityDTO cityDTOMemphis;
    static SystemValuesDTO systemValuesDTO;


    @BeforeAll
    static void init() {
        cityDTOMemphis = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "Memphis"));
        systemValuesDTO = ((CityDTO) Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "london"))).getSystemValuesDTO();
    }


    @Nested
    class WeatherTestExample {
        private final List<List<String>> weatherConditions;
        private final List<List<String>> weatherIcons;

        {
            weatherConditions = readCsvFileIntoArray("src/test/resources/weather_conditions.csv");
            weatherIcons = readCsvFileIntoArray("src/test/resources/weather_icons.csv");
        }

        // Test example without framework
        @Test
        @DisplayName("Check weather icon id matches description for english without framework")
        void checkWeatherIconIdMatchesDescriptionForEnglishWithoutFramework() {
            boolean matched = false;
            for (List<String> firstRow : weatherIcons) {
                for (String firstEntry : firstRow) {
                    if (firstEntry.equals(cityDTOMemphis.getWeatherDTO().get(0).getWeatherIconId())) {
                        for (List<String> secondRow : weatherConditions) {
                            for (String secondEntry : secondRow) {
                                if (secondEntry.toLowerCase().equals(cityDTOMemphis.getWeatherDTO().get(0).getWeatherDescription())) {
                                    if (secondRow.get(3).equals(firstEntry) || secondRow.get(4).equals(firstEntry)) {
                                        matched = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Assertions.assertTrue(matched);
        }

        private List<List<String>> readCsvFileIntoArray(String filePath) {
            List<List<String>> temp = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] entries = line.split(",");
                    temp.add(Arrays.asList(entries));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return temp;
        }

        // Test example with framework
        @Test
        @DisplayName("checkWeatherIconIdMatchesDescriptionForEnglishWithFramework")
        void checkWeatherIconIdMatchesDescriptionForEnglishWithFramework() {
            // No need to get one station at a time eg. get(0), the framework handles all stations automatically
            Assertions.assertTrue(cityDTOMemphis.doWeatherIconIdsMatchDescription());
        }
    }

    @Nested
    class SystemValueTestExample{
        // Test example without framework
        @Test
        @DisplayName("Check country is upper case without framework")
        void checkCountryIsUpperCaseWithoutFramework() {
            boolean isUpper = true;
            for (Character character : systemValuesDTO.getCountry().toCharArray()){
                if (Character.isLowerCase(character)){
                    isUpper = false;
                    break;
                }
            }
            Assertions.assertTrue(isUpper);
        }
        
        // Test example with framework
        @Test
        @DisplayName("Check country is upper case with framework")
        void checkCountryIsUpperCaseWithFramework() {
            Assertions.assertTrue(systemValuesDTO.isCountryUpperCase());
        }
    }
}
