package com.sparta.eng82.openweatherapi.framework.dto.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.PrecipitationDTO;

public class PrecipitationDTOImpl implements PrecipitationDTO {
    @JsonProperty("1h")
    private Float oneHourMM;   //more readable name
    @JsonProperty("3h")
    private Float twoHourMM;


    @JsonProperty("1h")
    @Override
    public Float getOneHourMM() {
        return oneHourMM;
    }

    @JsonProperty("3h")
    @Override
    public Float getThreeHourMM() {
        return null;
    }

    @Override
    public boolean checkValuesArePositive() {
        boolean areValuesPositive = true;
        if (oneHourMM < 0) {
            areValuesPositive = false;
        }
        if (twoHourMM < 0) {
            areValuesPositive = false;
        }
        return areValuesPositive;
    }
}
