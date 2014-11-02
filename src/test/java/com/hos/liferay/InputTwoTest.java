package com.hos.liferay;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.hos.liferay.model.CustomerItems;
import com.hos.liferay.persistence.StoreProductServiceImpl;
import com.hos.liferay.service.SalesReceiptService;

public class InputTwoTest {
	private int INPUT_NUMBER = 2;
	
	@Test
	public void testInputItemcount() throws Exception {
		List<CustomerItems> custItems = null;
		StoreProductServiceImpl storeProductService = new StoreProductServiceImpl();
		custItems = storeProductService.fetchAllStoreItems(INPUT_NUMBER);
		assertEquals(custItems.size(), 2);
	}
	
	@Test
	public void testInput2ItemTotal() throws Exception {
		List<CustomerItems> custItems = null;
		StoreProductServiceImpl storeProductService = new StoreProductServiceImpl();
		custItems = storeProductService.fetchAllStoreItems(INPUT_NUMBER);
		SalesReceiptService receiptSvc = new SalesReceiptService(custItems);
		BigDecimal total = receiptSvc.getReceiptTotal();
		BigDecimal expectedTotal = new BigDecimal("65.15");
		assertTrue(total.equals(expectedTotal));
	}
	
	@Test
	public void testInput2ItemTaxTotal() throws Exception {
		List<CustomerItems> custItems = null;
		StoreProductServiceImpl storeProductService = new StoreProductServiceImpl();
		custItems = storeProductService.fetchAllStoreItems(INPUT_NUMBER);
		SalesReceiptService receiptSvc = new SalesReceiptService(custItems);
		BigDecimal total = receiptSvc.getTaxTotal();
		BigDecimal expectedTotal = new BigDecimal("7.65");
		assertTrue(total.equals(expectedTotal));
	}
}
