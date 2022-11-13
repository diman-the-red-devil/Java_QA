package web.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class FirefoxBrowser {
    // Получение экземпляра драйвера браузера "Mozilla Firefox"
    public static WebDriver getDriver() {
        // Настройка исполняемого файла драйвера
        WebDriverManager.firefoxdriver().setup();

        // Опции драйвера:
        FirefoxOptions options = new FirefoxOptions();
        // - прием небезопасных сертификатов = true
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        // - стратегия загрузки страницы = NORMAL
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);
        // - режим "Инкогнито"
        options.addArguments("-private");
        // - режим "Полный экран"
        options.addArguments("-kiosk");

        // Новый экземпляр драйвера
        return new FirefoxDriver(options);
    }
}
