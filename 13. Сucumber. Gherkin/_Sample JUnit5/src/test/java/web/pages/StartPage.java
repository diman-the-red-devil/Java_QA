package web.pages;

import web.elements.Button;
import web.elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Стартовая страница сайта DNS
public class StartPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(StartPage.class);
    // URL страницы
    private final String URL = "https://www.dns-shop.ru/";

    // ***** Веб элементы *****
    // Кнопка "Всё верно" на всплывашке
    @FindBy(xpath = "(//span[text()=\"Всё верно\"]/parent::button)[1]")
    private WebElement buttonYes;
    // Ссылка "Смартфоны и гаджеты"
    @FindBy(xpath = "(//a[contains(text(), \"Смартфоны и фототехника\")])[1]")
    private WebElement linkSmartsAndGadgets;
    // Ссылка "Смартфоны"
    @FindBy(xpath = "//a[contains(text(), \"Смартфоны и гаджеты\")]/following-sibling::div/a[contains(text(), \"Смартфоны\")]")
    private WebElement linkSmarts;

    // Конструктор класса
    public StartPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // Получение URL страницы
    public String getURL() {
        return this.URL;
    }

    // Открытие страницы
    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }

    // ***** Получение обернутых веб элементов *****
    // Кнопка "Всё верно" на всплывашке
    public Button buttonYes() {
        return new Button(buttonYes);
    }
    // Ссылка "Смартфоны и гаджеты"
    public Link linkSmartsAndGadgets() {
        return new Link(linkSmartsAndGadgets);
    }
    // Ссылка "Смартфоны"
    public Link linkSmarts() {
        return new Link(linkSmarts);
    }
}
