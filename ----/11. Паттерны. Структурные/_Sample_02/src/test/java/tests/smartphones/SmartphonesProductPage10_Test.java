package tests.smartphones;

import helpers.JSExec;
import models.Smartphone;
import models.SmartphoneBuilder;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import org.junit.jupiter.api.Test;
import pages.SmartphoneProductPage;
import pages.SmartphonesPageWithElements;
import pages.StartPageWithElements;
import steps.SmartphoneProductPageSteps;
import steps.SmartphonesPageSteps;
import steps.StartPageSteps;
import tests.BaseTest2;
import tests.smartphones.SmartphoneProductPageAssert2;

// Тест
public class SmartphonesProductPage10_Test extends BaseTest2 {
    @Test
    // Проверка
    public void selectedProduct_Is_SamsungGalaxyNote20Ultra256GBWhite() {
        // 1. Arrange
        SmartphoneBuilder builder = new SmartphoneBuilder(
                new Ram(8),                      // Оперативная память
                new Company("Samsung"))          // Производитель
                .setRom(256)                     // Внутренняя память
                .setModel("S20");                // Модель
        Smartphone smartphone = builder.build(); // Создание объекта

        // 2. Act
        SmartphoneProductPageSteps smartphoneProductPageSteps = getProductPage(smartphone);

        // 3. Assert
        String expected = "Купить 6.7\" Смартфон Samsung Galaxy Z Flip3 256 ГБ бежевый в интернет магазине DNS. Характеристики, цена Samsung Galaxy Z Flip3 | 4845670";
        SmartphoneProductPageAssert2 smartphoneProductAssert = new SmartphoneProductPageAssert2(smartphoneProductPageSteps);
        smartphoneProductAssert.pageTitleEquals(expected);
    }

    // Получение страницы с продуктом
    public SmartphoneProductPageSteps getProductPage(Smartphone smartphone) {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        // ***** Стартовая страница сайта DNS *****
        StartPageSteps startPageSteps = new StartPageSteps(new StartPageWithElements(driver));
        // Нажатие на ссылку "Смартфоны"
        startPageSteps.clickLinkSmarts();
        // ***** Страница "Смартфоны" *****
        SmartphonesPageSteps smartphonesPageSteps = new SmartphonesPageSteps(new SmartphonesPageWithElements(driver));
        // Установка сортировки "Сначала дорогие"
        smartphonesPageSteps.orderByExpensiveFirst();
        // Установка фильтра "Производитель"
        smartphonesPageSteps.filterByCompany(smartphone.getCompany());
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPageSteps.filterByRAM(smartphone.getRam());
        // Нажатие на кнопку "Применить"
        smartphonesPageSteps.clickButtonApply() ;
        // Нажатие на ссылку первого продукта в списке
        smartphonesPageSteps.clickLinkFirstProduct("Смартфон Samsung Galaxy Z Flip3 256 ГБ бежевый");
        //smartphonesPageSteps.clickLinkFirstProduct("Смартфон Samsung Galaxy S20 FE 128 ГБ белый");
        // ***** Страница "Продукт. Смартфон" *****
        return new SmartphoneProductPageSteps(new SmartphoneProductPage(driver));
    }
}