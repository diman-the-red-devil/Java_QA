package pages;

import helpers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Страница "Смартфоны"
public class SmartphonesPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphonesPage.class);

    // ***** Локаторы *****
    // 1. Блоки
    // Шапка
    String blockHeaderXpath = "//header";
    // 2. Фильтры и сортировка
    // 2.1. Сортировка
    // Аккордеон "Сортировка"
    String accordeonSortXpath = "//span[contains(text(), \"Сортировка:\")]/following::a";
    // Переключатель "Сортировка"
    String radiobuttonSortXpath = "//span[contains(text(), \"type\")]";
    // 2.2. Фильтр "Производитель"
    // Аккордеон "Производитель"
    String accordeonCompanyXpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Производитель\"]";
    // Чекбокс "Производитель"
    String checkboxCompanyXpath = "//span[contains(text(), \"company\")]";
    // 2.3. Фильтр "Объем оперативной памяти"
    // Аккордеон "Объем оперативной памяти"
    String accordeonRAMXpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Объем оперативной памяти\"]";
    // Чекбокс "Объем оперативной памяти"
    String checkboxRAMXpath = "//span[contains(text(), \"ram\")]";
    // Кнопка "Применить"
    String buttonApplyXpath = "//button[contains(text(), \"Применить\")]";
    // 3. Список смартфонов
    // Ссылка на первый продукт в списке
    String linkFirstProductXpath = "(//a[contains(@class, \"catalog-product__name\")])[1]";

    // Конструктор класса
    public SmartphonesPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
    }

    // ***** Действия на странице *****
    // 1. Блоки
    // Скрытие шапки
    public void blockHeaderHide() {
        WebElement blockHeader = driver.findElement(By.xpath(blockHeaderXpath));
        JavaScriptHelper.displayNone(blockHeader);
    }
    // 2. Фильтры и сортировка
    // 2.1. Сортировка
    // Отображение сортировки
    public void accordeonSortClick() {
        WaitHelper.visibilityOfElementLocated(By.xpath(accordeonSortXpath));
        WebElement accordeonSort = driver.findElement(By.xpath(accordeonSortXpath));
        WaitHelper.clickabilityOfElement(accordeonSort);
        accordeonSort.click();
        logger.info("Отображена сортировка");
    }
    // Установка сортировки
    public void radiobuttonSortClick(String type) {
        radiobuttonSortXpath = radiobuttonSortXpath.replace("type", type);
        WaitHelper.visibilityOfElementLocated(By.xpath(radiobuttonSortXpath));
        WebElement radiobuttonSort = driver.findElement(By.xpath(radiobuttonSortXpath));
        WaitHelper.clickabilityOfElement(radiobuttonSort);
        radiobuttonSort.click();
        logger.info("Установлена сортировка - \"" + type + "\"");
    }
    // 2.2. Фильтр "Производитель"
    // Отображение фильтра "Производитель"
    public void accordeonCompanyClick() {
        WaitHelper.visibilityOfElementLocated(By.xpath(accordeonCompanyXpath));
        WebElement accordeonCompany = driver.findElement(By.xpath(accordeonCompanyXpath));
        WaitHelper.clickabilityOfElement(accordeonCompany);
        accordeonCompany.click();
        logger.info("Отображен фильтр \"Производитель\"");
    }
    // Установка фильтра "Производитель"
    public void checkboxCompanyClick(String company) {
        checkboxCompanyXpath = checkboxCompanyXpath.replace("company", company);
        WaitHelper.visibilityOfElementLocated(By.xpath(checkboxCompanyXpath));
        WebElement checkboxCompany = driver.findElement(By.xpath(checkboxCompanyXpath));
        WaitHelper.clickabilityOfElement(checkboxCompany);
        checkboxCompany.click();
        logger.info("Установлен фильтр \"Производитель\" - " + company);
    }
    // 2.3. Фильтр "Объем оперативной памяти"
    // Отображение фильтра "Объем оперативной памяти"
    public void accordeonRAMClick() {
        WaitHelper.visibilityOfElementLocated(By.xpath(accordeonRAMXpath));
        WebElement accordeonRAM = driver.findElement(By.xpath(accordeonRAMXpath));
        WaitHelper.clickabilityOfElement(accordeonRAM);
        accordeonRAM.click();
        logger.info("Отображен фильтр \"Объем оперативной памяти\"");
    }
    // Установка фильтра "Объем оперативной памяти"
    public void checkboxRAMClick(String ram) {
        checkboxRAMXpath = checkboxRAMXpath.replace("ram", ram);
        WaitHelper.visibilityOfElementLocated(By.xpath(checkboxRAMXpath));
        WebElement checkboxRAM = driver.findElement(By.xpath(checkboxRAMXpath));
        WaitHelper.clickabilityOfElement(checkboxRAM);
        checkboxRAM.click();
        logger.info("Установлен фильтр \"Объем оперативной памяти\" - " + ram);
    }
    // Нажатие на кнопку "Применить"
    public void buttonApplyClick() {
        WaitHelper.visibilityOfElementLocated(By.xpath(buttonApplyXpath));
        WebElement buttonApply = driver.findElement(By.xpath(buttonApplyXpath));
        WaitHelper.clickabilityOfElement(buttonApply);
        buttonApply.click();
        logger.info("Нажата кнопка \"Применить\"");
    }
    // 3. Список смартфонов
    // Нажатие на ссылку первого продукта в списке
    public void linkFirstProductClick(String product) {
        WaitHelper.firstProductMustBe(By.xpath(linkFirstProductXpath), product);
        WebElement linkFirstProduct = driver.findElement(By.xpath(linkFirstProductXpath));
        String URL = linkFirstProduct.getAttribute("href");
        SwitchHelper.switchToNewWindow();
        WindowHelper.maximizeWindow();
        NavigationHelper.navigateTo(URL);
        logger.info("Нажата ссылка первого продукта в списке");
    }
}
