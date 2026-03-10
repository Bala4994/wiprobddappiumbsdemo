package com.test.mobile.android;

import java.net.URL;

import org.openqa.selenium.MutableCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

	public static AndroidDriver driver;

	public void initializeAndroidDriver() throws Exception {

		MutableCapabilities capabilities = new UiAutomator2Options();

		driver = new AndroidDriver(
				new URL("http://hub.browserstack.com/wd/hub"),
				capabilities);

		System.out.println("Android Driver Started");
	}

	public void quitDriver() {

		if(driver != null) {
			driver.quit();
		}

		System.out.println("Driver Closed");
	}
}