package com.ty.hospital.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.UserDao;
import com.ty.hospital.dto.Observation;
import com.ty.hospital.dto.User;

public class UserDaoImp implements UserDao {

	public User saveUser(User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(user!=null) {
			entityTransaction.begin();
			entityManager.persist(user);
			entityTransaction.commit();
			return user;
		}
		return null;
	}

	public boolean deleteUser(int uid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		User user=entityManager.find(User.class, uid);
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public User getUserById(int uid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from User s where uid=1?");
		query.setParameter(1, uid);
		User user=(User)query.getResultList();
		return user;
	}

	public User updateUserById(int uid, User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		User user2=entityManager.find(User.class, uid);
		if(user!=null) {
			user2.setEmail(user.getEmail());
			user2.setPassword(user.getPassword());
			user2.setUname(user.getUname());
			user2.setPhno(user.getPhno());
			user2.setRole(user.getRole());
			entityTransaction.begin();
			entityManager.merge(user2);
			entityTransaction.commit();
			return user2;
		}
		return null;
	}

	public List<User> getAllUSer() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select s from User s");
		List<User> user=query.getResultList();
		return user;
	}

	public User getUserName(String name) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from user s where name=1?");
		query.setParameter(1, name);
		User user=(User)query.getResultList();
		return user;
	}

	public User getUserByRole(String role) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venkySir");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("select s from User s where role=1?");
		query.setParameter(1, role);
		User user=(User)query.getResultList();
		return user;
	}

}
