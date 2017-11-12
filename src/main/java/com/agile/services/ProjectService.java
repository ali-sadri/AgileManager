package com.agile.services;

import com.agile.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
	void createProject(Project project);
	Project findByID(Long id);
	Project updateProject(Long id, Project project);
	void deleteProject(Long id);
	Optional<Project> findByName(String name);
	List<Project> findByProduct(Long ProductID);
	List<Project> findByState(Project.ProjectState state);
	List<Project> findByOwner(Long projectOwnerID);
	List<Project> findAll();
}
