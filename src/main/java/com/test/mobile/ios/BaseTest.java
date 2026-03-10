package com.test.mobile.ios;

import java.net.URL;

import org.openqa.selenium.MutableCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;



public class BaseTest {

	public static IOSDriver driver;

	public void initializeiOSDriver() throws Exception {

		MutableCapabilities capabilities = new XCUITestOptions();
		
		driver = new IOSDriver(
				new URL("http://hub.browserstack.com/wd/hub"),
				capabilities);

		System.out.println("iOS Driver Started");
	}

	public void quitDriver() {

		if(driver != null) {
			driver.quit();
		}

		System.out.println("Driver Closed");
	}
}