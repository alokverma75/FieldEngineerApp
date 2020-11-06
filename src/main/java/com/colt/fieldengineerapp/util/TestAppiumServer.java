package com.colt.fieldengineerapp.util;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestAppiumServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	
	public static void startServer() {
		String Appium_Node_Path="C:/Program Files/Appium/node.exe";
		String Appium_JS_Path="C:/Users/Medhansh/AppData/Roaming/npm/node_modules/appium/build/lib/appium.js";
		AppiumDriverLocalService appiumService;

		appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4823).
			               usingDriverExecutable(new File(Appium_Node_Path)).
			                withAppiumJS(new File(Appium_JS_Path)));
		appiumService.start();
	}

}
