package exps.web.pages;

import exps.web.elements.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Страница "Home"
public class HomePage extends BasePage {
    // Текст
    private By textBy = By.tagName("h1");

    // Конструктор
    public HomePage(WebDriver driver){
        super(driver);
    }

    public Text text() {
        return new Text(driver, textBy);
    }
}
