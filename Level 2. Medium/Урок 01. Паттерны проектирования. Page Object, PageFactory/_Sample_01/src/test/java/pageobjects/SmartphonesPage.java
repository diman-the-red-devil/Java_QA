package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartphonesPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(StartPage.class);

    // Конструктор класса
    public SmartphonesPage(WebDriver driver) {
        super(driver);
    }

    // ***** Фильтры *****
    // # Фильтр "Производитель"
    // Флажок "Samsung"
    By chbxSamsungXpath = By.xpath("//span[contains(text(), \"Samsung\")]");
    // # Фильтр "Объем оперативной памяти"
    // Гармошка "Объем оперативной памяти"
    By showRAMXpath = By.xpath("//div[@class=\"ui-list-controls ui-collapse ui-collapse_list\"]//span[contains(text(), \"Объем оперативной памяти\")]");
    // Флажок "8 Гб"
    By chbxRAM8GbXpath = By.xpath("//span[contains(text(), \"8 Гб\")]");
    // ***** Сортировка *****
    // Блок "Сортировка"
    By showSortXpath = By.xpath("//span[contains(text(), \"Сортировка:\")]/following::a");
    // Переключатель "Сначала дорогие"
    By rbtnExpensiveXpath = By.xpath("//span[contains(text(), \"Сначала дорогие\")]");
    // ***** Смартфоны *****
    // Ссылка на продукт
    By linkProductXpath = By.xpath("(//div[@data-id=\"product\"])[1]//a[@class=\"catalog-product__name ui-link ui-link_black\"]");

    //
    public void chbxSamsungClick() {
        WebElement chbxSamsung = driver.findElement(chbxSamsungXpath);
        chbxSamsung.click();
    }

    //
    public void showRAMClick() {
        WebElement showRAM = driver.findElement(showRAMXpath);
        showRAM.click();
    }

    //
    public void chbxRAM8GbClick() {
        WebElement chbxRAM8Gb = driver.findElement(chbxRAM8GbXpath);
        chbxRAM8Gb.click();
    }

    //
    public void showSortClick() {
        WebElement showSort = driver.findElement(showSortXpath);
        showSort.click();
    }

    //
    public void rbtnExpensiveClick() {
        WebElement rbtnExpensive = driver.findElement(rbtnExpensiveXpath);
        rbtnExpensive.click();
    }

    //
    public void linkProductClick() {
        WebElement linkProduct = driver.findElement(linkProductXpath);
        linkProduct.click();
    }
}
