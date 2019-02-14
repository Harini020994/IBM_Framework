package com.training.functional.tests;

/*
 * Author:Harini Kantheti
 * Application:Retail
 * Tc:RTTC_076
 * Pre-requisite:user should launch the application by entering valid URL
 * TestCase Description:To verify whether application allows to place an 
 * order by logging in while checking out & admin to change the status to complete
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.ChangeOrderDataProvider;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ChangeOrderPOM;
import com.training.pom.DeleteOrderPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ModifyOrderTest_RTTC_076 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		loginPOM = new LoginPOM(driver);
		deletePOM=new DeleteOrderPOM(driver);
		changePOM=new ChangeOrderPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void loginDBTest() {
		
		//login with admin role
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("DashboardPage_RTTC_076");

	}

	
	

/*	@Test(dataProvider= "db-inputs",dataProviderClass = ChangeOrderDataProvider.class,priority=1)
	
public void changeOrderTest_db(String orderId,String productName,String quantity) throws InterruptedException {
	
		deletePOM.moveToSales(); 
		deletePOM.clickOrders(); 
		screenShot.captureScreenShot("Second_17");
		changePOM.filterOrder(orderId);
		changePOM.editOrder(driver);
		changePOM.addProduct(productName);
		String product=changePOM.getProduct();
		changePOM.addQuantity(quantity);
		String quan=changePOM.getQuantity();
		changePOM.addBtn();
		String actual=changePOM.paymentPage();
		String expected="Success: You have modified orders!";
		boolean st=actual.contains(expected);
		assertTrue(st);
		
		}*/
	
	@Test(dataProvider= "db-inputs",dataProviderClass = ChangeOrderDataProvider.class,priority=1)
	public void changeOrderTest(String orderId,String productName,String quantity) throws InterruptedException {
		//Edit order and add new product
		deletePOM.moveToSales(); 
		deletePOM.clickOrders(); 
		screenShot.captureScreenShot("SearchOrder_RTTC_076");
		changePOM.filterOrder("87");
		screenShot.captureScreenShot("OrderResult_RTTC_076");
		changePOM.editOrder(driver);
		changePOM.addProduct("quis venenatis est ultricies et");
		String product=changePOM.getProduct();
		changePOM.addQuantity("1");
		String quan=changePOM.getQuantity();
		screenShot.captureScreenShot("addNewProduct_RTTC_076");
		changePOM.addBtn();
		//checkout with new product added
		String actual=changePOM.paymentPage();
		screenShot.captureScreenShot("SucessMsg_RTTC_076");
		String expected="Success: You have modified orders!";
		boolean st=actual.contains(expected);
		assertTrue(st);
		assertEquals(product,productName);
		assertEquals(quan,quantity);
					
	}
	
	
	
}