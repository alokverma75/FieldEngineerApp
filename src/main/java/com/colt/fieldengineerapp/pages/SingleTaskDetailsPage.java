package com.colt.fieldengineerapp.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SingleTaskDetailsPage extends TestBase {
	
	@AndroidFindBy(uiAutomator = "text(\"Basic\")")
	AndroidElement basicTextLabel;

	@AndroidFindBy(uiAutomator = "text(\"Order Number\")")
	AndroidElement orderNumberLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Provider\")")
	AndroidElement providerLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Product Name\")")
	AndroidElement productNameLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Task ID\")")
	AndroidElement taskIDLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Type\")")
	AndroidElement typeLabel;

	@AndroidFindBy(uiAutomator = "text(\"Subject\")")
	AndroidElement subjectLabel;

	@AndroidFindBy(uiAutomator = "text(\"Town\")")
	AndroidElement townLabel;

	@AndroidFindBy(uiAutomator = "text(\"Post Code\")")
	AndroidElement postCodeLabel;

	@AndroidFindBy(uiAutomator = "text(\"Customer\")")
	AndroidElement customerLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Country\")")
	AndroidElement countryLabel;

	@AndroidFindBy(uiAutomator = "text(\"Address\")")
	AndroidElement addressLabel;

	@AndroidFindBy(uiAutomator = "text(\"Job Owner ID\")")
	AndroidElement jobOwnerIDLabel;

	@AndroidFindBy(uiAutomator = "text(\"Job ID\")")
	AndroidElement jobIDLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Job Reference\")")
	AndroidElement jobReferenceLabel;

	@AndroidFindBy(uiAutomator = "text(\"Activity Id\")")
	AndroidElement activityIDLabel;

	@AndroidFindBy(uiAutomator = "text(\"Category\")")
	AndroidElement categoryLabel;

	@AndroidFindBy(uiAutomator = "text(\"Job Status\")")
	AndroidElement jobStatusLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Job Owner\")")
	AndroidElement jobOwnerLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Planned Start Date/Time\")")
	AndroidElement plannedStartLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Planned End Date/Time\")")
	AndroidElement plannedEndDateLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Job Link\")")
	AndroidElement jobLinkLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Job Link Status\")")
	AndroidElement jobLinkStatusLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"More Details\")")
	AndroidElement moreDetailsLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Legal Customer\")")
	AndroidElement legalCustomerLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Service\")")
	AndroidElement serviceLabel;

	@AndroidFindBy(uiAutomator = "text(\"Service Ref\")")
	AndroidElement serviceRefLabel;

	@AndroidFindBy(uiAutomator = "text(\"CPD\")")
	AndroidElement cpdLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"CRD\")")
	AndroidElement crdLabel;

	@AndroidFindBy(uiAutomator = "text(\"Sub Type\")")
	AndroidElement subTypeLabel;

	@AndroidFindBy(uiAutomator = "text(\"Remarks\")")
	AndroidElement remarksLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"ERO\")")
	AndroidElement eroLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Site Name\")")
	AndroidElement siteNameLabel;

	@AndroidFindBy(uiAutomator = "text(\"Telephone\")")
	AndroidElement telephoneLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Email\")")
	AndroidElement emailLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Coop Team\")")
	AndroidElement coopTeamLabel;

	@AndroidFindBy(uiAutomator = "text(\"Coop Tech\")")
	AndroidElement coopTechLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Coop Tech Mobile\")")
	AndroidElement coopTechMobileLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Coop Tech Email\")")
	AndroidElement coopTechEmailLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_title")
	private AndroidElement elementTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Activity Id\")")
	private AndroidElement Label;
	
	@AndroidFindBy(uiAutomator = "text(\"Job Remarks\")")
	private AndroidElement jobRemarksLabel;

	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageButton")
	private AndroidElement openActionsBtn;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_value")
	private List<AndroidElement> textFieldValue;
	
	
	public AndroidElement getJobReferenceLabel() {
		return jobReferenceLabel;
	}

	public AndroidElement getProductNameLabel() {
		return productNameLabel;
	}

	public List<AndroidElement> getTextFieldValue() {
		return textFieldValue;
	}

	public AndroidElement getBasicTextLabel() {
		return basicTextLabel;
	}

	public AndroidElement getOrderNumberLabel() {
		return orderNumberLabel;
	}

	public AndroidElement getProviderLabel() {
		return providerLabel;
	}

	public AndroidElement getTaskIDLabel() {
		return taskIDLabel;
	}

	public AndroidElement getTypeLabel() {
		return typeLabel;
	}

	public AndroidElement getSubjectLabel() {
		return subjectLabel;
	}

	public AndroidElement getTownLabel() {
		return townLabel;
	}

	public AndroidElement getPostCodeLabel() {
		return postCodeLabel;
	}

	public AndroidElement getCustomerLabel() {
		return customerLabel;
	}

	public AndroidElement getCountryLabel() {
		return countryLabel;
	}

	public AndroidElement getAddressLabel() {
		return addressLabel;
	}

	public AndroidElement getJobOwnerIDLabel() {
		return jobOwnerIDLabel;
	}

	public AndroidElement getJobIDLabel() {
		return jobIDLabel;
	}

	public AndroidElement getActivityIDLabel() {
		return activityIDLabel;
	}

	public AndroidElement getCategoryLabel() {
		return categoryLabel;
	}

	public AndroidElement getJobStatusLabel() {
		return jobStatusLabel;
	}

	public AndroidElement getJobOwnerLabel() {
		return jobOwnerLabel;
	}

	public AndroidElement getPlannedStartLabel() {
		return plannedStartLabel;
	}

	public AndroidElement getPlannedEndDateLabel() {
		return plannedEndDateLabel;
	}

	public AndroidElement getJobLinkLabel() {
		return jobLinkLabel;
	}

	public AndroidElement getJobLinkStatusLabel() {
		return jobLinkStatusLabel;
	}

	public AndroidElement getMoreDetailsLabel() {
		return moreDetailsLabel;
	}

	public AndroidElement getLegalCustomerLabel() {
		return legalCustomerLabel;
	}

	public AndroidElement getServiceLabel() {
		return serviceLabel;
	}

	public AndroidElement getServiceRefLabel() {
		return serviceRefLabel;
	}

	public AndroidElement getCpdLabel() {
		return cpdLabel;
	}

	public AndroidElement getCrdLabel() {
		return crdLabel;
	}

	public AndroidElement getSubTypeLabel() {
		return subTypeLabel;
	}

	public AndroidElement getRemarksLabel() {
		return remarksLabel;
	}

	public AndroidElement getEroLabel() {
		return eroLabel;
	}

	public AndroidElement getSiteNameLabel() {
		return siteNameLabel;
	}

	public AndroidElement getTelephoneLabel() {
		return telephoneLabel;
	}

	public AndroidElement getEmailLabel() {
		return emailLabel;
	}

	public AndroidElement getCoopTeamLabel() {
		return coopTeamLabel;
	}

	public AndroidElement getCoopTechLabel() {
		return coopTechLabel;
	}

	public AndroidElement getCoopTechMobileLabel() {
		return coopTechMobileLabel;
	}

	public AndroidElement getCoopTechEmailLabel() {
		return coopTechEmailLabel;
	}

	public AndroidElement getElementTextField() {
		return elementTextField;
	}

	public AndroidElement getLabel() {
		return Label;
	}

	public AndroidElement getJobRemarksLabel() {
		return jobRemarksLabel;
	}

	public AndroidElement getOpenActionsBtn() {
		return openActionsBtn;
	}

	public SingleTaskDetailsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	//Helper Method	for scroll	
	public TouchAction<?> moveToScrollToElement(AndroidDriver<AndroidElement> driver, String elementTextScrollTo){				
		return TestBase.getTouchActionForElement(driver, elementTextScrollTo);
		
	}
	
	//We can scroll to element without tap option
	public AndroidElement scrollToElement(AndroidDriver<AndroidElement> driver, String elementTextScrollTo) {
		return TestBase.getElementByAutomatorForScroll(driver, elementTextScrollTo);
	}


}
