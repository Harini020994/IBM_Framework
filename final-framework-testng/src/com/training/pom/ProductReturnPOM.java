package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductReturnPOM { 
	private WebDriver driver; 
	private Actions action; 
	
	public ProductReturnPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	} 
	
	
	@FindBy(xpath="(//a[contains(text(),'Returns')])[2]")
	private WebElement returns;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addBtn;
	
	@FindBy(xpath="//input[@id='input-order-id']")
	private WebElement orderId;
	
	@FindBy(xpath="//input[@id='input-customer']")
	private WebElement customer;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-product']")
	private WebElement inputProduct;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement model;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successMsg;
	
	@FindBy(xpath="//input[@value='9']")
	private WebElement checkBox;
	
	@FindBy(xpath="//div[@class='pull-right']//button[@type='button']")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement delsucessMsg;
	
	
	private JavascriptExecutor js;
	
		public void goToReturns(){
			this.returns.click();
		}
		public String addReturnProduct(String orderId,String customer,String firstname,String lastName,String email,String telephone,String inputProduct,String model) {
			this.addBtn.click();
			this.orderId.sendKeys(orderId);
			this.customer.sendKeys(customer);
			this.firstName.sendKeys(firstname);
			this.lastName.sendKeys(lastName);
			this.email.sendKeys(email);
			this.telephone.sendKeys(telephone);
			this.inputProduct.sendKeys(inputProduct);
			this.model.sendKeys(model);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", saveBtn);
			this.saveBtn.click();
			String actual=this.successMsg.getText();
			return actual;
			
			
			
		}
	public String deleteReturn() throws InterruptedException {
		this.checkBox.click();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", deleteBtn);
		this.deleteBtn.click();
		Alert a=driver.switchTo().alert();
		Thread.sleep(5000);
		a.accept();
		String actual=this.delsucessMsg.getText();
		return actual;
		
	}
}
