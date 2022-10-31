package steps;

import helpers.JavaScriptHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.SmartphonesPagePFPE;

public class SmartphonesPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(SmartphonesPageSteps.class);

    // Ссылка на объект класса SmartphonesPagePFPE
    // Страница "Смартфоны"
    private SmartphonesPagePFPE smartphonesPage;

    // Конструктор
    public SmartphonesPageSteps(WebDriver driver) {
        // ***** Страница "Смартфоны" *****
        smartphonesPage = new SmartphonesPagePFPE(driver);
        logger.info("Открыта страница [Смартфоны]");
    }

    // Установка сортировки
    public void orderBy(String type) {
        // Отображение сортировки
        smartphonesPage.accordeonSort().show();
        // Установка сортировки
        smartphonesPage.radiobuttonSort(type).setSelected(true);
        logger.info("Страница [Смартфоны]: Установка сортировки <" + type + ">");
    }

    // Установка фильтра "Производитель"
    public void filterByCompany(String company) {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Установка фильтра "Производитель"
        smartphonesPage.checkboxCompany(company).setChecked(true);
        logger.info("Страница [Смартфоны]: Установка фильтра \"Производитель\" - <" + company + ">");
    }

    // Установка фильтра "Объем оперативной памяти"
    public void filterByRAM(int ram) {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Отображение фильтра "Объем оперативной памяти"
        smartphonesPage.accordeonRAM().show();
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.checkboxRAM(ram + " Гб").setChecked(true);
        logger.info("Страница [Смартфоны]: Установка фильтра \"Объем оперативной памяти\" - <" + ram + " Гб>");
    }

    // Применение фильтров
    public void applyFilters() {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Нажатие на кнопку "Применить"
        smartphonesPage.buttonApply().click();
        logger.info("Страница [Смартфоны]: Применение фильтров");
    }

    // Нажатие на ссылку первого продукта в списке
    public void goToFirstProduct() {
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, -2000);
        // Нажатие на ссылку первого продукта в списке
        smartphonesPage.linkFirstProduct().openInNewWindow();
        logger.info("Страница [Смартфоны]: Переход на страницу первого продукта в списке");
    }
}
