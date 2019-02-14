package com.training.functional.tests;

/*
 * Author:Harini Kantheti
 * Application:Retail
 * Tc:RTTC_078
 * Pre-requisite:user should have launched the application & placed the order
 * TestCase Description:To verify whether application allows admin
 *  to create multiple category & add product on the created category
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
import com.training.dataproviders.CategoryCreateDataProvider;
import com.training.dataproviders.ChangeOrderDataProvider;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.CategortCreatePOM;
import com.training.pom.ChangeOrderPOM;
import com.training.pom.DeleteOrderPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CategoryCreateTest_RTTC078 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private DeleteOrderPOM deletePOM;
	private ChangeOrderPOM changePOM;
	private CategortCreatePOM categoryPOM;
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
		categoryPOM=new CategortCreatePOM(driver);
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
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("DashBoard_RTTC_078");

	}


	@Test(dataProvider= "excel-inputs",dataProviderClass = CategoryCreateDataProvider.class,priority=1)	
	
	public void CategoryCreateTest(String categoryName,String description,String metaTag,String metaTagdesc,String prodname,String metaTagNm,String cateName) throws InterruptedException {
	//ADD Category
		categoryPOM.moveToCatalog(driver);
	String actual=categoryPOM.addCategory(categoryName, description, metaTag, metaTagdesc);
	String expected="Success: You have modified categories!";
	boolean st=actual.contains(expected);
	assertTrue(st);
	//ADD Product
	categoryPOM.moveToCatalog(driver);
	String actual1=categoryPOM.addProduct(prodname, metaTagNm, cateName);
	String expected1="Success: You have modified products!";
	boolean st1=actual1.contains(expected1);
	assertTrue(st1);
		
	}
	
	
	
	
	
}