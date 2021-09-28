package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import web.drivers.WebDriverFactory;

// Класс для выполнения скриптов на JavaScript
public class JavaScriptHelper {
    // Логгер
    private Logger logger = LogManager.getLogger(JavaScriptHelper.class);
    // Исполнитель JS скриптов
    protected static JavascriptExecutor javascriptExecutor;

    // Инициализация исполнителя JS скриптов
    public static void init() {
        javascriptExecutor = (JavascriptExecutor) WebDriverFactory.getCurrentDriver();
    }

    // Скролл страницы заданное расстояние в пикселях по X и по Y
    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        javascriptExecutor.executeScript(script);
    }

    // Установка невидимости веб элемента
    public static void displayNone(WebElement element) {
        String script = "arguments[0].style.display='none';";
        javascriptExecutor.executeScript(script, element);
    }
}
