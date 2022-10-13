package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

// Базовый класс для всех элементов
public class BaseElement {
    // Драйвер
    protected WebDriver driver;
    // Локатор
    protected By by;
    // Элемент страницы
    protected WebElement webElement;

    // Конструктор базового класса
    public BaseElement(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
        // Ожидание появления элемента перед поиском элемента
        WaitFor.initWait(driver, Duration.ofMillis(3000), Duration.ofMillis(300));
        WaitFor.presenceOfElementLocated(by);
        WaitFor.visibilityOfElementLocated(by);
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
