package com.agile.controller;


import com.agile.model.Task;
import com.agile.services.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping(path = "/tasks") public class TaskController {

    @Autowired
    private TaskServiceImpl taskServiceImpl;

	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createTask(@RequestBody Task input) {
        taskServiceImpl.createTask(new Task(input.getName(), input.getSummary(),
            input.getDescription(), input.getComments(),
            input.getAssignedUser(), input.getEstimatedHours(),
            input.getRelatedStory(), input.getState()));
        return ResponseEntity.ok("The new task was Saved");
    }

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Task readTask(@PathVariable Long id) {
		return taskServiceImpl.findByID(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Task> readAllTasks() {
	    return taskServiceImpl.findAll();
	}


	@RequestMapping(method = RequestMethod.PUT)
	public Task updateTask(@RequestBody Task input) {
		return taskServiceImpl.updateTask(input.getId(),
			new Task(input.getName(), input.getSummary(),
                input.getDescription(), input.getComments(),
                input.getAssignedUser(), input.getEstimatedHours(),
                input.getRelatedStory(), input.getState()));
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable Long id) {
		taskServiceImpl.deleteTask(id);
		return ResponseEntity.ok("The specified task was deleted");
	}

}
