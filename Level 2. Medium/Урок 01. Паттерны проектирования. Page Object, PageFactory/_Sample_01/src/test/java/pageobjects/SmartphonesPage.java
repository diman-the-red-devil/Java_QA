package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartphonesPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphonesPage.class);

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
    // Выпадашка "Сортировка"
    By showSortXpath = By.xpath("//span[contains(text(), \"Сортировка:\")]/following::a");
    // Переключатель "Сначала дорогие"
    By rbtnExpensiveXpath = By.xpath("//span[contains(text(), \"Сначала дорогие\")]");
    // ***** Смартфоны *****
    // Ссылка на продукт
    By linkProductXpath = By.xpath("(//div[@data-id=\"product\"])[1]//a[@class=\"catalog-product__name ui-link ui-link_black\"]");

    // Нажатие на флажок "Samsung"
    public void chbxSamsungClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script1 = "window.scrollBy(0,300);";
        js.executeScript(script1);
        logger.info("Проскроллено вниз");

        WaitFor.visibilityOfElementLocated(chbxSamsungXpath);
        WebElement chbxSamsung = driver.findElement(chbxSamsungXpath);
        WaitFor.elementToBeClickable(chbxSamsung);
        chbxSamsung.click();
    }

    // Нажатие на гармошку "Объем оперативной памяти"
    public void showRAMClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script1 = "window.scrollBy(0,300);";
        js.executeScript(script1);
        logger.info("Проскроллено вниз");

        WaitFor.visibilityOfElementLocated(showRAMXpath);
        WebElement showRAM = driver.findElement(showRAMXpath);
        WaitFor.elementToBeClickable(showRAM);
        showRAM.click();
    }

    // Нажатие на флажок "8 Гб"
    public void chbxRAM8GbClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script1 = "window.scrollBy(0,300);";
        js.executeScript(script1);
        logger.info("Проскроллено вниз");

        WaitFor.visibilityOfElementLocated(chbxRAM8GbXpath);
        WebElement chbxRAM8Gb = driver.findElement(chbxRAM8GbXpath);
        WaitFor.elementToBeClickable(chbxRAM8Gb);
        chbxRAM8Gb.click();
    }

    // Нажатие на выпадашку "Сортировка"
    public void showSortClick() {
        WaitFor.visibilityOfElementLocated(showSortXpath);
        WebElement showSort = driver.findElement(showSortXpath);
        WaitFor.elementToBeClickable(showSort);
        showSort.click();
    }

    // Нажатие на переключатель "Сначала дорогие"
    public void rbtnExpensiveClick() {
        WaitFor.visibilityOfElementLocated(rbtnExpensiveXpath);
        WebElement rbtnExpensive = driver.findElement(rbtnExpensiveXpath);
        WaitFor.elementToBeClickable(rbtnExpensive);
        rbtnExpensive.click();
    }

    // Нажатие на ссылку на продукт
    public void linkProductClick() {
        // Изменение отображаемости элемента
        String headerXpath = "//header";
        WebElement header = driver.findElement(By.xpath(headerXpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].style.display='none';";
        js.executeScript(script, header);

        String script1 = "window.scrollBy(0,-400);";
        js.executeScript(script1);
        logger.info("Проскроллено вверх");

        WaitFor.visibilityOfElementLocated(linkProductXpath);
        WebElement linkProduct = driver.findElement(linkProductXpath);
        WaitFor.elementToBeClickable(linkProduct);
        linkProduct.click();
    }
}
