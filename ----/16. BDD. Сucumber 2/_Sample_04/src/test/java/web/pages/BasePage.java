package web.pages;

import web.helpers.ActionHelper;
import web.helpers.JavaScriptHelper;
import web.helpers.WaitHelper;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

// Базовый класс для всех объектов веб страниц
public class BasePage {
    // Драйвер браузера
    protected static WebDriver driver;

    // Конструктор базового класса
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        // Инициализация ожидания - 10 секунд
        WaitHelper.init(Duration.ofSeconds(10), Duration.ofMillis(100));
        // Инициализация исполнителя JS скриптов
        JavaScriptHelper.init();
        // Инициализация экшена
        ActionHelper.init();
    }

    // Получение заголовка текущей страницы
    public String getPageTitle() {
        return driver.getTitle();
    }
}
