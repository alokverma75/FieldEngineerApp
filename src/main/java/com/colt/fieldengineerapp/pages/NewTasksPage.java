package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewTasksPage extends TestBase {
	
	public NewTasksPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_activity_id")
	private AndroidElement activityIDValue;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_location")
	private AndroidElement imageLocation;

	@AndroidFindBy(uiAutomator = "text(\"DESCRIPTION\")") 
	private AndroidElement descriptionTitle;
	
	@AndroidFindBy(uiAutomator = "text(\"TYPE\")") 
	private AndroidElement typeTitle;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_type_value")
	private AndroidElement typeValue;

	@AndroidFindBy(uiAutomator = "text(\"PRIORITY\")") 
	private AndroidElement priorityTitle;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_priority_value")
	private AndroidElement priorityValue;


	@AndroidFindBy(uiAutomator = "text(\"STATUS\")") 
	private AndroidElement statusTitle;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_status_value")
	private AndroidElement statusValue;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_date_no")
	private AndroidElement dateValue;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_day")
	private AndroidElement monthValue;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_time")
	private AndroidElement timeValue;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_next")
	private AndroidElement imageNext;

	public AndroidElement getActivityIDValue() {
		return activityIDValue;
	}

	public AndroidElement getImageLocation() {
		return imageLocation;
	}

	public AndroidElement getDescriptionTitle() {
		return descriptionTitle;
	}

	public AndroidElement getTypeTitle() {
		return typeTitle;
	}

	public AndroidElement getTypeValue() {
		return typeValue;
	}

	public AndroidElement getPriorityTitle() {
		return priorityTitle;
	}

	public AndroidElement getPriorityValue() {
		return priorityValue;
	}

	public AndroidElement getStatusTitle() {
		return statusTitle;
	}

	public AndroidElement getStatusValue() {
		return statusValue;
	}

	public AndroidElement getDateValue() {
		return dateValue;
	}

	public AndroidElement getMonthValue() {
		return monthValue;
	}

	public AndroidElement getTimeValue() {
		return timeValue;
	}

	public AndroidElement getImageNext() {
		return imageNext;
	}	
	
}
