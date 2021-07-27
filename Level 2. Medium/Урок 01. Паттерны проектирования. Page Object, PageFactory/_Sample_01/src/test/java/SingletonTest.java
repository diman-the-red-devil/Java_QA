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

public class SingletonTest {/*
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SingletonTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void sigletonTest() {
        driver.get("https://github.com/");
        driver.manage().window().maximize();

        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));

        By linkSignInXpath = By.xpath("//a[contains(text(),\"Sign in\")]");
        wait.until(ExpectedConditions.elementToBeClickable(linkSignInXpath));
        WebElement linkSignIn = driver.findElement(linkSignInXpath);
        linkSignIn.click();

        By inputEmailXpath = By.xpath("//label[contains(text(), \"Username or email address\")]/following-sibling::input");
        wait.until(ExpectedConditions.elementToBeClickable(inputEmailXpath));
        WebElement inputEmail = driver.findElement(inputEmailXpath);
        inputEmail.sendKeys(UserSingleton.getInstance().getEmail());

        By inputPasswordXpath = By.xpath("//label[contains(text(), \"Password\")]/following-sibling::input");
        wait.until(ExpectedConditions.elementToBeClickable(inputPasswordXpath));
        WebElement inputPassword = driver.findElement(inputPasswordXpath);
        inputPassword.sendKeys(UserSingleton.getInstance().getPassword());

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

        By textareaBioXpath = By.xpath("//label[contains(text(), \"Bio\")]/parent::dt/following::dd//textarea");
        wait.until(ExpectedConditions.elementToBeClickable(textareaBioXpath));
        WebElement textareaBio = driver.findElement(textareaBioXpath);
        textareaBio.sendKeys(UserSingleton.getInstance().getBio());

        By inputTwitterUsernameXpath = By.xpath("//label[contains(text(), \"Twitter username\")]/parent::dt/following::dd//input");
        wait.until(ExpectedConditions.elementToBeClickable(inputTwitterUsernameXpath));
        WebElement inputTwitterUsername = driver.findElement(inputTwitterUsernameXpath);
        inputTwitterUsername.sendKeys(UserSingleton.getInstance().getTwitterUserName());

        By inputCompanyXpath = By.xpath("//label[contains(text(), \"Company\")]/parent::dt/following::dd//input");
        wait.until(ExpectedConditions.elementToBeClickable(inputCompanyXpath));
        WebElement inputCompany = driver.findElement(inputCompanyXpath);
        inputCompany.sendKeys(UserSingleton.getInstance().getCompany());

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

class UserSingleton
{
    private String email;
    private String password;
    private String bio;
    private String twitterUserName;
    private String company;

    private static UserSingleton instance;

    private UserSingleton() {
        this.email = "diman_the_red_devil@mail.ru";
        this.password = "JAKARTA12345rex-";
        this.bio = "I'm QA from Russia";
        this.twitterUserName = "Diman The Red Devil";
        this.company = "QA Company";
    }

    public static UserSingleton getInstance() {
        if (instance == null)
            instance = new UserSingleton();
        return instance;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getBio() {
        return this.bio;
    }

    public String getTwitterUserName() {
        return this.twitterUserName;
    }

    public String getCompany() {
        return this.company;
    }*/
}