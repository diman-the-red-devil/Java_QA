import io.cucumber.java.et.Ja;
import org.junit.jupiter.api.Test;
import web.helpers.JavaScriptHelper;
import web.helpers.WaitHelper;
import web.pages.SmartphonesPage;
import web.pages.StartPage;

public class SampleTest extends BaseTest2 {
    @Test
    // Проверка
    public void selectedProduct_Is_SamsungGalaxyNote20Ultra256GBWhite() {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");

        StartPage startPage = new StartPage(driver);
        startPage.linkYes().click();
        startPage.linkSmartsAndGadget().focusOnLink();
        startPage.linkSmarts().click();
        SmartphonesPage smartphonesPage = new SmartphonesPage(driver);
        smartphonesPage.mainBlock().hide();
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.checkBoxCompany("Samsung").setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);
        smartphonesPage.accordeonRAM().show();
        smartphonesPage.checkBoxRAM("8 Гб").setChecked(true);
        JavaScriptHelper.scrollBy(0,400);
        smartphonesPage.buttonApply().click();
        JavaScriptHelper.scrollBy(0,-400);
        smartphonesPage.accordeonSort().show();
        smartphonesPage.radioButtonSort("Сначала дорогие").setSelected(true);
        smartphonesPage.linkFirstProduct().click();
    }
}
