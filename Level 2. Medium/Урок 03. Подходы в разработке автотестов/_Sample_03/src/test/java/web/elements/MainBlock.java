package web.elements;

import web.helpers.JSExecHelper;
import web.helpers.WaitHelper;
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
        WaitHelper.visibilityOfElementLocated(by);
        JSExecHelper.displayNone(webElement);
    }
}
