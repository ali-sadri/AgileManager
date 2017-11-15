package com.agile.services;

import com.agile.model.ProjectMilestone;
import com.agile.repository.ProjectMilestoneRepository;
import com.agile.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectMilestoneServiceImpl implements ProjectMilestoneService{

	@Autowired
	private ProjectMilestoneRepository projectMilestoneRepository;

	@Override
	public void createProjectMilestone(ProjectMilestone projectMilestone) {
		projectMilestoneRepository.save(projectMilestone);
	}

	@Override
	public ProjectMilestone findByID(Long projectMilestoneID) {
		return projectMilestoneRepository.findOne(projectMilestoneID);
	}

    @Override public ProjectMilestone updateProjectMilestone(Long id,
        ProjectMilestone projectMilestone) {
        return projectMilestoneRepository.save(
            projectMilestoneRepository.findOne(id)
                .updateFields(projectMilestone));
    }

	@Override
	public void deleteProjectMilestone(Long id) {
		projectMilestoneRepository.delete(id);
	}

	@Override
	public Optional<ProjectMilestone> findByName(String projectMilestoneName) {
		return projectMilestoneRepository.findByName(projectMilestoneName);
	}

	@Override
	public List<ProjectMilestone> findByState(State state) {
		return projectMilestoneRepository.findByState(state);
	}

	@Override
	public List<ProjectMilestone> findByProject(Long projectID) {
		return projectMilestoneRepository.findByProjectId(projectID);
	}

	@Override
	public List<ProjectMilestone> findAll() {
		return projectMilestoneRepository.findAll();
	}
}
