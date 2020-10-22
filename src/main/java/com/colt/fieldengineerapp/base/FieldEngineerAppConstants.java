package com.colt.fieldengineerapp.base;

public interface FieldEngineerAppConstants {
	
	//Tap options
	
		public static final String ELEMENT_ATTRIBUTE_TEXT = "text(\"";
		public static final String ELEMENT_ATTRIBUTE_CONTENT_DESC = "new UiSelector().description(\"";
		public static final String ELEMENT_ATTRIBUTE_SCROLL_VIEW = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"";
		public static final String ELEMENT_SCROLL_SUFFIX = "\"));";
		public static final String ELEMENT_TAP_SUFFIX = "\")";		
		
		
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
		
		
		//Login Page
		
		public static final String ELEMENT_USER_ID = "User ID";
		public static final String ELEMENT_PASSWORD = "Password";
		public static final String ELEMENT_CHECKBOX_REMEMBER = "Remember me";
		public static final String BUTTON_LOGIN = "Login";
		public static final String BUTTON_SIGNUP = "Don't have an account? Sign up";
		
		
		//Landing Page
		public static final String ELEMENT_RADIO_NONE="None";		
		public static final String BUTTON_CONTINUE = "Continue";
		public static final String ELEMENT_AUTHENTICATION_LABEL="Choose Authentication Type";
		public static final String ELEMENT_AUTHENTICATION_ID="com.colt.coltengineering:id/tv_title";
		
		//HomePage: Page 3
		public static final String ELEMENT_HOMEPAGE_LABEL="Field Experts";
		public static final String ELEMENT_HOMEPAGE_TASKS_LABEL="Tasks";
		
		//Raise Planned Work Page
		public static final String ELEMENT_TEMPLATE_DROPDOWN_1="Please Select";
		public static final String ELEMENT_TEMPLATE_DROPDOWN_2="Standard SD";
		
		//Category dropdown values on Raised Planned Work Page
		public static final String ELEMENT_CATEGORY_DROPDOWN_1="Node Works";
		public static final String ELEMENT_CATEGORY_DROPDOWN_2="Service Delivery";
		public static final String ELEMENT_CATEGORY_DROPDOWN_3="Voice Configuration";
		public static final String ELEMENT_CATEGORY_DROPDOWN_4="IP Configuration";
		public static final String ELEMENT_CATEGORY_DROPDOWN_5="Installation & Service Testing";
		public static final String ELEMENT_CATEGORY_DROPDOWN_6="Fibre Works";
		
		//Change description dropdown values for selection
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_1="Cabling/removal of cabling to live equipment in nodes – ADVA FSP3000";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_2="Cabling/removal of cabling to live equipment in nodes – Atrica";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_3="Cabling/removal of cabling to live equipment – IQ Net 6500";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_4="Cabling/removal of cabling to live equipment – Infinera";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_5="Cabling/removal of cabling to live equipment – WDM Nortel LDN";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_6="Cyan Z77 CORE devices - Card insertion/removal to live equipment in nodes MSP SDH WDM devices routers switch";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_7="Decommissioned Equipment uninstallation in nodes";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_8="IQ Net 6500 - New card in live mux EXCLUDING OTR/ MOTR and CXN";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_9="IQ Net 6500 CIENA - Insert/Remove OTR/MOTR cards in existing chassis configuration and run optical patchcords to CCMD ports";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_10="Decommissioned Equipment uninstallation in nodes";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_11="IQ Net 6500 CIENA - Insert/Remove OTR/MOTR cards in existing chassis configuration and run optical patchcords to CCMD ports";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_12="Infinera LDN - Insert/ Remove any Cards";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_13="Jumpering/removal of jumpering in DDF's ODF's RDF's";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_14="Jumpering/removal of jumpering to DDF; ODFs and insert/remove cards; SFP’s; Cabling on IQ Net 6500 & Infinera Equipment or Insert/remove SFP & Cabling on Cisco Equipment";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_15="LTS order - DC power cabling; patching to ODF and IQ Net; Infinera or Cisco Equipment";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_16="Node - Cisco routers card installs";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_17="Node - Infinera - New TAM / TIM / TOM Installs";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_18="Node - MSP Atrica SFP insertions";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_19="Node - MSP Atrica card insertions";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_20="PO Cyan - PSW card";
		public static final String ELEMENT_CHANGE_DESCRIPTION_DROPDOWN_21="Power cabling or insertion of new power modules or batterries";
		
		
		//Single Task Details Page
		
		public static final String ELEMENT_TEXT_VIEW="android.widget.TextView";
		public static final String ELEMENT_TV_VALUE="com.colt.coltengineering:id/tv_value";
		public static final String ELEMENT_JOB_STATUS="Job Status";
		public static final String ELEMENT_JOB_OWNER="Job Owner";
		public static final String ELEMENT_PLANNED_START_DATE="Planned Start Date/Time";
		public static final String ELEMENT_CPD="CPD";
		public static final String ELEMENT_JOB_REMARKS="Job Remarks";
		public static final String ELEMENT_COOP_TECH_MAIL="Coop Tech Email";
		
		
		
		
		
		
		
		
		
		
		
		

}
