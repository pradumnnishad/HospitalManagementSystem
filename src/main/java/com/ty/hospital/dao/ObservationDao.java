package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Observation;

public interface ObservationDao {
	public Observation saveMedOrderDao(int oid,Observation observe);
	public boolean deleteObservationDao(int oid);
	public Observation getObservationDaoById(int oid);
	public Observation updateObservationDaoById(int oid,Observation observe);
	public Observation getObservationByDoctorname(String name);
	public List<Observation> getAllObservation();
}
