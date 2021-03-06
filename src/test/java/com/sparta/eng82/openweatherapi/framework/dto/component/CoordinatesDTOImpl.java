package com.sparta.eng82.openweatherapi.framework.dto.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.CoordinatesDTO;

public class CoordinatesDTOImpl implements CoordinatesDTO {

    @JsonProperty("lon")
    private Double longitude;

    @JsonProperty("Lon")
    private Double longitudeBbox;

    @JsonProperty("lat")
    private Double latitude;

    @JsonProperty("Lat")
    private Double latitudeBbox;

    public CoordinatesDTOImpl() {
    }

    @Override
    public Double getLongitude() {
        return longitude == null ? longitudeBbox : longitude;
    }

    @Override
    public Double getLatitude() {
        return latitude == null ? latitudeBbox : latitude;
    }

    @Override
    public boolean isLongitudeBetweenNegative180and180() {
        return longitude >= -180 && longitude <= 180;
    }

    @Override
    public boolean isLatitudeBetweenNegative90and90() {
        return latitude >= -90 && latitude <= 90;
    }


}
