package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class JobStatusPage extends TestBase {
	
	public JobStatusPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"Job Completed\")")
	private AndroidElement jobCompletedRadioButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Job Cancelled\")")
	private AndroidElement jobCancelledRadioButton;

	@AndroidFindBy(uiAutomator = "text(\"Any Delays\")")
	private AndroidElement jobDelayedChkBox;
	
	@AndroidFindBy(uiAutomator = "text(\"Customer Access\")")
	private AndroidElement customerAccessRadioButton;

	public AndroidElement getCustomerAccessRadioButton() {
		return customerAccessRadioButton;
	}

	public AndroidElement getJobCompletedRadioButton() {
		return jobCompletedRadioButton;
	}

	public AndroidElement getJobCancelledRadioButton() {
		return jobCancelledRadioButton;
	}

	public AndroidElement getJobDelayedChkBox() {
		return jobDelayedChkBox;
	}

	public TouchAction<?> moveToScrollToElement(AndroidDriver<AndroidElement> driver, String elementTextScrollTo){				
		return TestBase.getTouchActionForElement(driver, elementTextScrollTo);
		
	}
	

}
