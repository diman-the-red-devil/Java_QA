package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.Context;

//
public class NavigationHelper {
    // Логгер
    private Logger logger = LogManager.getLogger(NavigationHelper.class);

    public static void navigateTo(String URL) {
        Context.getDriver().navigate().to(URL);
    }

    public static void back() {
        Context.getDriver().navigate().back();
    }

    public static void forward() {
        Context.getDriver().navigate().forward();
    }

    public static void refresh() {
        Context.getDriver().navigate().refresh();
    }
}
