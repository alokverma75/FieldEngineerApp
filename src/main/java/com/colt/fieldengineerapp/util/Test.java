package com.colt.fieldengineerapp.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.colt.fieldengineerapp.base.TestBase;

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
		String directoryName = prop.getProperty("screenShots");
		String finalPath = System.getProperty("user.dir")+File.separator+directoryName+File.separator+"test"+".png";
	//	String finalPath = System.getProperty("user.dir");
		
		//System.out.println(directoryName);
		//System.out.println(finalPath);
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
		//System.out.println(" Japanese "+ japan);
		//ffmpeg -i inVideo.mp4 -i coltSmall.png -filter_complex "overlay=2:20" Colt-WaterMarked.mp4
		SimpleDateFormat dateFormat = new SimpleDateFormat(prop.getProperty("datePattern"));
		Date date = new Date();
		System.out.println("Date format new is "+ dateFormat.format(date));
		//public static String USRDIR = System.getProperty("user.dir");
		String dirPath = System.getProperty("user.dir");
		String videoNameB4 = " inVideo.mp4";
		String newDirName = "Recordings";
		//String newFileName = className + "." + methodName + "." + dateFormat.format(date) + ".mp4";
		//dirPath + File.separator + newDirName
		//System.out.println(" File name is " + newFileName);
		//System.getProperty("user.dir")+"\\resources\\ChangePath.bat"

		
		String recordingFolder =  "cd  " +dirPath + File.separator + newDirName;
		//System.out.println("recordingFolder "+ recordingFolder);
		String exeCmd = "ffmpeg  " + "-i" + videoNameB4 + "-i"+ " coltSmall.png" + "-filter_complex overlay=0:0  "+  "Colt-WaterMarked.mp4";
		//System.out.println(" folder is "+ System.getProperty("user.dir")+"\\resources\\ChangePath.bat");
        //Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\resources\\ChangePath.bat");
		//Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\resources\\startEmulator.bat");
		//Runtime.getRuntime().exec(exeCmd);
		//convertVideo();
		//startEmu();
		String path = "D:\\TechPractice\\Appium\\FieldEngineerApp\\Recordings";
		//createFile();
		deleteDirectoryTest(new File(path));

	}
	
	public static void convertVideo() throws InterruptedException
	{
		System.out.println("Inside video convertor");
		try {
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\resources\\Test.bat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Thread.sleep(6000);
	}
	
	public static void startEmu() throws InterruptedException
	{
		System.out.println("Inside new start mode");
		try {
			//ffmpeg -i inVideo.mp4 -i coltSmall.png -filter_complex "overlay=2:20" Colt-WaterMarked.mp4
			//String[] line = {"C:\\Program Files\\ffmpeg\\bin\\ffmpeg", "-i", "D:\\hadoop-video\\testVideo\\xyz", "%d.png"};
			String[] cmd = {"D:\\TechSoftwares\\ffmpeg-4.3.1-win64-static\\bin\\ffmpeg", "-i", 
			"D:\\TechPractice\\Appium\\FieldEngineerApp\\Recordings\\inVideo.mp4"
			,  
			"-i","D:\\TechPractice\\Appium\\FieldEngineerApp\\Recordings\\coltSmall.png",
			 "-filter_complex","overlay=0:0",
			"D:\\TechPractice\\Appium\\FieldEngineerApp\\Recordings\\Colt-WaterMarked.mp4"
			 };
			//Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\resources\\Test.bat");
			new ProcessBuilder(Arrays.asList(cmd)).start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Thread.sleep(6000);
	}
	
	public static void createFile() {
		
		 File myObj = null;
		
		try {  
		       myObj = new File("filename.mp4");  
		      if (myObj.createNewFile()) {  
		        System.out.println("File created: " + myObj.getName());  
		      } else {  
		        System.out.println("File already exists.");  
		      }  
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();  
		    }
		
		if(myObj.isFile()) {
			//myObj.delete();
			System.out.println(" if myObj is file "+ myObj.isFile());
			
			if (myObj.delete()) { 
			      System.out.println("Deleted the file: " + myObj.getName());
			    } else {
			      System.out.println("Failed to delete the file.");
			    } 
			
			
		}
//		File myObj1 = new File("filename1.txt");
//		if (myObj1.delete()) { 
//		      System.out.println("Deleted the file: " + myObj1.getName());
//		    } else {
//		      System.out.println("Failed to delete the file.");
//		    } 
//		
	}
	
	static public void deleteDirectoryTest(File path) {
	    if (path.exists()) {
	        File[] files = path.listFiles();
	        for (int i = 0; i < files.length; i++) {
	            if (files[i].isDirectory()) {
	                deleteDirectoryTest(files[i]);
	                System.out.println(" Inside dir loop");
	            } else {
	                files[i].delete();
	                System.out.println(" Inside file delete");
	            }
	        }
	    }
	    //return (path.delete());
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
