package com.colt.fieldengineerapp.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Test extends TestBase{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd HH/mm/ss");
		 Date date = new Date();
		 
		 //String video = driver.stopRecordingScreen();
		 //byte[] decode = Base64.getDecoder().decode(video);
		 
		 String data = "test";
		 
		 AndroidDriver<AndroidElement> driver = TestBase.getDriver();
			
		 //System.out.println(" Size of file i "+ decode.length);
		 FileUtils.write(new File(USRDIR + "/"+prop.getProperty("recordings")+ new Test().printClassName()+ 
				 dateFormat.format(date)+ ".text"), data);
		  

	}
	
	private String printClassName() {
		//String className = this.getClass().getSimpleName();
		 String nameofCurrMethod = new Throwable() 
                 .getStackTrace()[0] 
                 .getMethodName(); 
		
		System.out.println(nameofCurrMethod);
		
		return nameofCurrMethod;		
	}

}
