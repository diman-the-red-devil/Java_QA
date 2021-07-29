package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(StartPage.class);
    // URL
    private final String URL = "https://www.dns-shop.ru/";

    // Конструктор класса
    public StartPage(WebDriver driver) {
        super(driver);
    }

    public String getURL() {
        return this.URL;
    }

    // Кнопка "Да" на всплывашке
    By linkYesXpath = By.xpath("//a[contains(text(),\"Да\")]");
    // Ссылка "Смартфоны и гаджеты"
    By linkSmartsAndGadgetsXpath = By.xpath("(//a[contains(text(), \"Смартфоны и гаджеты\")])[1]");
    // Ссылка "Смартфоны"
    By linkSmartsXpath = By.xpath("(//a[contains(text(), \"Смартфоны и гаджеты\")])[2]/following::div/a");

    public void openPage() {
        driver.get(this.URL);
    }

    public void linkYesClick() {
        WebElement linkYes = driver.findElement(linkYesXpath);
        linkYes.click();
    }

    public void linkSmartsAndGadgetsClick() {
        WebElement linkSmartsAndGadgets = driver.findElement(linkSmartsAndGadgetsXpath);
        linkSmartsAndGadgets.click();
    }

    public void linkSmartsClick() {
        WebElement linkSmarts = driver.findElement(linkSmartsXpath);
        linkSmarts.click();
    }
}
