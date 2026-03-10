package mobile.ios.pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

public class BSAppPage {

    IOSDriver driver;

    public BSAppPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // -------- TEXT INPUT FLOW --------

    @iOSXCUITFindBy(accessibility = "Text Button")
    WebElement textButton;

    @iOSXCUITFindBy(accessibility = "Text Input")
    WebElement textInput;

    @iOSXCUITFindBy(accessibility = "Text Output")
    WebElement textOutput;

    // -------- WEBVIEW BUTTON --------

    @iOSXCUITFindBy(accessibility = "Web View")
    WebElement webViewBtn;
    
    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='close banner']")
    WebElement closeBtn;

    // -------- LANDING PAGE --------

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='BrowserStack Logo'])[1]")
    WebElement browserStackLogo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Get started free']")
    WebElement getStartedFree;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Talk to us'])[1]")
    WebElement talkToUs;

    // -------- WEB TESTING --------

    @iOSXCUITFindBy(accessibility = "Web Testing - Test websites or web apps on real browsers")
    WebElement webTestingTab;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Live'])[1]")
    WebElement liveText;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Automate'])[1]")
    WebElement automateText;

    // -------- APP TESTING --------

    @iOSXCUITFindBy(accessibility = "App Testing - Test iOS & Android apps on real devices")
    WebElement appTestingTab;
    
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeOther[@name='Test your websites and mobile apps'])[2]//XCUIElementTypeButton)[3]")
    WebElement appTestingTab1;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='App Live'])[1]")
    WebElement appLive;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='App Automate'])[1]")
    WebElement appAutomate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Automated mobile app testing on real devices']")
    WebElement automatePageText;

    // -------- HEADER --------

    @iOSXCUITFindBy(accessibility = "Search")
    WebElement searchIcon;

    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name='Menu Toggle']")
    WebElement menuToggle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign in']")
    WebElement signIn;

    // -------- LOGIN --------

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign in with Google']")
    WebElement signInGoogle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign up']")
    WebElement signUp;

    // -------- ACTION METHODS --------

    public void clickTextButton() {
        textButton.click();
    }

    public void enterText(String email) {
        textInput.sendKeys(email + "\n");
    }

    public String getOutputText() {
        return textOutput.getText();
    }

    public void openWebView() {
        webViewBtn.click();
    }

    public boolean verifyLandingPage() {
        return browserStackLogo.isDisplayed()
                && getStartedFree.isDisplayed()
                && talkToUs.isDisplayed();
    }

    public void clickWebTesting() {
        webTestingTab.click();
    }

    public boolean verifyWebTestingOptions() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.visibilityOf(liveText));
        return liveText.isDisplayed() && automateText.isDisplayed();
    }

    public void clickAppTesting() {
    	for (int i = 0; i < 3; i++) {

        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            WebElement element = wait.until(
                    ExpectedConditions.elementToBeClickable(appTestingTab));

            element.click();

        } catch (Exception e) {

        	appTestingTab1.click();
        }
    	}
    }

    public boolean verifyAppTestingOptions() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    	wait.until(ExpectedConditions.visibilityOf(appLive));
        return appLive.isDisplayed() && appAutomate.isDisplayed();
    }

    public void clickAppAutomate() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {

            WebElement element = wait.until(
                    ExpectedConditions.elementToBeClickable(appAutomate));

            element.click();

        } catch (Exception e) {
        	
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", appAutomate);
        }
    }

    public boolean verifyAutomatePage() {
    	
        return automatePageText.isDisplayed();
    }

    public boolean verifyHeader() {
        return searchIcon.isDisplayed()
                && menuToggle.isDisplayed();
                
    }

    public void verifyAndclickSignIn() throws InterruptedException {
    	//scrollToElement(menuToggle);
    	menuToggle.click();
    	//clickBasedOncorrdinates(360, 76);
    	Thread.sleep(1000);
        signIn.click();
    }

    public boolean verifyLoginOptions() {
        return signInGoogle.isDisplayed() && signUp.isDisplayed();
    }
    
    
    public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: scroll",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "direction", "up", "percent", 3.0));
	}
	
    public void clickBasedOncorrdinates(int x, int y) throws InterruptedException {
		Thread.sleep(5000);
		 TouchAction clickCord = new TouchAction(driver);
		clickCord.tap(PointOption.point(x, y)).perform();
		System.out.println("click performed using coordinates"+x +" "+y);
		
	}
    
}