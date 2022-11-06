package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;

// Класс для выполнения скриптов на JavaScript
public class JavaScriptHelper {
    // Логгер
    private static Logger logger = LogManager.getLogger(JavaScriptHelper.class);
    // Исполнитель JavaScript скриптов
    protected static JavascriptExecutor javascriptExecutor;

    // Инициализация исполнителя JavaScript скриптов
    public static void init(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    // Скролл страницы на заданное расстояние в пикселях по X и по Y
    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        javascriptExecutor.executeScript(script);
        // Добавление задержки
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Установка невидимости веб элемента
    public static void displayNone(WebElement element) {
        String script = "arguments[0].style.display='none';";
        javascriptExecutor.executeScript(script, element);
        // Добавление задержки
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
