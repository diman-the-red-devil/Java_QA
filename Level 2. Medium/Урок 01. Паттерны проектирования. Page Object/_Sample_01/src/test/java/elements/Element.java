package elements;

import org.openqa.selenium.WebElement;

// Базовый класс для всех Декораторов
public class Element {
    // Оборачиваемый веб элемент
    protected WebElement webElement;

    // Конструктор базового класса
    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    // Получение оборачиваемого объекта
    public WebElement getWebElement() {
        return this.webElement;
    }

    // Передача оборачиваемого объекта
    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }
}
