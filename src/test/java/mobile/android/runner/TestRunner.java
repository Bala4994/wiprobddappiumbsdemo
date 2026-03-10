package mobile.android.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/mobile/android/featureFiles",
        glue={"mobile.android.stepDefinitions",
        "com.test.mobile.android"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        },
        monochrome = true
)



public class TestRunner extends AbstractTestNGCucumberTests {

}