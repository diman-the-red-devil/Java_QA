package elements.webdriverfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static elements.webdriverfactory.BrowserName.CHROME;

// Фабрика по созданию экземпляров драйвера браузера
public class WebDriverFactory {
    // Логгер
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    // Получение экземпляра драйвера по имени
    public static WebDriver getDriver(String name) {
        switch (BrowserName.fromString(name)) {
            // Драйвер браузера Google Chrome
            case CHROME:
                logger.info("Драйвер браузера Google Chrome " + BrowserName.fromString(name) + CHROME);
                return ChromeBrowser.getDriver();
            // Драйвер браузера Mozilla Firefox
            case FIREFOX:
                logger.info("Драйвер браузера Mozilla Firefox");
                return FirefoxBrowser.getDriver();
            // Драйвер браузера Microsoft Edge
            case EDGE:
                logger.info("Драйвер браузера Microsoft Edge");
                return EdgeBrowser.getDriver();
            // По умолчанию
            default:
                throw new RuntimeException("Некорректное наименование браузера");
        }
    }
}