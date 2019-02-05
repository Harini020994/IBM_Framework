package com.training.functional.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.FilterOrderPOM;
import com.training.pom.FilterOrderPOM_RTTC047;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterOrderTest_RTTC047 {  
 
	private WebDriver driver;
	private String baseUrl;
	private FilterOrderPOM filterPOM;
	private FilterOrderPOM_RTTC047 filterOrderPOM;
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
		 filterOrderPOM= new FilterOrderPOM_RTTC047(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest
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
	public void movetoSales(){
		filterPOM.moveToSales(); 
		filterPOM.clickOrders(); 
		screenShot.captureScreenShot("Second_!6");
		
		
		
	}
	@Test(priority=2)
	public void validOrderTestWithId() {
		String actual=filterPOM.verifyOrderDetailsWithId("86");
		screenShot.captureScreenShot("Three_16");
		String expected="86";
		assertEquals(actual,expected);
		
	}
	@Test(priority=3)
	public void validOrdertestwithname(){
		String actual1=filterPOM.verifyOrderDetailsWithCustomer("Harini k");
		screenShot.captureScreenShot("Four_16");
		String expected1="Harini k";
		assertEquals(actual1,expected1);
		
		
		
	}	
	@Test(priority=4)
	public void validOrdertestbyStatus() {	
		String actual1=filterOrderPOM.verifyOrderDetailsWithStatus("Pending");
		screenShot.captureScreenShot("Four_16");
		String expected1="Pending";
		assertEquals(actual1,expected1);
		
	}
	@Test(priority=5)
	public void validOrdertestbyDtAd() {	
		String actual1=filterOrderPOM.verifyOrderDetailsWithDtAd("2019-01-28");
		screenShot.captureScreenShot("Four_16");
		String expected1="28/01/2019";
		assertEquals(actual1,expected1);
		
	}
	@Test(priority=6)
	public void validOrdertestbyDtMd() {	
		String actual1=filterOrderPOM.verifyOrderDetailsWithDtMd("2019-01-28");
		screenShot.captureScreenShot("Four_16");
		String expected1="28/01/2019";
		assertEquals(actual1,expected1);
		
	} 
	
	@Test(priority=7)
	public void validOrderTestbyTotal() {
		assertTrue(false);
	}
}
