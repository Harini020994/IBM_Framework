package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.ChangeOrderBean;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dao.RetailDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class ChangeOrderDataProvider {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<ChangeOrderBean> list = new RetailDAO().getProducts(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(ChangeOrderBean temp : list){
			Object[]  obj = new Object[3]; 
			obj[0] = temp.getOrderId(); 
			obj[1] = temp.getProductName(); 
			obj[2]=temp.getQuantity();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\selenium\\Test_Data.xlsx"; 
		String sheetName="RTTC_077";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
