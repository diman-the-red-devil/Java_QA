package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// Страница "Продукт. Смартфон"
public class SmartphoneProductPagePFPE extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphoneProductPagePFPE.class);

    // Конструктор класса
    public SmartphoneProductPagePFPE(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }
}
