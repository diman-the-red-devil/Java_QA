import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class Selenium3Listener extends AbstractWebDriverEventListener {
    private Logger logger = LogManager.getLogger(Selenium3Listener.class);

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Before Find Element " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("After Find Element " + by + " An Element <" + element.getTagName() + ">");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("Before Click On Element <" + element.getTagName() + ">");
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info("After Click On Element <" + element.getTagName() + ">");
    }
}
