package web.elements;

import org.openqa.selenium.WebElement;

public class BaseElement {
    // Веб элемент
    protected WebElement webElement;

    // Конструктор класса
    public BaseElement(WebElement webElement) {
        this.webElement = webElement;
    }

    // Получение оборачиваемого веб элемента
    // Получив оборачиваемый веб элемент, можно вызвать его методы
    // Например, getText()
    public WebElement getWebElement() {
        return webElement;
    }
}
