import org.junit.jupiter.api.Test;
import web.pages.StartPage;
import web.pages.TestPage;

public class SampleTest extends BaseTest2 {
    @Test
    // Проверка
    public void selectedProduct_Is_SamsungGalaxyNote20Ultra256GBWhite() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");

        TestPage testPage = new TestPage(driver);
        testPage.linkYes().click();
        testPage.linkSmartsAndGadget().click();
    }
}
