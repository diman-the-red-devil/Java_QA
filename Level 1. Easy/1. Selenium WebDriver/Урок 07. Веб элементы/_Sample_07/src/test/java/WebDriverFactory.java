import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public static WebDriver getDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                logger.info("Драйвер для браузера Google Chrome");
                return new ChromeDriver();
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                logger.info("Драйвер для браузера Mozilla Firefox");
                return new FirefoxDriver();
            /*
            case "edge" :
                WebDriverManager.edgedriver().setup();
                logger.info("Драйвер для браузера Microsoft Edge");
                return new EdgeDriver();
            case "explorer" :
                WebDriverManager.iedriver().setup();
                logger.info("Драйвер для браузера Microsoft Internet Explorer");
                return new InternetExplorerDriver();
            case "opera" :
                WebDriverManager.operadriver().setup();
                logger.info("Драйвер для браузера Opera");
                return new OperaDriver();
             */
            default:
                throw new RuntimeException("Incorrect browser name");
        }
    }
}