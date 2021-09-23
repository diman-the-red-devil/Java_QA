package web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// Класс "Таблица"
public class Table extends BaseElement {
    // Конструктор
    public Table(WebElement webElement) {
        super(webElement);
    }

    // Получение значения ячеек таблицы
    public String getDataValue(String dataName) {
        String xpath = "//table//td//span[contains(text(), \"" + dataName +
                "\")]/ancestor::td/following-sibling::td//span";
        return webElement.findElement(By.xpath(xpath)).getText();
    }
}