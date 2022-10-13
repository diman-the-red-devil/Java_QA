package pages;

import elements.Button;
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
    // Кнопка "Всё верно" на всплывашке
    String buttonYesXpath = "(//span[text()=\"Всё верно\"]/parent::button)[1]";
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

    // Нажатие на кнопку "Всё верно"
    public void buttonYesClick() {
        Button buttonYes = new Button(driver, By.xpath(buttonYesXpath));
        buttonYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
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
