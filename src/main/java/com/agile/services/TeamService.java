package com.agile.services;

import com.agile.model.Team;

import java.util.List;
import java.util.Optional;


public interface TeamService {
	void createTeam(Team team);
	Team findByID(Long id);
	Team updateTeam(Long id, Team team);
	void deleteTeam(Long id);
	Optional<Team> findByName(String name);
	List<Team> findAll();
}
