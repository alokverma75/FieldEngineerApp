package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ConfirmPage extends TestBase {
	
	public ConfirmPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"Planned Work Preview\")")
	private AndroidElement plannedWorkScreenLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Template\")")
	private AndroidElement templateLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_template")
	private AndroidElement templateTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Category\")")
	private AndroidElement categoryLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_category")
	private AndroidElement categoryTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Change Description\")")
	private AndroidElement changeDescriptionLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_category_description")
	private AndroidElement changeDescriptionTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Standard Ref from Change Catalogue\")")
	private AndroidElement standardRefChangeCatLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_cstd_catalogue")
	private AndroidElement standardRefChangeCatTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Configuration ID Type\")")
	private AndroidElement configurationIDTypeLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_config_id_type")
	private AndroidElement configurationIDTypeTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Location Details Tier 1\")")
	private AndroidElement locationDetailsTier1Label;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_loc_details_1")
	private AndroidElement locationDetailsTier1TextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Location Details Tier 2\")")
	private AndroidElement locationDetailsTier2Label;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_loc_details_2")
	private AndroidElement locationDetailsTier2TextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Site Address\")")
	private AndroidElement siteAddressLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_site_address")
	private AndroidElement siteAddressTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Planned Start\")")
	private AndroidElement plannedStartLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_planned_start_date")
	private AndroidElement plannedStartTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Planned End\")")
	private AndroidElement plannedEndLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_planned_end_date")
	private AndroidElement plannedEndTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Backout Start\")")
	private AndroidElement backoutStartLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_backout_start")
	private AndroidElement backoutStartTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Order No.\")")
	private AndroidElement orderNoLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_order_no")
	private AndroidElement orderNoTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Requestor Email ID\")")
	private AndroidElement requestorEmailIDLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_requester_email_id")
	private AndroidElement requestorEmailIDTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Implementer Email ID\")")
	private AndroidElement implementerEmailIDLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_implementer_email_id")
	private AndroidElement implementerEmailIDTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Implementer Mobile\")")
	private AndroidElement implementerMobileLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_implementer_mobile")
	private AndroidElement implementerMobileTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Configuration ID\")")
	private AndroidElement configurationIDLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_config_id")
	private AndroidElement configurationIDTextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Operational Categorization Tier 1\")")
	private AndroidElement operationalCatTier1Label;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_operational_tier_1")
	private AndroidElement operationalCatTier1TextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Operational Categorization Tier 2\")")
	private AndroidElement operationalCatTier2Label;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_operational_tier_2")
	private AndroidElement operationalCatTier2TextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Operational Categorization Tier 3\")")
	private AndroidElement operationalCatTier3Label;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_operational_tier_3")
	private AndroidElement operationalCatTier3TextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Product Categorization Tier 1\")")
	private AndroidElement productTier1Label;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_product_tier_1")
	private AndroidElement productTier1TextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Product Categorization Tier 2\")")
	private AndroidElement productTier2Label;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_product_tier_2")
	private AndroidElement productTier2TextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Product Categorization Tier 3\")")
	private AndroidElement productTier3Label;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_product_tier_3")
	private AndroidElement productTier3TextField;
	
	@AndroidFindBy(uiAutomator = "text(\"Want to save as a Template ?\")")
	private AndroidElement saveTemplateConfirmLabel;

	@AndroidFindBy(uiAutomator = "text(\"Enter your Template name\")")
	private AndroidElement nameTemplateConfirmLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_template_name")
	private AndroidElement enterTemplateNameTextField;

	
	@AndroidFindBy(id = "android:id/button1")
	private AndroidElement okButton;

	@AndroidFindBy(id = "android:id/button2")
	private AndroidElement cancelButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Congratulations!!!\")")
	private AndroidElement congratsPopUpLabel;
	
	@AndroidFindBy(id = "android:id/button3")
	private AndroidElement okButtonForCongratsPopUp;

	
	
	public AndroidElement getCongratsPopUpLabel() {
		return congratsPopUpLabel;
	}

	public AndroidElement getOkButtonForCongratsPopUp() {
		return okButtonForCongratsPopUp;
	}

	public AndroidElement getNameTemplateConfirmLabel() {
		return nameTemplateConfirmLabel;
	}

	public AndroidElement getEnterTemplateNameTextField() {
		return enterTemplateNameTextField;
	}

	public AndroidElement getSaveTemplateConfirmLabel() {
		return saveTemplateConfirmLabel;
	}

	public AndroidElement getCancelButton() {
		return cancelButton;
	}

	public AndroidElement getPlannedWorkScreenLabel() {
		return plannedWorkScreenLabel;
	}

	public AndroidElement getTemplateLabel() {
		return templateLabel;
	}

	public AndroidElement getTemplateTextField() {
		return templateTextField;
	}

	public AndroidElement getCategoryLabel() {
		return categoryLabel;
	}

	public AndroidElement getCategoryTextField() {
		return categoryTextField;
	}

	public AndroidElement getChangeDescriptionLabel() {
		return changeDescriptionLabel;
	}

	public AndroidElement getChangeDescriptionTextField() {
		return changeDescriptionTextField;
	}

	public AndroidElement getStandardRefChangeCatLabel() {
		return standardRefChangeCatLabel;
	}

	public AndroidElement getStandardRefChangeCatTextField() {
		return standardRefChangeCatTextField;
	}

	public AndroidElement getConfigurationIDTypeLabel() {
		return configurationIDTypeLabel;
	}

	public AndroidElement getConfigurationIDTypeTextField() {
		return configurationIDTypeTextField;
	}

	public AndroidElement getLocationDetailsTier1Label() {
		return locationDetailsTier1Label;
	}

	public AndroidElement getLocationDetailsTier1TextField() {
		return locationDetailsTier1TextField;
	}

	public AndroidElement getLocationDetailsTier2Label() {
		return locationDetailsTier2Label;
	}

	public AndroidElement getLocationDetailsTier2TextField() {
		return locationDetailsTier2TextField;
	}

	public AndroidElement getSiteAddressLabel() {
		return siteAddressLabel;
	}

	public AndroidElement getSiteAddressTextField() {
		return siteAddressTextField;
	}

	public AndroidElement getPlannedStartLabel() {
		return plannedStartLabel;
	}

	public AndroidElement getPlannedStartTextField() {
		return plannedStartTextField;
	}

	public AndroidElement getPlannedEndLabel() {
		return plannedEndLabel;
	}

	public AndroidElement getPlannedEndTextField() {
		return plannedEndTextField;
	}

	public AndroidElement getBackoutStartLabel() {
		return backoutStartLabel;
	}

	public AndroidElement getBackoutStartTextField() {
		return backoutStartTextField;
	}

	public AndroidElement getOrderNoLabel() {
		return orderNoLabel;
	}

	public AndroidElement getOrderNoTextField() {
		return orderNoTextField;
	}

	public AndroidElement getRequestorEmailIDLabel() {
		return requestorEmailIDLabel;
	}

	public AndroidElement getRequestorEmailIDTextField() {
		return requestorEmailIDTextField;
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

	public AndroidElement getConfigurationIDLabel() {
		return configurationIDLabel;
	}

	public AndroidElement getConfigurationIDTextField() {
		return configurationIDTextField;
	}

	public AndroidElement getOperationalCatTier1Label() {
		return operationalCatTier1Label;
	}

	public AndroidElement getOperationalCatTier1TextField() {
		return operationalCatTier1TextField;
	}

	public AndroidElement getOperationalCatTier2Label() {
		return operationalCatTier2Label;
	}

	public AndroidElement getOperationalCatTier2TextField() {
		return operationalCatTier2TextField;
	}

	public AndroidElement getOperationalCatTier3Label() {
		return operationalCatTier3Label;
	}

	public AndroidElement getOperationalCatTier3TextField() {
		return operationalCatTier3TextField;
	}

	public AndroidElement getProductTier1Label() {
		return productTier1Label;
	}

	public AndroidElement getProductTier1TextField() {
		return productTier1TextField;
	}

	public AndroidElement getProductTier2Label() {
		return productTier2Label;
	}

	public AndroidElement getProductTier2TextField() {
		return productTier2TextField;
	}

	public AndroidElement getProductTier3Label() {
		return productTier3Label;
	}

	public AndroidElement getProductTier3TextField() {
		return productTier3TextField;
	}

	public AndroidElement getOkButton() {
		return okButton;
	}
	
	
	

}
