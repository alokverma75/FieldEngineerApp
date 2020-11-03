package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.base.TestData;
import com.colt.fieldengineerapp.pages.ConfirmPage;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;
import com.colt.fieldengineerapp.pages.RaisePlanWorkWarningAlerts;
import com.colt.fieldengineerapp.pages.RaisedPlanWorkPage;
import com.colt.fieldengineerapp.pages.SetTimePage;
import com.colt.fieldengineerapp.pages.TemplatesPage;

public class TemplatesPageTest extends TestBase {
	
	LandingPage landingPage;
	HomePage homePage;
	LoginPage loginPage;
	TemplatesPage templatesPage;
	RaisedPlanWorkPage raisedPlannedWorkPage;
	RaisePlanWorkWarningAlerts raisePlanWorkWarningAlerts;
	SetTimePage setTimePage;
	ConfirmPage confirmPage;
	
	
	public TemplatesPageTest() throws MalformedURLException, IOException{
		super();
			
	}
	
	@BeforeTest(alwaysRun = true)
	public void startServices() throws IOException, InterruptedException {
		System.out.println("Starting AVD == " +this.getClass().getName());
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
		templatesPage = new TemplatesPage(driver);
		setTimePage = new SetTimePage(driver);
		raisedPlannedWorkPage = new RaisedPlanWorkPage(driver);
		raisePlanWorkWarningAlerts = new RaisePlanWorkWarningAlerts(driver);
		confirmPage = new ConfirmPage(driver);
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		
	}
	//Test data is populated using one single TestDate class
	@Test(dataProvider = "TextFieldsDataForTemplates", dataProviderClass = TestData.class)
	public void templatesPageTest(String orderNumber, String inputTextField,String templateName) throws MalformedURLException, IOException{
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.startRecording(driver);
			}
			
		}

		landingPage.getContinueBtn().click();		
		String templatesTitle = homePage.getTemplatesButton().getText();
		Assert.assertEquals(templatesTitle, ELEMENT_TEMPLATE_HOME,ELEMENT_TEMPLATE_HOME_MSG );
		
		homePage.getTemplatesButton().click();
		
		String viewTemplatesTitle = templatesPage.getViewTemplatesLabel().getText();
		Assert.assertEquals(viewTemplatesTitle, ELEMENT_VIEW_TEMPLATE,ELEMENT_VIEW_TEMPLATE_MSG );
		
		String nameTitle = templatesPage.getNameLabel().getText();
		Assert.assertEquals(nameTitle, ELEMENT_NAME,ELEMENT_NAME_MSG );
		
		String createdDateTitle = templatesPage.getCreatedDateLabel().getText();
		Assert.assertEquals(createdDateTitle, ELEMENT_CREATED_ON,ELEMENT_CREATED_ON_MSG );
		
		String allTemplatesTotal = templatesPage.getTotalTemplatesValueTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(allTemplatesTotal.trim()), ELEMENT_TOTAL_TEMPLATE_VALUE_MSG);
		
		String nameTextFieldValue = templatesPage.getNameTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(nameTextFieldValue.trim()), ELEMENT_NAME_TEXTFIELD_MSG);
		
		String createdOnTextFieldValue = templatesPage.getCreatedDateTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(createdOnTextFieldValue.trim()), ELEMENT_CREATED_ON_TEXTFIELD_MSG);

		//Now click on templates button first in list
		
		templatesPage.getImageTemplateBtns().get(0).click();
		
		//check the title of next page i.e. Raise Planned Work
		String pageTitle = raisedPlannedWorkPage.getRaisePlannedWorkLabel().getText();
		Assert.assertEquals(pageTitle, ELEMENT_RAISEPLAN_WORK_LABEL,ELEMENT_RAISEPLAN_WORK_LABEL_MSG );
		
		String templateTitle = raisedPlannedWorkPage.getTemplateDropDownLabel().getText();
		Assert.assertEquals(templateTitle, ELEMENT_TEMPLATE_DD_LABEL,ELEMENT_TEMPLATE_DD_LABEL_MSG );
		String templateDDValue = raisedPlannedWorkPage.getDropDownsValue().get(ELEMENT_FIRST).getText();
		System.out.println(" Template drop down "+ templateDDValue);
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(templateDDValue.trim()), ELEMENT_TEMPLATE_TF_LABEL_MSG);
		
		String categoryTitle = raisedPlannedWorkPage.getCategoryLabel().getText();
		Assert.assertEquals(categoryTitle, ELEMENT_CATEGORY_DD_LABEL,ELEMENT_CATEGORY_DD_LABEL_MSG );
		String categoryDDValue = raisedPlannedWorkPage.getDropDownsValue().get(ELEMENT_SECOND).getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(categoryDDValue.trim()), ELEMENT_CATEGORY_TF_LABEL_MSG);

		String changeDescTitle = raisedPlannedWorkPage.getChangeDescriptionLabel().getText();
		Assert.assertEquals(changeDescTitle, ELEMENT_CHGDEC_DD_LABEL,ELEMENT_CHGDEC_DD_LABEL_MSG );
		String changeDescDDValue = raisedPlannedWorkPage.getDropDownsValue().get(ELEMENT_THIRD).getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(changeDescDDValue.trim()), ELEMENT_CHGDEC_TF_LABEL_MSG);
		
		String stdRefTitle = raisedPlannedWorkPage.getChangeCatalogeLabel().getText();
		Assert.assertEquals(stdRefTitle, ELEMENT_STDREF_LABEL,ELEMENT_STDREF_LABEL_MSG );
		String stdRefValue = raisedPlannedWorkPage.getChangeCatalogeTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(stdRefValue.trim()), ELEMENT_STDREF_TF_MSG);
		
		String configIDTypeTitle = raisedPlannedWorkPage.getConfigIDTypeLabel().getText();
		Assert.assertEquals(configIDTypeTitle, ELEMENT_CONFGID_LABEL,ELEMENT_CONFGID_LABEL_MSG );
		String configIDTypeValue = raisedPlannedWorkPage.getConfigIdTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(configIDTypeValue.trim()), ELEMENT_CONFGID_TF_MSG);
		
		//Next Page
		raisedPlannedWorkPage.getNextBtn().click();

		String locTier1DDTitle = raisedPlannedWorkPage.getLocationDetailsTier1Label().getText();
		Assert.assertEquals(locTier1DDTitle, ELEMENT_LOCT1_DD_LABEL,ELEMENT_LOCT1_DD_LABEL_MSG );
		String locTier1DDValue = raisedPlannedWorkPage.getDropDownsLOCValue().get(ELEMENT_THIRD).getText();
		System.out.println("locTier1DDValue is "+locTier1DDValue);
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(locTier1DDValue.trim()), ELEMENT_LOCT1_DD_VALUE_MSG);

		String locTier2DDTitle = raisedPlannedWorkPage.getLocationDetailsTier2Label().getText();
		Assert.assertEquals(locTier2DDTitle, ELEMENT_LOCT2_DD_LABEL,ELEMENT_LOCT2_DD_LABEL_MSG );
		String locTier2DDValue = raisedPlannedWorkPage.getDropDownsLOCValue().get(ELEMENT_FIFTH).getText();
		System.out.println("locTier2DDValue is "+locTier2DDValue);
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(locTier2DDValue.trim()), ELEMENT_LOCT2_DD_VALUE_MSG);

		String siteAddTitle = raisedPlannedWorkPage.getSiteAddressLabel().getText();
		Assert.assertEquals(siteAddTitle, ELEMENT_SITEADD_LABEL,ELEMENT_SITEADD_LABEL_MSG );
		String siteAddTFValue = raisedPlannedWorkPage.getSiteAddressTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(siteAddTFValue.trim()), ELEMENT_SITEADD_LABEL_TF_MSG);
		
		//Next Page
		raisedPlannedWorkPage.getNextBtn().click();

		String plannedStartTitle = raisedPlannedWorkPage.getPlannedStartDateLabel().getText();
		Assert.assertEquals(plannedStartTitle, ELEMENT_PLSTART_LABEL,ELEMENT_PLSTART_LABEL_MSG );
		
		String plannedEndTitle = raisedPlannedWorkPage.getPlannedEndDateLabel().getText();
		Assert.assertEquals(plannedEndTitle, ELEMENT_PLEND_LABEL,ELEMENT_PLEND_LABEL_MSG );

		String backoutStartTitle = raisedPlannedWorkPage.getBackOutStartDateLabel().getText();
		Assert.assertEquals(backoutStartTitle, ELEMENT_BACKSTART_LABEL,ELEMENT_BACKSTART_LABEL_MSG );
		
		//Try to move without filling any details
		raisedPlannedWorkPage.getNextBtn().click();
		
		//First for Planned Start Date
		String blankPlannedStartDate = raisedPlannedWorkPage.getErrorSnackbarMessage().getText();
		Assert.assertEquals(blankPlannedStartDate, ERROR_SNACKBAR_PLANNED_START,ERROR_SNACKBAR_PLANNED_START_MSG );
		
		// Handle date selectors 
		
		//Click on Template dropdown and click on Standard SD option
		raisedPlannedWorkPage.getPlannedStartDateSelector().click();
		String timeZoneID = raisedPlannedWorkPage.getZoneGMTBtn().getText(); 
		raisedPlannedWorkPage.getZoneGMTBtn().click();
		Map<String,Integer> dateMap = raisedPlannedWorkPage.timeDateMapAsPerTimezone(timeZoneID);
		System.out.println(" Current day in dd is "+ dateMap.get(ELEMENT_DAY_KEY));
		
		
		int currentDate = dateMap.get(ELEMENT_DAY_KEY).intValue();
		
		//check if we can set date previous to current
		if((currentDate-1) != 0) {
		 raisedPlannedWorkPage.moveToScrollToElement(driver, String.valueOf(currentDate-1)).perform();
		raisedPlannedWorkPage.getOkBtn().click();
		raisedPlannedWorkPage.getOkBtn().click();
		
		//Alert alertBackDate = driver.switchTo().alert();
		String errorMessage = raisedPlannedWorkPage.getInavlalidDateLabel().getText();
		Assert.assertEquals(errorMessage, START_DATE_ERROR_MESSAGE, START_DATE_ERROR_MESSAGE_Label);
		raisedPlannedWorkPage.getOkBtn().click();

		raisedPlannedWorkPage.getPlannedStartDateSelector().click();
		raisedPlannedWorkPage.getZoneGMTBtn().click();
		
		
		//check if we can set date previous to current
		raisedPlannedWorkPage.moveToScrollToElement(driver, String.valueOf(currentDate)).perform();
		raisedPlannedWorkPage.getOkBtn().click();
		raisedPlannedWorkPage.getOkBtn().click();
		
		
		String errorTime = raisedPlannedWorkPage.getInavlalidDateLabel().getText();
		Assert.assertEquals(errorTime, START_DATE_ERROR_MESSAGE, START_DATE_ERROR_MESSAGE_Label);
		raisedPlannedWorkPage.getOkBtn().click();
		raisedPlannedWorkPage.getPlannedStartDateSelector().click();
		raisedPlannedWorkPage.getZoneGMTBtn().click();

		}
		

		//To take care or corner cases as calendar next button is not working so adjusting last month dates			
		if(currentDate  == 30 || currentDate == 31 || currentDate == 28 || currentDate == 29) {
			currentDate = currentDate + 0 ;
		}else {
			currentDate = currentDate + 1;
		}		
						
		raisedPlannedWorkPage.moveToScrollToElement(driver, String.valueOf(currentDate)).perform();
		raisedPlannedWorkPage.getOkBtn().click();
		
		
		//Using other keyboard with edit text to enter time
		raisedPlannedWorkPage.getDateToggleButton().click();
		
		
		
		int hourCurrent = dateMap.get(ELEMENT_HOUR_KEY).intValue();
		int hourToBeSet = hourCurrent + 2;
		System.out.println(" hourToBeSet "+ hourToBeSet);
		
		if(hourToBeSet > 12) {
			hourToBeSet = 1;
		}else if(hourToBeSet == 12) {
			hourToBeSet = 12;
		}
		
		setTimePage.getInPutHourTextField().clear();
		setTimePage.getInPutHourTextField().sendKeys(String.valueOf(hourToBeSet));
		System.out.println(" setTimePage hour "+ setTimePage.getInPutHourTextField().getText());
		
		int minutesCurrent = dateMap.get(ELEMENT_MINUTE_KEY).intValue();
		int minutesToBeSet = minutesCurrent + 40;
		
		if(minutesToBeSet > 60) {
			minutesToBeSet = 40;
		}else if(minutesToBeSet == 60) {
			minutesToBeSet = 50;
		}
		
		setTimePage.getInPutMinuteTextField().clear();
		setTimePage.getInPutMinuteTextField().sendKeys(String.valueOf(minutesToBeSet));
		
		System.out.println(" setTimePage minutes "+ setTimePage.getInPutMinuteTextField().getText());
		String currentAMPMValue = setTimePage.getCurrentAMPMValue().getText();
		setTimePage.getAmPMDropDown().click();		
		
		System.out.println("Current APPM Value is "+currentAMPMValue);
		
		if(currentAMPMValue.equals(ELEMENT_PM)) {
			setTimePage.moveToScrollToElement(driver, ELEMENT_PM);
		}else {
			setTimePage.moveToScrollToElement(driver, ELEMENT_AM);
		}
		
		setTimePage.getOkButton().click();
		String plannedStartTextField = raisedPlannedWorkPage.getPlannedStartTextField().getText();
		System.out.println("plannedStartTextField "+plannedStartTextField);
		
		
		//Now same to be checked for End date selector 
		raisedPlannedWorkPage.getNextBtn().click();
		String blankPlannedEndDate = raisedPlannedWorkPage.getErrorSnackbarMessage().getText();
		Assert.assertEquals(blankPlannedEndDate, ERROR_SNACKBAR_PLANNED_END,ERROR_SNACKBAR_PLANNED_END_MSG );

		
		//for end date check and try to set to previous date 
		if(currentDate-1 != 0) {
		raisedPlannedWorkPage.getPlannedEndDateSelector().click();
		
		raisedPlannedWorkPage.moveToScrollToElement(driver, String.valueOf(currentDate-1)).perform();
		raisedPlannedWorkPage.getOkBtn().click();
		raisedPlannedWorkPage.getOkBtn().click();
		//Alert alertBackDate = driver.switchTo().alert();
		String errorMessageEnd = raisedPlannedWorkPage.getErrorLabel().getText();
		Assert.assertEquals(errorMessageEnd, ERROR_MESSAGE_END_DATE, ERROR_MESSAGE_END_DATE_LABEL);
		raisedPlannedWorkPage.getOkBtn().click();
		String errorMessageEndDate = raisedPlannedWorkPage.getErrorLabel().getText();
		Assert.assertEquals(errorMessageEndDate, ERROR_MESSAGE_END_DATE, ERROR_MESSAGE_END_DATE_LABEL);
		raisedPlannedWorkPage.getOkBtn().click();
		}
		//alertBackDate.accept();
		
		raisedPlannedWorkPage.getPlannedEndDateSelector().click();				
		raisedPlannedWorkPage.moveToScrollToElement(driver, String.valueOf(currentDate)).perform();
		raisedPlannedWorkPage.getOkBtn().click();
		
		raisedPlannedWorkPage.getDateToggleButton().click();
		
		int hourCurrentEnd = dateMap.get(ELEMENT_HOUR_KEY).intValue();
		int hourToBeSetEnd = hourCurrentEnd + 2;
		System.out.println(" hourToBeSetEnd "+ hourToBeSetEnd);
		
		if(hourToBeSet > 12) {
			hourToBeSet = 1;
		}else if(hourToBeSet == 12) {
			hourToBeSet = 12;
		}
		
		setTimePage.getInPutHourTextField().clear();
		setTimePage.getInPutHourTextField().sendKeys(String.valueOf(hourToBeSet));
		System.out.println(" setTimePage hour "+ setTimePage.getInPutHourTextField().getText());
		
		int minutesCurrentEnd = dateMap.get(ELEMENT_MINUTE_KEY).intValue();
		int minutesToBeSetEnd = minutesCurrentEnd + 40;
		
		if(minutesToBeSetEnd > 60) {
			minutesToBeSetEnd = 40;
		}else if(minutesToBeSetEnd == 60) {
			minutesToBeSetEnd = 50;
		}
		
		setTimePage.getInPutMinuteTextField().clear();
		setTimePage.getInPutMinuteTextField().sendKeys(String.valueOf(minutesToBeSetEnd));
		
		System.out.println(" setTimePage minutes "+ setTimePage.getInPutMinuteTextField().getText());
		String currentAMPMValueEnd = setTimePage.getCurrentAMPMValue().getText();
		setTimePage.getAmPMDropDown().click();		
		
		System.out.println("Current APPM Value is "+currentAMPMValue);
		
		if(currentAMPMValueEnd.equals(ELEMENT_PM)) {
			setTimePage.moveToScrollToElement(driver, ELEMENT_PM);
		}else {
			setTimePage.moveToScrollToElement(driver, ELEMENT_AM);
		}
		
		setTimePage.getOkButton().click();
		
		//Move to next Page now
		
		raisedPlannedWorkPage.getNextBtn().click();
		
		//First Alert for Order No
		
		raisedPlannedWorkPage.getNextBtn().click(); //try to move without entering order no
		TestBase.wait(driver, 20);
		Alert alertOrderNo = driver.switchTo().alert();
		String emptyOrderIdLabel = raisePlanWorkWarningAlerts.getEmptyOrderIdLabel().getText();
		Assert.assertEquals(emptyOrderIdLabel, ERROR_MESSAGE_EMPTY_ORDER_ID);		
		alertOrderNo.accept();
		
		raisedPlannedWorkPage.getOrderNumberTextField().sendKeys(orderNumber);
		String orderTextField = raisedPlannedWorkPage.getOrderNumberTextField().getText();
		Assert.assertNotNull(orderTextField, ELEMENT_ORDER_TF_MSG);
		
		
		//First Alert for device id
		raisedPlannedWorkPage.getNextBtn().click(); //try to move without entering device id
		TestBase.wait(driver, 20);
		Alert alertConfigId = driver.switchTo().alert();
		String emptyConfigIdLabel = raisePlanWorkWarningAlerts.getEmptyConfigIdLabel().getText();
		Assert.assertEquals(emptyConfigIdLabel, ERROR_MESSAGE_EMPTY_DEVICE_ID);		
		alertConfigId.accept();	

		
		
		String requesterEmailIdLabelConfirmPage = confirmPage.getRequestorEmailIDLabel().getText();
		Assert.assertEquals(requesterEmailIdLabelConfirmPage,ELEMENT_REQUESTER_EMAIL_ID);
		
		String requesterEmailIdTextFieldConfirmPage = confirmPage.getRequestorEmailIDTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(requesterEmailIdTextFieldConfirmPage.trim()), ELEMENT_REQUESTER_EMAIL_ID_MSG);

		String implementerEmailIdLabelConfirmPage = confirmPage.getImplementerEmailIDLabel().getText();
		Assert.assertEquals(implementerEmailIdLabelConfirmPage,ELEMENT_IMPLEM_EMAIL_ID);
		
		String implementerEmailIdTextFieldConfirmPage = confirmPage.getImplementerEmailIDTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(implementerEmailIdTextFieldConfirmPage.trim()), ELEMENT_IMPLEM_EMAIL_ID_MSG);
		String implementerMobConfirmPage = confirmPage.getImplementerMobileLabel().getText();
		Assert.assertEquals(implementerMobConfirmPage,ELEMENT_IMPLEM_MOBILE);
		
		String implementerMobTextFieldConfirmPage = confirmPage.getImplementerMobileTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(implementerMobTextFieldConfirmPage.trim()), ELEMENT_IMPLEM_MOBILE_MSG);

		raisedPlannedWorkPage.getDeviceIdAddBtn().click();
		String inputIdLabel = raisePlanWorkWarningAlerts.getInputDeviceIdLabel().getText();
		Assert.assertEquals(inputIdLabel, ERROR_MESSAGE_EMPTY_INPUT_IDS);
	
		raisedPlannedWorkPage.getInputTextField().sendKeys(inputTextField);
		raisedPlannedWorkPage.getAddBtnForPopup().click();
		raisedPlannedWorkPage.getNextBtn().click();	

		//Next Page
		String opCatTier1DDTitle = raisedPlannedWorkPage.getOpertaionalCatTier1Label().getText();
		Assert.assertEquals(opCatTier1DDTitle, ELEMENT_OPCATT1_DD_LABEL,ELEMENT_OPCAT1_DD_LABEL_MSG);
		String opCatTier1DDValue = raisedPlannedWorkPage.getDropDownsLOCValue().get(ELEMENT_THIRD).getText();
		System.out.println("opCatTier1DDValue is "+opCatTier1DDValue);
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(opCatTier1DDValue.trim()), ELEMENT_OPCAT1_DD_VALUE_MSG);
		
		String opCatTier2DDTitle = raisedPlannedWorkPage.getOpertaionalCatTier2Label().getText();
		Assert.assertEquals(opCatTier2DDTitle, ELEMENT_OPCATT2_DD_LABEL,ELEMENT_OPCAT2_DD_LABEL_MSG);
		String opCatTier2DDValue = raisedPlannedWorkPage.getDropDownsLOCValue().get(ELEMENT_FIFTH).getText();
		System.out.println("opCatTier2DDValue is "+opCatTier2DDValue);
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(opCatTier2DDValue.trim()), ELEMENT_OPCAT2_DD_VALUE_MSG);

		String opCatTier3DDTitle = raisedPlannedWorkPage.getOpertaionalCatTier3Label().getText();
		Assert.assertEquals(opCatTier3DDTitle, ELEMENT_OPCATT3_DD_LABEL,ELEMENT_OPCAT3_DD_LABEL_MSG);
		String opCatTier3DDValue = raisedPlannedWorkPage.getDropDownsLOCValue().get(ELEMENT_SEVENTH).getText();
		System.out.println("opCatTier1DDValue is "+opCatTier3DDValue);
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(opCatTier3DDValue.trim()), ELEMENT_OPCAT3_DD_VALUE_MSG);
		
		//Click on Next button to view next page
		raisedPlannedWorkPage.getNextBtn().click();	

		//Next Page
		String prodCatTier1DDTitle = raisedPlannedWorkPage.getProductCatTier1Label().getText();
		Assert.assertEquals(prodCatTier1DDTitle, ELEMENT_PRODCATT1_DD_LABEL,ELEMENT_PRODCATT1_DD_LABEL_MSG);
		String prodCatTier1DDValue = raisedPlannedWorkPage.getDropDownsLOCValue().get(ELEMENT_THIRD).getText();
		System.out.println("opCatTier1DDValue is "+opCatTier1DDValue);
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(prodCatTier1DDValue.trim()), ELEMENT_PRODCATT1_DD_VALUE_MSG);
		
		String prodCatTier2DDTitle = raisedPlannedWorkPage.getProductCatTier2Label().getText();
		Assert.assertEquals(prodCatTier2DDTitle, ELEMENT_PRODCATT2_DD_LABEL,ELEMENT_PRODCATT2_DD_LABEL_MSG);
		String prodCatTier2DDValue = raisedPlannedWorkPage.getDropDownsLOCValue().get(ELEMENT_FIFTH).getText();
		System.out.println("opCatTier1DDValue is "+opCatTier2DDValue);
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(prodCatTier2DDValue.trim()), ELEMENT_PRODCATT2_DD_VALUE_MSG);

		String prodCatTier3DDTitle = raisedPlannedWorkPage.getProductCatTier3Label().getText();
		Assert.assertEquals(prodCatTier3DDTitle, ELEMENT_PRODCATT3_DD_LABEL,ELEMENT_PRODCATT3_DD_LABEL_MSG);
		String prodCatTier3DDValue = raisedPlannedWorkPage.getDropDownsLOCValue().get(ELEMENT_SEVENTH).getText();
		System.out.println("opCatTier1DDValue is "+prodCatTier3DDValue);
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(prodCatTier3DDValue.trim()), ELEMENT_PRODCATT3_DD_VALUE_MSG);

		//Now click on Submit and on Next Page just move to Confirm button as this page data is validated in confirmPageTest
		
		raisedPlannedWorkPage.getFinalSubmitButton().click();
		
		//Confirm Page elements
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_FINAL_CONFIRM_BUTTON).perform();	
		
		confirmPage.getOkButton().click();		
		confirmPage.getEnterTemplateNameTextField().sendKeys(templateName);		
		confirmPage.getOkButton().click();		
		confirmPage.getOkButtonForCongratsPopUp().click();	

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
		Thread.sleep(8000);
	}


	
	

}
