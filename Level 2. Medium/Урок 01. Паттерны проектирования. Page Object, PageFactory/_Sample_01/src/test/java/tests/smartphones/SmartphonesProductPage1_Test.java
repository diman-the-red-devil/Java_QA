package tests.smartphones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SmartphoneProductPage;
import pages.SmartphonesPage;
import pages.StartPage;
import tests.BaseTest;

// Тест
public class SmartphonesProductPage1_Test extends BaseTest {

    @Test
    // Проверка
    public void selectedProduct_Is_SamsungGalaxyNote20Ultra256GBWhite() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        // ***** Стартовая страница сайта DNS *****
        StartPage startPage = new StartPage(driver);
        // Нажатие на ссылку "Смартфоны"
        startPage.linkSmartsAndGadgetsMove();
        startPage.linkSmartsClick();
        // ***** Страница "Смартфоны" *****
        SmartphonesPage smartphonesPage = new SmartphonesPage(driver);
        // Установка сортировки "Сначала дорогие"
        smartphonesPage.showSortClick();
        smartphonesPage.rbtnExpensiveClick();
        // Установка фильтра "Производитель"
        String product = "Samsung"; // производитель
        smartphonesPage.chbxProductClick(product);
        // Установка фильтра "Объем оперативной памяти"
        String ram = "8 Гб"; // объем ОП
        smartphonesPage.showRAMClick();
        smartphonesPage.chbxRAMClick(ram);
        smartphonesPage.btnApplyClick();
        // Открытие страницы с продуктом
        smartphonesPage.linkProductClick("Смартфон Samsung Galaxy Note 20 Ultra 256 ГБ белый");
        SmartphoneProductPage smartphoneProductPage = new SmartphoneProductPage(driver);
        // Проверка
        String expected = "Купить 6.9\" Смартфон Samsung Galaxy Note 20 Ultra 256 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy Note 20 Ultra | 1685908";
        String actual = smartphoneProductPage.getPageTitle();
        Assertions.assertEquals(expected, actual);
    }
}
