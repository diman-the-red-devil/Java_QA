package exps.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Флажок
public class CheckBox extends Element{
    // Конструктор
    public CheckBox(WebDriver driver, By by) {
        super(driver, by);
    }

    // Установка флажка
    public void setChecked(boolean value) {
        if (value != isChecked()) {
            webElement.click();
        }
    }

    // Проверка, что флажок установлен
    public boolean isChecked() {
        return webElement.isSelected();
    }
}
