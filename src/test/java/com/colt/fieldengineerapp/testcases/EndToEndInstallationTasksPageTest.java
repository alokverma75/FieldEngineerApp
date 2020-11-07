package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.pages.ActionsPage;
import com.colt.fieldengineerapp.pages.AlertPage;
import com.colt.fieldengineerapp.pages.AllTasksListPage;
import com.colt.fieldengineerapp.pages.AllTasksPage;
import com.colt.fieldengineerapp.pages.AttachmentsPage;
import com.colt.fieldengineerapp.pages.CommunicationPage;
import com.colt.fieldengineerapp.pages.FilterPage;
import com.colt.fieldengineerapp.pages.HeaderPage;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LocationPage;
import com.colt.fieldengineerapp.pages.LoginPage;
import com.colt.fieldengineerapp.pages.SingleTaskDetailsPage;
import com.colt.fieldengineerapp.util.TestData;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EndToEndInstallationTasksPageTest extends TestBase {

	LoginPage loginPage;
	LandingPage landingPage;
	HomePage homePage;
	AllTasksListPage allTasksListPage;
	SingleTaskDetailsPage singleTaskDetailsPage;
	ActionsPage actionsPage;
	AllTasksPage installationPage;
	HeaderPage headerPage;
	LocationPage locationPage;
	CommunicationPage communicationPage;
	AttachmentsPage attachmentsPage;
	AlertPage alertPage;
	FilterPage filterPage;
	AndroidDriver<AndroidElement> driver;
	List<AndroidElement> listofTextView;
	

	public EndToEndInstallationTasksPageTest() throws MalformedURLException, IOException {
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
		installationPage = new AllTasksPage(driver);
		headerPage = new HeaderPage(driver);
		locationPage = new LocationPage(driver);
		communicationPage = new CommunicationPage(driver);
		attachmentsPage = new AttachmentsPage(driver);
		allTasksListPage = new AllTasksListPage(driver);
		singleTaskDetailsPage = new SingleTaskDetailsPage(driver);
		alertPage = new AlertPage(driver);
		filterPage = new FilterPage(driver);
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		Thread.sleep(2000);
		landingPage.getContinueBtn().click();
		Thread.sleep(3000);

	}


	
	@Test(dataProvider = "InputDataForAllTasks", dataProviderClass = TestData.class)
	public void testinstallationPageEndToEnd(String userEmail, String chatText) throws InterruptedException, IOException {
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.startRecording(driver);
			}
			
		}
		
		homePage.getInstallationTasksImageBtn().click();
		//First Check all elements on New Tasks Page for first task
		
		//Activity ID
		
		String activityIDValue = installationPage.getActivityIDValue().getText();
		Assert.assertNotNull(activityIDValue,ELEMENT_ACTIVITY_ID_TF_VALUE);
		
		String imageLocation = installationPage.getActivityIDValue().getText();
		Assert.assertNotNull(imageLocation,ELEMENT_ACTIVITY_ID_TF_VALUE);		

		String typeLabel = installationPage.getTypeTitle().getText();
		Assert.assertEquals(typeLabel,ELEMENT_TYPE_NEW_TASK_TITLE,ELEMENT_TYPE_NEW_TASK_TITLE_MSG);
		String typeTFValue = installationPage.getTypeValue().getText();
		Assert.assertNotNull(typeTFValue,ELEMENT_TYPE_NEW_TASK_TITLE_TF_VALUE);
		Assert.assertEquals(typeTFValue, ELEMENT_TYPE_VALUE_INSTALLATION,ELEMENT_TYPE_VALUE_INSTALLATION_MSG);

		String productLabel = installationPage.getProductTitle().getText();
		Assert.assertEquals(productLabel,ELEMENT_PRODUCT_LABEL,ELEMENT_PRODUCT_LABEL_MSG);
		String priorityTFValue = installationPage.getPriorityValue().getText();
		Assert.assertNotNull(priorityTFValue,ELEMENT_PRODUCT_LABEL_TF_VALUE);
		
		String statusLabel = installationPage.getStatusTitle().getText();
		Assert.assertEquals(statusLabel,ELEMENT_STATUS_TITLE,ELEMENT_STATUS_TITLE_MSG);
		String statusTFValue = installationPage.getStatusValue().getText();
		Assert.assertNotNull(statusTFValue,ELEMENT_STATUS_TITLE_TF_VALUE);
		
		// Try to search for say Installation Type tasks in list
		String typeMaintainance = "";
		try {
			typeMaintainance = singleTaskDetailsPage.scrollToElement(driver, ELEMENT_TYPE_MAINTENANCE).getText();
		
		}catch(NoSuchElementException e) {
			//As there should be no element with TYPE=Maintenance, an exception will be thrown
			Assert.assertFalse(ELEMENT_TYPE_MAINTENANCE.equals(typeMaintainance));
		}
		
		Assert.assertFalse(ELEMENT_TYPE_MAINTENANCE.equals(typeMaintainance));
		
		homePage.getBackButton().click();
		homePage.getInstallationTasksImageBtn().click();


		//Check for filter option 
		
		headerPage.getFilterTasks().click();
		
		//Now use relevant Filter screen to make selection and for new task default option should be New
		
		String filterAlertTitle = filterPage.getFilterTitle().getText();
		Assert.assertEquals(filterAlertTitle,ELEMENT_FILTER_TITLE,ELEMENT_FILTER_TITLE_MSG);

		String pomCheckbox = filterPage.getPomChkBox().getText();
		Assert.assertEquals(pomCheckbox,ELEMENT_POM,ELEMENT_POM_MSG);
		
		String sblCheckbox = filterPage.getSblChkBox().getText();
		Assert.assertEquals(sblCheckbox,ELEMENT_SBL,ELEMENT_SBL_MSG);

		String statusCheckbox = filterPage.getStatusChkBox().getText();
		Assert.assertEquals(statusCheckbox,ELEMENT_STATUS,ELEMENT_STATUS_MSG);
		
//		String newCheckbox = filterPage.getNewChkBox().getText();
//		Assert.assertEquals(newCheckbox,ELEMENT_NEW,ELEMENT_NEW_MSG);
//		
//		String inProgressCheckbox = filterPage.getInProgressChkBox().getText();
//		Assert.assertEquals(inProgressCheckbox,ELEMENT_IN_PROGRESS,ELEMENT_IN_PROGRESS_MSG);
//		
//		String doneCheckbox = filterPage.getDoneChkBox().getText();
//		Assert.assertEquals(doneCheckbox,ELEMENT_DONE,ELEMENT_DONE_MSG);
		
		String nextfivedaysCheckbox = filterPage.getNextFiveDaysChkBox().getText();
		Assert.assertEquals(nextfivedaysCheckbox,ELEMENT_NEXT_FIVE_DAYS,ELEMENT_NEXT_FIVE_DAYS_MSG);

		String nextTendaysCheckbox = filterPage.getNextTenDaysChkBox().getText();
		Assert.assertEquals(nextTendaysCheckbox,ELEMENT_NEXT_TEN_DAYS,ELEMENT_NEXT_TEN_DAYS_MSG);
			
		String pomChkBoxNotSelected =  filterPage.getPomChkBox().getAttribute(ELEMENT_CHECKED);
		Assert.assertTrue(ELEMENT_TRUE.equals(pomChkBoxNotSelected));
		
		String sblChkBoxNotSelected =  filterPage.getSblChkBox().getAttribute(ELEMENT_CHECKED);
		Assert.assertTrue(ELEMENT_FALSE.equals(sblChkBoxNotSelected));

		String statusChkBoxNotSelected =  filterPage.getStatusChkBox().getAttribute(ELEMENT_CHECKED);
		Assert.assertTrue(ELEMENT_FALSE.equals(statusChkBoxNotSelected));
		
		String nextFiveChkBoxNotSelected =  filterPage.getNextFiveDaysChkBox().getAttribute(ELEMENT_CHECKED);
		Assert.assertTrue(ELEMENT_FALSE.equals(nextFiveChkBoxNotSelected));
		
		String nextTenChkBoxNotSelected =  filterPage.getNextTenDaysChkBox().getAttribute(ELEMENT_CHECKED);
		Assert.assertTrue(ELEMENT_FALSE.equals(nextTenChkBoxNotSelected));
		
		


		
		//Now click on Status chk box and apply
		if(!(ELEMENT_TRUE.equals(statusChkBoxNotSelected))) {
			filterPage.getStatusChkBox().click();
		}
		
		String doneCheckbox = filterPage.getDoneChkBox().getAttribute(ELEMENT_CHECKED);
		
		if(!(ELEMENT_TRUE.equals(doneCheckbox))) {
			filterPage.getDoneChkBox().click();
		}		
		
		 
		
		filterPage.getApplyButton().click();
		
		//Open filter again and chk if it is still selected
		headerPage.getFilterTasks().click();
		String newChkBoxStillSelected =  filterPage.getDoneChkBox().getAttribute(ELEMENT_CHECKED);
		Assert.assertTrue(ELEMENT_TRUE.equals(newChkBoxStillSelected));
		
		filterPage.getCancelButton().click();
		
		//Now chk status of first ask if it is In Progress as all in progress too will be loaded

		
		//scroll till the first Task with New status appears in view
		singleTaskDetailsPage.scrollToElement(driver, ELEMENT_RESOLVED);
		
		
		//Get list of statuses of all Tasks from the view and check the one with Status=New
		List<AndroidElement> statusValues = installationPage.getStatusValuesList();
			
			for(int i = 0; i < statusValues.size(); i++) {
				String statusValueOnFilter = statusValues.get(i).getText();				
				if(ELEMENT_NEW.equals(statusValueOnFilter)) {
					System.out.println("statusTFValueAfterApplyFilter  "+ statusValueOnFilter + "at index "+ i);
					Assert.assertEquals(statusValueOnFilter,ELEMENT_RESOLVED);
					break;
					
					}
					
				}

		
		//Lets try to assign this task to some user before moving on
		
		headerPage.getAssignTaskIcon().click();
		
		String checkBoxValueBeforeClick = installationPage.getCheckBox().get(ELEMENT_FIRST).getAttribute(ELEMENT_CHECKED);		
		Assert.assertTrue(ELEMENT_FALSE.equals(checkBoxValueBeforeClick));
		
		installationPage.getCheckBox().get(ELEMENT_FIRST).click();
		
		headerPage.getAssignButton().click();
		
		String alertPageTitle = alertPage.getAssignTaskAlertWindowTitle().getText();
		Assert.assertEquals(alertPageTitle,ELEMENT_ALERT_TITLE,ELEMENT_ALERT_TITLE_MSG);
		
		alertPage.getUserNameTextField().sendKeys(userEmail);
		alertPage.getSubmitButton().click();
		
		String checkBoxValueAfterClick = installationPage.getCheckBox().get(ELEMENT_FIRST).getAttribute(ELEMENT_CHECKED);	
		Assert.assertTrue(ELEMENT_TRUE.equals(checkBoxValueAfterClick));
		
		homePage.getBackButton().click();
		homePage.getNewTasksImageBtn().click();
		
		String activityIDValueNew = installationPage.getActivityIDValue().getText();
		installationPage.getImageNext().click();
		Thread.sleep(2000);
		
		
		//compare page title with activity id captured in previous page
		String pageTitle = headerPage.getPageTitle().getText();
		Assert.assertEquals(pageTitle,activityIDValueNew,ELEMENT_TITLE_VALUES);
		
		headerPage.getDetailsTab().click();
		
		//check for Page elements title
		String basiclabel = singleTaskDetailsPage.getBasicTextLabel().getText();
		Assert.assertEquals(basiclabel,ELEMENT_BASIC_TITLE,ELEMENT_BASIC_TITLE_MSG);
		
		String orderlabel = singleTaskDetailsPage.getOrderNumberLabel().getText();
		Assert.assertEquals(orderlabel,ELEMENT_ORDER_NUMBER_TITLE,ELEMENT_ORDER_NUMBER_TITLE_MSG);
		//System.out.println("Label is " + orderlabel);
				
		String providerlabel = singleTaskDetailsPage.getProviderLabel().getText();
		Assert.assertEquals(providerlabel,ELEMENT_PROVIDER_TITLE,ELEMENT_PROVIDER_TITLE_MSG);
		//System.out.println("Label is " + providerlabel);
		
		String productNamelabel = singleTaskDetailsPage.getProductNameLabel().getText();
		Assert.assertEquals(productNamelabel,ELEMENT_PRODUCT_NAME_TITLE,ELEMENT_PRODUCT_NAME_TITLE_MSG);
		//System.out.println("Label is " + orderlabel);

		String taskIDlabel = singleTaskDetailsPage.getTaskIDLabel().getText();
		Assert.assertEquals(taskIDlabel,ELEMENT_TASK_ID_TITLE,ELEMENT_TASK_ID_TITLE_MSG);
		//System.out.println("Label is " + orderlabel);

		String typelabel = singleTaskDetailsPage.getTypeLabel().getText();
		Assert.assertEquals(typelabel,ELEMENT_TYPE_TITLE,ELEMENT_TYPE_TITLE_MSG);
		//System.out.println("Label is " + typelabel);
		
		String subjectlabel = singleTaskDetailsPage.getSubjectLabel().getText();
		Assert.assertEquals(subjectlabel,ELEMENT_SUBJECT_TITLE,ELEMENT_SUBJECT_TITLE_MSG);
		//System.out.println("Label is " + subjectlabel);

		String townlabel = singleTaskDetailsPage.getTownLabel().getText();
		Assert.assertEquals(townlabel,ELEMENT_TOWN_TITLE,ELEMENT_TOWN_TITLE_MSG);
		//System.out.println("Label is " + townlabel);
		
		String postCodelabel = singleTaskDetailsPage.getPostCodeLabel().getText();
		Assert.assertEquals(postCodelabel,ELEMENT_POST_CODE_TITLE,ELEMENT_POST_CODE_TITLE_MSG);
		//System.out.println("Label is " + postCodelabel);
		
		// Till Post code one page we can check all elements for this page
//		listofTextView = singleTaskDetailsPage.getTextFieldValue();
//		for (int i = 0; i < listofTextView.size(); i++) {
//			System.out.println(" element at" + i + "th Index is " + listofTextView.get(i).getText());
//		}
		
		//Now scroll to customer
		
		singleTaskDetailsPage.scrollToElement(driver, ELEMENT_COUNTRY_TITLE);
		//Thread.sleep(2000);
//		String customerlabel = singleTaskDetailsPage.getCustomerLabel().getText();
//		Assert.assertEquals(customerlabel,ELEMENT_CUSTOMER_TITLE,ELEMENT_CUSTOMER_TITLE_MSG);
//		System.out.println("Label is " + customerlabel);
		
		//singleTaskDetailsPage.scrollToElement(driver, ELEMENT_COUNTRY_TITLE);
		String countrylabel = singleTaskDetailsPage.getCountryLabel().getText();
		Assert.assertEquals(countrylabel,ELEMENT_COUNTRY_TITLE,ELEMENT_COUNTRY_TITLE_MSG);
		//System.out.println("Label is " + countrylabel);
		
		String addresslabel = singleTaskDetailsPage.getAddressLabel().getText();
		Assert.assertEquals(addresslabel,ELEMENT_ADDRESS_TITLE,ELEMENT_ADDRESS_TITLE_MSG);
		//System.out.println("Label is " + addresslabel);
		
		//singleTaskDetailsPage.scrollToElement(driver, ELEMENT_JOB_OWNER_ID_TITLE);
		String jobOwnerIDlabel = singleTaskDetailsPage.getJobOwnerIDLabel().getText();
		Assert.assertEquals(jobOwnerIDlabel,ELEMENT_JOB_OWNER_ID_TITLE,ELEMENT_JOB_OWNER_ID_TITLE_MSG);
		//System.out.println("Label is " + jobOwnerIDlabel);
		
		
		String jobIDlabel = singleTaskDetailsPage.getJobIDLabel().getText();
		Assert.assertEquals(jobIDlabel,ELEMENT_JOB_ID_TITLE,ELEMENT_JOB_ID_TITLE_MSG);
		//System.out.println("Label is " + jobIDlabel);
		
		String activityIDlabel = singleTaskDetailsPage.getActivityIDLabel().getText();
		Assert.assertEquals(activityIDlabel,ELEMENT_ACTIVITY_ID_TITLE,ELEMENT_ACTIVITY_ID_TITLE_MSG);
		//System.out.println("Label is " + activityIDlabel);

		String categorylabel = singleTaskDetailsPage.getCategoryLabel().getText();
		Assert.assertEquals(categorylabel,ELEMENT_CATEGORY_TITLE,ELEMENT_CATEGORY_TITLE_MSG);
		//System.out.println("Label is " + categorylabel);
		
		String jobStatuslabel = singleTaskDetailsPage.getJobStatusLabel().getText();
		Assert.assertEquals(jobStatuslabel,ELEMENT_JOB_STATUS_TITLE,ELEMENT_JOB_STATUS_TITLE_MSG);
		//System.out.println("Label is " + jobStatuslabel);
		
		String jobOwnerlabel = singleTaskDetailsPage.getJobOwnerLabel().getText();
		Assert.assertEquals(jobOwnerlabel,ELEMENT_JOB_OWNER_TITLE,ELEMENT_JOB_OWNER_TITLE_MSG);
		//System.out.println("Label is " + jobOwnerlabel);
		
		String plannedStartlabel = singleTaskDetailsPage.getPlannedStartLabel().getText();
		Assert.assertEquals(plannedStartlabel,ELEMENT_PLANNED_START_DATE_TITLE,ELEMENT_PLANNED_START_DATE_TITLE_MSG);
		//System.out.println("Label is " + plannedStartlabel);
		
//		listofTextView = singleTaskDetailsPage.getTextFieldValue();
//		for (int i = 0; i < listofTextView.size(); i++) {
//			System.out.println(" element at" + i + "th Index is " + listofTextView.get(i).getText());
//		}

		
			
		singleTaskDetailsPage.scrollToElement(driver, ELEMENT_JOB_LINK_TITLE);
		
//		String plannedEndlabel = singleTaskDetailsPage.getPlannedEndDateLabel().getText();
//		Assert.assertEquals(plannedEndlabel,ELEMENT_PLANNED_END_DATE_TITLE,ELEMENT_PLANNED_END_DATE_TITLE_MSG);
//		System.out.println("Label is " + plannedEndlabel);

		String jobLinklabel = singleTaskDetailsPage.getJobLinkLabel().getText();
		Assert.assertEquals(jobLinklabel,ELEMENT_JOB_LINK_TITLE,ELEMENT_JOB_LINK_TITLE_MSG);
		//System.out.println("Label is " + jobLinklabel);

		String jobLinkStatuslabel = singleTaskDetailsPage.getJobLinkStatusLabel().getText();
		Assert.assertEquals(jobLinkStatuslabel,ELEMENT_JOB_LINK_STATUS_TITLE,ELEMENT_JOB_LINK_STATUS_TITLE_MSG);
		//System.out.println("Label is " + jobLinkStatuslabel);
		
		String moreDetailslabel = singleTaskDetailsPage.getMoreDetailsLabel().getText();
		Assert.assertEquals(moreDetailslabel,ELEMENT_MORE_DETAILS_TITLE,ELEMENT_MORE_DETAILS_TITLE_MSG);
		//System.out.println("Label is " + moreDetailslabel);

		String legalCustomerlabel = singleTaskDetailsPage.getLegalCustomerLabel().getText();
		Assert.assertEquals(legalCustomerlabel,ELEMENT_LEGAL_CUST_TITLE,ELEMENT_LEGAL_CUST_TITLE_MSG);
		//System.out.println("Label is " + legalCustomerlabel);

		String servicelabel = singleTaskDetailsPage.getServiceLabel().getText();
		Assert.assertEquals(servicelabel,ELEMENT_SERVICE_TITLE,ELEMENT_SERVICE_TITLE_MSG);
		//System.out.println("Label is " + servicelabel);
		
		String serviceReflabel = singleTaskDetailsPage.getServiceRefLabel().getText();
		Assert.assertEquals(serviceReflabel,ELEMENT_SERVICE_REF_TITLE,ELEMENT_SERVICE_REF_TITLE_MSG);
		//System.out.println("Label is " + serviceReflabel);
		
		
		String cpdlabel = singleTaskDetailsPage.getCpdLabel().getText();
		Assert.assertEquals(cpdlabel,ELEMENT_CPD_TITLE,ELEMENT_CPD_TITLE_MSG);
		//System.out.println("Label is " + cpdlabel);
		
		//String crdlabel = singleTaskDetailsPage.scrollToElement(driver, ELEMENT_CRD_TITLE).getText();
		String crdlabel = singleTaskDetailsPage.getCrdLabel().getText();
		Assert.assertEquals(crdlabel,ELEMENT_CRD_TITLE,ELEMENT_CRD_TITLE_MSG);
		//System.out.println("Label is " + crdlabel);
		
		//singleTaskDetailsPage.scrollToElement(driver, ELEMENT_SUB_TYPE_TITLE);
		String subtypelabel = singleTaskDetailsPage.getSubTypeLabel().getText();
		Assert.assertEquals(subtypelabel,ELEMENT_SUB_TYPE_TITLE,ELEMENT_SUB_TYPE_TITLE_MSG);
		//System.out.println("Label is " + subtypelabel);

//		listofTextView = singleTaskDetailsPage.getTextFieldValue();
//		for (int i = 0; i < listofTextView.size(); i++) {
//			System.out.println(" element at" + i + "th Index is " + listofTextView.get(i).getText());
//		}
		
		singleTaskDetailsPage.scrollToElement(driver, ELEMENT_SITE_NAME_TITLE);
		//Below are commented as due to limitation of Emulator scroll function and some elements it fail to read on page view
//		String remarkslabel = singleTaskDetailsPage.getRemarksLabel().getText();
//		Assert.assertEquals(remarkslabel,ELEMENT_REMARKS_TITLE,ELEMENT_REMARKS_TITLE_MSG);
//		System.out.println("Label is " + remarkslabel);

//		String erolabel = singleTaskDetailsPage.getEroLabel().getText();
//		Assert.assertEquals(erolabel,ELEMENT_ERO_TITLE,ELEMENT_ERO_TITLE_MSG);
//		System.out.println("Label is " + erolabel);

		String siteNamelabel = singleTaskDetailsPage.getSiteNameLabel().getText();
		Assert.assertEquals(siteNamelabel,ELEMENT_SITE_NAME_TITLE,ELEMENT_SITE_NAME_TITLE_MSG);
		//System.out.println("Label is " + siteNamelabel);

		String telephonelabel = singleTaskDetailsPage.getTelephoneLabel().getText();
		Assert.assertEquals(telephonelabel,ELEMENT_TELEPHONE_TITLE,ELEMENT_TELEPHONE_TITLE_MSG);
		//System.out.println("Label is " + telephonelabel);

		String emailLabel = singleTaskDetailsPage.getEmailLabel().getText();
		Assert.assertEquals(emailLabel,ELEMENT_EMAIL_TITLE,ELEMENT_EMAIL_TITLE_MSG);
		//System.out.println("Label is " + emailLabel);
		
		String jobRemarksLabel = singleTaskDetailsPage.getJobRemarksLabel().getText();
		Assert.assertEquals(jobRemarksLabel,ELEMENT_JOB_REMARKS_TITLE,ELEMENT_JOB_REMARKS_TITLE_MSG);
		//System.out.println("Label is " + jobRemarksLabel);
		
		String coopTeamLabel = singleTaskDetailsPage.getCoopTeamLabel().getText();
		Assert.assertEquals(coopTeamLabel,ELEMENT_COOP_TEAM_TITLE,ELEMENT_COOP_TEAM_TITLE_MSG);
		//System.out.println("Label is " + coopTeamLabel);

//		
//		listofTextView = singleTaskDetailsPage.getTextFieldValue();
//		for (int i = 0; i < listofTextView.size(); i++) {
//			System.out.println(" element at" + i + "th Index is " + listofTextView.get(i).getText());
//		}
//		
		//String coopTechLabel = singleTaskDetailsPage.scrollToElement(driver, ELEMENT_COOP_TECH_TITLE).getText();
		String coopTechLabel = singleTaskDetailsPage.getCoopTechLabel().getText();
		Assert.assertEquals(coopTechLabel,ELEMENT_COOP_TECH_TITLE,ELEMENT_COOP_TECH_TITLE_MSG);
		//System.out.println("Label is " + coopTechLabel);
		
//		String coopTechMobLabel = singleTaskDetailsPage.getCoopTechMobileLabel().getText();
//		Assert.assertEquals(coopTechMobLabel,ELEMENT_COOP_TECH_MOB_TITLE,ELEMENT_COOP_TECH_MOB_TITLE_MSG);
//		System.out.println("Label is " + coopTechLabel);
//		
		singleTaskDetailsPage.scrollToElement(driver, ELEMENT_COOP_TECH_EMAIL_TITLE);
		String coopTechEmailLabel = singleTaskDetailsPage.getCoopTechEmailLabel().getText();
		Assert.assertEquals(coopTechEmailLabel,ELEMENT_COOP_TECH_EMAIL_TITLE,ELEMENT_COOP_TECH_EMAIL_TITLE_MSG);
		//System.out.println("Label is " + coopTechEmailLabel);

		//Now validate Location Page, first use header page to click on Location tab
		headerPage.getLocationTab().click();
		
		//Now use Location page to validate all data on this page, all tabs have separate page 
		
//		String aEndAddress = locationPage.getaEndAddress().getText();
//		Assert.assertEquals(aEndAddress,ELEMENT_AEND_ADDRESSS_TITLE,ELEMENT_AEND_ADDRESSS_TITLE_MSG);
//		
//		String aEndAddressTextFieldValue = locationPage.getSiteAValue().getText();
//		Assert.assertFalse(ELEMENT_EMPTY_STRING.equals(aEndAddressTextFieldValue), ELEMENT_AEND_ADDRESSS_TITLE_VALUE);
//		
//		String imageSiteA = locationPage.getSiteImage().getText();
//		Assert.assertNotNull(imageSiteA,ELEMENT_AEND_ADDRESSS_IMG_VALUE);
//		
//		String locateLabel = locationPage.getLocateTitle().getText();
//		Assert.assertEquals(locateLabel,ELEMENT_LOCATE_TITLE,ELEMENT_LOCATE_TITLE_MSG);
//		
//		String imageZoom = locationPage.getZoomImage().getText();
//		Assert.assertNotNull(imageZoom,ELEMENT_ZOOM_IMG_VALUE);
		
		// Validate communications page by opening chat window and send a message
		headerPage.getCommunicationTab().click();
		
		communicationPage.getAddCommentButton().click();
		communicationPage.getAddMessageTextField().sendKeys(chatText); 
		communicationPage.getSendButton().click();
		
		//Now validate Attachments page
		headerPage.getAttachmentsTab().click();
		attachmentsPage.getDownloadsTitle().click();
		attachmentsPage.getUploadedTitle().click();
		
		
		//Now got back to previous page
		homePage.getBackButton().click();
			
		

		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.SaveRecording(driver, this.getClass().getSimpleName(),new Throwable().getStackTrace()[0].getMethodName());
			}
			
		}
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() throws IOException, InterruptedException {
		System.out.println("Tearing  down == " +this.getClass().getName());
//		TestBase.shutDownAVD();
//		Thread.sleep(3000);
		System.out.println("Tearing  down Appium == " +this.getClass().getName());
//		TestBase.stopAppiumServer();
//		Thread.sleep(8000);
	}

}
