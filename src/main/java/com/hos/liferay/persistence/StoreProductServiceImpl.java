package com.hos.liferay.persistence;

import java.util.List;
import java.util.ArrayList;
import com.hos.liferay.model.CustomerItems;
import com.hos.liferay.persistence.StoreProductService;

public class StoreProductServiceImpl implements StoreProductService {
	public List<CustomerItems> fetchAllStoreItems(int inputType) throws Exception {
		List<CustomerItems> results = new ArrayList<CustomerItems>();
		CustomerItems custItem = null;
		
		switch(inputType) {
		case 1:
			custItem = null;
			custItem = new CustomerItems();
			custItem.setCost(12.49);
			custItem.setImported(false);
			custItem.setItemDescription("book");
			custItem.setQuantity(1);
			custItem.setTaxable(false);
			results.add(custItem);		
			
			custItem = null;
			custItem = new CustomerItems();
			custItem.setCost(14.99);
			custItem.setImported(false);
			custItem.setItemDescription("music CD");
			custItem.setQuantity(1);
			custItem.setTaxable(true);
			results.add(custItem);
			
			custItem = null;
			custItem = new CustomerItems();
			custItem.setCost(.85);
			custItem.setImported(false);
			custItem.setItemDescription("chocolate bar");
			custItem.setQuantity(1);
			custItem.setTaxable(false);
			results.add(custItem);
			
			break;
		case 2:
			custItem = null;
			custItem = new CustomerItems();
			custItem.setCost(10.00);
			custItem.setImported(true);
			custItem.setItemDescription("imported box of chocolates");
			custItem.setQuantity(1);
			custItem.setTaxable(false);
			results.add(custItem);
			
			custItem = null;
			custItem = new CustomerItems();
			custItem.setCost(47.50);
			custItem.setImported(true);
			custItem.setItemDescription("imported bottle of perfume");
			custItem.setQuantity(1);
			custItem.setTaxable(true);
			results.add(custItem);
			
			break;
		case 3:
			custItem = null;
			custItem = new CustomerItems();
			custItem.setCost(27.99);
			custItem.setImported(true);
			custItem.setItemDescription("imported bottle of perfume");
			custItem.setQuantity(1);
			custItem.setTaxable(true);
			results.add(custItem);
			
			custItem = null;
			custItem = new CustomerItems();
			custItem.setCost(18.99);
			custItem.setImported(false);
			custItem.setItemDescription("bottle of perfume");
			custItem.setQuantity(1);
			custItem.setTaxable(true);
			results.add(custItem);
			
			custItem = null;
			custItem = new CustomerItems();
			custItem.setCost(9.75);
			custItem.setImported(false);
			custItem.setItemDescription("packet of headache pills");
			custItem.setQuantity(1);
			custItem.setTaxable(false);
			results.add(custItem);
			
			custItem = null;
			custItem = new CustomerItems();
			custItem.setCost(11.25);
			custItem.setImported(true);
			custItem.setItemDescription("imported box of chocolates");
			custItem.setQuantity(1);
			custItem.setTaxable(false);
			results.add(custItem);
			
			break;
		}
		return results;
	}
}
