package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class BaseTest {
    // Драйвер браузера
    protected static WebDriver driver;
    // Логгер
    private Logger logger = LogManager.getLogger(BaseTest.class);

    // Перед каждым тестом
    @BeforeEach
    public void setUp() {
        // Получаем параметр запуска тестов через Maven -Dbrowser
        String browser = System
                .getProperty("browser", "chrome")
                .toLowerCase();
        // Получаем экземпляр драйвера браузера
        // Настройка исполняемого файла драйвера
        WebDriverManager.chromedriver().setup();
        // Опции драйвера:
        ChromeOptions options = new ChromeOptions();
        // - поведение при появлении алертов "Игнорирование"
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        // - стратегия загрузки страницы "NORMAL"
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);
        // - режим "Инкогнито"
        options.addArguments("--incognito");
        // - режим "Полный экран"
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
        logger.info("Драйвер стартовал!");
    }

    // После каждого теста
    @AfterEach
    public void setDown() {
        // Если драйвер еще существует
        if(driver != null) {
            // Закрываем его
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
