package com.training.pom;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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

public class PlaceOrderPOM extends FilterOrderPOM{
	 private WebDriver driver;
	 private JavascriptExecutor js;
	 private Actions action;
	 private FilterOrderPOM filterPOM;
	
		
	 
	public PlaceOrderPOM(WebDriver driver) {
		super(driver); 
		  
	} 
	
	

	@FindBy(xpath="//span[contains(text(),'Shop Now')]")
	private WebElement shopNow;
	
	@FindBy(xpath="//span[contains(text(),'Ethnic')]")
	private WebElement ethnic;
	
	@FindBy(xpath="//div[@class='mfilter-option mfilter-search']//input[@type='text']")
	private WebElement prodSearch;
	
	@FindBy(xpath="//img[contains(@class,'lazyloaded')]")
	private WebElement productImg;
	
	@FindBy(xpath="//span[contains(text(),'Quickview')]")
	private WebElement quickView;
	
	@FindBy(xpath="(//input[@class='form-control'])[1]")
	private WebElement quantity;
	
	@FindBy(xpath="//i[@class='fa fa-caret-up']")
	private WebElement icquan;
	
	@FindBy(xpath="//button[contains(text(),'Add to Cart')]")
	private WebElement addToCart;
	
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement shoppingCart;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement checkOut;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement userMail;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement login;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement billingContinue;
	
	@FindBy(xpath="//input[@id='button-shipping-address']")
	private WebElement deliveryContinue;
	
	@FindBy(xpath="//input[@id='button-shipping-method']")
	private WebElement shippingContinue;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreeCheck;
	
	@FindBy(xpath="//input[@id='button-payment-method']")
	private WebElement paymentContinue;
	
	@FindBy(xpath="//input[@id='button-confirm']")
	private WebElement confirmOrder;
	
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement loginIcon;
	
	
	@FindBy(xpath="//span[contains(text(),'MY ORDERS')]")
	private WebElement orderHistory;
	
	@FindBy(xpath="(//td[@class='text-left'])[5]")
	private WebElement status;
		
	
	
	public void moveToshopNow(WebDriver driver,String product) throws InterruptedException {
			action=new Actions(driver);
		action.moveToElement(this.shopNow).click().perform();
		this.ethnic.click();
		//this.prodSearch.sendKeys(product);
		this.productImg.click();		
	     ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(newTab.get(1));
	      this.icquan.click();
		   this.addToCart.click();
		  this.shoppingCart.click();
		  js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", checkOut);
		   this.checkOut.click();
		   
		    

	}
	public void goToLoginPage() {
		
		this.loginIcon.click();
		
		
		
	}
	public String userCheckStatus(WebDriver driver) {
		action=new Actions(driver);
		action.moveToElement(this.loginIcon).build().perform();
		this.orderHistory.click();
		String updatedstatus=this.status.getText();
		return updatedstatus;
	}
	public void accountLogin(String Email,String password) {
		this.userMail.sendKeys(Email);
		this.password.sendKeys(password);
		this.login.click();
	}
	
	public void paymentProcess() throws InterruptedException {
		Thread.sleep(3000);
		this.billingContinue.click();
		this.deliveryContinue.click();
		this.shippingContinue.click();
		this.agreeCheck.click();
		this.paymentContinue.click();
		this.confirmOrder.click();
	}
	

}