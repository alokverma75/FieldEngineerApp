package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;

public class LandingPageTest extends TestBase {
	
	LandingPage landingPage;
	HomePage homePage;
	LoginPage loginPage;
	
	public LandingPageTest() throws MalformedURLException, IOException{
		super();
			
	}
	
//	@BeforeSuite(alwaysRun = true)
//	public void startServer() throws IOException {
//		TestBase.startAVD();		
//	}
	
		
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws MalformedURLException, IOException{
		driver = getDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void homePageTasksTitleTest() throws MalformedURLException, IOException{
		landingPage.getContinueBtn().click();		
		boolean hasTasksTitle = homePage.validateHomePageTasksTitle(ELEMENT_HOMEPAGE_TASKS_LABEL);
		Assert.assertTrue(hasTasksTitle);
	}
	
	@Test
	public void continueTest() throws MalformedURLException, IOException{
		landingPage.getContinueBtn().click();
		boolean pageHasTitle = homePage.validateHomePageTitle(ELEMENT_HOMEPAGE_LABEL);
		Assert.assertTrue(pageHasTitle);
	}	
	
	

}
