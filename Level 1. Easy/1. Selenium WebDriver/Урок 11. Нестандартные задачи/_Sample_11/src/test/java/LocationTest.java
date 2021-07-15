import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.html5.WebStorage;

import java.util.Set;

public class LocationTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(LocationTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void locationTest() {
        //
        ChromeDriver d = (ChromeDriver) driver;
        Location location = new Location(10.0, 110.0, 140.1);
        d.setLocation(location);
        logger.info(location.toString());
        logger.info("Altitude: " + location.getAltitude());
        logger.info("Latitude: " + location.getLatitude());
        logger.info("Longitude: " + location.getLongitude());
        // Открыть страницу dns-shop.ru
        d.get("https://yandex.ru/maps");
        logger.info("Открыта страница dns-shop.ru - " + "https://yandex.ru/maps");
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
