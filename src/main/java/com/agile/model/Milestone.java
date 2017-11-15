package com.agile.model;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class Milestone extends AgileItem{

	@Column(name = "estimated_done_date")
	protected Timestamp estimatedDoneDate;

	protected String comments;

	public Milestone() {
	}

	public Milestone(String name, String description, String summary,
		Timestamp estimatedDoneDate, String comments, State state) {
	    super(name, description, summary, state);
		this.estimatedDoneDate = estimatedDoneDate;
		this.comments = comments;
	}


	public Timestamp getEstimatedDoneDate() {
	    return estimatedDoneDate;
	}

	public String getComments() {
		return comments;
	}

	public void setEstimatedDoneDate(Timestamp estimatedDoneDate) {
		this.estimatedDoneDate = estimatedDoneDate;
	}

	public void setComments(String comments) {

	    this.comments = comments;
	}
}
