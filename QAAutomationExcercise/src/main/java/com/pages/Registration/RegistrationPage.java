package com.pages.Registration;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actions.Action;
import com.base.BaseClass;

public class RegistrationPage extends BaseClass {

	Action actions;
	WebDriverWait wait;
	
	@FindBy(xpath = "//a[@href='/login']")
	List<WebElement> signupLoginBtn;
	
	@FindBy(xpath = "//input[@data-qa='signup-name']")
	WebElement name;
	
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//button[@data-qa='signup-button']")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//input[@type='radio' and @value='Mr']")
	WebElement titleMr;
	
	@FindBy(xpath = "//input[@data-qa='password']")
	WebElement passwordTxt;
	
	@FindBy(xpath = "//select[@data-qa='days']")
	WebElement days;
	
	@FindBy(xpath = "//select[@data-qa='months']")
	WebElement months;
	
	@FindBy(xpath = "//select[@data-qa='years']")
	WebElement years;
	
	@FindBy(xpath = "//input[@id='newsletter']")
	WebElement signUpNewsLetterCheckbox;
	
	@FindBy(id = "first_name")
	WebElement firstNameTxt;
	
	@FindBy(id = "last_name")
	WebElement lastNameTxt;
	
	@FindBy(xpath = "//input[@data-qa='address']")
	WebElement addressTxt;
	
	@FindBy(xpath = "//input[@data-qa='state']")
	WebElement stateTxt;
	
	@FindBy(xpath = "//input[@data-qa='city']")
	WebElement cityTxt;
	
	@FindBy(xpath = "//input[@data-qa='zipcode']")
	WebElement zipcodeTxt;
	
	@FindBy(xpath = "//input[@data-qa='mobile_number']")
	WebElement mobileNumberTxt;
	
	@FindBy(xpath = "//button[@data-qa='create-account']")
	WebElement createAccountBtn;
	
	
	public RegistrationPage()
	{
		PageFactory.initElements(driver, this);
		actions = new Action();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	
	public void clickSignUpLogin() 
	{
		actions.clickVisibleElement(driver, signupLoginBtn, "SignUpLoginBtn");
	}
	
	public void enterAndClickSignUpBtn(String Name, String Email)
	{
		name.clear();
		name.sendKeys(Name);
		
		emailAddress.clear();
		emailAddress.sendKeys(Email);
		
		signUpBtn.click();
	}
	
	public void selectTitle() 
	{
		titleMr.click();
	}
	
	public void enterPassword(String Pass)
	{
		passwordTxt.clear();
		passwordTxt.sendKeys(Pass);
	}
	
	public void selectDays(String day)
	{
		wait.until(ExpectedConditions.elementToBeClickable(days));
		Select t = new Select(days);
		t.selectByVisibleText(day);
	}
	
	public void selectMonths(String month)
	{
		wait.until(ExpectedConditions.elementToBeClickable(months));
		Select t1 = new Select(months);
		t1.selectByVisibleText(month);
	}
	
	public void selectYear(String year)
	{
		wait.until(ExpectedConditions.elementToBeClickable(years));
		Select t2 = new Select(years);
		t2.selectByVisibleText(year);
	}
	
	public void selectNewLetterCheckbox()
	{
		if (!signUpNewsLetterCheckbox.isSelected())
		{
			signUpNewsLetterCheckbox.click();
		}
	}
		
	public void enterFirstName(String Fname)
	{
		firstNameTxt.clear();
		firstNameTxt.sendKeys(Fname);
	}
		
	public void enterLastName(String Lname)
	{
		lastNameTxt.clear();
		lastNameTxt.sendKeys(Lname);
	}
	
	public void enterAddress(String Address) 
	{
		addressTxt.clear();
		addressTxt.sendKeys(Address);
	}
		
	public void enterState(String State) 
	{
		stateTxt.clear();
		stateTxt.sendKeys(State);
	}
		
	public void enterCity(String City) 
	{
		cityTxt.clear();
		cityTxt.sendKeys(City);
	}
		
	public void enterZipCode(String Zip) 
	{
		zipcodeTxt.clear();
		zipcodeTxt.sendKeys(Zip);
	}
		
	public void enterMobile(String Mobile) 
	{
		mobileNumberTxt.clear();
		mobileNumberTxt.sendKeys(Mobile);
	}
	
	public void clickCreateAccountBtn()
	{
		actions.click(driver, createAccountBtn);
	}
	
	
}
