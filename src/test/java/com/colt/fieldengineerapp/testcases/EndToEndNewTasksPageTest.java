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
import com.colt.fieldengineerapp.pages.ActionsPage;
import com.colt.fieldengineerapp.pages.AllTasksListPage;
import com.colt.fieldengineerapp.pages.AttachmentsPage;
import com.colt.fieldengineerapp.pages.CommunicationPage;
import com.colt.fieldengineerapp.pages.HeaderPage;
import com.colt.fieldengineerapp.pages.HomePage;
import com.colt.fieldengineerapp.pages.LandingPage;
import com.colt.fieldengineerapp.pages.LocationPage;
import com.colt.fieldengineerapp.pages.LoginPage;
import com.colt.fieldengineerapp.pages.NewTasksPage;
import com.colt.fieldengineerapp.pages.SingleTaskDetailsPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EndToEndNewTasksPageTest extends TestBase {

	LoginPage loginPage;
	LandingPage landingPage;
	HomePage homePage;
	AllTasksListPage allTasksListPage;
	SingleTaskDetailsPage singleTaskDetailsPage;
	ActionsPage actionsPage;
	NewTasksPage newTasksPage;
	HeaderPage headerPage;
	LocationPage locationPage;
	CommunicationPage communicationPage;
	AttachmentsPage attachmentsPage;
	AndroidDriver<AndroidElement> driver;
	List<AndroidElement> listofTextView;
	

	public EndToEndNewTasksPageTest() throws MalformedURLException, IOException {
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
		newTasksPage = new NewTasksPage(driver);
		headerPage = new HeaderPage(driver);
		locationPage = new LocationPage(driver);
		communicationPage = new CommunicationPage(driver);
		attachmentsPage = new AttachmentsPage(driver);
		allTasksListPage = new AllTasksListPage(driver);
		singleTaskDetailsPage = new SingleTaskDetailsPage(driver);
		landingPage = loginPage.login(driver, prop.getProperty("userID"), prop.getProperty("password"));
		Thread.sleep(2000);
		landingPage.getContinueBtn().click();
		Thread.sleep(3000);

	}


	
	@Test
	public void testNonNullJobRemarksdField() throws InterruptedException, IOException {
		if(prop.getProperty(ELEMENT_RECORDING_NEEDED) != null) {
			if(prop.getProperty(ELEMENT_RECORDING_NEEDED).equals(ELEMENT_TRUE)) {
				TestBase.startRecording(driver);
			}
			
		}
		
		homePage.getNewTasksImageBtn().click();
		headerPage.getDetailsTab().click();
		
		//check for Page elements title
		String basiclabel = singleTaskDetailsPage.getBasicTextLabel().getText();
		Assert.assertEquals(basiclabel,ELEMENT_BASIC_TITLE,ELEMENT_BASIC_TITLE_MSG);
		
		String orderlabel = singleTaskDetailsPage.getOrderNumberLabel().getText();
		Assert.assertEquals(orderlabel,ELEMENT_ORDER_NUMBER_TITLE,ELEMENT_ORDER_NUMBER_TITLE_MSG);
		System.out.println("Label is " + orderlabel);
				
		String providerlabel = singleTaskDetailsPage.getProviderLabel().getText();
		Assert.assertEquals(providerlabel,ELEMENT_PROVIDER_TITLE,ELEMENT_PROVIDER_TITLE_MSG);
		System.out.println("Label is " + providerlabel);
		
		String productNamelabel = singleTaskDetailsPage.getProductNameLabel().getText();
		Assert.assertEquals(productNamelabel,ELEMENT_PRODUCT_NAME_TITLE,ELEMENT_PRODUCT_NAME_TITLE_MSG);
		System.out.println("Label is " + orderlabel);

		String taskIDlabel = singleTaskDetailsPage.getTaskIDLabel().getText();
		Assert.assertEquals(taskIDlabel,ELEMENT_TASK_ID_TITLE,ELEMENT_TASK_ID_TITLE_MSG);
		System.out.println("Label is " + orderlabel);

		String typelabel = singleTaskDetailsPage.getTypeLabel().getText();
		Assert.assertEquals(typelabel,ELEMENT_TYPE_TITLE,ELEMENT_TYPE_TITLE_MSG);
		System.out.println("Label is " + typelabel);
		
		String subjectlabel = singleTaskDetailsPage.getSubjectLabel().getText();
		Assert.assertEquals(subjectlabel,ELEMENT_SUBJECT_TITLE,ELEMENT_SUBJECT_TITLE_MSG);
		System.out.println("Label is " + subjectlabel);

		String townlabel = singleTaskDetailsPage.getTownLabel().getText();
		Assert.assertEquals(subjectlabel,ELEMENT_TOWN_TITLE,ELEMENT_TOWN_TITLE_MSG);
		System.out.println("Label is " + townlabel);
		
		String postCodelabel = singleTaskDetailsPage.getPostCodeLabel().getText();
		Assert.assertEquals(postCodelabel,ELEMENT_POST_CODE_TITLE,ELEMENT_POST_CODE_TITLE_MSG);
		System.out.println("Label is " + postCodelabel);

		String customerlabel = singleTaskDetailsPage.getCustomerLabel().getText();
		Assert.assertEquals(customerlabel,ELEMENT_CUSTOMER_TITLE,ELEMENT_CUSTOMER_TITLE_MSG);
		System.out.println("Label is " + customerlabel);

		String countrylabel = singleTaskDetailsPage.getCountryLabel().getText();
		Assert.assertEquals(countrylabel,ELEMENT_COUNTRY_TITLE,ELEMENT_COUNTRY_TITLE_MSG);
		System.out.println("Label is " + countrylabel);
		
		String addresslabel = singleTaskDetailsPage.getAddressLabel().getText();
		Assert.assertEquals(addresslabel,ELEMENT_ADDRESS_TITLE,ELEMENT_ADDRESS_TITLE_MSG);
		System.out.println("Label is " + addresslabel);
		
		String jobOwnerIDlabel = singleTaskDetailsPage.getJobOwnerIDLabel().getText();
		Assert.assertEquals(jobOwnerIDlabel,ELEMENT_JOB_OWNDER_ID_TITLE,ELEMENT_JOB_OWNDER_ID_TITLE_MSG);
		System.out.println("Label is " + jobOwnerIDlabel);
		
		String jobIDlabel = singleTaskDetailsPage.getJobIDLabel().getText();
		Assert.assertEquals(jobIDlabel,ELEMENT_JOB_ID_TITLE,ELEMENT_JOB_ID_TITLE_MSG);
		System.out.println("Label is " + jobIDlabel);
		
		String activityIDlabel = singleTaskDetailsPage.getActivityIDLabel().getText();
		Assert.assertEquals(activityIDlabel,ELEMENT_ACTIVITY_ID_TITLE,ELEMENT_ACTIVITY_ID_TITLE_MSG);
		System.out.println("Label is " + activityIDlabel);

		String categorylabel = singleTaskDetailsPage.getCategoryLabel().getText();
		Assert.assertEquals(categorylabel,ELEMENT_CATEGORY_TITLE,ELEMENT_CATEGORY_TITLE_MSG);
		System.out.println("Label is " + categorylabel);
		
		String jobStatuslabel = singleTaskDetailsPage.getJobStatusLabel().getText();
		Assert.assertEquals(jobStatuslabel,ELEMENT_JOB_STATUS_TITLE,ELEMENT_JOB_STATUS_TITLE_MSG);
		System.out.println("Label is " + jobStatuslabel);
		
		String jobOwnerlabel = singleTaskDetailsPage.getJobOwnerLabel().getText();
		Assert.assertEquals(jobOwnerlabel,ELEMENT_JOB_OWNER_TITLE,ELEMENT_JOB_OWNER_TITLE_MSG);
		System.out.println("Label is " + jobOwnerlabel);

		String plannedStartlabel = singleTaskDetailsPage.getPlannedStartLabel().getText();
		Assert.assertEquals(plannedStartlabel,ELEMENT_PLANNED_START_DATE_TITLE,ELEMENT_PLANNED_START_DATE_TITLE_MSG);
		System.out.println("Label is " + plannedStartlabel);

		String plannedEndlabel = singleTaskDetailsPage.getPlannedEndDateLabel().getText();
		Assert.assertEquals(plannedEndlabel,ELEMENT_PLANNED_END_DATE_TITLE,ELEMENT_PLANNED_END_DATE_TITLE_MSG);
		System.out.println("Label is " + jobStatuslabel);

		String jobLinklabel = singleTaskDetailsPage.getJobLinkLabel().getText();
		Assert.assertEquals(jobLinklabel,ELEMENT_JOB_LINK_TITLE,ELEMENT_JOB_LINK_TITLE_MSG);
		System.out.println("Label is " + jobLinklabel);

		String jobLinkStatuslabel = singleTaskDetailsPage.getJobLinkStatusLabel().getText();
		Assert.assertEquals(jobLinkStatuslabel,ELEMENT_JOB_LINK_STATUS_TITLE,ELEMENT_JOB_LINK_STATUS_TITLE_MSG);
		System.out.println("Label is " + jobLinkStatuslabel);
		
		String moreDetailslabel = singleTaskDetailsPage.getMoreDetailsLabel().getText();
		Assert.assertEquals(moreDetailslabel,ELEMENT_MORE_DETAILS_TITLE,ELEMENT_MORE_DETAILS_TITLE_MSG);
		System.out.println("Label is " + moreDetailslabel);

		String legalCustomerlabel = singleTaskDetailsPage.getLegalCustomerLabel().getText();
		Assert.assertEquals(legalCustomerlabel,ELEMENT_LEGAL_CUST_TITLE,ELEMENT_LEGAL_CUST_TITLE_MSG);
		System.out.println("Label is " + legalCustomerlabel);

		String servicelabel = singleTaskDetailsPage.getServiceLabel().getText();
		Assert.assertEquals(servicelabel,ELEMENT_SERVICE_TITLE,ELEMENT_SERVICE_TITLE_MSG);
		System.out.println("Label is " + servicelabel);
		
		String serviceReflabel = singleTaskDetailsPage.getServiceRefLabel().getText();
		Assert.assertEquals(serviceReflabel,ELEMENT_SERVICE_REF_TITLE,ELEMENT_SERVICE_REF_TITLE_MSG);
		System.out.println("Label is " + serviceReflabel);

		String cpdlabel = singleTaskDetailsPage.getCpdLabel().getText();
		Assert.assertEquals(cpdlabel,ELEMENT_CPD_TITLE,ELEMENT_CPD_TITLE_MSG);
		System.out.println("Label is " + cpdlabel);

		String crdlabel = singleTaskDetailsPage.getServiceRefLabel().getText();
		Assert.assertEquals(crdlabel,ELEMENT_CRD_TITLE,ELEMENT_CRD_TITLE_MSG);
		System.out.println("Label is " + crdlabel);

		String subtypelabel = singleTaskDetailsPage.getSubTypeLabel().getText();
		Assert.assertEquals(subtypelabel,ELEMENT_SUB_TYPE_TITLE,ELEMENT_SUB_TYPE_TITLE_MSG);
		System.out.println("Label is " + subtypelabel);
		
		String remarkslabel = singleTaskDetailsPage.getRemarksLabel().getText();
		Assert.assertEquals(remarkslabel,ELEMENT_REMARKS_TITLE,ELEMENT_REMARKS_TITLE_MSG);
		System.out.println("Label is " + remarkslabel);

		String erolabel = singleTaskDetailsPage.getEroLabel().getText();
		Assert.assertEquals(erolabel,ELEMENT_ERO_TITLE,ELEMENT_ERO_TITLE_MSG);
		System.out.println("Label is " + erolabel);

		String siteNamelabel = singleTaskDetailsPage.getSiteNameLabel().getText();
		Assert.assertEquals(siteNamelabel,ELEMENT_SITE_NAME_TITLE,ELEMENT_SITE_NAME_TITLE_MSG);
		System.out.println("Label is " + siteNamelabel);

		String telephonelabel = singleTaskDetailsPage.getTelephoneLabel().getText();
		Assert.assertEquals(telephonelabel,ELEMENT_TELEPHONE_TITLE,ELEMENT_TELEPHONE_TITLE_MSG);
		System.out.println("Label is " + telephonelabel);

		String emailLabel = singleTaskDetailsPage.getEmailLabel().getText();
		Assert.assertEquals(emailLabel,ELEMENT_EMAIL_TITLE,ELEMENT_EMAIL_TITLE_MSG);
		System.out.println("Label is " + emailLabel);
		
		String jobRemarksLabel = singleTaskDetailsPage.getJobRemarksLabel().getText();
		Assert.assertEquals(jobRemarksLabel,ELEMENT_JOB_REMARKS_TITLE,ELEMENT_JOB_REMARKS_TITLE_MSG);
		System.out.println("Label is " + jobRemarksLabel);
		
		String coopTeamLabel = singleTaskDetailsPage.getCoopTeamLabel().getText();
		Assert.assertEquals(coopTeamLabel,ELEMENT_COOP_TEAM_TITLE,ELEMENT_COOP_TEAM_TITLE_MSG);
		System.out.println("Label is " + coopTeamLabel);

		String coopTechLabel = singleTaskDetailsPage.getCoopTechLabel().getText();
		Assert.assertEquals(coopTechLabel,ELEMENT_COOP_TECH_TITLE,ELEMENT_COOP_TECH_TITLE_MSG);
		System.out.println("Label is " + coopTechLabel);
		
		String coopTechMobLabel = singleTaskDetailsPage.getCoopTechMobileLabel().getText();
		Assert.assertEquals(coopTechMobLabel,ELEMENT_COOP_TECH_MOB_TITLE,ELEMENT_COOP_TECH_MOB_TITLE_MSG);
		System.out.println("Label is " + coopTechLabel);
		
		String coopTechEmailLabel = singleTaskDetailsPage.getCoopTechEmailLabel().getText();
		Assert.assertEquals(coopTechEmailLabel,ELEMENT_COOP_TECH_EMAIL_TITLE,ELEMENT_COOP_TECH_EMAIL_TITLE_MSG);
		System.out.println("Label is " + coopTechEmailLabel);











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

	@AfterTest(alwaysRun = true)
	public void tearDown() throws IOException, InterruptedException {
		System.out.println("Tearing  down == " +this.getClass().getName());
		TestBase.shutDownAVD();
		Thread.sleep(3000);
		System.out.println("Tearing  down Appium == " +this.getClass().getName());
		TestBase.stopAppiumServer();
		Thread.sleep(8000);
	}

}
