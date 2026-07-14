package com.tests.Contactus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Contactus.ContactusPage;
import com.pages.Login.LoginPage;

public class ContactusPageTest extends BaseClass {

	LoginPage loginPage;
	ContactusPage contactusPage;
	
	public ContactusPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		contactusPage = new ContactusPage();
		
		loginPage.clickSignUpLogin();
		
		scrollByPixel(200);
		
		loginPage.login(prop.getProperty("emailAddress"), prop.getProperty("password"));
		
		contactusPage.clickContactUs();
	}
	
	@Test(priority=1)
	public void enterContactUsFormDetails()
	{
		contactusPage.enterContactUsFormDetails("Rahul Kumar", "test111@gmail.com", "Test Subject", "This is test message pls ignore");
		
		contactusPage.scrollByPixel(100);
		
		String filePath = System.getProperty("user.dir") + "/src/test/uploadFiles/Sample.pdf";

		contactusPage.uploadFile(filePath);
		
		contactusPage.clickOnSubmitButton();
		
		contactusPage.acceptDismissAlert();
		
		contactusPage.clickOnLogoutButton();
	}
	
	
	
}
