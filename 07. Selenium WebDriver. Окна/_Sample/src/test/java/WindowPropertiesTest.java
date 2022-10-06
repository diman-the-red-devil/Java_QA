import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;

public class WindowPropertiesTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(WindowPropertiesTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void fullScreenWindowTest() {
        // Открыть страницу https://devqa.io/
        driver.get("https://devqa.io/");
        logger.info("Открыта страница devqa.io - https://devqa.io/");

        // Установка полноэкранного режима окна браузера
        driver.manage().window().fullscreen();
        logger.info("Окно переведено в полноэкранный режим");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWindowPropertiesTest() {
        // Открыть страницу https://devqa.io/
        driver.get("https://devqa.io/");
        logger.info("Открыта страница devqa.io - https://devqa.io/");

        // Получить параметры окна
        // Координаты окна
        Point position = driver.manage().window().getPosition();
        logger.info("Координаты окна: [" + position.getX() + ", " + position.getY() + "]");
        // Размеры окна
        Dimension size = driver.manage().window().getSize();
        logger.info("Размеры окна: [" + size.getWidth() + ", " + size.getHeight() + "]");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setWindowPropertiesTest() {
        // Открыть страницу https://devqa.io/
        driver.get("https://devqa.io/");
        logger.info("Открыта страница devqa.io - https://devqa.io/");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Получить исходные параметры окна
        logger.info("Исходные параметры окна");
        // Координаты окна
        Point positionBefore = driver.manage().window().getPosition();
        logger.info("Координаты окна: [" + positionBefore.getX() + ", " + positionBefore.getY() + "]");
        // Размеры окна
        Dimension sizeBefore = driver.manage().window().getSize();
        logger.info("Размеры окна: [" + sizeBefore.getWidth() + ", " + sizeBefore.getHeight() + "]");

        // Установить параметры окна
        // Координаты окна
        Point newPosition = new Point(200, 200);
        driver.manage().window().setPosition(newPosition);
        // Размеры окна
        Dimension newSize = new Dimension(1520, 680);
        driver.manage().window().setSize(newSize);
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Получить новые параметры окна
        logger.info("Новые параметры окна");
        // Координаты окна
        Point positionAfter = driver.manage().window().getPosition();
        logger.info("Координаты окна: [" + positionAfter.getX() + ", " + positionAfter.getY() + "]");
        // Размеры окна
        Dimension sizeAfter = driver.manage().window().getSize();
        logger.info("Размеры окна: [" + sizeAfter.getWidth() + ", " + sizeAfter.getHeight() + "]");
    }

    @Test
    public void maxMinWindowTest() {
        // Открыть страницу https://devqa.io/
        driver.get("https://devqa.io/");
        logger.info("Открыта страница devqa.io - https://devqa.io/");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Получить исходные параметры окна
        logger.info("Исходные параметры окна");
        // Координаты окна
        Point positionBefore = driver.manage().window().getPosition();
        logger.info("Координаты окна: [" + positionBefore.getX() + ", " + positionBefore.getY() + "]");
        // Размеры окна
        Dimension sizeBefore = driver.manage().window().getSize();
        logger.info("Размеры окна: [" + sizeBefore.getWidth() + ", " + sizeBefore.getHeight() + "]");

        // Максимизация окна
        driver.manage().window().maximize();
        logger.info("Максимизация окна");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Получить новые параметры окна
        logger.info("Параметры окна после максимизации");
        // Координаты окна
        Point positionAfterMaximize = driver.manage().window().getPosition();
        logger.info("Координаты окна: [" + positionAfterMaximize.getX() + ", " + positionAfterMaximize.getY() + "]");
        // Размеры окна
        Dimension sizeAfterMaximize = driver.manage().window().getSize();
        logger.info("Размеры окна: [" + sizeAfterMaximize.getWidth() + ", " + sizeAfterMaximize.getHeight() + "]");

        // Минимизация окна
        driver.manage().window().minimize();
        logger.info("Минимизация окна");
        // Добавление задержки Thread.sleep, чтобы увидеть результат
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Получить новые параметры окна
        logger.info("Параметры окна после минимизации");
        // Координаты окна
        Point positionAfterMinimize = driver.manage().window().getPosition();
        logger.info("Координаты окна: [" + positionAfterMinimize.getX() + ", " + positionAfterMinimize.getY() + "]");
        // Размеры окна
        Dimension sizeAfterMinimize = driver.manage().window().getSize();
        logger.info("Размеры окна: [" + sizeAfterMinimize.getWidth() + ", " + sizeAfterMinimize.getHeight() + "]");
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
