package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;
import com.colt.fieldengineerapp.pages.LogoutPage;
import com.colt.fieldengineerapp.pages.OpenDrawerPage;
import com.colt.fieldengineerapp.pages.SettingsPage;

public class LogoutPageTest extends TestBase {
	
	LandingPage landingPage;
	HomePage homePage;
	LoginPage loginPage;
	LogoutPage logoutPage;
	OpenDrawerPage openDrawerPage;
	SettingsPage settingsPage;
	
	public LogoutPageTest() throws MalformedURLException, IOException{
		super();
			
	}
	
	@BeforeTest(alwaysRun = true)
	public void startServices() throws IOException, InterruptedException {
		TestBase.startAVD();
		Thread.sleep(20000);
		System.out.println("Starting Appium == " +this.getClass().getName());
		TestBase.startAppiumServer();				
	}
		
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws MalformedURLException, IOException, InterruptedException{
		driver = getDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		openDrawerPage = new OpenDrawerPage(driver);
		settingsPage = new SettingsPage(driver);
		logoutPage = new LogoutPage(driver);
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		
	}
	
	@Test
	public void logoutPageTest() throws MalformedURLException, IOException, InterruptedException{
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.startRecording(driver);
			}
			
		}

		landingPage.getContinueBtn().click();		
		boolean hasTasksTitle = homePage.validateHomePageTitle(ELEMENT_HOMEPAGE_LABEL);
		Assert.assertTrue(hasTasksTitle);
		
		homePage.getDrawerButton().click();
		
		String openDrawerPageLabel = openDrawerPage.getWelcomeLabel().getText();
		Assert.assertEquals(openDrawerPageLabel,ELEMENT_WELCOME,ELEMENT_WELCOME_MSG);
		
		String userNameLabel = openDrawerPage.getUserNameLabel().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(userNameLabel.trim()), ELEMENT_USERNAME_MSG);
		
		//openDrawerPage.getSettingsPageButton().click();
		openDrawerPage.getAllDrawerButtons().get(3).click();
		
		String confirmLabel = logoutPage.getConfirmLabel().getText();
		Assert.assertFalse(confirmLabel != null && ELEMENT_EMPTY_STRING.equals(confirmLabel.trim()), ELEMENT_LOGOUT_CONFIRM_HEADING_VALUE);
		Assert.assertEquals(confirmLabel,ELEMENT_LOGOUT_CONFIRM_HEADING,ELEMENT_LOGOUT_CONFIRM_HEADING);
		
		String messageLabel = logoutPage.getMessgageLabel().getText();
		Assert.assertFalse(messageLabel != null && ELEMENT_EMPTY_STRING.equals(messageLabel.trim()), ELEMENT_LOGOUT_CONFIRM_TITLE_VALUE);
		Assert.assertEquals(messageLabel,ELEMENT_LOGOUT_CONFIRM_TITLE,ELEMENT_LOGOUT_CONFIRM_TITLE_MSG);
		
		homePage.getOkButton().click();
		Thread.sleep(3000);
			
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
			}
			
		}

	}
	
	
	@AfterTest(alwaysRun = true)
	public void tearDown() throws IOException, InterruptedException {
		
		if(prop.getProperty("stopAVD").equals("true")) {
			System.out.println("Tearing  down == " +this.getClass().getName());
			TestBase.shutDownAVD();
			Thread.sleep(3000);
		}		
		
		if(prop.getProperty("stopAppiumServer").equals("true")) {
			System.out.println("Tearing  down == " +this.getClass().getName());
			TestBase.stopAppiumServer();
			Thread.sleep(5000);		}
	}


	
	

}
