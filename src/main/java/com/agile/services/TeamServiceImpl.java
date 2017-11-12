package com.agile.services;

import com.agile.model.Team;
import com.agile.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public void createTeam(Team team) {
		teamRepository.save(team);
	}

	@Override
	public Team findByID(Long id) {
		return teamRepository.findOne(id);
	}

	@Override public Team updateTeam(Long id, Team team) {
        return teamRepository
            .save(teamRepository.findOne(id).updateFields(team));
    }

	@Override
	public void deleteTeam(Long id) {
		teamRepository.delete(id);
	}

	@Override
	public Optional<Team> findByName(String name) {
		return teamRepository.findByName(name);
	}

	@Override
	public List<Team> findAll() {
		return teamRepository.findAll();
	}
}
