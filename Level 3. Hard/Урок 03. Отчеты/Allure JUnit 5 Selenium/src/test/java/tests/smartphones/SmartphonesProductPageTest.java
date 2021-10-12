package tests.smartphones;

import io.qameta.allure.*;
import models.Smartphone;
import models.SmartphoneBuilder;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import org.junit.jupiter.api.Test;
import web.pages.SmartphoneProductPage;
import web.pages.SmartphonesPage;
import web.pages.StartPage;
import steps.SmartphoneProductPageSteps;
import steps.SmartphonesPageSteps;
import steps.StartPageSteps;
import tests.BaseTest;

// Тест
@Epic("DNS. Смартфоны")
@Feature("Страница продукта Смартфон")
public class SmartphonesProductPageTest extends BaseTest {
    @Test
    @Description("Проверка заголовка страницы первого товара из списка")
    @Issue("Task-001")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.dns-shop.ru/")
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
        String expected = "Купить 6.9\" Смартфон Samsung Galaxy Note 20 Ultra 256 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy Note 20 Ultra | 1685908";
        SmartphoneProductPageAssert smartphoneProductAssert = new SmartphoneProductPageAssert(smartphoneProductPageSteps);
        smartphoneProductAssert.pageTitleEquals(expected);
    }

    // Получение страницы с продуктом
    public SmartphoneProductPageSteps getProductPage(Smartphone smartphone) {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        // ***** Стартовая страница сайта DNS *****
        StartPageSteps startPageSteps = new StartPageSteps(new StartPage(driver));
        // Нажатие на ссылку "Смартфоны"
        startPageSteps.clickLinkSmarts();
        // ***** Страница "Смартфоны" *****
        SmartphonesPageSteps smartphonesPageSteps = new SmartphonesPageSteps(new SmartphonesPage(driver));
        // Установка сортировки "Сначала дорогие"
        smartphonesPageSteps.orderByExpensiveFirst();
        // Установка фильтра "Производитель"
        smartphonesPageSteps.filterByCompany(smartphone.getCompany());
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPageSteps.filterByRAM(smartphone.getRam());
        // Нажатие на кнопку "Применить"
        smartphonesPageSteps.clickButtonApply() ;
        // Нажатие на ссылку первого продукта в списке
        smartphonesPageSteps.clickLinkFirstProduct("Смартфон Samsung Galaxy Note 20 Ultra 256 ГБ белый");
        //smartphonesPageSteps.clickLinkFirstProduct("Смартфон Samsung Galaxy S20 FE 128 ГБ белый");
        // ***** Страница "Продукт. Смартфон" *****
        return new SmartphoneProductPageSteps(new SmartphoneProductPage(driver));
    }
}