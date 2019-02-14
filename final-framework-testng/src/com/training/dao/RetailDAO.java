package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.ChangeOrderBean;
import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class RetailDAO {
	
	Properties properties; 
	
	public RetailDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<ChangeOrderBean> getProducts(){
		String sql = properties.getProperty("get.products"); 
		
		GetConnection gc  = new GetConnection(); 
		List<ChangeOrderBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<ChangeOrderBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				ChangeOrderBean temp = new ChangeOrderBean(); 
				temp.setOrderId(gc.rs1.getString(1));
				temp.setProductName(gc.rs1.getString(2));
				temp.setQuantity(gc.rs1.getString(3));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new RetailDAO().getProducts().forEach(System.out :: println);
	}


	public List<LoginBean> getLogins() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
