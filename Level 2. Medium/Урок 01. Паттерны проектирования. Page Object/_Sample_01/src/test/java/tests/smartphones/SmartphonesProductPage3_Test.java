package tests.smartphones;

import org.junit.jupiter.api.Test;
import pages.SmartphoneProductPage;
import pages.SmartphonesPage;
import pages.StartPage;
import tests.BaseTest;

// Тест
public class SmartphonesProductPage3_Test extends BaseTest {

    @Test
    // Проверка
    public void selectedProduct_Is_SamsungGalaxyNote20Ultra256GBWhite() {
        // 1. Arrange
        String product = "Samsung"; // производитель
        String ram = "8 Гб"; // объем ОП

        // 2. Act
        SmartphoneProductPage smartphoneProductPage = getProductPage(product, ram);

        // 3. Assert
        String expected = "Купить 6.9\" Смартфон Samsung Galaxy Note 20 Ultra 256 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy Note 20 Ultra | 1685908";
        SmartphoneProductPageAssert smartphoneProductAssert = new SmartphoneProductPageAssert(smartphoneProductPage);
        smartphoneProductAssert.pageTitleEquals(expected);
    }

    // Получение заголовка страницы с продуктом
    public SmartphoneProductPage getProductPage(String product, String ram) {
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
        smartphonesPage.chbxProductClick(product);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.showRAMClick();
        smartphonesPage.chbxRAMClick(ram);
        smartphonesPage.btnApplyClick();
        // Открытие страницы с продуктом
        smartphonesPage.linkProductClick("Смартфон Samsung Galaxy Note 20 Ultra 256 ГБ белый");
        return new SmartphoneProductPage(driver);
    }
}
