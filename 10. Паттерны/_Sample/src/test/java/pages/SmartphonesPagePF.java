package pages;

import helpers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// Страница "Смартфоны"
public class SmartphonesPagePF extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphonesPagePF.class);

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
    public SmartphonesPagePF(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // ***** Действия на странице *****
    // 1. Блоки
    // Скрытие шапки
    public void blockHeaderHide() {
        JavaScriptHelper.displayNone(blockHeader);
    }
    // 2. Фильтры и сортировка
    // 2.1. Сортировка
    // Отображение сортировки
    public void accordeonSortClick() {
        WaitHelper.clickabilityOfElement(accordeonSort);
        accordeonSort.click();
        logger.info("Отображена сортировка");
    }
    // Установка сортировки
    public void radiobuttonSortClick(String type) {
        for (WebElement webElement : radiobuttonSort) {
            if(webElement.getText().contains(type)) {
                WaitHelper.clickabilityOfElement(webElement);
                webElement.click();
                break;
            }
        }
        logger.info("Установлена сортировка - \"" + type + "\"");
    }
    // 2.2. Фильтр "Производитель"
    // Отображение фильтра "Производитель"
    public void accordeonCompanyClick() {
        WaitHelper.clickabilityOfElement(accordeonCompany);
        accordeonCompany.click();
        logger.info("Отображен фильтр \"Производитель\"");
    }
    // Установка фильтра "Производитель"
    public void checkboxCompanyClick(String company) {
        for (WebElement webElement : checkboxCompany) {
            if(webElement.getText().contains(company)) {
                WaitHelper.clickabilityOfElement(webElement);
                webElement.click();
                break;
            }
        }
        logger.info("Установлен фильтр \"Производитель\" - " + company);
    }
    // 2.3. Фильтр "Объем оперативной памяти"
    // Отображение фильтра "Объем оперативной памяти"
    public void accordeonRAMClick() {
        WaitHelper.clickabilityOfElement(accordeonRAM);
        accordeonRAM.click();
        logger.info("Отображен фильтр \"Объем оперативной памяти\"");
    }
    // Установка фильтра "Объем оперативной памяти"
    public void checkboxRAMClick(String ram) {
        for (WebElement webElement : checkboxRAM) {
            if(webElement.getText().contains(ram)) {
                WaitHelper.clickabilityOfElement(webElement);
                webElement.click();
                break;
            }
        }
        logger.info("Установлен фильтр \"Объем оперативной памяти\" - " + ram);
    }
    // Нажатие на кнопку "Применить"
    public void buttonApplyClick() {
        WaitHelper.clickabilityOfElement(buttonApply);
        buttonApply.click();
        logger.info("Нажата кнопка \"Применить\"");
    }
    // 3. Список смартфонов
    // Нажатие на ссылку первого продукта в списке
    public void linkFirstProductClick(String product) {
        String URL = linkFirstProduct.getAttribute("href");
        SwitchHelper.switchToNewWindow();
        WindowHelper.maximizeWindow();
        NavigationHelper.navigateTo(URL);
        logger.info("Нажата ссылка первого продукта в списке");
    }
}
