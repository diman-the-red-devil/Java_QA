import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ImplicitWaitsTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(ImplicitWaitsTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void implicitlyWaitTest() {
        // Установить неявное ожидание до появления элемента на странице
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница DNS - https://www.dns-shop.ru/");
        // Нажать на ссылку Магазины
        WebElement linkShops = driver.findElement(By.xpath("//a[text()=\"Магазины\"]"));
        linkShops.click();
        logger.info("Нажата ссылка Магазины");
        // Нажать на выпадашку Каталог
        WebElement spanCatalog = driver.findElement(By.xpath("//span[@class=\"catalog-spoiler \"]"));
        spanCatalog.click();
        logger.info("Нажата выпадашка Каталог");
        // Нажать на ссылку Бытовая техника
        WebElement linkAppliances = driver.findElement(By.xpath("//a[text()=\"Бытовая техника\"]"));
        linkAppliances.click();
        logger.info("Нажата ссылка Бытовая техника");
    }

    @Test
    public void pageLoadTimeoutTest() {
        // Установить неявное ожидание до появления элемента на странице
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница DNS - https://www.dns-shop.ru/");
    }

    @Test
    public void setScriptTimeoutTest() {
        // Установить неявное ожидание до появления элемента на странице
        driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(0));
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница DNS - https://www.dns-shop.ru/");
        ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 500);");
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
