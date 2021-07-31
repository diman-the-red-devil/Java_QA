package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс ожиданий событий на странице
public class WaitFor {
    // Логгер
    private Logger logger = LogManager.getLogger(WaitFor.class);
    // Ожидание драйвера браузера
    protected static WebDriverWait wait;

    // Установка таймаута ожидания и интервала опроса
    public static void initWait(WebDriver driver, Duration timeOut, Duration sleep) {
        wait = new WebDriverWait(driver, timeOut, sleep);
    }

    public static void presenceOfElementLocated(By webElement) {
        wait.until(ExpectedConditions.presenceOfElementLocated(webElement));
    }

    // Ожидание появления текста в элементе
    public static void textToBePresentInElement(WebElement webElement, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    // Ожидание кликабельности элемента
    public static void elementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    // Ожидание кликабельности элемента
    public static void elementToBeClickable(By webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    // Ожидание видимости элемента
    public static void visibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    // Ожидание видимости элемента
    public static void visibilityOfElementLocated(By webElement) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
    }
}
