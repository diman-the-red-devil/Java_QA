package web.pages;

import web.elements.*;
import web.helpers.WaitFor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Страница "Смартфоны"
public class SmartphonesPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphonesPage.class);

    // Конструктор класса
    public SmartphonesPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
    }

    // ***** Локаторы *****
    // Шапка
    String mainBlockXpath = "//header";
    // Фильтры
    // - Фильтр "Производитель"
    String chbxCompanyXpath = "//span[contains(text(), \"company\")]";
    // - Фильтр "Объем оперативной памяти"
    String accordeonRAMXpath = "//div[@class=\"ui-list-controls ui-collapse ui-collapse_list\"]//span[contains(text(), \"Объем оперативной памяти\")]";
    String chbxRAMXpath = "//span[contains(text(), \"ram\")]";
    // Кнопка Применить
    String btnApplyXpath = "//button[contains(text(), \"Применить\")]";
    // Сортировка
    // - Выпадашка "Сортировка"
    String accordeonSortXpath = "//span[contains(text(), \"Сортировка:\")]/following::a";
    // - Переключатель "Сначала дорогие"
    String rbtnExpensiveXpath = "//span[contains(text(), \"Сначала дорогие\")]";
    // Смартфоны
    // - Ссылка на первый продукт в списке
    String linkFirstProductXpath = "(//a[contains(@class, \"catalog-product__name\")])[1]";

    // Скрытие шапки
    public void mainBlockHide() {
        MainBlock mainBlock = new MainBlock(driver, By.xpath(mainBlockXpath));
        mainBlock.hide();
    }

    // Нажатие на выпадашку "Сортировка"
    public void accordeonSortClick() {
        Accordeon accordeonSort = new Accordeon(driver, By.xpath(accordeonSortXpath));
        accordeonSort.show();
        logger.info("Нажата выпадашка \"Сортировка\"");
    }

    // Установка сортировки "Сначала дорогие"
    public void rbtnExpensiveClick() {
        RadioButton rbtnExpensive = new RadioButton(driver, By.xpath(rbtnExpensiveXpath));
        rbtnExpensive.setSelected(true);
        logger.info("Установлена сортировка - \"Сначала дорогие\"");
    }

    // Установка фильтра "Производитель"
    public void chbxCompanyClick(String company) {
        chbxCompanyXpath = chbxCompanyXpath.replace("company", company);
        CheckBox chbxCompany = new CheckBox(driver, By.xpath(chbxCompanyXpath));
        chbxCompany.setChecked(true);
        logger.info("Установлен фильтр \"Производитель\" - " + company);
    }

    // Нажатие на гармошку "Объем оперативной памяти"
    public void accordeonRAMClick() {
        Accordeon accordeonRAM = new Accordeon(driver, By.xpath(accordeonRAMXpath));
        accordeonRAM.show();
        logger.info("Отображены значения фильтра \"Объем оперативной памяти\"");
    }

    // Установка фильтра "Объем оперативной памяти"
    public void chbxRAMClick(String ram) {
        chbxRAMXpath = chbxRAMXpath.replace("ram", ram);
        CheckBox chbxRAM = new CheckBox(driver, By.xpath(chbxRAMXpath));
        chbxRAM.setChecked(true);
        logger.info("Установлен фильтр \"Объем оперативной памяти\" - " + ram);
    }

    // Нажатие на кнопку "Применить"
    public void btnApplyClick() {
        Button btnApply = new Button(driver, By.xpath(btnApplyXpath));
        btnApply.click();
        logger.info("Нажата кнопка \"Применить\"");
    }

    // Нажатие на ссылку первого продукта в списке
    public void linkFirstProductClick(String product) {
        WaitFor.firstProductMustBe(By.xpath(linkFirstProductXpath), product);
        Link linkProduct = new Link(driver, By.xpath(linkFirstProductXpath));
        linkProduct.openInNewWindow();
        logger.info("Нажата ссылка первого продукта в списке");
    }
}
