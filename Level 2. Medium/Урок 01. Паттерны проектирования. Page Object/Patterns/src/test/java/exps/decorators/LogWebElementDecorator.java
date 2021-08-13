package exps.decorators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.util.Arrays;
import java.util.List;

public class LogWebElementDecorator extends BaseWebElementDecorator {
    Logger logger = LogManager.getLogger(LogWebElementDecorator.class);

    public LogWebElementDecorator(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        logger.info(String.format("Элемент [%s]: Нажатие", webElement.getTagName()));
        webElement.click();
    }

    @Override
    public void submit() {
        logger.info(String.format("Элемент [%s]: Отправка формы", webElement.getTagName()));
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        logger.info(String.format("Элемент [%s]: Ввод текста = %s", webElement.getTagName(), Arrays.toString(keysToSend)));
        webElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        logger.info(String.format("Элемент [%s]: Удаление текста", webElement.getTagName()));
        webElement.clear();
    }

    @Override
    public String getTagName() {
        String tag = webElement.getTagName();
        logger.info(String.format("Элемент [%s]: Тег = %s", webElement.getTagName(), tag));
        return tag;
    }

    @Override
    public String getAttribute(String name) {
        String attribute = webElement.getAttribute(name);
        logger.info(String.format("Элемент [%s]: Атрибут[%s] = %s", webElement.getTagName(), name, attribute));
        return attribute;
    }

    @Override
    public boolean isSelected() {
        boolean selected = webElement.isSelected();
        logger.info(String.format("Элемент [%s]: Выбран? = %s", webElement.getTagName(), selected));
        return selected;
    }

    @Override
    public boolean isEnabled() {
        boolean enabled = webElement.isEnabled();
        logger.info(String.format("Элемент [%s]: Активен? = %s", webElement.getTagName(), enabled));
        return enabled;
    }

    @Override
    public String getText() {
        String text = webElement.getText();
        logger.info(String.format("Элемент [%s]: Текст = %s", webElement.getTagName(), text));
        return text;
    }

    @Override
    public List<WebElement> findElements(By by) {
        List<WebElement> webElements = webElement.findElements(by);
        for (WebElement w : webElements) {
            logger.info(String.format("Элемент [%s]: Элемент = %s", webElement.getTagName(), w.getTagName()));
        }
        return webElements;
    }

    @Override
    public WebElement findElement(By by) {
        WebElement w = webElement.findElement(by);
        logger.info(String.format("Элемент [%s]: Элемент = %s", webElement.getTagName(), w.getTagName()));
        return w;
    }

    @Override
    public boolean isDisplayed() {
        boolean displayed = webElement.isDisplayed();
        logger.info(String.format("Элемент [%s]: Отображается? = %s", webElement.getTagName(), displayed));
        return displayed;
    }

    @Override
    public Point getLocation() {
        Point point = webElement.getLocation();
        logger.info(String.format("Элемент [%s]: X = %s, Y = %s", webElement.getTagName(), point.getX(), point.getY()));
        return point;
    }

    @Override
    public Dimension getSize() {
        Dimension dimension = webElement.getSize();
        logger.info(String.format("Элемент [%s]: W = %s, H = %s", webElement.getTagName(), dimension.getWidth(), dimension.getHeight()));
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        Rectangle rect = webElement.getRect();
        logger.info(String.format("Элемент [%s]: X = %s, Y = %s, W = %s, H = %s", webElement.getTagName(), rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight()));
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        String cssValue = webElement.getCssValue(propertyName);
        logger.info(String.format("Элемент [%s]: CSS [%s] = %s", webElement.getTagName(), propertyName, cssValue));
        return cssValue;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
