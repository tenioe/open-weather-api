package com.sparta.eng82.openweatherapi.framework.dto.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.WeatherDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeatherDTOImpl implements WeatherDTO {

    @JsonProperty("id")
    private Integer weatherId;
    @JsonProperty("main")
    private String weatherGroup;
    @JsonProperty("description")
    private String weatherDescription;
    @JsonProperty("icon")
    private String weatherIcon;

    public WeatherDTOImpl() {
    }

    @Override
    public int getWeatherId() {
        return weatherId;
    }

    @Override
    public String getWeatherGroup() {
        return weatherGroup;
    }

    @Override
    public String getWeatherDescription() {
        return weatherDescription;
    }

    @Override
    public String getWeatherIconId() {
        return weatherIcon;
    }

    @Override
    public boolean checkWeatherIdMatchesGroup() {
        return matchTwoValues("src/test/resources/weather_conditions.csv", weatherId.toString(), weatherGroup, 1);
    }

    @Override
    public boolean checkWeatherIdMatchesDescription() {
        return matchTwoValues("src/test/resources/weather_conditions.csv", weatherId.toString(), weatherDescription, 2);
    }

    @Override
    public boolean checkWeatherIconMatchesDescription() {
        return matchTwoValuesTwoCsv("src/test/resources/weather_icons.csv", "src/test/resources/weather_conditions.csv", weatherIcon, weatherDescription);
    }

    private boolean matchTwoValuesTwoCsv(String firstFilePath, String secondFilePath, String findFirst, String matchSecond) {
        for (List<String> firstRow : readCsvFileIntoArray(firstFilePath)) {
            for (String firstEntry : firstRow) {
                if (firstEntry.equals(findFirst)) {
                    for (List<String> secondRow : readCsvFileIntoArray(secondFilePath)) {
                        for (String secondEntry : secondRow) {
                            if (secondEntry.toLowerCase().equals(matchSecond)) {
                                if (secondRow.get(3).equals(firstEntry)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean matchTwoValues(String filePath, String findValue, String matchValue, int index) {
        for (List<String> row : readCsvFileIntoArray(filePath)) {
            for (String entry : row) {
                if (entry.equals(findValue)) {
                    if (row.get(index).equals(matchValue)) {
                        return true;
                    }
                }
            }
        }
        return false;
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
}