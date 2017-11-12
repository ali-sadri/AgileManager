package com.agile.model;

import com.agile.sharedEnums.State;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Long id;

	private String summary;

	@ManyToOne()
	@JoinColumn(name = "story_id", nullable = true)
	@JsonBackReference
	private Story relatedStory;

	@ManyToOne()
	@JoinColumn(name = "assigned_user_id", nullable = true)
	@JsonBackReference
	private User assignedUser;

	@Column(columnDefinition = "enum('New','InProgress','InTesting','Done')")
	@Enumerated(EnumType.STRING)
	private State state;

	@Column(name = "estimated_hours")
	private Long estimatedHours;

	private String comments;

	public Task() {}

	public Task(String summary, String comments, User assignedUser, Long
			estimatedHours, Story relatedStory, State state){
		this.summary = summary;
		this.comments = comments;
		this.assignedUser = assignedUser;
		this.estimatedHours = estimatedHours;
		this.relatedStory = relatedStory;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public String getSummary() {
		return summary;
	}

	public Story getRelatedStory() {
		return relatedStory;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public State getState() {
		return state;
	}

	public Long getEstimatedHours() {
		return estimatedHours;
	}

	public String getComments() {
		return comments;
	}	

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setRelatedStory(Story relatedStory) {
		this.relatedStory = relatedStory;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setEstimatedHours(Long estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Task updateFields(Task task){
		this.summary = task.summary;
		this.assignedUser = task.assignedUser;
		this.comments = task.comments;
		this.estimatedHours = task.estimatedHours;
		this.relatedStory = task.relatedStory;
		this.state = task.state;
		return this;
	}
}
