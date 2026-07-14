package com.pages.Products;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actions.Action;
import com.base.BaseClass;

public class ProductPage extends BaseClass {
	
	Action actions;
	
	@FindBy(xpath = "//a[@href='/products']")
	WebElement clickProducts;
	
	@FindBy(xpath = "//a[@href='/product_details/1']")
	WebElement clickOn1stProduct;
	
	@FindBy(xpath = "//input[@id='search_product']")
	WebElement searchProduct;
	
	@FindBy(xpath = "//button[@id='submit_search']")
	WebElement searchBtn;
	
	@FindBy(xpath = "//a[@data-toggle='collapse' and @href='#Women']")
	List<WebElement> categoryWomen;
	
	@FindBy(xpath = "//a[@data-toggle='collapse' and @href='#Men']")
	List<WebElement> categoryMen;
	
	@FindBy(xpath = "//a[@data-toggle='collapse' and @href='#Kids']")
	List<WebElement> categoryKids;
	
	
	public ProductPage() 
	{
		PageFactory.initElements(driver, this);
		actions = new Action();
	}
	
	public void clickProducts()
	{
		actions.click(driver, clickProducts);
	}
	
	public void clickOn1stProduct() 
	{
		actions.click(driver, clickOn1stProduct);
	}
	
	public void searchProductByName(String PName) 
	{
		searchProduct.click();
		searchProduct.clear();
		searchProduct.sendKeys(PName);
		
		actions.click(driver, searchBtn);
	}
	
	public void searchNonExistingProduct(String NExistingProduct)
	{
		searchProduct.click();
		searchProduct.clear();
		searchProduct.sendKeys(NExistingProduct);
		
		actions.click(driver, searchBtn);
	}
	
	public void clickCategoryName() 
	{
		actions.clickVisibleElement(driver, categoryWomen, "Women");
		
		actions.clickVisibleElement(driver, categoryMen, "Men");
		
		actions.clickVisibleElement(driver, categoryKids, "Kids");
	}
	
	
	

}
