package mobile.android.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WikipediaPage {

    AndroidDriver driver;

    public WikipediaPage(AndroidDriver driver) {

        this.driver = driver;

        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(20)),
                this);
    }

    // LOCATORS

    @AndroidFindBy(accessibility = "Search Wikipedia")
    private WebElement searchIcon;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/search_src_text")
    private WebElement searchBox;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/page_list_item_title")
    private List<WebElement> searchResults;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/view_page_title")
    private WebElement articleTitle;
    
    @AndroidFindBy(id="org.wikipedia.alpha:id/view_wiki_error_text")
    private WebElement errorPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"More options\"]")
    private WebElement moreOptions;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/explore_overflow_settings")
    private WebElement settingsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='General']")
    private WebElement generalSettings;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/explore_overflow_account_name")
    private WebElement loginOption;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/login_create_account_link")
    private WebElement signUpButton;

    // ACTION METHODS

    public void tapSearch() {
        searchIcon.click();
    }
    
    public boolean searchWikipediaPageDisplayed() {
    	return searchIcon.isDisplayed();
    }
    public void enterSearchKeyword(String keyword) {
        searchBox.sendKeys(keyword);
    }

    public boolean searchResultsDisplayed() {
        return searchResults.size() > 0;
    }

    public void selectFirstResult() {
        searchResults.get(0).click();
    }

    public boolean articlePageOpened() {
        return articleTitle.isDisplayed();
    }
    
    public boolean errorPageOpened() {
        return errorPage.isDisplayed();
    }


    public String getArticleTitle() {
        return articleTitle.getText();
    }

    public void clickMoreOptions() {
        moreOptions.click();
    }

    public boolean settingsDisplayed() {
        return settingsButton.isDisplayed();
    }

    public void clickSettings() {
        settingsButton.click();
    }

    public boolean generalSettingsVisible() {
        return generalSettings.isDisplayed();
    }

    public boolean loginDisplayed() {
        return loginOption.isDisplayed();
    }

    public void clickLogin() {
        loginOption.click();
    }

    public boolean signupDisplayed() {
        return signUpButton.isDisplayed();
    }
}