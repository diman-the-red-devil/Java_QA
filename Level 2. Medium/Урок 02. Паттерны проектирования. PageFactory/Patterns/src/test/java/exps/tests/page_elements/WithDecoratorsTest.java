package exps.tests.page_elements;

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
public class WithDecoratorsTest {
    // Драйвер браузера
    protected static WebDriver driver;
    // Логгер
    private Logger logger = LogManager.getLogger(WithDecoratorsTest.class);

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
        String expected = "Dashboard";

        // Act
        HomePage homePage = getPageAfterLogin(login, password);

        // Assert
        // Проверить что отображается текст "Стартовая страница"
        HomePageAssert homePageAssert = new HomePageAssert(homePage);
        homePageAssert.displayedTextAfterLogin();
        homePageAssert.textAfterLoginIs(expected);
    }

    public HomePage getPageAfterLogin(String login, String password) {
        // Страница "Sign In"
        SignInPage signInPage = new SignInPage(driver);
        // Вход с логином и паролем
        // Страница "Home"
        return signInPage.loginValidUser(login, password);
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

class HomePageAssert1 {
    private HomePage homePage;

    public HomePageAssert1(HomePage homePage) {
        this.homePage = homePage;
    }

    // Проверка отображения текста после входа с логином и паролем
    public void displayedTextAfterLogin() {
        Assertions.assertTrue(homePage.isTextDisplyed());
    }

    // Проверка текста после входа с логином и паролем
    public void textAfterLoginIs(String expected) {
        Assertions.assertEquals(expected, homePage.getText(),
                "Ошибка! Текст на странице не соответствует ожидаемому");
    }
}