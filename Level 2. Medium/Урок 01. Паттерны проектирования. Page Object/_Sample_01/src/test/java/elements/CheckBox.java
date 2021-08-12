package elements;

import org.openqa.selenium.WebElement;

// Класс Флажок (CheckBox)
public class CheckBox extends Element{
    // Конструктор
    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    // Установка флажка
    public void setChecked(boolean value) {
        if (value != isChecked()) {
            webElement.click();
        }
    }

    // Флажок установлен?
    public boolean isChecked() {
        return webElement.isSelected();
    }
}
