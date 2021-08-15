package exps.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import exps.helpers.WaitFor;

import java.time.Duration;

// Базовый класс для всех элементов
public class Element {
    // Элемент страницы
    protected WebElement webElement;

    // Базовый конструктор
    public Element(WebDriver driver, By by) {
        // Ожидание перед поиском элемента
        WaitFor.initWait(driver, Duration.ofMillis(3000), Duration.ofMillis(300));
        WaitFor.presenceOfElementLocated(by);
        // Поиск элемента
        webElement = driver.findElement(by);
    }

    // Получение оборачиваемого элемента
    // Получив оборачиваемый элемент, можно вызвать его методы
    // Например, getText()
    public WebElement getWebElement() {
        return webElement;
    }
}
