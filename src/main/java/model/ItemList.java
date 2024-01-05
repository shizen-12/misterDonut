package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ItemList implements Serializable{
	private List<Item> itemList = new ArrayList<Item>();
	
	public ItemList() {
		
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	//itemListにitemを追加
	public void addItemList(Item item) {
		itemList.add(item);
	}
	
	
}
