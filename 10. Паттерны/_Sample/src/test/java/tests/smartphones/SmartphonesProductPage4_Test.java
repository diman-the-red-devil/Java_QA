package tests.smartphones;

import helpers.JSExec;
import org.junit.jupiter.api.Test;
import pages.*;
import tests.BaseTest;

// Тест
public class SmartphonesProductPage4_Test extends BaseTest {
    @Test
    // Проверка
    public void filterBySamsung8Gb_sortByExpansiveFirst_Test() {
        // 1. Arrange
        String product = "Samsung"; // производитель
        String ram = "8 Гб"; // объем ОП

        // 2. Act
        SmartphoneProductPage smartphoneProductPage = getProductPage(product, ram);

        // 3. Assert
        String expected = "Купить 6.6\" Смартфон Samsung Galaxy S22+ 256 ГБ розовый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S22+ | 9916150";
        SmartphoneProductPageAssert smartphoneProductAssert = new SmartphoneProductPageAssert(smartphoneProductPage);
        smartphoneProductAssert.pageTitleEquals(expected);
    }

    // Получение заголовка страницы с продуктом
    public SmartphoneProductPage getProductPage(String product, String ram) {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        // ***** Стартовая страница сайта DNS *****
        StartPageWithElements startPage = new StartPageWithElements(driver);
        // Наведение курсора мыши на ссылку "Смартфоны и гаджеты"
        startPage.linkSmartsAndGadgetsMove();
        // Нажатие на ссылку "Смартфоны"
        startPage.linkSmartsClick();

        // ***** Страница "Смартфоны" *****
        SmartphonesPageWithElements smartphonesPage = new SmartphonesPageWithElements(driver);
        // Нажатие на выпадашку "Сортировка"
        smartphonesPage.accordeonSortClick();
        // Установка сортировки "Сначала дорогие"
        smartphonesPage.rbtnExpensiveClick();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 600);
        // Установка фильтра "Производитель"
        smartphonesPage.chbxCompanyClick(product);
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Нажатие на гармошку "Объем оперативной памяти"
        smartphonesPage.accordeonRAMClick();
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