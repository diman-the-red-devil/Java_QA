import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class RestAssuredSpecsTest {
    @Test
    public void requestSpecTest() {
        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com");
        request.basePath("/api");
        request.pathParam("method", "character");
        request.queryParam("name","Rick Sanchez");
        request.header("name", "Rick Sanchez");
        request.cookie("name", "Rick Sanchez");
        request.log().method();
        request.log().uri();
        request.log().params();
        request.log().headers();
        request.log().cookies();
        // Response - класс, хранящий ответ запроса
        Response response = request.get("{method}");
        response.prettyPrint();
        // Проверка кода статуса ответа
        request.then().statusCode(200);
    }

    @Test
    public void responseSpecTest() {
        // RequestSpecification - класс спецификация ответа
        ResponseSpecification response = RestAssured.expect();
        response.logDetail(LogDetail.ALL);
        response.header("Content-Type","application/json; charset=utf-8");
        response.statusCode(200);
        response.statusLine("HTTP/1.1 200 OK");
        response.rootPath("results[0]");
        response.body("name", equalTo("Rick Sanchez"));
        response.time( lessThan(10L), TimeUnit.DAYS);

        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api");
        request.queryParam("name","Rick Sanchez");
        request.log().method();
        request.log().uri();
        request.log().params();

        // Проверка ответа
        request.get("/character").then().spec(response);
    }
}
