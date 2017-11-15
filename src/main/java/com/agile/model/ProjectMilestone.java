package com.agile.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity public class ProjectMilestone extends Milestone {

	@ManyToOne()
	@JoinColumn(name = "project_id", nullable = true)
    @JsonBackReference
	private Project project;

	public ProjectMilestone() {}

	public ProjectMilestone(String name, String description,String summary,
		Timestamp estimatedDoneDate, String comments, State state,
		Project project) {
		super(name, description, summary, estimatedDoneDate, comments, state);
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ProjectMilestone updateFields(ProjectMilestone projectMilestone) {
		this.name = projectMilestone.name;
		this.project = projectMilestone.project;
		this.comments = projectMilestone.comments;
		this.description = projectMilestone.description;
		this.estimatedDoneDate = projectMilestone.estimatedDoneDate;
		this.state = projectMilestone.state;
		return this;
	}

}
