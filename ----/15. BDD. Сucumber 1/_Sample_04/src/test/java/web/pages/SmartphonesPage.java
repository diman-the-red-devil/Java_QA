package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;
import web.elements.*;
import web.helpers.WaitHelper;

import java.time.Duration;

// Страница "Смартфоны"
public class SmartphonesPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphonesPage.class);

    // ***** Веб элементы *****
    // Шапка
    @FindBy(xpath = "//header")
    private WebElement mainBlock;
    // Фильтры
    // Фильтр "Производитель"
    // Блок с чекбоксами "Производитель"
    @FindBy(xpath = "//span[text()=\"Производитель\"]/parent::a/following-sibling::div//div[@class=\"ui-checkbox-group ui-checkbox-group_list\"]")
    private WebElement divCompany;
    // Фильтр "Объем оперативной памяти"
    // Аккордеон "Объем оперативной памяти"
    @FindBy(xpath = "//div[@class=\"ui-list-controls ui-collapse ui-collapse_list\"]//span[contains(text(), \"Объем оперативной памяти\")]")
    private WebElement accordeonRAM;
    // Блок с чекбоксами "Объем оперативной памяти"
    @FindBy(xpath = "//span[text()=\"Объем оперативной памяти\"]/parent::a/following-sibling::div//div[@class=\"ui-checkbox-group ui-checkbox-group_list\"]")
    private WebElement divRAM;
    // Кнопка "Применить"
    @FindBy(xpath = "//button[contains(text(), \"Применить\")]")
    private WebElement buttonApply;
    // Сортировка
    // Аккордеон "Сортировка"
    @FindBy(xpath = "//span[contains(text(), \"Сортировка:\")]/following::a")
    private WebElement accordeonSort;
    // Блок с переключателями "Сортировка"
    @FindBy(xpath = "(//div[@class=\"top-filter__radio-list ui-radio top-filter__popover\"])[1]")
    private WebElement divSort;
    // Смартфоны
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
    // 1. Шапка
    public MainBlock mainBlock() {
        return new MainBlock(mainBlock);
    }
    // 2. Фильтры
    // Фильтр "Производитель"
    // Чекбокс "Производитель"
    public CheckBox checkBoxCompany(String company) {
        return new CheckBox(findCheckBoxCompany(company));
    }
    // Поиск чекбокса "Производитель"
    private WebElement findCheckBoxCompany(String company) {
        WaitHelper.visibilityOfElement(divCompany);
        return divCompany.findElement(By.xpath("./label/span[contains(text(), \"" + company + "\")]"));
    }

    // Фильтр "Объем оперативной памяти"
    // Аккордеон "Объем оперативной памяти"
    public Accordeon accordeonRAM() {
        return new Accordeon(accordeonRAM);
    }
    // Чекбокс "Объем оперативной памяти"
    public CheckBox checkBoxRAM(String ram) {
        return new CheckBox(findCheckBoxRAM(ram));
    }
    // Поиск чекбокса "Объем оперативной памяти"
    private WebElement findCheckBoxRAM(String ram) {
        WaitHelper.visibilityOfElement(divRAM);
        return divRAM.findElement(By.xpath("./label/span[contains(text(), \"" + ram + "\")]"));
    }

    // Кнопка Применить
    public Button buttonApply() {
        return new Button(buttonApply);
    }
    // 3. Сортировка
    // Аккордеон "Сортировка"
    public Accordeon accordeonSort() {
        return new Accordeon(accordeonSort);
    }
    // Переключатель "Сортировка"
    public RadioButton radioButtonSort(String sort) {
        return new RadioButton(findRadioButtonSort(sort));
    }
    // Поиск переключателя "Сортировка"
    private WebElement findRadioButtonSort(String sort) {
        WaitHelper.visibilityOfElement(divSort);
        return divSort.findElement(By.xpath("//span[contains(text(), \"" + sort + "\")]"));
    }

    // 4. Ссылка на первый продукт в списке
    public Link linkFirstProduct() {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Link(linkFirstProduct);
    }
}
