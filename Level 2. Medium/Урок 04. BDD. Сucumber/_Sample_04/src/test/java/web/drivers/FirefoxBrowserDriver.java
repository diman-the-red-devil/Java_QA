package web.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

// Драйвера браузера "Mozilla Firefox"
public class FirefoxBrowserDriver {
    // Получение экземпляра драйвера браузера "Mozilla Firefox"
    public static WebDriver getDriver() {
        // Настройка исполняемого файла драйвера
        WebDriverManager.firefoxdriver().setup();

        // Опции драйвера:
        FirefoxOptions options = new FirefoxOptions();
        // - поведение при появлении алертов "Игнорирование"
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        // - стратегия загрузки страницы "NORMAL"
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);
        // - режим "Инкогнито"
        options.addArguments("-private");
        // - режим "Полный экран"
        options.addArguments("-kiosk");

        // Новый экземпляр драйвера
        return new FirefoxDriver(options);
    }
}
