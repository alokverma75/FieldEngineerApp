package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;

public class LandingPageTest extends TestBase {
	
	LandingPage landingPage;
	HomePage homePage;
	LoginPage loginPage;
	
	public LandingPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException, IOException{
		driver = getDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
	}
	
	@Test(priority=1)
	public void homePageTasksTitleTest() throws MalformedURLException, IOException{
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		landingPage.getContinueBtn().click();		
		boolean hasTasksTitle = homePage.validateHomePageTasksTitle("Tasks");
		Assert.assertTrue(hasTasksTitle);
	}
	
//	@Test(priority=2)
//	public void crmLogoImageTest(){
//		boolean flag = loginPage.validateCRMImage();
//		Assert.assertTrue(flag);
//	}
	
	@Test(priority=0)
	public void continueTest() throws MalformedURLException, IOException{
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		landingPage.getContinueBtn().click();
		boolean pageHasTitle = homePage.validateHomePageTitle("Field Experts");
		Assert.assertTrue(pageHasTitle);
	}
	
	
	
//	@After
//	public void tearDown(){
//		driver.quit();
//	}
	


}
