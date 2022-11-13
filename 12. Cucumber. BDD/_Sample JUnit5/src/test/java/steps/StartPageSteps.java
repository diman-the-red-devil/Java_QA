package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.drivers.WebDriverFactory;
import web.pages.StartPage;

// Шаги и проверки на странице "Стартовая"
public class StartPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(StartPageSteps.class);

    // Ссылка на объект класса StartPage
    // Страница "Стартовая страница сайта DNS"
    private StartPage startPage;

    // Шаг: Открыта страница "Стартовая страница сайта DNS"
    @Дано("Открыта страница \"Стартовая страница сайта DNS\"")
    public void openStartPage() {
        startPage = new StartPage(WebDriverFactory.getCurrentDriver());
        // Открыть сайт https://www.dns-shop.ru/
        startPage.openPage();
        logger.info("Страница [Стартовая страница DNS]: Открыта \"Стартовая страница сайта DNS\"");
    }

    // Шаг: Выполнен переход на страницу "Смартфоны"
    @Когда("Выполнен переход на страницу \"Смартфоны\"")
    public void goToSmartphonesPage() {
        // Наведение курсора мыши на ссылку "Смартфоны и гаджеты"
        startPage.linkSmartsAndGadgets().focusOnLink();
        // Нажатие на ссылку "Смартфоны"
        startPage.linkSmarts().click();
        logger.info("Страница [Стартовая страница DNS]: Выполнен переход на страницу \"Смартфоны\"");
    }
}
