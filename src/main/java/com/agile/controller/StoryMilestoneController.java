package com.agile.controller;

import com.agile.model.StoryMilestone;
import com.agile.services.StoryMilestoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping(path = "/storymilestones")
public class StoryMilestoneController {

	@Autowired
    private StoryMilestoneServiceImpl storyMilestoneServiceImpl;

	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createStoryMilestone(
        @RequestBody StoryMilestone input) {
        storyMilestoneServiceImpl.createStoryMilestone(
            new StoryMilestone(input.getName(), input.getDescription(),
                input.getSummary(), input.getEstimatedDoneDate(),
                input.getComments(), input.getState(), input.getStory()));
        return ResponseEntity.ok("The new story milestone was Saved");
    }

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public StoryMilestone readStoryMilestone(@PathVariable Long id) {
		return storyMilestoneServiceImpl.findByID(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<StoryMilestone> readAllStorieMilestones() {
		return storyMilestoneServiceImpl.findAll();
	}


	@RequestMapping(method = RequestMethod.PUT)
    public StoryMilestone updateStoryMilestone(
        @RequestBody StoryMilestone input) {
        return storyMilestoneServiceImpl.updateStoryMilestone(input.getId(),
            new StoryMilestone(input.getName(), input.getDescription(),
                input.getSummary(), input.getEstimatedDoneDate(),
                input.getComments(), input.getState(), input.getStory()));
    }

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> deleteStoryMilestone(@PathVariable Long id) {
        storyMilestoneServiceImpl.deleteStoryMilestone(id);
        return ResponseEntity.ok("The specified story milestone was deleted");
    }


}
