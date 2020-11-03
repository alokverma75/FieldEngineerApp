package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends TestBase {
	
	public HomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"Tasks\")")
	AndroidElement homePageTasksTitle;
	
	@AndroidFindBy(uiAutomator = "text(\"Field Experts\")")
	AndroidElement homePageTitle;
	
	@AndroidFindBy(uiAutomator = "text(\"View All\")")
	AndroidElement viewAllTasksBtn;

	@AndroidFindBy(uiAutomator = "text(\"Raise Plan Work\")") 
	AndroidElement raisePlanWork;
	
	@AndroidFindBy(uiAutomator = "text(\"Templates\")") 
	AndroidElement templatesButton;

	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_option_icon")
	AndroidElement raisePlanWorkIcon;
	
	@AndroidFindBy(uiAutomator = "text(\"フィールド専門家\")")
	private AndroidElement japaneseLanguaLabel;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
	private AndroidElement drawerButton;

	public AndroidElement getDrawerButton() {
		return drawerButton;
	}

	public AndroidElement getJapaneseLanguaLabel() {
		return japaneseLanguaLabel;
	}

	public AndroidElement getViewAllTasksBtn() {
		return viewAllTasksBtn;
	}
	
	public AndroidElement getRaisePlanWork() {
		return raisePlanWork;
	}

	public AndroidElement getRaisePlanWorkIcon() {
		return raisePlanWorkIcon;
	}

		
	public AndroidElement getHomePageTasksTitle() {
		return homePageTasksTitle;
	}


	public AndroidElement getHomePageTitle() {
		return homePageTitle;
	}	

	public AndroidElement getTemplatesButton() {
		return templatesButton;
	}

	public boolean validateHomePageTasksTitle(String element){
		return homePageTasksTitle.getText().equals(element);
	}
	
	public boolean validateHomePageTitle(String element){
		return homePageTitle.getText().equals(element);
	}



	

}
