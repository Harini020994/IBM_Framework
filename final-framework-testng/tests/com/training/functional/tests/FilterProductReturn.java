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
import com.training.pom.DeleteOrderPOM;
import com.training.pom.FilterOrderPOM;
import com.training.pom.FilterProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterProductReturn { 
  
	private WebDriver driver;
	private String baseUrl;
	private FilterOrderPOM filterPOM;
	private FilterProductPOM filterProductPOM;
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
		
		filterProductPOM=new FilterProductPOM(driver);
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
	public void filterProductTest() throws InterruptedException {
		filterProductPOM.sendUserName("admin");
		filterProductPOM.sendPassword("admin@123");
		filterProductPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First_18");
		filterProductPOM.moveToSales(); 
		filterProductPOM.clickReturns(); 
		screenShot.captureScreenShot("Second_18");
		
		

				
		
	}
	@Test(priority=1)
	public void filterProductById(){
		
		String actual=filterProductPOM.verifyReturnDetailsWithId("80");
		screenShot.captureScreenShot("Three_18");
		System.out.println(actual);
		String expected="80";
		assertEquals(expected,actual);
		
	}
	@Test(priority=2)
	public void filterProductByCustomer()
	{
		String actual1=filterProductPOM.verifyReturnDetailsWithCustomer("sowmya souju");
		screenShot.captureScreenShot("Four_18");
		String expected1="sowmya souju";
		assertEquals(actual1,expected1);
	}
}