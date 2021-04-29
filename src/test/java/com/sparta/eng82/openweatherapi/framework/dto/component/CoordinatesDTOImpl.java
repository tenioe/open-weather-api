package com.sparta.eng82.openweatherapi.framework.dto.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.CoordinatesDTO;

public class CoordinatesDTOImpl implements CoordinatesDTO {

    @JsonProperty("lon")
    private Double Longitude;
    @JsonProperty("lat")
    private Double Latitude;

    @Override
    public Double getLongitude() {
        return Longitude;
    }

    @Override
    public Double getLatitude() {
        return Latitude;
    }

    @Override
    public boolean isLongitudeBetweenNegative180and180() {
        return Longitude >= -180 && Longitude <= 180;
    }

    @Override
    public boolean isLatitudeBetweenNegative90and90() {
        return Latitude >= -90 && Latitude <= 90;
    }


}
