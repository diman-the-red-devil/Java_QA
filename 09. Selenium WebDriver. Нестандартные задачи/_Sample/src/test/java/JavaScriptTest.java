import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JavaScriptTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(JavaScriptTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void elementClickTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Hidden-Elements/index.html");
        logger.info("Открыта страница webdriveruniversity.com - " + "https://webdriveruniversity.com/Hidden-Elements/index.html");

        // Клик по кнопке
        String button1Xpath = "//span[@id=\"button1\"]";
        WebElement button1 = driver.findElement(By.xpath(button1Xpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].click();";
        js.executeScript(script, button1);
        logger.info("Нажата кнопка");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void elementGetTextTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");
        logger.info("Открыта страница webdriveruniversity.com - " + "https://webdriveruniversity.com/Click-Buttons/index.html");

        // Вывод текста элементов
        String sectionsXpath = "//div[@class=\"section-title\"]";
        List<WebElement> sections = driver.findElements(By.xpath(sectionsXpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return arguments[0].innerText;";
        for (WebElement section : sections) {
            String text = js.executeScript(script, section).toString();
            logger.info("Текст: \n" + text);
        }
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void scrollPagetest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
        logger.info("Открыта страница webdriveruniversity.com - " + "https://webdriveruniversity.com/Data-Table/index.html");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Проскроллить вниз на 500px
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script1 = "window.scrollBy(0,500);";
        js.executeScript(script1);
        logger.info("Проскроллено вниз на 500px");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Проскроллить вниз на 500px
        String script2 = "window.scrollBy(500,1000);";
        js.executeScript(script2);
        logger.info("Проскроллено вниз на 500px");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void opacityChangeTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Hidden-Elements/index.html");
        logger.info("Открыта страница webdriveruniversity.com - " + "https://webdriveruniversity.com/Hidden-Elements/index.html");
        logger.info("Кнопка прозрачная");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Изменение прозрачности элемента
        String divOpacityZeroXpath = "//div[@id=\"zero-opacity\"]";
        WebElement divOpacityZero = driver.findElement(By.xpath(divOpacityZeroXpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].style.opacity=1; return true;";
        js.executeScript(script, divOpacityZero);
        logger.info("Кнопка непрозрачная");

        // Клик по элементу
        divOpacityZero.click();
        logger.info("Нажата кнопка");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void visibilityChangeTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Hidden-Elements/index.html");
        logger.info("Открыта страница webdriveruniversity.com - " + "https://webdriveruniversity.com/Hidden-Elements/index.html");
        logger.info("Кнопка невидимая");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Изменение видимости элемента
        String divVisibilityHiddenXpath = "//div[@id=\"visibility-hidden\"]";
        WebElement divVisibilityHidden = driver.findElement(By.xpath(divVisibilityHiddenXpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].style.visibility='visible';";
        js.executeScript(script, divVisibilityHidden);
        logger.info("Кнопка видимая");

        // Клик по элементу
        divVisibilityHidden.click();
        logger.info("Нажата кнопка");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void displayChangeTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Hidden-Elements/index.html");
        logger.info("Открыта страница webdriveruniversity.com - " + "https://webdriveruniversity.com/Hidden-Elements/index.html");
        logger.info("Кнопка неотображаемая");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Изменение отображаемости элемента
        String divDisplayNoneXpath = "//div[@id=\"not-displayed\"]";
        WebElement divDisplayNone = driver.findElement(By.xpath(divDisplayNoneXpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].style.display='block';";
        js.executeScript(script, divDisplayNone);
        logger.info("Кнопка отображаемая");

        // Клик по элементу
        divDisplayNone.click();
        logger.info("Нажата кнопка");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bgColorChangeTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");
        logger.info("Открыта страница webdriveruniversity.com - " + "https://webdriveruniversity.com/Click-Buttons/index.html");

        // Цвет кнопки до
        String spanBtnXpath = "//span[@id=\"button1\"]";
        WebElement spanBtn = driver.findElement(By.xpath(spanBtnXpath));
        String colorBefore = spanBtn.getCssValue("background-color");
        logger.info("Цвет кнопки до - " + colorBefore);
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Изменение цвета кнопки
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].style.backgroundColor = 'HotPink'";
        js.executeScript(script, spanBtn);

        // Цвет кнопки после
        String colorAfter= spanBtn.getCssValue("background-color");
        logger.info("Цвет кнопки после - " + colorAfter);
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}

