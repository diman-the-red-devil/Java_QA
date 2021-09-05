package exps.web.pages.factory;

import exps.web.pages.BasePage;
import exps.web.pages.HomePage;
import exps.web.pages.SignInPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    // Логгер
    private static Logger logger = LogManager.getLogger(PageFactory.class);

    // Получение экземпляра страницы (пейдж обджекта)
    public static BasePage getPage(WebDriver driver, PageName name) {
        switch (name) {
            // Стартовая "Home"
            case HOME_PAGE:
                logger.info("Страница \"Home\"");
                HomePage homePage = new HomePage(driver);
                // Инициализация некоторых элементов страницы
                return homePage;
            // Страница "Sign In"
            case SIGN_IN_PAGE:
                logger.info("Страница \"Sign In\"");
                SignInPage signInPage = new SignInPage(driver);
                // Инициализация некоторых элементов страницы
                return signInPage;
            // По умолчанию
            default:
                throw new RuntimeException("Некорректное наименование страницы (пейдж обджекта)");
        }
    }
}
