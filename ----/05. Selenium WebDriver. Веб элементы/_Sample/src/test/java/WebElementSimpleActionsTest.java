import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementSimpleActionsTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(WebElementSimpleActionsTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void clickTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.name("Save"));
        // Нажатие на элемент
        element.click();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendKeysTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.name("Initial"));
        // Ввод текста
        element.sendKeys("Initial");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clearTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.name("Initial"));
        element.sendKeys("Initial");
        // Удаление текста
        element.clear();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void submitTest(){
        driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
        WebElement element = driver.findElement(By.name("Initial"));
        // Отправка данных формы
        element.submit();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
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