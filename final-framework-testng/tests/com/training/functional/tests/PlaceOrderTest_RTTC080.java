package com.training.functional.tests;


/*
 * Author:Harini Kantheti
 * Application:Retail
 * Tc:RTTC_080
 * Pre-requisite:user should launch the application by entering valid URL
 * TestCase Description:To verify whether application allows to place an order
 * 	 by logging in while checking out & admin to change the status to complete
 * 
 */

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
import com.training.pom.ChangeOrderPOM;
import com.training.pom.FilterOrderPOM;
import com.training.pom.PlaceOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PlaceOrderTest_RTTC080 {  
 
	private WebDriver driver;
	private String baseUrl;
	private String userUrl;
	private FilterOrderPOM filterPOM;
	private AddCategoryPOM addcategory;
	private PlaceOrderPOM placeOrderPOM;
	private ChangeOrderPOM changeOrderPOM;
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
		placeOrderPOM=new PlaceOrderPOM(driver);
		 changeOrderPOM=new ChangeOrderPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		userUrl=properties.getProperty("userURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(userUrl);
	}
	
@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	
	@Test(priority=0)
	public void placeOrder() throws InterruptedException {
		
			placeOrderPOM.moveToshopNow(driver,"Integer Vitae Iaculis Massa");
			placeOrderPOM.accountLogin("harinikantheti94@gmail.com", "alliswell");
			placeOrderPOM.paymentProcess();
		
	}
	@Test(priority=1)
	public void LoginTest() {
		driver.get(baseUrl);
		filterPOM.sendUserName("admin");
		filterPOM.sendPassword("admin@123");
		filterPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First_16");
			
	}
	
	@Test(priority=2,dependsOnMethods= {"placeOrder","LoginTest"})
	public void editOrderStatus() {
		filterPOM.moveToSales(); 
		filterPOM.clickOrders();
		filterPOM.verifyOrderDetails("115");
		changeOrderPOM.editOrderStatus(driver, "Complete");
		
	}
	
	@Test(priority=3)
	public void checkOrderStatus() {
		driver.get(userUrl);
		placeOrderPOM.goToLoginPage();
		placeOrderPOM.accountLogin("harinikantheti94@gmail.com", "alliswell");
		String updatedStatus=placeOrderPOM.userCheckStatus(driver);
		assertEquals(updatedStatus,"Complete");
		
		
	}
		
}
