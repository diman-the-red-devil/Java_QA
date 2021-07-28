package webdriverfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

// Фабрика по созданию экземпляров драйвера браузера
public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    // Получение экземпляра драйвера по имени
    public static WebDriver create(String name) {
        switch (BrowserName.fromString(name)) {
            // Драйвер браузера Google Chrome
            case CHROME:
                logger.info("Драйвер браузера Google Chrome");
                ChromeBrowser.getDriver();
            // Драйвер браузера Mozilla Firefox
            case FIREFOX:
                logger.info("Драйвер браузера Mozilla Firefox");
                FirefoxBrowser.getDriver();
            // Драйвер браузера Microsoft Edge
            case EDGE:
                logger.info("Драйвер браузера Microsoft Edge");
                EdgeBrowser.getDriver();
            // По умолчанию
            default:
                throw new RuntimeException("Некорректное наименование браузера");
        }
    }
}