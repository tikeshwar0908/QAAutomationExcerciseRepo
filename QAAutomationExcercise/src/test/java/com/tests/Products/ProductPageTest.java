package com.tests.Products;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Login.LoginPage;
import com.pages.Products.ProductPage;

public class ProductPageTest extends BaseClass {
	
	LoginPage loginPage;
	ProductPage productPage;
	
	public ProductPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		productPage = new ProductPage();
		
		loginPage.clickSignUpLogin();
		
		loginPage.scrollByPixel(200);
		
		loginPage.login(prop.getProperty("emailAddress"), prop.getProperty("password"));
		
		productPage.clickProducts();
		
	}
	
	@Test(priority=1)
	public void verifyAllProductsandClickOn1stProduct()
	{
//		productPage.clickProducts();
		
		productPage.scrollByPixel(1000);
		
		productPage.scrollByPixel(-500);
		
		productPage.clickOn1stProduct();
	}
	
	@Test(priority=2)
	public void searchProductByName()
	{
		productPage.searchProductByName("Blue Top");
		
		productPage.scrollByPixel(500);
	}
	
	@Test(priority=3)
	public void searchNonExistingProduct()
	{
		productPage.searchNonExistingProduct("XYZ123ABC");
		
		productPage.scrollByPixel(400);
	}
	
	@Test(priority=4)
	public void clickOnCategoryName()
	{	
		productPage.clickCategoryName();
	}

}
