package com.training.pom;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChangeOrderPOM extends FilterOrderPOM{
	 private WebDriver driver;
	 private JavascriptExecutor js;
	 private Actions action;
	
		
	 
	public ChangeOrderPOM(WebDriver driver) {
		super(driver); 
		  
	} 
	@FindBy(xpath="(//a[@class='btn btn-primary'])[2]")
	private WebElement editBtn;
	
	@FindBy(xpath="//button[@id='button-customer']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//i[@class='fa fa-minus-circle']")
	private WebElement removeBtn;
	
	@FindBy(xpath="//input[@id='input-product']")
	private WebElement choosePrd;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement cartcontinueBtn;
	
	@FindBy(xpath="//button[@id='button-product-add']")
	private WebElement addPrdBtn;
	
	
	
	@FindBy(xpath="//button[@id='button-payment-address']")
	private WebElement paymentcontinueBtn;
	
	@FindBy(xpath="//button[@id='button-shipping-address']")
	private WebElement shippingcontinueBtn;
	
	@FindBy(xpath="//select[@id='input-shipping-method']")
	private WebElement shippingSelect;
	
	@FindBy(xpath="//select[@id='input-payment-method']")
	private WebElement paymentSelect;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	private WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement alertMessage;
	
	@FindBy(xpath="//div[@class='form-group']//input[@value='1']")
	private WebElement quantity;
	
	@FindBy(xpath="//li[@data-value='689']")
	private WebElement elementToSelect;

	
		

	public void editOrder(WebDriver driver) throws InterruptedException{
		this.editBtn.click();
		 js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", continueBtn);
		Thread.sleep(2000);
		this.continueBtn.click();
		this.removeBtn.click();
		
	}
	public void addProduct(String product,String quantity) throws InterruptedException {
		this.choosePrd.clear();
		this.choosePrd.sendKeys(product);
		Thread.sleep(2000);
		this.elementToSelect.click();
		this.quantity.sendKeys(quantity);
		this.addPrdBtn.click();
		
	}
	
	public String paymentPage() throws InterruptedException {
		
		this.cartcontinueBtn.click();
		Thread.sleep(2000);
		this.paymentcontinueBtn.click();
		this.shippingcontinueBtn.click();
		Thread.sleep(3000);
		Select s= new Select(this.shippingSelect);
		s.selectByVisibleText("Free Shipping - Rs.0");
		
		Select s1= new Select(this.paymentSelect);
		s1.selectByVisibleText("Cash On Delivery");
		js.executeScript("arguments[0].scrollIntoView();",saveBtn);
		this.saveBtn.click();
		
		   	js.executeScript("arguments[0].scrollIntoView();", alertMessage);
			String actual=this.alertMessage.getText();
			System.out.println(actual);
			return actual;
			
	}
	
	
		
	
	
	
	
	
	

}
