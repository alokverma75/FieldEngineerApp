package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage2;


public class LoginPageTest2 extends TestBase {
	
	LoginPage2 loginPage;
	LandingPage landingPage;
	
	public LoginPageTest2(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException, IOException{
		//initialization();
		loginPage = new LoginPage2();	
	}
	
//	@Test(priority=1)
//	public void loginPageTitleTest(){
//		String title = loginPage.validateLoginPageTitle();
//		Assert.assertEquals(title, "Choose Authentication Type");
//	}
	
//	@Test(priority=2)
//	public void crmLogoImageTest(){
//		boolean flag = loginPage.validateCRMImage();
//		Assert.assertTrue(flag);
//	}
	
	@Test(priority=0)
	public void loginTest() throws MalformedURLException, IOException{
		landingPage = loginPage.login(prop.getProperty("userID"), prop.getProperty("password"));
		String title = loginPage.validateLandingPageTitle();
		Assert.assertEquals(title, "Choose Authentication Type");
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
