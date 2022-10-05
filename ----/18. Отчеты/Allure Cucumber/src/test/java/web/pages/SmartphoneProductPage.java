package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;
import web.elements.Table;
import web.helpers.WaitHelper;

// Страница "Продукт. Смартфон"
public class SmartphoneProductPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphoneProductPage.class);

    // ***** Веб элементы *****
    // Ссылка "Характеристики"
    @FindBy(xpath = "//a[text()=\"Характеристики\"]")
    private WebElement linkCharacteristics;
    // Таблица "Характеристики"
    @FindBy(xpath = "//table")
    private WebElement tableCharacteristics;

    // Конструктор класса
    public SmartphoneProductPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // ***** Получение обернутых веб элементов *****
    // Ссылка "Характеристики"
    public Link linkCharacteristics() {
        WaitHelper.visibilityOfElement(linkCharacteristics);
        return new Link(linkCharacteristics);
    }
    // Таблица "Характеристики"
    public Table tableCharacteristics() {
        WaitHelper.visibilityOfElement(tableCharacteristics);
        return new Table(tableCharacteristics);
    }
}
