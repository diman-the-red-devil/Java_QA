package tests.smartphones;

import models.SmartphoneBL;
import models.SmartphoneBLBuilder;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import org.junit.jupiter.api.Test;
import steps.SmartphoneProductPageSteps;
import steps.SmartphonesPageSteps;
import steps.StartPageSteps;
import tests.BaseTestWF;
import tests.smartphones.matchers.SmartphoneProductPageMatcherFC;

// Паттерн
// Page Object Model
// PageFactory
// Arrange Act Assert
// Assert Objects
// Page Elements
// JavaBean
// Value Objects
// Builder
// Facade
// WebDriverFactory
public class Pattern11WFTest extends BaseTestWF {

    @Test
    public void dnsTest() {
        // 1. Arrange
        String company = "Samsung"; // производитель
        String model = "S22";          // модель
        int ram = 8;                // объем оперативной памяти
        int rom = 256;              // объем внутренней памяти

        SmartphoneBLBuilder builder = new SmartphoneBLBuilder(
                new Ram(ram),
                new Company(company))
                .setRom(rom)
                .setModel(model);
        SmartphoneBL smartphoneBL = builder.build(); // Создание объекта

        // 2. Act
        SmartphoneProductPageSteps smartphoneProductPage = getProductPage(smartphoneBL);

        // 3. Assert
        // Проверка заголовка открытой страницы
        String expected = "Купить 6.8\" Смартфон Samsung Galaxy S22 Ultra 128 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S22 Ultra | 4900422";
        SmartphoneProductPageMatcherFC smartphoneProductPageMatcher = new SmartphoneProductPageMatcherFC(smartphoneProductPage);
        smartphoneProductPageMatcher.pageTitleEquals(expected);
    }

    // Получение заголовка страницы с продуктом
    public SmartphoneProductPageSteps getProductPage(SmartphoneBL smartphoneBL) {
        // ***** Стартовая страница сайта DNS *****
        StartPageSteps startPage = new StartPageSteps(driver);
        // Переход на страницу "Смартфоны"
        startPage.goToSmartphonesPage();

        // ***** Страница "Смартфоны" *****
        SmartphonesPageSteps smartphonesPage = new SmartphonesPageSteps(driver);
        // Установка сортировки "Сначала дорогие"
        String type = "Сначала дорогие";
        smartphonesPage.orderBy(type);
        // Установка фильтра "Производитель"
        smartphonesPage.filterByCompany(smartphoneBL.getCompany().getCompany());
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.filterByRAM(smartphoneBL.getRam().getRam());
        // Применение фильтров
        smartphonesPage.applyFilters();
        // Переход на страницу первого продукта в списке
        smartphonesPage.goToFirstProduct();

        // ***** Страница "Продукт. Смартфон" *****
        return new SmartphoneProductPageSteps(driver);
    }
}
