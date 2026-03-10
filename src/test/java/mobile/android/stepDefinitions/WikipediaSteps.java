package mobile.android.stepDefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.mobile.android.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mobile.android.pages.WikipediaPage;

public class WikipediaSteps extends BaseTest{
	
	WikipediaPage wikipediaPage;

    @Given("user launches Wikipedia application")
    public void user_launches_application() throws Exception {    	
        wikipediaPage = new WikipediaPage(driver);
        System.out.println("Wikipedia App launched");
        Thread.sleep(5000);
    }

    @Given("user taps on Search Wikipedia")
    public void user_taps_search() {
        wikipediaPage.tapSearch();
    }

    @When("user enters search keyword {string}")
    public void user_enters_search_keyword(String keyword) {
        wikipediaPage.enterSearchKeyword(keyword);
    }

    @Then("search results should appear")
    public void search_results_should_appear() {
        Assert.assertTrue(wikipediaPage.searchResultsDisplayed());
    }

    @When("user selects first search result")
    public void user_selects_first_result() {
        wikipediaPage.selectFirstResult();
    }

    @Then("error page should open")
    public void error_page_should_open() {
        Assert.assertTrue(wikipediaPage.errorPageOpened());
    }

    @When("user navigates back") 
    public void user_navigates_back() {
    driver.navigate().back(); 
    } 
    
    @Then("Home page should be displayed") 
    public void search_results_page_displayed() {     	 
    	Assert.assertTrue(wikipediaPage.searchWikipediaPageDisplayed()); 
    	}

    @When("user selects more options")
    public void user_selects_more_options() {
    	wikipediaPage = new WikipediaPage(driver);
        wikipediaPage.clickMoreOptions();
    }

    @Then("settings button should be displayed")
    public void settings_button_should_be_displayed() {
        Assert.assertTrue(wikipediaPage.settingsDisplayed());
    }

    @When("User clicks on settings button")
    public void user_clicks_settings() {
        wikipediaPage.clickSettings();
    }

    @Then("General settings screen should be visible")
    public void general_settings_screen_should_be_visible() {
        Assert.assertTrue(wikipediaPage.generalSettingsVisible());
        driver.navigate().back(); 
    }

    @When("user clicks on more options")
    public void user_clicks_on_more_options() {
    	wikipediaPage = new WikipediaPage(driver);
        wikipediaPage.clickMoreOptions();
    }

    @Then("Login to wikipedia should be displayed")
    public void login_to_wikipedia_should_be_displayed() {
        Assert.assertTrue(wikipediaPage.loginDisplayed());
    }

    @When("user clicks on Login to wikipedia")
    public void user_clicks_on_login() {
        wikipediaPage.clickLogin();
    }

    @Then("Sign up button should be displayed")
    public void signup_button_should_be_displayed() {
        Assert.assertTrue(wikipediaPage.signupDisplayed());
    }
    
}