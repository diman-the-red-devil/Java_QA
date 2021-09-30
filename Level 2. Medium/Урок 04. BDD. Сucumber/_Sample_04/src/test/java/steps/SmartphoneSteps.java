package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import web.pages.SmartphoneProductPage;
import web.pages.SmartphonesPage;
import web.pages.StartPage;

import java.time.Duration;

// Шаги
public class SmartphoneSteps {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphoneSteps.class);
    // Страницы
    StartPage startPage;
    SmartphonesPage smartphonesPage;
    SmartphoneProductPage smartphoneProductPage;

    @Дано("Открыта Главная страница ДНС")
    public void startDriverAndOpenStartPage() {
        startPage = new StartPage(WebDriverFactory.getCurrentDriver());
        smartphonesPage = new SmartphonesPage(WebDriverFactory.getCurrentDriver());
        smartphoneProductPage = new SmartphoneProductPage(WebDriverFactory.getCurrentDriver());
        // Открыть страницу https://www.dns-shop.ru/
        WebDriverFactory.getCurrentDriver().get("https://www.dns-shop.ru/");
        logger.info("Открыта Стартовая страница сайта DNS");
    }

    @Когда("Выполнен переход на страницу Смартфоны")
    public void openSmartphonesPage() {
        startPage.linkYes().click();
        startPage.linkSmartsAndGadget().focusOnLink();
        startPage.linkSmarts().click();
        logger.info("Выполнен переход на страницу Смартфоны");
    }

    @Тогда("Проверить: В заголовке страницы отображается текст Смартфоны")
    public void assertTitle() {
        // Проверка заголовка страницы
        logger.info("Проверка заголовка страницы");
        Assertions.assertTrue(smartphonesPage.getPageTitle().contains("Смартфоны"), "В заголовке страницы не отображается текст Смартфоны");
    }

    @И("Установлена сортировка {string}")
    public void setSortBy(String sortBy) {
        smartphonesPage.accordeonSort().show();
        smartphonesPage.radioButtonSort(sortBy).setSelected(true);
        logger.info("Установлена сортировка" + sortBy);
    }

    @И("В фильтре {string} выбрано значение {string}")
    public void setFilterBy(String filterBy, String value) {
        JavaScriptHelper.scrollBy(0,400);
        switch (filterBy) {
            case "Производитель":
                smartphonesPage.checkBoxCompany(value).setChecked(true);
                break;
            case "Объем оперативной памяти":
                smartphonesPage.accordeonRAM().show();
                smartphonesPage.checkBoxRAM(value).setChecked(true);
                break;
        }
        logger.info("В фильтре " + filterBy + " выбрано значение " + value);
    }

    @И("Применены выбранные фильтры")
    public void applyFilters() {
        JavaScriptHelper.scrollBy(0,400);
        smartphonesPage.buttonApply().click();
        logger.info("Применены выбранные фильтры");
    }

    @И("Выполнен переход на страницу первого товара из списка")
    public void selectFirstSmartphone() {
        JavaScriptHelper.scrollBy(0, -600);
        smartphonesPage.linkFirstProduct().click();
        logger.info("Выполнен переход на страницу первого товара из списка");
    }

    @Тогда("Проверить: В заголовке страницы отображается текст {string}")
    public void assertTitleSmartphoneProduct(String company) {
        // Проверка заголовка страницы
        logger.info("Проверка заголовка страницы");
        Assertions.assertTrue(smartphoneProductPage.getPageTitle().contains(company), "В заголовке страницы не отображается текст " + company);
    }
}
