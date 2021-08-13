package exps.pages;

import exps.decorators.LogWebElementDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Страница "Home"
public class HomePageWithDecorators {
    // Драйвер браузера
    protected WebDriver driver;
    // Текст
    private By tеxtBy = By.tagName("h1");

    // Конструктор
    public HomePageWithDecorators(WebDriver driver){
        this.driver = driver;
    }

    // Отображается элемент?
    public boolean isTextDisplyed() {
        LogWebElementDecorator webElement = new LogWebElementDecorator(driver.findElement(tеxtBy));
        return webElement.isDisplayed();
    }

    // Получение текста
    public String getText() {
        LogWebElementDecorator webElement = new LogWebElementDecorator(driver.findElement(tеxtBy));
        return webElement.getText();
    }
}
