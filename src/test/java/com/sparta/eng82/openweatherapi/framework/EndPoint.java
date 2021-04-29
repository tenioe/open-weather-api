package com.sparta.eng82.openweatherapi.framework;

public enum EndPoint {

    BASE_URL("api.openweathermap.org/data/2.5/"),
    BY_CITY_NAME("weather?q={city name},{state code},{country code}"),
    BY_CIT_ID("weather?id={city id}"),
    BY_COORDS("weather?lat={lat}&lon={lon}"),
    BY_ZIP("weather?zip={zip code},{country code}"),
    BY_BBOX("box/city?bbox={bbox}"),
    BY_CIRCLE("find?lat={lat}&lon={lon}&cnt={cnt}");

    private final String url;

    EndPoint(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
