package com.tests.Registration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Login.LoginPage;
import com.pages.Registration.RegistrationPage;


public class RegistrationPageTest extends BaseClass {
	
	RegistrationPage registrationPage;
	
	public RegistrationPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		registrationPage = new RegistrationPage();
		
		registrationPage.clickSignUpLogin();
	}
	
	@Test(priority=1)
	public void verifySignUpUser()
	{
		registrationPage.scrollByPixel(200);
		registrationPage.enterAndClickSignUpBtn(prop.getProperty("name"), prop.getProperty("emailAddress"));
		
		registrationPage.selectTitle();
		
		registrationPage.enterPassword("Rahul222");
		
		registrationPage.selectDays("10");
		
		registrationPage.selectMonths("March");
		
		registrationPage.selectYear("2020");
		
		registrationPage.selectNewLetterCheckbox();
		
		registrationPage.enterFirstName("Rahul");
		
		registrationPage.enterLastName("Kumar");
		
		registrationPage.enterAddress("Avenue Street e5");
		
		registrationPage.enterState("Alabama");
		
		registrationPage.enterCity("Noida");
		
		registrationPage.enterZipCode("12345");
		
		registrationPage.enterMobile("11111");
		
		registrationPage.clickCreateAccountBtn();
	}
	
//	@Test(priority=2)
//	public void verifySignUpWithExistingUser()
//	{
//		registrationPage.scrollByPixel(200);
//		registrationPage.enterAndClickSignUpBtn(prop.getProperty("name"), prop.getProperty("emailAddress"));
//	}
	
	
}
