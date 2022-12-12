import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
public class RestAssuredResponseTests {

    @Test
    public void responseOutputTest() {
        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api/");
        request.queryParam("name","Rick Sanchez");
        // Response - класс, хранящий ответ запроса
        Response response = request.get("/character");
        // Вывод в консоль в не отфоратированном виде
        response.peek();
        // Вывод в консоль в отфоратированном виде
        response.prettyPeek();
        // Вывод в консоль в не отфоратированном виде и возврат в виде строки
        String printString = response.print();
        System.out.println("\r\nprintString: " + printString);
        // Вывод в консоль в отфоратированном виде и возврат в виде строки
        String prettyPrintString = response.prettyPrint();
        System.out.println("\r\nprettyPrintString: " + prettyPrintString);
        // Проверка кода статуса ответа
        request.then().statusCode(200);
    }

    @Test
    public void responseExtractBodyTest() {
        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api/");
        request.queryParam("name","Rick Sanchez");
        // Response - класс, хранящий ответ запроса
        Response response = request.get("/character");
        String name = response.path("results[0].name");
        System.out.println("name: " + name);
        // Проверка кода статуса ответа
        request.then().statusCode(200);
    }

    @Test
    public void responseGetBodyDataTest() {
        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api/");
        request.queryParam("name","Rick Sanchez");
        // Response - класс, хранящий ответ запроса
        Response response = request.get("/character");
        String asPrettyString = response.asPrettyString();
        System.out.println("asPrettyString: " + asPrettyString);
        // Проверка кода статуса ответа
        request.then().statusCode(200);
    }

    @Test
    public void responseGetHeadersTest() {
        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api/");
        request.queryParam("name","Rick Sanchez");
        // Response - класс, хранящий ответ запроса
        Response response = request.get("/character");
        String contentType  = response.header("Content-Type");
        System.out.println("Content-Type: " + contentType);
        String date  = response.header("Date");
        System.out.println("Date: " + date);
        String transferEncoding  = response.header("Transfer-Encoding");
        System.out.println("Transfer-Encoding: " + transferEncoding);
        // Проверка кода статуса ответа
        request.then().statusCode(200);
    }

    @Test
    public void responseGetBodyTest() {
        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api/");
        request.queryParam("name","Rick Sanchez");
        // Response - класс, хранящий ответ запроса
        Response response = request.get("/character");
        ResponseBody body = response.body();
        System.out.println("body: " + body.asPrettyString());
        // Проверка кода статуса ответа
        request.then().statusCode(200);
    }

    @Test
    public void responseGetCookiesTest() {
        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api/");
        request.queryParam("name","Rick Sanchez");
        // Response - класс, хранящий ответ запроса
        Response response = request.get("/character");
        String cookie = response.cookie("Cookie 1");
        System.out.println("cookie: " + cookie);
        // Проверка кода статуса ответа
        request.then().statusCode(200);
    }

    @Test
    public void responseGetStatusTest() {
        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api/");
        request.queryParam("name","Rick Sanchez");
        // Response - класс, хранящий ответ запроса
        Response response = request.get("/character");
        int statusCode  = response.statusCode();
        System.out.println("statusCode: " + statusCode);
        String statusLine  = response.statusLine();
        System.out.println("statusLine: " + statusLine);
        // Проверка кода статуса ответа
        request.then().statusCode(200);
    }

    @Test
    public void responseGetTimeTest() {
        // RequestSpecification - класс спецификация запроса
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://rickandmortyapi.com/api/");
        request.queryParam("name","Rick Sanchez");
        // Response - класс, хранящий ответ запроса
        Response response = request.get("/character");
        long time  = response.time();
        System.out.println("time: " + time);
        long timeInMSs  = response.timeIn(TimeUnit.MILLISECONDS);
        System.out.println("timeIn MILLISECONDS: " + timeInMSs);
        long timeInSs  = response.timeIn(TimeUnit.SECONDS);
        System.out.println("timeIn SECONDS: " + timeInSs);
        long timeInMs  = response.timeIn(TimeUnit.MINUTES);
        System.out.println("timeIn MINUTES: " + timeInMs);
        // Проверка кода статуса ответа
        request.then().statusCode(200);
    }
}
