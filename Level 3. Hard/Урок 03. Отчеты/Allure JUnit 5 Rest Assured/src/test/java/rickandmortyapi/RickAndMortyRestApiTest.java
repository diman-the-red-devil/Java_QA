package rickandmortyapi;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;

// mvn clean test -Dtest=RickAndMortyRestApiTest
// https://rickandmortyapi.com/
@Execution(ExecutionMode.CONCURRENT)
public class RickAndMortyRestApiTest {
    // Ендпоинт сервиса
    private final String URL = "https://rickandmortyapi.com/api/character/";

    // Кейс 1. Получение данных персонажа по его имени и проверка имени в body
    @ParameterizedTest
    @MethodSource("dataForGetCharacterByNameAndCheckName")
    public void getCharacterByNameAndCheckName(String name, String expectedName) {
        RestAssured
                .given()
                    .log().uri()
                .when()
                    .get(URL + "?name=" + name)
                .then()
                    .log().status()
                    .log().body()
                    .spec(
                        new ResponseSpecBuilder()
                                .expectStatusCode(200)
                                .expectBody("results[0].name", equalTo(expectedName))
                                .build()
                );
    }

    // Генератор тестовых данных для getCharacterByNameAndCheckName
    private static Stream<Arguments> dataForGetCharacterByNameAndCheckName() {
        return Stream.of(
                Arguments.of("Rick Sanchez", "Rick Sanchez"),
                Arguments.of("Morty Smith", "Morty Smith")
        );
    }

    // Кейс 2. Получение данных персонажа по его имени и проверка статуса в body
    @ParameterizedTest
    @MethodSource("dataForGetCharacterByNameAndCheckStatus")
    public void getCharacterByNameAndCheckStatus(String name, String expectedStatus) {
        RestAssured
                .given()
                .log().uri()
                .when()
                .get(URL + "?name=" + name)
                .then()
                .log().status()
                .log().body()
                .spec(
                        new ResponseSpecBuilder()
                                .expectStatusCode(200)
                                .expectBody("results[0].status", equalTo(expectedStatus))
                                .build()
                );
    }

    // Генератор тестовых данных для getCharacterByNameAndCheckStatus
    private static Stream<Arguments> dataForGetCharacterByNameAndCheckStatus() {
        return Stream.of(
                Arguments.of("Rick Sanchez", "Alive"),
                Arguments.of("Morty Smith", "Alive")
        );
    }
}
