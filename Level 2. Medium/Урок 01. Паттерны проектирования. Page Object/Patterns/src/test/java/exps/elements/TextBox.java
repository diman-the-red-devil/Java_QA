package exps.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox extends Element {
    public TextBox(WebDriver driver, By by) {
        super(driver, by);
    }

    public void click() {
        webElement.click();
    }

    public void setText(String text) {
        webElement.sendKeys(text);
    }
}
