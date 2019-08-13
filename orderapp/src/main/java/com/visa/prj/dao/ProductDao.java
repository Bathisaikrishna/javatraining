package com.visa.prj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Product;

@Repository
public interface ProductDao {

	List<Product> getProducts();
	Product getProduct(int id);
	int addProduct(Product p); 
}
