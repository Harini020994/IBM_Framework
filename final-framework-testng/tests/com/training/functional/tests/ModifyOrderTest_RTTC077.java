package com.training.functional.tests;

/*
 * Author:Harini Kantheti
 * Application:Retail
 * Tc:RTTC_077
 * Pre-requisite: user should have launched the application & placed the order
 * TestCase Description:To verify whether application allows admin to change multiple order placed by the customer
 * 
 */


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

public class ModifyOrderTest_RTTC077 {
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

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class,priority=0)
	public void loginDBTest(String userName, String password) {
		//login as admin
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("HomePage_RTTC_077");

	}


	@Test(dataProvider= "excel-inputs",dataProviderClass = ChangeOrderDataProvider.class,priority=1)
	
public void changeOrderTest(String orderId,String productName,String quantity) throws InterruptedException {
	
		deletePOM.moveToSales(); 
		deletePOM.clickOrders(); 
		screenShot.captureScreenShot("OrdersPage_RTTC_077");
		changePOM.filterOrder(orderId);
		screenShot.captureScreenShot("OrdersResult_RTTC_077");
		//edit and remove item from order
		changePOM.editOrder(driver);
		//Add new product
		changePOM.addProduct(productName);
		changePOM.addQuantity(quantity);
		screenShot.captureScreenShot("AddProduct_RTTC_077");
		changePOM.addBtn();
		String actual=changePOM.paymentPage();
		screenShot.captureScreenShot("SucessMsg_RTTC_077");
		String expected="Success: You have modified orders!";
		boolean st=actual.contains(expected);
		assertTrue(st);
	}
	
	
	
}