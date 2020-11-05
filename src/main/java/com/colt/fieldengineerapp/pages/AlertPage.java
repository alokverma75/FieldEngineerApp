package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AlertPage extends TestBase {
	
	public AlertPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"Enter COLT Usern ID or Email Id\")") 
	private AndroidElement assignTaskAlertWindowTitle;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_username")
	private AndroidElement userNameTextField;

	@AndroidFindBy(uiAutomator = "text(\"Submit\")") 
	private AndroidElement submitButton;

	@AndroidFindBy(uiAutomator = "text(\"Cancel\")") 
	private AndroidElement cancelButton;

	public AndroidElement getAssignTaskAlertWindowTitle() {
		return assignTaskAlertWindowTitle;
	}

	public AndroidElement getUserNameTextField() {
		return userNameTextField;
	}

	public AndroidElement getSubmitButton() {
		return submitButton;
	}

	public AndroidElement getCancelButton() {
		return cancelButton;
	}

	
	
}
