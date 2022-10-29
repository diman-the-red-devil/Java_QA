package pages;

import helpers.ActionHelper;
import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Стартовая страница сайта DNS
public class StartPage extends BasePage {
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
    public StartPage(WebDriver driver) {
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

    // ***** Действия на странице *****
    // Нажатие на кнопку "Всё верно" на всплывашке
    public void buttonYesClick() {
        WaitHelper.presenceOfElementLocated(By.xpath(buttonYesXpath));
        WebElement linkYes = driver.findElement(By.xpath(buttonYesXpath));
        WaitHelper.clickabilityOfElement(linkYes);
        linkYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
    }
    // Наведение курсора мыши на ссылку "Смартфоны и гаджеты"
    public void linkSmartsAndGadgetsMove() {
        WaitHelper.presenceOfElementLocated(By.xpath(linkSmartsAndGadgetsXpath));
        WebElement linkSmartsAndGadgets = driver.findElement(By.xpath(linkSmartsAndGadgetsXpath));
        ActionHelper.moveToElement(linkSmartsAndGadgets);
        logger.info("Курсор мыши наведен на ссылку \"Смартфоны\"");
    }
    // Нажатие на ссылку "Смартфоны"
    public void linkSmartsClick() {
        WaitHelper.visibilityOfElementLocated(By.xpath(linkSmartsXpath));
        WebElement linkSmarts = driver.findElement(By.xpath(linkSmartsXpath));
        WaitHelper.clickabilityOfElement(linkSmarts);
        linkSmarts.click();
        logger.info("Нажата ссылка \"Смартфоны\"");
    }
}
