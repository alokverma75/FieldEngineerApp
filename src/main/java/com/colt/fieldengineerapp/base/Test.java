package com.colt.fieldengineerapp.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Test extends TestBase{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd HH/mm/ss");
//		 Date date = new Date();
//		 
//		 //String video = driver.stopRecordingScreen();
//		 //byte[] decode = Base64.getDecoder().decode(video);
//		 String nameofCurrMethod = new Throwable() 
//                 .getStackTrace()[0] 
//                 .getMethodName(); 
//		
//		System.out.println(nameofCurrMethod);
//		String directoryName = prop.getProperty("screenShots");
//		String finalPath = System.getProperty("user.dir")+File.separator+directoryName+File.separator+"test"+".png";
//		//String finalPath = System.getProperty("user.dir");
//		
//		//System.out.println(directoryName);
//		System.out.println(finalPath);
//		 String data = "test";
//		 
//		 //AndroidDriver<AndroidElement> driver = TestBase.getDriver();
//			
//		 //System.out.println(" Size of file i "+ decode.length);
////		 FileUtils.writeLines(new File(USRDIR + "/"+prop.getProperty("recordings")+ new Test().printClassName()+ 
////				 dateFormat.format(date)+ ".text"), data);
//		 //startEmulator(); 
//		 startAppiumServer();
		
		String japan = "フィールド専門家";
		System.out.println(" Japanese "+ japan);

	}
	
	private String printClassName() {
		//String className = this.getClass().getSimpleName();
		 String nameofCurrMethod = new Throwable() 
                 .getStackTrace()[0] 
                 .getMethodName(); 
		
		System.out.println(nameofCurrMethod);
		System.out.println(File.separator);
		
		return nameofCurrMethod;		
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{
		System.out.println("Inside Start emulator");
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}
	
	public static void startAppiumServer() throws IOException, InterruptedException {
			
		
//			//C:\Users\Medhansh\AppData\Roaming\npm\node_modules\appium\build\lib
//			//service = AppiumDriverLocalService.buildDefaultService();
//		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//				.withAppiumJS(new File("C:/Users/Medhansh/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4923));
		AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.usingPort(4824)
                .withIPAddress("127.0.0.1")
                .usingDriverExecutable(new File("D:/nodejs/node.exe"))
                .withAppiumJS(new File("C:/Users/Medhansh/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE);
                //.withLogFile(new File(System.getProperty("user.dir") + "/target/resources/appium_server_logs" + Thread.currentThread().getId()));
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(appiumServiceBuilder);
			service.start();	
	}
		


}
