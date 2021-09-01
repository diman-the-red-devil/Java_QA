package exps.tests.pojo;

import exps.pages.HomePage;
import exps.pages.SignInPage;
import exps.webdriverfactory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

// Тест
public class WithPOJOTest {
    // Драйвер браузера
    protected static WebDriver driver;
    // Логгер
    private Logger logger = LogManager.getLogger(WithPOJOTest.class);

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
        LoginPOJO loginPOJO = new LoginPOJO("diman_the_red_devil@mail.ru","JAKARTA12345rex-");
        HomePage homePage = signInPage.loginValidUser(loginPOJO);

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
