package com.agile.repository;

import com.agile.model.Project;
import com.agile.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	Optional<Project> findByName(String name);
	List<Project> findByProductId(Long productID);
	List<Project> findByProjectOwnerId(Long projectOwnerID);
	List<Project> findByState(State state);
}
