package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.StartPagePFPE;

// Шаги на странице "Стартовая"
public class StartPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(StartPageSteps.class);

    // Ссылка на объект класса StartPagePFPE
    // Стартовая страница сайта DNS
    private StartPagePFPE startPage;

    // Конструктор
    public StartPageSteps(WebDriver driver) {
        // ***** Стартовая страница сайта DNS *****
        startPage = new StartPagePFPE(driver);
        // Открыть сайт https://www.dns-shop.ru/
        startPage.openPage();
        logger.info("Открыта страница [Стартовая страница DNS]");
    }

    // Переход на страницу "Смартфоны"
    public void goToSmartphonesPage() {
        // Наведение курсора мыши на ссылку "Смартфоны и гаджеты"
        startPage.linkSmartsAndGadgets().focusOnLink();
        // Нажатие на ссылку "Смартфоны"
        startPage.linkSmarts().click();
        logger.info("Страница [Стартовая страница DNS]: Переход на страницу \"Смартфоны\"");
    }
}
