package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.ActionsPage;
import com.colt.fieldengineerapp.pages.AddAttachmentsPage;
import com.colt.fieldengineerapp.pages.AddEditDocument;
import com.colt.fieldengineerapp.pages.AddEditImage;
import com.colt.fieldengineerapp.pages.AllTasksListPage;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.JobStatusPage;
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
	JobStatusPage jobstatusPage;
	AndroidDriver<AndroidElement> driver;
	AddAttachmentsPage addAttachmentsPage;
	AddEditImage addEditImage;
	AddEditDocument addEditDocument;
	
	
	SoftAssert softAssert;
	List<AndroidElement> listofTextView;


	public EndToEndActionsPageTest() throws MalformedURLException, IOException {
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
		actionsPage = new ActionsPage(driver);
		setTimePage = new SetTimePage(driver);
		jobstatusPage = new JobStatusPage(driver);
		allTasksListPage = new AllTasksListPage(driver);
		singleTaskDetailsPage = new SingleTaskDetailsPage(driver);
		addAttachmentsPage = new AddAttachmentsPage(driver);
		addEditImage = new AddEditImage(driver);
		addEditDocument = new AddEditDocument(driver);
		softAssert = new SoftAssert();
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		landingPage.getContinueBtn().click();
		Thread.sleep(3000);
	}
	
	@Test
	public void testActionsPageNew() throws InterruptedException, IOException {
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.startRecording(driver);
			}
			
		}
		homePage.getNewTasksImageBtn().click();
			
		try {
		allTasksListPage.moveToScrollToElement(driver, ELEMENT_NEW_TASK_FIRST);
		}catch(NoSuchElementException e) {
			
			//No new element found so test case can't be executed
			homePage.getBackButton().click();
			return;
		}
  	    singleTaskDetailsPage.getOpenActionsBtn().click();
 	    
  	    String actionsLabel = actionsPage.getActionsLabel().getText();
  	    softAssert.assertFalse(actionsLabel == null && ELEMENT_EMPTY_STRING.equals(actionsLabel), ELEMENT_ACTIONS_TITLE_VALUE);
  	    softAssert.assertEquals(actionsLabel, ELEMENT_ACTIONS_TITLE, ELEMENT_ACTIONS_TITLE_MSG);
  	    
 	    String exptectedTimeLabel = actionsPage.getExpectedTimeToReachLabel().getText();
  	    softAssert.assertFalse(exptectedTimeLabel == null && ELEMENT_EMPTY_STRING.equals(exptectedTimeLabel), ELEMENT_EXPECTED_TIME_TITLE_VALUE);
  	    softAssert.assertEquals(exptectedTimeLabel, ELEMENT_EXPECTED_TIME_TITLE, ELEMENT_EXPECTED_TIME_TITLE_MSG);
  	    
	    String startTravelLabel = actionsPage.getStartTimeToTravelLabel().getText();
  	    softAssert.assertFalse(startTravelLabel == null && ELEMENT_EMPTY_STRING.equals(startTravelLabel), ELEMENT_START_TIME_TITLE_VALUE);
  	    softAssert.assertEquals(startTravelLabel, ELEMENT_START_TIME_TITLE, ELEMENT_START_TIME_TITLE_MSG);

	    String reachedSiteLabel = actionsPage.getReachedSiteLabel().getText();
  	    softAssert.assertFalse(reachedSiteLabel == null && ELEMENT_EMPTY_STRING.equals(reachedSiteLabel), ELEMENT_REACHED_SITE_TITLE_VALUE);
  	    softAssert.assertEquals(reachedSiteLabel, ELEMENT_REACHED_SITE_TITLE, ELEMENT_REACHED_SITE_TITLE_MSG);
  	    
	    String addAttachmentsLabel = actionsPage.getAddAttachmentsLabel().getText();
  	    softAssert.assertFalse(addAttachmentsLabel == null && ELEMENT_EMPTY_STRING.equals(addAttachmentsLabel), ELEMENT_ADD_ATTACHMENTS_TITLE_VALUE);
  	    softAssert.assertEquals(addAttachmentsLabel, ELEMENT_ADD_ATTACHMENTS_TITLE, ELEMENT_ADD_ATTACHMENTS_TITLE_MSG);
  	    
	    String closureNotesLabel = actionsPage.getClosureNotesLabel().getText();
  	    softAssert.assertFalse(closureNotesLabel == null && ELEMENT_EMPTY_STRING.equals(closureNotesLabel), ELEMENT_CLOSURE_NOTES_TITLE_VALUE);
  	    softAssert.assertEquals(closureNotesLabel, ELEMENT_CLOSURE_NOTES_TITLE, ELEMENT_CLOSURE_NOTES_TITLE_MSG);

	    String leftSiteLabel = actionsPage.getLeftSitesLabel().getText();
  	    softAssert.assertFalse(leftSiteLabel == null && ELEMENT_EMPTY_STRING.equals(leftSiteLabel), ELEMENT_LEFT_SITE_TITLE_VALUE);
  	    softAssert.assertEquals(leftSiteLabel, ELEMENT_LEFT_SITE_TITLE, ELEMENT_LEFT_SITE_TITLE_MSG);

  	    actionsPage.getEstimatedTimeToReachButton().click();
  	    setTimePage.getDateToggleButton().click();
  	    
  	    //Try to set incorrect time say 1 AM
  	    setTimePage.getInPutHourTextField().clear();
		setTimePage.getInPutHourTextField().sendKeys(String.valueOf(ELEMENT_SECOND));
		String currentAMPMValueInitial = setTimePage.getCurrentAMPMValue().getText();
		setTimePage.getAmPMDropDown().click();
		
		System.out.println("Current APPM Value is "+currentAMPMValueInitial);
		
		if(currentAMPMValueInitial.equals(ELEMENT_PM)) {
			setTimePage.moveToScrollToElement(driver, ELEMENT_AM);
		}else {
			setTimePage.moveToScrollToElement(driver, ELEMENT_PM);
		}
		
		setTimePage.getOkButton().click();
		
		String enterCorrectTimeLabel = actionsPage.getEnterCorrectTimeLabel().getText();
  	    softAssert.assertEquals(enterCorrectTimeLabel, ELEMENT_ENTER_CORRECT_TIME, ELEMENT_ENTER_CORRECT_TIME_MSG);
  	    setTimePage.getOkButton().click();
  	   
  	    
  	    //Now start again
  	    actionsPage.getEstimatedTimeToReachButton().click();
  	    //It will open last closed view of text field view to enter time data so no need to click toggle button again
  	    
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
			minutesToBeSet = 50;
		}
		
		setTimePage.getInPutMinuteTextField().clear();
		setTimePage.getInPutMinuteTextField().sendKeys(String.valueOf(minutesToBeSet));
		
		System.out.println(" setTimePage minutes "+ setTimePage.getInPutMinuteTextField().getText());
	    
		String currentAMPMValue = setTimePage.getCurrentAMPMValue().getText();
		setTimePage.getAmPMDropDown().click();
		
		
		System.out.println("Current APPM Value is "+currentAMPMValue);
		
		if(currentAMPMValue.equals(ELEMENT_AM)) {
			setTimePage.moveToScrollToElement(driver, ELEMENT_PM);
		}else {
			setTimePage.moveToScrollToElement(driver, ELEMENT_PM);
		}
		
		setTimePage.getOkButton().click();
		
		//check for text field value:
		String expectedTime = actionsPage.getEstimatedArrivalTextField().getText();
		softAssert.assertFalse(expectedTime == null && ELEMENT_EMPTY_STRING.equals(expectedTime), ELEMENT_EXPECTED_TIME_TF_VALUE);
		//Now set start time
		actionsPage.getStartTravelToCustomerButton().click();
		
		//check for text field value:
		String startTime = actionsPage.getStartTravelToCustomerTextField().getText();
		softAssert.assertFalse(startTime == null && ELEMENT_EMPTY_STRING.equals(startTime), ELEMENT_START_TIME_TF_VALUE);


		actionsPage.getReachedSiteButton().click();
		//actionsPage.getNoDelayButton().click();
		
		//check for text field value:
		String reachedSite = actionsPage.getReachedTimeTextField().getText();
		softAssert.assertFalse(reachedSite == null && ELEMENT_EMPTY_STRING.equals(reachedSite), ELEMENT_REACHED_SITE_TF_VALUE);
		
		//Now test Add attachment option for Image and document
		
		actionsPage.getAddAttachmentsButton().click();
		addAttachmentsPage.getAddAttachmentButton().click();
		//Lets first try to click, edit and add an image
		//Check title of screen
		String addAttachmentsLabelTitle = addAttachmentsPage.getAddAttachmentsLabel().getText();
		System.out.println("addAttachmentsLabel.trim() is "+addAttachmentsLabel.trim()+" ==addAttachmentsLabel equal== "+ addAttachmentsLabel.trim().equals(ELEMENT_ADD_ATTACMENTS_TITLE));
		softAssert.assertFalse(addAttachmentsLabelTitle == null && ELEMENT_EMPTY_STRING.equals(addAttachmentsLabelTitle), ELEMENT_ADD_ATTACMENTS_TITLE_VALUE);
		softAssert.assertEquals(addAttachmentsLabelTitle.trim(), ELEMENT_ADD_ATTACMENTS_TITLE,ELEMENT_ADD_ATTACMENTS_TITLE_MSG);
		
		addAttachmentsPage.getAddImageButton().click();
		
		String uploadImageLabel = addEditImage.getUploadImageLabel().getText();
		System.out.println("uploadImageLabel.trim()=="+uploadImageLabel.trim());
		softAssert.assertFalse(uploadImageLabel == null && ELEMENT_EMPTY_STRING.equals(uploadImageLabel), ELEMENT_UPLOAD_IMAGE_TITLE_VALUE);
		//softAssert.assertEquals(uploadImageLabel, ELEMENT_UPLOAD_IMAGE_TITLE, ELEMENT_UPLOAD_IMAGE_TITLE_MSG);
		
		addEditImage.getFromCameraButton().click();
		addEditImage.getImageCaptureButton().click();
//		addEditImage.getImageSaveButton().click();
//		addEditImage.getEditImageButton().click();
		
		
		//Lets retake and capture again
		addEditImage.getImageRetakeButton().click();
		
		//Now start again and lets try clear option
		addEditImage.getImageCaptureButton().click();
		addEditImage.getImageSaveButton().click();
		addEditImage.getClearImageButton().click();
		
		//Now try again hehe
		addEditImage.getFromCameraButton().click();
		addEditImage.getImageCaptureButton().click();
		addEditImage.getImageSaveButton().click();
		addEditImage.getEditImageButton().click();
		addEditImage.getClearAllScreenButton().click();
		
		System.out.println("Starting at From Camera again");
		
		//Now once more try to edit
		addEditImage.getFromCameraButton().click();
		addEditImage.getImageCaptureButton().click();
		
		addEditImage.getImageSaveButton().click();
		addEditImage.getEditImageButton().click();
		
		//Lets try to add some text in blue color on picture and Undo
		
		addEditImage.getTextOnScreenButton().click();
		addEditImage.getColorPickerList().get(ELEMENT_SECOND).click();
		addEditImage.getEnterTextArea().sendKeys("This is test message from Alok");
		addEditImage.getDoneButton().click();
		addEditImage.getUndoButton().click();
		System.out.println("After Undo");
		//Lets start again to select add text and draw before we continue
		
		addEditImage.getDrawOnScreenButton().click();
		addEditImage.getColorPickerList().get(ELEMENT_FIFTH).click();
		System.out.println("B4 draw line final line");
		addEditImage.getDrawOnScreenArea().click();
		Thread.sleep(2000);
		TestBase.drawLineOnArea(driver, addEditImage.getDrawOnScreenArea(), 200,300);
		//Lets draw one more line
		addEditImage.getColorPickerList().get(ELEMENT_SECOND).click();
		TestBase.drawLineOnArea(driver, addEditImage.getDrawOnScreenArea(), 400,300);
		addEditImage.getDoneButton().click();

		addEditImage.getTextOnScreenButton().click();
		addEditImage.getColorPickerList().get(ELEMENT_SECOND).click();
		addEditImage.getEnterTextArea().sendKeys("This is test message from Alok");
		//Thread.sleep(2000);
		System.out.println("B4 done button final text");
		addEditImage.getDoneButton().click();
		Thread.sleep(2000);
		
		addEditImage.getContinueButton().click();
		Thread.sleep(2000);
		addEditImage.getSaveImageButton().click();
		
		addEditImage.getYesButton().click();
		
		String uploadingImageLabel = addEditImage.getUploadingAttachmentLabel().getText();
		System.out.println("uploadingImageLabel is "+uploadingImageLabel);
		softAssert.assertFalse(uploadingImageLabel == null && ELEMENT_EMPTY_STRING.equals(uploadingImageLabel),ELEMENT_UPLOADING_ATTACHMENT_TITLE_VALUE );
		//softAssert.assertEquals(uploadingImageLabel.trim(), ELEMENT_UPLOADING_ATTACHMENT_TITLE, ELEMENT_UPLOADING_ATTACHMENT_TITLE_MSG);
		

		Thread.sleep(5000);
		homePage.getBackButton().click();
		
		
		//End Test add attachment
	
		actionsPage.getClosureNotesButton().click();
		actionsPage.getFeedbackTextField().sendKeys("Task was completed successfully");
		actionsPage.getSubmitButton().click();
		
		actionsPage.getLeftSiteButton().click();
		jobstatusPage.getJobCompletedRadioButton().click();
		jobstatusPage.getJobDelayedChkBox().click();
		jobstatusPage.getCustomerAccessRadioButton().click();
		actionsPage.getSubmitButton().click();
		actionsPage.getHideActionsScreenButton().click();
			
		homePage.getBackButton().click();
		
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
			}
			
		}
		
		//now assert all and let test fail even if one assert has failed
		softAssert.assertAll();
	}
	
	@Test
	public void testActionsPagePlanned() throws InterruptedException, IOException {
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.startRecording(driver);
			}
			
		}
		homePage.getNewTasksImageBtn().click();
		//allTasksListPage.getListOfTasks().get(3).click();
		
		try {
		allTasksListPage.moveToScrollToElement(driver, ELEMENT_PLANNED_TASK_FIRST);
		}catch(NoSuchElementException e) {
			
			//No new element found so test case can't be executed
			homePage.getBackButton().click();
			return;
		}
  	    singleTaskDetailsPage.getOpenActionsBtn().click();
 	    
  	    String actionsLabel = actionsPage.getActionsLabel().getText();
  	    softAssert.assertFalse(actionsLabel == null && ELEMENT_EMPTY_STRING.equals(actionsLabel), ELEMENT_ACTIONS_TITLE_VALUE);
  	    softAssert.assertEquals(actionsLabel, ELEMENT_ACTIONS_TITLE, ELEMENT_ACTIONS_TITLE_MSG);
  	    
 	    String exptectedTimeLabel = actionsPage.getExpectedTimeToReachLabel().getText();
  	    softAssert.assertFalse(exptectedTimeLabel == null && ELEMENT_EMPTY_STRING.equals(exptectedTimeLabel), ELEMENT_EXPECTED_TIME_TITLE_VALUE);
  	    softAssert.assertEquals(exptectedTimeLabel, ELEMENT_EXPECTED_TIME_TITLE, ELEMENT_EXPECTED_TIME_TITLE_MSG);
  	    
	    String startTravelLabel = actionsPage.getStartTimeToTravelLabel().getText();
  	    softAssert.assertFalse(startTravelLabel == null && ELEMENT_EMPTY_STRING.equals(startTravelLabel), ELEMENT_START_TIME_TITLE_VALUE);
  	    softAssert.assertEquals(startTravelLabel, ELEMENT_START_TIME_TITLE, ELEMENT_START_TIME_TITLE_MSG);

	    String reachedSiteLabel = actionsPage.getReachedSiteLabel().getText();
  	    softAssert.assertFalse(reachedSiteLabel == null && ELEMENT_EMPTY_STRING.equals(reachedSiteLabel), ELEMENT_REACHED_SITE_TITLE_VALUE);
  	    softAssert.assertEquals(reachedSiteLabel, ELEMENT_REACHED_SITE_TITLE, ELEMENT_REACHED_SITE_TITLE_MSG);
  	    
	    String addAttachmentsLabel = actionsPage.getAddAttachmentsLabel().getText();
  	    softAssert.assertFalse(addAttachmentsLabel == null && ELEMENT_EMPTY_STRING.equals(addAttachmentsLabel), ELEMENT_ADD_ATTACHMENTS_TITLE_VALUE);
  	    softAssert.assertEquals(addAttachmentsLabel, ELEMENT_ADD_ATTACHMENTS_TITLE, ELEMENT_ADD_ATTACHMENTS_TITLE_MSG);
  	    
	    String closureNotesLabel = actionsPage.getClosureNotesLabel().getText();
  	    softAssert.assertFalse(closureNotesLabel == null && ELEMENT_EMPTY_STRING.equals(closureNotesLabel), ELEMENT_CLOSURE_NOTES_TITLE_VALUE);
  	    softAssert.assertEquals(closureNotesLabel, ELEMENT_CLOSURE_NOTES_TITLE, ELEMENT_CLOSURE_NOTES_TITLE_MSG);

	    String leftSiteLabel = actionsPage.getLeftSitesLabel().getText();
  	    softAssert.assertFalse(leftSiteLabel == null && ELEMENT_EMPTY_STRING.equals(leftSiteLabel), ELEMENT_LEFT_SITE_TITLE_VALUE);
  	    softAssert.assertEquals(leftSiteLabel, ELEMENT_LEFT_SITE_TITLE, ELEMENT_LEFT_SITE_TITLE_MSG);
  	    
		String expectedTimePrePopulate = actionsPage.getEstimatedArrivalTextField().getText();
		
		if(!expectedTimePrePopulate.equals("0.00")) {

  	    actionsPage.getEstimatedTimeToReachButton().click();
  	    setTimePage.getDateToggleButton().click();
  	    
  	    //Try to set incorrect time say 1 AM
  	    setTimePage.getInPutHourTextField().clear();
		setTimePage.getInPutHourTextField().sendKeys(String.valueOf(ELEMENT_SECOND));
		String currentAMPMValueInitial = setTimePage.getCurrentAMPMValue().getText();
		setTimePage.getAmPMDropDown().click();
		
		System.out.println("Current APPM Value is "+currentAMPMValueInitial);
		
		if(currentAMPMValueInitial.equals(ELEMENT_PM)) {
			setTimePage.moveToScrollToElement(driver, ELEMENT_AM);
		}else {
			setTimePage.moveToScrollToElement(driver, ELEMENT_PM);
		}
		
		setTimePage.getOkButton().click();
		
		String enterCorrectTimeLabel = actionsPage.getEnterCorrectTimeLabel().getText();
  	    softAssert.assertEquals(enterCorrectTimeLabel, ELEMENT_ENTER_CORRECT_TIME, ELEMENT_ENTER_CORRECT_TIME_MSG);
  	    setTimePage.getOkButton().click();
  	   
  	    
  	    //Now start again
  	    actionsPage.getEstimatedTimeToReachButton().click();
  	    //It will open last closed view of text field view to enter time data so no need to click toggle button again
  	    
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
			minutesToBeSet = 50;
		}
		
		setTimePage.getInPutMinuteTextField().clear();
		setTimePage.getInPutMinuteTextField().sendKeys(String.valueOf(minutesToBeSet));
		
		System.out.println(" setTimePage minutes "+ setTimePage.getInPutMinuteTextField().getText());
	    
		String currentAMPMValue = setTimePage.getCurrentAMPMValue().getText();
		setTimePage.getAmPMDropDown().click();
		
		
		System.out.println("Current APPM Value is "+currentAMPMValue);
		
		if(currentAMPMValue.equals(ELEMENT_AM)) {
			setTimePage.moveToScrollToElement(driver, ELEMENT_PM);
		}else {
			setTimePage.moveToScrollToElement(driver, ELEMENT_PM);
		}
		
		setTimePage.getOkButton().click();
		
		//check for text field value:
		String expectedTime = actionsPage.getEstimatedArrivalTextField().getText();
		softAssert.assertFalse(expectedTime == null && ELEMENT_EMPTY_STRING.equals(expectedTime), ELEMENT_EXPECTED_TIME_TF_VALUE);
		//Now set start time
		actionsPage.getStartTravelToCustomerButton().click();
		
		//check for text field value:
		String startTime = actionsPage.getStartTravelToCustomerTextField().getText();
		softAssert.assertFalse(startTime == null && ELEMENT_EMPTY_STRING.equals(startTime), ELEMENT_START_TIME_TF_VALUE);


		actionsPage.getReachedSiteButton().click();
		actionsPage.getNoDelayButton().click();
		
		//check for text field value:
		String reachedSite = actionsPage.getReachedTimeTextField().getText();
		softAssert.assertFalse(reachedSite == null && ELEMENT_EMPTY_STRING.equals(reachedSite), ELEMENT_REACHED_SITE_TF_VALUE);
		
		//Now test Add attachment option for Image and document
		}//means we can't do any of the above actions so rest of the test case will work
		
		actionsPage.getAddAttachmentsButton().click();
		addAttachmentsPage.getAddAttachmentButton().click();
		//Lets first try to click, edit and add an image
		//Check title of screen
		String addAttachmentsLabelTitle = addAttachmentsPage.getAddAttachmentsLabel().getText();
		System.out.println("addAttachmentsLabel.trim() is "+addAttachmentsLabel.trim()+" ==addAttachmentsLabel equal== "+ addAttachmentsLabel.trim().equals(ELEMENT_ADD_ATTACMENTS_TITLE));
		softAssert.assertFalse(addAttachmentsLabelTitle == null && ELEMENT_EMPTY_STRING.equals(addAttachmentsLabelTitle), ELEMENT_ADD_ATTACMENTS_TITLE_VALUE);
		softAssert.assertEquals(addAttachmentsLabelTitle.trim(), ELEMENT_ADD_ATTACMENTS_TITLE,ELEMENT_ADD_ATTACMENTS_TITLE_MSG);
		
		addAttachmentsPage.getAddImageButton().click();
		
		String uploadImageLabel = addEditImage.getUploadImageLabel().getText();
		System.out.println("uploadImageLabel.trim()=="+uploadImageLabel.trim());
		softAssert.assertFalse(uploadImageLabel == null && ELEMENT_EMPTY_STRING.equals(uploadImageLabel), ELEMENT_UPLOAD_IMAGE_TITLE_VALUE);
		//softAssert.assertEquals(uploadImageLabel, ELEMENT_UPLOAD_IMAGE_TITLE, ELEMENT_UPLOAD_IMAGE_TITLE_MSG);
		
		addEditImage.getFromCameraButton().click();
		addEditImage.getImageCaptureButton().click();
//		addEditImage.getImageSaveButton().click();
//		addEditImage.getEditImageButton().click();
		
		
		//Lets retake and capture again
		addEditImage.getImageRetakeButton().click();
		
		//Now start again and lets try clear option
		addEditImage.getImageCaptureButton().click();
		addEditImage.getImageSaveButton().click();
		addEditImage.getClearImageButton().click();
		
		//Now try again hehe
		addEditImage.getFromCameraButton().click();
		addEditImage.getImageCaptureButton().click();
		addEditImage.getImageSaveButton().click();
		addEditImage.getEditImageButton().click();
		addEditImage.getClearAllScreenButton().click();
		
		System.out.println("Starting at From Camera again");
		
		//Now once more try to edit
		addEditImage.getFromCameraButton().click();
		addEditImage.getImageCaptureButton().click();
		
		addEditImage.getImageSaveButton().click();
		addEditImage.getEditImageButton().click();
		
		//Lets try to add some text in blue color on picture and Undo
		
		addEditImage.getTextOnScreenButton().click();
		addEditImage.getColorPickerList().get(ELEMENT_SECOND).click();
		addEditImage.getEnterTextArea().sendKeys("This is test message from Alok");
		addEditImage.getDoneButton().click();
		addEditImage.getUndoButton().click();
		System.out.println("After Undo");
		//Lets start again to select add text and draw before we continue
		
		addEditImage.getDrawOnScreenButton().click();
		addEditImage.getColorPickerList().get(ELEMENT_FIFTH).click();
		System.out.println("B4 draw line final line");
		addEditImage.getDrawOnScreenArea().click();
		Thread.sleep(2000);
		TestBase.drawLineOnArea(driver, addEditImage.getDrawOnScreenArea(), 200,300);
		//Lets draw one more line
		addEditImage.getColorPickerList().get(ELEMENT_SECOND).click();
		TestBase.drawLineOnArea(driver, addEditImage.getDrawOnScreenArea(), 400,300);
		addEditImage.getDoneButton().click();

		addEditImage.getTextOnScreenButton().click();
		addEditImage.getColorPickerList().get(ELEMENT_SECOND).click();
		addEditImage.getEnterTextArea().sendKeys("This is test message from Alok");
		//Thread.sleep(2000);
		System.out.println("B4 done button final text");
		addEditImage.getDoneButton().click();
		Thread.sleep(2000);
		
		addEditImage.getContinueButton().click();
		Thread.sleep(2000);
		addEditImage.getSaveImageButton().click();
		
		addEditImage.getYesButton().click();
		
		String uploadingImageLabel = addEditImage.getUploadingAttachmentLabel().getText();
		System.out.println("uploadingImageLabel is "+uploadingImageLabel);
		softAssert.assertFalse(uploadingImageLabel == null && ELEMENT_EMPTY_STRING.equals(uploadingImageLabel),ELEMENT_UPLOADING_ATTACHMENT_TITLE_VALUE );
		//softAssert.assertEquals(uploadingImageLabel.trim(), ELEMENT_UPLOADING_ATTACHMENT_TITLE, ELEMENT_UPLOADING_ATTACHMENT_TITLE_MSG);
		

		Thread.sleep(5000);
		homePage.getBackButton().click();
		
		
		//End Test add attachment
	
		actionsPage.getClosureNotesButton().click();
		actionsPage.getFeedbackTextField().sendKeys("Task was completed successfully");
		actionsPage.getSubmitButton().click();
		
		actionsPage.getLeftSiteButton().click();
		jobstatusPage.getJobCompletedRadioButton().click();
		jobstatusPage.getJobDelayedChkBox().click();
		jobstatusPage.getCustomerAccessRadioButton().click();
		actionsPage.getSubmitButton().click();
		actionsPage.getHideActionsScreenButton().click();
			
		homePage.getBackButton().click();
		
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
			}
			
		}
		
		//now assert all and let test fail even if one assert has failed
		softAssert.assertAll();
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
