import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.print.PageMargin;
import org.openqa.selenium.print.PageSize;
import org.openqa.selenium.print.PrintOptions;

import java.io.FileOutputStream;
import java.io.IOException;

public class PrintPageTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(PrintPageTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("firefox");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void savePageToBase64TextTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");
        logger.info("Открыта страница webdriveruniversity.com - " + "https://webdriveruniversity.com/Click-Buttons/index.html");
        // Сохранение страницы в PDF
        PrintsPage printer = (PrintsPage) driver;
        PrintOptions printOptions = new PrintOptions();
        printOptions.setPageRanges("1-2");
        Pdf pdf = printer.print(printOptions);
        String content = pdf.getContent();
        logger.info(content);
    }

    @Test
    public void savePageToFileTest() {
        // Открыть страницу webdriveruniversity.com
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");
        logger.info("Открыта страница webdriveruniversity.com - " + "https://webdriveruniversity.com/Click-Buttons/index.html");
        // Сохранение страницы в PDF
        PrintsPage printer = (PrintsPage) driver;
        PrintOptions printOptions = new PrintOptions();
        printOptions.setPageRanges("1-2");
        Pdf pdf = printer.print(printOptions);
        String content = pdf.getContent();
        byte[] decoded = java.util.Base64.getDecoder().decode(content);
        try {
            FileOutputStream fos = new FileOutputStream("pdf.pdf");
            fos.write(decoded);
            fos.flush();
            fos.close();
            logger.info("Страница сохранена в файл pdf.pdf");
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
