package com.agile.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product extends AgileItem{

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	@JsonManagedReference
	private Set<Project> relatedProjects =	new HashSet<>();

	@ManyToOne()
	@JoinColumn(name = "owner_id", nullable = true)
	@JsonBackReference
	private User productOwner;

	public Product() {
	}

    public Product(String name, String summary, String description, State
        state, User productOwner, Set<Project> relatedProjects ){
	    super(name, summary,description,state);
	    this.productOwner = productOwner;
	    this.relatedProjects = relatedProjects;
    }

	public User getProductOwner() {
		return productOwner;
	}

	public Set<Project> getRelatedProjects() {
		return relatedProjects;
	}

	public void setProductOwner(User productOwner) {
		this.productOwner = productOwner;
	}

	public void setRelatedProjects(Set<Project> relatedProjects) {
		this.relatedProjects = relatedProjects;
	}

	public Product updateFields(Product product) {
		this.name = product.name;
		this.description = product.description;
		this.state = product.state;
		this.productOwner = product.productOwner;
		this.relatedProjects = product.relatedProjects;
		this.summary = product.summary;
		return this;
	}

}
