package com.agile.controller;

import com.agile.model.ProjectMilestone;
import com.agile.services.ProjectMilestoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping(path = "/projectmilestones")
public class ProjectMileStoneController {

	@Autowired
    private ProjectMilestoneServiceImpl projectMilestoneServiceImpl;

	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createProjectMilestone(
        @RequestBody ProjectMilestone input) {
        projectMilestoneServiceImpl.createProjectMilestone(
            new ProjectMilestone(input.getName(), input.getDescription(),
                input.getSummary(), input.getEstimatedDoneDate(),
                input.getComments(), input.getState(), input.getProject()));
        return ResponseEntity.ok("The new project milestone was Saved");
    }

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ProjectMilestone readProjectMilestone(@PathVariable Long id) {
        return projectMilestoneServiceImpl.findByID(id);
    }

	@RequestMapping(method = RequestMethod.GET)
	public List<ProjectMilestone> readAllProjectMilestones() {
		return projectMilestoneServiceImpl.findAll();
	}


	@RequestMapping(method = RequestMethod.PUT)
    public ProjectMilestone updateProjectMilestone(
        @RequestBody ProjectMilestone input) {
        return projectMilestoneServiceImpl.updateProjectMilestone(input.getId(),
            new ProjectMilestone(input.getName(), input.getDescription(),
                input.getSummary(), input.getEstimatedDoneDate(),
                input.getComments(), input.getState(), input.getProject()));
    }

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> deleteProjctMilestone(@PathVariable Long id) {
        projectMilestoneServiceImpl.deleteProjectMilestone(id);
        return ResponseEntity
            .ok("The specified project milestone was " + "deleted");
    }

}
