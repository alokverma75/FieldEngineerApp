package com.colt.fieldengineerapp.base;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;


import com.colt.fieldengineerapp.util.ReadPropertyFile;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;

import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class TestBase implements FieldEngineerAppConstants{
	
	public static AndroidDriver<AndroidElement> driver;
	private static DesiredCapabilities cap = new DesiredCapabilities();
	public static String USRDIR = System.getProperty("user.dir");
	public static Properties prop;	
	static boolean  started = false;

	public static AndroidDriver<AndroidElement> getDriver() throws IOException, MalformedURLException {

		prop = ReadPropertyFile.readPropertiesFile("resources/config.properties");
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
		cap.setCapability(MobileCapabilityType.APP, USRDIR + prop.getProperty("app"));
		cap.setCapability(AndroidMobileCapabilityType.AVD, prop.getProperty("avdName"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automationName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getProperty("appActivity"));
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getProperty("appPackage"));	

		driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;

	}
	
	public static void initialization() throws IOException, MalformedURLException {

		prop = ReadPropertyFile.readPropertiesFile("resources/config.properties");
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
		cap.setCapability(MobileCapabilityType.APP, prop.getProperty("app"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automationName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getProperty("appActivity"));
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getProperty("appPackage"));
		

		driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	

	}
	
	public static void startAVD() throws IOException {
		
		System.out.println("This will start avd");
		
		if(started) {
			System.out.println(" Already started so shutting down");
		shutDownAVD();
		}
	
		Runtime.getRuntime().exec("adb start-server");
		Runtime.getRuntime().exec("emulator -avd pixel2");
		started = true;
		
		
		System.out.println("the avd is started successfully");
		
	}
	
	public static void shutDownAVD() throws IOException {
		
		System.out.println("This will close the avd");
		Runtime.getRuntime().exec("adb shell reboot -p");
		started = false;
		System.out.println("the avd is closed successfully");
		
	}
	
	public static TapOptions geTapOption(AndroidDriver<AndroidElement> driver, String elementText) {

		//String searchWebElement = "text(\"" + elementText + "\")";
		
		String searchWebElement = ELEMENT_ATTRIBUTE_TEXT + elementText + ELEMENT_TAP_SUFFIX;		
		System.out.println(" search Web eleement   "+ searchWebElement);

		return TapOptions.tapOptions()
				.withElement(ElementOption.element(driver.findElementByAndroidUIAutomator(searchWebElement)));

	}
// This will search element by scrolling in actual
	public static TapOptions geTapOptionForScroll(AndroidDriver<AndroidElement> driver, String elementText) {				
		String searchWebElement = ELEMENT_ATTRIBUTE_SCROLL_VIEW + elementText + ELEMENT_SCROLL_SUFFIX;		
		System.out.println(" search Web element   "+ searchWebElement);
		// e.g. of search search Web element   new UiScrollable(new UiSelector()).scrollIntoView(text("Job Remarks"));

		return TapOptions.tapOptions()
				.withElement(ElementOption.element(driver.findElementByAndroidUIAutomator(searchWebElement)));

	}	
	
	public static LongPressOptions geLongPressOption(AndroidDriver<AndroidElement> driver, String attributeText, String elementText) {

		String searchWebElement = attributeText + elementText + ELEMENT_TAP_SUFFIX;
		return LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(driver.findElementByAndroidUIAutomator(searchWebElement)));

	}

	//Find Element by UiAutomator for Android elements though page factory mandates this in string constant and not used with page factory
	public static AndroidElement getElementByAutomator(AndroidDriver<AndroidElement> driver, String elementTextValue) {
		String searchWebElement = ELEMENT_ATTRIBUTE_TEXT + elementTextValue + ELEMENT_TAP_SUFFIX;
		
		System.out.println(searchWebElement);
		
		return driver.findElementByAndroidUIAutomator(searchWebElement);
	}
	
	public static String getAutomatorElementFormat(String elementText) {
		
		String automatorFormat = ELEMENT_ATTRIBUTE_TEXT + elementText + ELEMENT_TAP_SUFFIX;		
		return automatorFormat;
	}
	// Search element by scrolling which will work like for TouchAction and TapOption combination
	public static AndroidElement getElementByAutomatorForScroll(AndroidDriver<AndroidElement> driver, String elementTextValue) {
		String searchWebElement = ELEMENT_ATTRIBUTE_SCROLL_VIEW + elementTextValue + ELEMENT_SCROLL_SUFFIX;
		
		System.out.println(searchWebElement);
		
		return driver.findElementByAndroidUIAutomator(searchWebElement);
	}
	
	// This will return an element after scrolling on mobile screen
	public static TouchAction<?> getTouchActionForElement(AndroidDriver<AndroidElement> driver, String elementTextScrollTo){
		TouchAction<?> action = new TouchAction<>(driver);
		
		return action.tap(TestBase.geTapOptionForScroll(driver,elementTextScrollTo)).perform();
		
	}
		
	
	//To hide keyboard
	public static void hideKeyBoard(AndroidDriver<AndroidElement> driver) {
		
		driver.hideKeyboard();
	}
	
	// Used for Drag and Drop functionality from one point to another like clock arm 
	public static PointOption<?> getPointOption(AndroidDriver<AndroidElement> driver, String elementText, String moveTo) {
		String searchWebElement = elementText + moveTo + ELEMENT_TAP_SUFFIX;
		
		AndroidElement element = driver.findElementByAndroidUIAutomator(searchWebElement);
		System.out.println(" Serach element for PointOption "+ searchWebElement);
		
		System.out.println(" And points are as X :"+ element.getCenter().getX() + " And Y: is "+element.getCenter().getY());
		
		return PointOption.point(element.getCenter().getX(), element.getCenter().getY());
	}
	/**Used for Drag and Drop functionality from one point to another like clock arm 
	 * e. g. action.press(Base.getPointOptionById(driver, ELEMENT_APIS_ID_PREFIX, ELEMENT_DRAG_DROP_ONE))
	 * .waitAction(WaitOptions.waitOptions(Base.getDuration(2))).moveTo(
	 * getPointOptionById(driver, ELEMENT_APIS_ID_PREFIX, ELEMENT_DRAG_DROP_TWO)).release().perform();
	 * 
	 * @param driver
	 * @param elementText
	 * @param moveTo
	 * @return
	 */
	public static PointOption<?> getPointOptionById(AndroidDriver<AndroidElement> driver, String elementText, String moveTo) {
		String searchWebElement = elementText + moveTo ;
		
		AndroidElement element = driver.findElementById(searchWebElement);
		System.out.println(" Serach element for PointOption "+ searchWebElement);
		
		System.out.println(" And points are as X :"+ element.getCenter().getX() + " And Y: is "+element.getCenter().getY());
		
		return PointOption.point(element.getCenter().getX(), element.getCenter().getY());
	}


	public static AndroidElement getElementByClassName(AndroidDriver<AndroidElement> driver, String elementText) {

		return driver.findElementByClassName(elementText);
	}
	
	public static Duration getDuration(long timeInSeconds) {
		
		return Duration.ofSeconds(timeInSeconds);
	}

	public static List<AndroidElement> getElementsByClassName(AndroidDriver<AndroidElement> driver,	String elementText) {

		return driver.findElementsByClassName(elementText);
	}
	
	public static List<AndroidElement> getElementsById(AndroidDriver<AndroidElement> driver,	String elementText) {

		return driver.findElementsById(elementText);
	}
	
	//driver.findElementByXPath("//android.widget.Button[@text='OK']");
	public static AndroidElement getElementByXpath(AndroidDriver<AndroidElement> driver, String textWidget, String elementText) {
		
		String xPath = ELEMENT_XPATH_PREFIX+textWidget+ELEMENT_XPATH__TEXT_PREFIX+ elementText+ELEMENT_XPATH__TEXT_SUFFIX;
		
			
		System.out.println(" xpath is >>>> "+ xPath);
		

		return driver.findElementByXPath(xPath.trim());
	}
	
   public static AndroidElement getElementByXpathUsingDescription(AndroidDriver<AndroidElement> driver, String elementText) {
		
		String xPath = ELEMENT_XPATH_PREFIX+ ELEMENT_XPATH__DESCRIPTION_PREFIX+ elementText+ELEMENT_XPATH__TEXT_SUFFIX;
		
			
		System.out.println(" xpath is >>>> "+ xPath);		

		return driver.findElementByXPath(xPath.trim());
	}
	
	public static AndroidElement getElementById(AndroidDriver<AndroidElement> driver, String elementText) {

		return driver.findElementById(ELEMENT_ID_PREFIX+elementText);
	}
	
	
}
