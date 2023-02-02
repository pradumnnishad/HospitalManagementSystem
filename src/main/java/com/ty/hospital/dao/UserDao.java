package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.User;

public interface UserDao {
	public User saveUser(User user);
	 public boolean deleteUser(int uid);
	 public User getUserById(int uid);
	 public User updateUserById(int uid,User user);
	 public List<User> getAllUSer();
	 public User getUserName(String name);
	 public User getUserByRole(String role);
}
