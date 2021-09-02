package exps.tests;

import exps.pages.HomePage;
import org.junit.jupiter.api.Assertions;

public class HomePageAssert {
    private HomePage homePage;

    public HomePageAssert(HomePage homePage) {
        this.homePage = homePage;
    }

    // Проверка отображения текста после входа с логином и паролем
    public void displayedTextAfterLogin() {
        Assertions.assertTrue(homePage.isTextDisplyed());
    }

    // Проверка текста после входа с логином и паролем
    public void textAfterLoginIs(String expected) {
        Assertions.assertEquals(expected, homePage.getText(),
                "Ошибка! Текст на странице не соответствует ожидаемому");
    }
}