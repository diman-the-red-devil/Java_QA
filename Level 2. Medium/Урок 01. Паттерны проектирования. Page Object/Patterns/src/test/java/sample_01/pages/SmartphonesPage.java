package sample_01.pages;

import sample_01.helpers.JSExec;
import sample_01.helpers.WaitFor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

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
    String headerXpath = "//header";
    // Фильтры
    // - Фильтр "Производитель"
    String chbxCompanyXpath = "//span[contains(text(), \"company\")]";
    // - Фильтр "Объем оперативной памяти"
    String showRAMXpath = "//div[@class=\"ui-list-controls ui-collapse ui-collapse_list\"]//span[contains(text(), \"Объем оперативной памяти\")]";
    String chbxRAMXpath = "//span[contains(text(), \"ram\")]";
    // Кнопка Применить
    String btnApplyXpath = "//button[contains(text(), \"Применить\")]";
    // Сортировка
    // - Выпадашка "Сортировка"
    String showSortXpath = "//span[contains(text(), \"Сортировка:\")]/following::a";
    // - Переключатель "Сначала дорогие"
    String rbtnExpensiveXpath = "//span[contains(text(), \"Сначала дорогие\")]";
    // Смартфоны
    // - Ссылка на продукт
    String linkProductXpath = "//span[contains(text(),\"product\")]/parent::a";

    // Нажатие на выпадашку "Сортировка"
    public void showSortClick() {
        WebElement header = driver.findElement(By.xpath(headerXpath));
        JSExec.displayNone(header);
        WaitFor.visibilityOfElementLocated(By.xpath(showSortXpath));
        WebElement showSort = driver.findElement(By.xpath(showSortXpath));
        WaitFor.clickabilityOfElement(showSort);
        showSort.click();
        logger.info("Нажата выпадашка \"Сортировка\"");
    }

    // Установка сортировки "Сначала дорогие"
    public void rbtnExpensiveClick() {
        WaitFor.visibilityOfElementLocated(By.xpath(rbtnExpensiveXpath));
        WebElement rbtnExpensive = driver.findElement(By.xpath(rbtnExpensiveXpath));
        WaitFor.clickabilityOfElement(rbtnExpensive);
        rbtnExpensive.click();
        logger.info("Установлена сортировка - \"Сначала дорогие\"");
    }

    // Установка фильтра "Производитель"
    public void chbxProductClick(String company) {
        JSExec.scrollBy(0, 300);
        chbxCompanyXpath = chbxCompanyXpath.replace("company", company);
        WaitFor.visibilityOfElementLocated(By.xpath(chbxCompanyXpath));
        WebElement chbxCompany = driver.findElement(By.xpath(chbxCompanyXpath));
        WaitFor.clickabilityOfElement(chbxCompany);
        chbxCompany.click();
        logger.info("Установлен фильтр \"Производитель\" - " + company);
    }

    // Нажатие на гармошку "Объем оперативной памяти"
    public void showRAMClick() {
        JSExec.scrollBy(0, 300);
        WaitFor.visibilityOfElementLocated(By.xpath(showRAMXpath));
        WebElement showRAM = driver.findElement(By.xpath(showRAMXpath));
        WaitFor.clickabilityOfElement(showRAM);
        showRAM.click();
        logger.info("Отображены значения фильтра \"Объем оперативной памяти\"");
    }

    // Установка фильтра "Объем оперативной памяти"
    public void chbxRAMClick(String ram) {
        JSExec.scrollBy(0, 300);
        chbxRAMXpath = chbxRAMXpath.replace("ram", ram);
        WaitFor.visibilityOfElementLocated(By.xpath(chbxRAMXpath));
        WebElement chbxRAM = driver.findElement(By.xpath(chbxRAMXpath));
        WaitFor.clickabilityOfElement(chbxRAM);
        chbxRAM.click();
        logger.info("Установлен фильтр \"Объем оперативной памяти\" - " + ram);
    }

    // Нажатие на кнопку "Применить"
    public void btnApplyClick() {
        JSExec.scrollBy(0, 300);
        WaitFor.visibilityOfElementLocated(By.xpath(btnApplyXpath));
        WebElement btnApply = driver.findElement(By.xpath(btnApplyXpath));
        WaitFor.clickabilityOfElement(btnApply);
        btnApply.click();
        logger.info("Нажата кнопка \"Применить\"");
    }

    // Нажатие на ссылку первого продукта в списке
    public void linkProductClick(String product) {
        JSExec.scrollBy(0, -500);
        linkProductXpath = linkProductXpath.replace("product", product);
        WaitFor.visibilityOfElementLocated(By.xpath(linkProductXpath));
        WebElement linkProduct = driver.findElement(By.xpath(linkProductXpath));
        String URL = linkProduct.getAttribute("href");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        logger.info("Нажата кнопка первого продукта в списке");
    }
}
