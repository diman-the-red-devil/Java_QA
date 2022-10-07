import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SeleniumTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void basicAuthTest() {
        // Открыть страницу the-internet.herokuapp.com
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        logger.info("Открыта страница the-internet.herokuapp.com - https://the-internet.herokuapp.com/basic_auth");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Открыть страницу the-internet.herokuapp.com с авторизацией
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        logger.info("Открыта страница the-internet.herokuapp.com - https://the-internet.herokuapp.com/basic_auth");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileUploadTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/File-Upload/index.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/File-Upload/index.html");
        // Приложить файл upload.txt
        String fileUploadXpath = "//input[@type=\"file\"]";
        WebElement fileUpload = driver.findElement(By.xpath(fileUploadXpath));
        // !!! Поменять путь на свой
        fileUpload.sendKeys("C:\\Users\\DKim\\Desktop\\_Sample\\upload\\upload.txt");
        logger.info("Файл приложен");
        // Отправить файл
        String btnSubmitXpath = "//input[@type=\"submit\"]";
        WebElement btnSubmit = driver.findElement(By.xpath(btnSubmitXpath));
        btnSubmit.click();
        logger.info("Файл отправлен!");
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
}
