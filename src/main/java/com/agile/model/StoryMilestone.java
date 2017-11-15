package com.agile.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
public class StoryMilestone extends Milestone {

	@ManyToOne()
	@JoinColumn(name = "story_id", nullable = true)
    @JsonBackReference
	private Story story;

	public StoryMilestone() {}

	public StoryMilestone(String name, String description, String summary,
		Timestamp estimatedDoneDate, String comments, State state,
		Story story) {
		super(name, description, summary, estimatedDoneDate, comments, state);
		this.story = story;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public StoryMilestone updateFields(StoryMilestone storyMilestone){
		this.name = storyMilestone.name;
		this.story = storyMilestone.story;
		this.comments = storyMilestone.comments;
		this.description = storyMilestone.description;
		this.estimatedDoneDate = storyMilestone.estimatedDoneDate;
		this.state = storyMilestone.state;
		return this;
	}
}
