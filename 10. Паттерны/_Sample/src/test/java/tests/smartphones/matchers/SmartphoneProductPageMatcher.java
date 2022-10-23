package tests.smartphones.matchers;

import org.junit.jupiter.api.Assertions;
import pages.SmartphoneProductPagePF;

public class SmartphoneProductPageMatcher {
    // Страница "Продукт. Смартфон"
    SmartphoneProductPagePF page;

    // Конструктор
    public SmartphoneProductPageMatcher(SmartphoneProductPagePF page) {
        this.page = page;
    }

    // Проверка / Утверждение (Матчер)
    public void pageTitleEquals(String expected) {
        String actual = page.getPageTitle();
        Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}
