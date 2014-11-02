package com.hos.liferay.persistence;

import java.util.List;
import com.hos.liferay.model.CustomerItems;

public interface StoreProductService {
	public List<CustomerItems> fetchAllStoreItems(int inputType) throws Exception;
}
