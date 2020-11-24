package com.colt.fieldengineerapp.pages;

import java.util.List;

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

	@AndroidFindBy(id = "com.colt.coltengineering:id/design_menu_item_text")
	private List<AndroidElement> allDrawerButtons;

	public List<AndroidElement> getAllDrawerButtons() {
		return allDrawerButtons;
	}

	public AndroidElement getWelcomeLabel() {
		return welcomeLabel;
	}

	public AndroidElement getUserNameLabel() {
		return userNameLabel;
	}

	

}
