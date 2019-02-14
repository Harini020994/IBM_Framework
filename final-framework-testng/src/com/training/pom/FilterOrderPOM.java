package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterOrderPOM { 
	private WebDriver driver; 
	private Actions action; 
	
	public FilterOrderPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	} 
	
	@FindBy(id="input-username")
	private WebElement userName;  
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="(//li[@id='menu-sale']//child::a[@class='parent'])[1]")
	private WebElement sales;
	
	@FindBy(xpath="(//a[contains(text(),'Orders')])[1]")
	private WebElement orders;
	
	@FindBy(xpath="//input[@id='input-order-id']")
	private WebElement orderId;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filterBtn;
	
	@FindBy(xpath="//input[@id='input-customer']")
	private WebElement customer;
	
	@FindBy(xpath="(//tbody//td[@class='text-center']//following::td)[1]")
	private WebElement returnId;
	
	@FindBy(xpath="(//tbody//td[@class='text-center']//following::td)[2]")
	private WebElement returnCustomer;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public void moveToSales()
	{
		action=new Actions(driver);
		action.moveToElement(this.sales).build().perform();
	}
	public void clickOrders() {
		this.orders.click(); 
	}
	public String verifyOrderDetailsWithId(String orderId) {
		this.orderId.clear();
		this.orderId.sendKeys(orderId);
		this.filterBtn.click();	
		
		String Actual=this.returnId.getText();
		
		return Actual;
	}
	
	public void verifyOrderDetails(String orderId) {
		this.orderId.clear();
		this.orderId.sendKeys(orderId);
		this.filterBtn.click();	
		
		
	}
		
		public String verifyOrderDetailsWithCustomer(String customer){
			this.orderId.clear();
			this.customer.clear();
			this.customer.sendKeys(customer);
			this.filterBtn.click();
			
			String Actual=this.returnCustomer.getText();
			 
				return Actual;
			
		}
	
}
