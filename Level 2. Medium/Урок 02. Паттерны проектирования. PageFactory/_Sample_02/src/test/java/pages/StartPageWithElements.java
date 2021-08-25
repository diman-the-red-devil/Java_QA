package pages;

import elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Стартовая страница сайта DNS
public class StartPageWithElements extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(StartPage.class);
    // URL страницы
    private final String URL = "https://www.dns-shop.ru/";

    // ***** Локаторы *****
    // Кнопка "Да" на всплывашке
    String linkYesXpath = "//a[contains(text(),\"Да\")]";
    // Ссылка "Смартфоны и гаджеты"
    String linkSmartsAndGadgetsXpath = "(//a[contains(text(), \"Смартфоны и гаджеты\")])[1]";
    // Ссылка "Смартфоны"
    String linkSmartsXpath = "(//a[contains(text(), \"Смартфоны и гаджеты\")])[2]/following::div/a";

    // Конструктор класса
    public StartPageWithElements(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
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

    // Нажатие на кнопку "Да"
    public void linkYesClick() {
        Link linkYes = new Link(driver, By.xpath(linkYesXpath));
        linkYes.click();
        logger.info("Нажата кнопка \"Да\"");
    }

    // Наведение курсора мыши на ссылку "Смартфоны и гаджеты"
    public void linkSmartsAndGadgetsMove() {
        Link linkSmartsAndGadgets = new Link(driver, By.xpath(linkSmartsAndGadgetsXpath));
        linkSmartsAndGadgets.focusOnLink();
        logger.info("Курсор мыши наведен на ссылку \"Смартфоны\"");
    }

    // Нажатие на ссылку "Смартфоны"
    public void linkSmartsClick() {
        Link linkSmarts = new Link(driver, By.xpath(linkSmartsXpath));
        linkSmarts.click();
        logger.info("Нажата ссылка \"Смартфоны\"");
    }
}
