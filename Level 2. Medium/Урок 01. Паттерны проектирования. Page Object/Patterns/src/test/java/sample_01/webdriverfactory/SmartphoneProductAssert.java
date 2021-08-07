package sample_01.webdriverfactory;

import org.junit.jupiter.api.Assertions;
import sample_01.pages.SmartphoneProductPage;

public class SmartphoneProductAssert {
    SmartphoneProductPage page;

    public SmartphoneProductAssert(SmartphoneProductPage page) {
        this.page = page;
    }

    public void pageTitleEquals(String expected) {
        String actual = page.getPageTitle();
        Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}
