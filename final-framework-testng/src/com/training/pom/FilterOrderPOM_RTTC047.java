package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterOrderPOM_RTTC047 extends FilterOrderPOM { 
	public FilterOrderPOM_RTTC047(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public FilterOrderPOM filterOrder;
	WebDriver driver;
	private JavascriptExecutor js;

	
	
	@FindBy(xpath="//select[@id='input-order-status']")
	private WebElement OrderStatus;
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filterBtn;
	@FindBy(xpath="(//td[@class='text-left'])[6]")
	private WebElement returnStatus;
	@FindBy(xpath="(//button[@class='btn btn-default'])[1]")
	private WebElement dateAdded;
	@FindBy(xpath="//input[@placeholder='Date Added']")
	private WebElement dateToBeAdded;
	@FindBy(xpath="(//td[@class='text-left'])[7]")
	private WebElement dateToBeReturned;
	@FindBy(xpath="(//button[@class='btn btn-default'])[2]")
	private WebElement dateModified;
	@FindBy(xpath="//input[@id='input-date-modified']")
	private WebElement dateToBeModified;
	@FindBy(xpath="(//td[@class='text-left'])[8]")
	private WebElement dateMdToBeReturned;
	@FindBy(xpath="//input[@placeholder='Total']")
	private WebElement inputTotal;
	@FindBy(xpath="(//td[@class='text-right']  )[5]")
	private WebElement returnTotal;
	
	
		public String verifyOrderDetailsWithStatus(String OrderStatus){
			
			Select s= new Select(this.OrderStatus);
			s.selectByVisibleText(OrderStatus);
			this.filterBtn.click();
			String Actual=this.returnStatus.getText();
			return Actual;
		
	}
public String verifyOrderDetailsWithDtAd(String Date){
			
					this.dateToBeAdded.sendKeys(Date);
			this.filterBtn.click();
			String Actual=this.dateToBeReturned.getText();
			return Actual;
		
	}
public String verifyOrderDetailsWithDtMd(String Date){
	
	
	this.dateToBeModified.sendKeys(Date);
	this.filterBtn.click();
	String Actual=this.dateMdToBeReturned.getText();
	return Actual;

}
	
	
}
