import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class ScreenShotsTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(ScreenShotsTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void takesScreenshotViewablePageTest() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
        // Нажать на ссылку "Да"
        By linkYesXPath = By.xpath("//a[text()=\"Да\"]");
        WebElement linkYes = driver.findElement(linkYesXPath);
        linkYes.click();
        logger.info("Нажата ссылка \"Да\"");
        // Нажать на ссылку "Бытовая техника"
        By linkBTXPath = By.xpath("//div/a[text()=\"Бытовая техника\"]");
        WebElement linkBT = driver.findElement(linkBTXPath);
        linkBT.click();
        logger.info("Нажата ссылка \"Бытовая техника\"");
        // Сделать скриншот всей страницы
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("temp\\screenshot.png"));
            logger.info("Скриншот сохранен в файле [temp\\screenshot.png]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void takesScreenshotElementTest() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
        // Сделать скриншот ссылки "Да"
        By linkYesXPath = By.xpath("//a[text()=\"Да\"]");
        WebElement linkYes = driver.findElement(linkYesXPath);
        File file = linkYes.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("temp\\screenshot.png"));
            logger.info("Скриншот сохранен в файле [temp\\screenshot.png]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void takesScreenshotElementFromViewablePageTest() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
        // Найти элемент
        By linkYesXPath = By.xpath("//a[text()=\"Да\"]");
        WebElement linkYes = driver.findElement(linkYesXPath);
        // Получить координаты и размеры элемента
        Point location = linkYes.getLocation();
        Dimension size = linkYes.getSize();
        // Сделать скриншот всей страницы
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Сделать скриншот ссылки "Да"
        try {
            BufferedImage viewablePageImage = ImageIO.read(file);
            BufferedImage linkYesImage = viewablePageImage.getSubimage(
                location.getX() - 50, location.getY() - 50,
                size.getWidth() + 200, size.getHeight() + 100);
            ImageIO.write(linkYesImage, "png", file);
            FileUtils.copyFile(file, new File("temp\\screenshot.png"));
            logger.info("Скриншот сохранен в файле [temp\\screenshot.png]");
        } catch (IOException e) {
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
