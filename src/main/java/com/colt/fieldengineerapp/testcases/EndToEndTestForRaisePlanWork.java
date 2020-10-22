package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;
import com.colt.fieldengineerapp.pages.RaisedPlanWorkPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EndToEndTestForRaisePlanWork extends TestBase {

	LoginPage loginPage;
	LandingPage landingPage;
	HomePage homePage;
	RaisedPlanWorkPage raisedPlannedWorkPage;
	AndroidDriver<AndroidElement> driver;
	List<AndroidElement> listofTextView;


	public EndToEndTestForRaisePlanWork() throws MalformedURLException, IOException {
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

	}

	@Test
	public void endToEndTestForRaisePlanWork() throws MalformedURLException, IOException {
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		landingPage.getContinueBtn().click();
		homePage.getRaisePlanWork().click();
		
		String label = raisedPlannedWorkPage.getTemplateLabel().getText();
		System.out.println("Label is " + label);
		
		raisedPlannedWorkPage.getTemplateDropDown().click();
		raisedPlannedWorkPage.moveToScrollToElement(driver, ELEMENT_TEMPLATE_DROPDOWN_1).perform();
		
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
		
	}

	

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws IOException {
		System.out.println("tearing down");
		// landingPage = null;
		// driver.quit();
		// TestBase.shutDownAVD();
	}

}
