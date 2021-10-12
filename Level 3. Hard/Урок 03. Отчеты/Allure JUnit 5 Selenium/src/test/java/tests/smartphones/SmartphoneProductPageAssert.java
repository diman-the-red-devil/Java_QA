package tests.smartphones;

import org.junit.jupiter.api.Assertions;
import steps.SmartphoneProductPageSteps;

// Матчер с проверками страницы "Продукт. Смартфон"
public class SmartphoneProductPageAssert {
    // Шаги на странице "Продукт. Смартфон"
    SmartphoneProductPageSteps smartphoneProductPageSteps;

    // Конструктор
    public SmartphoneProductPageAssert(SmartphoneProductPageSteps smartphoneProductPageSteps) {
        this.smartphoneProductPageSteps = smartphoneProductPageSteps;
    }

    // Проверка / Утверждение (Матчер)
    public void pageTitleEquals(String expected) {
        String actual = smartphoneProductPageSteps.pageTitle();
        Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}
