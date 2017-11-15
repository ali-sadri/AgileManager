package com.agile.controller;


import com.agile.model.Story;
import com.agile.services.StoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping(path = "/stories")
public class StoryController {

	@Autowired
    private StoryServiceImpl storyServiceImpl;

	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createStory(@RequestBody Story input) {
        storyServiceImpl.createStory(
            new Story(input.getName(), input.getSummary(),
                input.getDescription(), input.getState(),
                input.getAssignedTeam(), input.getComments(),
                input.getContinuation(), input.getContinuedFromStoryId(),
                input.getStartDate(), input.getEstimatedEndDate(),
                input.getMilestones(), input.getRelatedProject(),
                input.getRelatedTasks(), input.getSize(),
                input.getAcceptanceCriteria()));
        return ResponseEntity.ok("The new story was Saved");
    }

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Story readStory(@PathVariable Long id) {
		return storyServiceImpl.findByID(id);
	}

	@RequestMapping(method = RequestMethod.GET)
    public List<Story> readAllStories() {
	    return storyServiceImpl.findAll();
    }


	@RequestMapping(method = RequestMethod.PUT)
    public Story updateStory(@RequestBody Story input) {
        return storyServiceImpl.updateStory(input.getId(),
            new Story(input.getName(), input.getSummary(),
                input.getDescription(), input.getState(),
                input.getAssignedTeam(), input.getComments(),
                input.getContinuation(), input.getContinuedFromStoryId(),
                input.getStartDate(), input.getEstimatedEndDate(),
                input.getMilestones(), input.getRelatedProject(),
                input.getRelatedTasks(), input.getSize(),
                input.getAcceptanceCriteria()));
    }

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<?> deleteStory(@PathVariable Long id) {
		storyServiceImpl.deleteStory(id);
		return ResponseEntity.ok("The specified story was deleted");
	}


}
