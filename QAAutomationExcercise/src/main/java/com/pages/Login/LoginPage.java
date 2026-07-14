package com.pages.Login;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actions.Action;
import com.base.BaseClass;

	public class LoginPage extends BaseClass {
		
	Action actions;
	
	@FindBy(xpath = "//a[@href='/login']")
	List<WebElement> signupLoginBtn;
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement logoutBtn;
	
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
		actions = new Action();
	}

	
	public void clickSignUpLogin() 
	{
		actions.clickVisibleElement(driver, signupLoginBtn, "SignUpLoginBtn");
	}
	
	
	public void login(String User, String Password) 
	{
		emailAddress.clear();
		emailAddress.sendKeys(User);
		
		password.clear();
		password.sendKeys(Password);
		
		loginBtn.click();
	}
	
	
//	public void clickLogoutButton()
//	{
//		loginBtn.click();
//	}
	

}
