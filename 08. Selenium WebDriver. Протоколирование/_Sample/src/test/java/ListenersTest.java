import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;


public class ListenersTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(ListenersTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void listenerSelenium3Test() {
        // Регистрация слушателя событий
        Selenium3Listener listener = new Selenium3Listener();
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(listener);
        // Открыть страницу https://www.dns-shop.ru/
        eventFiringWebDriver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
        // Нажать на кнопку "Всё верно"
        By btnYesXPath = By.xpath("(//span[text()=\"Всё верно\"])[1]");
        WebElement btnYes = driver.findElement(btnYesXPath);
        btnYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
    }

    @Test
    public void listenerSelenium4Test() {
        // Регистрация слушателя событий
        Selenium4Listener listener = new Selenium4Listener();
        WebDriver eventFiringWebDriver = new EventFiringDecorator(listener).decorate(driver);
        // Открыть страницу https://www.dns-shop.ru/
        eventFiringWebDriver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
        // Нажать на кнопку "Всё верно"
        By btnYesXPath = By.xpath("(//span[text()=\"Всё верно\"])[1]");
        WebElement btnYes = driver.findElement(btnYesXPath);
        btnYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
