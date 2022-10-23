package elements;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;

// Класс "Флажок"
public class CheckBox extends BaseElement {

    // Конструктор
    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    // Установка флажка
    public void setChecked(boolean value) {
        if (value != isChecked()) {
            // Ожидание кликабельности флажка
            WaitHelper.clickabilityOfElement(webElement);
            webElement.click();
        }
    }

    // Проверка, что флажок установлен
    public boolean isChecked() {
        return webElement.isSelected();
    }
}
