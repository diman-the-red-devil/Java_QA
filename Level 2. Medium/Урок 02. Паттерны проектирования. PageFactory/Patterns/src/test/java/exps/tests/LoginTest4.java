package exps.tests;

import exps.models.Account;
import exps.models.valueobjects.FullName;
import exps.models.valueobjects.Login;
import exps.models.valueobjects.MobilePhone;
import exps.models.valueobjects.Password;
import exps.web.pages.HomePage;
import exps.web.pages.SignInPage;
import exps.web.drivers.factory.WebDriverFactory;
import exps.web.pages.factory.PageFactory;
import exps.web.pages.factory.PageName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.util.Date;

// Тест
public class LoginTest4 {
    // Драйвер браузера
    protected static WebDriver driver;
    // Логгер
    private Logger logger = LogManager.getLogger(LoginTest4.class);

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
        Account account = new Account(
                new Login(login),
                new Password(password)
        );
        account.setMobilePhone(new MobilePhone("89064067898"));
        account.setFullName(new FullName("Тестов Тест Тестович"));
        account.setDateOfBirth(new Date("01-01-2000"));
        String expected = "Dashboard";

        // Act
        HomePage homePage = getPageAfterLogin(account);

        // Assert
        // Проверить что отображается текст "Стартовая страница"
        HomePageAssert homePageAssert = new HomePageAssert(homePage);
        homePageAssert.displayedTextAfterLogin();
        homePageAssert.textAfterLoginIs(expected);
    }

    public HomePage getPageAfterLogin(Account account) {
        // Страница "Sign In"
        SignInPage signInPage = (SignInPage) PageFactory.getPage(driver, PageName.SIGN_IN_PAGE);
        // Вход с логином и паролем
        // Страница "Home"
        return signInPage.loginValidUser(account);
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

