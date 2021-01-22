package com.spring.rest;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CrudRepository extends JpaRepository<Product, Integer>{

}
