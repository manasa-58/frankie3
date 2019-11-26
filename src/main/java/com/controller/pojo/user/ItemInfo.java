package com.controller.pojo.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class ItemInfo {
	
	@Id
	@GeneratedValue
	private int Itemid;
	public int getItemid() {
		return Itemid;
	}
	public void setItemid(int itemid) {
		Itemid = itemid;
	}
	public String getItem() {
		return Item;
	}
	public void setItem(String item) {
		Item = item;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getQty() {
		return Qty;
	}
	public void setQty(String qty) {
		Qty = qty;
	}
	public String getTypeOfItem() {
		return TypeOfItem;
	}
	public void setTypeOfItem(String typeOfItem) {
		TypeOfItem = typeOfItem;
	}
	private String Item;
	private int Price;
	private String Qty;
	private String TypeOfItem;
	

}
