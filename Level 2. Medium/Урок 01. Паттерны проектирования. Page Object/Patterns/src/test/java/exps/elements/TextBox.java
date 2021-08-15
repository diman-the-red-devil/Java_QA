package exps.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Текстовое поле
public class TextBox extends Element {
    // Конструктор
    public TextBox(WebDriver driver, By by) {
        super(driver, by);
    }

    // Нажатие на текстовое поле
    public void click() {
        webElement.click();
    }

    // Ввод значения в текстовое поле
    public void setValue(String text) {
        webElement.sendKeys(text);
    }
}
