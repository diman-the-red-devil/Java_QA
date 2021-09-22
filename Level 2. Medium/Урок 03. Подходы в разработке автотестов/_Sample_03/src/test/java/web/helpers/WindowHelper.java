package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WindowType;
import web.Context;

//
public class WindowHelper {
    // Логгер
    private Logger logger = LogManager.getLogger(NavigationHelper.class);

    public static void newWindow() {
        Context.getDriver().switchTo().newWindow(WindowType.TAB);
    }

    public static void () {
        Context.getDriver().manage().window().maximize();
    }


}
