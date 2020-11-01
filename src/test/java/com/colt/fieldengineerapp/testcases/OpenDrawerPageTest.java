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
import com.colt.fieldengineerapp.pages.OpenDrawerPage;
import com.colt.fieldengineerapp.pages.SettingsPage;

public class OpenDrawerPageTest extends TestBase {
	
	LandingPage landingPage;
	HomePage homePage;
	LoginPage loginPage;
	OpenDrawerPage openDrawerPage;
	SettingsPage settingsPage;
	
	public OpenDrawerPageTest() throws MalformedURLException, IOException{
		super();
			
	}
	
	@BeforeTest(alwaysRun = true)
	public void startServices() throws IOException, InterruptedException {
		TestBase.startAVD();
		Thread.sleep(12000);
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
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		
	}
	
	@Test
	public void openDrawerPageTest() throws MalformedURLException, IOException{
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
		
		openDrawerPage.getSettingsPageButton().click();
		
		String settingsPageLabel = settingsPage.getSettingsLabel().getText();
		Assert.assertEquals(settingsPageLabel,ELEMENT_SETTINGS,ELEMENT_SETTINGS_MSG);
			
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
			}
			
		}

	}
	
	
	@AfterTest(alwaysRun = true)
	public void tearDown() throws IOException, InterruptedException {
		System.out.println("Tearing  down AVD== " +this.getClass().getName());
		TestBase.shutDownAVD();
		Thread.sleep(3000);
		System.out.println("Tearing  down Appium== " +this.getClass().getName());
		TestBase.stopAppiumServer();
		Thread.sleep(5000);
	}


	
	

}
