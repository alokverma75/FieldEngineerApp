package com.colt.fieldengineerapp.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ActionsPage extends TestBase {
	
	public ActionsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"Actions\")")
	private AndroidElement actionsLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Expected Time To Reach Customer\")")
	private AndroidElement expectedTimeToReachLabel;	
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_eta_time")
	private AndroidElement estimatedArrivalTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Start Travel To Customer\")")
	private AndroidElement startTimeToTravelLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_start_time")
	private AndroidElement startTravelToCustomerTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Reached Site\")")
	private AndroidElement reachedSiteLabel;	
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_reached_time")
	private AndroidElement reachedTimeTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Add Attachments\")")
	private AndroidElement addAttachmentsLabel;	
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_attachments_number")
	private AndroidElement addAttachmentsTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Closure Notes\")")
	private AndroidElement closureNotesLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_feedback_check")
	private AndroidElement closureNotesTextField;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_feedback_text")
	private AndroidElement feedbackTextField;

	@AndroidFindBy(uiAutomator = "text(\"Submit\")")
	private AndroidElement submitButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Left Site ?\")")
	private AndroidElement leftSitesLabel;	

	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_job_completed_time")
	private AndroidElement leftSiteTextField;
	
	@AndroidFindBy(
  xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.ImageView[2]")
	private AndroidElement estimatedTimeToReachButton;

	@AndroidFindBy(
 xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.ImageView[4]")
	private AndroidElement startTravelToCustomerButton;

	@AndroidFindBy(
 xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.ImageView[6]")
	private AndroidElement reachedSiteButton;
	
	@AndroidFindBy(
 xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.ImageView[8]")
	private AndroidElement addAttachmentsButton;
	
	@AndroidFindBy(
 xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.ImageView[10]")
	private AndroidElement closureNotesButton;

	@AndroidFindBy(
 xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.ImageView[12]")
	private AndroidElement leftSiteButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Enter correct time\")")
	private AndroidElement enterCorrectTimeLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_hide")
	private AndroidElement hideActionsScreenButton;
	
	@AndroidFindBy(uiAutomator = "text(\"No\")")
	private AndroidElement noDelayButton;

	public AndroidElement getNoDelayButton() {
		return noDelayButton;
	}


	public AndroidElement getHideActionsScreenButton() {
		return hideActionsScreenButton;
	}


	public AndroidElement getEnterCorrectTimeLabel() {
		return enterCorrectTimeLabel;
	}


	public AndroidElement getFeedbackTextField() {
		return feedbackTextField;
	}


	public AndroidElement getSubmitButton() {
		return submitButton;
	}



	public AndroidElement getExpectedTimeToReachLabel() {
		return expectedTimeToReachLabel;
	}



	public AndroidElement getStartTimeToTravelLabel() {
		return startTimeToTravelLabel;
	}



	public AndroidElement getReachedSiteLabel() {
		return reachedSiteLabel;
	}



	public AndroidElement getAddAttachmentsLabel() {
		return addAttachmentsLabel;
	}



	public AndroidElement getClosureNotesLabel() {
		return closureNotesLabel;
	}



	public AndroidElement getLeftSitesLabel() {
		return leftSitesLabel;
	}



	public AndroidElement getEstimatedTimeToReachButton() {
		return estimatedTimeToReachButton;
	}
	
	

	public AndroidElement getStartTravelToCustomerButton() {
		return startTravelToCustomerButton;
	}



	public AndroidElement getReachedSiteButton() {
		return reachedSiteButton;
	}



	public AndroidElement getAddAttachmentsButton() {
		return addAttachmentsButton;
	}



	public AndroidElement getClosureNotesButton() {
		return closureNotesButton;
	}



	public AndroidElement getLeftSiteButton() {
		return leftSiteButton;
	}



	public AndroidElement getActionsLabel() {
		return actionsLabel;
	}

	public AndroidElement getEstimatedArrivalTextField() {
		return estimatedArrivalTextField;
	}

	public AndroidElement getStartTravelToCustomerTextField() {
		return startTravelToCustomerTextField;
	}

	public AndroidElement getReachedTimeTextField() {
		return reachedTimeTextField;
	}

	public AndroidElement getAddAttachmentsTextField() {
		return addAttachmentsTextField;
	}

	public AndroidElement getClosureNotesTextField() {
		return closureNotesTextField;
	}

	public AndroidElement getLeftSiteTextField() {
		return leftSiteTextField;
	}
	
	public List<AndroidElement> getTextElementsByClassName(AndroidDriver<AndroidElement> driver, String elementText){
		
		return TestBase.getElementsByClassName(driver, elementText);
	}
	
	public List<AndroidElement> getTextElementsByResourceId(AndroidDriver<AndroidElement> driver, String elementText){
		
		return TestBase.getElementsById(driver, elementText);
	}
	
	public TouchAction<?> getHourActionSwipe(AndroidDriver<AndroidElement> driver, String hourTo){
		return TestBase.getTouchActionForSwipe(driver,hourTo);
		
	}	
		
	public TouchAction<?> getMinuteActionSwipeTo(AndroidDriver<AndroidElement> driver, String minuteTo){
		return TestBase.getTouchActionForSwipe(driver, minuteTo);
		
	}
	
	public Map<String,Integer> timeDateMapAsPerTimezone(String timeZoneID){
		return TestBase.getDateTimeBasedOnTimeZone(timeZoneID);
	}
	

}
