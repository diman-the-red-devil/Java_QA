import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class RestAssuredRequestTests {

    @Test
    public void httpRequestTest() {
        RestAssured
            .given()
                .baseUri("https://restful-booker.herokuapp.com")
            .when()
                // Отправка HTTP запроса
                .request("GET", "/booking")
            .then()
                // Проверка кода статуса ответа
                .statusCode(200);
    }

    @Test
    public void httpGETTest() {
        RestAssured
            .given()
                .baseUri("https://restful-booker.herokuapp.com")
            .when()
                // Отправка HTTP запроса GET
                .get("/booking")
            .then()
                // Проверка кода статуса ответа
               .statusCode(200);
    }

    @Test
    public void httpPOSTTest() {
        String jsonString = "{\r\n" +
                "   \"username\" : \"admin\",\r\n" +
                "   \"password\" : \"password123\"\r\n" +
                "}";

        RestAssured
            .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .body(jsonString)
            .when()
                // Отправка HTTP запроса POST
                .post("/auth")
            .then()
                // Проверка кода статуса ответа
                .statusCode(200);
    }

    @Test
    public void httpPUTTest() {
        String jsonString = "{\r\n" +
                "    \"firstname\" : \"John\",\r\n" +
                "    \"lastname\" : \"Johnes\",\r\n" +
                "    \"totalprice\" : 99999,\r\n" +
                "    \"depositpaid\" : true,\r\n" +
                "    \"bookingdates\" : {\r\n" +
                "        \"checkin\" : \"2022-01-01\",\r\n" +
                "        \"checkout\" : \"2024-01-01\"\r\n" +
                "    },\r\n" +
                "    \"additionalneeds\" : \"Breakfast\"\r\n"
                + "}";

        RestAssured
            .given()
                .baseUri("https://restful-booker.herokuapp.com")
                // В cookie нужно вставить токен из предыдущего запроса
                .cookie("token", "9d2a2f311c14b1d")
                .contentType(ContentType.JSON)
                .body(jsonString)
            .when()
                // Отправка HTTP запроса PUT
                .put("/booking/1234")
            .then()
                // Проверка кода статуса ответа
                .statusCode(200);
    }

    @Test
    public void httpPATCHTest() {
        String jsonString = "{\r\n" +
            "    \"firstname\" : \"John\",\r\n" +
            "    \"lastname\" : \"Johnes\"\r\n" +
            "}";

        RestAssured
            .given()
                .baseUri("https://restful-booker.herokuapp.com")
                // В cookie нужно вставить токен из предыдущего запроса
                .cookie("token", "e88375c0fde687a")
                .contentType(ContentType.JSON)
                .body(jsonString)
            .when()
                // Отправка HTTP запроса PATCH
                .patch("/booking/1234")
            .then()
                // Проверка кода статуса ответа
                .statusCode(200);
    }

    @Test
    public void httpDELETETest() {
        RestAssured
            .given()
                .baseUri("https://restful-booker.herokuapp.com")
                // В cookie нужно вставить токен из предыдущего запроса
                .cookie("token", "e88375c0fde687a")
            .when()
                // Отправка HTTP запроса DELETE
                .delete("/booking/1234")
            .then()
                // Проверка кода статуса ответа
                .statusCode(200);

        RestAssured
            .given()
                .baseUri("https://restful-booker.herokuapp.com")
            .when()
                // Отправка HTTP запроса GET
                .get("/booking/1234")
            .then()
                // Проверка кода статуса ответа
                .statusCode(404);
    }
}
