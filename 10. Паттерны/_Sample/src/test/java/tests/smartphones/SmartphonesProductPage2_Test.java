package tests.smartphones;

import helpers.JSExec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SmartphoneProductPage;
import pages.SmartphonesPage;
import pages.StartPage;
import tests.BaseTest;

// Тест с POM и AAA
public class SmartphonesProductPage2_Test extends BaseTest {

    @Test
    // Проверка
    public void filterBySamsung8Gb_sortByExpansiveFirst_Test() {
        // 1. Arrange
        String product = "Samsung"; // производитель
        String ram = "8 Гб"; // объем ОП

        // 2. Act
        SmartphoneProductPage smartphoneProductPage = getProductPage(product, ram);
        String actual = smartphoneProductPage.getPageTitle();

        // 3. Assert
        String expected = "Купить 6.6\" Смартфон Samsung Galaxy S22+ 256 ГБ розовый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S22+ | 9916150";
        Assertions.assertEquals(expected, actual);
    }

    // Получение заголовка страницы с продуктом
    public SmartphoneProductPage getProductPage(String product, String ram) {
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
        smartphonesPage.chbxProductClick(product);
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Нажатие на гармошку "Объем оперативной памяти"
        smartphonesPage.showRAMClick();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.chbxRAMClick(ram);
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Нажатие на кнопку "Применить"
        smartphonesPage.btnApplyClick();
        // Прокрутка страницы вверх
        JSExec.scrollBy(0, -1500);
        // Нажатие на ссылку первого продукта в списке
        smartphonesPage.linkFirstProductClick("Смартфон Samsung Galaxy S22+ 256 ГБ розовый");
        return new SmartphoneProductPage(driver);
    }
}
