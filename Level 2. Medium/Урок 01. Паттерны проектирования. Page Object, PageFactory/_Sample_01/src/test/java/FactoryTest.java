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

public class FactoryTest {
    /*
    protected static WebDriver driver;
    private final Logger logger = LogManager.getLogger(FactoryTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void factoryTest() {
        driver.get("https://github.com/");
        driver.manage().window().maximize();

        String userType = System.getProperty("userType", "simple");

        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        User user = UserFactory.createUser(userType);

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

        By textareaBioXpath = By.xpath("//label[contains(text(), \"Bio\")]/parent::dt/following::dd//textarea");
        wait.until(ExpectedConditions.elementToBeClickable(textareaBioXpath));
        WebElement textareaBio = driver.findElement(textareaBioXpath);
        textareaBio.sendKeys(user.getBio());

        By inputTwitterUsernameXpath = By.xpath("//label[contains(text(), \"Twitter username\")]/parent::dt/following::dd//input");
        wait.until(ExpectedConditions.elementToBeClickable(inputTwitterUsernameXpath));
        WebElement inputTwitterUsername = driver.findElement(inputTwitterUsernameXpath);
        inputTwitterUsername.sendKeys(user.getTwitterUserName());

        By inputCompanyXpath = By.xpath("//label[contains(text(), \"Company\")]/parent::dt/following::dd//input");
        wait.until(ExpectedConditions.elementToBeClickable(inputCompanyXpath));
        WebElement inputCompany = driver.findElement(inputCompanyXpath);
        inputCompany.sendKeys(user.getCompany());

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

abstract class User {
    private String email;
    private String password;
    private String bio;
    private String twitterUserName;
    private String company;

    public void setEmail(String email) { this.email = email; }
    public String getEmail() {
        return this.email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getBio() {
        return this.bio;
    }
    public void setTwitterUserName(String twitterUserName) {
        this.twitterUserName = twitterUserName;
    }
    public String getTwitterUserName() {
        return this.twitterUserName;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getCompany() {
        return this.company;
    }
    abstract void someMethod();
}

class SimpleUser extends User {
    public SimpleUser() { }
    public void someMethod() { }
}

class PremiumUser extends User {
    private String premium;

    public PremiumUser() { }

    public void setPremium(String premium) { this.premium = premium; }
    public String getPremium() { return this.premium; }
    public void someMethod() { };
}

class UserFactory
{
    public static User createUser(String userType) {
        switch (userType) {
            case "simple":
                SimpleUser simpleUser = new SimpleUser();
                simpleUser.setEmail("diman_the_red_devil@mail.ru");
                simpleUser.setPassword("JAKARTA12345rex-");
                simpleUser.setBio("I'm QA from Russia");
                simpleUser.setTwitterUserName("Diman The Red Devil");
                simpleUser.setCompany("QA Company");
                return simpleUser;
            case "premium":
                PremiumUser premiumUser = new PremiumUser();
                premiumUser.setEmail("diman_the_red_devil@mail.ru");
                premiumUser.setPassword("JAKARTA12345rex-");
                premiumUser.setBio("I'm QA from Russia");
                premiumUser.setTwitterUserName("Diman The Red Devil");
                premiumUser.setCompany("QA Company");
                premiumUser.setPremium("Premium");
                return premiumUser;
            default:
                throw new RuntimeException("Incorrect user type");
        }
    }*/
}