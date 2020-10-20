package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
	
	public LoginPageTest() throws MalformedURLException, IOException{
		super();
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws MalformedURLException, IOException{
		driver = getDriver();
		loginPage = new LoginPage(driver);
		
	}
	
	@Test(priority=0)
	public void landingPageTitleTest() throws MalformedURLException, IOException{
	    landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		String title = landingPage.getLandingPageTitle().getText();
		System.out.println(" Login page title "+ title);
		Assert.assertEquals(title, ELEMENT_AUTHENTICATION_LABEL);
	}
	
	@Test(groups = {"smoke"})
	public void loginTest() throws MalformedURLException, IOException{
				
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		Assert.assertNotNull(landingPage);		
	}	
	
	@Test(dataProvider = "getData")
	public void loginTestWithMultiUsers(String userID, String password) throws MalformedURLException, IOException{		
		landingPage = loginPage.login(driver, userID, password);
		System.out.println("Test multi run ");
		Assert.assertNotNull(landingPage);
	}
	
	@DataProvider
	public Object[][] getData() throws MalformedURLException, IOException{
				
		Object[][] data  = new Object[3][2];
		data[0][0] = prop.getProperty("userID");
		data[0][1] = prop.getProperty("password");
		
		data[1][0] = prop.getProperty("userID1");
		data[1][1] = prop.getProperty("password1");
		
		data[2][0] = prop.getProperty("userID2");
		data[2][1] = prop.getProperty("password2");		
		
		return data;
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() throws IOException{
		System.out.println("tearing down");
		landingPage = null;
		driver.quit();
		TestBase.shutDownAVD();
	}

}
