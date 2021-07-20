import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v91.browser.Browser;
import org.openqa.selenium.devtools.v91.browser.model.PermissionType;
import org.openqa.selenium.devtools.v91.emulation.Emulation;
import org.openqa.selenium.devtools.v91.fetch.Fetch;
import org.openqa.selenium.devtools.v91.fetch.model.HeaderEntry;
import org.openqa.selenium.devtools.v91.fetch.model.RequestId;
import org.openqa.selenium.devtools.v91.log.Log;
import org.openqa.selenium.devtools.v91.network.Network;
import org.openqa.selenium.devtools.v91.network.model.BlockedReason;
import org.openqa.selenium.devtools.v91.network.model.ConnectionType;
import org.openqa.selenium.devtools.v91.network.model.Headers;
import org.openqa.selenium.devtools.v91.network.model.ResourceType;
import org.openqa.selenium.devtools.v91.performance.Performance;
import org.openqa.selenium.devtools.v91.performance.model.Metric;
import org.apache.commons.codec.binary.Base64;

import java.util.*;
import java.util.stream.Collectors;

public class DevToolsTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(DevToolsTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void browserPermissionsTest() {
        // Доступ к DevTools
        ChromeDriver chrome =  (ChromeDriver) driver;
        DevTools devTools = chrome.getDevTools();
        // Открытие сессии DevTools
        devTools.createSession();
        // Предоставление прав браузеру на выполнение операций
        // Browser.grantPermissions - предоставление прав браузеру
        // Список предоставляемых прав
        List<PermissionType> permissions = new ArrayList<>();
        permissions.add(PermissionType.AUDIOCAPTURE);
        permissions.add(PermissionType.VIDEOCAPTURE);
        permissions.add(PermissionType.GEOLOCATION);
        devTools.send(Browser.grantPermissions(permissions, Optional.empty(), Optional.empty()));

        // Открыть страницу yandex.ru
        chrome.get("https://yandex.ru");
        logger.info("Открыта страница yandex.ru - " + "https://yandex.ru");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрытие сессии DevTools
        devTools.close();
    }

    @Test
    public void browserVersionTest() {
        // Доступ к DevTools
        ChromeDriver chrome =  (ChromeDriver) driver;
        DevTools devTools = chrome.getDevTools();
        // Открытие сессии DevTools
        devTools.createSession();
        // Получение данных о браузере
        // Browser.getVersion - получение данных о версии
        Browser.GetVersionResponse version = devTools.send(Browser.getVersion());
        // Вывод данных о браузере
        logger.info("Browser: " + version.getProduct());
        logger.info("User Agent: " + version.getUserAgent());
        logger.info("JS: " + version.getJsVersion());
        logger.info("Protocol: " + version.getProtocolVersion());

        // Открыть страницу yandex.ru
        chrome.get("https://yandex.ru");
        logger.info("Открыта страница yandex.ru - " + "https://yandex.ru");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрытие сессии DevTools
        devTools.close();
    }

    @Test
    public void emulationSetDeviceMetricsTest() {
        // Доступ к DevTools
        ChromeDriver chrome =  (ChromeDriver) driver;
        DevTools devTools = chrome.getDevTools();
        // Открытие сессии DevTools
        devTools.createSession();
        // Установка параметров эмулируемого устройства
        // Emulation.setDeviceMetricsOverride - установка параметров
        // Параметры эмулируемого устройства
        int width = 600;            // Ширина
        int height = 1000;          // Высота
        int deviceScaleFactor = 50; //
        boolean mobile = true;      // Мобильное устройства
        devTools.send(Emulation.setDeviceMetricsOverride(
                width, height, deviceScaleFactor, mobile,
                Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty())
        );

        // Открыть страницу yandex.ru
        chrome.get("https://yandex.ru");
        logger.info("Открыта страница yandex.ru - " + "https://yandex.ru");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрытие сессии DevTools
        devTools.close();
    }

    @Test
    public void emulationSetGeoLocationTest() {
        // Доступ к DevTools
        ChromeDriver chrome =  (ChromeDriver) driver;
        DevTools devTools = chrome.getDevTools();
        // Открытие сессии DevTools
        devTools.createSession();
        // Установка геолокации
        // Emulation.setGeolocationOverride - установка геолокации
        // Параметры геолокации
        Optional<Number> latitude = Optional.of(50.52930);  // Широта
        Optional<Number> longitude = Optional.of(42.68620); // Долгота
        Optional<Number> accuracy = Optional.of(10);        // Точность
        devTools.send(Emulation.setGeolocationOverride(latitude, longitude, accuracy));

        // Открыть страницу mycurrentlocation.net
        chrome.get("https://mycurrentlocation.net/");
        logger.info("Открыта страница mycurrentlocation.net - " + "https://mycurrentlocation.net/");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрытие сессии DevTools
        devTools.close();
    }

    @Test
    public void logListenerTest() {
        // Доступ к DevTools
        ChromeDriver chrome =  (ChromeDriver) driver;
        DevTools devTools = chrome.getDevTools();
        // Открытие сессии DevTools
        devTools.createSession();
        // Вывод логов
        // Log.enable - включение доступа к логам
        devTools.send(Log.enable());
        // Слушатель
        devTools.addListener(Log.entryAdded(),
            // Вывод логов
            logEntry -> {
                logger.info("Log: " + logEntry.getText());
                logger.info("Level: " + logEntry.getLevel());
            }
        );

        // Открыть страницу yandex.ru
        chrome.get("https://yandex.ru");
        logger.info("Открыта страница yandex.ru - " + "https://yandex.ru");
        // Ввести в строку поиска текст - Selenium
        WebElement input = chrome.findElement(By.xpath("//input[@class=\"input__control input__input mini-suggest__input\"]"));
        input.sendKeys("Selenium");
        // Нажать на кнопку "Найти"
        WebElement button = chrome.findElement(By.xpath("//button[@class=\"button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited\"]"));
        button.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрытие сессии DevTools
        devTools.close();
    }

    @Test
    public void performanceTest() {
        // Доступ к DevTools
        ChromeDriver chrome =  (ChromeDriver) driver;
        DevTools devTools = chrome.getDevTools();
        // Открытие сессии DevTools
        devTools.createSession();
        // Сбор метрик
        // Performance.enable - включение сбора метрик
        devTools.send(Performance.enable(Optional.of(Performance.EnableTimeDomain.TIMETICKS)));

        // Открыть страницу yandex.ru
        chrome.get("https://yandex.ru");
        logger.info("Открыта страница yandex.ru - " + "https://yandex.ru");
        // Ввести в строку поиска текст - Selenium
        WebElement input = chrome.findElement(By.xpath("//input[@class=\"input__control input__input mini-suggest__input\"]"));
        input.sendKeys("Selenium");
        // Нажать на кнопку "Найти"
        WebElement button = chrome.findElement(By.xpath("//button[@class=\"button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited\"]"));
        button.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Получение метрик
        List<Metric> metrics = devTools.send(Performance.getMetrics());
        List<String> metricNames = metrics.stream()
            .map(o -> o.getName())
            .collect(Collectors.toList()
         );
        // Performance.disable - выключение сбора метрик
        devTools.send(Performance.disable());
        // Список метрик для проверки
        List<String> metricsToCheck = Arrays.asList(
            "Timestamp",
            "Documents",
            "Frames",
            "JSEventListeners",
            "LayoutObjects",
            "MediaKeySessions",
            "Nodes",
            "Resources",
            "DomContentLoaded",
            "NavigationStart"
        );
        // Вывод метрик
        metricsToCheck.forEach(metric ->
                logger.info(metric + " is : " + metrics.get(metricNames.indexOf(metric)).getValue())
        );

        // Закрытие сессии DevTools
        devTools.close();
    }

    @Test
    public void fetchRequestsTest() {
        // Доступ к DevTools
        ChromeDriver chrome =  (ChromeDriver) driver;
        DevTools devTools = chrome.getDevTools();
        // Открытие сессии DevTools
        devTools.createSession();
        // Перехват запроса
        // Fetch.enable - включение перехвата запроса
        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        // Слушатель
        devTools.addListener(
            // Fetch.requestPaused - остановка запроса
            Fetch.requestPaused(),
            // Обработка запроса
            request -> {
                // Новый URL запроса (подставляем в Fetch.continueRequest)
                String newUrl = request.getRequest().getUrl().contains("yandex.ru")
                              ? request.getRequest().getUrl().replace("yandex.ru", "ya.ru")
                              : request.getRequest().getUrl();
                // Параметры запроса
                RequestId requestId = request.getRequestId();                            // ID запроса
                Optional<String> url = Optional.of(request.getRequest().getUrl());       // URL запроса
                Optional<String> method = Optional.of(request.getRequest().getMethod()); // Метод запроса
                Optional<String> postData = request.getRequest().getPostData();          // Данные POST запроса
                Optional<List<HeaderEntry>> headers = request.getResponseHeaders();      // Заголовки запроса
                // Fetch.continueRequest - продолжение запроса
                devTools.send(Fetch.continueRequest(requestId, url, method, postData, headers));
            }
        );

        // Открыть страницу yandex.ru
        chrome.get("https://yandex.ru");
        logger.info("Открыта страница yandex.ru - " + "https://yandex.ru");
        // Ввести в строку поиска текст - Selenium
        WebElement input = chrome.findElement(By.xpath("//input[@class=\"input__control input__input mini-suggest__input\"]"));
        input.sendKeys("Selenium");
        // Нажать на кнопку "Найти"
        WebElement button = chrome.findElement(By.xpath("//button[@class=\"button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited\"]"));
        button.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрытие сессии DevTools
        devTools.close();
    }

    @Test
    public void networkConnectEmulationTest() {
        // Доступ к DevTools
        ChromeDriver chrome = (ChromeDriver) driver;
        DevTools devTools = chrome.getDevTools();
        // Открытие сессии DevTools
        devTools.createSession();
        // Эмуляция интернет соединения
        // Network.enable - включение сетевых возможностей
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        // Network.emulateNetworkConditions - эмуляция интернет соединения
        // Параметры соединения
        Boolean offline = false;           // Оффлайн режим
        Number latency = 2;                // Задержка
        Number downloadThroughput = 80000; // Пропускная способность скачивания
        Number uploadThroughput = 200000;  // Пропускная способность загрузки
        Optional<ConnectionType> connectionType = Optional.of(ConnectionType.CELLULAR2G); // Тип соединения
        devTools.send(Network.emulateNetworkConditions(offline, latency, downloadThroughput, uploadThroughput, connectionType));

        // Открыть страницу yandex.ru
        chrome.get("https://yandex.ru");
        logger.info("Открыта страница yandex.ru - " + "https://yandex.ru");
        // Ввести в строку поиска текст - Selenium
        WebElement input = chrome.findElement(By.xpath("//input[@class=\"input__control input__input mini-suggest__input\"]"));
        input.sendKeys("Selenium");
        // Нажать на кнопку "Найти"
        WebElement button = chrome.findElement(By.xpath("//button[@class=\"button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited\"]"));
        button.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрытие сессии DevTools
        devTools.close();
    }

    @Test
    public void networkAddHeadersTest() {
        // Доступ к DevTools
        ChromeDriver chrome = (ChromeDriver) driver;
        DevTools devTools = chrome.getDevTools();
        // Открытие сессии DevTools
        devTools.createSession();
        // Добавление заголовков в запросы
        // Network.enable - включение сетевых возможностей
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        // Network.setExtraHTTPHeaders - отправка заголовков запроса
        // Заголовки
        Map<String, Object> headers = new HashMap<>();
        headers.put("headername1", "headervalue1");
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
        // Слушатель
        devTools.addListener(
            // Network.requestWillBeSent - перехват запроса
            Network.requestWillBeSent(),
            // Обработка запроса
            request -> {
                logger.info(request.getRequest().getHeaders().get("headername1"));
            }
        );

        // Открыть страницу yandex.ru
        chrome.get("https://yandex.ru");
        logger.info("Открыта страница yandex.ru - " + "https://yandex.ru");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрытие сессии DevTools
        devTools.close();
    }

    @Test
    public void networkCaptureHttpRequestTest() {
        // Доступ к DevTools
        ChromeDriver chrome = (ChromeDriver) driver;
        DevTools devTools = chrome.getDevTools();
        // Открытие сессии DevTools
        devTools.createSession();
        // Перехват HTTP запроса
        // Network.enable - включение сетевых возможностей
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        // Слушатель
        devTools.addListener(
            // Network.requestWillBeSent - перехват запроса
            Network.requestWillBeSent(),
            // Обработка запроса
            request -> {
                logger.info(request.getRequest().getMethod() + " " + request.getRequest().getUrl());
            }
        );

        // Открыть страницу yandex.ru
        chrome.get("https://yandex.ru");
        logger.info("Открыта страница yandex.ru - " + "https://yandex.ru");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрытие сессии DevTools
        devTools.close();
    }

    @Test
    public void networkBasicAuthTest() {
        // Доступ к DevTools
        ChromeDriver chrome = (ChromeDriver) driver;
        DevTools devTools = chrome.getDevTools();
        // Открытие сессии DevTools
        devTools.createSession();
        // Авторизация BasicAuth
        // Network.enable - включение сетевых возможностей
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Открыть страницу jigsaw.w3.org/HTTP/
        driver.get("https://jigsaw.w3.org/HTTP/");

        // Отправка заголовков
        // Network.setExtraHTTPHeaders - отправка заголовков запроса
        final String USERNAME = "guest"; // Имя пользователя
        final String PASSWORD = "guest"; // Пароль пользователя
        byte[] encodedUserPass = new Base64().encode(String.format("%s:%s", USERNAME, PASSWORD).getBytes());
        String basicAuth = "Basic " + new String(encodedUserPass);
        Map<String, Object> headers = new HashMap<>(); // Заголовки
        headers.put("Authorization", basicAuth);
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        // Нажать на ссылку "Basic Authentication test"
        WebElement link = driver.findElement(By.linkText("Basic Authentication test"));
        link.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрытие сессии DevTools
        devTools.close();
    }

    @AfterEach
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
