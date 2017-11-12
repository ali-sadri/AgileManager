package com.agile.repository;

import com.agile.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
	Optional<Team> findByName(String name);
}


