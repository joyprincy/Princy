package com.niit.laptop.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.laptop.model.Category;

public class Categoryedit {
	
	public void update(Category category,SessionFactory sessionFactory)
	{
			
		System.out.print("inside update product");
		Session s=sessionFactory.openSession();
		SQLQuery query=s.createSQLQuery("update Category1 set  name='"+category.getName()+"',description='"+category.getDescription()+"' where ID=+'"+category.getId()+"'");
		query.executeUpdate();
		
		
	}


}
