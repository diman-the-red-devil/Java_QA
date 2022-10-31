package tests.smartphones.matchers;

import org.junit.jupiter.api.Assertions;
import pages.SmartphoneProductPagePFPE;
import steps.SmartphoneProductPageSteps;

public class SmartphoneProductPageMatcherFC {
    // Шаги на странице "Продукт. Смартфон"
    SmartphoneProductPageSteps smartphoneProductPageSteps;

    // Конструктор
    public SmartphoneProductPageMatcherFC(SmartphoneProductPageSteps smartphoneProductPageSteps) {
        this.smartphoneProductPageSteps = smartphoneProductPageSteps;
    }

    // Проверка / Утверждение (Матчер)
    public void pageTitleEquals(String expected) {
        String actual = smartphoneProductPageSteps.getPageTitle();
        Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}
