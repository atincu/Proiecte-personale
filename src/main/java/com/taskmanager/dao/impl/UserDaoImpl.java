package com.taskmanager.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taskmanager.dao.UserDao;
import com.taskmanager.model.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {
	
	 @Autowired
	 private SessionFactory session;
	
	@Override
	public void addUser(UserEntity user) {
		session.getCurrentSession().save(user);	
	}

	@Override
	public void editUser(UserEntity user) {
		session.getCurrentSession().update(user);		
	}

	@Override
	public void deleteUser(int userId) {
		session.getCurrentSession().delete(findUser(userId));		
	}

	@Override
	public UserEntity findUser(int userId) {
		return (UserEntity) session.getCurrentSession().get(UserEntity.class, userId);
	}

	@Override
	public UserEntity findUserByName(String username) {
		Criteria criteria = session.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("username", username));
		return (UserEntity) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getAllUsers() {
		return session.getCurrentSession().createQuery("from user").list();
	}

}
