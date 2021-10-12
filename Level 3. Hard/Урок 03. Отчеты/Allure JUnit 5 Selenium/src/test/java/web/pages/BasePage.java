package web.pages;

import org.openqa.selenium.WebDriver;
import web.helpers.JSExec;
import web.helpers.WaitFor;


import java.time.Duration;

// Базовый класс для всех объектов веб страниц
public class BasePage {
    // Драйвер браузера
    protected static WebDriver driver;

    // Конструктор базового класса
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        // Инициализация ожидания - 10 секунд
        WaitFor.initWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        // Инициализация исполнителя JS скриптов
        JSExec.initJS(driver);
    }
}
