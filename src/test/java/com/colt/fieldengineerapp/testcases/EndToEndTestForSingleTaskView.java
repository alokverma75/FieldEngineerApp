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


	public EndToEndTestForSingleTaskView() throws MalformedURLException, IOException {
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
		allTasksListPage = new AllTasksListPage(driver);
		singleTaskDetailsPage = new SingleTaskDetailsPage(driver);
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		landingPage.getContinueBtn().click();
		homePage.getViewAllTasksBtn().click();
		allTasksListPage.getViewTaskBtn().click();

	}

	@Test
	public void endToEndTestTillSingleTaskView() throws MalformedURLException, IOException {
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.startRecording(driver);
			}
			
		}
		String orderLabel = singleTaskDetailsPage.getOrderNumberLabel().getText();
		Assert.assertEquals(orderLabel,ELEMENT_ORDER_NUMBER_TITLE,ELEMENT_ORDER_NUMBER_TITLE_MSG);
		

		listofTextView = singleTaskDetailsPage.getTextFieldValue();
		for (int i = 0; i < listofTextView.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView.get(i).getText());
		}

		// ScrollTo Job status kept as reference as both methods will work
		String labelJobStatus = singleTaskDetailsPage.scrollToElement(driver, ELEMENT_JOB_STATUS).getText();
		System.out.println("Label is " + labelJobStatus);

		listofTextView = singleTaskDetailsPage.getTextFieldValue();
		for (int i = 0; i < listofTextView.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView.get(i).getText());
		}

		// ScrollTo PLanned Start Date
		String labelPlannedStartDate = singleTaskDetailsPage.scrollToElement(driver, ELEMENT_PLANNED_START_DATE).getText();
		System.out.println("Label is " + labelPlannedStartDate);

		listofTextView = singleTaskDetailsPage.getTextFieldValue();
		for (int i = 0; i < listofTextView.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView.get(i).getText());
		}
		
		// ScrollTo CPD
		String labelCPD = singleTaskDetailsPage.scrollToElement(driver, ELEMENT_CPD).getText();
		System.out.println("Label is " + labelCPD);

		listofTextView = singleTaskDetailsPage.getTextFieldValue();
		for (int i = 0; i < listofTextView.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView.get(i).getText());
		}

		// ScrollTo Job Remarks
		String labelJobRemarks =  singleTaskDetailsPage.scrollToElement(driver, ELEMENT_JOB_REMARKS).getText();
		System.out.println("Label is " + labelJobRemarks);

		listofTextView = singleTaskDetailsPage.getTextFieldValue();
		for (int i = 0; i < listofTextView.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView.get(i).getText());
		}


		// Now scroll to end element and capture values of all elements on screen view 

		String labelCoopTech = singleTaskDetailsPage.scrollToElement(driver, ELEMENT_COOP_TECH_MAIL).getText();
		System.out.println("Label is " + labelCoopTech);

		listofTextView = singleTaskDetailsPage.getTextFieldValue();
		for (int i = 0; i < listofTextView.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView.get(i).getText());
		}
		
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
			}
			
		}

	}
	
	//@Test
	public void testNonNullJobIdField() throws IOException {
		if(prop.getProperty("recordingNeeded").equals("true")) {
			TestBase.startRecording(driver);
			}
		String jobID = singleTaskDetailsPage.scrollToElement(driver, ELEMENT_JOB_ID).getText();
		System.out.println("Label is " + jobID);

		listofTextView = singleTaskDetailsPage.getTextFieldValue();
		System.out.println(" Size of list on scroll to Job ID "+ listofTextView.size());
		for (int i = 0; i < listofTextView.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView.get(i).getText());
		}
		String jobIDTextField = listofTextView.get(3).getText();		
		Assert.assertFalse(jobIDTextField.equals(""),ERROR_MESSAGE_EMPTY_JOB_ID);
		if(prop.getProperty("recordingNeeded").equals("true")) {
			TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
		}
		
	}
	
	//@Test
	public void testNonNullActivityIdField() throws IOException {
		if(prop.getProperty("recordingNeeded").equals("true")) {
			TestBase.startRecording(driver);
			}
		String activityID = singleTaskDetailsPage.scrollToElement(driver, ELEMENT_Activity_ID).getText();
		System.out.println("Label is " + activityID);

		listofTextView = singleTaskDetailsPage.getTextFieldValue();
		System.out.println(" Size of list on scroll to Job ID "+ listofTextView.size());
		for (int i = 0; i < listofTextView.size(); i++) {
			System.out.println(" element at" + i + "th Index is " + listofTextView.get(i).getText());
		}
		String jobIDTextField = listofTextView.get(3).getText();		
		Assert.assertFalse(jobIDTextField.equals(""),ERROR_MESSAGE_EMPTY_ACTIVITY_ID);
		if(prop.getProperty("recordingNeeded").equals("true")) {
			TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
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
