package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import web.drivers.BrowserName;
import web.drivers.WebDriverFactory;
import web.pages.SmartphonesPage;
import web.pages.StartPage;

// Шаги
public class SmartphoneSteps {
    // Драйвер браузера
    protected static WebDriver driver;
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphoneSteps.class);

    @Дано("Запущен браузер и открыта Главная страница ДНС")
    public void startDriverAndOpenStartPage() {
        // Запустить драйвер
        driver = WebDriverFactory.getDriver(BrowserName.fromString("Chrome"));
        logger.info("Драйвер стартовал!");
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта Стартовая страница сайта DNS");
    }

    @Когда("Выполнен переход на страницу Смартфоны")
    public void openSmartphonesPage() {
        StartPage startPage = new StartPage(driver);
        startPage.linkYes().click();
        startPage.linkSmartsAndGadget().focusOnLink();
        startPage.linkSmarts().click();
        logger.info("Выполнен переход на страницу Смартфоны");
    }

    @Тогда("Проверить: В заголовке страницы отображается текст Смартфоны")
    public void assertTitle() {
        SmartphonesPage smartphonesPage = new SmartphonesPage(driver);
        // Проверка заголовка страницы
        Assertions.assertTrue(smartphonesPage.getPageTitle().contains("Смартфоны"));
        // Если драйвер еще существует
        if(driver != null) {
            // Закрываем его
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
