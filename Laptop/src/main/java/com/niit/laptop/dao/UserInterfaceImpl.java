package com.niit.laptop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptop.model.User;

@Repository("userDao")
public class UserInterfaceImpl  {
	
	@Autowired
	public SessionFactory sessionFactory;
	public UserInterfaceImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
}
	@Transactional
	public void saveOrUpdate(User user) {
		user.setEnable(true);
		user.setRole("ROLE_USER");
		Session ses=sessionFactory.openSession();
		ses.saveOrUpdate(user);
		ses.flush();
	}
	
	@Transactional
	public void delete(String username) {
		User userToDelete = new User();
		userToDelete.setUsername(username);
		sessionFactory.getCurrentSession().delete(userToDelete);
		
	}
	
	@Transactional
	public User get(String username) {
		String hql="from User where username =" + "'" + username  + "'";
		Query query=sessionFactory.openSession().createQuery(hql);
		
			List<User>listUser=query.list();
		
		if(listUser!= null && !listUser.isEmpty()) {
			return listUser.get(0);
			
		}
		return null;
	}
	
	@Transactional
	public boolean isValidUser(String username,String password)
	{
		Criteria query=sessionFactory.openSession().createCriteria(User.class);
		Criterion restl=Restrictions.and(Restrictions.eq("username", username),Restrictions.eq("password",password));
		query.add(restl);
		
		@SuppressWarnings("unchecked")
		List<User> listUser =query.list();
		if(listUser !=null && !listUser.isEmpty())
		{
			return true;
		}
		
		return false;
	}
	
		
			
	
	
	@Transactional
	public List<User> list() {
		
		@SuppressWarnings("unchecked")
		List<User> listUser =(List<User>) sessionFactory.getCurrentSession().
		createCriteria(User.class).list();
		return listUser;
	}
	
}
