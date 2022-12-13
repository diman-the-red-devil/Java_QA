import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
public class WebElementPropertiesTest {
    protected WebDriver driver;
    private Logger logger = LogManager.getLogger(WebElementPropertiesTest.class);

    @BeforeEach
    public void setUp() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void getTagNameTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        // Получение имени тега элемента
        String tagName = element.getTagName();
        logger.info("Tag Name: <" + tagName + ">");
        Assertions.assertTrue(tagName.equals("input"), "Значение tagName != input!");
    }

    @Test
    public void getAttributeTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        // Получение значения атрибута элемента
        String attributeValue = element.getAttribute("name");
        logger.info("Attribute Value: name = " + attributeValue);
        Assertions.assertTrue(attributeValue.equals("FirstName"), "Значение attributeValue != FirstName!");
    }

    @Test
    public void getSizeTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        // Получение размеров (значения ширины и высоты) элемента
        Dimension size = element.getSize();
        int height = size.getHeight();
        int width = size.getWidth();
        logger.info("Size: height = " + height + " width = " + width);
        Assertions.assertTrue(height == 21, "Значение height != 21!");
        Assertions.assertTrue(width == 128, "Значение width != 128!");
    }

    @Test
    public void getLocationTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        // Получение положения верхнего левого угла (значения координат x, y) элемента
        Point location = element.getLocation();
        int x = location.getX();
        int y = location.getY();
        logger.info("Location: x = " + x + " y = " + y);
        Assertions.assertTrue(x == 135, "Значение x != 135!");
        Assertions.assertTrue(y == 275, "Значение y != 275!");
    }

    @Test
    public void getRectTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        // Получение размеров и положения верхнего левого угла элемента
        Rectangle rect = element.getRect();

        Dimension size = rect.getDimension();
        int height = size.getHeight();
        int width = size.getWidth();
        logger.info("Size: height = " + height + " width = " + width);
        Assertions.assertTrue(height == 21, "Значение height != 21!");
        Assertions.assertTrue(width == 128, "Значение width != 128!");

        Point location = rect.getPoint();
        int x = location.getX();
        int y = location.getY();
        logger.info("Location: x = " + x + " y = " + y);
        Assertions.assertTrue(x == 135, "Значение x != 135!");
        Assertions.assertTrue(y == 275, "Значение y != 275!");
    }

    @Test
    public void isDisplayedTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        // Проверка видимости элемента
        boolean isDisplayed = element.isDisplayed();
        logger.info("Is Displayed: " + isDisplayed);
        Assertions.assertTrue(isDisplayed, "Не отображается!");
    }

    @Test
    public void isEnabledTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        // Проверка доступности элемента
        boolean isEnabled = element.isEnabled();
        logger.info("Is Enabled: " + isEnabled);
        Assertions.assertTrue(isEnabled, "Не доступна!");
    }

    @Test
    public void isSelectedTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        // Проверка выбора элемента
        boolean isSelected = element.isSelected();
        logger.info("Is Selected: " + isSelected);
        Assertions.assertFalse(isSelected, "Выбрана!");
    }

    @Test
    public void getTextTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.tagName("h1"));
        // Получение текстового содержимого элемента
        String text = element.getText();
        logger.info("Text: " + text);
        Assertions.assertTrue(text.contains("Selenium"), "Значение text не содержит Selenium!");
    }

    @Test
    public void getCssValueTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        // Получение значения CSS элемента
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