package tests.smartphones.matchers;

import org.junit.jupiter.api.Assertions;
import pages.SmartphoneProductPagePFPE;

public class SmartphoneProductPageMatcherPFPE {
    // Страница "Продукт. Смартфон"
    SmartphoneProductPagePFPE page;

    // Конструктор
    public SmartphoneProductPageMatcherPFPE(SmartphoneProductPagePFPE page) {
        this.page = page;
    }

    // Проверка / Утверждение (Матчер)
    public void pageTitleEquals(String expected) {
        String actual = page.getPageTitle();
        Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}
