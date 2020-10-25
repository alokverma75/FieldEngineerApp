package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
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
	public void startServer() throws IOException {
		TestBase.startAVD();		
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws MalformedURLException, IOException {
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

//	@Test
//	public void endToEndTestForRaisePlanWork() throws MalformedURLException, IOException {
//		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
//		Assert.assertNotNull(landingPage);
//		landingPage.getContinueBtn().click();
//		//plannedWorksPage.getPlannedWorksBtn().click();
//		plannedWorksPage.findAllElementsById(driver, ELEMENT_PLANNED_WORKS_IMAGE_OPTION).get(1).click();
//		
//	}
	
	
	//@Test
	public void validateAllLabelAndTextFields() {
		String pageTitle = plannedWorksPage.getTotalPlannedWorkListLabel().getText();
		Assert.assertEquals(pageTitle, ELEMENT_PLANNED_WORKS_LABEL);
		
		String totalWorksTitle = plannedWorksPage.getTotalPlanWorksLabel().getText();		
		Assert.assertEquals(totalWorksTitle,ELEMENT_TOTAL_PLANNED_WORKS_LABEL );
		
		String totalWorksValue = plannedWorksPage.getTotalPlannedWorks().getText();
		Assert.assertFalse(totalWorksValue.isBlank(), ERROR_MESSAGE_EMPTY_ID);
		
		String ID = plannedWorksPage.getIdTitle().getText();		
		Assert.assertEquals(ID,ELEMENT_PLANNED_WORKS_ID_LABEL );
		
		String idValue = plannedWorksPage.getIdValue().getText();
		
		Integer idValueInt = Integer.parseInt(idValue);
		
		boolean isInt = idValueInt instanceof Integer;
		Assert.assertTrue(isInt, ERROR_MESSAGE_ID_NOT_INTEGER);
		
		Assert.assertFalse(idValue.isBlank(), ERROR_MESSAGE_EMPTY_ID);
		Assert.assertTrue(idValue.length() == ERROR_MESSAGE_ID_FIELD_LENGTH, ERROR_MESSAGE_ID_FIELD_LENGTH_ERROR);		
		
		String startDateLabel = plannedWorksPage.getStartDateTitle().getText();
		Assert.assertEquals(startDateLabel,ELEMENT_PLANNED_WORKS_START_DATE_LABEL );

		String startDateValue = plannedWorksPage.getStartDateValue().getText();
		Assert.assertFalse(startDateValue.isBlank(), ERROR_MESSAGE_EMPTY_START_DATE);

		String endDateLabel = plannedWorksPage.getEndDateTitle().getText();
		Assert.assertEquals(endDateLabel,ELEMENT_PLANNED_WORKS_END_DATE_LABEL );

		String endDateValue = plannedWorksPage.getEndDateValue().getText();
		Assert.assertFalse(endDateValue.isBlank(),ERROR_MESSAGE_EMPTY_END_DATE);
		
		String categoryLabel = plannedWorksPage.getCategoryLabel().getText();
		Assert.assertEquals(categoryLabel,ELEMENT_PLANNED_WORKS_CATEGORY_LABEL );

		String categoryValue = plannedWorksPage.getCategoryTextField().getText();		
		Assert.assertFalse(categoryValue.isBlank(), ERROR_MESSAGE_EMPTY_CATEGORY);
		
		String siebelrefLabel = plannedWorksPage.getSiebelrefLabel().getText();
		Assert.assertEquals(siebelrefLabel,ELEMENT_PLANNED_WORKS_SIEBEL_REF_LABEL);

		String siebelrefValue = plannedWorksPage.getSiebelRefTextField().getText();		
		Assert.assertFalse(siebelrefValue.isBlank(), ERROR_MESSAGE_EMPTY_SIEBEL_REF);
	
		String descriptionLabel = plannedWorksPage.getDescriptionLabel().getText();
		Assert.assertEquals(descriptionLabel,ELEMENT_PLANNED_WORKS_DESCRIPTION_LABEL);

		String descriptionValue = plannedWorksPage.getSiebelRefTextField().getText();		
		Assert.assertFalse(descriptionValue.isBlank(), ERROR_MESSAGE_EMPTY_DESCRIPTION);
		
	}
	
	@Test
	public void testPlannedWorkDetails() {
		plannedWorksPage.getServiceCard().click();
		
		String pageTitle = plannedWorksPage.getPlannedWorksPageTitle().getText();
		Assert.assertEquals(pageTitle, ELEMENT_PLANNED_WORKS_PAGE_TITLE);
		
		
	}


	

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws IOException {
		System.out.println("tearing down");
		// landingPage = null;
		// driver.quit();
		// TestBase.shutDownAVD();
	}

}
