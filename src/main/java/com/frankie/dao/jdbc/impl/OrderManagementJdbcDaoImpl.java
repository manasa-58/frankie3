package com.frankie.dao.jdbc.impl;

import java.util.List;

import com.controller.pojo.user.ItemInfo;
import com.frankie.dao.interf.IOrderManagementDao;

public class OrderManagementJdbcDaoImpl  implements IOrderManagementDao {

	public int deleteItem(int itemId) {
		System.out.println("jdbc flow");
		return 0;
	}

	public List<ItemInfo> fetchdeleteItem() {
		System.out.println("jdbc flow");
		return null;
	}

	public ItemInfo editView(int itemId) {
		System.out.println("jdbc flow");
		return null;
	}

	public void updateItem(ItemInfo item) {
		System.out.println("jdbc flow");
		
	}

}
