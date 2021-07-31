package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExec {
    // Логгер
    private Logger logger = LogManager.getLogger(JSExec.class);
    //
    protected static JavascriptExecutor js;

    // Установка
    public static void initJS(WebDriver driver) {
        js = (JavascriptExecutor) driver;
    }

    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        js.executeScript(script);
    }

    public static void displayNone(WebElement element) {
        String script = "arguments[0].style.display='none';";
        js.executeScript(script, element);
    }
}
