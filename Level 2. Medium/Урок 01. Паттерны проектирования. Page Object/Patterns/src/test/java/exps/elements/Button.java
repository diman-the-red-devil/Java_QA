package exps.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends Element {
    public Button(WebDriver driver, By by) {
        super(driver, by);
    }

    public void click() {
        webElement.click();
    }
}
