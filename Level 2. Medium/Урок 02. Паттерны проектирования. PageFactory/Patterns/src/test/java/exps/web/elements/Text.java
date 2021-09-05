package exps.web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Текст
public class Text extends Element {
    // Конструктор
    public Text(WebDriver driver, By by) {
        super(driver, by);
    }

    // Получение текста
    public String getText() {
        return webElement.getText();
    }
}
