package web.elements;

import org.openqa.selenium.WebElement;

// Класс "Текстовое поле ввода"
public class TextBox extends BaseElement {
    // Конструктор
    public TextBox(WebElement webElement) {
        super(webElement);
    }

    // Нажатие на текстовое поле ввода
    public void click() {
        webElement.click();
    }

    // Ввод значения в текстовое поле ввода
    public void setValue(String value) {
        webElement.sendKeys(value);
    }
}
