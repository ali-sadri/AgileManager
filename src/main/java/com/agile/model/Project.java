package com.agile.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project extends AgileItem{

	@ManyToOne()
	@JoinColumn(name = "product_id", nullable = true)
	@JsonBackReference
	private Product product;

	@Column(name = "start_date")
	private Timestamp startDate;

	@Column(name = "estimated_end_date")
	private Timestamp estimatedEndDate;

	@ManyToOne()
	@JoinColumn(name = "owner_id", nullable = true)
	@JsonBackReference
	private User projectOwner;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "relatedProject")
	@JsonManagedReference
	private Set<Story> relatedStories = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	@JsonManagedReference
	private Set<ProjectMilestone> milestones = 	new HashSet<>();

	public Project() {
	}

	public Project(String name, String summary, String description,
        State state, Product product, Timestamp estimatedEndDate, Timestamp
        startDate, Set<ProjectMilestone> milestones, User projectOwner,
        Set<Story> relatedStories) {
		super(name, summary, description, state);
		this.projectOwner = projectOwner;
		this.product = product;
		this.relatedStories = relatedStories;
		this.milestones = milestones;
		this.startDate = startDate;
		this.estimatedEndDate = estimatedEndDate;
	}

	public Product getProduct() {
		return product;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public Timestamp getEstimatedEndDate() {
		return estimatedEndDate;
	}

	public Set<ProjectMilestone> getMilestones() {
		return milestones;
	}

	public User getProjectOwner() {
		return projectOwner;
	}

	public Set<Story> getRelatedStories() {
		return relatedStories;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public void setEstimatedEndDate(Timestamp estimatedEndDate) {
		this.estimatedEndDate = estimatedEndDate;
	}

	public void setMilestones(Set<ProjectMilestone> milestones) {
		this.milestones = milestones;
	}

	public void setProjectOwner(User projectOwner) {
		this.projectOwner = projectOwner;
	}

	public void setRelatedStories(Set<Story> relatedStories) {
		this.relatedStories = relatedStories;
	}

	public Project updateFields(Project project) {
		this.name = project.name;
		this.product = project.product;
		this.summary = project.summary;
		this.estimatedEndDate = project.estimatedEndDate;
		this.description = project.description;
		this.milestones = project.milestones;
		this.projectOwner = project.projectOwner;
		this.relatedStories = project.relatedStories;
		this.startDate = project.startDate;
		this.state = project.state;
		return this;
	}

}
