package sample.elements;

import sample.helpers.JSExec;
import sample.helpers.WaitFor;
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
