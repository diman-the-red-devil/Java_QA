import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.Color;

import static org.openqa.selenium.ScreenOrientation.LANDSCAPE;

public class ScreenTest {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(ScreenTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("firefox");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void colorTest() {
        WebDriver d = new Augmenter().augment(driver);
        Rotatable rotator = ((Rotatable) d);
        rotator.rotate(LANDSCAPE);
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");
        logger.info("Открыта страница webdriveruniversity.com - " + "https://webdriveruniversity.com/Click-Buttons/index.html");


    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
