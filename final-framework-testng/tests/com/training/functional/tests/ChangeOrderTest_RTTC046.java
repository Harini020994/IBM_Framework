package com.training.functional.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangeOrderPOM;
import com.training.pom.DeleteOrderPOM;
import com.training.pom.FilterOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ChangeOrderTest_RTTC046 { 
 
	private WebDriver driver; 
	private String baseUrl;
	private FilterOrderPOM filterPOM;
	private DeleteOrderPOM deletePOM; 
	private ChangeOrderPOM changePOM;
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
		deletePOM=new DeleteOrderPOM(driver);
		changePOM=new ChangeOrderPOM(driver);
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
	public void login() {
		deletePOM.sendUserName("admin");
		deletePOM.sendPassword("admin@123");
		deletePOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First_17");
		
	}
	@Test(priority=1)
	public void changeOrderTest() throws InterruptedException {
	
		deletePOM.moveToSales(); 
		deletePOM.clickOrders(); 
		screenShot.captureScreenShot("Second_17");
		changePOM.filterOrder("87");
		changePOM.editOrder(driver);
		changePOM.addProduct("Integer vitae iaculis massa");
		changePOM.addQuantity("2");
		changePOM.addBtn();
		String actual=changePOM.paymentPage();
		String expected="Success: You have modified orders!";
		boolean st=actual.contains(expected);
		assertTrue(st);
					
	}
	
	
	
}