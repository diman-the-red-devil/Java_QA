package tests;

import org.junit.jupiter.api.Test;
import pageobjects.SmartphonesPage;
import pageobjects.StartPage;

public class SmartphonesTest extends BaseTest {

    @Test
    public void selectSamsung() {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.linkSmartsAndGadgetsMove();
        startPage.linkSmartsClick();
        SmartphonesPage smartphonesPage = new SmartphonesPage(driver);
        smartphonesPage.showSortClick();
        smartphonesPage.rbtnExpensiveClick();
        smartphonesPage.chbxSamsungClick();
        smartphonesPage.showRAMClick();
        smartphonesPage.chbxRAM8GbClick();
        smartphonesPage.linkProductClick();
    }
}
