package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TemplatesPage extends TestBase {
	
	public TemplatesPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}	
	
	@AndroidFindBy(uiAutomator = "text(\"\")")
	private AndroidElement templatesLabelBtn;
	
	@AndroidFindBy(uiAutomator = "text(\"View Templates\")")
	private AndroidElement viewTemplatesLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_total_value")
	private AndroidElement totalTemplatesValueTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Total Templates\")")
	private AndroidElement totalTemplatesLabel;

	
	
	
	
	
	

}
