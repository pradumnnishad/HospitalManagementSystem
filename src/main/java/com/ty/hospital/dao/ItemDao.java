package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Item;

public interface ItemDao {
	public Item saveItem(int mid,Item item);
	public boolean deleteItem(int i_id);
	public Item getItemById(int i_id);
	public Item updateItemById(int i_id,Item item);
	public List<Item> getrAllItem();
	public Item getItemByMedOrderID(int mid);
}
