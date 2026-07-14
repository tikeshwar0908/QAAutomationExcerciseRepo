package com.pages.Contactus;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actions.Action;
import com.base.BaseClass;

public class ContactusPage extends BaseClass {
	
	Action actions;
	WebDriverWait wait;
	
	@FindBy(xpath = "//a[@href='/contact_us']")
	WebElement contactUs;
	
	@FindBy(xpath = "//input[@data-qa='name']")
	WebElement name;
	
	@FindBy(xpath = "//input[@data-qa='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@data-qa='subject']")
	WebElement subject;
	
	@FindBy(xpath = "//textarea[@data-qa='message']")
	WebElement messageBox;
	
	@FindBy(xpath = "//input[@type='file']")
	WebElement chooseFile;
	
	@FindBy(xpath = "//input[@data-qa='submit-button']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement logoutBtn;
	
	
	public ContactusPage()
	{
		PageFactory.initElements(driver, this);
		actions = new Action();
		wait =new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void clickContactUs()
	{
		actions.click(driver, contactUs);
	}
	
	public void enterContactUsFormDetails(String Name, String Email, String Subject, String Message) 
	{
		name.click();
		name.clear();
		name.sendKeys(Name);
		
		email.click();
		email.clear();
		email.sendKeys(Email);
		
		subject.click();
		subject.clear();
		subject.sendKeys(Subject);
		
		messageBox.click();
		messageBox.clear();
		messageBox.sendKeys(Message);
	}
	
	public void uploadFile(String filePath) 
	{
	    chooseFile.sendKeys(filePath);
	}
	
	public void clickOnSubmitButton() 
	{
		actions.click(driver, submitBtn);
	}
	
	public void acceptDismissAlert() 
	{
//		Alert t = wait.until(ExpectedConditions.alertIsPresent());
//		t.accept();
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	public void clickOnLogoutButton() 
	{
		actions.click(driver, logoutBtn);
	}
	

}
