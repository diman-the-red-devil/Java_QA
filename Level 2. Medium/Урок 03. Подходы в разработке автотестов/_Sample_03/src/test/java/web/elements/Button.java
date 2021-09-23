package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

// Класс "Кнопка"
public class Button extends BaseElement {
    // Конструктор
    public Button(WebElement webElement) {
        super(webElement);
    }

    // Нажатие на кнопку
    public void click() {
        // Ожидание кликабельности кнопки
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
