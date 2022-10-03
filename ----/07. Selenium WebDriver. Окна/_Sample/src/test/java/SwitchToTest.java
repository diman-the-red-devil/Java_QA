import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;
import java.util.Set;

public class SwitchToTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SwitchToTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("edge");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void switchToActiveElementTest() {
        // Открыть страницу https://devqa.io/search/
        driver.get("https://devqa.io/search/");
        logger.info("Открыта страница devqa.io - https://devqa.io/search/");

        // Переключиться на активный элемент
        WebElement inputSearch = driver.switchTo().activeElement();
        logger.info("Переключение на активный элемент");

        // Ввести текста в поле для поиска
        inputSearch.sendKeys("Selenium");
        logger.info("Ввод текста в поле для поиска");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void switchToAlertTest() {
        // Открыть страницу https://webdriveruniversity.com/Popup-Alerts/index.html
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/Popup-Alerts/index.html");

        // Переключиться на модальное окно
        // Simple Alert
        WebElement btnSimpleAlert = driver
                .findElement(By.xpath("//h2[text()=\"JavaScript Alert\"]/following-sibling::div/span"));
        btnSimpleAlert.click();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Alert alertSimpleAlert = driver.switchTo().alert();
        alertSimpleAlert.accept();
        logger.info("Переключение на модальное окно Simple Alert");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Confirmation Alert
        WebElement btnConfirmationAlert = driver
                .findElement(By.xpath("//h2[text()=\"JavaScript Confirm Box\"]/following-sibling::div/span"));
        btnConfirmationAlert.click();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Alert alertConfirmationAlert = driver.switchTo().alert();
        alertConfirmationAlert.accept();
        logger.info("Переключение на модальное окно Confirmation Alert");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void switchToFrameTest() {
        // Открыть страницу https://webdriveruniversity.com/IFrame/index.html
        driver.get("https://webdriveruniversity.com/IFrame/index.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/IFrame/index.html");

        // Переключиться на фрейм и нажать кнопку
        WebElement frame = driver.findElement(By.id("frame"));
        logger.info("Переключение на фрейм");
        WebElement btnInFrame = driver
                .switchTo()
                .frame(frame)
                .findElement(By.xpath("//button[@id=\"button-find-out-more\"]"));
        btnInFrame.click();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void switchToWindowTest() {
        // Открыть страницу https://devqa.io/selenium-css-selectors/
        driver.get("https://devqa.io/selenium-css-selectors/");
        logger.info("Открыта страница devqa.io - https://devqa.io/selenium-css-selectors/");
        String oldWindow = driver.getWindowHandle();
        logger.info("Старое окно:\n" + oldWindow);

        // Переключиться на новое окно
        driver.switchTo().newWindow(WindowType.WINDOW);
        logger.info("Переключение на новое окно:\n" + driver.getWindowHandle());

        // Открыть страницу https://devqa.io/selenium-tutorial/
        driver.get("https://devqa.io/selenium-tutorial/");
        logger.info("Открыта страница devqa.io - https://devqa.io/selenium-tutorial/");
        String newWindow = driver.getWindowHandle();
        logger.info("Новое окно:\n" + newWindow);

        // Переключиться на старое окно
        driver.switchTo().window(oldWindow);
        logger.info("Переключение на старое окно:\n" + driver.getWindowHandle());
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
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
