package com.colt.fieldengineerapp.base;

/*
 * 
 *@author Alok Verma
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.colt.fieldengineerapp.constants.ActionsPageConstants;
import com.colt.fieldengineerapp.constants.AlertMessagesRaisePlanWorkConstants;
import com.colt.fieldengineerapp.constants.AlertPageConstants;
import com.colt.fieldengineerapp.constants.AllTasksPageConstants;
import com.colt.fieldengineerapp.constants.ConfirmPageConstants;
import com.colt.fieldengineerapp.constants.FieldEngineerAppConstants;
import com.colt.fieldengineerapp.constants.FilterPageConstants;
import com.colt.fieldengineerapp.constants.HeaderPageConstants;
import com.colt.fieldengineerapp.constants.HomePageConstants;
import com.colt.fieldengineerapp.constants.LocationPageConstants;
import com.colt.fieldengineerapp.constants.OpenDrawerAndSettingsPageConstants;
import com.colt.fieldengineerapp.constants.PlannedWorksPageErrorMessages;
import com.colt.fieldengineerapp.constants.RaisePlannedWorkConstants;
import com.colt.fieldengineerapp.constants.SingleTaskPageConstants;
import com.colt.fieldengineerapp.constants.TemplatesConstants;
import com.colt.fieldengineerapp.util.ReadPropertyFile;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class TestBase implements FieldEngineerAppConstants, PlannedWorksPageErrorMessages, AlertMessagesRaisePlanWorkConstants,
		ActionsPageConstants,ConfirmPageConstants, OpenDrawerAndSettingsPageConstants,TemplatesConstants,RaisePlannedWorkConstants,
		HomePageConstants, LocationPageConstants,SingleTaskPageConstants,AllTasksPageConstants,HeaderPageConstants,AlertPageConstants,
		FilterPageConstants{

	public static AndroidDriver<AndroidElement> driver;
	private static DesiredCapabilities cap = new DesiredCapabilities();
	public static String USRDIR = System.getProperty("user.dir");
	public static Properties prop;
	public static AppiumDriverLocalService service;
	
	static {
		try {
			prop = ReadPropertyFile.readPropertiesFile("resources/config.properties");
		} catch (IOException e) {
			System.out.println(" Property file not found");
			e.printStackTrace();
		}
	}
	
	/**
	 * To start appium server programmatically
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void startAppiumServer() throws IOException, InterruptedException {
		killAllNodes();
		String port = prop.getProperty("appiumServerPort");
		boolean flag = checkIfServerIsRunnning(Integer.parseInt(port));
		if (!flag) {
			
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();			
		}
		

	}
	
	public static void stopAppiumServer() {
		if(service != null) {
			service.stop();
		}
			
		System.out.println("Appimum server stopped successfully");
	}
	
	public static void killAllNodes() throws IOException, InterruptedException
	{
	
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		
	}
	
	
	
	/**
	 * To check if server is already running and use the same
	 * @param port
	 * @return
	 */
	private static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static void getScreenshot(String screenShot) throws IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(prop.getProperty("datePattern"));
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String directoryName = prop.getProperty("screenShots");
		//FileUtils.copyFile(scrfile, new File(directory) + "\\Screenshots" + screenShot + ".png"));
		FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+File.separator+directoryName+File.separator+screenShot+dateFormat.format(new Date())+".png"));

	}

	/**
	 * This will return an instance of driver with required capabilities and will be
	 * used in all places
	 * 
	 * @return
	 * @throws IOException
	 * @throws MalformedURLException
	 * @throws InterruptedException 
	 */

	public static AndroidDriver<AndroidElement> getDriver() throws IOException, MalformedURLException, InterruptedException {

	  //This will be used in Jenkins and will be passed as dropdown
        String device= System.getProperty("deviceName");
        if(device == null || device.equals("")) {
        	device = prop.getProperty("deviceName");
        }

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.APP, USRDIR + prop.getProperty("app"));
		cap.setCapability(AndroidMobileCapabilityType.AVD, prop.getProperty("avdName"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automationName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, prop.getProperty("autoGrantPermissions"));
		//cap.setCapability(AndroidMobileCapabilityType.IS_HEADLESS, prop.getProperty("isHeadless"));
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getProperty("appActivity"));
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getProperty("appPackage"));

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;

	}

	/**
	 * This method will be called to start the emulator along with adb server.
	 * Usually with BeforeSuite method tag
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */

	public static void startAVD() throws IOException, InterruptedException {

		System.out.println("This will start avd");
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\resources\\startEmulator.bat");
		Thread.sleep(7000);
		
		System.out.println("the avd is started successfully");

	}

	/**
	 * This method will shut down the emulator after test suite is completed
	 * 
	 * @throws IOException
	 */

	public static void shutDownAVD() throws IOException {

		System.out.println("This will close the avd");
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\resources\\stopEmulator.bat");		
		System.out.println("the avd is closed successfully");

	}

	/**
	 * This method will return the TapOptions for a given element type on a page
	 * 
	 * @param driver
	 * @param elementText
	 * @return
	 */

	public static TapOptions geTapOption(AndroidDriver<AndroidElement> driver, String elementText) {

		// String searchWebElement = "text(\"" + elementText + "\")";

		String searchWebElement = ELEMENT_ATTRIBUTE_TEXT + elementText + ELEMENT_TAP_SUFFIX;
		System.out.println(" search Web eleement   " + searchWebElement);

		return TapOptions.tapOptions()
				.withElement(ElementOption.element(driver.findElementByAndroidUIAutomator(searchWebElement)));

	}

	/**
	 * This method will return TapOptions object for a given element after searching
	 * in a drop down say or on a screen
	 * 
	 * @param driver
	 * @param elementText
	 * @return
	 */
	public static TapOptions geTapOptionForScroll(AndroidDriver<AndroidElement> driver, String elementText) {
		String searchWebElement = ELEMENT_ATTRIBUTE_SCROLL_VIEW + elementText + ELEMENT_SCROLL_SUFFIX;
		System.out.println(" search Web element   " + searchWebElement);
		// e.g. of search search Web element new UiScrollable(new
		// UiSelector()).scrollIntoView(text("Job Remarks"));

		return TapOptions.tapOptions()
				.withElement(ElementOption.element(driver.findElementByAndroidUIAutomator(searchWebElement)));

	}

	/**
	 * This method will return LongPressOptions for functionality of drag/drop of
	 * element from one location to another
	 * 
	 * @param driver
	 * @param attributeText
	 * @param elementText
	 * @return
	 */

	public static LongPressOptions geLongPressOption(AndroidDriver<AndroidElement> driver, String attributeText,
			String elementText) {

		String searchWebElement = attributeText + elementText + ELEMENT_TAP_SUFFIX;
		return LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(driver.findElementByAndroidUIAutomator(searchWebElement)));

	}

	/**
	 * This method will return an element using UiAutomator feature of driver for
	 * mobile elements
	 * 
	 * @param driver
	 * @param elementTextValue
	 * @return
	 */
	public static AndroidElement getElementByAutomator(AndroidDriver<AndroidElement> driver, String elementTextValue) {
		String searchWebElement = ELEMENT_ATTRIBUTE_TEXT + elementTextValue + ELEMENT_TAP_SUFFIX;

		System.out.println(searchWebElement);

		return driver.findElementByAndroidUIAutomator(searchWebElement);
	}

	/**
	 * This method will return the format to search ui automator search string
	 * 
	 * @param elementText
	 * @return
	 */
	public static String getAutomatorElementFormat(String elementText) {

		String automatorFormat = ELEMENT_ATTRIBUTE_TEXT + elementText + ELEMENT_TAP_SUFFIX;
		return automatorFormat;
	}

	/**
	 * This method will return an element after scrolling a list of elements if not
	 * visible on initial view
	 * 
	 * @param driver
	 * @param elementTextValue
	 * @return
	 */
	public static AndroidElement getElementByAutomatorForScroll(AndroidDriver<AndroidElement> driver,
			String elementTextValue) {
		String searchWebElement = ELEMENT_ATTRIBUTE_SCROLL_VIEW + elementTextValue + ELEMENT_SCROLL_SUFFIX;

		System.out.println(searchWebElement);

		return driver.findElementByAndroidUIAutomator(searchWebElement);
	}
	
	
	/**
	 * This method will return TouchAction object for a given element after
	 * searching an element and tapping on the same
	 * 
	 * @param driver
	 * @param elementTextScrollTo
	 * @return
	 */
	public static TouchAction<?> getTouchActionForElement(AndroidDriver<AndroidElement> driver,
			String elementTextScrollTo) {
		TouchAction<?> action = new TouchAction<>(driver);

		return action.tap(TestBase.geTapOptionForScroll(driver, elementTextScrollTo)).perform();

	}

	public static TapOptions geTapOption(AndroidDriver<AndroidElement> driver, String attributeText,
			String elementText) {

		String searchWebElement = attributeText + elementText + ELEMENT_TAP_SUFFIX;
		System.out.println(" search Web eleement   " + searchWebElement);

		return TapOptions.tapOptions()
				.withElement(ElementOption.element(driver.findElementByAndroidUIAutomator(searchWebElement)));

	}

	public static TouchAction<?> getTouchActionForSwipe(AndroidDriver<AndroidElement> driver, String swipeTo) {
		TouchAction<?> action = new TouchAction<>(driver);

		return action.tap(TestBase.geTapOption(driver, ELEMENT_ATTRIBUTE_CONTENT_DESC, swipeTo)).perform();

	}

	public static TouchAction<?> getTouchActionForPress(AndroidDriver<AndroidElement> driver, String swipeFrom,
			String swipeTo) {

		TouchAction<?> action = new TouchAction<>(driver);

		return action.press(TestBase.getPointOption(driver, ELEMENT_ATTRIBUTE_CONTENT_DESC, swipeFrom))
				.waitAction(WaitOptions.waitOptions(TestBase.getDuration(2)))
				.moveTo(TestBase.getPointOption(driver, ELEMENT_ATTRIBUTE_CONTENT_DESC, swipeTo)).release().perform();

	}

	/**
	 * This method can be used to hide the soft keyboard after data has been entered
	 * by script
	 * 
	 * @param driver
	 */
	public static void hideKeyBoard(AndroidDriver<AndroidElement> driver) {

		driver.hideKeyboard();
	}

	/**
	 * This method is used for Swipe functionality from one point to another by
	 * finding element's from x,y coordinates to the final x,y coordinates This is
	 * new way now to move elements and methods like getCenter().getX() etc are used
	 * 
	 * @param driver
	 * @param elementText
	 * @param moveTo
	 * @return
	 */
	public static PointOption<?> getPointOption(AndroidDriver<AndroidElement> driver, String elementText,
			String moveTo) {
		String searchWebElement = elementText + moveTo + ELEMENT_TAP_SUFFIX;

		AndroidElement element = driver.findElementByAndroidUIAutomator(searchWebElement);
		System.out.println(" Serach element for PointOption " + searchWebElement);

		System.out.println(
				" And points are as X :" + element.getCenter().getX() + " And Y: is " + element.getCenter().getY());

		return PointOption.point(element.getCenter().getX(), element.getCenter().getY());
	}

	/**
	 * Used for Drag and Drop functionality from one point to another like clock arm
	 * e. g. action.press(Base.getPointOptionById(driver, ELEMENT_APIS_ID_PREFIX,
	 * ELEMENT_DRAG_DROP_ONE))
	 * .waitAction(WaitOptions.waitOptions(Base.getDuration(2))).moveTo(
	 * getPointOptionById(driver, ELEMENT_APIS_ID_PREFIX,
	 * ELEMENT_DRAG_DROP_TWO)).release().perform();
	 * 
	 * @param driver
	 * @param elementText
	 * @param moveTo
	 * @return
	 */
	public static PointOption<?> getPointOptionById(AndroidDriver<AndroidElement> driver, String elementText,
			String moveTo) {
		String searchWebElement = elementText + moveTo;

		AndroidElement element = driver.findElementById(searchWebElement);
		System.out.println(" Serach element for PointOption " + searchWebElement);

		System.out.println(
				" And points are as X :" + element.getCenter().getX() + " And Y: is " + element.getCenter().getY());

		return PointOption.point(element.getCenter().getX(), element.getCenter().getY());
	}

	/**
	 * This method can be used to find an element using className attribute
	 * 
	 * @param driver
	 * @param elementText
	 * @return
	 */
	public static AndroidElement getElementByClassName(AndroidDriver<AndroidElement> driver, String elementText) {

		return driver.findElementByClassName(elementText);
	}

	/**
	 * This will return an instance of Duration with specified time in seconds which
	 * is generic and will set any value as required
	 * 
	 * @param timeInSeconds
	 * @return
	 */
	public static Duration getDuration(long timeInSeconds) {

		return Duration.ofSeconds(timeInSeconds);
	}

	/**
	 * This method will return a List of elements identified by a common className
	 * if no unique locator is defined
	 * 
	 * @param driver
	 * @param elementText
	 * @return
	 */
	public static List<AndroidElement> getElementsByClassName(AndroidDriver<AndroidElement> driver,
			String elementText) {

		return driver.findElementsByClassName(elementText);
	}

	/**
	 * This method will return a List of all elements identified by a common id when
	 * no unique locator is defined
	 * 
	 * @param driver
	 * @param elementText
	 * @return
	 */
	public static List<AndroidElement> getElementsById(AndroidDriver<AndroidElement> driver, String elementText) {

		return driver.findElementsById(elementText);
	}

	/**
	 * This method will return an element using xpath
	 * 
	 * @param driver
	 * @param textWidget
	 * @param elementText
	 * @return
	 */

	// driver.findElementByXPath("//android.widget.Button[@text='OK']");
	public static AndroidElement getElementByXpath(AndroidDriver<AndroidElement> driver, String textWidget,
			String elementText) {

		String xPath = ELEMENT_XPATH_PREFIX + textWidget + ELEMENT_XPATH__TEXT_PREFIX + elementText
				+ ELEMENT_XPATH__TEXT_SUFFIX;

		System.out.println(" xpath is >>>> " + xPath);

		return driver.findElementByXPath(xPath.trim());
	}

	/**
	 * This method will return an element using xpath and provided description only
	 * 
	 * @param driver
	 * @param elementText
	 * @return
	 */

	public static AndroidElement getElementByXpathUsingDescription(AndroidDriver<AndroidElement> driver,
			String elementText) {

		String xPath = ELEMENT_XPATH_PREFIX + ELEMENT_XPATH__DESCRIPTION_PREFIX + elementText
				+ ELEMENT_XPATH__TEXT_SUFFIX;

		System.out.println(" xpath is >>>> " + xPath);

		return driver.findElementByXPath(xPath.trim());
	}
	
	/**
	 * This method will return an element by using provided id of element
	 * 
	 * @param driver
	 * @param elementText
	 * @return
	 */
	public static AndroidElement getElementById(AndroidDriver<AndroidElement> driver, String elementText) {

		return driver.findElementById(ELEMENT_ID_PREFIX + elementText);
	}

	/**
	 * This method will return the date as per defined pattern
	 * 
	 * @param datePattern
	 * @return
	 */
	public static String getDate(String datePattern) {

		String pattern = datePattern;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println(date);

		return date;
	}

	/**
	 * This method will return time based on the timeZone selected from the screen
	 * i.e. GMT/BST and will create date/time based on that timeZone.
	 * 
	 * @param timeZoneID
	 * @return
	 */

	public static Map<String, Integer> getDateTimeBasedOnTimeZone(String timeZoneID) {
		TimeZone timeZone = TimeZone.getTimeZone(timeZoneID);

		Calendar calendar = new GregorianCalendar();
		calendar.setTimeZone(timeZone);

		System.out.println("year     = " + calendar.get(Calendar.YEAR));
		System.out.println("day     = " + calendar.get(Calendar.DAY_OF_MONTH));
		int monthInCorrectValue = calendar.get(Calendar.MONTH);
		monthInCorrectValue++;
		System.out.println("month     = " + monthInCorrectValue);
		System.out.println("hour     = " + calendar.get(Calendar.HOUR));
		System.out.println("minute     = " + calendar.get(Calendar.MINUTE));

		Map<String, Integer> dateTimeZonedMap = new HashMap<String, Integer>();

		dateTimeZonedMap.put(ELEMENT_YEAR_KEY, Integer.valueOf(calendar.get(Calendar.YEAR)));
		dateTimeZonedMap.put(ELEMENT_MONTH_KEY, Integer.valueOf(monthInCorrectValue));
		dateTimeZonedMap.put(ELEMENT_DAY_KEY, Integer.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
		dateTimeZonedMap.put(ELEMENT_HOUR_KEY, Integer.valueOf(calendar.get(Calendar.HOUR)));
		dateTimeZonedMap.put(ELEMENT_MINUTE_KEY, Integer.valueOf(calendar.get(Calendar.MINUTE)));

		return dateTimeZonedMap;
	}

	/**
	 * This method will start recording using Android driver based on the
	 * recordingNeeded=true, will not work if false
	 * 
	 * @param driver
	 */
	public static void startRecording(AndroidDriver<AndroidElement> driver) {
		driver.startRecordingScreen(new AndroidStartScreenRecordingOptions().withVideoSize("1280x720")
				.withTimeLimit(TestBase.getDuration(300)));
	}

	/**
	 * This method will save recording using Android driver based on the
	 * recordingNeeded=true, will not work if false This will create new Folder
	 * Recordings under user.path, and if created will skip and create new video
	 * file The file name is TestClassName.enclosingMethod+ dateTime+.mp4
	 * datePattern is defined in config.properties and can be adjusted on the fly
	 * 
	 * @param driver
	 * @param className
	 * @param methodName
	 * @throws IOException
	 */
	public static void SaveRecording(AndroidDriver<AndroidElement> driver, String className, String methodName)
			throws IOException {

		SimpleDateFormat dateFormat = new SimpleDateFormat(prop.getProperty("datePattern"));
		Date date = new Date();

		String dirPath = USRDIR;
		String newDirName = "Recordings";
		String newFileName = className + "-" + methodName + "-" + dateFormat.format(date) + ".mp4";

		System.out.println(" File name is " + newFileName);

		// Create new directory under user.path
		File oneMoreDirectory = new File(dirPath + File.separator + newDirName);
		// Create directory for existed path.
		boolean isCreated = false;
		if (!oneMoreDirectory.exists()) {
			isCreated = oneMoreDirectory.mkdir();
			if (isCreated) {
				System.out.printf("\n3. Successfully created new directory, path:%s",
						oneMoreDirectory.getCanonicalPath());
			} else { // Directory may already exist
				System.out.printf("\n3. Already created directory");
			}
		}
		
		//Lets first empty the folder before starting again		
		 emptyDirectory(oneMoreDirectory);
		 System.out.println("deleting oneMoreDirectory with path "+ oneMoreDirectory);
		

		// Create file under new directory path C:\newDirectory\directory
		File anotherNewFile = new File(oneMoreDirectory + File.separator + newFileName);

		// Create new file under specified directory
		isCreated = anotherNewFile.createNewFile();
		if (isCreated) {
			System.out.printf("\n4. Successfully created new file, path:%s", anotherNewFile.getCanonicalPath());
			System.out.println();

		} else { // File may already exist
			System.out.printf("\n4. Unable to create new file");
		}

		String video = driver.stopRecordingScreen();
		byte[] decode = Base64.getDecoder().decode(video);

		System.out.println(" Size of file i " + decode.length);
		
		// Now try to mark it
		
		String ffmpegPath = prop.getProperty("ffmpegPath");
		String separator = "-i";
		String waterMarkImage = prop.getProperty("waterMarkImage");
		String fileNameToBeConverted = anotherNewFile.getAbsolutePath();
		String fileSpecifierForWaterMark= prop.getProperty("fileSpecifier");
		String filterComplex = prop.getProperty("filterComplex");
		String overLay = prop.getProperty("overlay");
		String recordingsFolder = prop.getProperty("recordingFolder");
		//String nameOfWaterMarkedFile = "D:\\TechPractice\\Appium\\FieldEngineerApp\\Recordings\\"+className + "-" + methodName + "-" + fileSpecifierForWaterMark +dateFormat.format(date) + ".mp4";
		String nameOfWaterMarkedFile = USRDIR + File.separator+recordingsFolder + File.separator+className + "-" + methodName + "-" + fileSpecifierForWaterMark +"-"+dateFormat.format(date) + ".mp4";
		
		System.out.println(" fileNameToBeConverted is == "+ fileNameToBeConverted);
		System.out.println("nameOfWaterMarkedFile =="+nameOfWaterMarkedFile);
		//Create WaterMarked directory if not created
		createNewDirectory(recordingsFolder);
		
		String[] cmd = {
				ffmpegPath,separator, 
				fileNameToBeConverted,  
				separator,waterMarkImage,
				filterComplex,overLay,
				nameOfWaterMarkedFile
				 };
		try {

			// Initialize a pointer
			// in file using OutputStream
			OutputStream os = new FileOutputStream(anotherNewFile);

			// Starts writing the bytes in it
			os.write(decode);
			System.out.println("Successfully" + " byte inserted");

			// Close the file
			os.close();
			
			new ProcessBuilder(Arrays.asList(cmd)).start();
			
			
		}

		catch (Exception e) {
			System.out.println("Exception: " + e);
		}
			
		
		
	}
	
	/**
	 * This method will empty files in a folder and subfolders in recursive mode 
	 * @param path
	 */
	static public void emptyDirectory(File path) {
	    if (path.exists()) {
	        File[] files = path.listFiles();
	        System.out.println(" list of file is== "+files.length);
	        for (int i = 0; i < files.length; i++) {
	            if (files[i].isDirectory()) {
	                emptyDirectory(files[i]);
	            } else {
	                files[i].delete();
	                System.out.println("Inside file delete "+  files[i].getName() );
	            }
	        }
	    }
	   
	}
	
	/**
	 * This method will create a new folder under user.dir/newFolderName, where user.dir=System.get("user.dir) i.e.
	 * D:\TechPractice\Appium\FieldEngineerApp in my case, so new folder say WaterMarkRecordings String will be passed in this
	 * method to be created and it will check if such directory dont exist then it will create else it will return and new folder
	 * will be D:\TechPractice\Appium\FieldEngineerApp\WaterMarkRecordings. The name of folder is passed from property file 
	 * which can be anything.
	 * @param newDirectoryName
	 * @throws IOException
	 */
	private static void createNewDirectory(String newDirectoryName) throws IOException {
		String dirPath = USRDIR;
		
		// Create new directory under user.path
		File oneMoreDirectory = new File(dirPath + File.separator + newDirectoryName);
		// Create directory for existed path.
		boolean isCreated = false;
		if (!oneMoreDirectory.exists()) {
			isCreated = oneMoreDirectory.mkdir();
			if (isCreated) {
				System.out.printf("\n3. Successfully created new directory, path:%s",
						oneMoreDirectory.getCanonicalPath());
			} else { // Directory may already exist
				System.out.printf("\n3. Already created directory");
			}
		}
		
		
	}

	/**
	 * This method will explicitly wait till Alert is shown before we switch to it
	 * 
	 * @param driver
	 * @param timeToWait
	 * @return
	 */
	public static Alert wait(AndroidDriver<AndroidElement> driver, int timeToWait) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		return wait.until(ExpectedConditions.alertIsPresent());

	}
	
	 
		public static WebElement waitForElement(AndroidDriver<AndroidElement> driver, int timeToWait,String expression) {
			WebDriverWait wait = new WebDriverWait(driver, timeToWait);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expression)));

		}

	public static AndroidElement waitForElement(By locator) {
		try {
			return driver.findElement(locator); // Returns when the object identified

		} catch (StaleElementReferenceException e) {

			return waitForElement(locator); // recalls the function till the element on the page identified
		}
	}

}
