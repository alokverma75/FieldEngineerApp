package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	LandingPage landingPage;
	AndroidDriver<AndroidElement> driver;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException, IOException{
		driver = getDriver();
		loginPage = new LoginPage(driver);	
		//landingPage = new LandingPage1(driver);
	}
	
	@Test(priority=1)
	public void landingPageTitleTest() throws MalformedURLException, IOException{
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		String title = landingPage.getLandingPageTitle().getText();
		Assert.assertEquals(title, "Choose Authentication Type");
	}
	

	
	@Test(priority=0)
	public void loginTest() throws MalformedURLException, IOException{
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		
		Assert.assertNotNull(landingPage);
	}
	
	
	
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}

}
