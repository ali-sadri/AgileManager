package com.agile.repository;

import com.agile.model.StoryMilestone;
import com.agile.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoryMilestoneRepository extends JpaRepository<StoryMilestone, Long>{
	Optional<StoryMilestone> findByName(String name);
	List<StoryMilestone> findByState(State state);
	List<StoryMilestone> findByStoryId(Long storyID);
}
