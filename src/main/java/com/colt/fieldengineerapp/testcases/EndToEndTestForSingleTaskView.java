package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.AllTasksListPage;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;
import com.colt.fieldengineerapp.pages.SingleTaskDetailsPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EndToEndTestForSingleTaskView extends TestBase {

	LoginPage loginPage;
	LandingPage landingPage;
	HomePage homePage;
	AllTasksListPage allTasksListPage;
	SingleTaskDetailsPage singleTaskDetailsPage;
	AndroidDriver<AndroidElement> driver;
	List<AndroidElement> listofTextView;
	List<AndroidElement> listofTextView1;
	List<AndroidElement> listofTextView2;
	List<AndroidElement> listofTextView3;
	List<AndroidElement> listofTextView4;
	List<AndroidElement> listofTextView5;

	public EndToEndTestForSingleTaskView() throws MalformedURLException, IOException {
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
		allTasksListPage = new AllTasksListPage(driver);
		singleTaskDetailsPage = new SingleTaskDetailsPage(driver);

	}

	@Test
	public void endToEndTestTillSingleTaskView() throws MalformedURLException, IOException {
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		landingPage.getContinueBtn().click();
		homePage.getViewAllTasksBtn().click();
		homePage.getAllowBtn().click();
		allTasksListPage.getViewTaskBtn().click();
		String label = singleTaskDetailsPage.getOrderNumberLabel().getText();
		System.out.println("Label is " + label);

		listofTextView = singleTaskDetailsPage.getTextElementsByResourceId(driver, ELEMENT_TV_VALUE);
		for (int i = 0; i < listofTextView.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView.get(i).getText());
		}

		// ScrollTo Job status
		//singleTaskDetailsPage.moveToScrollToElement(driver, ELEMENT_JOB_STATUS).perform();

		//String labelCustomer = singleTaskDetailsPage.getJobStatusLabel().getText();
		
		String labelJobStatus = singleTaskDetailsPage.moveToElement(driver, ELEMENT_JOB_STATUS).getText();
		System.out.println("Label is " + labelJobStatus);

		listofTextView1 = singleTaskDetailsPage.getTextElementsByResourceId(driver, ELEMENT_TV_VALUE);
		for (int i = 0; i < listofTextView1.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView1.get(i).getText());
		}

		// ScrollTo PLanned Start Date
		//singleTaskDetailsPage.moveToScrollToElement(driver, ELEMENT_PLANNED_START_DATE).perform();

		//String labelPlannedStartDate = singleTaskDetailsPage.getPlannedStartLabel().getText();
		String labelPlannedStartDate = singleTaskDetailsPage.moveToElement(driver, ELEMENT_PLANNED_START_DATE).getText();
		System.out.println("Label is " + labelPlannedStartDate);

		listofTextView1 = singleTaskDetailsPage.getTextElementsByResourceId(driver, ELEMENT_TV_VALUE);
		for (int i = 0; i < listofTextView1.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView1.get(i).getText());
		}
		
		// ScrollTo CPD
		//singleTaskDetailsPage.moveToScrollToElement(driver, ELEMENT_CPD).perform();

		//String labelCPD = singleTaskDetailsPage.getCpdLabel().getText();
		String labelCPD = singleTaskDetailsPage.moveToElement(driver, ELEMENT_CPD).getText();
		System.out.println("Label is " + labelCPD);

		listofTextView1 = singleTaskDetailsPage.getTextElementsByResourceId(driver, ELEMENT_TV_VALUE);
		for (int i = 0; i < listofTextView1.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView1.get(i).getText());
		}

		// ScrollTo Job Remarks
		//singleTaskDetailsPage.moveToScrollToElement(driver, ELEMENT_JOB_REMARKS).perform();

		//String labelJobRemarks = singleTaskDetailsPage.getJobRemarksLabel().getText();
		String labelJobRemarks =  singleTaskDetailsPage.moveToElement(driver, ELEMENT_CPD).getText();
		System.out.println("Label is " + labelJobRemarks);

		listofTextView1 = singleTaskDetailsPage.getTextElementsByResourceId(driver, ELEMENT_TV_VALUE);
		for (int i = 0; i < listofTextView1.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView1.get(i).getText());
		}


		// Now scroll to end element and capture values of all elements on screen view

		//singleTaskDetailsPage.moveToScrollToElement(driver, ELEMENT_COOP_TECH_MAIL).perform();

		//String labelCoopTech = singleTaskDetailsPage.getCoopTechEmailLabel().getText();
		
		String labelCoopTech = singleTaskDetailsPage.moveToElement(driver, ELEMENT_COOP_TECH_MAIL).getText();
		System.out.println("Label is " + labelCoopTech);

		listofTextView1 = singleTaskDetailsPage.getTextElementsByResourceId(driver, ELEMENT_TV_VALUE);
		for (int i = 0; i < listofTextView1.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView1.get(i).getText());
		}

	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws IOException {
		System.out.println("tearing down");
		// landingPage = null;
		// driver.quit();
		// TestBase.shutDownAVD();
	}

}
