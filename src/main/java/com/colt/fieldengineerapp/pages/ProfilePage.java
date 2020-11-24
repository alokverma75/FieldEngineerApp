package com.colt.fieldengineerapp.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.colt.fieldengineerapp.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage extends TestBase {
	
	public ProfilePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, getDuration(50)), this);
	}
	
	@AndroidFindBy(uiAutomator = "text(\"Profile\")")
	private AndroidElement profilePageLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_title")
	private AndroidElement profilePageUserLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Basic Details\")")
	private AndroidElement basicDetailsTab;
	
	@AndroidFindBy(uiAutomator = "text(\"Title\")")
	private AndroidElement titleLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_title")
	private AndroidElement titleDropDown;
	
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_first_name")
	private AndroidElement firstNameLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_first_name")
	private AndroidElement firstNameTF;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_last_name")
	private AndroidElement lastNameLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_last_name")
	private AndroidElement lastNameTF;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_phone_number")
	private AndroidElement phoneNumberLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_phone_number")
	private AndroidElement phoneNumberTF;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_phone_number_info")
	private AndroidElement phoenNumberInfoLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_mobile")
	private AndroidElement mobileNumberLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_mobile")
	private AndroidElement mobileNumberTF;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_email")
	private AndroidElement emailLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_email")
	private AndroidElement emailTF;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_preferred_contact")
	private AndroidElement preferredContactLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_preferred_contact")
	private AndroidElement preferredContactTF;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_display_language")
	private AndroidElement displayLangLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/spin_language")
	private AndroidElement displayLangDropDown;
	
	@AndroidFindBy(uiAutomator = "text(\"Change Password\")")
	private AndroidElement changePasswordTab;
	
	@AndroidFindBy(uiAutomator = "text(\"Current Password\")")
	private AndroidElement currentPasswordLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/text_input_password_toggle")
	private List<AndroidElement> showPasswordButton;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_current_password")
	private AndroidElement currentPasswordTF;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_new_passowrd")
	private AndroidElement newPasswordLabel;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/et_new_password")
	private AndroidElement newPasswordTF;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_confirm_passowrd")
	private AndroidElement confirmPasswordLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/et_confirm_password")
	private AndroidElement confirmPasswordTF;

	@AndroidFindBy(id = "com.colt.coltengineering:id/btn_change_password")
	private AndroidElement changePasswordButton;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_password_consrnt_1")
	private AndroidElement passwordInfoLabel1;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_password_consrnt_2")
	private AndroidElement passwordInfoLabel2;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_password_consrnt_3")
	private AndroidElement passwordInfoLabel3;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_password_consrnt_4")
	private AndroidElement passwordInfoLabel4;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tv_password_consrnt_5")
	private AndroidElement passwordInfoLabel5;
	
	@AndroidFindBy(uiAutomator = "text(\"Please enter current password\")")
	private AndroidElement enterCurrentPasswordLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Please enter new password\")")
	private AndroidElement enterNewPasswordLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Please confirm password\")")
	private AndroidElement enterConfirmPasswordLabel;
	
	@AndroidFindBy(uiAutomator = "text(\"Password mismatch\")")
	private AndroidElement passwordMismatchLabel;

	@AndroidFindBy(id = "com.colt.coltengineering:id/tvAlertMsg")
	private AndroidElement changingPasswordAlertMsg;
	
	@AndroidFindBy(id = "com.colt.coltengineering:id/snackbar_text")
	private AndroidElement passwordMessageSnackBarSuccess;
	
	public AndroidElement getEnterConfirmPasswordLabel() {
		return enterConfirmPasswordLabel;
	}

	public AndroidElement getPasswordMismatchLabel() {
		return passwordMismatchLabel;
	}

	public AndroidElement getEnterCurrentPasswordLabel() {
		return enterCurrentPasswordLabel;
	}

	public AndroidElement getEnterNewPasswordLabel() {
		return enterNewPasswordLabel;
	}

	public AndroidElement getChangingPasswordAlertMsg() {
		return changingPasswordAlertMsg;
	}

	public AndroidElement getPasswordMessageSnackBarSuccess() {
		return passwordMessageSnackBarSuccess;
	}

	public AndroidElement getChangePasswordTab() {
		return changePasswordTab;
	}

	public AndroidElement getCurrentPasswordLabel() {
		return currentPasswordLabel;
	}

	public List<AndroidElement> getShowPasswordButton() {
		return showPasswordButton;
	}

	public AndroidElement getCurrentPasswordTF() {
		return currentPasswordTF;
	}

	public AndroidElement getNewPasswordLabel() {
		return newPasswordLabel;
	}

	public AndroidElement getNewPasswordTF() {
		return newPasswordTF;
	}

	public AndroidElement getConfirmPasswordLabel() {
		return confirmPasswordLabel;
	}

	public AndroidElement getConfirmPasswordTF() {
		return confirmPasswordTF;
	}

	public AndroidElement getChangePasswordButton() {
		return changePasswordButton;
	}

	public AndroidElement getPasswordInfoLabel1() {
		return passwordInfoLabel1;
	}

	public AndroidElement getPasswordInfoLabel2() {
		return passwordInfoLabel2;
	}

	public AndroidElement getPasswordInfoLabel3() {
		return passwordInfoLabel3;
	}

	public AndroidElement getPasswordInfoLabel4() {
		return passwordInfoLabel4;
	}

	public AndroidElement getPasswordInfoLabel5() {
		return passwordInfoLabel5;
	}

	public AndroidElement getProfilePageLabel() {
		return profilePageLabel;
	}

	public AndroidElement getProfilePageUserLabel() {
		return profilePageUserLabel;
	}

	public AndroidElement getBasicDetailsTab() {
		return basicDetailsTab;
	}

	public AndroidElement getTitleLabel() {
		return titleLabel;
	}

	public AndroidElement getTitleDropDown() {
		return titleDropDown;
	}

	public AndroidElement getFirstNameLabel() {
		return firstNameLabel;
	}

	public AndroidElement getFirstNameTF() {
		return firstNameTF;
	}

	public AndroidElement getLastNameLabel() {
		return lastNameLabel;
	}

	public AndroidElement getLastNameTF() {
		return lastNameTF;
	}

	public AndroidElement getPhoneNumberLabel() {
		return phoneNumberLabel;
	}

	public AndroidElement getPhoneNumberTF() {
		return phoneNumberTF;
	}

	public AndroidElement getPhoenNumberInfoLabel() {
		return phoenNumberInfoLabel;
	}

	public AndroidElement getMobileNumberLabel() {
		return mobileNumberLabel;
	}

	public AndroidElement getMobileNumberTF() {
		return mobileNumberTF;
	}

	public AndroidElement getEmailLabel() {
		return emailLabel;
	}

	public AndroidElement getEmailTF() {
		return emailTF;
	}

	public AndroidElement getPreferredContactLabel() {
		return preferredContactLabel;
	}

	public AndroidElement getPreferredContactTF() {
		return preferredContactTF;
	}

	public AndroidElement getDisplayLangLabel() {
		return displayLangLabel;
	}

	public AndroidElement getDisplayLangDropDown() {
		return displayLangDropDown;
	}
}
