package com.agile.services;

import com.agile.model.Project;
import com.agile.repository.ProjectRepository;
import com.agile.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public void createProject(Project project) {
		projectRepository.save(project);
	}

	@Override
	public Project findByID(Long id) {
		return projectRepository.findOne(id);
	}

	@Override
	public Project updateProject(Long id, Project project) {
		return projectRepository.save(projectRepository.findOne(id)
				.updateFields(project));
	}

	@Override
	public void deleteProject(Long id) {
		projectRepository.delete(id);
	}

	@Override
	public Optional<Project> findByName(String name) {
		return projectRepository.findByName(name);
	}

	@Override
	public List<Project> findByProduct(Long productID) {
		return projectRepository.findByProductId(productID);
	}

	@Override
	public List<Project> findByState(State state) {
		return projectRepository.findByState(state);
	}

	@Override
	public List<Project> findByOwner(Long projectOwnerID) {
		return projectRepository.findByProjectOwnerId(projectOwnerID);
	}

	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}
}
