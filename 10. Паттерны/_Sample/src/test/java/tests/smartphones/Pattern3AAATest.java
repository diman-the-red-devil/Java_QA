package tests.smartphones;

import helpers.JavaScriptHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Sleeper;
import pages.SmartphoneProductPagePF;
import pages.SmartphonesPagePF;
import pages.StartPagePF;
import tests.BaseTest;

import java.time.Duration;

// Паттерн Page Object Model + PageFactory + Arrange Act Assert
public class Pattern3AAATest extends BaseTest {
    @Test
    public void dnsTest() {
        // 1. Arrange
        String company = "Samsung"; // производитель
        String ram = "8 Гб"; // объем ОП

        // 2. Act
        SmartphoneProductPagePF smartphoneProductPage = getProductPage(company, ram);
        String actual = smartphoneProductPage.getPageTitle();

        // 3. Assert
        // Проверка заголовка открытой страницы
        String expected = "Купить 6.8\" Смартфон Samsung Galaxy S22 Ultra 128 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S22 Ultra | 4900422";
        Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }

    // Получение заголовка страницы с продуктом
    public SmartphoneProductPagePF getProductPage(String company, String ram) {
        // ***** Стартовая страница сайта DNS *****
        StartPagePF startPage = new StartPagePF(driver);
        // Открыть страницу https://www.dns-shop.ru/
        startPage.openPage();
        // Наведение курсора мыши на ссылку "Смартфоны и гаджеты"
        startPage.linkSmartsAndGadgetsMove();
        // Нажатие на ссылку "Смартфоны"
        startPage.linkSmartsClick();

        // ***** Страница "Смартфоны" *****
        SmartphonesPagePF smartphonesPage = new SmartphonesPagePF(driver);
        // Отображение сортировки
        smartphonesPage.accordeonSortClick();
        // Установка сортировки "Сначала дорогие"
        String type = "Сначала дорогие";
        smartphonesPage.radiobuttonSortClick(type);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Установка фильтра "Производитель"
        smartphonesPage.checkboxCompanyClick(company);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Отображение фильтра "Объем оперативной памяти"
        smartphonesPage.accordeonRAMClick();
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.checkboxRAMClick(ram);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Нажатие на кнопку "Применить"
        smartphonesPage.buttonApplyClick();
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, -2000);
        // Нажатие на ссылку первого продукта в списке
        smartphonesPage.linkFirstProductClick("Смартфон Samsung Galaxy S22 Ultra 128 ГБ белый");

        // ***** Страница "Продукт. Смартфон" *****
        return new SmartphoneProductPagePF(driver);
    }
}
