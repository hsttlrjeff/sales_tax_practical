package com.hos.liferay.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.hos.liferay.model.CustomerItems;
import com.hos.liferay.model.SalesReceiptItems;

public class SalesReceiptService {
	private List<CustomerItems> masterItemList;
	private List<SalesReceiptItems> receiptItemList;
	private double receiptSalesTaxTotal = 0;
	private double receiptTotal = 0;
	
	public SalesReceiptService(List<CustomerItems> custItems) {
		this.masterItemList = custItems;
		this.receiptItemList = new ArrayList<SalesReceiptItems>();
		calculateValues();
	}
	
	private void calculateValues() {
		SalesTaxService taxService = new SalesTaxService();
		for(CustomerItems custItem : masterItemList) {
			int quantity = custItem.getQuantity();
			String description = custItem.getItemDescription();
			double taxForItem = taxService.calculateTaxAmount(custItem);
			double itemTotalWithTax = taxService.calculateItemTotal(custItem, taxForItem);
			
			receiptSalesTaxTotal += taxForItem;
			receiptTotal += itemTotalWithTax;
			
			receiptItemList.add(new SalesReceiptItems(quantity, description, itemTotalWithTax, taxForItem));
		}
	}
	
	public BigDecimal getReceiptTotal() {
		BigDecimal total = new BigDecimal(Double.toString(receiptTotal)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return total;
	}
	
	public BigDecimal getTaxTotal() {
		BigDecimal total = new BigDecimal(Double.toString(receiptSalesTaxTotal)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return total;
	}
	
	public void createOutput(int outputCount) {
		System.out.println("Output " + outputCount + ":");
		for(SalesReceiptItems item : receiptItemList) {
			System.out.println(item.getQuantity() + " " + item.getItemDescription() + ": " + item.getItemCost());
		}
		System.out.println("Sales Taxes: " + getTaxTotal());
		System.out.println("Total: " + getReceiptTotal());
		System.out.println();
	}
}
