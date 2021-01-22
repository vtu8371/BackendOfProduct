package com.spring.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CrudService {
	
	@Autowired
	private CrudRepository repo;
	
	public List<Product> fetchProductList(){
		return repo.findAll();
	}
	
	public Product saveProduct(Product product) {
		return repo.save(product);
	}
	
	public Optional<Product> fetchProductById(int id) {
		return repo.findById(id);
	}
	
	public String deleteProductById(int id) {
		String result;
		 try {
			 repo.deleteById(id);
			 result="Product Deleted Successfully";
		 }
		 catch(Exception e) {
			 result="Not available in database";
		 }
		 return result;
	}
}
