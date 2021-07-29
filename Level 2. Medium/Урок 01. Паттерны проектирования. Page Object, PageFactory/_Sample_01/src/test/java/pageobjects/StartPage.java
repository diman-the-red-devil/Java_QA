package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class StartPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(StartPage.class);
    // URL страницы
    private final String URL = "https://www.dns-shop.ru/";

    // Конструктор класса
    public StartPage(WebDriver driver) {
        super(driver);
    }

    // Кнопка "Да" на всплывашке
    By linkYesXpath = By.xpath("//a[contains(text(),\"Да\")]");
    // Ссылка "Смартфоны и гаджеты"
    By linkSmartsAndGadgetsXpath = By.xpath("(//a[contains(text(), \"Смартфоны и гаджеты\")])[1]");
    // Ссылка "Смартфоны"
    By linkSmartsXpath = By.xpath("(//a[contains(text(), \"Смартфоны и гаджеты\")])[2]/following::div/a");

    // Получение URL страницы
    public String getURL() {
        return this.URL;
    }

    // Открытие страницы в браузере
    public void openPage() {
        driver.get(this.URL);
    }

    // Нажатие на кнопку "Да"
    public void linkYesClick() {
        WaitFor.presenceOfElementLocated(linkYesXpath);
        WebElement linkYes = driver.findElement(linkYesXpath);
        WaitFor.elementToBeClickable(linkYes);
        linkYes.click();
    }

    // Нажатие на ссылку "Смартфоны и гаджеты"
    public void linkSmartsAndGadgetsClick() {
        WaitFor.presenceOfElementLocated(linkSmartsAndGadgetsXpath);
        WebElement linkSmartsAndGadgets = driver.findElement(linkSmartsAndGadgetsXpath);
        WaitFor.elementToBeClickable(linkSmartsAndGadgets);
        linkSmartsAndGadgets.click();
    }

    // Нажатие на ссылку "Смартфоны"
    public void linkSmartsClick() {
        WaitFor.presenceOfElementLocated(linkSmartsXpath);
        WebElement linkSmarts = driver.findElement(linkSmartsXpath);
        WaitFor.elementToBeClickable(linkSmarts);
        linkSmarts.click();
    }
}
