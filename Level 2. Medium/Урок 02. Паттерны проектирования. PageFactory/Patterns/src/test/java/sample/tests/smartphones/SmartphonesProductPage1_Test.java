package sample.tests.smartphones;

import sample.helpers.JSExec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.pages.SmartphoneProductPage;
import sample.pages.SmartphonesPage;
import sample.pages.StartPage;
import sample.tests.BaseTest;

// Тест с POM
public class SmartphonesProductPage1_Test extends BaseTest {

    @Test
    // Проверка
    public void selectedProduct_Is_SamsungGalaxyNote20Ultra256GBWhite() {
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
        JSExec.scrollBy(0, 300);
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
        JSExec.scrollBy(0, -500);
        // Нажатие на ссылку первого продукта в списке
        smartphonesPage.linkFirstProductClick("Смартфон Samsung Galaxy Z Flip3 256 ГБ бежевый");
        SmartphoneProductPage smartphoneProductPage = new SmartphoneProductPage(driver);
        // Проверка заголовка открытой страницы
        String expected = "Купить 6.7\" Смартфон Samsung Galaxy Z Flip3 256 ГБ бежевый в интернет магазине DNS. Характеристики, цена Samsung Galaxy Z Flip3 | 4845670";
        String actual = smartphoneProductPage.getPageTitle();
        Assertions.assertEquals(expected, actual);
    }
}
