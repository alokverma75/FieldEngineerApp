package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HeaderPage extends TestBase {
	
	public HeaderPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_title")
	private AndroidElement pageTitle;
	
	@AndroidFindBy(uiAutomator = "text(\"Details\")") 
	private AndroidElement detailsTab;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_home")
	private AndroidElement homeIcon;

	@AndroidFindBy(id = "com.colt.coltengineering:id/task_select")
	private AndroidElement assignTaskIcon;

	@AndroidFindBy(id = "com.colt.coltengineering:id/task_filter")
	private AndroidElement filterTasks;
	
	@AndroidFindBy(uiAutomator = "text(\"Location\")") 
	private AndroidElement locationTab;

	@AndroidFindBy(uiAutomator = "text(\"Communication\")") 
	private AndroidElement communicationTab;

	@AndroidFindBy(uiAutomator = "text(\"Attachments\")") 
	private AndroidElement attachmentsTab;
	
	@AndroidFindBy(uiAutomator = "text(\"Assign\")")
	private AndroidElement assignButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Cancel\")")
	private AndroidElement cancelButton;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_task_start_time")
	private AndroidElement startDateTask;
	
	
	public AndroidElement getStartDateTask() {
		return startDateTask;
	}

	public AndroidElement getAssignButton() {
		return assignButton;
	}

	public AndroidElement getCancelButton() {
		return cancelButton;
	}

	public AndroidElement getPageTitle() {
		return pageTitle;
	}

	public AndroidElement getDetailsTab() {
		return detailsTab;
	}

	public AndroidElement getHomeIcon() {
		return homeIcon;
	}

	
	public AndroidElement getAssignTaskIcon() {
		return assignTaskIcon;
	}


	public AndroidElement getFilterTasks() {
		return filterTasks;
	}

	public AndroidElement getLocationTab() {
		return locationTab;
	}

	public AndroidElement getCommunicationTab() {
		return communicationTab;
	}

	public AndroidElement getAttachmentsTab() {
		return attachmentsTab;
	}
	
	
}
