package com.agile.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	private String summary;

	@Column(name = "full_description")
	private String fullDescription;

	@ManyToOne()
	@JoinColumn(name = "product_id", nullable = true)
	@JsonBackReference
	private Product product;

	@Column(name = "start_date")
	private Timestamp startDate;

	@Column(name = "estimated_end_date")
	private Timestamp estimatedEndDate;

	@Column(columnDefinition = "enum('New','InProgress','Complete')")
	@Enumerated(EnumType.STRING)
	private ProjectState state;

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

	public Project(String name, String summary, Product product) {
		this.name = name;
		this.summary = summary;
		this.product = product;
	}

	public Project(String name, String summary, Product product,
		Timestamp startDate, Timestamp estimatedEndDate) {
		this(name, summary, product);
		this.startDate = startDate;
		this.estimatedEndDate = estimatedEndDate;
	}

	public Project(String name, String summary, Product product,
		Timestamp startDate, Timestamp estimatedEndDate, String
		fullDescription,
		Set<ProjectMilestone> milestones, User projectOwner,
		Set<Story> relatedStories, ProjectState state) {
		this(name, summary, product, startDate, estimatedEndDate);
		this.fullDescription = fullDescription;
		this.milestones = milestones;
		this.projectOwner = projectOwner;
		this.relatedStories = relatedStories;
	}


	public enum ProjectState {
		New, InProgress, Complete
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

	public Product getProduct() {
		return product;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public Timestamp getEstimatedEndDate() {
		return estimatedEndDate;
	}

	public ProjectState getState() {
		return state;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
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

	public void setState(ProjectState state) {
		this.state = state;
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
		this.fullDescription = project.fullDescription;
		this.milestones = project.milestones;
		this.projectOwner = project.projectOwner;
		this.relatedStories = project.relatedStories;
		this.startDate = project.startDate;
		this.state = project.state;
		return this;
	}

}
