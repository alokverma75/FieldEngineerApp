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
	
	@AndroidFindBy(uiAutomator = "text(\"Customer\")")
	AndroidElement customerLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Job Status\")")
	AndroidElement jobStatusLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Planned Start Date/Time\")")
	AndroidElement plannedStartLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"CPD\")")
	AndroidElement cpdLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Job Remarks\")")
	AndroidElement jobRemarksLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Coop Tech Email\")")
	AndroidElement coopTechEmailLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Job ID\")")
	AndroidElement jobIDLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_title")
	private AndroidElement elementTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Activity Id\")")
	private AndroidElement Label;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageButton")
	private AndroidElement openActionsBtn;
	
	public AndroidElement getBasicTextLabel() {
		return basicTextLabel;
	}

	public AndroidElement getJobIDLabel() {
		return jobIDLabel;
	}

	public AndroidElement getElementTextField() {
		return elementTextField;
	}

	public AndroidElement getLabel() {
		return Label;
	}

	public AndroidElement getOpenActionsBtn() {
		return openActionsBtn;
	}

	public AndroidElement getCoopTechEmailLabel() {
		return coopTechEmailLabel;
	}

	public AndroidElement getCustomerLabel() {
		return customerLabel;
	}
	
	public AndroidElement getJobStatusLabel() {
		return jobStatusLabel;
	}
	
	public AndroidElement getPlannedStartLabel() {
		return plannedStartLabel;
	}

	public AndroidElement getCpdLabel() {
		return cpdLabel;
	}

	public AndroidElement getJobRemarksLabel() {
		return jobRemarksLabel;
	}

		
	public List<AndroidElement> getTextElementsByClassName(AndroidDriver<AndroidElement> driver, String elementText){
		
		return TestBase.getElementsByClassName(driver, elementText);
	}
	
	public List<AndroidElement> getTextElementsByResourceId(AndroidDriver<AndroidElement> driver, String elementText){
		
		return TestBase.getElementsById(driver, elementText);
	}
	

	public AndroidElement getOrderNumberLabel() {
		return orderNumberLabel;
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