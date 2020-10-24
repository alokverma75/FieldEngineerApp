package com.colt.fieldengineerapp.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;


import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RaisedPlanWorkPage extends TestBase {
	
	
	@AndroidFindBy(uiAutomator = "text(\"Raise Planned Work\")")
	private AndroidElement raisePlannedWorkLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Template\")")
	private AndroidElement templateLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_template")
	private AndroidElement templateDropDown;
	
	@AndroidFindBy(uiAutomator = "text(\"Standard SD\")")
	private AndroidElement templateDropDownLabel;	

	@AndroidFindBy(uiAutomator = "text(\"Category\")")
	private AndroidElement categoryLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_category")
	private AndroidElement categoryDropDown;
	
	@AndroidFindBy(uiAutomator = "text(\"Change Description\")")
	private AndroidElement changeDescriptionLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_category_description")
	private AndroidElement changeDescriptionDropDown;
	
	@AndroidFindBy(uiAutomator = "text(\"Standard Ref from Change Catalogue\")")
	private AndroidElement changeCatalogeLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_std_catalogue")
	private AndroidElement changeCatalogeTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Configuration ID Type\")")
	private AndroidElement configIDTypeLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_configuration_id")
	private AndroidElement configIdTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Next\")")
	private AndroidElement nextBtn;
	
	@AndroidFindBy(uiAutomator = "text(\"Previous\")")
	private AndroidElement previousBtn;
	
	@AndroidFindBy(uiAutomator = "text(\"Location Details Tier 1\")")
	private AndroidElement locationDetailsTier1Label;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_loc_details_1")
	private AndroidElement locationDetailsTier1DropDown;
	

	@AndroidFindBy(uiAutomator = "text(\"Location Details Tier 2\")")
	private AndroidElement locationDetailsTier2Label;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_loc_details_2")
	private AndroidElement locationDetailsTier2DropDown;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_site_address")
	private AndroidElement siteAddressTextField;
	
	
	@AndroidFindBy(uiAutomator = "text(\"Planned Start\")")
	private AndroidElement plannedStartDateLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_planned_start")
	private AndroidElement plannedStartTextField;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_date_plan_start")
	private AndroidElement plannedStartDateSelector;
	
	@AndroidFindBy(uiAutomator = "text(\"Planned End\")")
	private AndroidElement plannedEndDateLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_planned_end")
	private AndroidElement plannedEndTextField;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_date_plan_end")
	private AndroidElement plannedEndDateSelector;
	
	@AndroidFindBy(uiAutomator = "text(\"Backout Start\")")
	private AndroidElement backOutStartDateLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_backout_start")
	private AndroidElement backoutStartTextField;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_date_backout")
	private AndroidElement backoutStartDateSelector;
	
	@AndroidFindBy(uiAutomator = "text(\"Choose a Time Zone.\")")
	private AndroidElement timeZoneLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"GMT\")")
	private AndroidElement zoneGMTBtn;
	
	@AndroidFindBy(uiAutomator = "text(\"BST\")")
	private AndroidElement zoneBSTBtn;
	
	@AndroidFindBy(id = "android:id/hours")
	private AndroidElement hourOption;
	
	@AndroidFindBy(id = "android:id/minutes")
	private AndroidElement minutesOption;
	
	@AndroidFindBy(id = "android:id/button1")
	private AndroidElement okBtn;
	
	@AndroidFindBy(id = "android:id/button2")
	private AndroidElement cancelBtn;
	
	@AndroidFindBy(id = "android:id/month_view")
	private AndroidElement monthDateSelector;
	
	@AndroidFindBy(uiAutomator = "text(\"Order No.\")")
	private AndroidElement orderNumberLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_order_no")
	private AndroidElement orderNumberTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Requestor Email ID\")")
	private AndroidElement requesterEmailIDLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_order_no")
	private AndroidElement requesterEmailIDTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Implementer Email ID\")")
	private AndroidElement implementerEmailIDLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_implementer_email_id")
	private AndroidElement implementerEmailIDTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Implementer Mobile\")")
	private AndroidElement implementerMobileLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_implementer_mobile")
	private AndroidElement implementerMobileTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Device ID\")")
	private AndroidElement deviceIDLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_add_text")
	private AndroidElement deviceIdAddBtn;
	
	@AndroidFindBy(uiAutomator = "text(\"Input IDs\")")
	private AndroidElement inputIDLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"(USE for multiple ID)\")")
	private AndroidElement instructionUseLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_input_id")
	private AndroidElement inputTextField;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/btn_add")
	private AndroidElement addBtnForPopup;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/btn_cancel")
	private AndroidElement cancelBtnForPopup;
	
	@AndroidFindBy(uiAutomator = "text(\"Empty order id\")")
	private AndroidElement emptyOrderIdLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Please fill Order No.\")")
	private AndroidElement instructionOrderNoLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Empty config id\")")
	private AndroidElement instructionEmptyConfigLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Please fill Device ID\")")
	private AndroidElement instructionEmptyDeviceIdLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Operational Categorization Tier 1\")")
	private AndroidElement opertaionalCatTier1Label;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_operational_tier_1")
	private AndroidElement opertaionalCatTier1DropDown;
	
	@AndroidFindBy(uiAutomator = "text(\"Operational Categorization Tier 2\")")
	private AndroidElement opertaionalCatTier2Label;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_operational_tier_2")
	private AndroidElement opertaionalCatTier2DropDown;
	
	@AndroidFindBy(uiAutomator = "text(\"Operational Categorization Tier 3\")")
	private AndroidElement opertaionalCatTier3Label;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_operational_tier_3")
	private AndroidElement opertaionalCatTier3DropDown;
	
	//Warning windows for above dropdowns
	
	@AndroidFindBy(uiAutomator = "text(\"Empty operation tier 1\")")
	private AndroidElement emptyOperationTier1LabelPopUp;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a operational categorization tier 1\")")
	private AndroidElement emptyOperationCatTier1LabelPopUp;
	
	@AndroidFindBy(uiAutomator = "text(\"Empty operation tier 2\")")
	private AndroidElement emptyOperationTier2LabelPopUp;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a operational categorization tier 2\")")
	private AndroidElement emptyOperationCatTier2LabelPopUp;

	@AndroidFindBy(uiAutomator = "text(\"Empty operation tier 3\")")
	private AndroidElement emptyOperationTier3LabelPopUp;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a operational categorization tier 3\")")
	private AndroidElement emptyOperationCatTier3LabelPopUp;
	
		
	//Page 6 Product Tier
	@AndroidFindBy(uiAutomator = "text(\"Product Categorization Tier 1\")")
	private AndroidElement productCatTier1Label;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_product_tier_1")
	private AndroidElement productCatTier1DropDown;
	
	@AndroidFindBy(uiAutomator = "text(\"Product Categorization Tier 2\")")
	private AndroidElement productCatTier2Label;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_product_tier_2")
	private AndroidElement productCatTier2DropDown;
	
	@AndroidFindBy(uiAutomator = "text(\"Product Categorization Tier 3\")")
	private AndroidElement productCatTier3Label;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_product_tier_3")
	private AndroidElement productCatTier3DropDown;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/btn_submit")
	private AndroidElement finalSubmitButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Empty product tier 1\")")
	private AndroidElement emptyProductTier1LabelPopUp;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a product categorization tier 1\")")
	private AndroidElement emptyProductCatTier1LabelPopUp;
	
	@AndroidFindBy(uiAutomator = "text(\"Empty product tier 2\")")
	private AndroidElement emptyProductTier1Labe2PopUp;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a product categorization tier 2\")")
	private AndroidElement emptyProductCatTier2LabelPopUp;
	
	@AndroidFindBy(uiAutomator = "text(\"Empty product tier 3\")")
	private AndroidElement emptyProductTier3LabelPopUp;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a product categorization tier 3\")")
	private AndroidElement emptyProductCatTier3LabelPopUp;
	
	@AndroidFindBy(id = "android:id/toggle_mode")
	private AndroidElement dateToggleButton;

	
	
	public AndroidElement getDateToggleButton() {
		return dateToggleButton;
	}


	public AndroidElement getHourOption() {
		return hourOption;
	}


	public AndroidElement getMinutesOption() {
		return minutesOption;
	}


	public AndroidElement getTimeZoneLabel() {
		return timeZoneLabel;
	}


	public AndroidElement getOrderNumberLabel() {
		return orderNumberLabel;
	}


	public AndroidElement getOrderNumberTextField() {
		return orderNumberTextField;
	}


	public AndroidElement getRequesterEmailIDLabel() {
		return requesterEmailIDLabel;
	}


	public AndroidElement getRequesterEmailIDTextField() {
		return requesterEmailIDTextField;
	}


	public AndroidElement getImplementerEmailIDLabel() {
		return implementerEmailIDLabel;
	}


	public AndroidElement getImplementerEmailIDTextField() {
		return implementerEmailIDTextField;
	}


	public AndroidElement getImplementerMobileLabel() {
		return implementerMobileLabel;
	}


	public AndroidElement getImplementerMobileTextField() {
		return implementerMobileTextField;
	}


	public AndroidElement getDeviceIDLabel() {
		return deviceIDLabel;
	}


	public AndroidElement getDeviceIdAddBtn() {
		return deviceIdAddBtn;
	}


	public AndroidElement getInputIDLabel() {
		return inputIDLabel;
	}


	public AndroidElement getInstructionUseLabel() {
		return instructionUseLabel;
	}


	public AndroidElement getInputTextField() {
		return inputTextField;
	}


	public AndroidElement getAddBtnForPopup() {
		return addBtnForPopup;
	}


	public AndroidElement getCancelBtnForPopup() {
		return cancelBtnForPopup;
	}


	public AndroidElement getEmptyOrderIdLabel() {
		return emptyOrderIdLabel;
	}


	public AndroidElement getInstructionOrderNoLabel() {
		return instructionOrderNoLabel;
	}


	public AndroidElement getInstructionEmptyConfigLabel() {
		return instructionEmptyConfigLabel;
	}


	public AndroidElement getInstructionEmptyDeviceIdLabel() {
		return instructionEmptyDeviceIdLabel;
	}


	public AndroidElement getOpertaionalCatTier1Label() {
		return opertaionalCatTier1Label;
	}


	public AndroidElement getOpertaionalCatTier1DropDown() {
		return opertaionalCatTier1DropDown;
	}


	public AndroidElement getOpertaionalCatTier2Label() {
		return opertaionalCatTier2Label;
	}


	public AndroidElement getOpertaionalCatTier2DropDown() {
		return opertaionalCatTier2DropDown;
	}


	public AndroidElement getOpertaionalCatTier3Label() {
		return opertaionalCatTier3Label;
	}


	public AndroidElement getOpertaionalCatTier3DropDown() {
		return opertaionalCatTier3DropDown;
	}


	public AndroidElement getEmptyOperationTier1LabelPopUp() {
		return emptyOperationTier1LabelPopUp;
	}


	public AndroidElement getEmptyOperationCatTier1LabelPopUp() {
		return emptyOperationCatTier1LabelPopUp;
	}


	public AndroidElement getEmptyOperationTier2LabelPopUp() {
		return emptyOperationTier2LabelPopUp;
	}


	public AndroidElement getEmptyOperationCatTier2LabelPopUp() {
		return emptyOperationCatTier2LabelPopUp;
	}


	public AndroidElement getEmptyOperationTier3LabelPopUp() {
		return emptyOperationTier3LabelPopUp;
	}


	public AndroidElement getEmptyOperationCatTier3LabelPopUp() {
		return emptyOperationCatTier3LabelPopUp;
	}


	public AndroidElement getProductCatTier1Label() {
		return productCatTier1Label;
	}


	public AndroidElement getProductCatTier1DropDown() {
		return productCatTier1DropDown;
	}


	public AndroidElement getProductCatTier2Label() {
		return productCatTier2Label;
	}


	public AndroidElement getProductCatTier2DropDown() {
		return productCatTier2DropDown;
	}


	public AndroidElement getProductCatTier3Label() {
		return productCatTier3Label;
	}


	public AndroidElement getProductCatTier3DropDown() {
		return productCatTier3DropDown;
	}


	public AndroidElement getFinalSubmitButton() {
		return finalSubmitButton;
	}


	public AndroidElement getEmptyProductTier1LabelPopUp() {
		return emptyProductTier1LabelPopUp;
	}


	public AndroidElement getEmptyProductCatTier1LabelPopUp() {
		return emptyProductCatTier1LabelPopUp;
	}


	public AndroidElement getEmptyProductTier1Labe2PopUp() {
		return emptyProductTier1Labe2PopUp;
	}


	public AndroidElement getEmptyProductCatTier2LabelPopUp() {
		return emptyProductCatTier2LabelPopUp;
	}


	public AndroidElement getEmptyProductTier3LabelPopUp() {
		return emptyProductTier3LabelPopUp;
	}


	public AndroidElement getEmptyProductCatTier3LabelPopUp() {
		return emptyProductCatTier3LabelPopUp;
	}


	public AndroidElement getMonthDateSelector() {
		return monthDateSelector;
	}


	public AndroidElement getOkBtn() {
		return okBtn;
	}


	public AndroidElement getCancelBtn() {
		return cancelBtn;
	}


	public AndroidElement getZoneGMTBtn() {
		return zoneGMTBtn;
	}


	public AndroidElement getZoneBSTBtn() {
		return zoneBSTBtn;
	}


	public AndroidElement getPlannedStartDateLabel() {
		return plannedStartDateLabel;
	}


	public AndroidElement getPlannedStartTextField() {
		return plannedStartTextField;
	}


	public AndroidElement getPlannedStartDateSelector() {
		return plannedStartDateSelector;
	}


	public AndroidElement getPlannedEndDateLabel() {
		return plannedEndDateLabel;
	}


	public AndroidElement getPlannedEndTextField() {
		return plannedEndTextField;
	}


	public AndroidElement getPlannedEndDateSelector() {
		return plannedEndDateSelector;
	}


	public AndroidElement getBackOutStartDateLabel() {
		return backOutStartDateLabel;
	}


	public AndroidElement getBackoutStartTextField() {
		return backoutStartTextField;
	}


	public AndroidElement getBackoutStartDateSelector() {
		return backoutStartDateSelector;
	}


	public AndroidElement getSiteAddressTextField() {
		return siteAddressTextField;
	}


	public AndroidElement getLocationDetailsTier2Label() {
		return locationDetailsTier2Label;
	}
	
	
	public AndroidElement getLocationDetailsTier2DropDown() {
		return locationDetailsTier2DropDown;
	}

	
	public AndroidElement getLocationDetailsTier1Label() {
		return locationDetailsTier1Label;
	}
	
	
	public AndroidElement getLocationDetailsTier1DropDown() {
		return locationDetailsTier1DropDown;
	}


	public AndroidElement getTemplateDropDownLabel() {
		return templateDropDownLabel;
	}
			
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
	
	public String getDateAsPerPattern(String pattern) {
		return TestBase.getDate(pattern);
		
	}
	
	public Map<String,Integer> timeDateMapAsPerTimezone(String timeZoneID){
		return TestBase.getDateTimeBasedOnTimeZone(timeZoneID);
	}
	
	public TouchAction<?> getHourActionSwipe(AndroidDriver<AndroidElement> driver, String hourTo){
		return TestBase.getTouchActionForSwipe(driver,hourTo);
		
	}	
		
	public TouchAction<?> getMinuteActionSwipeTo(AndroidDriver<AndroidElement> driver, String minuteTo){
		return TestBase.getTouchActionForSwipe(driver, minuteTo);
		
	}
	
	public TouchAction<?> moveHourMinuteFromTillTo(AndroidDriver<AndroidElement> driver, String swipeFrom, String swipeTo){
		return TestBase.getTouchActionForPress(driver, swipeFrom, swipeTo);
		
	}
	
	


}
