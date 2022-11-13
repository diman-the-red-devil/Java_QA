import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class Selenium3Listener extends AbstractWebDriverEventListener {
    private Logger logger = LogManager.getLogger(Selenium3Listener.class);

    // До поиска веб элемента
    @Override
    public void beforeFindBy(By locator, WebElement element, WebDriver driver) {
        logger.info("До поиска веб элемента: Сделать что-то, например записать в лог локатор веб элемента");
    }

    // После поиска веб элемента
    @Override
    public void afterFindBy(By locator, WebElement element, WebDriver driver) {
        logger.info("После поиска веб элемента: Сделать что-то, например записать в лог тег веб элемента");
    }

    // До нажатия на веб элемент
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("До нажатия на веб элемент: Сделать что-то, например снять скриншот");
    }

    // После нажатия на веб элемент
    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info("После нажатия на веб элемент: Сделать что-то, например снять скриншот");
    }
}
