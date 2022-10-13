package tests.smartphones;

import helpers.JSExec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Sleeper;
import pages.SmartphoneProductPage;
import pages.SmartphonesPage;
import pages.StartPage;
import tests.BaseTest;

import java.time.Duration;

// Тест с POM
public class SmartphonesProductPage1_Test extends BaseTest {

    @Test
    // Проверка
    public void filterBySamsung8Gb_sortByExpansiveFirst_Test() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");

        // ***** Стартовая страница сайта DNS *****
        StartPage startPage = new StartPage(driver);
        // Наведение курсора мыши на ссылку "Смартфоны и гаджеты"
        startPage.linkSmartsAndGadgetsMove();
        // Нажатие на ссылку "Смартфоны"
        startPage.linkSmartsClick();

        // ***** Страница "Смартфоны" *****
        SmartphonesPage smartphonesPage = new SmartphonesPage(driver);
        // Нажатие на выпадашку "Сортировка"
        smartphonesPage.showSortClick();
        // Установка сортировки "Сначала дорогие"
        smartphonesPage.rbtnExpensiveClick();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 600);
        // Установка фильтра "Производитель"
        String product = "Samsung"; // производитель
        smartphonesPage.chbxProductClick(product);
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Нажатие на гармошку "Объем оперативной памяти"
        smartphonesPage.showRAMClick();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Установка фильтра "Объем оперативной памяти"
        String ram = "8 Гб"; // объем ОП
        smartphonesPage.chbxRAMClick(ram);
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Нажатие на кнопку "Применить"
        smartphonesPage.btnApplyClick();
        // Прокрутка страницы вверх
        JSExec.scrollBy(0, -1500);
        // Нажатие на ссылку первого продукта в списке
        smartphonesPage.linkFirstProductClick("Смартфон Samsung Galaxy S22+ 256 ГБ розовый");
        SmartphoneProductPage smartphoneProductPage = new SmartphoneProductPage(driver);
        // Проверка заголовка открытой страницы
        String expected = "Купить 6.6\" Смартфон Samsung Galaxy S22+ 256 ГБ розовый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S22+ | 9916150";
        String actual = smartphoneProductPage.getPageTitle();
        Assertions.assertEquals(expected, actual);
    }
}
