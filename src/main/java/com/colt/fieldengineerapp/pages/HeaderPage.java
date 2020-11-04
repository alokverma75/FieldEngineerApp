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
	
	@AndroidFindBy(uiAutomator = "text(\"Details\")") 
	private AndroidElement detailsTab;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_home")
	private AndroidElement homeIcon;

	@AndroidFindBy(id = "com.colt.coltengineering:id/task_select")
	private AndroidElement assignTask;

	@AndroidFindBy(id = "com.colt.coltengineering:id/task_filter")
	private AndroidElement filterTasks;
	
	@AndroidFindBy(uiAutomator = "text(\"Location\")") 
	private AndroidElement locationTab;

	@AndroidFindBy(uiAutomator = "text(\"Communication\")") 
	private AndroidElement communicationTab;

	@AndroidFindBy(uiAutomator = "text(\"Attachments\")") 
	private AndroidElement attachmentsTab;

	public AndroidElement getDetailsTab() {
		return detailsTab;
	}

	public AndroidElement getHomeIcon() {
		return homeIcon;
	}

	public AndroidElement getAssignTask() {
		return assignTask;
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
