import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class PageLoadStrategyTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(PageLoadStrategyTest.class);

    @Test
    public void pageLoadStrategyNormalTest() {
        WebDriverManager.edgedriver().setup();
        logger.info("Драйвер для браузера MS Edge");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        // Устанавливаем стратегию загрузки страницы - NORMAL
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new EdgeDriver(options);
        // Время. Начало
        long start = System.currentTimeMillis();
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница DNS - https://www.dns-shop.ru/");
        WebElement element = driver.findElement(By.xpath("//a[text()=\"Магазины\"]"));
        element.click();
        // Время. Конец
        long finish = System.currentTimeMillis();
        // Затраченное время
        long time = finish - start;
        logger.info("Затраченное время: " + (time / 1000) + " секунд");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }

    @Test
    public void pageLoadStrategyEagerTest() {
        WebDriverManager.edgedriver().setup();
        logger.info("Драйвер для браузера MS Edge");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        // Устанавливаем стратегию загрузки страницы - EAGER
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new EdgeDriver(options);
        // Время. Начало
        long start = System.currentTimeMillis();
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница DNS - https://www.dns-shop.ru/");
        WebElement element = driver.findElement(By.xpath("//a[text()=\"Магазины\"]"));
        element.click();
        // Время. Конец
        long finish = System.currentTimeMillis();
        // Затраченное время
        long time = finish - start;
        logger.info("Затраченное время: " + (time / 1000) + " секунд");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }

    @Test
    public void pageLoadStrategyNoneTest() {
        WebDriverManager.edgedriver().setup();
        logger.info("Драйвер для браузера MS Edge");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        // Устанавливаем стратегию загрузки страницы - NONE
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driver = new EdgeDriver(options);

        try {
            // Время. Начало
            long start = System.currentTimeMillis();
            driver.get("https://www.dns-shop.ru/");
            logger.info("Открыта страница DNS - https://www.dns-shop.ru/");
            WebElement element = driver.findElement(By.xpath("//a[text()=\"Магазины\"]"));
            element.click();
            // Время. Конец
            long finish = System.currentTimeMillis();
            // Затраченное время
            long time = finish - start;
            logger.info("Затраченное время: " + (time / 1000) + " секунд");
        } catch (Exception e) {
            logger.info("Возникло исключение: " + e.getClass());
            if(driver != null) {
                driver.quit();
                logger.info("Драйвер остановлен!");
            }
        }
    }
}
