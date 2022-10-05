package steps;

import io.qameta.allure.Step;
import web.helpers.JSExec;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.pages.SmartphonesPage;


// Шаги на странице "Смартфоны"
public class SmartphonesPageSteps {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphonesPageSteps.class);

    // Ссылка на объект класса SmartphonesPageWithElements
    private SmartphonesPage smartphonesPage;

    // Конструктор
    public SmartphonesPageSteps(SmartphonesPage smartphonesPage) {
        // ***** Страница "Смартфоны" *****
        this.smartphonesPage = smartphonesPage;
        logger.info("Открыта страница [Смартфоны]");
    }

    // Установка сортировки "Сначала дорогие"
    @Step("Установка сортировки \"Сначала дорогие\"")
    public void orderByExpensiveFirst() {
        // Нажатие на выпадашку "Сортировка"
        smartphonesPage.accordeonSortClick();
        // Установка сортировки "Сначала дорогие"
        smartphonesPage.rbtnExpensiveClick();
    }

    // Установка фильтра "Производитель"
    @Step("Установка фильтра \"Производитель\"")
    public void filterByCompany(Company company) {
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Установка фильтра "Производитель"
        smartphonesPage.chbxCompanyClick(company.getCompany());
    }

    // Установка фильтра "Объем оперативной памяти"
    @Step("Установка фильтра \"Объем оперативной памяти\"")
    public void filterByRAM(Ram ram) {
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Нажатие на гармошку "Объем оперативной памяти"
        smartphonesPage.accordeonRAMClick();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.chbxRAMClick(ram.getRam() + " Гб");
    }

    // Нажатие на кнопку "Применить"
    @Step("Нажатие на кнопку \"Применить\"")
    public void clickButtonApply() {
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Нажатие на кнопку "Применить"
        smartphonesPage.btnApplyClick();
    }

    // Нажатие на ссылку первого продукта в списке
    @Step("Нажатие на ссылку первого продукта в списке")
    public void clickLinkFirstProduct(String product) {
        // Прокрутка страницы вверх
        JSExec.scrollBy(0, -500);
        // Нажатие на ссылку первого продукта в списке
        smartphonesPage.linkFirstProductClick(product);
    }
}
