package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RewardPointsPOM { 
	private WebDriver driver; 
	private Actions action; 
	
	public RewardPointsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	} 
	
	
	@FindBy(xpath="//li[@id='menu-customer']//a[@class='parent']")
	private WebElement customers;
	
	@FindBy(xpath="(//a[contains(text(),'Customers')])[2]")
	private WebElement customers_sub;
	

	@FindBy(xpath="//input[@id='input-email']")
	private WebElement customermail;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filterBtn;
	
	
	
	@FindBy(xpath="//i[@class='fa fa-pencil']")
	private WebElement editBtn;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstname;
	
	@FindBy(xpath="//a[contains(text(),'Address 1')]")
	private WebElement adressTab;
	
	@FindBy(xpath="//input[@placeholder='Postcode']")
	private WebElement postcode;
	
	@FindBy(xpath="//a[@href='#tab-reward']")
	private WebElement rewardsTab;

	@FindBy(xpath="//input[@id='input-reward-description']")
	private WebElement rewardsDesc;
	
	@FindBy(xpath="//input[@id='input-points']")
	private WebElement rewardsPoints;
	
	@FindBy(xpath="//button[contains(text(),'Add Reward Points')]")
	private WebElement addrewardsPoints;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement alertMsg;
	

	
	private JavascriptExecutor js;
	
	
	

	public String editCustomers(String mailId,String newName,String newPostCode,String rewardDesc,String rewardPoints) {
		action=new Actions(driver);
		action.moveToElement(this.customers).build().perform();
		this.customers_sub.click();
		this.customermail.sendKeys(mailId);
		this.filterBtn.click();
		this.editBtn.click();
		this.firstname.clear();
		this.firstname.sendKeys(newName);
		this.adressTab.click();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", postcode);
		this.postcode.sendKeys(newPostCode);
		this.rewardsTab.click();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", rewardsDesc);
		this.rewardsDesc.sendKeys(rewardDesc);
		this.rewardsPoints.sendKeys(rewardPoints);
		this.addrewardsPoints.click();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", saveBtn);
		this.saveBtn.click();
		String actual=this.alertMsg.getText();
		return actual;
		
		
		
	}
	
	
	
}
