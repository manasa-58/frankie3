package com.frankie.dao.interf;

import java.util.List;

import com.controller.pojo.user.ItemInfo;

public interface IOrderManagementDao {
	
	public int deleteItem(int itemId);
	public List<ItemInfo> fetchdeleteItem();
	public ItemInfo editView(int itemId);
	public void updateItem(ItemInfo item);

}
