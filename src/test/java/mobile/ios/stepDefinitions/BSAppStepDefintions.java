package mobile.ios.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.mobile.ios.BaseTest;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.*;
import mobile.ios.pages.BSAppPage;

public class BSAppStepDefintions extends BaseTest {

    WebDriverWait wait;
    BSAppPage page;

    @Given("User try to find Text Button in Sample App")
    public void I_try_to_find_text_sample_app() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        page = new BSAppPage(driver);

        page.clickTextButton();
    }

    @When("User type in {string} in the Text Input field")
    public void I_type_hello_text_input_field(String email) {

        page.enterText(email);
    }

    @Then("User should get the entered text in the Text Output field")
    public void I_should_get_entered_text_in_text_output() {

        Assert.assertEquals(page.getOutputText(), "hello@browserstack.com");
    }

    @When("User click Web View tab")
    public void click_webview_tab() {
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
         page = new BSAppPage(driver);
        page.openWebView();

        try {
			handleCookiePopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Then("BrowserStack landing page should appear")
    public void verify_landing_page() {

        Assert.assertTrue(page.verifyLandingPage());
    }

    @When("User click Web Testing tab")
    public void click_web_testing() {

        page.clickWebTesting();
    }

    @Then("Live and Automate options should be visible")
    public void verify_web_testing_options() {

        Assert.assertTrue(page.verifyWebTestingOptions());
    }

    
  
    @Then("Search menu and more options buttons should be visible")
    public void verify_header_elements() {

        Assert.assertTrue(page.verifyHeader());
    }

    @When("User click Sign in from more options")
    public void verifyAndclick_signin() throws Exception{

        page.verifyAndclickSignIn();
    }

    @Then("Google sign in and Sign up options should appear")
    public void verify_login_options() {

        Assert.assertTrue(page.verifyLoginOptions());
    }
    
    public void handleCookiePopup() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement accept =
                    wait.until(ExpectedConditions.elementToBeClickable(
                            AppiumBy.xpath("//XCUIElementTypeButton[@name='close banner']")));

            accept.click();

            System.out.println("Cookie popup handled");

        } catch (Exception e) {

            System.out.println("Cookie popup not displayed");
        }
    }
    
    
    
	/*
	 * @When("I click App Testing tab") public void click_app_testing() throws
	 * InterruptedException { page.clickAppTesting(); Thread.sleep(3000); }
	 * 
	 * @Then("App Live and App Automate options should be visible") public void
	 * verify_app_testing_options() {
	 * 
	 * Assert.assertTrue(page.verifyAppTestingOptions()); }
	 * 
	 * @When("I click App Automate") public void click_app_automate() throws
	 * Exception {
	 * 
	 * page.clickAppAutomate();
	 * 
	 * Thread.sleep(3000); }
	 */
}