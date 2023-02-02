package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.MedOrder;

public interface MedOrderDao {
	public MedOrder saveMedOrder(int eid,MedOrder medorder);
	public boolean deleteMedOrder(int mid);
	public MedOrder getMedOrderById(int mid);
	public MedOrder updateMedOrderById(int mid,MedOrder medorder);
	public List<MedOrder> getAllMedOrder();
	public MedOrder getMedOrderByDoctorName(String name);
	public MedOrder getMedOrderByDate(String date);
	

}
