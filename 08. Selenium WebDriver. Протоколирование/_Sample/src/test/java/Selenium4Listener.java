import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class Selenium4Listener implements WebDriverListener {
    private Logger logger = LogManager.getLogger(Selenium4Listener.class);

    // До поиска веб элемента
    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        logger.info("До поиска веб элемента: Сделать что-то, например записать в лог локатор веб элемента");
    }

    // После поиска веб элемента
    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info("После поиска веб элемента: Сделать что-то, например записать в лог тег веб элемента");
    }

    // До нажатия на веб элемент
    @Override
    public void beforeClick(WebElement element) {
        logger.info("До нажатия на веб элемент: Сделать что-то, например снять скриншот");
    }

    // После нажатия на веб элемент
    @Override
    public void afterClick(WebElement element) {
        logger.info("После нажатия на веб элемент: Сделать что-то, например снять скриншот");
    }
}
