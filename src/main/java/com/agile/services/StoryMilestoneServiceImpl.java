package com.agile.services;

import com.agile.model.StoryMilestone;
import com.agile.repository.StoryMilestoneRepository;
import com.agile.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service public class StoryMilestoneServiceImpl
	implements StoryMilestoneService {

	@Autowired private StoryMilestoneRepository storyMilestoneRepository;

	@Override public void createStoryMilestone(StoryMilestone storyMilestone) {
		storyMilestoneRepository.save(storyMilestone);
	}

	@Override public StoryMilestone findByID(Long storyMilestoneID) {
		return storyMilestoneRepository.findOne(storyMilestoneID);
	}

	@Override public StoryMilestone updateStoryMilestone(Long id,
		StoryMilestone storyMilestone) {
		return storyMilestoneRepository.save(
			storyMilestoneRepository.findOne(id).updateFields(storyMilestone));
	}

	@Override public void deleteStoryMilestone(Long id) {
		storyMilestoneRepository.delete(id);
	}

	@Override
	public Optional<StoryMilestone> findByName(String storyMilestoneName) {
		return storyMilestoneRepository.findByName(storyMilestoneName);
	}

	@Override public List<StoryMilestone> findByState(State state) {
		return storyMilestoneRepository.findByState(state);
	}

	@Override public List<StoryMilestone> findByStory(Long storyID) {
		return storyMilestoneRepository.findByStoryId(storyID);
	}

	@Override public List<StoryMilestone> findAll() {
		return storyMilestoneRepository.findAll();
	}
}
