package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OpenDrawerPage extends TestBase {
	
	public OpenDrawerPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}	
	
	
	//@AndroidFindBy(uiAutomator = "text(\"Welcome\")")
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_welcome")	
	private AndroidElement welcomeLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_username")
	private AndroidElement userNameLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_maintainence")
	private AndroidElement settingsPageButton;


	public AndroidElement getWelcomeLabel() {
		return welcomeLabel;
	}

	public AndroidElement getUserNameLabel() {
		return userNameLabel;
	}

	public AndroidElement getSettingsPageButton() {
		return settingsPageButton;
	}

	

}
