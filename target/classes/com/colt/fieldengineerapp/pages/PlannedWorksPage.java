package com.colt.fieldengineerapp.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PlannedWorksPage extends TestBase {
	
	public PlannedWorksPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"Planned Work Detail\")")
	private AndroidElement plannedWorksPageTitle;
	
	@AndroidFindBy(uiAutomator = "text(\"Planned work List\")")
	private AndroidElement totalPlannedWorkListLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_back")
	private AndroidElement backButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Planned Works\")")
	private AndroidElement plannedWorksBtn;

	@AndroidFindBy(id = "com.colt.coltengineering:id/img_option_icon")
	private AndroidElement imagePlannedWorksButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Total Plan Works\")")
	private AndroidElement totalPlanWorksLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_total_value")
	private AndroidElement totalPlannedWorks;
	
	//complete block showing details of planned work
	@AndroidFindBy(id = "com.colt.coltengineering:id/serviceCard")
	private AndroidElement serviceCard;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/id_title")
	private AndroidElement idTitle;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/id_value")
	private AndroidElement idValue;

	@AndroidFindBy(id = "com.colt.coltengineering:id/start_date_title")
	private AndroidElement startDateTitle;

	@AndroidFindBy(id = "com.colt.coltengineering:id/start_date_value")
	private AndroidElement startDateValue;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/end_date_title")
	private AndroidElement endDateTitle;

	@AndroidFindBy(id = "com.colt.coltengineering:id/end_date_value")
	private AndroidElement endDateValue;

	@AndroidFindBy(uiAutomator = "text(\"Category\")")
	private AndroidElement categoryLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/category_value")
	private AndroidElement categoryTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Seibel Ref\")")
	private AndroidElement siebelrefLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/seibel_ref_value")
	private AndroidElement siebelRefTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Description\")")
	private AndroidElement descriptionLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/description_value")
	private AndroidElement descriptionTextField;
	
	

	public AndroidElement getPlannedWorksPageTitle() {
		return plannedWorksPageTitle;
	}

	public AndroidElement getTotalPlannedWorkListLabel() {
		return totalPlannedWorkListLabel;
	}

	public AndroidElement getBackButton() {
		return backButton;
	}

	public AndroidElement getPlannedWorksBtn() {
		return plannedWorksBtn;
	}

	public AndroidElement getImagePlannedWorksButton() {
		return imagePlannedWorksButton;
	}

	public AndroidElement getTotalPlanWorksLabel() {
		return totalPlanWorksLabel;
	}

	public AndroidElement getTotalPlannedWorks() {
		return totalPlannedWorks;
	}

	public AndroidElement getServiceCard() {
		return serviceCard;
	}

	public AndroidElement getIdTitle() {
		return idTitle;
	}

	public AndroidElement getIdValue() {
		return idValue;
	}

	public AndroidElement getStartDateTitle() {
		return startDateTitle;
	}

	public AndroidElement getStartDateValue() {
		return startDateValue;
	}

	public AndroidElement getEndDateTitle() {
		return endDateTitle;
	}

	public AndroidElement getEndDateValue() {
		return endDateValue;
	}

	public AndroidElement getCategoryLabel() {
		return categoryLabel;
	}

	public AndroidElement getCategoryTextField() {
		return categoryTextField;
	}
	
	public AndroidElement getSiebelrefLabel() {
		return siebelrefLabel;
	}


	public AndroidElement getSiebelRefTextField() {
		return siebelRefTextField;
	}

	public AndroidElement getDescriptionLabel() {
		return descriptionLabel;
	}

	public AndroidElement getDescriptionTextField() {
		return descriptionTextField;
	}

	public List<AndroidElement> findAllElementsById(AndroidDriver<AndroidElement> driver, String elementId){
		
		return TestBase.getElementsById(driver, elementId);
	}

}
