package web;

import org.openqa.selenium.WebDriver;

public class Context {
    private static WebDriver _driver;

    public static void initContext(WebDriver driver) {
        _driver = driver;
    }

    public static WebDriver getDriver() {
        return _driver;
    }
}
