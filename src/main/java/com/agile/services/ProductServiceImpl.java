package com.agile.services;

import com.agile.model.Product;
import com.agile.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void createProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public Product findByID(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override public Product updateProduct(Long id, Product product) {
		return productRepository
			.save(productRepository.findOne(id).updateFields(product));
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.delete(id);
	}

	@Override
	public Optional<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> findByOwner(Long productOwnerID) {
		return productRepository.findByProductOwnerId(productOwnerID);
	}
}
