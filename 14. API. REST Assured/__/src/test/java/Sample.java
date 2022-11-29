import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Sample {

    @Test
    public void restTest1() {
        String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON)
                .setBody(jsonString)
                .build();

        Response response = RestAssured.post("/auth");
        response.prettyPrint();
    }

    @Test
    public void restTest2() {
        String jsonString = "{\r\n" +
                "    \"firstname\" : \"Amod\",\r\n" +
                "    \"lastname\" : \"Mahajan\"}";

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/booking/1")
                .cookie("token", "6608dc75eedd44f")
                .contentType(ContentType.JSON)
                .body(jsonString)
                .when()
                .patch()
                .then()
                .assertThat()
                .statusCode(200)
                .body("firstname", Matchers.equalTo("Amod"))
                .body("lastname", Matchers.equalTo("Mahajan"));
    }
}
