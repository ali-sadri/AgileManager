package com.agile.repository;

import com.agile.model.Task;
import com.agile.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
	 List<Task> findByRelatedStoryId(Long stroyID);
	 List<Task> findByAssignedUserId(Long userID);
	 List<Task> findByState(State state);
}
