package api.runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import api.listener.ApiListener;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"api/steps"},
        //snippets = SnippetType.CAMELCASE,
        plugin = {
                "json:target/jsonReport/CucumberTestReport.json",
                "rerun:target/rerun/failed_scenarios.txt",
        })
@Listeners(ApiListener.class)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
