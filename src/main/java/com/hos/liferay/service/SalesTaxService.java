package com.hos.liferay.service;

import java.math.BigDecimal;

import com.hos.liferay.model.CustomerItems;

public class SalesTaxService {
	private int DECIMAL_PLACES = 2;
	private int NEAREST_VALUE = 5;
	
	public double calculateTaxAmount(CustomerItems custItem) {
		double results = 0;
		double itemTotal = 0;
		double taxRate = 0;
		double computedTax = 0;
		
		itemTotal = custItem.getQuantity() * custItem.getCost();
		if(itemTotal > 0) {
			if(custItem.isTaxable()) {
				taxRate += 10;
			}
			if(custItem.isImported()) {
				taxRate += 5;
			}
			computedTax = (itemTotal * taxRate) / 100;
		}
		results = roundUpTax(computedTax);
		return results;
	}
	
	public double calculateItemTotal(CustomerItems custItem, double taxAmount) {
		double results = 0;
		double itemTotal = 0;
		
		itemTotal = custItem.getQuantity() * custItem.getCost();
		results = itemTotal + taxAmount;
		return results;
	}
	
	private double roundUpTax(double value) {
		BigDecimal bigDecimalTemp = new BigDecimal(Double.toString(value));
		double scaledNumber = bigDecimalTemp.setScale(DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).doubleValue() * 100;
		double resolution = scaledNumber % NEAREST_VALUE;
		if(resolution !=0) {
			scaledNumber += NEAREST_VALUE - resolution;
		}
		return scaledNumber / 100;
	}
}
