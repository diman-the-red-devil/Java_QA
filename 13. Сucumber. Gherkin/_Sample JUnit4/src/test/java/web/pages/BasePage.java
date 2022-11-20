package web.pages;

import web.helpers.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasePage {
    // Драйвер браузера
    protected static WebDriver driver;

    // Конструктор базового класса
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        // Инициализация ожиданий событий на странице
        WaitHelper.init(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        // Инициализация выполнения скриптов на JavaScript
        JavaScriptHelper.init(driver);
        // Инициализация выполнения сложных действий
        ActionHelper.init(driver);
        // Инициализация навигации в браузере
        NavigationHelper.init(driver);
        // Инициализация управления окнами
        WindowHelper.init(driver);
        // Инициализация переключения на объекты
        SwitchHelper.init(driver);
    }

    // Получение заголовка текущей страницы
    public String getPageTitle() {
        String title = driver.getTitle();
        //ogger.info("Заголовок страницы: " + title);
        return title;
    }
}
