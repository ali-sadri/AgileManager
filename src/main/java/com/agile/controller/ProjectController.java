package com.agile.controller;

import com.agile.model.Project;
import com.agile.services.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping(path = "/projects")
public class ProjectController {

	@Autowired private ProjectServiceImpl projectServiceImpl;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createProject(@RequestBody Project input) {
		projectServiceImpl.createProject(
			new Project(input.getName(), input.getSummary(), input
				.getProduct(),
				input.getStartDate(), input.getEstimatedEndDate(),
				input.getFullDescription(), input.getMilestones(),
				input.getProjectOwner(), input.getRelatedStories(),
				input.getState()));
		return ResponseEntity.ok("The new project was Saved");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Project readProject(@PathVariable Long id) {
		return projectServiceImpl.findByID(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Project> readAllProjects() {
		return projectServiceImpl.findAll();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Project updateProject(@RequestBody Project input) {
		return projectServiceImpl.updateProject(input.getId(),
			new Project(input.getName(), input.getSummary(), input
				.getProduct(),
				input.getStartDate(), input.getEstimatedEndDate(),
				input.getFullDescription(), input.getMilestones(),
				input.getProjectOwner(), input.getRelatedStories(),
				input.getState()));
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable Long id) {
		projectServiceImpl.deleteProject(id);
		return ResponseEntity.ok("The specified Project was deleted");
	}

}
