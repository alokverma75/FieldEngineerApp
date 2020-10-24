package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SetTimePage extends TestBase {
	
	public SetTimePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"Set time‎\")")
	private AndroidElement setTimeLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Type in time‎‎\")")
	private AndroidElement typeInTimeLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"hour\")")
	private AndroidElement hourLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"minute‎‎\")")
	private AndroidElement minuteLabel;

	@AndroidFindBy(id = "android:id/input_hour")
	private AndroidElement inPutHourTextField;

	@AndroidFindBy(id = "android:id/input_minute")
	private AndroidElement inPutMinuteTextField;
	
	@AndroidFindBy(id = "android:id/am_pm_spinner")
	private AndroidElement amPMDropDown;

	@AndroidFindBy(id = "android:id/button1")
	private AndroidElement okButton;

	@AndroidFindBy(id = "android:id/button2")
	private AndroidElement cancelButton;
	
	@AndroidFindBy(id = "android:id/toggle_mode")
	private AndroidElement dateToggleButton;
	
	@AndroidFindBy(id = "android:id/text1")
	private AndroidElement currentAMPMValue;

	

	public AndroidElement getCurrentAMPMValue() {
		return currentAMPMValue;
	}

	public AndroidElement getSetTimeLabel() {
		return setTimeLabel;
	}

	public AndroidElement getTypeInTimeLabel() {
		return typeInTimeLabel;
	}

	public AndroidElement getHourLabel() {
		return hourLabel;
	}

	public AndroidElement getMinuteLabel() {
		return minuteLabel;
	}

	public AndroidElement getInPutHourTextField() {
		return inPutHourTextField;
	}

	public AndroidElement getInPutMinuteTextField() {
		return inPutMinuteTextField;
	}

	public AndroidElement getAmPMDropDown() {
		return amPMDropDown;
	}

	public AndroidElement getOkButton() {
		return okButton;
	}

	public AndroidElement getCancelButton() {
		return cancelButton;
	}

	public AndroidElement getDateToggleButton() {
		return dateToggleButton;
	}
	
	public TouchAction<?> moveToScrollToElement(AndroidDriver<AndroidElement> driver, String elementTextScrollTo){				
		return TestBase.getTouchActionForElement(driver, elementTextScrollTo);
		
	}
	

}
