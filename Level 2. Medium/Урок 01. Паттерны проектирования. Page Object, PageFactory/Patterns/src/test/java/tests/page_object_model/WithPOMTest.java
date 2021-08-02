package tests.page_object_model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pom.HomePage;
import pom.SignInPage;
import webdriverfactory.WebDriverFactory;

// Тест
public class WithPOMTest {
    // Драйвер браузера
    protected static WebDriver driver;
    // Логгер
    private Logger logger = LogManager.getLogger(WithPOMTest.class);

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
        // Страница "Sign In"
        SignInPage signInPage = new SignInPage(driver);
        // Вход с логином и паролем
        // Страница "Home"
        HomePage homePage = signInPage.loginValidUser(
                "diman_the_red_devil@mail.ru",
                "JAKARTA12345rex-"
        );

        // Проверить что отображается текст "Стартовая страница"
        Assertions.assertTrue(homePage.isTextDisplyed());
        Assertions.assertEquals("Dashboard", homePage.getText(),
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
