package elements;

import org.openqa.selenium.WebElement;

// Класс Текстовое Поле (TextBox)
public class TextBox extends Element {
    // Конструктор
    public TextBox(WebElement webElement) {
        super(webElement);
    }

    // Нажатие на текстовое поле
    public void click() {
        webElement.click();
    }

    // Ввод текста в текстовое поле
    public void setValue(String text) {
        webElement.sendKeys(text);
    }
}
