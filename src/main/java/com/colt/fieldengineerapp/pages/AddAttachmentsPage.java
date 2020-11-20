package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddAttachmentsPage extends TestBase {
	
	public AddAttachmentsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	//@AndroidFindBy(uiAutomator = "text(\"Images/Documents‎\")")
	@AndroidFindBy(id="com.colt.coltengineering:id/tv_title")
	private AndroidElement addAttachmentsLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_back")
	private AndroidElement backButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Click + to add images or documents\")")
	private AndroidElement clickToAddButton;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/fab_expand_menu_button")
	private AndroidElement addAttachmentButton;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/btn_add_doc")
	private AndroidElement addDocButton;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/btn_add_image")
	private AndroidElement addImageButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Add Document\")")
	private AndroidElement addDocTextButton;

	@AndroidFindBy(uiAutomator = "text(\"Add Image\")")
	private AndroidElement addImageTextButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Choose to upload\")")
	private AndroidElement uploadScreenLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"DOCUMENT\")")
	private AndroidElement uploadDocumentButton;
	
	@AndroidFindBy(uiAutomator = "text(\"IMAGE\")")
	private AndroidElement uploadImageButton;
	
	
	@AndroidFindBy(uiAutomator = "text(\"TYPE\")")
	private AndroidElement typeLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"TITLE\")")
	private AndroidElement titleLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_title_value")
	private AndroidElement uploadedImageTitleTFValue;
	
	public AndroidElement getAddAttachmentsLabel() {
		return addAttachmentsLabel;
	}

	public AndroidElement getBackButton() {
		return backButton;
	}

	public AndroidElement getClickToAddButton() {
		return clickToAddButton;
	}

	public AndroidElement getAddAttachmentButton() {
		return addAttachmentButton;
	}

	public AndroidElement getAddDocButton() {
		return addDocButton;
	}

	public AndroidElement getAddImageButton() {
		return addImageButton;
	}

	public AndroidElement getAddDocTextButton() {
		return addDocTextButton;
	}

	public AndroidElement getAddImageTextButton() {
		return addImageTextButton;
	}

	public AndroidElement getUploadScreenLabel() {
		return uploadScreenLabel;
	}

	public AndroidElement getUploadDocumentButton() {
		return uploadDocumentButton;
	}

	public AndroidElement getUploadImageButton() {
		return uploadImageButton;
	}

	public AndroidElement getTypeLabel() {
		return typeLabel;
	}

	public AndroidElement getTitleLabel() {
		return titleLabel;
	}

	public AndroidElement getUploadedImageTitleTFValue() {
		return uploadedImageTitleTFValue;
	}

	public TouchAction<?> moveToScrollToElement(AndroidDriver<AndroidElement> driver, String elementTextScrollTo){				
		return TestBase.getTouchActionForElement(driver, elementTextScrollTo);
		
	}
	

}
