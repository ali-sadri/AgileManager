package com.agile.services;

import com.agile.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
	void createProduct(Product product);
	Product findByID(Long id);
	List<Product> findAll();
	Product updateProduct(Long id, Product product);
	void deleteProduct(Long id);
	Optional<Product> findByName(String name);
	List<Product> findByOwner(Long productOwnerID);
}
