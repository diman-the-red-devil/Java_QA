package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

// Класс для выполнения сложных действий
public class ActionHelper {
    // Логгер
    private Logger logger = LogManager.getLogger(ActionHelper.class);
    // Экшен
    protected static Actions actions;

    // Инициализация экшена
    public static void init(WebDriver driver) {
        actions = new Actions(driver);
    }

    // Перемещение курсора мыши на элемент
    public static void moveToElement(WebElement webElement) {
        actions.moveToElement(webElement).perform();
    }
}
