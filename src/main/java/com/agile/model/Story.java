package com.agile.model;

import com.agile.sharedEnums.State;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity public class Story {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false) private Long id;

	private String name;

	@Column(name = "acceptance_criteria")
	private String acceptanceCriteria;

	private String description;

	@ManyToOne()
	@JoinColumn(name = "project_id", nullable = true)
	@JsonBackReference
	private Project relatedProject;

	private Long size;

	@Column(columnDefinition = "enum('Yes','No')")
	@Enumerated(EnumType.STRING)
	private Continuation continuation;

	@Column(columnDefinition = "enum('New','InProgress','InTesting','Done')")
	@Enumerated(EnumType.STRING)
	private State state;

	@Column(name = "start_date")
	private Timestamp startDate;

	@Column(name = "estimated_end_date")
	private Timestamp estimatedEndDate;

	private String comments;

	@Column(name = "continued_from_story_id")
	private Long continuedFromStoryId;

	@ManyToOne()
	@JoinColumn(name = "assigned_team_id", nullable = true)
	@JsonBackReference
	private Team assignedTeam;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "relatedStory")
	@JsonManagedReference
	private Set<Task> relatedTasks = new HashSet<>();

	public Story(String name, String acceptanceCriteria, Team assignedTeam,
		String comments, Continuation continuation, Long continuedFromStoryId,
		String description, Timestamp estimatedEndDate,
		Set<StoryMilestone> milestones, Project relatedProject,
		Set<Task> relatedTasks, Long size, Timestamp startDate, State state) {
		this.name = name;
		this.acceptanceCriteria = acceptanceCriteria;
		this.assignedTeam = assignedTeam;
		this.comments = comments;
		this.continuation = continuation;
		this.continuedFromStoryId = continuedFromStoryId;
		this.description = description;
		this.estimatedEndDate = estimatedEndDate;
		this.milestones = milestones;
		this.relatedProject = relatedProject;
		this.relatedTasks = relatedTasks;
		this.size = size;
		this.startDate = startDate;
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "story")
	@JsonManagedReference
	private Set<StoryMilestone> milestones = new HashSet<>();

	public Story() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	public String getDescription() {
		return description;
	}

	public Project getRelatedProject() {
		return relatedProject;
	}

	public Long getSize() {
		return size;
	}

	public Continuation getContinuation() {
		return continuation;
	}

	public State getState() {
		return state;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public Timestamp getEstimatedEndDate() {
		return estimatedEndDate;
	}

	public String getComments() {
		return comments;
	}

	public Long getContinuedFromStoryId() {
		return continuedFromStoryId;
	}

	public Team getAssignedTeam() {
		return assignedTeam;
	}

	public Set<Task> getRelatedTasks() {
		return relatedTasks;
	}

	public Set<StoryMilestone> getMilestones() {
		return milestones;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRelatedProject(Project relatedProject) {
		this.relatedProject = relatedProject;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public void setContinuation(Continuation continuation) {
		this.continuation = continuation;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public void setEstimatedEndDate(Timestamp estimatedEndDate) {
		this.estimatedEndDate = estimatedEndDate;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setContinuedFromStoryId(Long continuedFromStoryId) {
		this.continuedFromStoryId = continuedFromStoryId;
	}

	public void setAssignedTeam(Team assignedTeam) {
		this.assignedTeam = assignedTeam;
	}

	public void setRelatedTasks(Set<Task> relatedTasks) {
		this.relatedTasks = relatedTasks;
	}

	public void setMilestones(Set<StoryMilestone> milestones) {
		this.milestones = milestones;
	}

	public Story updateFields(Story story) {
		this.acceptanceCriteria = story.acceptanceCriteria;
		this.assignedTeam = story.assignedTeam;
		this.comments = story.comments;
		this.continuation = story.continuation;
		this.continuedFromStoryId = story.continuedFromStoryId;
		this.description = story.description;
		this.estimatedEndDate = story.estimatedEndDate;
		this.milestones = story.milestones;
		this.name = story.name;
		this.relatedProject = story.relatedProject;
		this.relatedTasks = story.relatedTasks;
		this.size = story.size;
		this.startDate = story.startDate;
		this.state = story.state;
		return this;
	}

	public enum Continuation {
		Yes, No
	}

}
