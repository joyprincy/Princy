package com.niit.laptop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptop.model.Category;
import com.niit.laptop.model.Product;

@Repository("productDao")
public class ProductInterfaceImpl  {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	@Transactional
	public void saveOrUpdate(Product product) {
		sessionFactory.openSession().saveOrUpdate(product);
		System.out.println("This is inside saveor update  "+product.getId());
		
	}
	
	@Transactional
	public void update(Product product)
	{
		Productedit proe=new Productedit();
		proe.update(product, sessionFactory);
		
		}
	
	@Transactional
	public List <Product> getByCategory(int categoryId)
	{
		String hql="from Product where cat_id =" + " ' " +categoryId+ " ' ";
		Query query=sessionFactory.openSession().createQuery(hql);
		List<Product> listProduct=query.list();
		if(listProduct!=null && !listProduct.isEmpty()){
			return listProduct;
			
		}
		return null;
		}
	
	@Transactional
	public void delete(int id) {
		System.out.println("in del dao");
		System.out.println(id);
		Product productToDelete = new Product();
		productToDelete.setId(id);
		Session s=sessionFactory.openSession();
		SQLQuery sql=s.createSQLQuery("delete PRODUCT1 where id=" + "'" + id + "'");
		sql.executeUpdate();
		s.flush();
				//s.delete(productToDelete);
		System.out.println("Deleted item");
		
	}
	
	@Transactional
	public Product get(int id) {
		//String hql="from product where id =" + "'" + id + "'";
		System.out.println(id);
		//Query query=sessionFactory.openSession().createQuery(hql);
		Criteria query=sessionFactory.openSession().createCriteria(Product.class);
		query.add(Restrictions.eq("id", id));
	
		List<Product>listProduct=query.list();
		
		if(listProduct!= null && !listProduct.isEmpty()) {
			return listProduct.get(0);
			
		}
		return null;
	}
	
	
	@Transactional
	public List<Product> list() {
		
		@SuppressWarnings("unchecked")
		List<Product> listProduct =(List<Product>) sessionFactory.openSession().
		createCriteria(Product.class).list();
		System.out.println(listProduct);
		return listProduct;
	}
	


}
