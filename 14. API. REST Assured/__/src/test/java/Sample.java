import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Sample {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://rickandmortyapi.com/api/";
    }

    @Test
    public void restTest() {
        RequestSpecification request = RestAssured.given();
        request.accept(ContentType.JSON);
        request.queryParam("name","Rick Sanchez");

        Response response = request.request("GET","/character");
        String print  = response.prettyPrint();
    }

    @Test
    public void rest2Test() {
        RestAssured
                .given()
                .accept(ContentType.JSON)
                .queryParam("name","Rick Sanchez")
                .when()
                .request("GET","/character")
                .prettyPeek()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}
