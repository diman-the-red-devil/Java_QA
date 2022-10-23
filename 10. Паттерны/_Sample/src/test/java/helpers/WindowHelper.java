package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

// Класс для управления окнами
public class WindowHelper {
    // Логгер
    private Logger logger = LogManager.getLogger(WindowHelper.class);
    // Веб драйвер
    private static WebDriver window;

    // Инициализация драйвера
    public static void init(WebDriver driver) {
        window = driver;
    }
    
    // Максимизация размеров окна
    public static void maximizeWindow() {
        window.manage().window().maximize();
    }

    // Минимизация размеров окна
    public static void minimizeWindow() {
        window.manage().window().minimize();
    }

    // Отображение окна браузера в полноэкранном режиме
    public static void fullscreenWindow() {
        window.manage().window().fullscreen();
    }

    // Получение координат расположения окна
    public static Point getWindowPosition() {
        return window.manage().window().getPosition();
    }

    // Установка координат расположения окна
    public static void setWindowPosition(Point point) {
        window.manage().window().setPosition(point);
    }

    // Получение размеров окна
    public static Dimension getWindowSize() {
        return window.manage().window().getSize();
    }

    // Установка размеров окна
    public static void setWindowSize(Dimension dimension) {
        window.manage().window().setSize(dimension);
    }
}
