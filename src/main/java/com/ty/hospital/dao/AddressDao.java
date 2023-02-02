package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Hospital;

public interface AddressDao {
	public Address saveAddress(int bid,Address address);
	 public boolean deleteAddress(int aid);
	 public Address getAddressById(int aid);
	 public Address updateAddressById(int aid,Address address);
	 public List<Address> getAddressAll();
}
