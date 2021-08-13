package exps.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import exps.helpers.WaitFor;

import java.time.Duration;

public class Element {
    protected WebElement webElement;

    public Element(WebDriver driver, By by) {
        WaitFor.initWait(driver, Duration.ofMillis(3000), Duration.ofMillis(300));
        WaitFor.presenceOfElementLocated(by);
        webElement = driver.findElement(by);
    }

    public WebElement getWebElement() {
        return webElement;
    }
}
