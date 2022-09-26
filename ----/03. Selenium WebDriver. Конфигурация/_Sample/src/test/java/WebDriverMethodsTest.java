import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverMethodsTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(WebDriverMethodsTest.class);

    // Чтение передаваемого параметра browser (-Dbrowser)
    String env = System.getProperty("browser", "chrome");

    @BeforeEach
    public void setUp() {
        logger.info("env = " + env);
        driver = WebDriverFactory.getDriver(env.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void seacrhDNSTest() {
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница DNS - " + "https://www.dns-shop.ru/");

        // Вывод заголовка страницы
        String title = driver.getTitle();
        logger.info("Заголовок: " + title.toString());

        // Вывод текущего URL
        String currentUrl = driver.getCurrentUrl();
        logger.info("Текущий URL: " + currentUrl.toString());

        // Ввод текста в поле для поиска
        String searchInputXpath = "(//*[@placeholder=\"Поиск по сайту\"])[1]";
        WebElement searchInput = driver.findElement(By.xpath(searchInputXpath));
        String searchText = "Samsung";
        searchInput.sendKeys(searchText);

        // Нажатие кнопки "Найти"
        String searchButtonXpath = "(//span[@class=\"ui-input-search__icon ui-input-search__icon_search ui-input-search__icon_presearch\"])[1]";
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
}

