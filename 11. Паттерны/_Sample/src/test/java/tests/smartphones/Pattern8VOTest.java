package tests.smartphones;

import helpers.JavaScriptHelper;
import models.SmartphoneVO;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import org.junit.jupiter.api.Test;
import pages.SmartphoneProductPagePFPE;
import pages.SmartphonesPagePFPE;
import pages.StartPagePFPE;
import tests.BaseTest;
import tests.smartphones.matchers.SmartphoneProductPageMatcherPFPE;

// Паттерн
// Page Object Model
// PageFactory
// Arrange Act Assert
// Assert Objects
// Page Elements
// JavaBean
// Value Objects
public class Pattern8VOTest extends BaseTest {
    @Test
    public void dnsTest() {
        // 1. Arrange
        String company = "Samsung"; // производитель
        int ram = 8; // объем ОП
        SmartphoneVO smartphoneVO = new SmartphoneVO(
                new Ram(ram),
                new Company(company)
        );

        // 2. Act
        SmartphoneProductPagePFPE smartphoneProductPage = getProductPage(smartphoneVO);

        // 3. Assert
        // Проверка заголовка открытой страницы
        String expected = "Купить 6.8\" Смартфон Samsung Galaxy S22 Ultra 128 ГБ белый в интернет магазине DNS. Характеристики, цена Samsung Galaxy S22 Ultra | 4900422";
        SmartphoneProductPageMatcherPFPE smartphoneProductPageMatcher = new SmartphoneProductPageMatcherPFPE(smartphoneProductPage);
        smartphoneProductPageMatcher.pageTitleEquals(expected);
    }

    // Получение заголовка страницы с продуктом
    public SmartphoneProductPagePFPE getProductPage(SmartphoneVO smartphoneVO) {
        // ***** Стартовая страница сайта DNS *****
        StartPagePFPE startPage = new StartPagePFPE(driver);
        // Открыть страницу https://www.dns-shop.ru/
        startPage.openPage();
        // Наведение курсора мыши на ссылку "Смартфоны и гаджеты"
        startPage.linkSmartsAndGadgets().focusOnLink();
        // Нажатие на ссылку "Смартфоны"
        startPage.linkSmarts().click();

        // ***** Страница "Смартфоны" *****
        SmartphonesPagePFPE smartphonesPage = new SmartphonesPagePFPE(driver);
        // Отображение сортировки
        smartphonesPage.accordeonSort().show();
        // Установка сортировки "Сначала дорогие"
        String type = "Сначала дорогие";
        smartphonesPage.radiobuttonSort(type).setSelected(true);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Установка фильтра "Производитель"
        smartphonesPage.checkboxCompany(smartphoneVO.getCompany().getCompany()).setChecked(true);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Отображение фильтра "Объем оперативной памяти"
        smartphonesPage.accordeonRAM().show();
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.checkboxRAM(smartphoneVO.getRam().getRam() + " Гб").setChecked(true);
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Нажатие на кнопку "Применить"
        smartphonesPage.buttonApply().click();
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, -2000);
        // Нажатие на ссылку первого продукта в списке
        smartphonesPage.linkFirstProduct().openInNewWindow();

        // ***** Страница "Продукт. Смартфон" *****
        return new SmartphoneProductPagePFPE(driver);
    }
}
