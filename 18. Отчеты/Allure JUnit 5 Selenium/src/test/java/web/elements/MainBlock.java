package web.elements;

import web.helpers.JSExec;
import web.helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс "Главный блок"
public class MainBlock extends BaseElement {
    // Конструктор
    public MainBlock(WebDriver driver, By by) {
        super(driver, by);
    }

    // Скрытие блока
    public void hide() {
        WaitFor.visibilityOfElementLocated(by);
        JSExec.displayNone(webElement);
    }
}
