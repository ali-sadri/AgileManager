package com.agile.model;


import com.agile.sharedEnums.State;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity public class ProjectMilestone extends Milestone {

	@ManyToOne()
	@JoinColumn(name = "project_id", nullable = true)
	private Project project;

	public ProjectMilestone() {}

	public ProjectMilestone(String name, String description,
		Timestamp estimatedDoneDate, String comments, State state,
		Project project) {
		super(name, description, estimatedDoneDate, comments, state);
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
