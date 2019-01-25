package com.training.functional.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DeleteReturnPOM;
import com.training.pom.FilterOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteReturnTest { 

	private WebDriver driver;
	private String baseUrl;
	private FilterOrderPOM filterPOM;
	private DeleteReturnPOM deletePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		deletePOM=new DeleteReturnPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void deleteReturnTest() throws InterruptedException {
		deletePOM.sendUserName("admin");
		deletePOM.sendPassword("admin@123");
		deletePOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		deletePOM.moveToSales(); 
		deletePOM.clickReturns(); 
		screenShot.captureScreenShot("Second");
		deletePOM.selectReturn(driver);
		Thread.sleep(5000);
		String actual=deletePOM.deleteReturn(driver);
		String expected="Success: You have modified returns!";
		boolean st=actual.contains(expected);
		assertTrue(st);
		//assertEquals(expected,actual);
		
		
	}
}