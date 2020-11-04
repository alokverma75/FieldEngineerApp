package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LocationPage extends TestBase {
	
	public LocationPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"A End Address:\")") 
	private AndroidElement aEndAddress;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_site_a")
	private AndroidElement siteImage;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_site_a_value")
	private AndroidElement siteAValue;

	@AndroidFindBy(id = "com.colt.coltengineering:id/img_zoom_a")
	private AndroidElement zoomImage;
	
	@AndroidFindBy(uiAutomator = "text(\"Locate\")") 
	private AndroidElement locateTitle;

	public AndroidElement getaEndAddress() {
		return aEndAddress;
	}

	public AndroidElement getSiteImage() {
		return siteImage;
	}

	public AndroidElement getSiteAValue() {
		return siteAValue;
	}

	public AndroidElement getZoomImage() {
		return zoomImage;
	}

	public AndroidElement getLocateTitle() {
		return locateTitle;
	}

	
}
