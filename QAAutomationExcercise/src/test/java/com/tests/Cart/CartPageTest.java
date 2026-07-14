package com.tests.Cart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Cart.CartPage;
import com.pages.Login.LoginPage;

public class CartPageTest extends BaseClass {
		
	LoginPage loginPage;
	CartPage cartPage;
	
	public CartPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		cartPage = new CartPage();
		
		loginPage.clickSignUpLogin();
		
		loginPage.scrollByPixel(200);
		
		loginPage.login(prop.getProperty("emailAddress"), prop.getProperty("password"));
		
		cartPage.clickOnCart();
	}
	
	@Test(priority=1)
	public void ProductAddToCart()
	{
		cartPage.clickOnClickHereLink();
		
		cartPage.scrollByPixel(200);
		
		cartPage.searchProductByName("Blue Top");
		
		cartPage.scrollByPixel(500);
		
		cartPage.productAddTocart();
		
		cartPage.scrollByPixel(500);
		
//		cartPage.clickOnContinueShoppingLink();
		
//		cartPage.scrollByPixel(200);
		
//		cartPage.searchProductByName("Men Tshirt");
		
//		cartPage.scrollByPixel(500);
		
//		cartPage.productAddTocart();
		
		cartPage.viewCart();
		
		cartPage.clickOnProceedToCheckOut();
		
		cartPage.scrollByPixel(800);
		
		cartPage.clickOnPlaceOrderLink();
		
		cartPage.scrollByPixel(150);
		
		cartPage.enterCardDetails("Rahul Kumar", "11111", "123", "08", "2005");
		
		cartPage.clickOnDownloadInvoiceLink();
		
		cartPage.clickContinueLink();
	}
	
	
	
}
