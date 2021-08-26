package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс "Флажок"
public class CheckBox extends BaseElement {
    // Конструктор
    public CheckBox(WebDriver driver, By by) {
        super(driver, by);
    }

    // Установка флажка
    public void setChecked(boolean value) {
        if (value != isChecked()) {
            WaitFor.clickabilityOfElement(webElement);
            webElement.click();
        }
    }

    // Проверка, что флажок установлен
    public boolean isChecked() {
        WaitFor.visibilityOfElementLocated(by);
        return webElement.isSelected();
    }
}
