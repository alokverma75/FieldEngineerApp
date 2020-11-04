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
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_title")
	private AndroidElement homePageTasksTitle;
	
	@AndroidFindBy(uiAutomator = "text(\"Field Experts\")")
	private AndroidElement homePageTitle;
	
	@AndroidFindBy(uiAutomator = "text(\"View All\")")
	private AndroidElement viewAllTasksBtn;

	@AndroidFindBy(uiAutomator = "text(\"Raise Plan Work\")") 
	private AndroidElement raisePlanWork;
	
	@AndroidFindBy(uiAutomator = "text(\"Templates\")") 
	private AndroidElement templatesButton;

	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_option_icon")
	private AndroidElement raisePlanWorkIcon;
	
	@AndroidFindBy(uiAutomator = "text(\"フィールド専門家\")")
	private AndroidElement japaneseLanguaLabel;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
	private AndroidElement drawerButton;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/new_count")
	private AndroidElement newTasksCount;
	
	@AndroidFindBy(uiAutomator = "text(\"New\")") 
	private AndroidElement newTasksTitle;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_new")
	private AndroidElement newTasksImageBtn;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/inprogress_count")
	private AndroidElement inprogressTasksCount;
	
	@AndroidFindBy(uiAutomator = "text(\"In Progress\")") 
	private AndroidElement inprogressTasksTitle;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_inprogress")
	private AndroidElement inrogressTasksImageBtn;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/closed_count")
	private AndroidElement completedTasksCount;
	
	@AndroidFindBy(uiAutomator = "text(\"Completed\")") 
	private AndroidElement completedTasksTitle;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_closed")
	private AndroidElement completedTasksImageBtn;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_maintainence_count")
	private AndroidElement maintainanceTasksCount;
	
	//spell check to be corrected
	@AndroidFindBy(uiAutomator = "text(\"Maintainence\")") 
	private AndroidElement maintainenaceTasksTitle;

	@AndroidFindBy(id = "com.colt.coltengineering:id/img_maintainence")
	private AndroidElement maintainenaceTasksImageBtn;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_installation_count")
	private AndroidElement installationTasksCount;
	
	@AndroidFindBy(uiAutomator = "text(\"Installation\")") 
	private AndroidElement installationTasksTitle;

	@AndroidFindBy(id = "com.colt.coltengineering:id/img_installation")
	private AndroidElement installationTasksImageBtn;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_refresh")
	private AndroidElement refreshTasksBtn;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_refresh")
	private AndroidElement refreshTasksImageBtn;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_back")
	private AndroidElement backButton;
	
	@AndroidFindBy(uiAutomator = "text(\"My Tasks\")") 
	private AndroidElement myTasksTitle;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_total_value")
	private AndroidElement myTasksCount;
	
	public AndroidElement getMyTasksTitle() {
		return myTasksTitle;
	}

	public AndroidElement getMyTasksCount() {
		return myTasksCount;
	}

	public AndroidElement getNewTasksCount() {
		return newTasksCount;
	}

	public AndroidElement getNewTasksTitle() {
		return newTasksTitle;
	}

	public AndroidElement getNewTasksImageBtn() {
		return newTasksImageBtn;
	}

	public AndroidElement getInprogressTasksCount() {
		return inprogressTasksCount;
	}

	public AndroidElement getInprogressTasksTitle() {
		return inprogressTasksTitle;
	}

	public AndroidElement getInrogressTasksImageBtn() {
		return inrogressTasksImageBtn;
	}

	public AndroidElement getCompletedTasksCount() {
		return completedTasksCount;
	}

	public AndroidElement getCompletedTasksTitle() {
		return completedTasksTitle;
	}

	public AndroidElement getCompletedTasksImageBtn() {
		return completedTasksImageBtn;
	}

	public AndroidElement getMaintainanceTasksCount() {
		return maintainanceTasksCount;
	}

	public AndroidElement getMaintainenaceTasksTitle() {
		return maintainenaceTasksTitle;
	}

	public AndroidElement getMaintainenaceTasksImageBtn() {
		return maintainenaceTasksImageBtn;
	}

	public AndroidElement getInstallationTasksCount() {
		return installationTasksCount;
	}

	public AndroidElement getInstallationTasksTitle() {
		return installationTasksTitle;
	}

	public AndroidElement getInstallationTasksImageBtn() {
		return installationTasksImageBtn;
	}

	public AndroidElement getRefreshTasksBtn() {
		return refreshTasksBtn;
	}

	public AndroidElement getRefreshTasksImageBtn() {
		return refreshTasksImageBtn;
	}

	public AndroidElement getBackButton() {
		return backButton;
	}

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
