package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends TestBase {
	
	
	@AndroidFindBy(uiAutomator = "text(\"Tasks\")")
	AndroidElement homePageTasksTitle;
	
	@AndroidFindBy(uiAutomator = "text(\"Field Experts\")")
	AndroidElement homePageTitle;
	
	public HomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	public boolean validateHomePageTasksTitle(String element){
		return homePageTasksTitle.getText().equals(element);
	}
	
	public boolean validateHomePageTitle(String element){
		return homePageTitle.getText().equals(element);
	}

}
