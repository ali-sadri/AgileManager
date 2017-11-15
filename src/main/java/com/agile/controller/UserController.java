package com.agile.controller;

import com.agile.model.User;
import com.agile.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping(path = "/users") public class UserController {

	@Autowired
    private UserServiceImpl userServiceImpl;

	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User input) {
        userServiceImpl.createUser(
            new User(input.getFirstName(), input.getLastName(),
                input.getUserID(), input.getEmail(), input.getRole(),
                input.getTeam()));
        return ResponseEntity.ok("The new user was Saved");
    }

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public User readUser(@PathVariable Long id) {
		return userServiceImpl.findByID(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> readAllUsers() {
		return userServiceImpl.findAll();
	}


	@RequestMapping(method = RequestMethod.PUT)
    public User updateUser(@RequestBody User input) {
        User inputUser = new User(input.getFirstName(), input.getLastName(),
            input.getUserID(), input.getEmail(), input.getRole(),
            input.getTeam());
        inputUser.setAssignedTasks(input.getAssignedTasks());
        inputUser.setOwnedProducts(input.getOwnedProducts());
        inputUser.setOwnedProjects(input.getOwnedProjects());
        return userServiceImpl.updateUser(input.getId(), inputUser);
    }

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		userServiceImpl.deleteUser(id);
		return ResponseEntity.ok("The specified user was deleted");
	}
}
