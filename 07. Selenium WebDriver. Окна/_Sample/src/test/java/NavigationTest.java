import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;

public class NavigationTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(NavigationTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void navigateBackTest() {
        // Открыть страницу https://devqa.io/
        driver.get("https://devqa.io/");
        logger.info("Открыта страница devqa.io - https://devqa.io/");
        // Нажать на ссылку "How to Use the Linux find Command to Find Files"
        WebElement link1 = driver.findElement(By.xpath("//a[contains(text(), \"How to Use the Linux find Command to Find Files\")]"));
        link1.click();
        logger.info("Нажата ссылка \"How to Use the Linux find Command to Find Files\"");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Нажать на ссылку "Development"
        WebElement link2 = driver.findElement(By.xpath("//a[contains(text(), \"Development\")]"));
        link2.click();
        logger.info("Нажата ссылка \"Development\"");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Перейти Назад на предыдущую страницу
        driver.navigate().back();
        logger.info("Выполнен переход Назад по Истории");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void navigateForwardTest() {
        // Открыть страницу https://devqa.io/
        driver.get("https://devqa.io/");
        logger.info("Открыта страница devqa.io - https://devqa.io/");
        // Нажать на ссылку "How to Use the Linux find Command to Find Files"
        WebElement link1 = driver.findElement(By.xpath("//a[contains(text(), \"How to Use the Linux find Command to Find Files\")]"));
        link1.click();
        logger.info("Нажата ссылка \"How to Use the Linux find Command to Find Files\"");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Нажать на ссылку "Development"
        WebElement link2 = driver.findElement(By.xpath("//a[contains(text(), \"Development\")]"));
        link2.click();
        logger.info("Нажата ссылка \"Development\"");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Перейти Назад на предыдущую страницу
        driver.navigate().back();
        logger.info("Выполнен переход Назад по Истории");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Перейти Вперед на следующую страницу
        driver.navigate().forward();
        logger.info("Выполнен переход Вперед по Истории");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updatePageTest() {
        // Открыть страницу https://devqa.io/
        driver.get("https://devqa.io/");
        logger.info("Открыта страница devqa.io - https://devqa.io/");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Обновить страницу
        driver.navigate().refresh();
        logger.info("Выполнено обновление страницы");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loadNewPageTest() {
        // Открыть страницу https://devqa.io/
        driver.get("https://devqa.io/");
        logger.info("Открыта страница devqa.io - https://devqa.io/");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Загрузить новую страницу
        driver.navigate().to("https://devqa.io/tag/qa/");
        logger.info("Выполнена загрузка новой страницы devqa.io - https://devqa.io/tag/qa/");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
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
