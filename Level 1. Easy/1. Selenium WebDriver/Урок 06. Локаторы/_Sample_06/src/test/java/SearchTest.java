import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SearchTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void searchByIdTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.id("FirstName"));
        logger.info("WebElement: " + element.getTagName());
        element.sendKeys("First Name");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByNameTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.name("FirstName"));
        logger.info("WebElement: " + element.getTagName());
        element.sendKeys("First Name");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByClassTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        List<WebElement> elements = driver.findElements(By.className("detail_box"));
        for(WebElement element : elements)
            logger.info("WebElement: " + element.getText());
    }

    @Test
    public void searchByTagTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        List<WebElement> elements = driver.findElements(By.tagName("label"));
        for(WebElement element : elements)
            logger.info("WebElement: " + element.getText());
    }

    @Test
    public void searchByLinkTextTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.linkText("LOGOUT"));
        logger.info("WebElement: " + element.getText());
        element.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByPartialLinkTextTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.partialLinkText("LOG"));
        logger.info("WebElement: " + element.getText());
        element.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByCssSelectorTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element1 = driver.findElement(By.cssSelector("input#Initial"));
        logger.info("WebElement: " + element1.getTagName());
        logger.info("Id: " + element1.getAttribute("id"));
        element1.sendKeys("Initial");
        WebElement element2 = driver.findElement(By.cssSelector("input#FirstName"));
        logger.info("WebElement: " + element2.getTagName());
        logger.info("Id: " + element2.getAttribute("id"));
        element2.sendKeys("First Name");
        WebElement element3 = driver.findElement(By.cssSelector("input#MiddleName"));
        logger.info("WebElement: " + element3.getTagName());
        logger.info("Id: " + element3.getAttribute("id"));
        element3.sendKeys("Middle Name");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByXpathQueryTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " + "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element1 = driver.findElement(By.xpath(".//input[@id='Initial']"));
        logger.info("WebElement: " + element1.getTagName());
        logger.info("Id: " + element1.getAttribute("id"));
        element1.sendKeys("Initial");
        WebElement element2 = driver.findElement(By.xpath(".//input[@id='FirstName']"));
        logger.info("WebElement: " + element2.getTagName());
        logger.info("Id: " + element2.getAttribute("id"));
        element2.sendKeys("First Name");
        WebElement element3 = driver.findElement(By.xpath(".//input[@id='MiddleName']"));
        logger.info("WebElement: " + element3.getTagName());
        logger.info("Id: " + element3.getAttribute("id"));
        element3.sendKeys("Middle Name");

        try {
            Thread.sleep(10000);
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
}