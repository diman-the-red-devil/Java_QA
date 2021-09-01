package sample.tests.smartphones;

import helpers.JSExec;
import models.SmartphoneVO;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import org.junit.jupiter.api.Test;
import pages.SmartphoneProductPage;
import pages.SmartphonesPageWithElements;
import pages.StartPageWithElements;
import tests.BaseTest2;

// Тест
public class SmartphonesProductPage8_Test extends BaseTest2 {
    @Test
    // Проверка
    public void selectedProduct_Is_SamsungGalaxyNote20Ultra256GBWhite() {
        // 1. Arrange
        String product = "Samsung"; // производитель
        int ram = 8; // объем ОП
        SmartphoneVO smartphoneVO = new SmartphoneVO(
                new Ram(ram),
                new Company(product)
        );

        // 2. Act
        SmartphoneProductPage smartphoneProductPage = getProductPage(smartphoneVO);

        // 3. Assert
        String expected = "Купить 6.7\" Смартфон Samsung Galaxy Z Flip3 256 ГБ бежевый в интернет магазине DNS. Характеристики, цена Samsung Galaxy Z Flip3 | 4845670";
        SmartphoneProductPageAssert smartphoneProductAssert = new SmartphoneProductPageAssert(smartphoneProductPage);
        smartphoneProductAssert.pageTitleEquals(expected);
    }

    // Получение страницы с продуктом
    public SmartphoneProductPage getProductPage(SmartphoneVO smartphoneVO) {
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
        JSExec.scrollBy(0, 300);
        // Установка фильтра "Производитель"
        smartphonesPage.chbxCompanyClick(smartphoneVO.getCompany().getCompany());
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Нажатие на гармошку "Объем оперативной памяти"
        smartphonesPage.accordeonRAMClick();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.chbxRAMClick(smartphoneVO.getRam().getRam() + " Гб");
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Нажатие на кнопку "Применить"
        smartphonesPage.btnApplyClick();
        // Прокрутка страницы вверх
        JSExec.scrollBy(0, -500);
        // Нажатие на ссылку первого продукта в списке
        smartphonesPage.linkFirstProductClick("Смартфон Samsung Galaxy Z Flip3 256 ГБ бежевый");
        //smartphonesPage.linkFirstProductClick("Смартфон Samsung Galaxy S20 FE 128 ГБ белый");
        return new SmartphoneProductPage(driver);
    }
}