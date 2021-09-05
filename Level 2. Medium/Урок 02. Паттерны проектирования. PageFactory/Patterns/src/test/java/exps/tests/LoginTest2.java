package exps.tests;

import exps.models.AccountPOJO;
import exps.web.pages.HomePage;
import exps.web.pages.SignInPage;
import exps.web.drivers.factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

// Тест
public class LoginTest2 {
    // Драйвер браузера
    protected static WebDriver driver;
    // Логгер
    private Logger logger = LogManager.getLogger(LoginTest2.class);

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
        // Arrange
        String login = "diman_the_red_devil@mail.ru";
        String password = "JAKARTA12345rex-";
        AccountPOJO accountPOJO = new AccountPOJO(login, password);
        String expected = "Dashboard";

        // Act
        HomePage homePage = getPageAfterLogin(accountPOJO);

        // Assert
        // Проверить что отображается текст "Стартовая страница"
        HomePageAssert homePageAssert = new HomePageAssert(homePage);
        homePageAssert.displayedTextAfterLogin();
        homePageAssert.textAfterLoginIs(expected);
    }

    public HomePage getPageAfterLogin(AccountPOJO accountPOJO) {
        // Страница "Sign In"
        SignInPage signInPage = new SignInPage(driver);
        // Вход с логином и паролем
        // Страница "Home"
        return signInPage.loginValidUser(accountPOJO);
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