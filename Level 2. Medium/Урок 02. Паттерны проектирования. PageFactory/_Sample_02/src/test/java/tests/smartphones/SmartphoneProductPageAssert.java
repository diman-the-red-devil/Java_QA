package tests.smartphones;

import org.junit.jupiter.api.Assertions;
import pages.SmartphoneProductPage;

// Матчер с проверками страницы "Продукт. Смартфон"
public class SmartphoneProductPageAssert {
    // Страница "Продукт. Смартфон"
    SmartphoneProductPage page;

    // Конструктор
    public SmartphoneProductPageAssert(SmartphoneProductPage page) {
        this.page = page;
    }

    // Проверка / Утверждение (Матчер)
    public void pageTitleEquals(String expected) {
        String actual = page.getPageTitle();
        Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}
