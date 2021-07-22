import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SeleniumTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void dtoTest() {
        driver.get("https://github.com/");
        driver.manage().window().maximize();

        User user = new User("diman_the_red_devil@mail.ru", "JAKARTA12345rex-");

        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));

        By linkSignInXpath = By.xpath("//a[contains(text(),\"Sign in\")]");
        wait.until(ExpectedConditions.elementToBeClickable(linkSignInXpath));
        WebElement linkSignIn = driver.findElement(linkSignInXpath);
        linkSignIn.click();

        By inputEmailXpath = By.xpath("//label[contains(text(), \"Username or email address\")]/following-sibling::input");
        wait.until(ExpectedConditions.elementToBeClickable(inputEmailXpath));
        WebElement inputEmail = driver.findElement(inputEmailXpath);
        inputEmail.sendKeys(user.getEmail());

        By inputPasswordXpath = By.xpath("//label[contains(text(), \"Password\")]/following-sibling::input");
        wait.until(ExpectedConditions.elementToBeClickable(inputPasswordXpath));
        WebElement inputPassword = driver.findElement(inputPasswordXpath);
        inputPassword.sendKeys(user.getPassword());

        By inputSignInXpath = By.xpath("//input[@value=\"Sign in\"]");
        wait.until(ExpectedConditions.elementToBeClickable(inputSignInXpath));
        WebElement inputSignIn = driver.findElement(inputSignInXpath);
        inputSignIn.click();

        By detailsUserXpath = By.xpath("(//details)[2]");
        wait.until(ExpectedConditions.elementToBeClickable(detailsUserXpath));
        WebElement userDetails = driver.findElement(detailsUserXpath);
        userDetails.click();

        By linkSettingsXpath = By.xpath("(//a[contains(text(), \"Settings\")])[2]");
        wait.until(ExpectedConditions.elementToBeClickable(linkSettingsXpath));
        WebElement linkSettings = driver.findElement(linkSettingsXpath);
        linkSettings.click();

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
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

class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }
}