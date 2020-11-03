package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsPage extends TestBase {
	
	public SettingsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(50)), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"Settings\")")
	private AndroidElement settingsLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Language\")")
	private AndroidElement languageButton;

	@AndroidFindBy(uiAutomator = "text(\"Notification\")")
	private AndroidElement notificationButton;
	
	//Next page on click of Language button
	@AndroidFindBy(uiAutomator = "text(\"Language\")")
	private AndroidElement languageLabel;

	@AndroidFindBy(uiAutomator = "text(\"English\")")
	private AndroidElement englishLanguageButton;

	@AndroidFindBy(uiAutomator = "text(\"Japanese\")")
	private AndroidElement japaneseLanguageButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Notification\")")
	private AndroidElement notificationPageLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/img_selected")
	private AndroidElement rightCheckImage;
	
	@AndroidFindBy(uiAutomator = "text(\"言語\")")
	private AndroidElement japaneseButtonForLanguageSetting;
	
	@AndroidFindBy(uiAutomator = "text(\"通知\")")
	private AndroidElement japaneseButtonForNotificationSetting;
	
	@AndroidFindBy(uiAutomator = "text(\"通知\")")
	private AndroidElement japaneseLanguageNotificationLabel;


	public AndroidElement getJapaneseLanguageNotificationLabel() {
		return japaneseLanguageNotificationLabel;
	}

	@AndroidFindBy(uiAutomator = "text(\"英語\")")
	private AndroidElement englishButtonInJapanese;

	public AndroidElement getJapaneseButtonForNotificationSetting() {
		return japaneseButtonForNotificationSetting;
	}

	
	public AndroidElement getEnglishButtonInJapanese() {
		System.out.println("Inside getEnglishButtonInJapanese()");
		return englishButtonInJapanese;
	}

	public AndroidElement getJapaneseButtonForLanguageSetting() {
		return japaneseButtonForLanguageSetting;
	}

	public AndroidElement getSettingsLabel() {
		return settingsLabel;
	}

	public AndroidElement getLanguageButton() {
		return languageButton;
	}

	public AndroidElement getNotificationButton() {
		return notificationButton;
	}

	public AndroidElement getLanguageLabel() {
		return languageLabel;
	}

	public AndroidElement getEnglishLanguageButton() {
		return englishLanguageButton;
	}

	public AndroidElement getJapaneseLanguageButton() {
		return japaneseLanguageButton;
	}

	public AndroidElement getNotificationPageLabel() {
		return notificationPageLabel;
	}

	public AndroidElement getRightCheckImage() {
		return rightCheckImage;
	}

	

}
