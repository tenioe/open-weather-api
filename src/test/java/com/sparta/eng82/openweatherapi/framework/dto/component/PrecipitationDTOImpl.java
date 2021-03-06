package com.sparta.eng82.openweatherapi.framework.dto.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.PrecipitationDTO;

public class PrecipitationDTOImpl implements PrecipitationDTO {
    @JsonProperty("1h")
    private Float oneHourMillis;

    @JsonProperty("3h")
    private Float threeHourMillis;

    public PrecipitationDTOImpl (){}

    public PrecipitationDTOImpl(float defaultVal){
        this.oneHourMillis = defaultVal;
        this.threeHourMillis = defaultVal;
    }

    @JsonProperty("1h")
    @Override
    public Float getOneHourMillis() {
        return oneHourMillis;
    }

    @JsonProperty("3h")
    @Override
    public Float getThreeHourMillis() {
        return threeHourMillis;
    }

    @Override
    public boolean checkValuesArePositive() {
        boolean areValuesPositive = true;
        if (threeHourMillis !=null && oneHourMillis < 0) {
            areValuesPositive = false;
        }
        if (threeHourMillis != null && threeHourMillis < 0) {
            areValuesPositive = false;
        }
        return areValuesPositive;
    }

    @Override
    public boolean checkThreeHGreaterThanOneH() {
        if (threeHourMillis == null || oneHourMillis == null){
            return true;
        } else {
            return threeHourMillis >= oneHourMillis;
        }
    }
}
