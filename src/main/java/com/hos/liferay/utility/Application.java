package com.hos.liferay.utility;

import java.util.List;

import com.hos.liferay.persistence.StoreProductServiceImpl;
import com.hos.liferay.model.CustomerItems;
import com.hos.liferay.service.SalesReceiptService;

public class Application {
	public static void main(String[] args) {
		List<CustomerItems> custItems;
		
		int numberOfInputs = 3;
		for(int inputNumber = 1; inputNumber <= numberOfInputs; inputNumber++) {
			try {
				custItems = loadInputItems(inputNumber);
				if(custItems != null) {
					SalesReceiptService receiptSvc = new SalesReceiptService(custItems);
					receiptSvc.createOutput(inputNumber);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static List<CustomerItems> loadInputItems(int inputValues) throws Exception {
		List<CustomerItems> custItems = null;
		StoreProductServiceImpl storeProductService = new StoreProductServiceImpl();
		custItems = storeProductService.fetchAllStoreItems(inputValues);
		return custItems;
	}
}
