import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserOptionsTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(BrowserOptionsTest.class);

    @BeforeEach
    public void setUp() {
        driver = getDriver();
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void browserOptionsTest() {
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница DNS - " + "https://www.dns-shop.ru/");

        // Ввод текста для поиска
        String searchInputXpath = "(//*[@placeholder=\"Поиск по сайту\"])[2]";
        WebElement searchInput = driver.findElement(By.xpath(searchInputXpath));
        String searchText = "Samsung";
        searchInput.sendKeys(searchText);

        // Нажатие кнопка "Найти"
        String searchButtonXpath = "(//span[@class=\"ui-input-search__icon ui-input-search__icon_search ui-input-search__icon_presearch\"])[2]";
        WebElement searchButton = driver.findElement(By.xpath(searchButtonXpath));
        searchButton.click();

        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }

    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        logger.info("Драйвер для браузера Google Chrome");

        // Добавление свойств браузера Google Chrome (настройки сессии)

        // а) с помощью класса DesiredCapabilities и строковых параметров
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("unexpectedAlertBehaviour", "dismiss");
        capabilities.setCapability("unhandledPromptBehavior", "dismiss");

        // б) с помощью класса DesiredCapabilities и констант перечисления CapabilityType
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, Browser.CHROME);

        // в) с помощью класса ChromeOptions и строковых параметров
        ChromeOptions options = new ChromeOptions();
        options.setCapability("pageLoadStrategy", PageLoadStrategy.NORMAL);
        // options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        // г) с помощью класса ChromeOptions и констант перечисления CapabilityType
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
        // options.setAcceptInsecureCerts(false);

        // Добавление свойств (а) и (б)
        options.merge(capabilities);

        // Добавление аргументов запуска Google Chrome
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        return new ChromeDriver(options);
    }
}
