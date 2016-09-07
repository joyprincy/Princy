package com.niit.laptop.dao;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.laptop.model.Category;
import com.niit.laptop.model.Product;

@Service
public class CategoryDaoService {

	@Autowired
	private CategoryInterfaceImpl categoryDao;
	
	@Transactional
	public List<Category> list() {
		List<Category> cat=categoryDao.list();
		return cat;

	}
	public Category get(int id) {
		return categoryDao.get(id);
	}
	
	public void delete(int id) {
		System.out.println("inside product service dao   " +id);
		categoryDao.delete(id);
}
	public Category getByName(String name)
	{
	return categoryDao.getByName(name);
	}
	public void update(Category category)
	{
		categoryDao.update(category);
	}
		
	
	public void saveOrUpdate(Category category) {
	categoryDao.saveOrUpdate(category);
	}  
	
	}
