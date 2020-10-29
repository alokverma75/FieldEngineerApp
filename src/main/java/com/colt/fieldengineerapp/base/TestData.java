package com.colt.fieldengineerapp.base;

import org.testng.annotations.DataProvider;


/**
 * This class can be used to pass data to testcases as per need. Entire test will run as many data we will provide through 
 * this by adding additional methods and relevant data
 * @author Alok Verma
 *
 */
public class TestData {
	
	@DataProvider(name="InputData")
	public Object[][] getDataForEditField(){
		
		Object[][] dataObject = new Object[][] {
			
			{"coltonlinedcp", "Colt@1234"}, {"coltonlinedcp", "Colt@1234"}
			
		};
		
		return dataObject;
	}
	
	@DataProvider(name="TextFieldsData")
	public Object[][] getDataForRaisePlannedWorksTest(){
		
		Object[][] dataObject = new Object[][] {
			
			{"12345", "1234","123456","Test_Alok"}
			
		};
		
		return dataObject;
	}

}
