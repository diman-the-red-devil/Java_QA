import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME;

/*
// @Suite
// Набор тестов
@Suite
// @IncludeEngines
// Тестовый движок
@IncludeEngines("cucumber")
// @SelectClasspathResource
// Папка с BDD сценариями на Gherkin
@SelectClasspathResource("features")
// @ConfigurationParameter
// Опции для запуска сценариев
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps, hooks")
@ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
 */
public class RunCucumberTest {
}
