package web.pages;

import web.elements.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// Страница "Смартфоны"
public class SmartphonesPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphonesPage.class);

    // ***** Веб элементы *****
    // 1. Блоки
    // Шапка
    @FindBy(xpath = "//header")
    private WebElement blockHeader;
    // 2. Фильтры и сортировка
    // 2.1. Сортировка
    // Аккордеон "Сортировка"
    @FindBy(xpath = "//span[contains(text(), \"Сортировка:\")]/following::a")
    private WebElement accordeonSort;
    // Переключатели "Сортировка"
    @FindBy(xpath = "(//div[@class=\"top-filter__radio-list ui-radio top-filter__popover\"])[1]//span")
    private List<WebElement> radiobuttonSort;
    // 2.2. Фильтр "Производитель"
    // Аккордеон "Производитель"
    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Производитель\"]")
    private WebElement accordeonCompany;
    // Чекбоксы "Производитель"
    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Производитель\"]/../../div//label/span[1]")
    private List<WebElement> checkboxCompany;
    // 2.3. Фильтр "Объем оперативной памяти"
    // Аккордеон "Объем оперативной памяти"
    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Объем оперативной памяти\"]")
    private WebElement accordeonRAM;
    // Чекбоксы "Объем оперативной памяти"
    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Объем оперативной памяти\"]/../../div//label/span[1]")
    private List<WebElement> checkboxRAM;
    // Кнопка "Применить"
    @FindBy(xpath = "//button[contains(text(), \"Применить\")]")
    private WebElement buttonApply;
    // 3. Список смартфонов
    // Ссылка на первый продукт в списке
    @FindBy(xpath = "(//a[contains(@class, \"catalog-product__name\")])[1]")
    private WebElement linkFirstProduct;

    // Конструктор класса
    public SmartphonesPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // ***** Получение обернутых веб элементов *****
    // 1. Блоки
    // Шапка
    public Block blockHeader() {
        return new Block(blockHeader);
    }
    // 2. Фильтры и сортировка
    // 2.1. Сортировка
    // Аккордеон "Сортировка"
    public Accordeon accordeonSort() {
        return new Accordeon(accordeonSort);
    }
    // Переключатели "Сортировка"
    public RadioButton radiobuttonSort(String type) {
        for (WebElement webElement : radiobuttonSort) {
            if(webElement.getText().contains(type)) {
                return new RadioButton(webElement);
            }
        }
        return null;
    }
    // 2.2. Фильтр "Производитель"
    // Аккордеон "Производитель"
    public Accordeon accordeonCompany() {
        return new Accordeon(accordeonCompany);
    }
    // Чекбоксы "Производитель"
    public CheckBox checkboxCompany(String company) {
        for (WebElement webElement : checkboxCompany) {
            if(webElement.getText().contains(company)) {
                return new CheckBox(webElement);
            }
        }
        return null;
    }
    // 2.3. Фильтр "Объем оперативной памяти"
    // Аккордеон "Объем оперативной памяти"
    public Accordeon accordeonRAM() {
        return new Accordeon(accordeonRAM);
    }
    // Чекбоксы "Объем оперативной памяти"
    public CheckBox checkboxRAM(String ram) {
        for (WebElement webElement : checkboxRAM) {
            if(webElement.getText().contains(ram)) {
                return new CheckBox(webElement);
            }
        }
        return null;
    }
    // Кнопка "Применить"
    public Button buttonApply() {
        return new Button(buttonApply);
    }
    // 3. Список смартфонов
    // Ссылка на первый продукт в списке
    public Link linkFirstProduct() {
        return new Link(linkFirstProduct);
    }
}
