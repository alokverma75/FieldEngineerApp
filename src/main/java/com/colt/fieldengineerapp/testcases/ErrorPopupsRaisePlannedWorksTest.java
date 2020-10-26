package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.ConfirmPage;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;
import com.colt.fieldengineerapp.pages.RaisePlanWorkWarningAlerts;
import com.colt.fieldengineerapp.pages.RaisedPlanWorkPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ErrorPopupsRaisePlannedWorksTest extends TestBase {

	LoginPage loginPage;
	LandingPage landingPage;
	HomePage homePage;
	RaisedPlanWorkPage raisedPlannedWorkPage;
	RaisePlanWorkWarningAlerts raisePlanWorkWarningAlerts;
	ConfirmPage confirmPage;
	AndroidDriver<AndroidElement> driver;
	List<AndroidElement> listofTextView;


	public ErrorPopupsRaisePlannedWorksTest() throws MalformedURLException, IOException {
		super();

	}
	
	@BeforeTest(alwaysRun = true)
	public void startServer() throws IOException {
		TestBase.startAVD();		
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws MalformedURLException, IOException {
		driver = getDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		raisedPlannedWorkPage = new RaisedPlanWorkPage(driver);
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		raisePlanWorkWarningAlerts = new RaisePlanWorkWarningAlerts(driver);
		confirmPage = new ConfirmPage(driver);
	}

	//@Test
	public void alertsRaisePlanWorkTemplateStep() throws MalformedURLException, IOException {
		TestBase.startRecording(driver);
		landingPage.getContinueBtn().click();
		homePage.getRaisePlanWork().click();
	
		raisedPlannedWorkPage.getTemplateDropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_TEMPLATE_DROPDOWN_2).perform();
		
		raisedPlannedWorkPage.getNextBtn().click();
		//We need to switch to the opened Alert window before we read any value
		Alert alert = driver.switchTo().alert();		
		String emptyCategoryLabel = raisePlanWorkWarningAlerts.getEmptyCategoryLabel().getText();
		Assert.assertEquals(emptyCategoryLabel, ERROR_MESSAGE_EMPTY_CATEGORY);
		//OK Button not required for this as accept() to be used to click on OK.
		alert.accept();		
		
		raisedPlannedWorkPage.getCategoryDropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_CATEGORY_DROPDOWN_1).perform();		
		
		raisedPlannedWorkPage.getNextBtn().click();
		Alert alertDesc = driver.switchTo().alert();
		String emptyDescriptionLabel = raisePlanWorkWarningAlerts.getEmptyCategoryDescriptionLabel().getText();
		Assert.assertEquals(emptyDescriptionLabel, ERROR_MESSAGE_EMPTY_CATEGORY_DESCRIPTION);		
		alertDesc.accept();
		
		raisedPlannedWorkPage.getChangeDescriptionDropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_1).perform();
		raisedPlannedWorkPage.getNextBtn().click();
		TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
	}
	
	
	@Test
	public void alertsRaisePlanWorkOperationTierStep() throws MalformedURLException, IOException {
		TestBase.startRecording(driver);
		landingPage.getContinueBtn().click();
		homePage.getRaisePlanWork().click();
		raisedPlannedWorkPage.getTemplateDropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_TEMPLATE_DROPDOWN_2).perform();
		raisedPlannedWorkPage.getCategoryDropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_CATEGORY_DROPDOWN_1).perform();		
		raisedPlannedWorkPage.getChangeDescriptionDropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_1).perform();
		raisedPlannedWorkPage.getNextBtn().click();
		
		//First Alert for Location Tier1
		raisedPlannedWorkPage.getNextBtn().click();//try to move without selecting location tier1
		Alert alertLocTier1 = driver.switchTo().alert();
		String emptyLocTier1Label = raisePlanWorkWarningAlerts.getEmptyLocTier1Label().getText();
		Assert.assertEquals(emptyLocTier1Label, ERROR_MESSAGE_EMPTY_LOCATION_TIER1);		
		alertLocTier1.accept();
		
		//Now select the drop down after validating Alert window label
		raisedPlannedWorkPage.getLocationDetailsTier1DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_LOCATION_TIER1_DROPDOWN_22).perform();
		
		raisedPlannedWorkPage.getNextBtn().click();//try to move without selecting location tier2
		//First Alert for Location Tier2
		Alert alertLocTier2 = driver.switchTo().alert();
		String emptyLocTier2Label = raisePlanWorkWarningAlerts.getEmptyLocTier2Label().getText();
		Assert.assertEquals(emptyLocTier2Label, ERROR_MESSAGE_EMPTY_LOCATION_TIER2);		
		alertLocTier2.accept();
		
		//Now select the drop down after validating Alert window label
		raisedPlannedWorkPage.getLocationDetailsTier2DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_LOCATION_TIER2_DROPDOWN_2).perform();

		
		raisedPlannedWorkPage.getNextBtn().click();

		//First Alert for Site Address
		Alert alertSiteAddress = driver.switchTo().alert();
		String emptySiteAddressLabel = raisePlanWorkWarningAlerts.getEmptySiteAddressLabel().getText();
		Assert.assertEquals(emptySiteAddressLabel, ERROR_MESSAGE_EMPTY_SITE_ADDRESS);		
		alertSiteAddress.accept();
		TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
		
	}
	
	//@Test
	public void alertsRaisePlanWorkPlannedScheduleStep() throws MalformedURLException, IOException, InterruptedException {
		TestBase.startRecording(driver);
		
		landingPage.getContinueBtn().click();
		homePage.getRaisePlanWork().click();
		raisedPlannedWorkPage.getTemplateDropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_TEMPLATE_DROPDOWN_2).perform();
		raisedPlannedWorkPage.getCategoryDropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_CATEGORY_DROPDOWN_1).perform();		
		raisedPlannedWorkPage.getChangeDescriptionDropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_1).perform();
		raisedPlannedWorkPage.getNextBtn().click();
		
		//Location Tier
		raisedPlannedWorkPage.getLocationDetailsTier1DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_LOCATION_TIER1_DROPDOWN_22).perform();
		raisedPlannedWorkPage.getLocationDetailsTier2DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_LOCATION_TIER2_DROPDOWN_2).perform();
		raisedPlannedWorkPage.getSiteAddressTextField().sendKeys("12345");
		raisedPlannedWorkPage.getNextBtn().click();

	
		//Planned Schedule
		
		raisedPlannedWorkPage.getPlannedStartDateSelector().click();
		raisedPlannedWorkPage.getZoneGMTBtn().click();
		
		int currentDate = Integer.parseInt(raisedPlannedWorkPage.getDateAsPerPattern("dd"));
		raisedPlannedWorkPage.moveToScrollToElement(driver, String.valueOf(currentDate+1)).perform();
		raisedPlannedWorkPage.getOkBtn().click();
		
		raisedPlannedWorkPage.getHourActionSwipe(driver, ELEMENT_CLOCK_DIGIT_NINE).perform();
		raisedPlannedWorkPage.getMinuteActionSwipeTo(driver, ELEMENT_CLOCK_MINUTE_FORTY_FIVE);
		raisedPlannedWorkPage.getOkBtn().click();
		
		//for end date
		raisedPlannedWorkPage.getPlannedEndDateSelector().click();
							
		raisedPlannedWorkPage.moveToScrollToElement(driver, String.valueOf(currentDate+2)).perform();
		raisedPlannedWorkPage.getOkBtn().click();
		
		//set to a particular hour and time
		raisedPlannedWorkPage.getHourActionSwipe(driver, ELEMENT_CLOCK_DIGIT_HOUR_SEVEN_END).perform();
		raisedPlannedWorkPage.getMinuteActionSwipeTo(driver, ELEMENT_CLOCK_MINUTE_TWENTY_END);
		raisedPlannedWorkPage.getOkBtn().click();
		//move to next page
		raisedPlannedWorkPage.getNextBtn().click();
		
		//First Alert for Order No
		raisedPlannedWorkPage.getNextBtn().click(); //try to move without entering order no
		Alert alertOrderNo = driver.switchTo().alert();
		String emptyOrderIdLabel = raisePlanWorkWarningAlerts.getEmptyOrderIdLabel().getText();
		Assert.assertEquals(emptyOrderIdLabel, ERROR_MESSAGE_EMPTY_ORDER_ID);		
		alertOrderNo.accept();
		
		raisedPlannedWorkPage.getOrderNumberTextField().sendKeys("1234");
		
		
		//Empty config id
		//First Alert for device id
		raisedPlannedWorkPage.getNextBtn().click(); //try to move without entering device id
		Alert alertConfigId = driver.switchTo().alert();
		String emptyConfigIdLabel = raisePlanWorkWarningAlerts.getEmptyConfigIdLabel().getText();
		Assert.assertEquals(emptyConfigIdLabel, ERROR_MESSAGE_EMPTY_DEVICE_ID);		
		alertConfigId.accept();	

		
		raisedPlannedWorkPage.getDeviceIdAddBtn().click();
		String inputIdLabel = raisePlanWorkWarningAlerts.getInputDeviceIdLabel().getText();
		Assert.assertEquals(inputIdLabel, ERROR_MESSAGE_EMPTY_INPUT_IDS);		
		
		raisedPlannedWorkPage.getInputTextField().sendKeys("123456");
		raisedPlannedWorkPage.getAddBtnForPopup().click();
		raisedPlannedWorkPage.getNextBtn().click();	
		
		// Now try to move forward without entering Operation tier1
		raisedPlannedWorkPage.getNextBtn().click();	
		Alert alertOperationTier1Id = driver.switchTo().alert();
		String emptyOperationTier1Label = raisePlanWorkWarningAlerts.getEmptyOperationTier1Label().getText();
		Assert.assertEquals(emptyOperationTier1Label, ERROR_MESSAGE_EMPTY_OP_TIER1);		
		alertOperationTier1Id.accept();
		
		raisedPlannedWorkPage.getOpertaionalCatTier1DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_DROP_DOWN_OPCAT_TIER1_8).perform();
		
		// Now try to move forward without entering Operation tier2
		raisedPlannedWorkPage.getNextBtn().click();	
		Alert alertOperationTier2Id = driver.switchTo().alert();
		String emptyOperationTier2Label = raisePlanWorkWarningAlerts.getEmptyOperationTier2Label().getText();
		Assert.assertEquals(emptyOperationTier2Label, ERROR_MESSAGE_EMPTY_OP_TIER2);		
		alertOperationTier2Id.accept();	
		
		raisedPlannedWorkPage.getOpertaionalCatTier2DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_DROP_DOWN_OPCAT_TIER2_6).perform();
		
		// Now try to move forward without entering Operation tier3
		raisedPlannedWorkPage.getNextBtn().click();	
		Alert alertOperationTier3Id = driver.switchTo().alert();
		String emptyOperationTier3Label = raisePlanWorkWarningAlerts.getEmptyOperationTier2Label().getText();
		Assert.assertEquals(emptyOperationTier3Label, ERROR_MESSAGE_EMPTY_OP_TIER2); //Defect found in testing	
		alertOperationTier3Id.accept();
		
		raisedPlannedWorkPage.getOpertaionalCatTier3DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_DROP_DOWN_OPCAT_TIER3_3).perform();
		
		raisedPlannedWorkPage.getNextBtn().click();
		
		// Now try to move forward without entering Product tier1
		raisedPlannedWorkPage.getFinalSubmitButton().click();
		Alert alertProductTier1 = driver.switchTo().alert();
		String emptyProductTier1Label = raisePlanWorkWarningAlerts.getEmptyProductTier1Label().getText();
		Assert.assertEquals(emptyProductTier1Label, ERROR_MESSAGE_EMPTY_PROD_TIER1);		
		alertProductTier1.accept();
		
		
		raisedPlannedWorkPage.getProductCatTier1DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_DROP_DOWN_PRODCAT_TIER1_1).perform();
		
		
		// Now try to move forward without entering Product tier1
		raisedPlannedWorkPage.getFinalSubmitButton().click();
		Alert alertProductTier2 = driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String emptyProductTier2Label = raisePlanWorkWarningAlerts.getEmptyProductTier2Label().getText();
		Assert.assertEquals(emptyProductTier2Label, ERROR_MESSAGE_EMPTY_PROD_TIER2);
		//raisedPlannedWorkPage.getOkBtn().click();
		alertProductTier2.accept();	
		
		raisedPlannedWorkPage.getProductCatTier2DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_DROP_DOWN_PRODCAT_TIER2_1).perform();
		
		// Now try to move forward without entering Product tier1
		raisedPlannedWorkPage.getFinalSubmitButton().click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Alert alertProductTier3 = driver.switchTo().alert();
		String emptyProductTier3Label = raisePlanWorkWarningAlerts.getEmptyProductTier3Label().getText();
		Assert.assertEquals(emptyProductTier3Label, ERROR_MESSAGE_EMPTY_PROD_TIER3);		
		alertProductTier3.accept();

		
		raisedPlannedWorkPage.getProductCatTier3DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_DROP_DOWN_PRODCAT_TIER3_1).perform();
		
		raisedPlannedWorkPage.getFinalSubmitButton().click();
	
		// Now scroll to end of page to confirm the details
		
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_FINAL_CONFIRM_BUTTON).perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
		Alert alertSaveTemplate = driver.switchTo().alert();
		String saveTemplateLabel = raisePlanWorkWarningAlerts.getSaveTemplateConfirmLabel().getText();
		Assert.assertEquals(saveTemplateLabel, ERROR_MESSAGE_SAVE_TEMPLATE);		
		alertSaveTemplate.accept();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Alert alertEnterTemplateName = driver.switchTo().alert();
		String enterTemplateNameLabel = raisePlanWorkWarningAlerts.getEnterTemplateNameLabel().getText();
		Assert.assertEquals(enterTemplateNameLabel, ERROR_MESSAGE_ENTER_TEMPLATE_NAME);
		confirmPage.getEnterTemplateNameTextField().sendKeys("Test_Alok");
		alertEnterTemplateName.accept();	
		
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		Alert alertCongrats = driver.switchTo().alert();
		String alertCongratsLabel = raisePlanWorkWarningAlerts.getCongratsLabel().getText();
		Assert.assertEquals(alertCongratsLabel, MESSAGE_CONGRATS);		
		alertCongrats.accept();
		
		TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
	}




	

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws IOException {
		System.out.println("tearing down");
		// landingPage = null;
		// driver.quit();
		// TestBase.shutDownAVD();
	}

}
