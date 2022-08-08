package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.drivers.WebDriverFactory;

// Класс для навигации в браузере
public class NavigationHelper {
    // Логгер
    private Logger logger = LogManager.getLogger(NavigationHelper.class);

    // Открытие новой страницы
    public static void navigateTo(String URL) {
        WebDriverFactory.getCurrentDriver().navigate().to(URL);
    }

    // Переход на предыдущую страницу
    public static void back() {
        WebDriverFactory.getCurrentDriver().navigate().back();
    }

    // Переход на следующую страницу
    public static void forward() {
        WebDriverFactory.getCurrentDriver().navigate().forward();
    }

    // Обновление страницы
    public static void refresh() {
        WebDriverFactory.getCurrentDriver().navigate().refresh();
    }
}
