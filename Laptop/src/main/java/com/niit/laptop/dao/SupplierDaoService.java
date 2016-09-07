package com.niit.laptop.dao;



import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.laptop.model.Product;
import com.niit.laptop.model.Supplier;

@Service
public class SupplierDaoService {

	@Autowired
	private SupplierInterfaceImpl supplierDao;
	
	@Transactional
	public List<Supplier> list() {
		List<Supplier> sup=supplierDao.list();
		return sup;
	}
	public Supplier get(int id) {
		return  supplierDao.get(id);
	}
	
	public void delete(int id) {
		System.out.println("inside supplier service dao   " +id);
		supplierDao.delete(id);
		
	}

	public void saveOrUpdate(Supplier supplier) {
		
		System.out.println("inside service save or update");
		supplierDao.saveOrUpdate(supplier);
	}  
	
	}
