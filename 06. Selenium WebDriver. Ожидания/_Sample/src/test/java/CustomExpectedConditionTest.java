import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomExpectedConditionTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(CustomExpectedConditionTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void namedClassTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/Popup-Alerts/index.html");
        // Нажать на кнопку [CLICK ME!] в блоке [JavaScript Alert]
        By spanJSAlertXpath = By.xpath("//h2[text()=\"JavaScript Alert\"]/following-sibling::div/span");
        WebElement spanJSAlert = driver.findElement(spanJSAlertXpath);
        spanJSAlert.click();
        logger.info("Нажата кнопка [CLICK ME!] в блоке [JavaScript Alert]");
        // Подождать пока появится алерт
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(new AlertExpectedCondition());
        logger.info("Алерт отобразился!");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void anonymousClassTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/Popup-Alerts/index.html");
        // Нажать на кнопку [CLICK ME!] в блоке [JavaScript Alert]
        By spanJSAlertXpath = By.xpath("//h2[text()=\"JavaScript Alert\"]/following-sibling::div/span");
        WebElement spanJSAlert = driver.findElement(spanJSAlertXpath);
        spanJSAlert.click();
        logger.info("Нажата кнопка [CLICK ME!] в блоке [JavaScript Alert]");
        // Подождать пока появится алерт
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(
            // Анонимный класс new ExpectedCondition<Alert>()
            new ExpectedCondition<Alert>() {
            @Override
            public Alert apply(WebDriver input) {
                try {
                    return driver.switchTo().alert();
                } catch (NoAlertPresentException e) {
                    return null;
                }
            }
        });
        logger.info("Алерт отобразился!");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }

    class AlertExpectedCondition implements ExpectedCondition<Alert>  {
        // Переопределение метода apply
        // Пробуем переключиться на алерт
        @Override
        public Alert apply(WebDriver driver) {
            try {
                return driver.switchTo().alert();
            } catch (NoAlertPresentException e) {
                return null;
            }
        }
    }
}


