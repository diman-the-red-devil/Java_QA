package pokeapi;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;

@Execution(ExecutionMode.CONCURRENT)
public class PokeApiTest {

    private final String URL = "https://pokeapi.co/api/v2/";

    @ParameterizedTest
    @MethodSource("dataForGetBerryByNameAndCheckName")
    public void getBerryByNameAndCheckName(String name, String expectedName) {
        RestAssured
                .given()
                .log().uri()
                .when()
                .get(URL + "berry/" + name)
                .then()
                .assertThat().statusCode(200).and().body("name", is(expectedName))
                .log().status()
                .log().body();
    }

    private static Stream<Arguments> dataForGetBerryByNameAndCheckName() {
        return Stream.of(
                Arguments.of("cheri", "cheri"),
                Arguments.of("chesto", "chesto110")
        );
    }

    @ParameterizedTest
    @MethodSource("dataАForGetBerryByContestTypes")
    public void getBerryByContestTypes(String typeName, String expectedType) {
        RestAssured
                .given().log().uri()
                .when().get(URL + "contest-type/" + typeName)
                .then()
                .log().status()
                .log().body()
                .spec(
                        new ResponseSpecBuilder()
                                .expectStatusCode(200)
                                .expectBody("berry_flavor.name", equalTo(expectedType))
                                .build()
                );
    }

    private static Stream<Arguments> dataАForGetBerryByContestTypes() {
        return Stream.of(
                Arguments.of("cool", "spicy"),
                Arguments.of("beauty", "dry11")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForGetBerryByOutOfIndexOrByIncorrectName")
    public void getBerryByOutOfIndexOrByIncorrectName(String failVariable) {
        RestAssured
                .given().log().uri()
                .when().get(URL + "berry/" + failVariable)
                .then()
                .log().status()
                .log().body()
                .spec(
                        new ResponseSpecBuilder()
                                .expectStatusCode(404)
                                .build()
                );
    }

    private static Stream<Arguments> dataForGetBerryByOutOfIndexOrByIncorrectName() {
        return Stream.of(
                Arguments.of("1000"),
                Arguments.of("cherry")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForGetBerryNameInBerryFirmnessesList")
    public void getBerryNameInBerryFirmnessesList(String firmnessesName, String expectedBerry) {
        RestAssured
                .given().log().uri()
                .when().get(URL + "berry-firmness/" + firmnessesName)
                .then()
                .log().status()
                .log().body().assertThat().statusCode(200).and().body("berries[0].name", hasToString(expectedBerry));

    }

    private static Stream<Arguments> dataForGetBerryNameInBerryFirmnessesList() {
        return Stream.of(
                Arguments.of("very-soft", "pecha"),
                Arguments.of("soft", "cheri")
        );
    }
}