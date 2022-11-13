package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

// Класс для навигации в браузере
public class NavigationHelper {
    // Логгер
    private Logger logger = LogManager.getLogger(NavigationHelper.class);
    // Веб драйвер
    private static WebDriver navigation;

    // Инициализация драйвера
    public static void init(WebDriver driver) {
        navigation = driver;
    }

    // Открытие новой страницы
    public static void navigateTo(String URL) {
        navigation.navigate().to(URL);
    }

    // Переход на предыдущую страницу
    public static void back() {
        navigation.navigate().back();
    }

    // Переход на следующую страницу
    public static void forward() {
        navigation.navigate().forward();
    }

    // Обновление страницы
    public static void refresh() {
        navigation.navigate().refresh();
    }
}
