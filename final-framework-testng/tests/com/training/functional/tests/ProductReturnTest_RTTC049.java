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
import com.training.pom.FilterOrderPOM;
import com.training.pom.ProductReturnPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ProductReturnTest_RTTC049 {  
 
	private WebDriver driver;
	private String baseUrl;
	private FilterOrderPOM filterPOM;
	private ProductReturnPOM returnPOM;
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
		returnPOM=new ProductReturnPOM(driver);
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
	public void validOrderTest() {
		filterPOM.sendUserName("admin");
		filterPOM.sendPassword("admin@123");
		filterPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First_16");
				
		
	}
	
	@Test(priority=1)
	public void addProductReturn(){
		filterPOM.moveToSales(); 
		returnPOM.goToReturns();
		String actual=returnPOM.addReturnProduct("86", "Harini k", "Harini", "k", "harinikantheti94@gmail.com", "8985670051", "Integer vitae iaculis massa", "SKU-003");
		String expected="Success: You have modified returns!";
		System.out.println(actual);
		boolean st=actual.contains(expected);
		assertTrue(st);
		

	}
	
	@Test(priority=2)
	public void deleteReturn() throws InterruptedException {
		String actual=returnPOM.deleteReturn();
		String expected="Success: You have modified returns!";
		System.out.println(actual);
		boolean st=actual.contains(expected);
		assertTrue(st);
		
	}
}
