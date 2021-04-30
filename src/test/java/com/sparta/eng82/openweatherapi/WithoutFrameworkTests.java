package com.sparta.eng82.openweatherapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import com.sparta.eng82.openweatherapi.framework.EndPoint;
import com.sparta.eng82.openweatherapi.framework.Injector;
import com.sparta.eng82.openweatherapi.framework.dto.CityDTOImpl;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.SystemValuesDTO;
import org.junit.jupiter.api.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class WithoutFrameworkTests {

    static CityDTO cityDTOMemphis;
    static SystemValuesDTO systemValuesDTO;
    static String apiKey;

    @BeforeAll
    static void init() {
        // Without framework - 13 lines of code
        try (InputStream input = new FileInputStream("src/test/resources/application.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            apiKey = prop.getProperty("api.key");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            cityDTOMemphis = objectMapper.readValue(
                    new URL("https://api.openweathermap.org/data/2.5/weather?q=Memphis&appid=" + apiKey),
                    CityDTOImpl.class);
        } catch (IOException e) {
            e.printStackTrace();
        }



        // With framework - 1/2 lines of code
        systemValuesDTO = ((CityDTO) Injector.injectDTO(
                ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "london"))).getSystemValuesDTO();
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
            Assertions.assertTrue(cityDTOMemphis.doWeatherIconIdsMatchDescriptionForEnglish());
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
