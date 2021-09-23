package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

// Класс "Переключатель"
public class RadioButton extends BaseElement{
    // Конструктор
    public RadioButton(WebElement webElement) {
        super(webElement);
    }

    // Установка переключателя
    public void setSelected(boolean value) {
        WaitHelper.visibilityOfElement(webElement);
        if (value != isSelected()) {
            WaitHelper.clickabilityOfElement(webElement);
            webElement.click();
        }
    }

    // Проверка, что переключатель установлен
    public boolean isSelected() {
        return webElement.isSelected();
    }
}
