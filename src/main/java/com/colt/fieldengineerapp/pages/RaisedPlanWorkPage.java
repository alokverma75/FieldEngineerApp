package com.colt.fieldengineerapp.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RaisedPlanWorkPage extends TestBase {
	
	
	@AndroidFindBy(uiAutomator = "text(\"Raise Planned Work\")")
	AndroidElement raisePlannedWorkLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Template\")")
	AndroidElement templateLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_template")
	AndroidElement templateDropDown;
	
	@AndroidFindBy(uiAutomator = "text(\"Standard SD\")")
	AndroidElement templateDropDownLabel;
	
	public AndroidElement getTemplateDropDownLabel() {
		return templateDropDownLabel;
	}

	@AndroidFindBy(uiAutomator = "text(\"Category\")")
	AndroidElement categoryLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_category")
	AndroidElement categoryDropDown;
	
	@AndroidFindBy(uiAutomator = "text(\"Change Description\")")
	AndroidElement changeDescriptionLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_category_description")
	AndroidElement changeDescriptionDropDown;
	
	@AndroidFindBy(uiAutomator = "text(\"Standard Ref from Change Catalogue\")")
	AndroidElement changeCatalogeLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_std_catalogue")
	AndroidElement changeCatalogeTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Configuration ID Type\")")
	AndroidElement configIDTypeLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_configuration_id")
	AndroidElement configIdTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Next\")")
	AndroidElement nextBtn;
	
	@AndroidFindBy(uiAutomator = "text(\"Previous\")")
	AndroidElement previousBtn;
	
			
	public AndroidElement getNextBtn() {
		return nextBtn;
	}

	public AndroidElement getPreviousBtn() {
		return previousBtn;
	}

	public AndroidElement getRaisePlannedWorkLabel() {
		return raisePlannedWorkLabel;
	}

	public AndroidElement getTemplateLabel() {
		return templateLabel;
	}

	public AndroidElement getTemplateDropDown() {
		return templateDropDown;
	}

	public AndroidElement getCategoryLabel() {
		return categoryLabel;
	}

	public AndroidElement getChangeDescriptionLabel() {
		return changeDescriptionLabel;
	}

	public AndroidElement getChangeCatalogeLabel() {
		return changeCatalogeLabel;
	}

	public AndroidElement getChangeCatalogeTextField() {
		return changeCatalogeTextField;
	}

	public AndroidElement getConfigIDTypeLabel() {
		return configIDTypeLabel;
	}

	public AndroidElement getConfigIdTextField() {
		return configIdTextField;
	}
	
	public AndroidElement getCategoryDropDown() {
		return categoryDropDown;
	}

	public AndroidElement getChangeDescriptionDropDown() {
		return changeDescriptionDropDown;
	}

	public List<AndroidElement> getTextElementsByClassName(AndroidDriver<AndroidElement> driver, String elementText){
		
		return TestBase.getElementsByClassName(driver, elementText);
	}
	
	public List<AndroidElement> getTextElementsByResourceId(AndroidDriver<AndroidElement> driver, String elementText){
		
		return TestBase.getElementsById(driver, elementText);
	}
	
	
	public RaisedPlanWorkPage(AndroidDriver<AndroidElement> driver) {
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
