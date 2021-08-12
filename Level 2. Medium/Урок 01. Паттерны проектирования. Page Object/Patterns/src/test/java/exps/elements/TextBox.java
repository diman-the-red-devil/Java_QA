package exps.elements;

import org.openqa.selenium.WebElement;

public class TextBox extends Element {
    public TextBox(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        webElement.click();
    }

    public void setText(String text) {
        webElement.sendKeys(text);
    }
}
