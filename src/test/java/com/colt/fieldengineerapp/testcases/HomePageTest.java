package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LandingPage landingPage;
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest() throws MalformedURLException, IOException{
		super();
			
	}
	
	@BeforeTest(alwaysRun = true)
	public void startServices() throws IOException, InterruptedException {
		System.out.println("Starting Appium == " +this.getClass().getName());
		TestBase.startAppiumServer();
				
	}
		
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws MalformedURLException, IOException, InterruptedException{
		driver = getDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		
	}
	
	@Test
	public void homePageTest() throws MalformedURLException, IOException, InterruptedException{
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.startRecording(driver);
			}
			
		}

		landingPage.getContinueBtn().click();
		//Let page load for sometime and then try to access elements
		Thread.sleep(3000);
		
		String homepagesTitle = homePage.getHomePageTasksTitle().getText();
		Assert.assertEquals(homepagesTitle, ELEMENT_HOMEPAGE_LABEL,ELEMENT_HOMEPAGE_LABEL_MSG );
		
		String refreshTitle = homePage.getRefreshTasksBtn().getText();
		Assert.assertEquals(refreshTitle, ELEMENT_REFRESH_TASKS_TITLE,ELEMENT_REFRESH_TASKS_TITLE_MSG);
		
		String maytasksTitle = homePage.getMyTasksTitle().getText();
		Assert.assertEquals(maytasksTitle, ELEMENT_TASKS_TITLE,ELEMENT_TASKS_TITLE_MSG);

		String mytasksValue = homePage.getMyTasksCount().getText();
		Assert.assertNotNull(mytasksValue, ELEMENT_TASKS_TITLE_VALUE);
		
		String newtasksTitle = homePage.getNewTasksTitle().getText();
		Assert.assertEquals(newtasksTitle, ELEMENT_NEW_TASKS_TITLE,ELEMENT_NEW_TASKS_TITLE_MSG);

		String newtasksValue = homePage.getNewTasksCount().getText();
		Assert.assertNotNull(newtasksValue, ELEMENT_NEW_TASKS_TITLE_VALUE);
		
		String newtasksImageBtn = homePage.getNewTasksImageBtn().getText();
		Assert.assertNotNull(newtasksImageBtn, ELEMENT_NEW_TASKS_IMAGE_BTN_VALUE);

		
		String inProgressTasksTitle = homePage.getInprogressTasksTitle().getText();
		Assert.assertEquals(inProgressTasksTitle, ELEMENT_INPROGRESS_TASKS_TITLE,ELEMENT_INPROGRESS_TASKS_TITLE_MSG);

		String inProgressTasksValue = homePage.getInprogressTasksCount().getText();
		Assert.assertNotNull(inProgressTasksValue, ELEMENT_INPROGRESS_TASKS_TITLE_VALUE);
		
		String inProgressTasksImageBtn = homePage.getInrogressTasksImageBtn().getText();
		Assert.assertNotNull(inProgressTasksImageBtn, ELEMENT_NEW_TASKS_IMAGE_BTN_VALUE);


		String completedTasksTitle = homePage.getCompletedTasksTitle().getText();
		Assert.assertEquals(completedTasksTitle, ELEMENT_COMPLETED_TASKS_TITLE,ELEMENT_COMPLETED_TASKS_TITLE_MSG);

		String completedTasksValue = homePage.getCompletedTasksCount().getText();
		Assert.assertNotNull(completedTasksValue, ELEMENT_COMPLETED_TASKS_TITLE_VALUE);
		
		String completedTasksImageBtn = homePage.getCompletedTasksImageBtn().getText();
		Assert.assertNotNull(completedTasksImageBtn, ELEMENT_COMPLETED_TASKS_IMAGE_BTN_VALUE);
		
		String maintenanceTasksTitle = homePage.getMaintainenaceTasksTitle().getText();
		System.out.println("maintenanceTasksTitle  "+maintenanceTasksTitle);
		Assert.assertEquals(maintenanceTasksTitle.trim(), ELEMENT_MAINTENANCE_TASKS_TITLE,ELEMENT_MAINTENANCE_TASKS_TITLE_MSG);

		String  maintenanceTasksValue = homePage.getMaintainanceTasksCount().getText();
		Assert.assertNotNull(maintenanceTasksValue, ELEMENT_MAINTENANCE_TASKS_TITLE_VALUE);
		
		String  maintenanceTasksImageBtn = homePage.getMaintainenaceTasksImageBtn().getText();
		Assert.assertNotNull(maintenanceTasksImageBtn, ELEMENT_MAINTENANCE_TASKS_IMAGE_BTN_VALUE);

		

		
		

		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
			}
			
		}


	}
	@AfterTest(alwaysRun = true)
	public void tearDown() throws IOException, InterruptedException {
		System.out.println("Tearing  down == " +this.getClass().getName());
		TestBase.shutDownAVD();
		Thread.sleep(3000);
		//System.out.println("Tearing  down == " +this.getClass().getName());
		//TestBase.stopAppiumServer();
		//Thread.sleep(5000);
	}


	
	

}
