import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// @RunWith
// Указание класса для запуска тестов
@RunWith(Cucumber.class)
// @CucumberOptions
// Указание опции для запуска BDD тестов Cucumber/Gherkin
@CucumberOptions(
        // Список папок с feature файлами - фичи/сценарии
        features = {"src/test/resources/features"},
        // Спиcок пакетов с steps файлами - шаги
        glue = {"steps"}
        // Список тегов - фильтр запускаемых тестов
        // tags = {},
        // Плагин для Формирования отчета Allure
        // plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm", "progress", "summary"}
)
public class RunCucumberTest {
}
