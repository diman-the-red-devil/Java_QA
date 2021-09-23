package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс "Гармошка"
public class Accordeon extends BaseElement {
    // Конструктор
    public Accordeon(WebElement webElement) {
        super(webElement);
    }

    // Раскрытие гармошки
    public void show() {
        // Ожидание кликабельности гармошки
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
