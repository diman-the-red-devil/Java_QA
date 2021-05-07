import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitsTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(ExplicitWaitsTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void attributeExpectedConditionTest() {
        // Открыть страницу ng-bootstrap.github.io
        driver.get("https://ng-bootstrap.github.io/#/components/buttons/examples");
        logger.info("Открыта страница ng-bootstrap.github.io - https://ng-bootstrap.github.io/#/components/buttons/examples");
        // Нажать на кнопку [Checkbox buttons/Middle]
        By xpath = By.xpath("//ngbd-buttons-checkbox/div/label[2]/input");
        WebElement checkBoxButtonsMiddle = driver.findElement(xpath);
        checkBoxButtonsMiddle.click();
        logger.info("Нажата кнопка [Checkbox buttons/Middle]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.attributeToBe(checkBoxButtonsMiddle, "", ""));
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
