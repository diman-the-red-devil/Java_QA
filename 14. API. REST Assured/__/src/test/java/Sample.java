import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;

public class Sample {

    @Test
    public void test0() {
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api");
        request.basePath("/character");
        request.queryParam("name","Rick Sanchez");

        Response response = request.get();
        response.prettyPrint();
    }

    @Test
    public void test1() {
        ResponseSpecification response = RestAssured.expect();
        response.statusCode(500);

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api");
        request.basePath("/character");
        request.queryParam("name","Rick Sanchez");

        request.get().then().spec(response);
    }

    @Test
    public void test2() {
        ResponseSpecification response = RestAssured.expect();
        response.
        response.statusCode(500);

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api");
        request.basePath("/character");
        request.queryParam("name","Rick Sanchez");

        request.get().then().spec(response);
    }
}
