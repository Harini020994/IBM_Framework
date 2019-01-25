package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FilterCustomerPOM extends FilterOrderPOM {

	public FilterCustomerPOM(WebDriver driver) {
		super(driver);
		
	} 
	private WebDriver driver; 
	private Actions action;
	@FindBy(xpath="//li[@id='menu-customer']//a[@class='parent']")
	private WebElement customers;
	
	@FindBy(xpath="(//a[contains(text(),'Customers')])[2]")
	private WebElement customers2;
	
	@FindBy(xpath="//input[@id='input-name']")
	private WebElement customerName;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filterBtn;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement customerMail;
	
	@FindBy(xpath="(//tbody//td[@class='text-left'])[1]")
	private WebElement returnName;
	
	@FindBy(xpath="(//tbody//td[@class='text-left'])[2]")
	private WebElement returnMail;
	
	public void moveToCustomers(WebDriver driver) {
		action=new Actions(driver);
		action.moveToElement(this.customers).build().perform();
	}
	public void clickCustomers() {
		this.customers2.click();
		
	}
	
	
	public String verifyCustomerDetailsWithName(String customerName) {
		this.customerName.clear();
		this.customerName.sendKeys(customerName);
		this.filterBtn.click();			
		String Expected=customerName;
		System.out.println(Expected);
		String actual=this.returnName.getText();
		System.out.println(actual);
		
		return actual;
	}
		
		public String verifyCustomerDetailsWithMail(String customerMail){
			this.customerName.clear();
			this.customerMail.clear();
			this.customerMail.sendKeys(customerMail);
			this.filterBtn.click();
			String Actual=this.returnMail.getText();
			
				return Actual;
			
		}

	
}
