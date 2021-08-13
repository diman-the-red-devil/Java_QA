package exps.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox extends Element{
    public CheckBox(WebDriver driver, By by) {
        super(driver, by);
    }

    public void setChecked(boolean value) {
        if (value != isChecked()) {
            webElement.click();
        }
    }

    public boolean isChecked() {
        return webElement.isSelected();
    }
}
