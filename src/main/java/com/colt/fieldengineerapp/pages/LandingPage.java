package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage extends TestBase {
	
	
	
	
	@AndroidFindBy(uiAutomator = "text(\"Continue\")")
	//@AndroidFindBy(id = "com.colt.coltengineering:id/btn_continue")
	AndroidElement continueBtn;
	
	//@AndroidFindBy(uiAutomator = ELEMENT_AUTHENTICATION_LABEL)
	@AndroidFindBy(uiAutomator = "text(\"Choose Authentication Type\")")
	AndroidElement landingPageTitle;
	
	
	public LandingPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
		
	}


	public AndroidElement getContinueBtn() {
		return continueBtn;
	}


	public AndroidElement getLandingPageTitle() {
		return landingPageTitle;
	}
	
	
	

}
