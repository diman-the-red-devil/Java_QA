package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

// Класс "Ссылка"
public class Link extends BaseElement {
    // Конструктор
    public Link(WebDriver driver, By by) {
        super(driver, by);
    }

    // Нажатие на ссылку
    public void click() {
        WaitFor.visibilityOfElementLocated(by);
        WaitFor.clickabilityOfElement(webElement);
        webElement.click();
    }

    // Наведение курсора мыши на ссылку
    public void focusOnLink() {
        WaitFor.visibilityOfElementLocated(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    // Открытие ссылки в новом окне
    public void openInNewWindow() {
        String URL = this.getURL();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        driver.navigate().to(URL);
    }

    // Получение URL ссылки
    public String getURL() {
        return webElement.getAttribute("href");
    }

    // Получение текста ссылки
    public String getText() {
        WaitFor.visibilityOfElementLocated(by);
        return webElement.getText();
    }
}
