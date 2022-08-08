package web.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

// Драйвера браузера "Google Chrome"
public class ChromeBrowserDriver {
    // Получение экземпляра драйвера браузера "Google Chrome"
    public static WebDriver getDriver() {
        // Настройка исполняемого файла драйвера
        WebDriverManager.chromedriver().setup();

        // Опции драйвера:
        ChromeOptions options = new ChromeOptions();
        // - поведение при появлении алертов "Игнорирование"
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        // - стратегия загрузки страницы "NORMAL"
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);
        // - режим "Инкогнито"
        options.addArguments("--incognito");
        // - режим "Полный экран"
        options.addArguments("--start-fullscreen");

        // Новый экземпляр драйвера
        return new ChromeDriver(options);
    }
}
