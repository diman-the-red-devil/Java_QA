package web.elements;

import web.helpers.WaitHelper;
import org.openqa.selenium.WebElement;

// Класс "Текстовое поле ввода"
public class TextBox extends BaseElement {

    // Конструктор
    public TextBox(WebElement webElement) {
        super(webElement);
    }

    // Нажатие на текстовое поле ввода
    public void click() {
        // Ожидание кликабельности флажка текстового поля ввода
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }

    // Ввод значения в текстовое поле ввода
    public void setValue(String value) {
        // Ожидание кликабельности флажка текстового поля ввода
        WaitHelper.clickabilityOfElement(webElement);
        webElement.sendKeys(value);
    }
}
