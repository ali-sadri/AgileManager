package com.agile.services;

import com.agile.model.ProjectMilestone;
import com.agile.model.State;

import java.util.List;
import java.util.Optional;

public interface ProjectMilestoneService {
    void createProjectMilestone(ProjectMilestone projectMilestone);
    ProjectMilestone findByID(Long projectMilestoneID);
    ProjectMilestone updateProjectMilestone(Long id,
        ProjectMilestone projectMilestone);
    void deleteProjectMilestone(Long id);
    Optional<ProjectMilestone> findByName(String projectMilestoneName);
    List<ProjectMilestone> findByState(State state);
    List<ProjectMilestone> findByProject(Long projectID);
    List<ProjectMilestone> findAll();
}
