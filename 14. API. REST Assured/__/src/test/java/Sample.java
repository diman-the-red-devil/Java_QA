import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Sample {


    @Test
    public void restTest() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com/auth")
                .setBody("{\"username\" : \"admin\",\"password\" : \"password123\"}")
                .setContentType(ContentType.JSON).build();
        Response response = RestAssured.post();
        response.prettyPrint();
    }
}
