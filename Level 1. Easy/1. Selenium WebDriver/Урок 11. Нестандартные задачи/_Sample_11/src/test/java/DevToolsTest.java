import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
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
import org.openqa.selenium.devtools.v91.log.Log;
import org.openqa.selenium.devtools.v91.performance.Performance;
import org.openqa.selenium.devtools.v91.performance.model.Metric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
        List<PermissionType> permissions = new ArrayList<>();
        permissions.add(PermissionType.AUDIOCAPTURE);
        permissions.add(PermissionType.VIDEOCAPTURE);
        permissions.add(PermissionType.GEOLOCATION);
        // Отправка команды DevTools
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
        // Отправка команды DevTools
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
        int width = 600;
        int height = 1000;
        int deviceScaleFactor = 50;
        boolean mobile = true;
        // Отправка команды DevTools
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
        Optional<Number> latitude = Optional.of(50.52930);
        Optional<Number> longitude = Optional.of(42.68620);
        Optional<Number> accuracy = Optional.of(10);
        // Отправка команды DevTools
        devTools.send(Emulation.setGeolocationOverride(latitude, longitude, accuracy));
        // Открыть страницу mycurrentlocation.net
        chrome.get("https://mycurrentlocation.net/");
        logger.info("Открыта страница mycurrentlocation.net - " + "https://mycurrentlocation.net/");
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
        // Отправка команды DevTools
        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(),
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
        // Отправка команды DevTools
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

        List<Metric> metrics = devTools.send(Performance.getMetrics());
        List<String> metricNames = metrics.stream()
                .map(o -> o.getName())
                .collect(Collectors.toList()
         );

        devTools.send(Performance.disable());

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

        metricsToCheck.forEach(metric ->
                logger.info(metric + " is : " + metrics.get(metricNames.indexOf(metric)).getValue()));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
        // Сбор метрик
        // Отправка команды DevTools
        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        // Открыть страницу yandex.ru
        chrome.get("https://yandex.ru");
        logger.info("Открыта страница yandex.ru - " + "https://yandex.ru");
        // Ввести в строку поиска текст - Selenium
        WebElement input = chrome.findElement(By.xpath("//input[@class=\"input__control input__input mini-suggest__input\"]"));
        input.sendKeys("Selenium");
        // Нажать на кнопку "Найти"
        WebElement button = chrome.findElement(By.xpath("//button[@class=\"button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited\"]"));
        button.click();

        devTools.addListener(Fetch.requestPaused(), request -> {

            String url = request.getRequest().getUrl().contains("/v1/users")
                    ? request.getRequest().getUrl().replace("/v1/users", "/v2/users")
                    : request.getRequest().getUrl();

            devTools.send(Fetch.continueRequest(
                    request.getRequestId(),
                    Optional.of(url),
                    Optional.of(request.getRequest().getMethod()),
                    request.getRequest().getPostData(),
                    request.getResponseHeaders()));
        });

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
