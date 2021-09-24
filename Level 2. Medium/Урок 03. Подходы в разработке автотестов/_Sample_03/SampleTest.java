package web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import web.BaseTest;
import web.helpers.JavaScriptHelper;
import web.pages.SmartphoneProductPage;
import web.pages.SmartphonesPage;
import web.pages.StartPage;

public class SampleTest extends BaseTest {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphoneProductPage.class);

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
        SmartphoneProductPage smartphoneProductPage = new SmartphoneProductPage(driver);
        smartphoneProductPage.linkCharacteristics().click();
        logger.info(smartphoneProductPage.tableCharacteristics().getDataValue("Объем оперативной памяти"));
    }
}
