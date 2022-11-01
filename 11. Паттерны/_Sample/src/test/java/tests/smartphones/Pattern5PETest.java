package tests.smartphones;

import helpers.JavaScriptHelper;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Sleeper;
import pages.SmartphoneProductPagePFPE;
import pages.SmartphonesPagePFPE;
import pages.StartPagePFPE;
import tests.BaseTest;
import tests.smartphones.matchers.SmartphoneProductPageMatcherPFPE;

import java.time.Duration;

// Паттерн
// Page Object Model
// PageFactory
// Arrange Act Assert
// Assert Objects
// Page Elements
public class Pattern5PETest extends BaseTest {
    @Test
    public void dnsTest() {
        // 1. Arrange
        String company = "Samsung"; // производитель
        String ram = "8 Гб"; // объем ОП

        // 2. Act
        SmartphoneProductPagePFPE smartphoneProductPage = getProductPage(company, ram);

        // 3. Assert
        // Проверка заголовка открытой страницы
        String expected = "Купить 6.8\" Смартфон Samsung Galaxy S22 Ultra 128 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S22 Ultra | 4900422";
        SmartphoneProductPageMatcherPFPE smartphoneProductPageMatcher = new SmartphoneProductPageMatcherPFPE(smartphoneProductPage);
        smartphoneProductPageMatcher.pageTitleEquals(expected);
    }

    // Получение заголовка страницы с продуктом
    public SmartphoneProductPagePFPE getProductPage(String company, String ram) {
        // ***** Стартовая страница сайта DNS *****
        StartPagePFPE startPage = new StartPagePFPE(driver);
        // Открыть страницу https://www.dns-shop.ru/
        startPage.openPage();
        // Наведение курсора мыши на ссылку "Смартфоны и гаджеты"
        startPage.linkSmartsAndGadgets().focusOnLink();
        // Нажатие на ссылку "Смартфоны"
        startPage.linkSmarts().click();

        // ***** Страница "Смартфоны" *****
        SmartphonesPagePFPE smartphonesPage = new SmartphonesPagePFPE(driver);
        // Отображение сортировки
        smartphonesPage.accordeonSort().show();
        // Установка сортировки "Сначала дорогие"
        String type = "Сначала дорогие";
        smartphonesPage.radiobuttonSort(type).setSelected(true);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Установка фильтра "Производитель"
        smartphonesPage.checkboxCompany(company).setChecked(true);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Отображение фильтра "Объем оперативной памяти"
        smartphonesPage.accordeonRAM().show();
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.checkboxRAM(ram).setChecked(true);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Нажатие на кнопку "Применить"
        smartphonesPage.buttonApply().click();
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, -2000);
        // Нажатие на ссылку первого продукта в списке
        smartphonesPage.linkFirstProduct().openInNewWindow();

        // ***** Страница "Продукт. Смартфон" *****
        return new SmartphoneProductPagePFPE(driver);
    }
}
