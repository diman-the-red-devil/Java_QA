package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс "Кнопка"
public class Button extends BaseElement {
    // Конструктор
    public Button(WebDriver driver, By by) {
        super(driver, by);
    }

    // Нажатие на кнопку
    public void click() {
        WaitFor.visibilityOfElementLocated(by);
        WaitFor.clickabilityOfElement(webElement);
        webElement.click();
    }
}
