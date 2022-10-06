package openweatherapi;

import io.restassured.RestAssured;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;

@Execution(ExecutionMode.CONCURRENT)
public class OpenWeatherApiTest {

    private final String URL = "https://api.openweathermap.org/data/2.5/";
    private final String API_KEY = "&appid=f67ddf38159a94a1f1247b7c8c7cdf00";


    @ParameterizedTest
    @MethodSource("getDataForDetectLocation")
    public void detectLocation(String lat, String lon, String expectedCity) {
        RestAssured
                .given()
                .log().uri()
                .when()
                .get(URL + "weather?lat=LAT&lon=LON".replace("LAT", lat).replace("LON", lon) + API_KEY)
                .then()
                .log().body()
                .log().status()
                .assertThat().statusCode(200).and().body("name", equalTo(expectedCity));


    }

    public static Stream<Arguments> getDataForDetectLocation() {
        return Stream.of(
                Arguments.of("48.708048", "44.513303", "Volgograd")
        );
    }

    @ParameterizedTest
    @MethodSource("getInvalidDataForDetectLocation")
    public void detectLocationByInvalidData(String lat, String lon) {
        RestAssured
                .given()
                .log().uri()
                .when()
                .get(URL + "weather?lat=LAT&lon=LON".replace("LAT", lat).replace("LON", lon) + API_KEY)
                .then()
                .log().body()
                .log().status()
                .assertThat().statusCode(400);


    }


    public static Stream<Arguments> getInvalidDataForDetectLocation() {
        return Stream.of(
                Arguments.of("1000", "1000")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForGetTemperatureByCityName")
    public void getTemperatureByCityName(String cityName) {
        RestAssured
                .given()
                .log().uri()
                .when()
                .get(URL + "weather?q={city name}".replace("{city name}", cityName) + API_KEY)
                .then()
                .log().body()
                .log().status()
                .assertThat().statusCode(200).and().body("main.temp", not(nullValue()));


    }


    public static Stream<Arguments> dataForGetTemperatureByCityName() {
        return Stream.of(
                Arguments.of("Volgograd")
        );
    }

}
