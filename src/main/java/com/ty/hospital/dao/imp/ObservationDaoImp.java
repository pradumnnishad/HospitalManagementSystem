package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.ObservationDao;
import com.ty.hospital.dto.Observation;

public class ObservationDaoImp implements ObservationDao {

	public Observation saveMedOrderDao(int oid, Observation observe) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		 Observation observation=entityManager.find(Observation.class, oid);
		 if(observation!=null) {
			 entityTransaction.begin();
			 entityManager.persist(observation);
			 entityTransaction.commit();
			 return observation;
		 }
		return null;
	}

	public boolean deleteObservationDao(int oid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Observation observation=entityManager.find(Observation.class, oid);
		if(observation!=null) {
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Observation getObservationDaoById(int oid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select s from observation s where oid=1?");
		query.setParameter(1, oid);
		Observation observation=(Observation)query.getResultList();
		return observation;
	}

	public Observation updateObservationDaoById(int oid, Observation observe) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Observation observation=entityManager.find(Observation.class, oid);
		if(observation!=null) {
			observation.setDname(observe.getDname());
			observation.setR_Observation(observe.getR_Observation());
			entityTransaction.begin();
			entityManager.merge(observation);
			entityTransaction.commit();
			return observation;
		}
		return null;
	}

	public Observation getObservationByDoctorname(String name) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select s from Observation s where name=1?");
		query.setParameter(1, name);
		Observation observation=(Observation)query.getResultList();
		
		return observation;
	}

	public List<Observation> getAllObservation() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select s from Observation s");
		List<Observation> observation=query.getResultList();
		
		return observation;
	}

}
