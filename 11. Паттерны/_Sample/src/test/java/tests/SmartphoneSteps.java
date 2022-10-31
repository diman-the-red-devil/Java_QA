package tests;

import helpers.JavaScriptHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.SmartphoneProductPagePFPE;
import pages.SmartphonesPagePFPE;
import pages.StartPagePFPE;

// Шаги "Смартфоны"
public class SmartphoneSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(SmartphoneSteps.class);
    // Веб драйвер
    private WebDriver driver;

    // Стартовая страница сайта DNS
    private StartPagePFPE startPage;
    // Страница "Смартфоны"
    private SmartphonesPagePFPE smartphonesPage;
    // Страница "Продукт. Смартфон"
    private SmartphoneProductPagePFPE smartphoneProductPage;

    // Конструктор
    public SmartphoneSteps(WebDriver driver) {
        this.driver = driver;
        startPage = new StartPagePFPE(driver);
        smartphonesPage = new SmartphonesPagePFPE(driver);
        smartphoneProductPage = new SmartphoneProductPagePFPE(driver);
    }

    public void openStartPage() {
        // Открыть страницу https://www.dns-shop.ru/
        startPage.openPage();
    }

    public void goToSmartphonesPage() {
        // Наведение курсора мыши на ссылку "Смартфоны и гаджеты"
        startPage.linkSmartsAndGadgets().focusOnLink();
        // Нажатие на ссылку "Смартфоны"
        startPage.linkSmarts().click();
    }

    public void sortBy(String type) {
        // Отображение сортировки
        smartphonesPage.accordeonSort().show();
        // Установка сортировки "Сначала дорогие"
        smartphonesPage.radiobuttonSort(type).setSelected(true);
    }

    public void filterByCompany(String company) {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Установка фильтра "Производитель"
        smartphonesPage.checkboxCompany(company).setChecked(true);
    }

    public void filterByRAM(String ram) {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Отображение фильтра "Объем оперативной памяти"
        smartphonesPage.accordeonRAM().show();
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.checkboxRAM(ram + " Гб").setChecked(true);
    }

    public void applyFilters() {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Нажатие на кнопку "Применить"
        smartphonesPage.buttonApply().click();
    }

    public SmartphoneProductPagePFPE goToFirstProduct() {
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, -2000);
        // Нажатие на ссылку первого продукта в списке
        smartphonesPage.linkFirstProduct().openInNewWindow();
        return smartphoneProductPage;
    }
}
