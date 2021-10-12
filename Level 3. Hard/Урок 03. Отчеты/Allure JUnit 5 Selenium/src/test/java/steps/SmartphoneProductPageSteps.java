package steps;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.pages.SmartphoneProductPage;

// Шаги на странице "Продукт. Смартфон"
public class SmartphoneProductPageSteps {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphoneProductPageSteps.class);

    // Ссылка на объект класса SmartphoneProductPage
    private SmartphoneProductPage smartphoneProductPage;

    // Конструктор
    public SmartphoneProductPageSteps(SmartphoneProductPage smartphoneProductPage) {
        // ***** Страница "Продукт. Смартфон" *****
        this.smartphoneProductPage = smartphoneProductPage;
        logger.info("Открыта страница [Продукт. Смартфон]");
    }

    // Получение заголовка текущей страницы
    @Step("Получение заголовка текущей страницы")
    public String pageTitle() {
        return smartphoneProductPage.getPageTitle();
    }
}
