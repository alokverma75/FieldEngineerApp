package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;
import com.colt.fieldengineerapp.pages.OpenDrawerPage;
import com.colt.fieldengineerapp.pages.ProfilePage;
import com.colt.fieldengineerapp.util.TestData;

public class ProfilePageTest extends TestBase {
	
	LandingPage landingPage;
	HomePage homePage;
	LoginPage loginPage;
	OpenDrawerPage openDrawerPage;
	ProfilePage profilePage;
	SoftAssert softAssert;
	Logger logger;
	
	public ProfilePageTest() throws MalformedURLException, IOException{
		super();
			
	}
	
	@BeforeTest(alwaysRun = true)
	public void startServices() throws IOException, InterruptedException {
		TestBase.startAVD();
		Thread.sleep(20000);
		System.out.println("Starting Appium == " +this.getClass().getName());
		TestBase.startAppiumServer();
		logger = LogManager.getLogger(ProfilePageTest.class);
	}
		
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws MalformedURLException, IOException, InterruptedException{
		driver = getDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		openDrawerPage = new OpenDrawerPage(driver);
		profilePage = new ProfilePage(driver);
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));	
		softAssert = new SoftAssert();		
	}
	
	@Test
	public void profilePageBasicDetailsTest() throws MalformedURLException, IOException, InterruptedException{
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.startRecording(driver);
			}
			
		}

		landingPage.getContinueBtn().click();		
		boolean hasTasksTitle = homePage.validateHomePageTitle(ELEMENT_HOMEPAGE_LABEL);
		Assert.assertTrue(hasTasksTitle);
		
		homePage.getDrawerButton().click();
		logger.log(Level.DEBUG, "profilePageBasicDetailsTest()");
//		int size = openDrawerPage.getAllDrawerButtons().size();
//		System.out.println("size is "+size+ "and element is "+ openDrawerPage.getAllDrawerButtons().get(1));
		//The trick is to traverse using App source
		//Settings button is on 2nd Index or 3rd element
		openDrawerPage.getAllDrawerButtons().get(ELEMENT_SECOND).click();
		
		String profileLabel = profilePage.getProfilePageLabel().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(profileLabel.trim()), ELEMENT_PROFILE_PAGE_HEADING_VALUE);
		softAssert.assertEquals(profileLabel,ELEMENT_PROFILE_PAGE_HEADING,ELEMENT_PROFILE_PAGE_HEADING_MSG);

		String profileUserLabel = profilePage.getProfilePageUserLabel().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(profileUserLabel.trim()), ELEMENT_PROFILE_USER_NAME_VALUE);
		
		String basicDetailsLabel = profilePage.getBasicDetailsTab().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(basicDetailsLabel.trim()), ELEMENT_BASIC_DETAILS_TITLE_VALUE);
		softAssert.assertEquals(basicDetailsLabel,ELEMENT_BASIC_DETAILS_TITLE,ELEMENT_BASIC_DETAILS_TITLE_MSG);

	
		String titleLabel = profilePage.getTitleLabel().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(titleLabel.trim()), ELEMENT_SURNAME_TITLE_VALUE);
		softAssert.assertEquals(titleLabel,ELEMENT_SURNAME_TITLE,ELEMENT_SURNAME_TITLE_MSG);

		profilePage.getTitleDropDown().click();
		TestBase.getTouchActionForElement(driver, ELEMENT_TILE_DROP_DOWN_1).perform();
		
		String firstNameLabel = profilePage.getFirstNameLabel().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(firstNameLabel.trim()), ELEMENT_FIRST_NAME_TITLE_VALUE);
		softAssert.assertEquals(firstNameLabel,ELEMENT_FIRST_NAME_TITLE,ELEMENT_FIRST_NAME_TITLE_MSG);

		String firstNameTF = profilePage.getFirstNameTF().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(firstNameTF.trim()), ELEMENT_FIRST_TF_VALUE);
		
		String lastNameLabel = profilePage.getLastNameLabel().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(lastNameLabel.trim()), ELEMENT_LAST_NAME_TITLE_VALUE);
		softAssert.assertEquals(lastNameLabel,ELEMENT_LAST_NAME_TITLE,ELEMENT_LAST_NAME_TITLE_MSG);

		String lastNameTF = profilePage.getLastNameTF().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(lastNameTF.trim()), ELEMENT_LAST_TF_VALUE);

		String phoneNumberLabel = profilePage.getPhoneNumberLabel().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(phoneNumberLabel.trim()), ELEMENT_PHONE_NUMBER_TITLE_VALUE);
		softAssert.assertEquals(phoneNumberLabel,ELEMENT_PHONE_NUMBER_TITLE,ELEMENT_PHONE_NUMBER_TITLE_MSG);

		String phoneNumberTF = profilePage.getPhoneNumberTF().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(phoneNumberTF.trim()), ELEMENT_PHONE_NUMBER_TF_VALUE);
		
		String phoneNumberInfoLabel = profilePage.getPhoenNumberInfoLabel().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(phoneNumberInfoLabel.trim()), ELEMENT_PHONE_NUMBER_INFO);
		softAssert.assertEquals(phoneNumberInfoLabel,ELEMENT_PHONE_NUMBER_INFO,ELEMENT_PHONE_NUMBER_INFO_MSG);
		
		String mobileNumberLabel = profilePage.getMobileNumberLabel().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(mobileNumberLabel.trim()), ELEMENT_MOBILE_TITLE_VALUE);
		softAssert.assertEquals(mobileNumberLabel,ELEMENT_MOBILE_TITLE,ELEMENT_MOBILE_TITLE_MSG);

		String emailLabel = profilePage.getEmailLabel().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(emailLabel.trim()), ELEMENT_EMAIL_PROFILE_VALUE);
		softAssert.assertEquals(emailLabel,ELEMENT_EMAIL_PROFILE,ELEMENT_EMAIL_PROFILE_MSG);
		
		//scroll to Preferred Contact
		//TestBase.getElementByAutomatorForScroll()
		TestBase.getTouchActionForElement(driver, ELEMENT_PREFERRED_CONTACT_TITLE).perform();

		String emailTF = profilePage.getEmailTF().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(emailTF.trim()), ELEMENT_EMAIL_PROFILE_VALUE_TF);

		String preferredContactLabel = profilePage.getPreferredContactLabel().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(preferredContactLabel.trim()), ELEMENT_PREFERRED_CONTACT_TITLE_VALUE);
		softAssert.assertEquals(preferredContactLabel,ELEMENT_PREFERRED_CONTACT_TITLE,ELEMENT_PREFERRED_CONTACT_TITLE_MSG);

		String displayLangLabel = profilePage.getDisplayLangLabel().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(displayLangLabel.trim()), ELEMENT_DISPLAY_LANG_TITLE_VALUE);
		softAssert.assertEquals(displayLangLabel,ELEMENT_DISPLAY_LANG_TITLE,ELEMENT_DISPLAY_LANG_TITLE_MSG);

		profilePage.getDisplayLangDropDown().click();
		TestBase.getTouchActionForElement(driver, ELEMENT_LANG_DROP_DOWN_1).perform();
	
		driver.navigate().back();
		Thread.sleep(3000);
	
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
			}
			
		}
		//Now assert all and fail test case even if one assertion fails
		softAssert.assertAll();

	}
	
	//@Test(dataProvider = "InputDataForChangePassword", dataProviderClass = TestData.class)
	public void profilePageChangePasswordTest(String currentPassword, String newPassword,String wrongPassword,String confirmPassword) throws MalformedURLException, IOException, InterruptedException{
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.startRecording(driver);
			}
			
		}

		landingPage.getContinueBtn().click();		
		boolean hasTasksTitle = homePage.validateHomePageTitle(ELEMENT_HOMEPAGE_LABEL);
		Assert.assertTrue(hasTasksTitle);
		
		homePage.getDrawerButton().click();
//		int size = openDrawerPage.getAllDrawerButtons().size();
//		System.out.println("size is "+size+ "and element is "+ openDrawerPage.getAllDrawerButtons().get(1));
		//The trick is to traverse using App source
		//Settings button is on 2nd Index or 3rd element
		openDrawerPage.getAllDrawerButtons().get(ELEMENT_SECOND).click();
		
		profilePage.getChangePasswordTab().click();
		
		String currentPasswordLabel = profilePage.getCurrentPasswordLabel().getText();
		softAssert.assertFalse(ELEMENT_EMPTY_STRING.equals(currentPasswordLabel.trim()), ELEMENT_CHANGE_PWD_TITLE_VALUE);
		softAssert.assertEquals(currentPasswordLabel,ELEMENT_CURRENT_PWD_TITLE,ELEMENT_CURRENT_PWD_TITLE_MSG);
		
		profilePage.getChangePasswordButton().click();
		
		String currentPasswordBlankError = profilePage.getEnterCurrentPasswordLabel().getText();
		softAssert.assertEquals(currentPasswordBlankError,ELEMENT_CURRENT_PWD_BLANK_ERROR,ELEMENT_CURRENT_PWD_BLANK_ERROR_MSG);
		
		homePage.getOkButton().click();
		
		profilePage.getCurrentPasswordTF().sendKeys(currentPassword);
		
		//Try to move ahead without entering New password, and we should see an error window
		profilePage.getChangePasswordButton().click();
		
	
		String newPasswordBlankError = profilePage.getEnterNewPasswordLabel().getText();
		softAssert.assertEquals(newPasswordBlankError,ELEMENT_NEW_PWD_BLANK_ERROR,ELEMENT_NEW_PWD_BLANK_ERROR_MSG);

		homePage.getOkButton().click();
		String newPasswordLabel = profilePage.getNewPasswordLabel().getText();
		softAssert.assertEquals(newPasswordLabel,ELEMENT_NEW_PWD_TITLE,ELEMENT_NEW_PWD_TITLE_MSG);

		profilePage.getNewPasswordTF().sendKeys(newPassword);
		
		//Try to move ahead without entering New password, and we should see an error window
		profilePage.getChangePasswordButton().click();

		String confirmPasswordBlankError = profilePage.getEnterConfirmPasswordLabel().getText();
		softAssert.assertEquals(confirmPasswordBlankError,ELEMENT_CONFIRM_PWD_BLANK_ERROR,ELEMENT_CONFIRM_PWD_BLANK_ERROR_MSG);
		
		homePage.getOkButton().click();
		
		String confirmPasswordLabel = profilePage.getConfirmPasswordLabel().getText();
		softAssert.assertEquals(confirmPasswordLabel,ELEMENT_CONFIRM_PWD_TITLE,ELEMENT_CONFIRM_PWD_TITLE_MSG);
	
		//Now enter diff password other than entered on New password TF
		profilePage.getConfirmPasswordTF().sendKeys(wrongPassword);
		profilePage.getChangePasswordButton().click();
		String confirmPasswordMismatch = profilePage.getPasswordMismatchLabel().getText();
		softAssert.assertEquals(confirmPasswordMismatch,ELEMENT_PASSWORD_MISMATCH_ERROR,ELEMENT_PASSWORD_MISMATCH_ERROR_MSG);

		homePage.getOkButton().click();
		profilePage.getConfirmPasswordTF().clear();
		profilePage.getConfirmPasswordTF().sendKeys(confirmPassword);
		
		//Now press change password and validate the snackbar success message
		profilePage.getChangePasswordButton().click();
		
		//Now we will see alet window with Changing password message
		
		String changingPasswordMessage = profilePage.getChangingPasswordAlertMsg().getText();
		softAssert.assertEquals(changingPasswordMessage,ELEMENT_CHANGING_PASSWORD,ELEMENT_CHANGING_PASSWORD_MSG);
		
		//Sleep for 3 seconds
		Thread.sleep(3000);		
		
		String successMessage = profilePage.getPasswordMessageSnackBarSuccess().getText();
		softAssert.assertEquals(successMessage,ELEMENT_PASSWORD_CHANGE_SUCCESS,ELEMENT_PASSWORD_CHANGE_SUCCESS_MSG);
		
		driver.navigate().back();
		
		Thread.sleep(2000);
	
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
			}
			
		}
		//Now assert all and fail test case even if one assertion fails
		softAssert.assertAll();
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
