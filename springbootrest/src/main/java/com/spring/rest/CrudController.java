package com.spring.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CrudController {
	
	@Autowired
	private CrudService service;
	
	@GetMapping("/getproductlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> fetchProducList(){
		List<Product> products=new ArrayList<Product>();
		//logic to fetch list from database
		products = service.fetchProductList();
		System.out.println(products);
		return products;
	}
	
	@PostMapping("/addproduct")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product saveProduct(@RequestBody Product product){
		return service.saveProduct(product);
	}
	
	@GetMapping("/getproductbyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product fetchProducById(@PathVariable int id){
		return service.fetchProductById(id).get();
	}
	
	@DeleteMapping("/deleteproductbyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String deleteProductById(@PathVariable int id){
		return service.deleteProductById(id);
	}
}
