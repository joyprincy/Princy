package com.niit.laptop.dao;



import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.laptop.model.Product;

@Service
public class ProductDaoService {
   
	@Autowired
	private ProductInterfaceImpl productDao;
	
	@Transactional
	public List<Product> list() {
		
		List<Product> pro=productDao.list();
		return pro;
	}
	public Product get(int id) {
		
		return productDao.get(id);
		
			}
	public List <Product> getByCategory(int categoryId)
	{
		return getByCategory(categoryId);
	}
	
	public void delete(int id) {
		System.out.println("inside product service dao   " +id);
		productDao.delete(id);
	}
	
	public void update(Product product)
	{
		productDao.update(product);
	}

	public void saveOrUpdate(Product product) {
		
		System.out.println("inside service save or update");
		productDao.saveOrUpdate(product);
	}  
	
	}
