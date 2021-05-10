import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWaitsTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(ExplicitWaitsTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void elementAttributeExpectedConditionTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Accordion/index.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/Accordion/index.html");
        // Раскрыть гармошку
        // Кликнуть на кнопку [Manual Testing]
        By btnManualTestingXpath = By.xpath("//button[text()=\"Manual Testing\"]");
        WebElement btnManualTesting = driver.findElement(btnManualTestingXpath);
        btnManualTesting.click();
        // Подождать пока не покажется блок с текстом
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        By divManualTestingXpath = By.xpath("//button[text()=\"Manual Testing\"]/following-sibling::div[1]");
        WebElement divManualTesting = driver.findElement(divManualTestingXpath);
        wait.until(ExpectedConditions.attributeToBe(divManualTesting, "style", "max-height: 70px;"));
        logger.info("Гармошка раскрыта!");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void elementStateExpectedConditionTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        // Подождать пока чекбокс [Option 1] не станет кликабельным
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        By chbOption1Xpath = By.xpath("//label[text()=\"Option 1\"]");
        WebElement chbOption1 = driver.findElement(chbOption1Xpath);
        wait.until(ExpectedConditions.elementToBeClickable(chbOption1));
        // Проставить чекбокс [Option 1]
        chbOption1.click();
        logger.info("Чекбокс проставлен!");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void elementsNumberExpectedConditionTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        // Подождать пока количество чекбоксов имеющих текст [Option] не будет 4
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        By chbOptionXpath = By.xpath("//label[contains(text(),\"Option\")]");
        wait.until(ExpectedConditions.numberOfElementsToBe(chbOptionXpath, 4));
        // Подсчитать количество чекбоксов имеющих текст [Option]
        List<WebElement> chbOption = driver.findElements(chbOptionXpath);
        int count = chbOption.size();
        logger.info("Чекбоксов имеющих текст [Option]: " + count);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void elementsPresenceExpectedConditionTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html");
        // Ввести текст в поле ввода [Food Item]
        By tbxFoodItemXpath = By.xpath("//div[@class=\"autocomplete\"]/input");
        WebElement tbxFoodItem = driver.findElement(tbxFoodItemXpath);
        tbxFoodItem.sendKeys("Ca");
        // Подождать пока отобразятся подсказки
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        By divAutoCompleteXpath = By.xpath("//div/input[@type=\"hidden\"]");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(divAutoCompleteXpath));
        // Вывести в лог содержимое подсказок
        List<WebElement> divAutoComplete = driver.findElements(divAutoCompleteXpath);
        for (WebElement element : divAutoComplete) {
            logger.info("Подсказка: " + element.getAttribute("value"));
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void elementStalenessExpectedConditionTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html");
        // Ввести текст в поле ввода [Food Item]
        By tbxFoodItemXpath = By.xpath("//div[@class=\"autocomplete\"]/input");
        WebElement tbxFoodItem = driver.findElement(tbxFoodItemXpath);
        tbxFoodItem.sendKeys("Ca");
        logger.info("Введен текст в поле ввода [Food Item]");
        // Подождать пока отобразятся подсказки
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        By divCabbageXpath = By.xpath("//input[@value=\"Cabbage\"]//parent::div");
        wait.until(ExpectedConditions.presenceOfElementLocated(divCabbageXpath));
        logger.info("Отобразились подсказки");
        // Найти подсказку Cabbage
        WebElement divCabbage = driver.findElement(divCabbageXpath);
        divCabbage.click();
        logger.info("Выбрана подсказка Cabbage");
        // Очистить поле ввода [Food Item]
        tbxFoodItem.clear();
        logger.info("Очищено поле ввода [Food Item]");
        // Ввести текст в поле ввода [Food Item]
        tbxFoodItem.sendKeys("Ba");
        // Подождать отсутствие подсказки Cabbage
        wait.until(ExpectedConditions.stalenessOf(divCabbage));
        logger.info("Подсказка Cabbage отсутствует");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void elementVisibilityExpectedConditionTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        // Нажать на выпадашку [JAVA]
        By selProgLangsXpath = By.xpath("//h2[text()=\"Dropdown Menu(s)\"]/following-sibling::div/select[1]");
        WebElement selProgLangs = driver.findElement(selProgLangsXpath);
        selProgLangs.click();
        logger.info("Нажата выпадашка [JAVA]");
        // Подождать пока отобразится вариант для выбора [Python] в выпадашке [JAVA]
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        By optJavaXpath = By.xpath("//h2[text()=\"Dropdown Menu(s)\"]/following-sibling::div/select[1]/option[@value=\"python\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(optJavaXpath));
        logger.info("Отображается вариант для выбора [Python]");
        // Выбрать вариант для выбора [Python]
        WebElement optJava = driver.findElement(optJavaXpath);
        optJava.click();
        logger.info("Выбран вариант для выбора [Python]");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void elementInvisibilityExpectedConditionTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Hidden-Elements/index.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/Hidden-Elements/index.html");
        // Подождать что не отобразится элемент [Not Displayed]
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        By divSpanXpath = By.xpath("//div/span[1]");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divSpanXpath));
        logger.info("Не отображается элемент [Not Displayed]");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void elementTextExpectedConditionTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Accordion/index.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/Accordion/index.html");
        // Вывести текст в блоке с @id="text-appear-box"
        By divPXpath = By.xpath("//div[@id=\"text-appear-box\"]/p");
        WebElement divP = driver.findElement(divPXpath);
        logger.info("Текст в блоке @id=\"text-appear-box\": " + divP.getText());
        // Подождать пока смениться текст в блоке
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.textToBe(divPXpath, "LOADING COMPLETE."));
        // Вывести текст в блоке с @id="text-appear-box"
        logger.info("Текст в блоке @id=\"text-appear-box\": " + divP.getText());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void pageExpectedConditionTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/index.html");
        logger.info("Открыта страница webdriveruniversity.com - https://webdriveruniversity.com/index.html");
        // Подождать пока появится заголовок страницы
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.titleContains("WebDriverUniversity.com"));
        // Вывести заголовок страницы
        logger.info("Заголовок страницы: " + driver.getTitle());

        try {
            Thread.sleep(3000);
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
