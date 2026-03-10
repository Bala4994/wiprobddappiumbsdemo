package com.test.mobile.android;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.*;

public class Hooks extends BaseTest {

	@Before
	public void setup() throws Exception {

		initializeAndroidDriver();
	}

	@After
	public void tearDown() {

		quitDriver();
	}
	
	@AfterStep
    public void addScreenshot(Scenario scenario) {
		
		if(driver == null) return;
		
        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot, "image/png", "stepScreenshot");
    }
	
	

}