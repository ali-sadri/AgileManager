package com.agile.services;

import com.agile.model.Task;
import com.agile.repository.TaskRepository;
import com.agile.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public void createTask(Task task) {
		taskRepository.save(task);
	}

	@Override
	public Task findByID(Long id) {
		return taskRepository.findOne(id);
	}

	@Override
	public Task updateTask(Long id, Task task) {
		return taskRepository.save(taskRepository.findOne(id).updateFields
				(task));
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.delete(id);
	}

	@Override
	public List<Task> findByAssignedUser(Long userID) {
		return taskRepository.findByAssignedUserId(userID);
	}

	@Override
	public List<Task> findByRelatedStory(Long storyID) {
		return taskRepository.findByRelatedStoryId(storyID);
	}

	@Override
	public List<Task> findByState(State state) {
		return taskRepository.findByState(state);
	}

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
}
