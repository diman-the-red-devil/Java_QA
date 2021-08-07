package tests.smartphones;

import org.junit.jupiter.api.Assertions;
import pages.SmartphoneProductPage;

public class SmartphoneProductPageAssert {
    SmartphoneProductPage page;

    public SmartphoneProductPageAssert(SmartphoneProductPage page) {
        this.page = page;
    }

    public void pageTitleEquals(String expected) {
        String actual = page.getPageTitle();
        Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}
