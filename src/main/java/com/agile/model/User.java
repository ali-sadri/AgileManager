package com.agile.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User{

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "user_id", nullable = false)
	private String userID;

	@Column(nullable = false)
	private String email;

	@Column(columnDefinition =
		"enum('ProductOwner','ProjectOwner','Developer','QA',"
			+ "'TechnicalWriter',"
			+ "'Other')", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

	@ManyToOne()
	@JoinColumn(name = "team_id", nullable = true)
	@JsonBackReference
	private Team team;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productOwner")
	@JsonManagedReference
	private Set<Product> ownedProducts = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "projectOwner")
	@JsonManagedReference
	private Set<Project> ownedProjects = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "assignedUser")
	@JsonManagedReference
	private Set<Task> assignedTasks = new HashSet<>();

	public User(){}

	public User(String firstName, String lastName, String userID, String email,
		Role role, Team team) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userID = userID;
		this.email = email;
		this.role = role;
		this.team = team;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName()
    { return lastName; }

	public String getEmail() {
		return email;
	}

	public Role getRole() {
		return role;
	}

	public Team getTeam() {
		return team;
	}

	public String getUserID() {return userID;}

	public Set<Product> getOwnedProducts() {
		return ownedProducts;
	}

	public Set<Project> getOwnedProjects() {
		return ownedProjects;
	}

	public Set<Task> getAssignedTasks() {
		return assignedTasks;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) { this.lastName = lastName; }

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public void setUserID(String userID) {this.userID = userID;}

	public void setOwnedProducts(Set<Product> ownedProducts) {
		this.ownedProducts = ownedProducts;
	}

	public void setOwnedProjects(Set<Project> ownedProjects) {
		this.ownedProjects = ownedProjects;
	}

	public void setAssignedTasks(Set<Task> assignedTasks) {
		this.assignedTasks = assignedTasks;
	}

	public User updateFields(User user){
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.email = user.email;
		this.role = user.role;
		this.userID = user.userID;
		this.team = user.team;
		this.ownedProjects = user.ownedProjects;
		this.ownedProducts = user.ownedProducts;
		this.assignedTasks = user.assignedTasks;
		return this;
	}

	public enum Role{
		ProductOwner,
		ProjectOwner,
		Developer,
		QA,
		TechnicalWriter,
		ScrumMaster,
		Other
	}
}
