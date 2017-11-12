package com.agile.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Team {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
	@JsonManagedReference
	private Set<User> teamMembers = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "assignedTeam")
	@JsonManagedReference
	private Set<Story> assignedStories = new HashSet<>();

	public Team(){}

	public Team(String name){
		this.name = name;
	}

	public Team(String name, Set<User> teamMembers, Set<Story>
			assignedStories) {
		this.name = name;
		this.teamMembers = teamMembers;
		this.assignedStories = assignedStories;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Story> getAssignedStories() {
		return assignedStories;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(Set<User> teamMembers) {
		this.teamMembers = teamMembers;
	}

	public void setAssignedStories(Set<Story> assignedStories) {
		this.assignedStories = assignedStories;
	}

	public Team updateFields(Team team){
		this.name = team.name;
		this.teamMembers = team.teamMembers;
		this.assignedStories = team.assignedStories;
		return this;
	}

}
