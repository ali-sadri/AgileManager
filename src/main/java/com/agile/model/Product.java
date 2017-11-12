package com.agile.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	private String summary;

	@Column(name = "full_description")
	private String fullDescription;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	@JsonManagedReference
	private Set<Project> relatedProjects =	new HashSet<>();

	@ManyToOne()
	@JoinColumn(name = "owner_id", nullable = true)
	@JsonBackReference
	private User productOwner;

	public Product() {
	}

	public Product(String name, String summary, String description) {
		this.name = name;
		this.summary = summary;
		this.fullDescription = description;
	}

	public Product(String name, String summary, String description,
		User owner) {
		this(name, summary, description);
		this.productOwner = owner;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSummary() {
		return summary;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public User getProductOwner() {
		return productOwner;
	}

	public Set<Project> getRelatedProjects() {
		return relatedProjects;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public void setProductOwner(User productOwner) {
		this.productOwner = productOwner;
	}

	public void setRelatedProjects(Set<Project> relatedProjects) {
		this.relatedProjects = relatedProjects;
	}

	public Product updateFields(Product product) {
		this.name = product.name;
		this.fullDescription = product.fullDescription;
		this.productOwner = product.productOwner;
		this.relatedProjects = product.relatedProjects;
		this.summary = product.summary;
		return this;
	}

}
