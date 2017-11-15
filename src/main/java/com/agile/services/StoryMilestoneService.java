package com.agile.services;

import com.agile.model.StoryMilestone;
import com.agile.model.State;

import java.util.List;
import java.util.Optional;

public interface StoryMilestoneService {
	 void createStoryMilestone(StoryMilestone storyMilestone);
	 StoryMilestone findByID(Long storyMilestoneID);
	 StoryMilestone updateStoryMilestone(Long id, StoryMilestone
			storyMilestone);
	 void deleteStoryMilestone(Long id);
	 Optional<StoryMilestone> findByName(String storyMilestoneName);
	 List<StoryMilestone> findByState(State state);
	 List<StoryMilestone> findByStory(Long storyID);
	 List<StoryMilestone> findAll();
}
