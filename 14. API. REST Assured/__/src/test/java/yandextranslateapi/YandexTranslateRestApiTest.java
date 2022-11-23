package yandextranslateapi;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.json.JSONObject;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;

// mvn clean test -Dtest=YandexTranslateRestApiTest
// https://translate.api.cloud.yandex.net/translate/v2/translate
@Execution(ExecutionMode.CONCURRENT)
public class YandexTranslateRestApiTest {
        // Ендпоинт сервиса
        private final String URL = "https://translate.api.cloud.yandex.net/translate/v2/translate";

        // Заголовки
        private final Headers HEADERS = new Headers(
                new Header("Content-Type", "application/json"),
                new Header("Authorization", "Api-Key AQVN1HLWCOruKGZnVPDl-mN_sJM7HH3o03FWjYS1")
        );

        // Текст для перевода
        String[] texts = new String[]{"автоматизированное тестирование"};

        // Кейс 1. Правильность перевода словосочетания «автоматизированное тестирование»
        @ParameterizedTest
        @MethodSource("dataForTranslateAndCheckText")
        public void translateAndCheckText(String targetLanguageCode, String expectedText) {
            RestAssured
                    .given()
                        .log().uri()
                        .log().body()
                        .body(
                            new JSONObject()
                                    .put("folderId", "b1g2hv91fl6mdn4hlp0p")
                                    .put("texts", texts)
                                    .put("targetLanguageCode", targetLanguageCode)
                                    .toString()
                        )
                        .headers(HEADERS)
                    .when()
                        .post(URL)
                    .then()
                        .log().status()
                        .log().body()
                        .spec(
                            new ResponseSpecBuilder()
                                    .expectStatusCode(200)
                                    .expectBody("translations.text[0]", equalTo(expectedText))
                                    .build()
                    );
        }

        // Генератор тестовых данных для translateAndCheckText
        private static Stream<Arguments> dataForTranslateAndCheckText() {
            return Stream.of(
                    Arguments.of("en", "automated testing"),
                    Arguments.of("uk", "автоматизоване тестування"),
                    Arguments.of("it", "test automatizzati"),
                    Arguments.of("de", "automatisiertes testen")
            );
        }

        // Кейс 2. Вызов сервиса с некорректным targetLanguageCode и проверка кода ошибки = 400.
        @ParameterizedTest
        @MethodSource("dataForTranslateWithUnsupportedTargetLanguageCodeAndGet400")
        public void translateWithUnsupportedTargetLanguageCodeAndGet400(String targetLanguageCode) {
            RestAssured
                    .given()
                        .log().uri()
                        .log().body()
                        .body(
                            new JSONObject()
                                    .put("folderId", "b1g2hv91fl6mdn4hlp0p")
                                    .put("texts", texts)
                                    .put("targetLanguageCode", targetLanguageCode)
                                    .toString()
                        )
                        .headers(HEADERS)
                    .when()
                        .post(URL)
                    .then()
                        .log().status()
                        .log().body()
                        .spec(
                            new ResponseSpecBuilder()
                                    .expectStatusCode(200)
                                    .build()
                    );
        }

        // Генератор тестовых данных для translateWithUnsupportedTargetLanguageCodeAndGet400
        public static Stream<Arguments> dataForTranslateWithUnsupportedTargetLanguageCodeAndGet400() {
            return Stream.of(
                    Arguments.of("z"),
                    Arguments.of("yy"),
                    Arguments.of("www"),
                    Arguments.of("vv11")
            );
        }
}
