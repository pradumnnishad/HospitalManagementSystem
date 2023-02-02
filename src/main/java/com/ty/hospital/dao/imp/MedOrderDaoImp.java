package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.MedOrderDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.MedOrder;

public class MedOrderDaoImp implements MedOrderDao {

	public MedOrder saveMedOrder(int eid, MedOrder medorder) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(medorder);
			entityTransaction.commit();
			return medorder;
		}
		return null;
	}

	public boolean deleteMedOrder(int mid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();		
		MedOrder medOrder=entityManager.find(MedOrder.class, mid);
		if(medOrder!=null) {
			entityTransaction.begin();
			entityManager.remove(medOrder);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public MedOrder getMedOrderById(int mid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select s from MedOrder s where mid=1?");
		query.setParameter(1, mid);
		MedOrder medOrder=(MedOrder)query.getResultList();
		return medOrder;
	}

	public MedOrder updateMedOrderById(int mid, MedOrder medorder) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		MedOrder medOrder2=entityManager.find(MedOrder.class, mid);
		if(medOrder2!=null) {
			medOrder2.setDname(medorder.getDname());
			medOrder2.setOrderDate(medorder.getOrderDate());
			medOrder2.setTotal(medorder.getTotal());
			
			entityTransaction.begin();
			entityManager.merge(medOrder2);
			entityTransaction.commit();
			return medOrder2;
		}
		return null;
	}

	public List<MedOrder> getAllMedOrder() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();		
		Query query=entityManager.createQuery("select s from MedOrder s");
		List<MedOrder> list=query.getResultList();		
		return list;
	}

	public MedOrder getMedOrderByDoctorName(String name) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select name from medOrder s where name=1?");
		query.setParameter(1, name);
		MedOrder medOrder=(MedOrder)query.getResultList();
		return medOrder;
	}

	public MedOrder getMedOrderByDate(String date) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select date from medOrder s where date=1?");
		query.setParameter(1, date);
		MedOrder medOrder=(MedOrder)query.getResultList();
		return medOrder;
	}

}
