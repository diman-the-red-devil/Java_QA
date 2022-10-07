import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.print.PrintOptions;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PdfTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(PdfTest.class);

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void pdfTextPdfBoxTest() {
        // Открыть страницу с PDF
        String pdfURL = "http://www.pdf995.com/samples/pdf.pdf";
        driver.get(pdfURL);

        try {
            // Открытие файла PDF
            PDDocument pdf = PDDocument.load(new BufferedInputStream(new URL(pdfURL).openStream()));
            // Извлечение текста из документа PDF
            String text = new PDFTextStripper().getText(pdf);
            logger.info(text);
            // Закрытие файла PDF
            pdf.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void pdfTextITextPdfTest() {
        // Открыть страницу с PDF
        String pdfURL = "http://www.pdf995.com/samples/pdf.pdf";
        driver.get(pdfURL);

        try {
            // Открытие файла PDF
            PdfReader pdf = new PdfReader("http://www.pdf995.com/samples/pdf.pdf");
            // Извлечение текста из документа PDF
            // Нумерация страниц в PDF начинается с 1
            TextExtractionStrategy strategy = new SimpleTextExtractionStrategy();
            for (int i = 1; i <= pdf.getNumberOfPages(); ++i) {
                String text = PdfTextExtractor.getTextFromPage(pdf, i, strategy);
                logger.info(text);
            }
            // Закрытие файла PDF
            pdf.close();
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
