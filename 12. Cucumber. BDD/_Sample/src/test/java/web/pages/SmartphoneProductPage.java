package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// Страница "Продукт. Смартфон"
public class SmartphoneProductPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphoneProductPage.class);

    // Конструктор класса
    public SmartphoneProductPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }
}
