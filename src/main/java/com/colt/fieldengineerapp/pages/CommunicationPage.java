package com.colt.fieldengineerapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommunicationPage extends TestBase {
	
	public CommunicationPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(30)), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"Communication\")") 
	private AndroidElement communicationTitle;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/btn_add_comment")
	private AndroidElement addCommentButton;
	
	@AndroidFindBy(uiAutomator = "text(\"Enter message\")") 
	private AndroidElement enterMessageTitle;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_message")
	private AndroidElement addMessageTextField;

	@AndroidFindBy(uiAutomator = "text(\"Cancel\")") 
	private AndroidElement cancelButton;

	@AndroidFindBy(uiAutomator = "text(\"Send\")") 
	private AndroidElement sendButton;

	public AndroidElement getCommunicationTitle() {
		return communicationTitle;
	}

	public AndroidElement getAddCommentButton() {
		return addCommentButton;
	}

	public AndroidElement getEnterMessageTitle() {
		return enterMessageTitle;
	}

	public AndroidElement getAddMessageTextField() {
		return addMessageTextField;
	}

	public AndroidElement getCancelButton() {
		return cancelButton;
	}

	public AndroidElement getSendButton() {
		return sendButton;
	}	

	

}
