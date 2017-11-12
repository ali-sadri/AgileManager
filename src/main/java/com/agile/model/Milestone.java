package com.agile.model;

import com.agile.sharedEnums.State;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class Milestone {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	protected Long id;

	@Column(unique = true, nullable = false)
	protected String name;

	protected String description;

	@Column(name = "estimated_done_date")
	protected Timestamp estimatedDoneDate;

	protected String comments;

	@Column(columnDefinition = "enum('New','InProgress','InTesting','Done')")
	@Enumerated(EnumType.STRING)
	protected State state;

	public Milestone() {
	}

	public Milestone(String name, String description,
		Timestamp estimatedDoneDate, String comments, State state) {
		this.name = name;
		this.description = description;
		this.estimatedDoneDate = estimatedDoneDate;
		this.comments = comments;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Timestamp getEstimatedDoneDate() {
		return estimatedDoneDate;
	}

	public String getComments() {
		return comments;
	}

	public State getState() {
		return state;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEstimatedDoneDate(Timestamp estimatedDoneDate) {
		this.estimatedDoneDate = estimatedDoneDate;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setState(State state) {
		this.state = state;
	}


}
