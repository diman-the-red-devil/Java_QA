package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс ожиданий событий на странице
public class WaitHelper {
    // Логгер
    private static Logger logger = LogManager.getLogger(WaitHelper.class);
    // Ожидание драйвера браузера
    protected static WebDriverWait webDriverWait;

    // Инициализация ожидания драйвера браузера
    // Установка таймаута ожидания и интервала опроса
    public static void init(WebDriver driver, Duration timeOut, Duration sleep) {
        webDriverWait = new WebDriverWait(driver, timeOut, sleep);
    }

    // Ожидание наличия элемента по локатору
    public static void presenceOfElementLocated(By webElement) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(webElement));
    }

    // Ожидание появления текста в элементе
    public static void presenceOfTextInElement(WebElement webElement, String text) {
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    // Ожидание кликабельности элемента
    public static void clickabilityOfElement(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    // Ожидание кликабельности элемента по локатору
    public static void clickabilityOfElementLocated(By webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    // Ожидание видимости элемента
    public static void visibilityOfElement(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    // Ожидание видимости элемента по локатору
    public static void visibilityOfElementLocated(By webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
    }

    // Ожидание появления в списке продуктов в первой позиции заданного продукта
    public static void firstProductMustBe(By webElement, String product) {
        webDriverWait.until((ExpectedCondition<Boolean>) webDriver ->
                webDriver.findElement(webElement).getText().contains(product));
    }
}
