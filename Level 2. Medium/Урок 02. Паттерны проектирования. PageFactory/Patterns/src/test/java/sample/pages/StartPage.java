package sample.pages;

import sample.helpers.WaitFor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

// Стартовая страница сайта DNS
public class StartPage extends BasePage {
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

    // Нажатие на кнопку "Да"
    public void linkYesClick() {
        WaitFor.presenceOfElementLocated(By.xpath(linkYesXpath));
        WebElement linkYes = driver.findElement(By.xpath(linkYesXpath));
        WaitFor.clickabilityOfElement(linkYes);
        linkYes.click();
        logger.info("Нажата кнопка \"Да\"");
    }

    // Наведение курсора мыши на ссылку "Смартфоны и гаджеты"
    public void linkSmartsAndGadgetsMove() {
        WaitFor.presenceOfElementLocated(By.xpath(linkSmartsAndGadgetsXpath));
        WebElement linkSmartsAndGadgets = driver.findElement(By.xpath(linkSmartsAndGadgetsXpath));
        Actions actions = new Actions(driver);
        actions.moveToElement(linkSmartsAndGadgets).perform();
        logger.info("Курсор мыши наведен на ссылку \"Смартфоны\"");
    }

    // Нажатие на ссылку "Смартфоны"
    public void linkSmartsClick() {
        WaitFor.visibilityOfElementLocated(By.xpath(linkSmartsXpath));
        WebElement linkSmarts = driver.findElement(By.xpath(linkSmartsXpath));
        WaitFor.clickabilityOfElement(linkSmarts);
        linkSmarts.click();
        logger.info("Нажата ссылка \"Смартфоны\"");
    }
}
