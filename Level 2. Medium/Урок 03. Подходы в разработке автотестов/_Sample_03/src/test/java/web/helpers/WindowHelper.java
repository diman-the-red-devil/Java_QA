package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import web.drivers.WebDriverFactory;

// Класс для управления окнами
public class WindowHelper {
    // Логгер
    private Logger logger = LogManager.getLogger(WindowHelper.class);

    // Максимизация размеров окна
    public static void maximizeWindow() {
        WebDriverFactory.getCurrentDriver().manage().window().maximize();
    }

    // Минимизация размеров окна
    public static void minimizeWindow() {
        WebDriverFactory.getCurrentDriver().manage().window().minimize();
    }

    // Отображение окна браузера в полноэкранном режиме
    public static void fullscreenWindow() {
        WebDriverFactory.getCurrentDriver().manage().window().fullscreen();
    }

    // Получение координат расположения окна
    public static Point getWindowPosition() {
        return WebDriverFactory.getCurrentDriver().manage().window().getPosition();
    }

    // Установка координат расположения окна
    public static void setWindowPosition(Point point) {
        WebDriverFactory.getCurrentDriver().manage().window().setPosition(point);
    }

    // Получение размеров окна
    public static Dimension getWindowSize() {
       return WebDriverFactory.getCurrentDriver().manage().window().getSize();
    }

    // Установка размеров окна
    public static void setWindowSize(Dimension dimension) {
        WebDriverFactory.getCurrentDriver().manage().window().setSize(dimension);
    }
}
