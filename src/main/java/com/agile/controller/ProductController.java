package com.agile.controller;


import com.agile.model.Product;
import com.agile.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping(path = "/products")
public class ProductController {

	@Autowired
    private ProductServiceImpl productServiceImpl;

	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody Product input) {
        productServiceImpl.createProduct(
            new Product(input.getName(), input.getSummary(),
                input.getDescription(), input.getState(),
                input.getProductOwner(), input.getRelatedProjects()));
        return ResponseEntity.ok("The new product was Saved");
    }

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Product readProduct(@PathVariable Long id) {
		return productServiceImpl.findByID(id);
	}

	@RequestMapping(method = RequestMethod.GET)
    public List<Product> readAllProducts() {
        return productServiceImpl.findAll();
    }

	@RequestMapping(method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product input) {
        return productServiceImpl.updateProduct(input.getId(),
            new Product(input.getName(), input.getSummary(),
                input.getDescription(), input.getState(),
                input.getProductOwner(), input.getRelatedProjects()));
    }

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		productServiceImpl.deleteProduct(id);
		return ResponseEntity.ok("The specified product was deleted");
	}

}
