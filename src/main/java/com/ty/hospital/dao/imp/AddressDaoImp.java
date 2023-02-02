package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dao.AddressDao;
import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;

public class AddressDaoImp implements AddressDao{

	public Address saveAddress(int bid, Address address) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Branch branch=entityManager.find(Branch.class, bid);
		if(branch!=null) {
			Address address2=entityManager.find(Address.class, bid);
			entityTransaction.begin();
			entityManager.persist(address2);
			entityTransaction.commit();
			return address2;
		}
		return null;
	}

	public boolean deleteAddress(int aid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Address address=entityManager.find(Address.class, aid);
		if(address!=null) {
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Address getAddressById(int aid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Address address=entityManager.find(Address.class, aid);
		if(address!=null) {
			return address;
		}
		return null;
	}

	public Address updateAddressById(int aid, Address address) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Address address2=entityManager.find(Address.class, aid);
		if(address2!=null) {
			address2.setBranch(address.getBranch());
			address2.setCountry(address.getCountry());
			address2.setPin(address.getPin());
			address2.setState(address.getState());
			address2.setStreet(address.getStreet());
		}
		return null;
	}

	public List<Address> getAddressAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
