import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import com.sparta.eng82.openweatherapi.framework.EndPoint;
import com.sparta.eng82.openweatherapi.framework.Injector;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.CityDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WindDTOTests {
    static CityDTO cityDTO;


    @BeforeAll
    static void init() {
        cityDTO = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "London"));

    }

    @Test
    @DisplayName("Is speed greater than zero")
    void isSpeedGreaterThanZero(){
        Assertions.assertTrue(cityDTO.getWindDTO().getSpeed());
    }

    @Test
    @DisplayName("Is gust greater than zero")
    void isGustGreaterThanZero(){
        Assertions.assertTrue(cityDTO.getWindDTO().getDegree());
    }

    @Test
    @DisplayName("Is gust greater than zero")
    void isDegreeBetween0And360(){
        Assertions.assertTrue(cityDTO.getWindDTO().isDegreeBetween0And360());
    }

}
