package webdriverfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class Selenium4Listener implements WebDriverListener {
    private Logger logger = LogManager.getLogger(Selenium4Listener.class);

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        logger.info("Before Find Element " + locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info("After Find Element " + locator + " An Element <" + result.getTagName() + ">");
    }

    @Override
    public void beforeClick(WebElement element) {
        logger.info("Before Click On Element <" + element.getTagName() + ">");
    }

    @Override
    public void afterClick(WebElement element) {
        logger.info("After Click On Element <" + element.getTagName() + ">");
    }
}
