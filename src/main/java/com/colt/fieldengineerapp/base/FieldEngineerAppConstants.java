package com.colt.fieldengineerapp.base;

public interface FieldEngineerAppConstants {
	
	//Tap options
	
		public static final String ELEMENT_ATTRIBUTE_TEXT = "text(\"";
		public static final String ELEMENT_ATTRIBUTE_CONTENT_DESC = "new UiSelector().description(\"";
		public static final String ELEMENT_ATTRIBUTE_SCROLL_VIEW = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"";
		public static final String ELEMENT_SCROLL_SUFFIX = "\"));";
		public static final String ELEMENT_TAP_SUFFIX = "\")";	
		
		
		
		
		public static final String ELEMENT_PREFERENCE = "Preference";
		public static final String ELEMENT_TEXT_WIDGET = "android.widget.TextView";
		public static final String ELEMENT_BUTTON_WIDGET = "android.widget.Button";
		public static final String ELEMENT_EDIT_TEXT_WIDGET = "android.widget.EditText";
		public static final String ELEMENT_RELATIVE_LAYOUT_WIDGET = "android.widget.RelativeLayout";
		public static final String ELEMENT_ID_PREFIX = "android:id/";
		public static final String ELEMENT_APIS_ID_PREFIX = "io.appium.android.apis:id/";
		public static final String ELEMENT_XPATH_PREFIX = "//";
		public static final String ELEMENT_XPATH__TEXT_PREFIX = "[@text='";
		public static final String ELEMENT_XPATH__DESCRIPTION_PREFIX = "*[@content-desc='";
		public static final String ELEMENT_XPATH__TEXT_SUFFIX = "']";
		public static final String ELEMENT_CHECKBOX = "checkbox";
		
		//Page Element
		
		
		//Page 1
		public static final String ELEMENT_DROP_DOWN = "text1";
		public static final String ELEMENT_USER_ID = "User ID";
		public static final String ELEMENT_PASSWORD = "Password";
		
		
		//Landing Page
		public static final String ELEMENT_AUTHENTICATION_LABEL="Choose Authentication Type";
		public static final String ELEMENT_AUTHENTICATION_ID="com.colt.coltengineering:id/tv_title";
		
		//HomePage: Page 3
		public static final String ELEMENT_HOMEPAGE_LABEL="Field Experts";
		public static final String ELEMENT_HOMEPAGE_TASKS_LABEL="Tasks";
		
		
		
		public static final String ELEMENT_RADIO_NONE="None";
		
		
		public static final String ELEMENT_CHECKBOX_REMEMBER = "Remember me";
		public static final String BUTTON_LOGIN = "Login";
		public static final String BUTTON_SIGNUP = "Don't have an account? Sign up";
		public static final String BUTTON_CONTINUE = "Continue";
		
		

}
