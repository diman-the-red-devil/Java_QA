package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Страница "Home"
public class HomePage {
    // Драйвер браузера
    protected WebDriver driver;
    // Текст
    private By tеxtBy = By.tagName("h1");

    // Конструктор
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    // Отображается элемент?
    public boolean isTextDisplyed() {
        return driver.findElement(tеxtBy).isDisplayed();
    }

    // Получение текста
    public String getText() {
        return driver.findElement(tеxtBy).getText();
    }
}
