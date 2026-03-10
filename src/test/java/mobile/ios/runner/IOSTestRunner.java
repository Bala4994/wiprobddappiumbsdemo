package mobile.ios.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/mobile/ios/featureFiles",
        glue={"mobile.ios.stepDefinitions",
        "com.test.mobile.ios"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        },
        monochrome = true
)



public class IOSTestRunner extends AbstractTestNGCucumberTests {

}