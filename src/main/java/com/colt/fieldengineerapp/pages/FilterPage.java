package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FilterPage extends TestBase {
	
	public FilterPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"Filter By\")") 
	private AndroidElement filterTitle;	
	
	@AndroidFindBy(uiAutomator = "text(\"POM\")") 
	private AndroidElement pomChkBox;
	
	@AndroidFindBy(uiAutomator = "text(\"SBL\")") 
	private AndroidElement sblChkBox;
	
	@AndroidFindBy(uiAutomator = "text(\"Status\")") 
	private AndroidElement statusChkBox;
	
	@AndroidFindBy(uiAutomator = "text(\"New\")") 
	private AndroidElement newChkBox;
	
	@AndroidFindBy(uiAutomator = "text(\"In Progress\")") 
	private AndroidElement inProgressChkBox;

	@AndroidFindBy(uiAutomator = "text(\"Done\")") 
	private AndroidElement doneChkBox;

	@AndroidFindBy(uiAutomator = "text(\"Next 5 days\")") 
	private AndroidElement nextFiveDaysChkBox;

	@AndroidFindBy(uiAutomator = "text(\"Next 10 days\")") 
	private AndroidElement nextTenDaysChkBox;

	@AndroidFindBy(uiAutomator = "text(\"Cancel\")") 
	private AndroidElement cancelButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Discard\")") 
	private AndroidElement discardButton;

	@AndroidFindBy(uiAutomator = "text(\"Apply\")") 
	private AndroidElement applyButton;
	
	
	public AndroidElement getFilterTitle() {
		return filterTitle;
	}

	public AndroidElement getPomChkBox() {
		return pomChkBox;
	}

	public AndroidElement getSblChkBox() {
		return sblChkBox;
	}

	public AndroidElement getStatusChkBox() {
		return statusChkBox;
	}

	public AndroidElement getNewChkBox() {
		return newChkBox;
	}

	public AndroidElement getInProgressChkBox() {
		return inProgressChkBox;
	}

	public AndroidElement getDoneChkBox() {
		return doneChkBox;
	}

	public AndroidElement getNextFiveDaysChkBox() {
		return nextFiveDaysChkBox;
	}

	public AndroidElement getNextTenDaysChkBox() {
		return nextTenDaysChkBox;
	}

	public AndroidElement getCancelButton() {
		return cancelButton;
	}

	public AndroidElement getDiscardButton() {
		return discardButton;
	}

	public AndroidElement getApplyButton() {
		return applyButton;
	}
	
}
