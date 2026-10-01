package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions (
            features = "@target/failed-scenarios.txt",
            glue = {"stepdefinitions", "hooks"},
            plugin = {
                    "pretty",
                    "html:target/failed-rerun-report.html"
            }
    )

public class FailedTestRunner extends AbstractTestNGCucumberTests {
}
