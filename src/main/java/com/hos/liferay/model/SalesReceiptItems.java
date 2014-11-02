package com.hos.liferay.model;

import java.math.BigDecimal;

public class SalesReceiptItems {
	private int quantity;
	private String itemDescription;
	private BigDecimal itemCost;
	private BigDecimal salesTax;
	
	public SalesReceiptItems(int quantity, String itemDescription, double itemCost, double salesTax) {
		this.quantity = quantity;
		this.itemDescription = itemDescription;
		this.itemCost = new BigDecimal(Double.toString(itemCost)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		this.salesTax = new BigDecimal(Double.toString(salesTax)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public BigDecimal getItemCost() {
		return itemCost;
	}

	public void setItemCost(BigDecimal itemCost) {
		this.itemCost = itemCost;
	}

	public BigDecimal getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(BigDecimal salesTax) {
		this.salesTax = salesTax;
	}
	
	
}
