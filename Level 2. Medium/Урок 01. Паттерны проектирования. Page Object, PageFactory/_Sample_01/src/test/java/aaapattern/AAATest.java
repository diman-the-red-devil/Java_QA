package aaapattern;

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
import webdriverfactory.WebDriverFactory;

import java.time.Duration;

public class AAATest {
    protected static WebDriver driver;
    protected static Wait wait;
    private Logger logger = LogManager.getLogger(AAATest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void dtoTest() {
        // Arrange
        driver.get("https://github.com/");
        driver.manage().window().maximize();

        String email           = "diman_the_red_devil@mail.ru";
        String password        = "JAKARTA12345rex-";
        String bio             = "I'm QA from Russia";
        String twitterUserName = "Diman The Red Devil";
        String company         = "QA Company";

        // Act
        By linkSignInXpath = By.xpath("//a[contains(text(),\"Sign in\")]");
        waitToBeClackable(linkSignInXpath);
        WebElement linkSignIn = driver.findElement(linkSignInXpath);
        linkSignIn.click();

        By inputEmailXpath = By.xpath("//label[contains(text(), \"Username or email address\")]/following-sibling::input");
        waitToBeClackable(inputEmailXpath);
        WebElement inputEmail = driver.findElement(inputEmailXpath);
        inputEmail.sendKeys(email);

        By inputPasswordXpath = By.xpath("//label[contains(text(), \"Password\")]/following-sibling::input");
        waitToBeClackable(inputPasswordXpath);
        WebElement inputPassword = driver.findElement(inputPasswordXpath);
        inputPassword.sendKeys(password);

        By inputSignInXpath = By.xpath("//input[@value=\"Sign in\"]");
        waitToBeClackable(inputSignInXpath);
        WebElement inputSignIn = driver.findElement(inputSignInXpath);
        inputSignIn.click();

        By detailsUserXpath = By.xpath("(//details)[2]");
        waitToBeClackable(detailsUserXpath);
        WebElement userDetails = driver.findElement(detailsUserXpath);
        userDetails.click();

        By linkSettingsXpath = By.xpath("(//a[contains(text(), \"Settings\")])[2]");
        waitToBeClackable(linkSettingsXpath);
        WebElement linkSettings = driver.findElement(linkSettingsXpath);
        linkSettings.click();

        By textareaBioXpath = By.xpath("//label[contains(text(), \"Bio\")]/parent::dt/following::dd//textarea");
        waitToBeClackable(textareaBioXpath);
        WebElement textareaBio = driver.findElement(textareaBioXpath);
        textareaBio.sendKeys(bio);

        By inputTwitterUsernameXpath = By.xpath("//label[contains(text(), \"Twitter username\")]/parent::dt/following::dd//input");
        waitToBeClackable(inputTwitterUsernameXpath);
        WebElement inputTwitterUsername = driver.findElement(inputTwitterUsernameXpath);
        inputTwitterUsername.sendKeys(twitterUserName);

        By inputCompanyXpath = By.xpath("//label[contains(text(), \"Company\")]/parent::dt/following::dd//input");
        waitToBeClackable(inputCompanyXpath);
        WebElement inputCompany = driver.findElement(inputCompanyXpath);
        inputCompany.sendKeys(company);

        // Assert


        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void waitToBeClackable(By xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
