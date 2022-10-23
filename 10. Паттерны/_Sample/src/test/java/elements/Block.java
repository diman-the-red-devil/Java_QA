package elements;

import helpers.JavaScriptHelper;
import org.openqa.selenium.WebElement;

// Класс "Блок"
public class Block extends BaseElement {

    // Конструктор
    public Block(WebElement webElement) {
        super(webElement);
    }

    // Скрытие блока
    public void hide() {
        JavaScriptHelper.displayNone(webElement);
    }
}
