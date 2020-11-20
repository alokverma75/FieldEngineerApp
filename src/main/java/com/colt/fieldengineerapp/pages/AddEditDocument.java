package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddEditDocument extends TestBase {
	
	public AddEditDocument(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	
	@AndroidFindBy(uiAutomator = "text(\"Recent\")")
	private AndroidElement imageRetakeButton;

	@AndroidFindBy(id = "com.colt.coltengineering:id/img_capture")
	private AndroidElement imageCaptureButton;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Show roots\"]")
	private AndroidElement openRootDrawerButton;
	
	////android.widget.TextView[@content-desc="Grid view"]
	@AndroidFindBy(id = "com.android.documentsui:id/option_menu_grid")
	private AndroidElement openMenuGridButton;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"More options\"]")
	private AndroidElement openMoreOptionsButton;
	
	@AndroidFindBy(id = "//android.widget.TextView[@content-desc=\"List view\"]")
	private AndroidElement openListViewGridButton;

	public AndroidElement getImageRetakeButton() {
		return imageRetakeButton;
	}

	public AndroidElement getImageCaptureButton() {
		return imageCaptureButton;
	}

	public AndroidElement getOpenRootDrawerButton() {
		return openRootDrawerButton;
	}

	public AndroidElement getOpenMenuGridButton() {
		return openMenuGridButton;
	}

	public AndroidElement getOpenMoreOptionsButton() {
		return openMoreOptionsButton;
	}

	public AndroidElement getOpenListViewGridButton() {
		return openListViewGridButton;
	}

}
