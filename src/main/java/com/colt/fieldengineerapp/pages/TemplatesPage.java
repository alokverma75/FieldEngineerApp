package com.colt.fieldengineerapp.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TemplatesPage extends TestBase {
	
	public TemplatesPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}	
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_total_value")
	private AndroidElement totalTemplatesValueTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Total Templates\")")
	private AndroidElement totalTemplatesLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Name\")")
	private AndroidElement nameLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/name_value")
	private AndroidElement nameTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"View Templates\")")
	private AndroidElement viewTemplatesLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Created On\")")
	private AndroidElement createdDateLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/created_time_value")
	private AndroidElement createdDateTextField;

	@AndroidFindBy(id = "com.colt.coltengineering:id/img_icon")
	private List<AndroidElement> imageTemplateBtns;

	public AndroidElement getTotalTemplatesValueTextField() {
		return totalTemplatesValueTextField;
	}

	public AndroidElement getTotalTemplatesLabel() {
		return totalTemplatesLabel;
	}

	public AndroidElement getNameLabel() {
		return nameLabel;
	}

	public AndroidElement getNameTextField() {
		return nameTextField;
	}

	public AndroidElement getViewTemplatesLabel() {
		return viewTemplatesLabel;
	}

	public AndroidElement getCreatedDateLabel() {
		return createdDateLabel;
	}

	public AndroidElement getCreatedDateTextField() {
		return createdDateTextField;
	}

	public List<AndroidElement> getImageTemplateBtns() {
		return imageTemplateBtns;
	}

	

		

}
