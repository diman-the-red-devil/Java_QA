package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import models.Smartphone;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.pages.SmartphonesPage;

import java.util.List;
import java.util.Map;

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

    // Шаг: Установлена сортировка "<Тип сортировки>"
    @Когда("Установлена сортировка {string}")
    public void orderBy(String type) {
        // Отображение сортировки
        smartphonesPage.accordeonSort().show();
        // Установка сортировки
        smartphonesPage.radiobuttonSort(type).setSelected(true);
        logger.info("Страница [Смартфоны]: Установлена сортировка \"" + type + "\"");
    }

    // Шаг: В фильтре "Производитель" выбрано значение "<Название компании>"
    @Когда("В фильтре \"Производитель\" выбрано значение {string}")
    public void filterByCompany(String company) {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Установка фильтра "Производитель"
        smartphonesPage.checkboxCompany(company).setChecked(true);
        logger.info("Страница [Смартфоны]: В фильтре \"Производитель\" выбрано значение \"" + company + "\"");
    }

    // Шаг: В фильтре "Объем оперативной памяти" выбрано значение "<Количество> Гб"
    @Когда("В фильтре \"Объем оперативной памяти\" выбрано значение \"{int} Гб\"")
    public void filterByRAM(int ram) {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Отображение фильтра "Объем оперативной памяти"
        smartphonesPage.accordeonRAM().show();
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 400);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.checkboxRAM(ram + " Гб").setChecked(true);
        logger.info("Страница [Смартфоны]: В фильтре \"Объем оперативной памяти\" выбрано значение \"" + ram + " Гб\"");
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

    // Проверка: Заголовок страницы "Смартфоны" содержит текст "<Текст>"
    @Тогда("Проверка: Заголовок страницы \"Смартфоны\" содержит текст {string}")
    public void assertPageTitle(String text) {
        Assertions.assertTrue(smartphonesPage.getPageTitle().contains(text),
                "Страница [Смартфоны]: Ошибка! Заголовок страницы \"Смартфоны\" не содержит текст \"" + text + "\"!");
        logger.info("Страница [Смартфоны]: Заголовок страницы \"Смартфоны\" содержит текст \"" + text + "\"");
    }

    // Шаг: Установлены фильтры из таблицы с одной колонкой
    @И("Установлены фильтры из таблицы с одной колонкой")
    public void setFiltersFromTable1(List<String> filters) {
        Smartphone smartphone = new Smartphone(
                new Ram(Integer.parseInt(filters.get(1).split(" ")[0])),
                new Company(filters.get(0)));

        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0,400);
        // Установка фильтра "Производитель"
        smartphonesPage.checkboxCompany(smartphone.getCompany().getCompany()).setChecked(true);
        logger.info("Страница [Смартфоны]: В фильтре \"Производитель\" выбрано значение \"" + smartphone.getCompany().getCompany() + "\"");

        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0,400);
        // Отображение фильтра "Объем оперативной памяти"
        smartphonesPage.accordeonRAM().show();
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0,400);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.checkboxRAM(smartphone.getRam().getRam() + " Гб").setChecked(true);
        logger.info("Страница [Смартфоны]: В фильтре \"Объем оперативной памяти\" выбрано значение \"" + smartphone.getRam().getRam() + " Гб\"");

        logger.info("***** Установлены фильтры из таблицы с одной колонкой");
    }

    // Шаг: Установлены фильтры из таблицы с двумя колонками
    @И("Установлены фильтры из таблицы с двумя колонками")
    public void setFiltersFromTable2(Map<String, String> filters) {
        Smartphone smartphone = new Smartphone(
                new Ram(Integer.parseInt(filters.get("Объем оперативной памяти").split(" ")[0])),
                new Company(filters.get("Производитель")));

        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0,400);
        // Установка фильтра "Производитель"
        smartphonesPage.checkboxCompany(smartphone.getCompany().getCompany()).setChecked(true);
        logger.info("Страница [Смартфоны]: В фильтре \"Производитель\" выбрано значение \"" + smartphone.getCompany().getCompany() + "\"");


        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0,400);
        // Отображение фильтра "Объем оперативной памяти"
        smartphonesPage.accordeonRAM().show();
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0,400);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.checkboxRAM(smartphone.getRam().getRam() + " Гб").setChecked(true);
        logger.info("Страница [Смартфоны]: В фильтре \"Объем оперативной памяти\" выбрано значение \"" + smartphone.getRam().getRam() + " Гб\"");

        logger.info("***** Установлены фильтры из таблицы с двумя колонками");
    }

    // Шаг: Установлена сортировка и фильтры из таблицы с тремя колонками
    @И("Установлена сортировка и фильтры из таблицы с тремя колонками")
    public void setFiltersAndSortFromTable3(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        String sortBy = table.get(0).get("Сортировка");
        String filterByCompany = table.get(0).get("Производитель");
        String filterByRam = table.get(0).get("Объем оперативной памяти");

        Smartphone smartphone = new Smartphone(
                new Ram(Integer.parseInt(filterByRam.split(" ")[0])),
                new Company(filterByCompany));

        // Отображение сортировки
        smartphonesPage.accordeonSort().show();
        // Установка сортировки
        smartphonesPage.radiobuttonSort(sortBy).setSelected(true);
        logger.info("Страница [Смартфоны]: Установлена сортировка \"" + sortBy + "\"");

        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0,400);
        // Установка фильтра "Производитель"
        smartphonesPage.checkboxCompany(smartphone.getCompany().getCompany()).setChecked(true);
        logger.info("Страница [Смартфоны]: В фильтре \"Производитель\" выбрано значение \"" + smartphone.getCompany().getCompany() + "\"");

        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0,400);
        // Отображение фильтра "Объем оперативной памяти"
        smartphonesPage.accordeonRAM().show();
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0,400);
        // Установка фильтра "Объем оперативной памяти"
        smartphonesPage.checkboxRAM(smartphone.getRam().getRam() + " Гб").setChecked(true);
        logger.info("Страница [Смартфоны]: В фильтре \"Объем оперативной памяти\" выбрано значение \"" + smartphone.getRam().getRam() + " Гб\"");

        logger.info("***** Установлена сортировка и фильтры из таблицы с тремя колонками");
    }
}
