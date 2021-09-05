package exps.web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Кнопка
public class Button extends Element {
    // Конструктор
    public Button(WebDriver driver, By by) {
        super(driver, by);
    }

    // Нажатие на кнопку
    public void click() {
        webElement.click();
    }
}
