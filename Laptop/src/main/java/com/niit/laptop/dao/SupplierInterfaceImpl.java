package com.niit.laptop.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptop.model.Supplier;

@Repository("supplierDao")
public class SupplierInterfaceImpl  {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	
	public void saveOrUpdate(Supplier supplier) {
		Session ses=sessionFactory.openSession();
		ses.saveOrUpdate(supplier);
		ses.flush();
	}
	@Transactional
	public void delete(int id) {
		Supplier supplierToDelete = new Supplier();
		supplierToDelete.setId(id);
		Session s=sessionFactory.openSession();
		SQLQuery sql=s.createSQLQuery("delete SUPPLIER1 where id=" + "'" + id + "'");
		sql.executeUpdate();
		s.flush();
				//s.delete(productToDelete);
		System.out.println("Deleted item");
				
	}
	
	@Transactional
	public Supplier get(int id) {
		String hql="from category where id =" + "'" + id + "'";
		Query query=sessionFactory.openSession().createQuery(hql);
		
		List<Supplier>listSupplier=query.list();
		
		if(listSupplier!= null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
			
		}
		return null;
	}
	
	
	@Transactional
	public List<Supplier> list() {
		
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier =(List<Supplier>) sessionFactory.openSession().
		createCriteria(Supplier.class).list();
		return listSupplier;
	}
	

}
