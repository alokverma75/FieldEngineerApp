package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.ActionsPage;
import com.colt.fieldengineerapp.pages.AllTasksListPage;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;
import com.colt.fieldengineerapp.pages.SetTimePage;
import com.colt.fieldengineerapp.pages.SingleTaskDetailsPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EndToEndActionsPageTest extends TestBase {

	LoginPage loginPage;
	LandingPage landingPage;
	HomePage homePage;
	AllTasksListPage allTasksListPage;
	SingleTaskDetailsPage singleTaskDetailsPage;
	ActionsPage actionsPage;
	SetTimePage setTimePage;
	AndroidDriver<AndroidElement> driver;
	List<AndroidElement> listofTextView;


	public EndToEndActionsPageTest() throws MalformedURLException, IOException {
		super();

	}
	
	@BeforeTest(alwaysRun = true)
	public void startServices() throws IOException, InterruptedException {
		TestBase.startAVD();
		Thread.sleep(20000);
		TestBase.startAppiumServer();
				
	}


	@BeforeMethod(alwaysRun = true)
	public void setUp() throws MalformedURLException, IOException, InterruptedException {
		driver = getDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		actionsPage = new ActionsPage(driver);
		setTimePage = new SetTimePage(driver);
		allTasksListPage = new AllTasksListPage(driver);
		singleTaskDetailsPage = new SingleTaskDetailsPage(driver);
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		landingPage.getContinueBtn().click();
		homePage.getViewAllTasksBtn().click();
		allTasksListPage.getViewTaskBtn().click();

	}


	
	@Test
	public void testNonNullJobRemarksdField() throws InterruptedException, IOException {
		if(prop.getProperty("recordingNeeded").equals("true")) {
			TestBase.startRecording(driver);
			}
		//singleTaskDetailsPage.scrollToElement(driver, ELEMENT_JOB_REMARKS);
  	    singleTaskDetailsPage.getOpenActionsBtn().click();  	    
  	    actionsPage.getEstimatedTimeToReachButton().click();
  	    setTimePage.getDateToggleButton().click();
  	    
  	    //actionsPage.getHourActionSwipe(driver, ELEMENT_CLOCK_DIGIT_HOUR_SEVEN_END);
  	   //actionsPage.getMinuteActionSwipeTo(driver, ELEMENT_CLOCK_MINUTE_TWENTY_END);
  	    Map<String,Integer> dateMap = actionsPage.timeDateMapAsPerTimezone("BST");
		System.out.println(" Current day in dd is "+ dateMap.get(ELEMENT_DAY_KEY));
		
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
		if(prop.getProperty("recordingNeeded").equals("true")) {
			TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
		}
		
		}

	@AfterTest(alwaysRun = true)
	public void tearDown() throws IOException, InterruptedException {
		System.out.println("tearing down");
		TestBase.shutDownAVD();
		Thread.sleep(6000);
		TestBase.stopAppiumServer();
		Thread.sleep(10000);
	}

}
