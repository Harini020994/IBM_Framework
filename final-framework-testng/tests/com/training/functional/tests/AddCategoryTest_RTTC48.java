package com.training.functional.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCategoryPOM;
import com.training.pom.FilterOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCategoryTest_RTTC48 {  
 
	private WebDriver driver;
	private String baseUrl;
	private FilterOrderPOM filterPOM;
	private AddCategoryPOM addcategory;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest 
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	} 

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		filterPOM = new FilterOrderPOM(driver);
		addcategory=new AddCategoryPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	
	@Test(priority=0)
	public void LoginTest() {
		filterPOM.sendUserName("admin");
		filterPOM.sendPassword("admin@123");
		filterPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First_16");
			
		
		
	}
	
	@Test(priority=1)
	public void categoryAddition() {
		addcategory.moveToCatalog();
		addcategory.clickCategories();
		String actual=addcategory.addNewCategory("Ornaments1","Ornaments for ladies");
		String expected="Success: You have modified categories!";
				boolean st=actual.contains(expected);
				assertTrue(st);
		
	}
	
	@Test(priority=2)
	public void addProduct() throws InterruptedException{
		addcategory.moveToCatalog();
		String actual=addcategory.addNewProduct("finger ring2","finger ring2","ornaments");
		String expected="Success: You have modified products!";
		boolean st=actual.contains(expected);
		assertTrue(st);
		
		
	}
	
	
}
