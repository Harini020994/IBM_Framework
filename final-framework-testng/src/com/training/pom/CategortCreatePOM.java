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

public class CategortCreatePOM extends FilterOrderPOM{
	 private WebDriver driver;
	 private JavascriptExecutor js;
	 private Actions action;
	 private FilterOrderPOM filterPOM;
	
		
	 
	public CategortCreatePOM(WebDriver driver) {
		super(driver); 
		  
	} 
	
	
	/*@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement catalog;*/
	
	@FindBy(xpath="(//a[@class='parent'])[2]")
	private WebElement catalog;
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement categories;
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addBtn;
	
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement categoryName;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement description;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement metaTag;
	
	@FindBy(xpath="//textarea[@id='input-meta-description1']")
	private WebElement metaTagdesc;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveBtn;
	
	@FindBy(xpath="(//a[contains(text(),'Products')])[1]")
	private WebElement products;
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addPrd;
	
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement prodName;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement metatTagTitle;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement links;
	
	
	
	@FindBy(xpath="//input[@id='input-category']")
	private WebElement cateName;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']//child::li")
	private WebElement cateSelect;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement save;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement sucessMsg;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement sucessMsgProd;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement errMsgCat;
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement errMsgProd;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement model;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement data;
	
	
	
	public void moveToCatalog(WebDriver driver) {
			action=new Actions(driver);
		action.moveToElement(this.catalog).build().perform();
		
	}
	
	public String addCategory(String categoryName,String description,String metaTag,String metaTagdesc) {
		this.categories.click();
		this.addBtn.click();
		this.categoryName.sendKeys(categoryName);
		this.description.sendKeys(description);
		this.metaTag.sendKeys(metaTag);
		this.metaTagdesc.sendKeys(metaTagdesc);
		this.saveBtn.click();
		String actual=this.sucessMsg.getText();
		return actual; 
		
	}
	
	public String addCategory_negative(String categoryName,String description,String metaTag,String metaTagdesc) {
		this.categories.click();
		this.addBtn.click();
		this.categoryName.sendKeys(categoryName);
		this.description.sendKeys(description);
		this.metaTag.sendKeys(metaTag);
		this.metaTagdesc.sendKeys(metaTagdesc);
		this.saveBtn.click();
		String actual=this.errMsgCat.getText();
		return actual; 
		
	}
	
	public String addProduct(String prodname,String metaTag,String cateName) {
		this.products.click();
		this.addPrd.click();
		this.prodName.sendKeys(prodname);
		this.metatTagTitle.sendKeys(metaTag);
		this.data.click();
		this.model.sendKeys("12");
		this.links.click();
		this.cateName.sendKeys(cateName);
		this.cateSelect.click();
		this.save.click();
		String actual=this.sucessMsgProd.getText();
		return actual;
	}
	
	
	public String addProduct_negative(String prodname,String metaTag,String cateName) {
		this.products.click();
		this.addPrd.click();
		this.prodName.sendKeys(prodname);
		this.metatTagTitle.sendKeys(metaTag);
		this.data.click();
		this.model.sendKeys("12");
		this.links.click();
		this.cateName.sendKeys(cateName);
		this.cateSelect.click();
		this.save.click();
		String actual=this.errMsgProd.getText();
		return actual;
	}
	

	
	
		
	
	
	
	
	
	

}