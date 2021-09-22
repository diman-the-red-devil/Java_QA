package web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.elements.Linkk;

// Стартовая страница сайта DNS
public class StartPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(StartPage.class);
    // URL страницы
    private final String URL = "https://www.dns-shop.ru/";

    // ***** Веб элементы *****
    // Кнопка "Да" на всплывашке
    @FindBy(xpath = "//a[contains(text(),\"Да\")]")
    private WebElement linkYes;
    // Ссылка "Смартфоны и гаджеты"
    @FindBy(xpath = "(//a[contains(text(), \"Смартфоны и гаджеты\")])[1]")
    private WebElement linkSmartsAndGadgets;
    // Ссылка "Смартфоны"
    @FindBy(xpath = "//a[text()=\"Смартфоны\"]")
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
    // Кнопка "Да" на всплывашке
    public Linkk linkYes() {
        return new Link(linkYes);
    }
    // Ссылка "Смартфоны и гаджеты"
    public Linkk linkSmartsAndGadget() {
        return new Link(linkSmartsAndGadgets);
    }
    // Ссылка "Смартфоны"
    public Linkk linkSmarts() {
        return new Link(linkSmarts);
    }
}
