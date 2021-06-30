import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;


public class HttpCaptureTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(HttpCaptureTest.class);
    private static BrowserMobProxyServer proxy;
    private static Proxy seleniumProxy;

    @BeforeEach
    public void setUp() {
        proxy = new BrowserMobProxyServer();
        proxy.setTrustAllServers(true);
        proxy.setHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxy.start(8080);

        seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        try {
            String hostIp = Inet4Address.getLocalHost().getHostAddress();
            seleniumProxy.setHttpProxy(hostIp + ":" + proxy.getPort());
            seleniumProxy.setSslProxy(hostIp + ":" + proxy.getPort());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        WebDriverManager.chromedriver().setup();
        logger.info("Драйвер для браузера Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(capabilities);
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--allow-insecure-localhost");
        chromeOptions.addArguments("--ignore-urlfetcher-cert-requests");
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void httpCaptureTest() {
        proxy.newHar("dns-shop.ru");
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
        // Нажать на ссылку "Да"
        By linkYesXPath = By.xpath("//a[text()=\"Да\"]");
        WebElement linkYes = driver.findElement(linkYesXPath);
        linkYes.click();
        logger.info("Нажата ссылка \"Да\"");

        Har har = proxy.getHar();
        File harFile = new File("dns-shop.har");
        try {
            har.writeTo(harFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<HarEntry> entries = proxy.getHar().getLog().getEntries();
        for (HarEntry entry : entries) {
            logger.info("URL " + entry.getRequest().getUrl());
            logger.info("Response Code " + entry.getResponse().getStatus());
        }
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            proxy.stop();
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
