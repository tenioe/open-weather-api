package com.sparta.eng82.openweatherapi.framework;

public interface ConnectionManager {

    String BASE_URL = "api.openweathermap.org/data/2.5/";

    String BY_CITY_NAME = "weather?q={city name},{state code},{country code}";
    String BY_CITY_ID = "weather?id={city id}";
    String BY_COORDS = "weather?lat={lat}&lon={lon}";
    String BY_ZIP = "weather?zip={zip code},{country code}";

    String BY_BBOX = "box/city?bbox={bbox}";
    String BY_CIRCLE = "find?lat={lat}&lon={lon}&cnt={cnt}";

    String API_KEY = "&appid={API key}";

    String getConnection(String by, String... params);
}
