package com.agile.repository;

import com.agile.model.ProjectMilestone;
import com.agile.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectMilestoneRepository extends JpaRepository<ProjectMilestone, Long> {
	 Optional<ProjectMilestone> findByName(String name);
	 List<ProjectMilestone> findByState(State state);
	 List<ProjectMilestone> findByProjectId(Long projectID);
}
