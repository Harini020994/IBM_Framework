package com.training.functional.tests;

import static org.testng.Assert.assertEquals;

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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterOrder {  
 
	private WebDriver driver;
	private String baseUrl;
	private FilterOrderPOM filterPOM;
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
	
	@Test(priority=1)
	public void validOrderTestWithId() {
		String actual=filterPOM.verifyOrderDetailsWithId("171");
		screenShot.captureScreenShot("Three_16");
		String expected="171";
		assertEquals(actual,expected);
		
	}
	
	
	
	@Test(priority=0)
	public void validOrderTest() {
		filterPOM.sendUserName("admin");
		filterPOM.sendPassword("admin@123");
		filterPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First_16");
		filterPOM.moveToSales(); 
		filterPOM.clickOrders(); 
		screenShot.captureScreenShot("Second_!6");
		
		
		
	}
	
	@Test(priority=2)
	public void validOrdertestwithname(){
		String actual1=filterPOM.verifyOrderDetailsWithCustomer("manzoor mehadi");
		screenShot.captureScreenShot("Four_16");
		String expected1="manzoor mehadi";
		assertEquals(actual1,expected1);
		
		
		
	}
}
