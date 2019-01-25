package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteOrderPOM extends FilterOrderPOM{
	public DeleteOrderPOM(WebDriver driver) {
		super(driver); 
		  
	} 
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement message;

	@FindBy(xpath="//button[@id='button-delete']")
	private WebElement deletebtn;
	
	@FindBy(xpath="(//tbody//td[@class='text-center'])[1]//input[1]") 
	private WebElement selectOrder;
	
	private WebDriver driver;  
	private Actions action; 
	private JavascriptExecutor js;
	

	public void selectOrder(WebDriver driver){
		this.selectOrder.click();
	}
	
	public String deleteOrder(WebDriver driver) throws InterruptedException {
		js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", deletebtn);
				deletebtn.click();
		Alert a=driver.switchTo().alert();
		Thread.sleep(5000);
		a.accept();
		String actual=this.message.getText();
		
			return actual;
		
		
		
	}
	
	
	
	
	

}
