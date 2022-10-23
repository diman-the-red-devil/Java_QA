package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

// Класс для переключения на объекты
public class SwitchHelper {
    // Логгер
    private static Logger logger = LogManager.getLogger(SwitchHelper.class);
    // Веб драйвер
    private static WebDriver switcher;

    // Инициализация драйвера
    public static void init(WebDriver driver) {
        switcher = driver;
    }
    
    // Переключение на созданное окно
    public static void switchToExistWindow(String window) {
        switcher.switchTo().window(window);
    }

    // Переключение на создаваемое окно
    public static void switchToNewWindow() {
        switcher.switchTo().newWindow(WindowType.WINDOW);
    }

    // Переключение на создаваемую вкладку
    public static void switchToNewTab() {
        switcher.switchTo().newWindow(WindowType.TAB);
    }

    // Переключение на алерт
    public static void switchToAlert() {
        switcher.switchTo().alert();
    }

    // Переключение на фрейм по его индексу
    public static void switchToFrameByIndex(int index) {
        switcher.switchTo().frame(index);
    }

    // Переключение на фрейм по его атрибуту name или id
    public static void switchToFrameByNameOrId(String nameOrId) {
        switcher.switchTo().frame(nameOrId);
    }

    // Переключение на фрейм по веб элементу
    public static void switchToFrameByFrameWebElement(WebElement webElement) {
        switcher.switchTo().frame(webElement);
    }

    // Переключение на родительский фрейм
    public static void switchToParentFrame() {
        switcher.switchTo().parentFrame();
    }

    // Переключение на основной документ
    public static void switchToDefaultContent() {
        switcher.switchTo().defaultContent();
    }

    // Переключение на активный веб элемент
    public static void switchToActiveWebElement() {
        switcher.switchTo().activeElement();
    }
}
