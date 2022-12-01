import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Sample {

    @Test
    public void restTest1() {
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api/");
        request.basePath("/character");
        request.accept(ContentType.JSON);
        request.queryParam("name","Rick Sanchez");

        Response response = request.request("GET");
        long timeIn  = response.timeIn(TimeUnit.MILLISECONDS);
        System.out.println("timeIn: " + timeIn);
    }

    @Test
    public void restTest2() {
        RequestSpecification rqstSpec = new RequestSpecBuilder()
                .setBaseUri()
                .setBasePath();
        rqstSpec.accept(ContentType.JSON);
        rqstSpec.queryParam("name","Rick Sanchez")
                .log().method()
                .log().params();

        ResponseSpecification rspsSpec = rqstSpec.response();
        rspsSpec.statusCode(200);
        rspsSpec.request().request("GET","/character");
    }
}
