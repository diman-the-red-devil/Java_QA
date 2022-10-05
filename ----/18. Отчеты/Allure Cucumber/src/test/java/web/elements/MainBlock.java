package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.JavaScriptHelper;

// Класс "Главный блок"
public class MainBlock extends BaseElement {
    // Конструктор
    public MainBlock(WebElement webElement) {
        super(webElement);
    }

    // Скрытие блока
    public void hide() {
        JavaScriptHelper.displayNone(webElement);
    }
}
