package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

// Страница "Продукт. Смартфон"
public class SmartphoneProductPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphoneProductPage.class);

    // Конструктор класса
    public SmartphoneProductPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
    }

    // Получение заголовка текущей страницы
    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Заголовок страницы: " + title);
        return title;
    }
}
