package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import web.drivers.WebDriverFactory;
import web.pages.SmartphoneProductPage;

public class SmartphoneProductPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(SmartphoneProductPageSteps.class);

    // Ссылка на объект класса SmartphoneProductPage
    // Страница "Продукт. Смартфон"
    private SmartphoneProductPage smartphoneProductPage;

    // Шаг: Открыта страница "Продукт. Смартфон"
    @Дано("Открыта страница \"Продукт. Смартфон\"")
    public void openSmartphoneProductPage() {
        smartphoneProductPage = new SmartphoneProductPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Продукт. Смартфон]: Открыта страница \"Продукт. Смартфон\"");
    }

    // Проверка: Заголовок страницы соответствует ожидаемому
    @Тогда("Проверка: Заголовок страницы соответствует ожидаемому")
    public void assertPageTitle() {
        String expected = "Купить 6.8\" Смартфон Samsung Galaxy S22 Ultra 128 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S22 Ultra | 4900422";
        String actual = smartphoneProductPage.getPageTitle();
        Assertions.assertEquals(expected, actual, "Страница [Продукт. Смартфон]: Ошибка! Заголовок страницы не соответствует ожидаемому!");
        logger.info("Страница [Продукт. Смартфон]: Заголовок страницы соответствует ожидаемому");
    }
}
