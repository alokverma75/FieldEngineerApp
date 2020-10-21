package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.AllTasksListPage;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;
import com.colt.fieldengineerapp.pages.SingleTaskDetailsPage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EndToEndTest extends TestBase {
	
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
	
	public EndToEndTest() throws MalformedURLException, IOException{
		super();
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws MalformedURLException, IOException{
		driver = getDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		allTasksListPage = new AllTasksListPage(driver);
		singleTaskDetailsPage = new SingleTaskDetailsPage(driver);
		
	}
	
	
	@Test
	public void endToEndTestTillSingleTaskView() throws MalformedURLException, IOException{				
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		landingPage.getContinueBtn().click();
		homePage.getViewAllTasksBtn().click();
		homePage.getAllowBtn().click();
		allTasksListPage.getViewTaskBtn().click();
		String label = singleTaskDetailsPage.getOrderNumberLabel().getText();
		System.out.println("Label is "+label);
//		String labelText = singleTaskDetailsPage.getOrderNumberTextField().getText();
//		System.out.println(" Label Text Field "+ labelText);
		
		listofTextView = singleTaskDetailsPage.getTextElementsByResourceId(driver, ELEMENT_TV_VALUE);
		for(int i = 0; i < listofTextView.size(); i++) {
			System.out.println(" element at" + i+ "th Index is "+ listofTextView.get(i).getText());			
		}		
		TouchAction<?> action = new TouchAction<>(driver);		
		action.tap(TestBase.geTapOptionForScroll(driver,ELEMENT_ATTRIBUTE_SCROLL_VIEW, ELEMENT_COOP_TECH_MAIL)).perform();
		
		String labelCustomer = singleTaskDetailsPage.getCoopTechEmailLabel().getText();
		System.out.println("Label is "+labelCustomer);
		
		listofTextView1 = singleTaskDetailsPage.getTextElementsByResourceId(driver, ELEMENT_TV_VALUE);
		for(int i = 0; i < listofTextView1.size(); i++) {
			System.out.println(" element at" + i+ "th Index is "+ listofTextView1.get(i).getText());			
		}	
		
	}	
	
	
	
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() throws IOException{
		System.out.println("tearing down");
		//landingPage = null;
		//driver.quit();
		//TestBase.shutDownAVD();
	}

}
