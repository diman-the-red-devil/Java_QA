package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс "Текстовое поле ввода"
public class TextBox extends BaseElement {
    // Конструктор
    public TextBox(WebDriver driver, By by) {
        super(driver, by);
    }

    // Нажатие на текстовое поле ввода
    public void click() {
        WaitFor.visibilityOfElementLocated(by);
        WaitFor.clickabilityOfElement(webElement);
        webElement.click();
    }

    // Ввод значения в текстовое поле ввода
    public void setValue(String value) {
        WaitFor.visibilityOfElementLocated(by);
        webElement.sendKeys(value);
    }
}
