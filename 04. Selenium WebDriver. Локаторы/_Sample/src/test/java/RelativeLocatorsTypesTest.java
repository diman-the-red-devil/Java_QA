import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsTypesTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(RelativeLocatorsTypesTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void searchAboveElementTest() {
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        // Найти элемент выше элемента
        WebElement element = driver.findElement(RelativeLocator
                        .with(By.xpath("//label[text()=\"Option 1\"]"))
                        .above(By.xpath("//label[text()=\"Option 2\"]")));
        logger.info("WebElement: " + element.getTagName());
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchBelowElementTest() {
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        // Найти элемент ниже элемента
        WebElement element = driver.findElement(RelativeLocator
                .with(By.xpath("//label[text()=\"Option 2\"]"))
                .below(By.xpath("//label[text()=\"Option 1\"]")));
        logger.info("WebElement: " + element.getTagName());
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchToLeftOfElementTest() {
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://webdriveruniversity.com/Data-Table/index.html");
        // Найти элемент слева от элемента
        WebElement element = driver.findElement(RelativeLocator
                .with(By.xpath("//button[text()=\"Button-1\"]"))
                .toLeftOf(By.xpath("//button[text()=\"Button-3\"]")));
        logger.info("WebElement: " + element.getTagName());
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchToRightOfElementTest() {
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://webdriveruniversity.com/Data-Table/index.html");
        // Найти элемент справа от элемента
        WebElement element = driver.findElement(RelativeLocator
                .with(By.xpath("//button[text()=\"Button-3\"]"))
                .toRightOf(By.xpath("//button[text()=\"Button-1\"]")));
        logger.info("WebElement: " + element.getTagName());
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchNearElementTest() {
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
        logger.info("Открыта страница demosite.executeautomation.com - " +
                "https://webdriveruniversity.com/Data-Table/index.html");
        // Найти элемент рядом с элементом
        WebElement element = driver.findElement(RelativeLocator
                .with(By.xpath("//button[text()=\"Button-2\"]"))
                .near(By.xpath("//button[text()=\"Button-1\"]")));
        logger.info("WebElement: " + element.getTagName());
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
