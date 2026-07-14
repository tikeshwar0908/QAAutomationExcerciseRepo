package com.pages.Cart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actions.Action;
import com.base.BaseClass;

public class CartPage extends BaseClass {

    Action actions;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@href='/view_cart']")
    WebElement cartClick;

    @FindBy(xpath = "//a[@href='/products']")
    List<WebElement> clickHereLink;

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchProduct;

    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement searchBtn;

    @FindBy(xpath = "//a[@data-product-id='1' and contains(@class,'add-to-cart')]")
    WebElement addToCart;

    @FindBy(xpath = "//div[@id='cartModal' and contains(@class,'show')]//button[normalize-space()='Continue Shopping']")
    WebElement continueShoppingBtn;

    @FindBy(xpath = "//a[@href='/view_cart']")
    List<WebElement> viewCartLink;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    WebElement proceedToCheckoutBtn;
    
    @FindBy(xpath = "//a[@href='/payment']")
    WebElement placeOrderLink;
    
    @FindBy(xpath = "//input[@name='name_on_card']")
    WebElement nameOnCard;
    
    @FindBy(xpath = "//input[@name='card_number']")
    WebElement cardNumber;
    
    @FindBy(xpath = "//input[@name='cvc']")
    WebElement cvcNumber;
    
    @FindBy(xpath = "//input[@name='expiry_month']")
    WebElement expirationMonth;
    
    @FindBy(xpath = "//input[@name='expiry_year']")
    WebElement expirationYear;
    
    @FindBy(xpath = "//button[@class='form-control btn btn-primary submit-button']")
    WebElement payAndConfirmOrder;
    
    @FindBy(xpath = "//a[@href='/download_invoice/500']")
    WebElement downloadInvoice;
    
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueLink;
    

    public CartPage() {
        PageFactory.initElements(driver, this);
        actions = new Action();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void closeAdIfPresent() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));

            List<WebElement> closeButtons = driver.findElements(By.xpath(
                "//div[@id='dismiss-button'] | " +
                "//button[@id='dismiss-button'] | " +
                "//span[text()='Close'] | " +
                "//div[@aria-label='Close'] | " +
                "//button[@aria-label='Close'] | " +
                "//span[contains(text(),'×')]"
            ));

            for (WebElement closeBtn : closeButtons) {
                try {
                    if (closeBtn.isDisplayed()) {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
                        Thread.sleep(1000);
                        return;
                    }
                } catch (Exception ignored) {
                }
            }

            List<WebElement> frames = driver.findElements(By.tagName("iframe"));

            for (WebElement frame : frames) {
                try {
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame(frame);

                    List<WebElement> frameCloseButtons = driver.findElements(By.xpath(
                        "//div[@id='dismiss-button'] | " +
                        "//button[@id='dismiss-button'] | " +
                        "//span[text()='Close'] | " +
                        "//div[@aria-label='Close'] | " +
                        "//button[@aria-label='Close'] | " +
                        "//span[contains(text(),'×')]"
                    ));

                    for (WebElement closeBtn : frameCloseButtons) {
                        if (closeBtn.isDisplayed()) {
                            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
                            driver.switchTo().defaultContent();
                            Thread.sleep(1000);
                            return;
                        }
                    }

                } catch (Exception ignored) {
                }
            }

            driver.switchTo().defaultContent();

        } catch (Exception e) {
            driver.switchTo().defaultContent();
        }
    }

    public void safeClick(WebElement element) {
        closeAdIfPresent();

        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (ElementClickInterceptedException e) {
            closeAdIfPresent();
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (WebDriverException e) {
            closeAdIfPresent();
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void clickOnCart() {
        safeClick(cartClick);
    }

    public void clickOnClickHereLink() {
        closeAdIfPresent();
        actions.clickVisibleElement(driver, clickHereLink, "here");
    }

    public void searchProductByName(String PName) {
        closeAdIfPresent();

        wait.until(ExpectedConditions.visibilityOf(searchProduct));
        searchProduct.click();
        searchProduct.clear();
        searchProduct.sendKeys(PName);

        safeClick(searchBtn);
    }

    public void productAddTocart() {
        closeAdIfPresent();
        safeClick(addToCart);
    }

    public void clickOnContinueShoppingLink() {
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='cartModal' and contains(@class,'show')]//button[normalize-space()='Continue Shopping']")
            ));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

        } catch (TimeoutException e) {
            System.out.println("Continue Shopping popup not visible.");
        }
    }

    public void viewCart() {
        closeAdIfPresent();
        actions.clickVisibleElement(driver, viewCartLink, "ViewCart");
    }

    public void clickOnProceedToCheckOut() {
        closeAdIfPresent();
        safeClick(proceedToCheckoutBtn);
    }
    
    public void clickOnPlaceOrderLink() 
    {
    	closeAdIfPresent();
    	safeClick(placeOrderLink);
	}
    
    public void enterCardDetails(String NameOnCard, String CardNumber, String CVC, String ExpMonth, String ExpYear)
    {
    	closeAdIfPresent();
    	
    	nameOnCard.click();
    	nameOnCard.clear();
    	nameOnCard.sendKeys(NameOnCard);
    	
    	cardNumber.click();
    	cardNumber.clear();
    	cardNumber.sendKeys(CardNumber);
    	
    	cvcNumber.click();
    	cvcNumber.clear();
    	cvcNumber.sendKeys(CVC);
    	
    	expirationMonth.click();
    	expirationMonth.clear();
    	expirationMonth.sendKeys(ExpMonth);
    	
    	expirationYear.click();
    	expirationYear.clear();
    	expirationYear.sendKeys(ExpYear);
    	
    	safeClick(payAndConfirmOrder);
    }
    
    public void clickOnDownloadInvoiceLink() 
    {
    	closeAdIfPresent();
    	safeClick(downloadInvoice);
	}
    
    public void clickContinueLink() 
    {
    	closeAdIfPresent();
    	safeClick(continueLink);
	}
    
}









// My code ---------------------------------------------------------------

//package com.pages.Cart;

//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.actions.Action;
//import com.base.BaseClass;
//
//public class CartPage extends BaseClass {
//	
//	Action actions;
//	WebDriverWait wait;
//	
//	@FindBy(xpath = "//a[@href='/view_cart']")
//	WebElement cartClick;
//	
//	@FindBy(xpath = "//a[@href='/products']")
//	List<WebElement> clickHereLink;
//	
//	@FindBy(xpath = "//input[@id='search_product']")
//	WebElement searchProduct;
//	
//	@FindBy(xpath = "//button[@id='submit_search']")
//	WebElement searchBtn;
//	
//	@FindBy(xpath = "//a[@data-product-id='1' and @class='btn btn-default add-to-cart']")
//	WebElement addToCart;
//	
//	@FindBy(xpath = "//div[@id='cartModal' and contains(@class,'show')]//button[normalize-space()='Continue Shopping']")
//	private WebElement continueShoppingBtn;
//	
//	@FindBy(xpath = "//a[@href='/view_cart']")
//	List<WebElement> viewCartLink;
//	
//	@FindBy(xpath = "//a[@class='btn btn-default check_out']")
//	WebElement proceedToCheckoutBtn;
//	
//	@FindBy(xpath = "//a[@href='/payment']")
//	WebElement placeOrderLink;
//
//	@FindBy(xpath = "//input[@name='name_on_card']")
//	WebElement nameOnCard;
//
//	@FindBy(xpath = "//input[@name='card_number']")
//	WebElement cardNumber;
//
//	@FindBy(xpath = "//input[@name='cvc']")
//	WebElement cvcNumber;
//
//	@FindBy(xpath = "//input[@name='expiry_month']")
//	WebElement expirationMonth;
//
//	@FindBy(xpath = "//input[@name='expiry_year']")
//	WebElement expirationYear;
//
//	@FindBy(xpath = "//button[@class='form-control btn btn-primary submit-button']")
//	WebElement payAndConfirmOrder;
//
//	@FindBy(xpath = "//a[@href='/download_invoice/500']")
//	WebElement downloadInvoice;
//	
//  @FindBy(xpath = "//a[@data-qa='continue-button']")
//  WebElement continueLink;
//	
//	public CartPage()
//	{
//		PageFactory.initElements(driver, this);
//		actions = new Action();
//		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	}
//	
//	public void clickOnCart() 
//	{
//		actions.click(driver, cartClick);
//	}
//	
//	public void clickOnClickHereLink() 
//	{
//		actions.clickVisibleElement(driver, clickHereLink, "here");
//	}
//	
//	public void searchProductByName(String PName) 
//	{
//		searchProduct.click();
//		searchProduct.clear();
//		searchProduct.sendKeys(PName);
//		
//		actions.click(driver, searchBtn);
//	}
//	
//	public void productAddTocart() 
//	{
//		actions.click(driver, addToCart);
//	}
//	
//	public void clickOnContinueShoppingLink() 
//	{
//		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(
//		        By.xpath("//div[@id='cartModal' and contains(@class,'show')]//button[normalize-space()='Continue Shopping']")
//		    ));
//
//		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
//		}
//	
//	public void viewCart() 
//	{
//		actions.clickVisibleElement(driver, viewCartLink, "ViewCart");
//	}
//	
//	public void clickOnProceedToCheckOut() 
//	{
//		actions.click(driver, proceedToCheckoutBtn);
//	}
//
//	public void enterCardDetails(String NameOnCard, String CardNumber, String CVC, String ExpMonth, String ExpYear)
//	{
//	nameOnCard.click();
//	nameOnCard.clear();
//	nameOnCard.sendKeys(NameOnCard);
//	
//	cardNumber.click();
//	cardNumber.clear();
//	cardNumber.sendKeys(CardNumber);
//	
//	cvcNumber.click();
//	cvcNumber.clear();
//	cvcNumber.sendKeys(CVC);
//	
//	expirationMonth.click();
//	expirationMonth.clear();
//	expirationMonth.sendKeys(ExpMonth);
//	
//	expirationYear.click();
//	expirationYear.clear();
//	expirationYear.sendKeys(ExpYear);
//	
//	actions.click(driver, payAndConfirmOrder);
//	}
//
//	public void clickOnDownloadInvoiceLink() 
//	{
//	actions.click(driver, downloadInvoice);
//	}
//
//  public void clickContinueLink() 
//	{
//	actions.click(driver, continueLink);
//	}
//	
//
//}

