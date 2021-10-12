package web.elements;

import web.helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс "Гармошка"
public class Accordeon extends BaseElement {
    // Конструктор
    public Accordeon(WebDriver driver, By by) {
        super(driver, by);
    }

    // Раскрытие гармошки
    public void show() {
        WaitFor.visibilityOfElementLocated(by);
        WaitFor.clickabilityOfElement(webElement);
        webElement.click();
    }
}
