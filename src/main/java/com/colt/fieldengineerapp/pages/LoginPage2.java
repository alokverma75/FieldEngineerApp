package com.colt.fieldengineerapp.pages;

import java.io.IOException;
import java.net.MalformedURLException;

//import org.openqa.selenium.JavascriptExecutor;

//import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;


import io.appium.java_client.android.AndroidElement;

public class LoginPage2 extends TestBase {
	
	
	 private AndroidElement username;
	 private AndroidElement password;		
	 private AndroidElement loginBtn;	
	 private AndroidElement signUpBtn;
	 private AndroidElement rememberMeChkBox;
	
	
	 public AndroidElement getUsername() {
		return TestBase.getElementByAutomator(driver, ELEMENT_ATTRIBUTE_TEXT, ELEMENT_USER_ID);
	}

	public AndroidElement getPassword() {
		return TestBase.getElementByAutomator(driver, ELEMENT_ATTRIBUTE_TEXT, ELEMENT_PASSWORD);
	}

	public AndroidElement getLoginBtn() {
		return TestBase.getElementByAutomator(driver, ELEMENT_ATTRIBUTE_TEXT, BUTTON_LOGIN);
	}

	public AndroidElement getSignUpBtn() {
		return TestBase.getElementByAutomator(driver, ELEMENT_ATTRIBUTE_TEXT,BUTTON_SIGNUP);
	}
	
	public AndroidElement getRememberMeChkBox() {
		return TestBase.getElementByAutomator(driver, ELEMENT_ATTRIBUTE_TEXT, ELEMENT_CHECKBOX_REMEMBER);
	}	
	
	
	public LoginPage2() throws MalformedURLException, IOException {
		//PageFactory.initElements(TestBase.getDriver(), this);
		TestBase.initialization();
		
	}
	
	public LandingPage2 login(String un, String pwd) throws MalformedURLException, IOException{
		this.getUsername().sendKeys(un);
		this.getPassword().sendKeys(pwd);
		this.getRememberMeChkBox().click();
		this.getLoginBtn().click();

		return new LandingPage2();
	}
	
	public String validateLandingPageTitle(){
		return TestBase.getElementByAutomator(driver, ELEMENT_ATTRIBUTE_TEXT, ELEMENT_AUTHENTICATION_LABEL).getText();
	}
	


}
