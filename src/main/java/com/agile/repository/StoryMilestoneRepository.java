package com.agile.repository;

import com.agile.model.StoryMilestone;
import com.agile.sharedEnums.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoryMilestoneRepository extends JpaRepository<StoryMilestone, Long>{
	public Optional<StoryMilestone> findByName(String name);
	public List<StoryMilestone> findByState(State state);
	public List<StoryMilestone> findByStoryId(Long storyID);
}
