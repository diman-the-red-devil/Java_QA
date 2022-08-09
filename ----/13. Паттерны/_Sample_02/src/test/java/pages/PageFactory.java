package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import webdriverfactory.*;

// Фабрика по созданию экземпляров страниц (пейдж обджектов)
public class PageFactory {
    // Логгер
    private static Logger logger = LogManager.getLogger(PageFactory.class);

    // Получение экземпляра страницы (пейдж обджекта)
    public static BasePage getPage(WebDriver driver, PageName name) {
        switch (name) {
            // Стартовая страница
            case START_PAGE:
                logger.info("Стартовая страница");
                StartPageWithElements startPageWithElements = new StartPageWithElements(driver);
                // Инициализация некоторых элементов страницы
                return startPageWithElements;
            // Страница "Смартфоны"
            case SMARTPHONES_PAGE:
                logger.info("Страница \"Смартфоны\"");
                SmartphonesPageWithElements smartphonesPageWithElements = new SmartphonesPageWithElements(driver);
                // Инициализация некоторых элементов страницы
                return smartphonesPageWithElements;
            // Страница "Продукт. Смартфон"
            case SMARTPHONE_PRODUCT_PAGE:
                logger.info("Страница \"Продукт. Смартфон\"");
                SmartphoneProductPage smartphoneProductPage = new SmartphoneProductPage(driver);
                // Инициализация некоторых элементов страницы
                return smartphoneProductPage;
            // По умолчанию
            default:
                throw new RuntimeException("Некорректное наименование страницы (пейдж обджекта)");
        }
    }
}
