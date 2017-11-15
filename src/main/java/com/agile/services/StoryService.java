package com.agile.services;

import com.agile.model.Story;
import com.agile.model.State;

import java.util.List;
import java.util.Optional;

  public interface StoryService {
	 void createStory(Story story);
	 Story findByID(Long id);
	 Story updateStory(Long id, Story story);
	 void deleteStory(Long id);
	 Optional<Story> findByName(String name);
	 List<Story> findByRelatedProject(Long projectID);
	 List<Story> findByAssignedTeam(Long teamID);
	 List<Story> findByState(State state);
	 List<Story> findAll();
}
