package com.colt.fieldengineerapp.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestCase_2 extends TestBase{
	
	

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//AndroidDriver<AndroidElement> driver = getDriver();
		
		//TouchAction<?> action = new TouchAction<>(driver);
		
		
//		TestBase.getElementByAutomator(driver, ELEMENT_USER_ID).sendKeys("coltonlinedcp");
//		TestBase.hideKeyBoard(driver);
//		TestBase.getElementByAutomator(driver, ELEMENT_PASSWORD).sendKeys("Colt@1234");
//		TestBase.hideKeyBoard(driver);
//		TestBase.getElementByAutomator(driver,ELEMENT_CHECKBOX_REMEMBER).click();
//		TestBase.getElementByAutomator(driver, BUTTON_LOGIN).click();
//		//Thread.sleep(10);
//		//obj.wait(10);
//		//TestBase.getElementByAutomator(driver, ELEMENT_ATTRIBUTE_TEXT, BUTTON_CONTINUE).click();
//		String title = TestBase.getElementByAutomator(driver, ELEMENT_AUTHENTICATION_LABEL).getText();
//		System.out.println(" Title is "+title);
		
		String s1= "Images/Documents";
		
		System.out.println(" Test if equal "+ s1.equals(ELEMENT_ADD_ATTACMENTS_TITLE));
		
		
		

	}

}
