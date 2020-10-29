package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RaisePlanWorkWarningAlerts extends TestBase {
	
	public RaisePlanWorkWarningAlerts(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	//Template Step
	
//	@AndroidFindBy(uiAutomator = "text(\"Empty category\")")
//	private AndroidElement emptyCategoryLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/alertTitle")
	private AndroidElement emptyCategoryLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a category\")")
	private AndroidElement selectCategoryLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Empty category description\")")
	private AndroidElement emptyCategoryDescriptionLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Please fill Standard Ref From Change Catalogue\")")
	private AndroidElement selectCategoryDescriptionLabel;
	
	//Location Tier Step
	
	@AndroidFindBy(uiAutomator = "text(\"Empty location tier 1\")")
	private AndroidElement emptyLocTier1Label;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a location details tier 1\")")
	private AndroidElement selectLocTier1Label;

	@AndroidFindBy(uiAutomator = "text(\"Empty location tier 2\")")
	private AndroidElement emptyLocTier2Label;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a location details tier 2\")")
	private AndroidElement selectLocTier2Label;
	
	@AndroidFindBy(uiAutomator = "text(\"Empty site address\")")
	private AndroidElement emptySiteAddressLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Enter Site Name as appears in XNG\")")
	private AndroidElement enterSiteAddressLabel;
	
	//Planned Schedule Step
	
	//com.colt.coltengineering:id/snackbar_text
	
	@AndroidFindBy(uiAutomator = "text(\"Please fill Planned Start\")")
	private AndroidElement fillPlannedStartLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Please fill Planned End\")")
	private AndroidElement fillPlannedEndLabel;

	@AndroidFindBy(uiAutomator = "text(\"Empty order id\")")
	private AndroidElement emptyOrderIdLabel;
	
	//Personal Information step
	
	@AndroidFindBy(uiAutomator = "text(\"Please fill Order No.\")")
	private AndroidElement fillOrderNoLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Empty config id\")")
	private AndroidElement emptyConfigIdLabel;	
	
	@AndroidFindBy(uiAutomator = "text(\"Please fill Device ID\")")
	private AndroidElement EmptyDeviceIdLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Input IDs\")")
	private AndroidElement inputDeviceIdLabel;

	
		
	//Opertation Tier
	
	@AndroidFindBy(uiAutomator = "text(\"Empty operation tier 1\")")
	private AndroidElement emptyOperationTier1Label;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a operational categorization tier 1\")")
	private AndroidElement selectOperationCatTier1LabelPopUp;
	
	@AndroidFindBy(uiAutomator = "text(\"Empty operation tier 2\")")
	private AndroidElement emptyOperationTier2Label;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a operational categorization tier 2\")")
	private AndroidElement slectOperationCatTier2Label;

	@AndroidFindBy(uiAutomator = "text(\"Empty operation tier 3\")")
	private AndroidElement emptyOperationTier3Label;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a operational categorization tier 3\")")
	private AndroidElement selectOperationCatTier3Label;


	//Product Tier
	
	@AndroidFindBy(uiAutomator = "text(\"Empty product tier 1\")")
	private AndroidElement emptyProductTier1Label;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a product categorization tier 1\")")
	private AndroidElement selectProductCatTier1LabelPopUp;
	
	@AndroidFindBy(uiAutomator = "text(\"Empty product tier 2\")")
	private AndroidElement emptyProductTier2Label;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a product categorization tier 2\")")
	private AndroidElement slectProductCatTier2Label;

	@AndroidFindBy(uiAutomator = "text(\"Empty product tier 3\")")
	private AndroidElement emptyProductTier3Label;
	
	@AndroidFindBy(uiAutomator = "text(\"Please select a product categorization tier 3\")")
	private AndroidElement selectProductCatTier3Label;
	
	@AndroidFindBy(uiAutomator = "text(\"Want to save as a Template ?\")")
	private AndroidElement saveTemplateConfirmLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Enter your Template name\")")
	private AndroidElement enterTemplateNameLabel;	
	
	@AndroidFindBy(uiAutomator = "text(\"Congratulations!!!\")")
	private AndroidElement congratsLabel;

	public AndroidElement getEmptyCategoryLabel() {
		return emptyCategoryLabel;
	}

	public AndroidElement getSelectCategoryLabel() {
		return selectCategoryLabel;
	}

	public AndroidElement getEmptyCategoryDescriptionLabel() {
		return emptyCategoryDescriptionLabel;
	}

	public AndroidElement getSelectCategoryDescriptionLabel() {
		return selectCategoryDescriptionLabel;
	}

	public AndroidElement getEmptyLocTier1Label() {
		return emptyLocTier1Label;
	}

	public AndroidElement getSelectLocTier1Label() {
		return selectLocTier1Label;
	}

	public AndroidElement getEmptyLocTier2Label() {
		return emptyLocTier2Label;
	}

	public AndroidElement getSelectLocTier2Label() {
		return selectLocTier2Label;
	}

	public AndroidElement getEmptySiteAddressLabel() {
		return emptySiteAddressLabel;
	}

	public AndroidElement getEnterSiteAddressLabel() {
		return enterSiteAddressLabel;
	}

	public AndroidElement getFillPlannedStartLabel() {
		return fillPlannedStartLabel;
	}

	public AndroidElement getFillPlannedEndLabel() {
		return fillPlannedEndLabel;
	}

	public AndroidElement getEmptyOrderIdLabel() {
		return emptyOrderIdLabel;
	}

	public AndroidElement getFillOrderNoLabel() {
		return fillOrderNoLabel;
	}

	public AndroidElement getEmptyConfigIdLabel() {
		return emptyConfigIdLabel;
	}

	public AndroidElement getEmptyDeviceIdLabel() {
		return EmptyDeviceIdLabel;
	}

	public AndroidElement getInputDeviceIdLabel() {
		return inputDeviceIdLabel;
	}

	public AndroidElement getEmptyOperationTier1Label() {
		return emptyOperationTier1Label;
	}

	public AndroidElement getSelectOperationCatTier1LabelPopUp() {
		return selectOperationCatTier1LabelPopUp;
	}

	public AndroidElement getEmptyOperationTier2Label() {
		return emptyOperationTier2Label;
	}

	public AndroidElement getSlectOperationCatTier2Label() {
		return slectOperationCatTier2Label;
	}

	public AndroidElement getEmptyOperationTier3Label() {
		return emptyOperationTier3Label;
	}

	public AndroidElement getSelectOperationCatTier3Label() {
		return selectOperationCatTier3Label;
	}

	public AndroidElement getEmptyProductTier1Label() {
		return emptyProductTier1Label;
	}

	public AndroidElement getSelectProductCatTier1LabelPopUp() {
		return selectProductCatTier1LabelPopUp;
	}

	public AndroidElement getEmptyProductTier2Label() {
		return emptyProductTier2Label;
	}

	public AndroidElement getSlectProductCatTier2Label() {
		return slectProductCatTier2Label;
	}

	public AndroidElement getEmptyProductTier3Label() {
		return emptyProductTier3Label;
	}

	public AndroidElement getSelectProductCatTier3Label() {
		return selectProductCatTier3Label;
	}

	public AndroidElement getSaveTemplateConfirmLabel() {
		return saveTemplateConfirmLabel;
	}

	public AndroidElement getEnterTemplateNameLabel() {
		return enterTemplateNameLabel;
	}

	public AndroidElement getCongratsLabel() {
		return congratsLabel;
	}
}



	
	



