package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FilterProductPOM extends FilterOrderPOM {

	public FilterProductPOM(WebDriver driver) {
		super(driver);  
		
	} 
	private WebDriver driver; 
	private Actions action;
	@FindBy(xpath="(//a[contains(text(),'Returns')])[2]")
	private WebElement returns;
	
	@FindBy(xpath="//input[@id='input-return-id']")
	private WebElement returnId;
	
	@FindBy(xpath="//i[@class='fa fa-filter']")
	private WebElement filterBtn;
	
	@FindBy(xpath="//input[@id='input-customer']")
	private WebElement customer;
	
	public void clickReturns() {
		this.returns.click(); 
	}
	
	@FindBy(xpath="(//tbody//td[@class='text-right'])[1]")
	private WebElement returnproduct;
	
	@FindBy(xpath="(//tbody//td[@class='text-center']//following::td)[3]")
	private WebElement returnname;
	
	public String verifyReturnDetailsWithId(String returnId) {
		
		
		System.out.println("test");
		this.returnId.clear();
		this.returnId.sendKeys(returnId);
		this.filterBtn.click();			
		String Expected=returnId;
		System.out.println(Expected);
		String actual=this.returnproduct.getText();
			System.out.println(actual);

		return actual;
	}
		
		public String verifyReturnDetailsWithCustomer(String customer){
			this.returnId.clear();
			this.customer.clear();
			this.customer.sendKeys(customer);
			this.filterBtn.click();
			
			String Actual=this.returnname.getText();
			 
				return Actual;
			
		}
	
}
