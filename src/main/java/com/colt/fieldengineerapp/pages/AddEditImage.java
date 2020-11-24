package com.colt.fieldengineerapp.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddEditImage extends TestBase {
	
	public AddEditImage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_capture")
	private AndroidElement imageCaptureButton;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_close")
	private AndroidElement imageCloseButton;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_save")
	private AndroidElement imageSaveButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Retake\")")
	private AndroidElement imageRetakeButton;

	
	@AndroidFindBy(uiAutomator = "text(\"Upload Image\")")
	private AndroidElement uploadImageLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_home")
	private AndroidElement homeButton;
	
	@AndroidFindBy(uiAutomator = "text(\"From Camera\")")
	private AndroidElement fromCameraButton;

	@AndroidFindBy(uiAutomator = "text(\"From Gallery\")")
	private AndroidElement fromGalleryButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Save\")")
	private AndroidElement saveImageButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Clear\")")
	private AndroidElement clearImageButton;

	@AndroidFindBy(uiAutomator = "text(\"Edit\")")
	private AndroidElement editImageButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Close\")")
	private AndroidElement closeScreenButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Draw\")")
	private AndroidElement drawOnScreenButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Text\")")
	private AndroidElement textOnScreenButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Clear All\")")
	private AndroidElement clearAllScreenButton;

	@AndroidFindBy(uiAutomator = "text(\"Continue\")")
	private AndroidElement continueButton;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/color_picker_view")
	private List<AndroidElement> colorPickerList;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/add_text_edit_text")
	private AndroidElement enterTextArea;
	
	@AndroidFindBy(uiAutomator = "text(\"Done\")")
	private AndroidElement doneButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Undo\")")
	private AndroidElement undoButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Erase\")")
	private AndroidElement eraseButton;
	
	//@AndroidFindBy(id = "com.colt.coltengineering:id/photo_edit_iv")
	//@AndroidFindBy(id = "com.colt.coltengineering:id/add_text_edit_text")	
	@AndroidFindBy(id = "com.colt.coltengineering:id/drawing_view")	
	private AndroidElement drawOnScreenArea;
	
	@AndroidFindBy(uiAutomator = "text(\"Do you want to upload file?\")")
	private AndroidElement confirmUploadAlertLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Yes\")")
	private AndroidElement yesButton;
	
	@AndroidFindBy(uiAutomator = "text(\"No\")")
	private AndroidElement noButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Uploading Attachment...\")")
	private AndroidElement uploadingAttachmentLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tvAlertMsg")
	private AndroidElement uploadAttachmentAlert;	
		
	public AndroidElement getImageCaptureButton() {
		return imageCaptureButton;
	}

	public AndroidElement getImageCloseButton() {
		return imageCloseButton;
	}

	public AndroidElement getImageSaveButton() {
		return imageSaveButton;
	}

	public AndroidElement getImageRetakeButton() {
		return imageRetakeButton;
	}

	public AndroidElement getUploadImageLabel() {
		return uploadImageLabel;
	}

	public AndroidElement getHomeButton() {
		return homeButton;
	}
	
	public AndroidElement getFromCameraButton() {
		return fromCameraButton;
	}

	public AndroidElement getFromGalleryButton() {
		return fromGalleryButton;
	}


	public AndroidElement getSaveImageButton() {
		return saveImageButton;
	}

	public AndroidElement getClearImageButton() {
		return clearImageButton;
	}

	public AndroidElement getEditImageButton() {
		return editImageButton;
	}

	public AndroidElement getCloseScreenButton() {
		return closeScreenButton;
	}

	public AndroidElement getDrawOnScreenButton() {
		return drawOnScreenButton;
	}

	public AndroidElement getTextOnScreenButton() {
		return textOnScreenButton;
	}

	public AndroidElement getClearAllScreenButton() {
		return clearAllScreenButton;
	}

	public AndroidElement getContinueButton() {
		return continueButton;
	}

	public List<AndroidElement> getColorPickerList() {
		return colorPickerList;
	}

	public AndroidElement getEnterTextArea() {
		return enterTextArea;
	}

	public AndroidElement getDoneButton() {
		return doneButton;
	}

	public AndroidElement getUndoButton() {
		return undoButton;
	}

	public AndroidElement getEraseButton() {
		return eraseButton;
	}

	public AndroidElement getDrawOnScreenArea() {
		return drawOnScreenArea;
	}

	public AndroidElement getConfirmUploadAlertLabel() {
		return confirmUploadAlertLabel;
	}

	public AndroidElement getYesButton() {
		return yesButton;
	}

	public AndroidElement getNoButton() {
		return noButton;
	}

	public AndroidElement getUploadingAttachmentLabel() {
		return uploadingAttachmentLabel;
	}

	public AndroidElement getUploadAttachmentAlert() {
		return uploadAttachmentAlert;
	}

	public TouchAction<?> moveToScrollToElement(AndroidDriver<AndroidElement> driver, String elementTextScrollTo){				
		return TestBase.getTouchActionForElement(driver, elementTextScrollTo);
		
	}
	

}
