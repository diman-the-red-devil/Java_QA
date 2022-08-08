package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс "Переключатель"
public class RadioButton extends BaseElement{
    // Конструктор
    public RadioButton(WebDriver driver, By by) {
        super(driver, by);
    }

    // Установка переключателя
    public void setSelected(boolean value) {
        if (value != isSelected()) {
            WaitFor.clickabilityOfElement(webElement);
            webElement.click();
        }
    }

    // Проверка, что переключатель установлен
    public boolean isSelected() {
        WaitFor.visibilityOfElementLocated(by);
        return webElement.isSelected();
    }
}
