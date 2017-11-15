package com.agile.services;

import com.agile.model.Story;
import com.agile.repository.StoryRepository;
import com.agile.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StoryServiceImpl implements StoryService
{
	@Autowired
	private StoryRepository storyRepository;

	@Override
	public void createStory(Story story) {
		storyRepository.save(story);
	}

	@Override
	public Story findByID(Long id) {
		return storyRepository.findOne(id);
	}

	@Override
	public Story updateStory(Long id, Story story) {
		return storyRepository.save(storyRepository.findOne(id).updateFields
				(story));
	}

	@Override
	public void deleteStory(Long id) {
		storyRepository.delete(id);
	}

	@Override
	public Optional<Story> findByName(String name) {
		return storyRepository.findByName(name);
	}

	@Override
	public List<Story> findByRelatedProject(Long projectID) {
		return storyRepository.findByRelatedProjectId(projectID);
	}

	@Override
	public List<Story> findByAssignedTeam(Long teamID) {
		return storyRepository.findByAssignedTeamId(teamID);
	}

	@Override
	public List<Story> findByState(State state) {
		return storyRepository.findByState(state);
	}

	@Override
	public List<Story> findAll() {
		return storyRepository.findAll();
	}
}
