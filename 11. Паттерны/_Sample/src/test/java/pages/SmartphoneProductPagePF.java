package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// Страница "Продукт. Смартфон"
public class SmartphoneProductPagePF extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphoneProductPagePF.class);

    // Конструктор класса
    public SmartphoneProductPagePF(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }
}
