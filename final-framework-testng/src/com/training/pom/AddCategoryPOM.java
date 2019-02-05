package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPOM { 
	private WebDriver driver; 
	private Actions action; 
	
	public AddCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	} 
	
	@FindBy(xpath="(//a[@class='parent'])[2]")
	private WebElement catalog;
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement categories;
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addNewBtn;
	
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement category;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement categorydesc;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement metaTag;
	
	@FindBy(xpath="//textarea[@id='input-meta-description1']")
	private WebElement metaTagDesc;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement alertmsg;
	
	@FindBy(xpath="(//a[contains(text(),'Products')])[1]")
	private WebElement products;
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addNewPrdBtn;
	
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement prdName;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement metaTagPrd;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement links;
	
	@FindBy(xpath="//input[@id='input-category']")
	private WebElement inputCategory;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveBtnPrd;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement dataLink;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement model;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement sucessmsg;
	

	
	private JavascriptExecutor js;
	public void moveToCatalog() {
		action=new Actions(driver);
		action.moveToElement(this.catalog).build().perform();
	}
	public void clickCategories() {
		this.categories.click();
	}
	public String addNewCategory(String category,String categorydesc) {
		this.addNewBtn.click();
		this.category.clear();
		this.category.sendKeys(category);
		this.categorydesc.sendKeys(categorydesc);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", metaTag);
		this.metaTag.click();
		this.metaTag.sendKeys(category);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", metaTagDesc);
		this.metaTagDesc.click();
		this.metaTagDesc.sendKeys(categorydesc);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", saveBtn);
		this.saveBtn.click();
		String actual=this.alertmsg.getText();
		return actual;
	}
	public String addNewProduct(String productName,String metaTagName,String category) throws InterruptedException {
		this.products.click();
		this.addNewPrdBtn.click();
		this.prdName.click();
		this.prdName.sendKeys(productName);
		this.metaTagPrd.sendKeys(metaTagName);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", links);
		this.links.click();
		Thread.sleep(5000);
		this.inputCategory.click();
		this.inputCategory.sendKeys(category);
		List<WebElement> options = inputCategory.findElements(By.tagName("li"));
		for (WebElement option : options) {
		    if(category.equals(option.getText()))
		        option.click();   
		}
		this.dataLink.click();
		this.model.click();
		this.model.sendKeys("12");
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", saveBtnPrd);
		this.saveBtnPrd.click();
		String actual=sucessmsg.getText();
		return actual;
		
		
	}

	
	
	
}
