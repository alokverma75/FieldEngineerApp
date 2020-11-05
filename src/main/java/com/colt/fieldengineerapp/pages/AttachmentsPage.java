package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AttachmentsPage extends TestBase {
	
	public AttachmentsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"Downloads\")") 
	private AndroidElement downloadsTitle;
	

	@AndroidFindBy(uiAutomator = "text(\"Uploaded\")") 
	private AndroidElement uploadedTitle;
	

	public AndroidElement getDownloadsTitle() {
		return downloadsTitle;
	}


	public AndroidElement getUploadedTitle() {
		return uploadedTitle;
	}


}
