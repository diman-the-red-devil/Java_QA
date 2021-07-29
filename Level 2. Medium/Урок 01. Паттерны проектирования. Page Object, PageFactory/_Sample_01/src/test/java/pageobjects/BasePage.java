package pageobjects;

import org.openqa.selenium.WebDriver;

// Базовый класс для всех объектов веб страниц
public class BasePage {
    // Драйвер браузера
    protected static WebDriver driver;

    // Конструктор базового класса
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
