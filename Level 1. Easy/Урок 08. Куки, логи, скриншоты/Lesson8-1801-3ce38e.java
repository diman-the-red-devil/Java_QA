import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Lesson8 {

    protected static WebDriver driver;
    protected Actions action;

    private Logger logger = LogManager.getLogger(SampleTest.class);

    private static final String CONSOLE_LOG = "var test = 'I am text'; console.log(test);";
    private static final String RETURN_TEXT = "return 'text'";
    private static final String RETURN_NUMBER = "return 26";
    private static final String RETURN_BOOL = "return true";
    private static final String RETURN_ELEMENT = "return document.querySelector('#text');";

    @Test
    public void takeScreenshot(){
        driver.get("https://ya.ru");

        driver.findElement(By.cssSelector("#text")).clear();
        driver.findElement(By.cssSelector("#text")).sendKeys("Base64");
        String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        saveBase64(base64);

        driver.findElement(By.cssSelector("#text")).clear();
        driver.findElement(By.cssSelector("#text")).sendKeys("Bytes");
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveBytes(bytes);

        driver.findElement(By.cssSelector("#text")).clear();
        driver.findElement(By.cssSelector("#text")).sendKeys("File");
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        saveFile(file);
    }

    @Test
    public void elementScreenshot() {
        driver.get("https://ya.ru");

        driver.findElement(By.cssSelector("#text")).clear();
        driver.findElement(By.cssSelector("#text")).sendKeys("Base64");
        String base64 = driver.findElement(By.cssSelector("#text")).getScreenshotAs(OutputType.BASE64);
        saveBase64(base64);
    }

    @Test
    public void draw(){
        driver.get("http://www.htmlcanvasstudio.com/");
        WebElement canvas = driver.findElement(By.cssSelector("#imageTemp"));

        Actions beforeBuild = action
                .clickAndHold(canvas)
                .moveByOffset(100, 100)
                .moveByOffset(-50, -10)
                .release();
        beforeBuild.perform();
        saveFile(canvas.getScreenshotAs(OutputType.FILE));
    }

    @Test
    public void move(){
        driver.get("https://ng-bootstrap.github.io/#/components/popover/examples");

        WebElement popover = driver.findElement(By.cssSelector(".col-xl-9 > ng-component:nth-child(2) > ngbd-widget-demo:nth-child(10) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > ngbd-popover-config:nth-child(1) > button:nth-child(1)"));

        action.moveToElement(popover).pause(400L).perform();

        String content = driver.findElement(By.cssSelector("#ngb-popover-19")).getText();
        logger.info(content);

    }

    @Test
    public void execute(){
        driver.get("https://ya.ru");

        Object willBeNull = ((JavascriptExecutor) driver).executeScript(CONSOLE_LOG);
        String string = (String) ((JavascriptExecutor) driver).executeScript(RETURN_TEXT);
        Long number = (Long) ((JavascriptExecutor) driver).executeScript(RETURN_NUMBER);
        Boolean bool = (Boolean) ((JavascriptExecutor) driver).executeScript(RETURN_BOOL);
        WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(RETURN_ELEMENT);
    }

    private void saveBase64(String data) {
        File file = OutputType.FILE.convertFromBase64Png(data);
        saveFile(file);
    }

    private void saveBytes(byte[] data) {
        File file = OutputType.FILE.convertFromPngBytes(data);
        saveFile(file);
    }

    private void saveFile(File data) {
        String fileName = "target/" + System.currentTimeMillis() + ".png";
        try {
            FileUtils.copyFile(data, new File(fileName));
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4L, TimeUnit.SECONDS);
        action = new Actions(driver);
        logger.info("Драйвер поднят");
    }
    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}