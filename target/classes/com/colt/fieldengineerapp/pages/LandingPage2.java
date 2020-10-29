package com.colt.fieldengineerapp.pages;

import java.io.IOException;
import java.net.MalformedURLException;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidElement;

public class LandingPage2 extends TestBase {
	
	
	
	
	public LandingPage2() throws MalformedURLException, IOException{
		//initialization();
	}
	
	public AndroidElement getContinueBtn() {
		return TestBase.getElementByAutomator(driver, BUTTON_CONTINUE);
	}
	
	public String validateHomePageTitle(){
		return TestBase.getElementByAutomator(driver,ELEMENT_HOMEPAGE_LABEL).getText();
	}
	
	public String validateHomePageTasksTitle(){
		return TestBase.getElementByAutomator(driver, ELEMENT_HOMEPAGE_TASKS_LABEL).getText();
	}
	
	
	

}
