package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.pages.SmartphoneProductPage;

public class SmartphoneProductPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(SmartphoneProductPageSteps.class);

    // Ссылка на объект класса SmartphoneProductPage
    // Страница "Продукт. Смартфон"
    private SmartphoneProductPage smartphoneProductPage;

    // Конструктор
    public SmartphoneProductPageSteps(WebDriver driver) {
        // ***** Страница "Продукт. Смартфон" *****
        smartphoneProductPage = new SmartphoneProductPage(driver);
        logger.info("Открыта страница [Продукт. Смартфон]");
    }

    // Получение заголовка текущей страницы
    public String getPageTitle() {
        logger.info("Страница [Продукт. Смартфон]: Получение заголовка текущей страницы");
        return smartphoneProductPage.getPageTitle();
    }
}
