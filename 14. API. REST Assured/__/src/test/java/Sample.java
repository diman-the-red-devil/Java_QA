import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Sample {

    @Test
    public void test1() {
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api");
        request.basePath("/character");
        request.queryParam("name","Rick Sanchez");

        Response response = request.get();
        response.prettyPrint();
    }

    @Test
    public void test2() {
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api");
        request.basePath("/character");
        request.formParams("name", "Rick Sanchez");
        request.log().uri();
        request.log().params();

        Response response = request.get();
        response.prettyPrint();
    }

}
