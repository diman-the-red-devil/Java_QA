import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.util.List;

public class WebElementsTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(WebElementsTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void getTagNameTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        String tagName = element.getTagName();
        logger.info("Tag Name: <" + tagName + ">");
        Assertions.assertTrue(tagName.equals("input"), "Значение tagName != input!");
    }

    @Test
    public void getAttributeTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        String attributeValue = element.getAttribute("name");
        logger.info("Attribute Value: name = " + attributeValue);
        Assertions.assertTrue(attributeValue.equals("name"), "Значение attributeValue != name!");
    }

    @Test
    public void getSizeTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        Dimension size = element.getSize();
        int height = size.getHeight();
        int width = size.getWidth();
        logger.info("Size: height = " + height + " width = " + width);
        Assertions.assertTrue(height == 21, "Значение height != 21!");
        Assertions.assertTrue(width == 124, "Значение width != 124!");
    }

    @Test
    public void getLocationTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        Point location = element.getLocation();
        int x = location.getX();
        int y = location.getY();
        logger.info("Location: x = " + x + " y = " + y);
        Assertions.assertTrue(x == 136, "Значение x != 136!");
        Assertions.assertTrue(y == 275, "Значение y != 2751");
    }

    @Test
    public void getRectTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        Rectangle rect = element.getRect();

        Dimension size = rect.getDimension();
        int height = size.getHeight();
        int width = size.getWidth();
        logger.info("Size: height = " + height + " width = " + width);
        Assertions.assertTrue(height == 21, "Значение height != 21!");
        Assertions.assertTrue(width == 124, "Значение width != 124!");

        Point location = rect.getPoint();
        int x = location.getX();
        int y = location.getY();
        logger.info("Location: x = " + x + " y = " + y);
        Assertions.assertTrue(x == 136, "Значение x != 136!");
        Assertions.assertTrue(y == 275, "Значение y != 275!");
    }

    @Test
    public void isDisplayedTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        boolean isDisplayed = element.isDisplayed();
        logger.info("Is Displayed: " + isDisplayed);
        Assertions.assertTrue(isDisplayed, "Не отображается!");
    }

    @Test
    public void isEnabledTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        boolean isEnabled = element.isEnabled();
        logger.info("Is Enabled: " + isEnabled);
        Assertions.assertTrue(isEnabled, "Не доступна!");
    }

    @Test
    public void isSelectedTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        boolean isSelected = element.isSelected();
        logger.info("Is Selected: " + isSelected);
        Assertions.assertFalse(isSelected, "Выбрана!");
    }

    @Test
    public void getTextTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.tagName("h1"));
        String text = element.getText();
        logger.info("Text: " + text);
        Assertions.assertTrue(text.contains("Selenium"), "Значение text не содержит Selenium!");
    }

    @Test
    public void getCssValueTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        String cssValue = element.getCssValue("width");
        logger.info("Css Value: width = " + cssValue);
        Assertions.assertTrue(cssValue.equals("120px"), "Значение cssValue != 120px!");
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}