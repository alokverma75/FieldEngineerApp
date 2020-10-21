package com.colt.fieldengineerapp.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SingleTaskDetailsPage extends TestBase {
	
	
	@AndroidFindBy(uiAutomator = "text(\"Order Number\")")
	AndroidElement orderNumberLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Customer\")")
	AndroidElement customerLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Coop Tech Email\")")
	AndroidElement coopTechEmailLabel;

	public AndroidElement getCoopTechEmailLabel() {
		return coopTechEmailLabel;
	}

	public AndroidElement getCustomerLabel() {
		return customerLabel;
	}

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_value")
	AndroidElement orderNumberTextField;
	
	public List<AndroidElement> getTextElementsByClassName(AndroidDriver<AndroidElement> driver, String elementText){
		
		return TestBase.getElementsByClassName(driver, elementText);
	}
	
	public List<AndroidElement> getTextElementsByResourceId(AndroidDriver<AndroidElement> driver, String elementText){
		
		return TestBase.getElementsById(driver, elementText);
	}
	
	


	public AndroidElement getOrderNumberTextField() {
		return orderNumberTextField;
	}

	public AndroidElement getOrderNumberLabel() {
		return orderNumberLabel;
	}

	public SingleTaskDetailsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}


}
