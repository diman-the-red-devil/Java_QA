import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TimeOutsTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(TimeOutsTest.class);

    // Читаем передаваемый параметр browser (-Dbrowser)
    String env = System.getProperty("browser", "chrome");

    @BeforeEach
    public void setUp() {
        logger.info("env = " + env);
        driver = WebDriverFactory.getDriver(env.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void timeOutsTest1() {
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
        logger.info("Открыта страница Yandex - " + "https://yandex.ru/");
    }

    @Test
    public void timeOutsTest2() {
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MILLISECONDS);
        driver.get("https://yandex.ru/");
        logger.info("Открыта страница Yandex - " + "https://yandex.ru/");
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
