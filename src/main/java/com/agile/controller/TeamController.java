package com.agile.controller;

import com.agile.model.Team;
import com.agile.services.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping(path = "/teams") public class TeamController {

	@Autowired
    private TeamServiceImpl teamServiceImpl;

	@RequestMapping(method = RequestMethod.POST, path = "/add/{name}")
	public ResponseEntity<?> createTeam(@PathVariable String name) {
		teamServiceImpl.createTeam(new Team(name));
		return ResponseEntity.ok("The new Team was Saved");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Team readTeam(@PathVariable Long id) {
		return teamServiceImpl.findByID(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Team> readAllTeams() {
	    return teamServiceImpl.findAll();
	}

	@RequestMapping(method = RequestMethod.PUT)
    public Team updateTeam(@RequestBody Team input) {
        return teamServiceImpl.updateTeam(input.getId(),
            new Team(input.getName(), input.getTeamMembers(),
                input.getAssignedStories()));
    }


	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<?> deleteTeam(@PathVariable Long id) {
		teamServiceImpl.deleteTeam(id);
		return ResponseEntity.ok("The specified team was deleted");
	}
}
