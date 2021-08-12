package elements;

import org.openqa.selenium.WebElement;

// Класс Кнопка (Button)
public class Button extends Element {
    // Конструктор
    public Button(WebElement webElement) {
        super(webElement);
    }

    // Нажатие на кнопку
    public void click() {
        webElement.click();
    }
}
