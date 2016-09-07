package com.niit.laptop.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.laptop.model.Product;

public class Productedit {
	public void update(Product product,SessionFactory sessionFactory)
	{
			
		System.out.print("inside update product");
		Session s=sessionFactory.openSession();
		SQLQuery query=s.createSQLQuery("update Product1 set  name='"+product.getName()+"',description='"+product.getDescription()+"',price='"+product.getPrice()+"',cat_id='"+product.getCat()+"',supplier='"+product.getSupplier()+"' where ID=+'"+product.getId()+"'");
		query.executeUpdate();
		
		
	}

	
	
}
