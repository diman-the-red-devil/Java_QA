package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.pages.SmartphonesPage;

// Шаги и проверки на странице "Смартфоны"
public class SmartphonesPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(SmartphonesPageSteps.class);

    // Ссылка на объект класса SmartphonesPage
    // Страница "Смартфоны"
    private SmartphonesPage smartphonesPage;

    // Шаг: Открыта страница "Смартфоны"
    @Дано("Открыта страница \"Смартфоны\"")
    public void openSmartphonesPage() {
        smartphonesPage = new SmartphonesPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Смартфоны]: Открыта страница \"Смартфоны\"");
    }

    // Шаг: Установлена сортировка "Сначала дорогие"
    @Когда("Установлена сортировка \"Сначала дорогие\"")
    public void orderBy() {
        // Отображение сортировки
        smartphonesPage.accordeonSort().show();
        // Установка сортировки
        smartphonesPage.radiobuttonSort("Сначала дорогие").setSelected(true);
        logger.info("Страница [Смартфоны]: Установлена сортировка \"Сначала дорогие\"");
    }

    // Шаг: В фильтре "Производитель" выбрано значение "Samsung"
    @Когда("В фильтре \"Производитель\" выбрано значение \"Samsung\"")
    public void filterByCompany() {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Установка фильтра "Производитель"
        smartphonesPage.checkboxCompany("Samsung").setChecked(true);
        logger.info("Страница [Смартфоны]: В фильтре \"Производитель\" выбрано значение \"Samsung\"");
    }

    // Шаг: В фильтре "Объем оперативной памяти" выбрано значение "8 Гб"
    @Когда("В фильтре \"Объем оперативной памяти\" выбрано значение \"8 Гб\"")
    public void filterByRAM() {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Отображение фильтра "Объем оперативной памяти"
        smartphonesPage.accordeonRAM().show();
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.checkboxRAM("8 Гб").setChecked(true);
        logger.info("Страница [Смартфоны]: В фильтре \"Объем оперативной памяти\" выбрано значение \"8 Гб\"");
    }

    // Шаг: Применены фильтры
    @Когда("Применены фильтры")
    public void applyFilters() {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Нажатие на кнопку "Применить"
        smartphonesPage.buttonApply().click();
        logger.info("Страница [Смартфоны]: Применены фильтры");
    }

    // Шаг: Выполнен переход на страницу первого продукта в списке
    @Когда("Выполнен переход на страницу первого продукта в списке")
    public void goToFirstProduct() {
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, -2000);
        // Нажатие на ссылку первого продукта в списке
        smartphonesPage.linkFirstProduct().openInNewWindow();
        logger.info("Страница [Смартфоны]: Выполнен переход на страницу первого продукта в списке");
    }

    // Проверка: Заголовок страницы "Смартфоны" содержит текст "Смартфоны"
    @Тогда("Проверка: Заголовок страницы \"Смартфоны\" содержит текст \"Смартфоны\"")
    public void assertPageTitle() {
        Assertions.assertTrue(smartphonesPage.getPageTitle().contains("Смартфоны"),
                "Страница [Смартфоны]: Ошибка! Заголовок страницы \"Смартфоны\" не содержит текст \"Смартфоны\"!");
        logger.info("Страница [Смартфоны]: Заголовок страницы \"Смартфоны\" содержит текст \"Смартфоны\"");
    }
}
