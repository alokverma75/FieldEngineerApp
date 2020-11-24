package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LogoutPage extends TestBase {
	
	public LogoutPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}	
	
	
	@AndroidFindBy(uiAutomator = "text(\"Confirm\")")
	private AndroidElement confirmLabel;
	
	@AndroidFindBy(id = "android:id/message")
	private AndroidElement messgageLabel;

	public AndroidElement getConfirmLabel() {
		return confirmLabel;
	}

	public AndroidElement getMessgageLabel() {
		return messgageLabel;
	}

	

	

}
