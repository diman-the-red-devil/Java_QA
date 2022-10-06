import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class ColorTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(ColorTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void colorTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");
        logger.info("Открыта страница webdriveruniversity.com - " + "https://webdriveruniversity.com/Click-Buttons/index.html");

        // Цвета границы и фона кнопки
        String btnXpath = "//span[@id=\"button1\"]";
        WebElement btn = driver.findElement(By.xpath(btnXpath));
        Color btnColor = Color.fromString(btn.getCssValue("border-color"));
        Color btnBgColor = Color.fromString(btn.getCssValue("background-color"));
        logger.info("Цвет границы кнопки: ");
        logger.info("HEX - " + btnColor.asHex());
        logger.info("RGB - " + btnColor.asRgb());
        logger.info("RGBA - " + btnColor.asRgba());
        logger.info("Цвет фона кнопки: ");
        logger.info("HEX - " + btnBgColor.asHex());
        logger.info("RGB - " + btnBgColor.asRgb());
        logger.info("RGBA - " + btnBgColor.asRgba());
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
