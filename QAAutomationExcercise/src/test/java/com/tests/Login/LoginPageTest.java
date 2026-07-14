package com.tests.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Login.LoginPage;

public class LoginPageTest extends BaseClass {

	LoginPage loginPage;
	
	public LoginPageTest() 
	{
		super();	
	}
	
	@BeforeMethod
	public void setup() 
	{
		initialization();
		loginPage = new LoginPage();

		loginPage.clickSignUpLogin();
		
		loginPage.scrollByPixel(200);
	}
	
	@Test(priority=1)
	public void verifyLoginFunctionality()
	{
		loginPage.login(prop.getProperty("emailAddress"),prop.getProperty("password"));
	}
	
//	@Test(priority=2)
//	public void loginWithInvalidCred()
//	{	
//		loginPage.login("test@gmail.com", "password123");
//	}
//	
//	@Test(priority=3)
//	public void loginWithBlankCred()
//	{
//		loginPage.login("", "");
//	}
	
//	@Test(priority=4)
//	public void loginWithValidEmailAndEmptyPass()
//	{
//		loginPage.login("tikeshwarfc1@gmail.com", "");
//	}
	
	
//	@Test(priority=5)
//	public void clickLogoutButtonTest()
//	{
//		loginPage.clickLogoutButton();
//	}
	
}
