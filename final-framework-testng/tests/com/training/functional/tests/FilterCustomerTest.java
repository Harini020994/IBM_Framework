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
import com.training.pom.FilterCustomerPOM;
import com.training.pom.FilterOrderPOM;
import com.training.pom.FilterProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterCustomerTest {

	private WebDriver driver;
	private String baseUrl;
	private FilterOrderPOM filterPOM;
	private FilterCustomerPOM filterCustomerPOM;
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
		
		filterCustomerPOM=new FilterCustomerPOM(driver);
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
	public void filterCustomerTest() throws InterruptedException {
		filterCustomerPOM.sendUserName("admin");
		filterCustomerPOM.sendPassword("admin@123");
		filterCustomerPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		filterCustomerPOM.moveToCustomers(driver); 
		filterCustomerPOM.clickCustomers(); 
		screenShot.captureScreenShot("Second");
		Thread.sleep(5000);
		
		
				
		
	}
	@Test(priority=1)
	public void filterCustomerByName()
	{
		String actual=filterCustomerPOM.verifyCustomerDetailsWithName("manzoor mehadi");
		String expected="manzoor mehadi";
		assertEquals(expected,actual);
	}
	@Test(priority=2)
	public void filterCustomerByMail()
	{
		String actual1=filterCustomerPOM.verifyCustomerDetailsWithMail("manzoor@gmail.com");
		String expected1="manzoor@gmail.com";
		assertEquals(actual1,expected1);
	}
}