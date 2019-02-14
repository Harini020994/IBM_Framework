package com.training.bean;

public class ChangeOrderBean {
	private String orderId;
	private String productName;
	private String quantity; 

	
	public ChangeOrderBean(String orderId, String productName,String quantity) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.quantity=quantity;
	}

	

	public ChangeOrderBean() {
		// TODO Auto-generated constructor stub
	}



	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ChangeOrderBean [orderId=" + orderId + ", password=" + productName + "]";
	}

}
