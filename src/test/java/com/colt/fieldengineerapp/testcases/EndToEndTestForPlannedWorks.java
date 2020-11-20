package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.ConfirmPage;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;
import com.colt.fieldengineerapp.pages.PlannedWorksPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EndToEndTestForPlannedWorks extends TestBase {

	LoginPage loginPage;
	LandingPage landingPage;
	HomePage homePage;
	PlannedWorksPage plannedWorksPage;
	AndroidDriver<AndroidElement> driver;
	ConfirmPage confirmPage;
	List<AndroidElement> listofTextView;


	public EndToEndTestForPlannedWorks() throws MalformedURLException, IOException {
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
	public void setUp() throws MalformedURLException, IOException, InterruptedException {
		driver = getDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		plannedWorksPage = new PlannedWorksPage(driver);
		confirmPage = new ConfirmPage(driver);
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		landingPage.getContinueBtn().click();
		//plannedWorksPage.getPlannedWorksBtn().click();
		plannedWorksPage.findAllElementsById(driver, ELEMENT_PLANNED_WORKS_IMAGE_OPTION).get(1).click();

	}


	@Test
	public void validateAllLabelAndTextFields() throws IOException {

		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.startRecording(driver);
			}
			
		}
		
		String pageTitle = plannedWorksPage.getTotalPlannedWorkListLabel().getText();
		Assert.assertEquals(pageTitle, ELEMENT_PLANNED_WORKS_LABEL);
		
		String totalWorksTitle = plannedWorksPage.getTotalPlanWorksLabel().getText();		
		Assert.assertEquals(totalWorksTitle,ELEMENT_TOTAL_PLANNED_WORKS_LABEL );
		
		String totalWorksValue = plannedWorksPage.getTotalPlannedWorks().getText();
		Assert.assertFalse(totalWorksValue.equals(""), ERROR_MESSAGE_EMPTY_ID);
		
		String ID = plannedWorksPage.getIdTitle().getText();		
		Assert.assertEquals(ID,ELEMENT_PLANNED_WORKS_ID_LABEL );
		
		String idValue = plannedWorksPage.getIdValue().getText();
		
		Integer idValueInt = Integer.parseInt(idValue);
		
		boolean isInt = idValueInt instanceof Integer;
		Assert.assertTrue(isInt, ERROR_MESSAGE_ID_NOT_INTEGER);
		
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(idValue), ERROR_MESSAGE_EMPTY_ID);
		Assert.assertTrue(idValue.length() == ERROR_MESSAGE_ID_FIELD_LENGTH, ERROR_MESSAGE_ID_FIELD_LENGTH_ERROR);		
		
		String startDateLabel = plannedWorksPage.getStartDateTitle().getText();
		Assert.assertEquals(startDateLabel,ELEMENT_PLANNED_WORKS_START_DATE_LABEL );

		String startDateValue = plannedWorksPage.getStartDateValue().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(startDateValue), ERROR_MESSAGE_EMPTY_START_DATE);

		String endDateLabel = plannedWorksPage.getEndDateTitle().getText();
		Assert.assertEquals(endDateLabel,ELEMENT_PLANNED_WORKS_END_DATE_LABEL );

		String endDateValue = plannedWorksPage.getEndDateValue().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(endDateValue),ERROR_MESSAGE_EMPTY_END_DATE);
		
		String categoryLabel = plannedWorksPage.getCategoryLabel().getText();
		Assert.assertEquals(categoryLabel,ELEMENT_PLANNED_WORKS_CATEGORY_LABEL );

		String categoryValue = plannedWorksPage.getCategoryTextField().getText();		
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(categoryValue), ERROR_MESSAGE_EMPTY_CATEGORY_TEXT_FIELD);
		
		String siebelrefLabel = plannedWorksPage.getSiebelrefLabel().getText();
		Assert.assertEquals(siebelrefLabel,ELEMENT_PLANNED_WORKS_SIEBEL_REF_LABEL);

		String siebelrefValue = plannedWorksPage.getSiebelRefTextField().getText();		
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(siebelrefValue), ERROR_MESSAGE_EMPTY_SIEBEL_REF);
	
		String descriptionLabel = plannedWorksPage.getDescriptionLabel().getText();
		Assert.assertEquals(descriptionLabel,ELEMENT_PLANNED_WORKS_DESCRIPTION_LABEL);

		String descriptionValue = plannedWorksPage.getSiebelRefTextField().getText();		
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(descriptionValue), ERROR_MESSAGE_EMPTY_DESCRIPTION);
		
		//Check all data on next page which are same as Confirm Page:
		plannedWorksPage.getServiceCard().click();
		
		String templateLabel = confirmPage.getTemplateLabel().getText();
		Assert.assertEquals(templateLabel,ELEMENT_TEMPLATE);
		
		String templateTextField = confirmPage.getTemplateTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(templateTextField.trim()), ELEMENT_TEMPLATE_MSG);
		
		String categoryLabelConfirmPage = confirmPage.getCategoryLabel().getText();
		Assert.assertEquals(categoryLabelConfirmPage,ELEMENT_CATEGORY);
		
		String categoryTextFieldConfirmPage = confirmPage.getCategoryLabel().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(categoryTextFieldConfirmPage.trim()), ELEMENT_CATEGORY_MSG);
		
		String changeDescriptionLabelConfirmPage = confirmPage.getChangeDescriptionLabel().getText();
		Assert.assertEquals(changeDescriptionLabelConfirmPage,ELEMENT_CHANGE_DESCRIPTION);
		
		String changeDescriptionTextFieldConfirmPage = confirmPage.getChangeDescriptionTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(changeDescriptionTextFieldConfirmPage.trim()), ELEMENT_CHANGE_DESCRIPTION_MSG);

		String standardRefLabelConfirmPage = confirmPage.getStandardRefChangeCatLabel().getText();
		Assert.assertEquals(standardRefLabelConfirmPage,ELEMENT_STANDARD_REF);
		
		String standardRefTextFieldConfirmPage = confirmPage.getStandardRefChangeCatTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(standardRefTextFieldConfirmPage.trim()), ELEMENT_STANDARD_REF_MSG);

		String configIdTypeLabelConfirmPage = confirmPage.getConfigurationIDTypeLabel().getText();
		Assert.assertEquals(configIdTypeLabelConfirmPage,ELEMENT_CONFIG_ID_TYPE);
		
		String configIdTypeTextFieldConfirmPage = confirmPage.getConfigurationIDTypeTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(configIdTypeTextFieldConfirmPage.trim()), ELEMENT_CONFIG_ID_TYPE_MSG);
		
		String locTier1LabelConfirmPage = confirmPage.getLocationDetailsTier1Label().getText();
		Assert.assertEquals(locTier1LabelConfirmPage,ELEMENT_LOC_TIER1);
		
		String locTier1TextFieldConfirmPage = confirmPage.getLocationDetailsTier1TextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(locTier1TextFieldConfirmPage.trim()), ELEMENT_LOC_TIER1_MSG);
		
		
		String locTier2LabelConfirmPage = confirmPage.getLocationDetailsTier2Label().getText();
		Assert.assertEquals(locTier2LabelConfirmPage,ELEMENT_LOC_TIER2);
		
		String locTier2TextFieldConfirmPage = confirmPage.getLocationDetailsTier2TextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(locTier2TextFieldConfirmPage.trim()), ELEMENT_LOC_TIER2_MSG);

		String siteAddLabelConfirmPage = confirmPage.getSiteAddressLabel().getText();
		Assert.assertEquals(siteAddLabelConfirmPage,ELEMENT_SITE_ADD);
		
		String siteAddTextFieldConfirmPage = confirmPage.getSiteAddressTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(siteAddTextFieldConfirmPage.trim()), ELEMENT_SITE_ADD_MSG);
		
		//scroll to next page starting from Planned start date
		String plannedStartLabelConfirmPage = confirmPage.getPlannedStartLabel().getText();
		Assert.assertEquals(plannedStartLabelConfirmPage,ELEMENT_PLANNED_START);		


		//String plannedEndLabelConfirmPage = confirmPage.getPlannedEndLabel().getText();
		String plannedEndLabelConfirmPage = confirmPage.scrollToElement(driver, ELEMENT_PLANNED_END).getText();
		Assert.assertEquals(plannedEndLabelConfirmPage,ELEMENT_PLANNED_END);
		
		// This is checked after scroll into Planned End and this is visible
		String plannedStartTextFieldConfirmPage = confirmPage.getPlannedStartTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(plannedStartTextFieldConfirmPage.trim()), ELEMENT_PLANNED_START_MSG);

		
		String plannedEndTextFieldConfirmPage = confirmPage.getPlannedEndTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(plannedEndTextFieldConfirmPage.trim()), ELEMENT_PLANNED_END_MSG);

		String backoutStartLabelConfirmPage = confirmPage.getBackoutStartLabel().getText();
		Assert.assertEquals(backoutStartLabelConfirmPage,ELEMENT_BACKOUT_START);
		
		String backoutStartTextFieldConfirmPage = confirmPage.getBackoutStartTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(backoutStartTextFieldConfirmPage.trim()), ELEMENT_BACKOUT_START_MSG);

		String orderNoLabelConfirmPage = confirmPage.getOrderNoLabel().getText();
		Assert.assertEquals(orderNoLabelConfirmPage,ELEMENT_ORDER_NO);
		
		String orderNoTextFieldConfirmPage = confirmPage.getOrderNoTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(orderNoTextFieldConfirmPage.trim()), ELEMENT_ORDER_NO_MSG);

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

		
		String configIdLabelConfirmPage = confirmPage.getConfigurationIDLabel().getText();
		Assert.assertEquals(configIdLabelConfirmPage,ELEMENT_CONFIG_ID);
		
		String configIdTextFieldConfirmPage = confirmPage.getConfigurationIDTextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(configIdTextFieldConfirmPage.trim()), ELEMENT_CONFIG_ID_MSG);

		
		String opCatTier1LabelConfirmPage = confirmPage.getOperationalCatTier1Label().getText();
		Assert.assertEquals(opCatTier1LabelConfirmPage,ELEMENT_OP_CAT_TIER1);
		
		String opCatTier1TextFieldConfirmPage = confirmPage.getOperationalCatTier1TextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(opCatTier1TextFieldConfirmPage.trim()), ELEMENT_OP_CAT_TIER1_MSG);
		

		String opCatTier3LabelConfirmPage = confirmPage.scrollToElement(driver, ELEMENT_OP_CAT_TIER3).getText();
		Assert.assertEquals(opCatTier3LabelConfirmPage,ELEMENT_OP_CAT_TIER3);
		
		String opCatTier3TextFieldConfirmPage = confirmPage.getOperationalCatTier3TextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(opCatTier3TextFieldConfirmPage.trim()), ELEMENT_OP_CAT_TIER3_MSG);

		String prodCatTier1LabelConfirmPage = confirmPage.getProductTier1Label().getText();
		Assert.assertEquals(prodCatTier1LabelConfirmPage,ELEMENT_PROD_CAT1);
		
		String prodCatTier1TextFieldConfirmPage = confirmPage.getOperationalCatTier1TextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(prodCatTier1TextFieldConfirmPage.trim()), ELEMENT_PROD_CAT1_MSG);

		String prodCatTier2LabelConfirmPage = confirmPage.getProductTier2Label().getText();
		Assert.assertEquals(prodCatTier2LabelConfirmPage,ELEMENT_PROD_CAT2);
		
		String prodCatTier2TextFieldConfirmPage = confirmPage.getOperationalCatTier2TextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(prodCatTier2TextFieldConfirmPage.trim()), ELEMENT_PROD_CAT2_MSG);

		String prodCatTier3LabelConfirmPage = confirmPage.getProductTier3Label().getText();
		Assert.assertEquals(prodCatTier3LabelConfirmPage,ELEMENT_PROD_CAT3);
		
		String prodCatTier3TextFieldConfirmPage = confirmPage.scrollToElement(driver, ELEMENT_PROD_CAT3).getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(prodCatTier3TextFieldConfirmPage.trim()), ELEMENT_PROD_CAT3_MSG);

		//check pending elements
		
		String opCatTier2LabelConfirmPage = confirmPage.getOperationalCatTier2Label().getText();
		Assert.assertEquals(opCatTier2LabelConfirmPage,ELEMENT_OP_CAT_TIER2);
		
		String opCatTier2TextFieldConfirmPage = confirmPage.getOperationalCatTier2TextField().getText();
		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(opCatTier2TextFieldConfirmPage.trim()), ELEMENT_OP_CAT_TIER2_MSG);
		



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
