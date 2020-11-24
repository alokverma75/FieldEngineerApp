package com.colt.fieldengineerapp.testcases;

import org.junit.Test;

import com.colt.fieldengineerapp.base.TestBase;
import com.colt.fieldengineerapp.util.Log4J2PropertiesConf;


public class TestLog4j extends TestBase{
	
	@Test
    public void testPerformSomeTask() throws Exception {
		Log4J2PropertiesConf app=new Log4J2PropertiesConf();
      app.performSomeTask();
    }

}
