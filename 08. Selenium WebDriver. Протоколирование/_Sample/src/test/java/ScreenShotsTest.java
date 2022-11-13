import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Sleeper;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.cropper.indent.BlurFilter;
import ru.yandex.qatools.ashot.cropper.indent.IndentCropper;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

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
        // Нажать на кнопку "Всё верно"
        By btnYesXPath = By.xpath("(//span[text()=\"Всё верно\"])[1]");
        WebElement btnYes = driver.findElement(btnYesXPath);
        btnYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
        // Ожидание обновления страницы
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Нажать на ссылку "Бытовая техника"
        By linkBTXPath = By.xpath("//div/a[text()=\"Бытовая техника\"]");
        WebElement linkBT = driver.findElement(linkBTXPath);
        linkBT.click();
        logger.info("Нажата ссылка \"Бытовая техника\"");
        // Сделать скриншот видимой области веб страницы
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(file);
            ImageIO.write(image, "png", new File("temp\\TSViewablePage.png"));
            logger.info("Скриншот сохранен в файле [temp\\TSViewablePage.png]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void takesScreenshotElementTest() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
        // Нажать на кнопку "Всё верно"
        By btnYesXPath = By.xpath("(//span[text()=\"Всё верно\"])[1]");
        WebElement btnYes = driver.findElement(btnYesXPath);
        btnYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
        // Ожидание обновления страницы
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Нажать на ссылку "Бытовая техника"
        By linkBTXPath = By.xpath("//div/a[text()=\"Бытовая техника\"]");
        WebElement linkBT = driver.findElement(linkBTXPath);
        linkBT.click();
        logger.info("Нажата ссылка \"Бытовая техника\"");
        // Сделать скриншот веб элемента
        try {
            By divSubcategoryXPath = By.xpath("//div[@class=\"subcategory__item-container \"]");
            WebElement divSubcategory = driver.findElement(divSubcategoryXPath);
            File file = divSubcategory.getScreenshotAs(OutputType.FILE);
            BufferedImage viewablePageImage = ImageIO.read(file);
            ImageIO.write(viewablePageImage, "png", new File("temp\\TSElement.png"));
            logger.info("Скриншот сохранен в файле [temp\\TSElement.png]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void takesScreenshotElementFromViewablePageTest() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
        // Нажать на кнопку "Всё верно"
        By btnYesXPath = By.xpath("(//span[text()=\"Всё верно\"])[1]");
        WebElement btnYes = driver.findElement(btnYesXPath);
        btnYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
        // Ожидание обновления страницы
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Нажать на ссылку "Бытовая техника"
        By linkBTXPath = By.xpath("//div/a[text()=\"Бытовая техника\"]");
        WebElement linkBT = driver.findElement(linkBTXPath);
        linkBT.click();
        logger.info("Нажата ссылка \"Бытовая техника\"");
        // Сделать скриншот веб элемента вырезанный из видимой области веб страницы
        try {
            By divSubcategoryXPath = By.xpath("//div[@class=\"subcategory__item-container \"]");
            WebElement divSubcategory = driver.findElement(divSubcategoryXPath);
            Point location = divSubcategory.getLocation();
            Dimension size = divSubcategory.getSize();
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage viewablePageImage = ImageIO.read(file);
            BufferedImage linkYesImage = viewablePageImage.getSubimage(
                location.getX() - 50, location.getY() - 50,
                size.getWidth() + 200, size.getHeight() + 100);
            ImageIO.write(linkYesImage, "png", new File("temp\\TSElementFromViewablePage.png"));
            logger.info("Скриншот сохранен в файле [temp\\TSElementFromViewablePage.png]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void aShotViewablePageTest() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
        // Нажать на кнопку "Всё верно"
        By btnYesXPath = By.xpath("(//span[text()=\"Всё верно\"])[1]");
        WebElement btnYes = driver.findElement(btnYesXPath);
        btnYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
        // Ожидание обновления страницы
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Нажать на ссылку "Бытовая техника"
        By linkBTXPath = By.xpath("//div/a[text()=\"Бытовая техника\"]");
        WebElement linkBT = driver.findElement(linkBTXPath);
        linkBT.click();
        logger.info("Нажата ссылка \"Бытовая техника\"");
        // Сделать скриншот видимой области веб страницы
        try {
            Screenshot screenshot = new AShot().takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\ASViewablePage.png"));
            logger.info("Скриншот сохранен в файле [temp\\ASViewablePage.png]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void aShotFullPageTest() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
        // Нажать на кнопку "Всё верно"
        By btnYesXPath = By.xpath("(//span[text()=\"Всё верно\"])[1]");
        WebElement btnYes = driver.findElement(btnYesXPath);
        btnYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
        // Ожидание обновления страницы
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Нажать на ссылку "Бытовая техника"
        By linkBTXPath = By.xpath("//div/a[text()=\"Бытовая техника\"]");
        WebElement linkBT = driver.findElement(linkBTXPath);
        linkBT.click();
        logger.info("Нажата ссылка \"Бытовая техника\"");
        // Сделать скриншот всей веб страницы
        try {
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\ASFullPage.png"));
            logger.info("Скриншот сохранен в файле [temp\\ASFullPage.png]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void aShotElementTest() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
        // Нажать на кнопку "Всё верно"
        By btnYesXPath = By.xpath("(//span[text()=\"Всё верно\"])[1]");
        WebElement btnYes = driver.findElement(btnYesXPath);
        btnYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
        // Ожидание обновления страницы
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Нажать на ссылку "Бытовая техника"
        By linkBTXPath = By.xpath("//div/a[text()=\"Бытовая техника\"]");
        WebElement linkBT = driver.findElement(linkBTXPath);
        linkBT.click();
        logger.info("Нажата ссылка \"Бытовая техника\"");
        // Сделать скриншот веб элемента
        try {
            By divSubcategoryXPath = By.xpath("//div[@class=\"subcategory__item-container \"]");
            WebElement divSubcategory = driver.findElement(divSubcategoryXPath);
            Screenshot screenshot = new AShot()
                    .coordsProvider(new WebDriverCoordsProvider())
                    .takeScreenshot(driver, divSubcategory);
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\ASElement.png"));
            logger.info("Скриншот сохранен в файле [temp\\ASElement.png]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void aShotCompareImagesTest() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
        // Нажать на кнопку "Всё верно"
        By btnYesXPath = By.xpath("(//span[text()=\"Всё верно\"])[1]");
        WebElement btnYes = driver.findElement(btnYesXPath);
        btnYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
        // Ожидание обновления страницы
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Нажать на ссылку "Бытовая техника"
        By linkBTXPath = By.xpath("//div/a[text()=\"Бытовая техника\"]");
        WebElement linkBT = driver.findElement(linkBTXPath);
        linkBT.click();
        logger.info("Нажата ссылка \"Бытовая техника\"");
        // Сравнить скриншот с образцом
        try {
            BufferedImage actualImage = new AShot().takeScreenshot(driver).getImage();
            BufferedImage expectedImage = ImageIO.read(new File("temp\\ASCompareImagesExpectedImage.png"));
            ImageDiffer imageDiffer = new ImageDiffer();
            ImageDiff diff = imageDiffer.makeDiff(actualImage, expectedImage);
            if (diff.hasDiff()) {
                logger.info("Изображения одинаковые");
            } else {
                logger.info("Изображения разные");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void aShotPrettifyTest() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
        // Нажать на кнопку "Всё верно"
        By btnYesXPath = By.xpath("(//span[text()=\"Всё верно\"])[1]");
        WebElement btnYes = driver.findElement(btnYesXPath);
        btnYes.click();
        logger.info("Нажата кнопка \"Всё верно\"");
        // Ожидание обновления страницы
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Нажать на ссылку "Бытовая техника"
        By linkBTXPath = By.xpath("//div/a[text()=\"Бытовая техника\"]");
        WebElement linkBT = driver.findElement(linkBTXPath);
        linkBT.click();
        logger.info("Нажата ссылка \"Бытовая техника\"");
        // Сделать скриншот с эффектом
        try {
            By divSubcategoryXPath = By.xpath("//div[@class=\"subcategory__item-container \"]");
            WebElement divSubcategory = driver.findElement(divSubcategoryXPath);
            Screenshot screenshot = new AShot()
                    .imageCropper(new IndentCropper()
                            .addIndentFilter(new BlurFilter()))
                    .takeScreenshot(driver, divSubcategory);
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\ASPrettify.png"));
            logger.info("Скриншот сохранен в файле [temp\\ASPrettify.png]");
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
