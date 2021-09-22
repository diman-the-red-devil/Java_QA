package web.elements;

import org.openqa.selenium.WebElement;

// Класс "Кнопка"
public class Button extends BaseElement {
    // Конструктор
    public Button(WebElement webElement) {
        super(webElement);
    }

    // Нажатие на кнопку
    public void click() {
        webElement.click();
    }
}
