package com.niit.laptop.dao;



import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.niit.laptop.model.User;

@Service
public class UserDaoService {

	@Autowired
	private UserInterfaceImpl userDao;
	
	@Transactional
	public List<User> list1() {
		return null;
	}
	public User get(String username) {
		return userDao.get(username);
		
	}
	
	
	public void delete1(String username) {
	}

	public void saveOrUpdate(User user) {
		
		System.out.println("inside service save or update");
		userDao.saveOrUpdate(user);
	}  
	public boolean isValidUser(String username, String password)
	{
		
		return userDao.isValidUser(username, password);
	}
	}
	
	
