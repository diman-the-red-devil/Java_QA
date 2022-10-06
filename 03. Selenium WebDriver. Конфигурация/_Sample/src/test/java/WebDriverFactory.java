import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    // Возврат драйвера для конкретного браузера по его названию
    public static WebDriver getDriver(String browserName) {
        switch (browserName) {
            // Создание драйвера для браузера Google Chrome
            case "chrome":
                WebDriverManager.chromedriver().setup();
                logger.info("Драйвер для браузера Google Chrome");
                return new ChromeDriver();
            // Создание драйвера для браузера Mozilla Firefox
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            /*
            // Создание драйвера для браузера Microsoft Edge
            case "edge" :
                WebDriverManager.edgedriver().setup();
                logger.info("Драйвер для браузера Microsoft Edge");
                return new EdgeDriver();
            // Создание драйвера для браузера Microsoft Internet Explorer
            case "explorer" :
                WebDriverManager.iedriver().setup();
                logger.info("Драйвер для браузера Microsoft Internet Explorer");
                return new InternetExplorerDriver();
            // Создание драйвера для браузера Opera
            case "opera" :
                WebDriverManager.operadriver().setup();
                logger.info("Драйвер для браузера Opera");
                return new OperaDriver();
             */
            // Ответ по умолчанию, если введено некорректное название браузера
            default:
                throw new RuntimeException("Введено некорректное название браузера");
        }
    }
}