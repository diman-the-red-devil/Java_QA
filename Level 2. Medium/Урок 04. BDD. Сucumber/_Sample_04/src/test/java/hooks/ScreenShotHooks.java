package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import web.drivers.WebDriverFactory;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

public class ScreenShotHooks {
    // Драйвер браузера
    protected static WebDriver driver = WebDriverFactory.getCurrentDriver();
    // Логгер
    private Logger logger = LogManager.getLogger(ScreenShotHooks.class);

    // Действия совершаемые перед каждым шагом
    @BeforeStep
    public void takeScreenShotBeforeStep(Scenario scenario) {
        // Сделать скриншот видимой области веб страницы
        try {
            Screenshot screenshot = new AShot().takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png",
                    new File("temp\\" + scenario.getName() + "-" + Timestamp.from(Instant.now()).getTime() + ".png"));
            logger.info("Скриншот сохранен в файле [temp\\ASViewablePage.png]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Действия совершаемые после каждого шага
    @AfterStep
    public void takeScreenShotAfterStep(Scenario scenario) {
        // Сделать скриншот видимой области веб страницы
        try {
            Screenshot screenshot = new AShot().takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png",
                    new File("temp\\" + scenario.getName() + "-" + Timestamp.from(Instant.now()).getTime() + ".png"));
            logger.info("Скриншот сохранен в файле [temp\\ASViewablePage.png]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
