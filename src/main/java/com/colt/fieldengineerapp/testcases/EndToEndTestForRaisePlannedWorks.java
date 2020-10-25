package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.ConfirmPage;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;
import com.colt.fieldengineerapp.pages.RaisedPlanWorkPage;
import com.colt.fieldengineerapp.pages.SetTimePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EndToEndTestForRaisePlannedWorks extends TestBase {

	LoginPage loginPage;
	LandingPage landingPage;
	HomePage homePage;
	RaisedPlanWorkPage raisedPlannedWorkPage;
	SetTimePage setTimePage;
	ConfirmPage confirmPage;
	AndroidDriver<AndroidElement> driver;
	List<AndroidElement> listofTextView;


	public EndToEndTestForRaisePlannedWorks() throws MalformedURLException, IOException {
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
		setTimePage = new SetTimePage(driver);
		confirmPage = new ConfirmPage(driver);
	}

	@Test
	public void endToEndTestForRaisePlanWork() throws MalformedURLException, IOException {
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		landingPage.getContinueBtn().click();
		homePage.getRaisePlanWork().click();
		
		String label = raisedPlannedWorkPage.getTemplateLabel().getText();
		System.out.println("Label is " + label);
		
		//Click on Template dropdown and click on Standard SD option
		raisedPlannedWorkPage.getTemplateDropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_TEMPLATE_DROPDOWN_2).perform();	
			
		
		
		//click on Change Category drop down and select one of the value
		String categoryLabel = raisedPlannedWorkPage.getCategoryLabel().getText();
		System.out.println("Label is " + categoryLabel);
		raisedPlannedWorkPage.getCategoryDropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_CATEGORY_DROPDOWN_1).perform();		

		//click on Change Category drop down and select one of the value
		String changeDescriptionlabel = raisedPlannedWorkPage.getChangeDescriptionLabel().getText();
		System.out.println("Label is " + changeDescriptionlabel);
		raisedPlannedWorkPage.getChangeDescriptionDropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_1).perform();
		
		String changeCatalogeLabel = raisedPlannedWorkPage.getChangeCatalogeLabel().getText();
		System.out.println("Change catalogue label is "+ changeCatalogeLabel);
		
		String changeCatalogeTextField = raisedPlannedWorkPage.getChangeCatalogeTextField().getText();
		System.out.println("Change catalogue Text Field is "+ changeCatalogeTextField);
		
		
		String changeCatalogeTextFieldLabel = raisedPlannedWorkPage.getConfigIDTypeLabel().getText();
		System.out.println("Config Label is "+ changeCatalogeTextFieldLabel);
		
		String changeCatalogeTextFieldValue = raisedPlannedWorkPage.getConfigIdTextField().getText();
		System.out.println("Config Text Field  is "+ changeCatalogeTextFieldValue);
		
		raisedPlannedWorkPage.getNextBtn().click();
		
		//On Next page we meed to click on 2 of the drop downs and enter value in text field
		

		String labelLocationDetailsTier1 = raisedPlannedWorkPage.getLocationDetailsTier1Label().getText();
		System.out.println("Label is " + labelLocationDetailsTier1);
		
		//Click on Template dropdown and click on Standard SD option
		raisedPlannedWorkPage.getLocationDetailsTier1DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_LOCATION_TIER1_DROPDOWN_22).perform();
		
		
		String labelLocationDetailsTier2 = raisedPlannedWorkPage.getLocationDetailsTier2Label().getText();
		System.out.println("Label is " + labelLocationDetailsTier2);
		
		//Click on Template dropdown and click on Standard SD option
		raisedPlannedWorkPage.getLocationDetailsTier2DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_LOCATION_TIER2_DROPDOWN_2).perform();
		
		raisedPlannedWorkPage.getSiteAddressTextField().sendKeys("12345");
		
		raisedPlannedWorkPage.getNextBtn().click();
		
		//Planned Start
		String labelPLannedStart = raisedPlannedWorkPage.getPlannedStartDateLabel().getText();
		System.out.println("Label is " + labelPLannedStart);
		
		//Click on Template dropdown and click on Standard SD option
		raisedPlannedWorkPage.getPlannedStartDateSelector().click();
		String timeZoneID = raisedPlannedWorkPage.getZoneGMTBtn().getText(); 
		raisedPlannedWorkPage.getZoneGMTBtn().click();
		//get current date time details as per timezone selected 
		//int currentDate = Integer.parseInt(raisedPlannedWorkPage.getDateAsPerPattern("dd"));
		
		Map<String,Integer> dateMap = raisedPlannedWorkPage.timeDateMapAsPerTimezone(timeZoneID);
		System.out.println(" Current day in dd is "+ dateMap.get(ELEMENT_DAY_KEY));
		
		int currentDate = dateMap.get(ELEMENT_DAY_KEY).intValue();
						
		raisedPlannedWorkPage.moveToScrollToElement(driver, String.valueOf(currentDate+1)).perform();
		raisedPlannedWorkPage.getOkBtn().click();
		
		//Using other keyboard with edit text to enter time
		raisedPlannedWorkPage.getDateToggleButton().click();
		
		int hourCurrent = dateMap.get(ELEMENT_HOUR_KEY).intValue();
		int hourToBeSet = hourCurrent + 2;
		
		if(hourToBeSet > 12) {
			hourToBeSet = 1;
		}else if(hourToBeSet == 12) {
			hourToBeSet = 12;
		}
		
		setTimePage.getInPutHourTextField().clear();
		setTimePage.getInPutHourTextField().sendKeys(String.valueOf(hourToBeSet));
		System.out.println(" setTimePage minutes "+ setTimePage.getInPutHourTextField().getText());
		
		int minutesCurrent = dateMap.get(ELEMENT_MINUTE_KEY).intValue();
		int minutesToBeSet = minutesCurrent + 40;
		
		if(minutesToBeSet > 60) {
			minutesToBeSet = 10;
		}else if(minutesToBeSet == 60) {
			minutesToBeSet = 60;
		}
		
		setTimePage.getInPutMinuteTextField().clear();
		setTimePage.getInPutMinuteTextField().sendKeys(String.valueOf(minutesToBeSet));
		
		System.out.println(" setTimePage minutes "+ setTimePage.getInPutMinuteTextField().getText());
		String currentAMPMValue = setTimePage.getCurrentAMPMValue().getText();
		setTimePage.getAmPMDropDown().click();
		
		
		System.out.println("Current APPM Value is "+currentAMPMValue);
		
		if(currentAMPMValue.equals(ELEMENT_PM)) {
			setTimePage.moveToScrollToElement(driver, ELEMENT_AM);
		}else {
			setTimePage.moveToScrollToElement(driver, ELEMENT_PM);
		}
		
		setTimePage.getOkButton().click();
	
		//Using Swipe mode to set time
		
		//raisedPlannedWorkPage.getHourActionSwipe(driver, ELEMENT_CLOCK_DIGIT_NINE).perform();
		//raisedPlannedWorkPage.getMinuteActionSwipeTo(driver, ELEMENT_CLOCK_MINUTE_FORTY_FIVE);
		System.out.println("Hour in Map is "+ dateMap.get(ELEMENT_HOUR_KEY).toString());
//		raisedPlannedWorkPage.moveHourMinuteFromTillTo(
//				driver,dateMap.get(ELEMENT_HOUR_KEY).toString(), ELEMENT_CLOCK_DIGIT_NINE).perform();
//		raisedPlannedWorkPage.moveHourMinuteFromTillTo(
//				driver,dateMap.get(ELEMENT_MINUTE_KEY).toString(), ELEMENT_CLOCK_MINUTE_FORTY_FIVE).perform();
		
		//raisedPlannedWorkPage.getOkBtn().click();
		
		String plannedStartTextField = raisedPlannedWorkPage.getPlannedStartTextField().getText();
		System.out.println("plannedStartTextField "+plannedStartTextField);
		
		
		//for end date
		raisedPlannedWorkPage.getPlannedEndDateSelector().click();
							
		raisedPlannedWorkPage.moveToScrollToElement(driver, String.valueOf(currentDate+2)).perform();
		raisedPlannedWorkPage.getOkBtn().click();
		
		//set to a particular hour and time
		raisedPlannedWorkPage.getHourActionSwipe(driver, ELEMENT_CLOCK_DIGIT_HOUR_SEVEN_END).perform();
		raisedPlannedWorkPage.getMinuteActionSwipeTo(driver, ELEMENT_CLOCK_MINUTE_TWENTY_END);
		
//		raisedPlannedWorkPage.moveHourMinuteFromTillTo(
//				driver,dateMap.get(ELEMENT_HOUR_KEY).toString(), ELEMENT_CLOCK_DIGIT_HOUR_SEVEN_END).perform();
//		raisedPlannedWorkPage.moveHourMinuteFromTillTo(
//				driver,dateMap.get(ELEMENT_MINUTE_KEY).toString(), ELEMENT_CLOCK_MINUTE_TWENTY_END).perform();
		raisedPlannedWorkPage.getOkBtn().click();
		
		String plannedEndTextField = raisedPlannedWorkPage.getPlannedEndTextField().getText();
		System.out.println("plannedEndTextField "+plannedEndTextField);

		
		//Read the Planned Start Text Field
//		raisedPlannedWorkPage.getBackoutStartDateSelector().click();
//		//raisedPlannedWorkPage.getZoneGMTBtn().click();
//		//String dateCurrent = raisedPlannedWorkPage.getDateAsPerPattern("dd");
////		int plannedEndDate = Integer.parseInt(raisedPlannedWorkPage.getDateAsPerPattern("dd"));
////		System.out.println(" Current date in dd is "+ plannedEndDate);
//						
//		raisedPlannedWorkPage.moveToScrollToElement(driver, String.valueOf(currentDate+2)).perform();
//		raisedPlannedWorkPage.getOkBtn().click();
		
		
		//raisedPlannedWorkPage.getHourActionSwipe(driver, ELEMENT_CLOCK_HOUR_EIGHT_BACKOUT).perform();
		//raisedPlannedWorkPage.getMinuteActionSwipeTo(driver, ELEMENT_CLOCK_MINUTE_FORTY_BACKOUT);
		//raisedPlannedWorkPage.getOkBtn().click();
		
		String backOutTextField = raisedPlannedWorkPage.getBackoutStartTextField().getText();
		System.out.println("backOutTextField "+backOutTextField);
		
		raisedPlannedWorkPage.getNextBtn().click();
		
		//Next Page
		raisedPlannedWorkPage.getOrderNumberTextField().sendKeys("1234");
		raisedPlannedWorkPage.getDeviceIdAddBtn().click();
		raisedPlannedWorkPage.getInputTextField().sendKeys("123456");
		raisedPlannedWorkPage.getAddBtnForPopup().click();
		raisedPlannedWorkPage.getNextBtn().click();
		
		//Next page
		String labelOpCatTier1 = raisedPlannedWorkPage.getOpertaionalCatTier1Label().getText();
		System.out.println("labelOpCatTier1 "+labelOpCatTier1);
		
		raisedPlannedWorkPage.getOpertaionalCatTier1DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_DROP_DOWN_OPCAT_TIER1_8).perform();
		
		raisedPlannedWorkPage.getOpertaionalCatTier2DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_DROP_DOWN_OPCAT_TIER2_6).perform();
		
		raisedPlannedWorkPage.getOpertaionalCatTier3DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_DROP_DOWN_OPCAT_TIER3_3).perform();
		
		raisedPlannedWorkPage.getNextBtn().click();
		
		//Next Page
		raisedPlannedWorkPage.getProductCatTier1DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_DROP_DOWN_PRODCAT_TIER1_1).perform();
		
		raisedPlannedWorkPage.getProductCatTier2DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_DROP_DOWN_PRODCAT_TIER2_1).perform();
		
		raisedPlannedWorkPage.getProductCatTier3DropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_DROP_DOWN_PRODCAT_TIER3_1).perform();
		
		raisedPlannedWorkPage.getFinalSubmitButton().click();
		
		//Confirm Page elements
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_FINAL_CONFIRM_BUTTON).perform();
		
		
		confirmPage.getOkButton().click();
		
		confirmPage.getEnterTemplateNameTextField().sendKeys("Test_Alok");
		
		confirmPage.getOkButton().click();
		
		confirmPage.getOkButtonForCongratsPopUp().click();
		
	}

	

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws IOException {
		System.out.println("tearing down");
		// landingPage = null;
		// driver.quit();
		// TestBase.shutDownAVD();
	}

}