package pages;

import helpers.ActionHelper;
import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Стартовая страница сайта DNS
public class StartPagePF extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(StartPagePF.class);
    // URL страницы
    private final String URL = "https://www.dns-shop.ru/";

    // ***** Веб элементы *****
    // Кнопка "Всё верно" на всплывашке
    @FindBy(xpath = "(//span[text()=\"Всё верно\"]/parent::button)[1]")
    private WebElement buttonYes;
    // Ссылка "Смартфоны и гаджеты"
    @FindBy(xpath = "(//a[contains(text(), \"Смартфоны и гаджеты\")])[1]")
    private WebElement linkSmartsAndGadgets;
    // Ссылка "Смартфоны"
    @FindBy(xpath = "(//a[contains(text(), \"Смартфоны и гаджеты\")])[2]/following::div/a")
    private WebElement linkSmarts;

    // Конструктор класса
    public StartPagePF(WebDriver driver) {
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

    // ***** Действия на странице *****
    // Нажатие на кнопку "Всё верно" на всплывашке
    public void buttonYesClick() {
        WaitHelper.clickabilityOfElement(buttonYes);
        buttonYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
    }
    // Наведение курсора мыши на ссылку "Смартфоны и гаджеты"
    public void linkSmartsAndGadgetsMove() {
        ActionHelper.moveToElement(linkSmartsAndGadgets);
        logger.info("Курсор мыши наведен на ссылку \"Смартфоны\"");
    }
    // Нажатие на ссылку "Смартфоны"
    public void linkSmartsClick() {
        WaitHelper.clickabilityOfElement(linkSmarts);
        linkSmarts.click();
        logger.info("Нажата ссылка \"Смартфоны\"");
    }
}
