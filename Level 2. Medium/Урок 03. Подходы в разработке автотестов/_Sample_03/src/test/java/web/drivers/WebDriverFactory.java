package web.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

// Фабрика по созданию экземпляров драйвера браузера
public class WebDriverFactory {
    // Логгер
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);
    // Драйвер
    private static WebDriver webDriver;

    // Получение экземпляра драйвера по имени
    public static WebDriver getDriver(BrowserName name) {
        switch (name) {
            // Драйвер браузера Google Chrome
            case CHROME:
                logger.info("Драйвер браузера Google Chrome");
                webDriver = ChromeBrowserDriver.getDriver();
                return webDriver;
            // Драйвер браузера Mozilla Firefox
            case FIREFOX:
                logger.info("Драйвер браузера Mozilla Firefox");
                webDriver = FirefoxBrowserDriver.getDriver();
                return webDriver;
            // Драйвер браузера Microsoft Edge
            case EDGE:
                logger.info("Драйвер браузера Microsoft Edge");
                webDriver = EdgeBrowserDriver.getDriver();
                return webDriver;
            // По умолчанию
            default:
                throw new RuntimeException("Некорректное наименование браузера");
        }
    }

    // Получение уже созданного экземпляра драйвера
    public static WebDriver getCurrentDriver() {
        return webDriver;
    }
}