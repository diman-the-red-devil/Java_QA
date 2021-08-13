package exps.decorators;

import org.openqa.selenium.WebElement;

public abstract class BaseWebElementDecorator implements WebElement {
    protected WebElement webElement;

    public BaseWebElementDecorator(WebElement webElement) {
        this.webElement = webElement;
    }
}
