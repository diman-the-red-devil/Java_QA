package pageobjects;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

// Базовый класс для всех объектов веб страниц
public class BasePage {
    // Драйвер браузера
    protected static WebDriver driver;

    // Конструктор базового класса
    public BasePage(WebDriver driver) {
        this.driver = driver;
        WaitFor.initWait(driver, Duration.ofSeconds(1), Duration.ofMillis(100));
    }
}
