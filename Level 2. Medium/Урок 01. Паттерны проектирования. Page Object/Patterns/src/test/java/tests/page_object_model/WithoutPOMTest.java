package tests.page_object_model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webdriverfactory.WebDriverFactory;

// Тест
public class WithoutPOMTest {
    // Драйвер браузера
    protected static WebDriver driver;
    // Логгер
    private Logger logger = LogManager.getLogger(WithoutPOMTest.class);

    // Перед каждым тестом
    @BeforeEach
    public void setUp() {
        // Получаем параметр запуска тестов через Maven -Dbrowser
        String browser = System
                .getProperty("browser", "chrome")
                .toLowerCase();
        // Получаем экземпляр драйвера браузера
        driver = WebDriverFactory.getDriver(browser);
        logger.info("Драйвер стартовал!");
        driver.get("https://github.com/login");
    }

    @Test
    public void loginTest() {
        // Страница "Вход"
        // Ввести логин и пароль
        driver.findElement(By.name("login")).sendKeys("diman_the_red_devil@mail.ru");
        driver.findElement(By.name("password")).sendKeys("JAKARTA12345rex-");
        driver.findElement(By.name("commit")).click();

        // Стартовая страница
        // Проверить что отображается текст "Стартовая страница"
        Assertions.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
        Assertions.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Dashboard",
                "Ошибка! Текст на странице не соответствует ожидаемому");
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
