package com.taskmanager.dao;

import java.util.List;

import com.taskmanager.model.UserEntity;

public interface UserDao {
	
	void addUser(UserEntity user);
	
	void editUser(UserEntity user);
	
	void deleteUser(int userId);
	
	UserEntity findUser(int userId);
	
	UserEntity findUserByName(String username);
	
	List<UserEntity> getAllUsers();
}
