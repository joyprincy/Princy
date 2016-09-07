package com.niit.laptop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptop.model.Category;
import com.niit.laptop.model.Product;

@Repository("categoryDao")
public class CategoryInterfaceImpl  {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	
	public void saveOrUpdate(Category category) {
		Session ses=sessionFactory.openSession();
		ses.saveOrUpdate(category);
		ses.flush();
	}
	@Transactional
	public void delete(int id) {
		System.out.println("in del dao");
		System.out.println(id);
		Category categoryToDelete = new Category();
		categoryToDelete.setId(id);
		Session s=sessionFactory.openSession();
		SQLQuery sql=s.createSQLQuery("delete CATEGORY1 where id=" + "'" + id + "'");
		sql.executeUpdate();
		//s.flush();
				//s.delete(productToDelete);
		System.out.println("Deleted item");
	}
	
	@Transactional
	public Category getByName(String name) {
		
		/*Criteria query=sessionFactory.openSession().createCriteria(Category.class);
		query.add(Restrictions.eq("name", name));
	System.out.println(query);*/
		String hql="from Category where name =" + " ' " +name+ " ' ";
		Query query=sessionFactory.openSession().createQuery(hql);
	    List<Category>listCategory=query.list();
	    for(Category cat:listCategory)
	    {
	    	System.out.println("this is inside getbyname    "+cat.getName());
	    }
		if(listCategory!= null && !listCategory.isEmpty()) {
			return listCategory.get(0);
			
		}
		return null;
	}
	@Transactional
	public void update(Category category)
	{
		Categoryedit cate=new Categoryedit();
		cate.update(category, sessionFactory);
		
		}
	
	@Transactional
	public Category get(int id) {
		String hql="from category where id =" + "'" + id + "'";
		Query query=sessionFactory.openSession().createQuery(hql);
		
		List<Category>listCategory=query.list();
		
		if(listCategory!= null && !listCategory.isEmpty()) {
			return listCategory.get(0);
			
		}
		return null;
	}
	
	
	@Transactional
	public List<Category> list() {
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory =(List<Category>) sessionFactory.openSession().
		createCriteria(Category.class).list();
		return listCategory;
	}

	
	

	}
