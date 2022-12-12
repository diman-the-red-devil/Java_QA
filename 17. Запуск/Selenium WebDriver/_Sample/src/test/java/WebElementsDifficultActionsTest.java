import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
public class WebElementsDifficultActionsTest {
    protected WebDriver driver;
    private Logger logger = LogManager.getLogger(WebElementSimpleActionsTest.class);

    @BeforeEach
    public void setUp() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void clickTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement element = driver.findElement(By.id("click-box"));
        // Левый клик мышью в текущей позиции
        Actions actions = new Actions(driver);
        actions
                .moveToElement(element)
                .click()
                .perform();
        String text = element.getText();
        logger.info("Text: " + text);
        Assertions.assertTrue(text.equals("Dont release me!!!"));
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clickTargetTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement element = driver.findElement(By.id("click-box"));
        // Левый клик мышью в центре элемента
        Actions actions = new Actions(driver);
        actions
                .click(element)
                .perform();
        String text = element.getText();
        logger.info("Text: " + text);
        Assertions.assertTrue(text.equals("Dont release me!!!"));
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clickAndHoldTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement element = driver.findElement(By.id("click-box"));
        // Левый клик мышью c удержанием в текущей позиции
        Actions actions = new Actions(driver);
        actions
                .moveToElement(element)
                .clickAndHold()
                .perform();
        String text = element.getText();
        logger.info("Text: " + text);
        Assertions.assertTrue(text.equals("Well done! keep holding that click now....."));
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clickAndHoldTargetTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement element = driver.findElement(By.id("click-box"));
        // Левый клик мышью c удержанием в центре элемент
        Actions actions = new Actions(driver);
        actions
                .clickAndHold(element)
                .perform();
        String text = element.getText();
        logger.info("Text: " + text);
        Assertions.assertTrue(text.equals("Well done! keep holding that click now....."));
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void contextClickTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement element = driver.findElement(By.id("click-box"));
        // Правый клик мышью в текущей позиции
        Actions actions = new Actions(driver);
        actions
                .moveToElement(element)
                .contextClick()
                .perform();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void contextClickTargetTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement element = driver.findElement(By.id("click-box"));
        // Правый клик мышью в центре элемента
        Actions actions = new Actions(driver);
        actions
                .contextClick(element)
                .perform();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doubleClickTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement element = driver.findElement(By.id("double-click"));
        // Двойной клик мышью в текущей позиции
        Actions actions = new Actions(driver);
        actions
                .moveToElement(element)
                .doubleClick()
                .perform();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doubleClickTargetTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement element = driver.findElement(By.id("double-click"));
        // Двойной клик мышью в центре элемента
        Actions actions = new Actions(driver);
        actions
                .doubleClick(element)
                .perform();
        String color = element.getCssValue("background-color");
        logger.info("Color: " + color);
        Assertions.assertTrue(color.equals("rgba(147, 203, 90, 1)"));
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dragAndDropTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        // Перетаскивание объекта
        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(source, target)
                .perform();
        String text = target.getText();
        logger.info("Text: " + text);
        Assertions.assertTrue(text.equals("Dropped!"));
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dragAndDropByTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        // Перетаскивание объекта со смещением
        Actions actions = new Actions(driver);
        actions
                .dragAndDropBy(source, 80, 80)
                .perform();
        String text = target.getText();
        logger.info("Text: " + text);
        Assertions.assertTrue(text.equals("Dropped!"));
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void keyDownKeyUpTest(){
        driver.get("https://webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html");
        WebElement element = driver.findElement(By.id("myInput"));
        // Нажатие и отпускание клавиши клавиатуры
        Actions actions = new Actions(driver);
        actions
                .moveToElement(element)
                .keyDown(Keys.SHIFT)
                .sendKeys("kiwi")
                .keyUp(Keys.SHIFT)
                .perform();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void keyDownKeyUpTargetTest(){
        driver.get("https://webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html");
        WebElement element = driver.findElement(By.id("myInput"));
        // Нажатие и отпускание клавиши клавиатуры в элементе
        Actions actions = new Actions(driver);
        actions
                .keyDown(element, Keys.SHIFT)
                .sendKeys(element, "kiwi")
                .keyUp(element, Keys.SHIFT)
                .perform();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void moveByOffsetTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement element = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        // Смещение мыши
        Actions actions = new Actions(driver);
        actions
                .moveToElement(element)
                .moveByOffset(0, 30)
                .click()
                .perform();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void moveToElementTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement element = driver.findElement(By.xpath("//button[text()='Hover Over Me Second!']"));
        // Перемещение мыши в центр элемента
        Actions actions = new Actions(driver);
        actions
                .moveToElement(element)
                .perform();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void moveToElementOffsetTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement element = driver.findElement(By.xpath("//button[text()='Hover Over Me Second!']"));
        // Перемещение мыши в центр элемента со смещением
        Actions actions = new Actions(driver);
        actions
                .moveToElement(element, 0, 10)
                .perform();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void releaseTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement element = driver.findElement(By.id("click-box"));
        // Отпускание левой кнопки мыши
        Actions actions = new Actions(driver);
        actions
                .clickAndHold(element)
                .pause(600)
                .release()
                .perform();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void releaseTargetTest(){
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        logger.info("Открыта страница webdriveruniversity.com - " +
                "https://webdriveruniversity.com/Actions/index.html#");
        WebElement element = driver.findElement(By.id("click-box"));
        // Отпускание левой кнопки мыши в центре элемента
        Actions actions = new Actions(driver);
        actions
                .moveToElement(element)
                .clickAndHold()
                .pause(600)
                .release(element)
                .perform();
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
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
