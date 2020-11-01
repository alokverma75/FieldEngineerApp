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

import io.appium.java_client.android.AndroidElement;

public class SettingsrPageTest extends TestBase {
	
	LandingPage landingPage;
	HomePage homePage;
	LoginPage loginPage;
	OpenDrawerPage openDrawerPage;
	SettingsPage settingsPage;
	
	public SettingsrPageTest() throws MalformedURLException, IOException{
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
	
	@Test(priority=1)
	public void settingsPageTest() throws MalformedURLException, IOException{
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.startRecording(driver);
			}
			
		}

		landingPage.getContinueBtn().click();		
		boolean hasTasksTitle = homePage.validateHomePageTitle(ELEMENT_HOMEPAGE_LABEL);
		Assert.assertTrue(hasTasksTitle);
		
		homePage.getDrawerButton().click();
		openDrawerPage.getSettingsPageButton().click();
		
		String languageButton = settingsPage.getLanguageButton().getText();
		Assert.assertEquals(languageButton,ELEMENT_LANGUAGE,ELEMENT_LANGUAGE_MSG);
		
		String notificationButton = settingsPage.getNotificationButton().getText();
		Assert.assertEquals(notificationButton,ELEMENT_NOTIFICATION,ELEMENT_NOTIFICATION_MSG);
		
		//First check notification page
		settingsPage.getNotificationButton().click();
		
		String notificationLabel = settingsPage.getNotificationPageLabel().getText();
		Assert.assertEquals(notificationLabel,ELEMENT_NOTIFICATION,ELEMENT_NOTIFICATION_MSG);

		//As there is no info except Notification label, so go back
		driver.navigate().back();
		
        //Now click on Language button to check next page details
		settingsPage.getLanguageButton().click();
		
		String languageLabel = settingsPage.getLanguageLabel().getText();
		Assert.assertEquals(languageLabel,ELEMENT_LANGUAGE,ELEMENT_LANGUAGE_MSG);

		String englishLanguageButton = settingsPage.getEnglishLanguageButton().getText();
		Assert.assertEquals(englishLanguageButton,ELEMENT_ENGLISH_LANGUAGE,ELEMENT_ENGLISH_LANGUAGE_MSG);
		
		AndroidElement rightCheck = settingsPage.getRightCheckImage();
		Assert.assertFalse(rightCheck == null, ELEMENT_USERNAME_MSG);
		
		String japaneseLanguageButton = settingsPage.getJapaneseLanguageButton().getText();
		Assert.assertEquals(japaneseLanguageButton,ELEMENT_JAPANESE_LANGUAGE,ELEMENT_JAPANESE_LANGUAGE_MSG);
		
		settingsPage.getJapaneseLanguageButton().click();
		
		String homePageLabelinJapanese = homePage.getJapaneseLanguaLabel().getText();
		Assert.assertEquals(homePageLabelinJapanese,ELEMENT_JAPANESE_LABEL_HOME_PAGE,ELEMENT_JAPANESE_LABEL_HOME_PAGE_MSG);
		
		homePage.getDrawerButton().click();
		openDrawerPage.getSettingsPageButton().click();
		
		//Try to check Notification button in Japanese click
		settingsPage.getJapaneseButtonForNotificationSetting().click();
		
		String notificationPageLabelinJapanese = settingsPage.getJapaneseLanguageNotificationLabel().getText();
		Assert.assertEquals(notificationPageLabelinJapanese,ELEMENT_JAPANESE_LABEL_NOTIFICATION_PAGE,ELEMENT_JAPANESE_LABEL_NOTIFICATION_PAGE_MSG);

		//As there is no info except Notification label, so go back
		driver.navigate().back();
		
		//Try to set Language to English
		
		settingsPage.getJapaneseButtonForLanguageSetting().click();
		
		AndroidElement engInJapanese = settingsPage.getEnglishButtonInJapanese();
		
		String engInJapaneseLabel = engInJapanese.getText();
		Assert.assertEquals(engInJapaneseLabel,ELEMENT_ENG_BUTTON_IN_JAPANESE,ELEMENT_ENG_BUTTON_IN_JAPANESE_MSG);
		
		//click to change language to English again and check HomePage label text
		engInJapanese.click();
		
		String homePageLabel = homePage.getHomePageTitle().getText();
		Assert.assertEquals(homePageLabel,ELEMENT_HOMEPAGE_LABEL,ELEMENT_HOMEPAGE_LABEL_MSG);

		
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
