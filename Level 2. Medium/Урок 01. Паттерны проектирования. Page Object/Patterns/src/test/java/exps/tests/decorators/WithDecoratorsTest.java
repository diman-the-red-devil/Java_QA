package exps.tests.decorators;

import exps.pages.HomePageWithDecorators;
import exps.pages.SignInPageWithDecorators;
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
        HomePageWithDecorators homePage = getPageAfterLogin(login, password);

        // Assert
        // Проверить что отображается текст "Стартовая страница"
        HomePageWithDecoratorsAssert homePageWithDecoratorsAssertAssert = new HomePageWithDecoratorsAssert(homePage);
        homePageWithDecoratorsAssertAssert.displayedTextAfterLogin();
        homePageWithDecoratorsAssertAssert.textAfterLoginIs(expected);
    }

    public HomePageWithDecorators getPageAfterLogin(String login, String password) {
        // Страница "Sign In"
        SignInPageWithDecorators signInPageWithDecorators = new SignInPageWithDecorators(driver);
        // Вход с логином и паролем
        // Страница "Home"
        return signInPageWithDecorators.loginValidUser(login, password);
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

class HomePageWithDecoratorsAssert {
    private HomePageWithDecorators homePageWithDecorators;

    public HomePageWithDecoratorsAssert(HomePageWithDecorators homePageWithDecorators) {
        this.homePageWithDecorators = homePageWithDecorators;
    }

    // Проверка отображения текста после входа с логином и паролем
    public void displayedTextAfterLogin() {
        Assertions.assertTrue(homePageWithDecorators.isTextDisplyed());
    }

    // Проверка текста после входа с логином и паролем
    public void textAfterLoginIs(String expected) {
        Assertions.assertEquals(expected, homePageWithDecorators.getText(),
                "Ошибка! Текст на странице не соответствует ожидаемому");
    }
}