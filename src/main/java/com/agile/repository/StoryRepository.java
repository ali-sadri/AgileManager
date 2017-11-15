package com.agile.repository;

import com.agile.model.Story;
import com.agile.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoryRepository extends JpaRepository<Story, Long> {
	Optional<Story> findByName(String name);
	List<Story> findByRelatedProjectId(Long projectID);
	List<Story> findByState(State state);
	List<Story> findByAssignedTeamId(Long teamID);
}
