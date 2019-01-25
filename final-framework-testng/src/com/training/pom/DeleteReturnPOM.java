package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteReturnPOM extends FilterProductPOM{
	public DeleteReturnPOM(WebDriver driver) {
		super(driver);
		
	}


	private WebDriver driver; 
	private Actions action; 
	
	public void selectReturn(WebDriver driver) {
		driver.findElement(By.xpath("(//tbody//td[@class='text-center'])[1]//input[1]")).click();
		
	}      
	public String deleteReturn(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//div[@class='pull-right']//button[@type='button']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Element.click();
		Alert a=driver.switchTo().alert();
		Thread.sleep(5000);
		a.accept();
		String actual=(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());
		//String expected="Success: You have modified returns!\r\n" + "×";
		
			return actual;
		
		
		
	}

	
	
	
	
	
	

}
