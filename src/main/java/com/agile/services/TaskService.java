package com.agile.services;

import com.agile.model.Task;
import com.agile.model.State;

import java.util.List;

public interface TaskService {
	 void createTask(Task task);
	 Task findByID(Long id);
	 Task updateTask(Long id, Task task);
	 void deleteTask(Long id);
	 List<Task> findByAssignedUser(Long userID);
	 List<Task> findByRelatedStory(Long storyID);
	 List<Task> findByState(State state);
	 List<Task> findAll();
}
