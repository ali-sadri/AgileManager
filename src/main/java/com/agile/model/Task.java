package com.agile.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Task extends AgileItem {

	@ManyToOne()
	@JoinColumn(name = "story_id", nullable = true)
	@JsonBackReference
	private Story relatedStory;

	@ManyToOne()
	@JoinColumn(name = "assigned_user_id", nullable = true)
	@JsonBackReference
	private User assignedUser;

	@Column(name = "estimated_hours")
	private Long estimatedHours;

	private String comments;

	public Task() {}

	public Task(String name, String summary, String description, String
        comments, User assignedUser, Long
			estimatedHours, Story relatedStory, State state){
	    super(name, summary, description, state);
		this.comments = comments;
		this.assignedUser = assignedUser;
		this.estimatedHours = estimatedHours;
		this.relatedStory = relatedStory;
	}

	public Story getRelatedStory() {
		return relatedStory;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public Long getEstimatedHours() {
		return estimatedHours;
	}

	public String getComments() {
		return comments;
	}

	public void setRelatedStory(Story relatedStory) {
		this.relatedStory = relatedStory;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	public void setEstimatedHours(Long estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Task updateFields(Task task){
	    this.name = task.name;
	    this.description = task.description;
		this.summary = task.summary;
		this.assignedUser = task.assignedUser;
		this.comments = task.comments;
		this.estimatedHours = task.estimatedHours;
		this.relatedStory = task.relatedStory;
		this.state = task.state;
		return this;
	}
}
