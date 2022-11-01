package tests.smartphones;

import helpers.JavaScriptHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SmartphoneProductPagePF;
import pages.SmartphonesPagePF;
import pages.StartPagePF;
import tests.BaseTest;

// Паттерн Page Object Model + PageFactory
public class Pattern2PageFactoryTest extends BaseTest {
    @Test
    public void dnsTest() {
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
        String company = "Samsung"; // производитель
        smartphonesPage.checkboxCompanyClick(company);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Отображение фильтра "Объем оперативной памяти"
        smartphonesPage.accordeonRAMClick();
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Установка фильтра "Объем оперативной памяти"
        String ram = "8 Гб"; // объем ОП
        smartphonesPage.checkboxRAMClick(ram);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Нажатие на кнопку "Применить"
        smartphonesPage.buttonApplyClick();
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, -2000);
        // Нажатие на ссылку первого продукта в списке
        smartphonesPage.linkFirstProductClick();

        // ***** Страница "Продукт. Смартфон" *****
        SmartphoneProductPagePF smartphoneProductPage = new SmartphoneProductPagePF(driver);
        String actual = smartphoneProductPage.getPageTitle();

        // Проверка заголовка открытой страницы
        String expected = "Купить 6.8\" Смартфон Samsung Galaxy S22 Ultra 128 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S22 Ultra | 4900422";
        Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}
