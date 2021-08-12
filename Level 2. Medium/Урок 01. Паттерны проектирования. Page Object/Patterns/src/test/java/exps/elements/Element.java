package exps.elements;

import org.openqa.selenium.WebElement;

public class Element {
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getWebElement() {
        return this.webElement;
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getTagName() {
        return this.webElement.getTagName();
    }
}
