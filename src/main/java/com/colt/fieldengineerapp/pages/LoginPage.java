package com.colt.fieldengineerapp.pages;

import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends TestBase {
	
	

	//@AndroidFindBy(id = "com.colt.coltengineering:id/et_username")
	@AndroidFindBy(uiAutomator = "text(\"User ID\")")
	private AndroidElement userId;
	
	//@AndroidFindBy(id = "com.colt.coltengineering:id/et_new_password")
	@AndroidFindBy(uiAutomator = "text(\"Password\")")
	private AndroidElement password;
	
	//@AndroidFindBy(id = "com.colt.coltengineering:id/btn_login")
	@AndroidFindBy(uiAutomator = "text(\"Login\")")
	private AndroidElement loginBtn;
	
	//@AndroidFindBy(id = "com.colt.coltengineering:id/tv_sign_up")
	@AndroidFindBy(uiAutomator = "text(\"Don't have an account? Sign up\")")
	AndroidElement signupBtn;
	
	//@AndroidFindBy(id="com.colt.coltengineering:id/cbRememberMe")
	@AndroidFindBy(uiAutomator = "text(\"Remember me\")")
	private AndroidElement checkboxRememberMe;
	
	public LoginPage(AppiumDriver<?> driver) {
		PageFactory.initElements( new AppiumFieldDecorator(driver, getDuration(30)) , this);
	}
	
	public LandingPage login(AppiumDriver<?> driver, String un, String pwd) throws MalformedURLException, IOException{
		userId.sendKeys(un);
		password.sendKeys(pwd);
		checkboxRememberMe.click();
		loginBtn.click();

		return new LandingPage(driver);
	}
	
	

}
