package web.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

// Класс "Ссылка"
public class Link extends BaseElement {
    // Конструктор
    public Link(WebElement webElement) {
        super(webElement);
    }

    // Нажатие на ссылку
    public void click() {
        webElement.click();
    }

    // Наведение курсора мыши на ссылку
    public void focusOnLink() {
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
        return webElement.getText();
    }
}
