package com.agile.services;

import com.agile.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
	void createUser(User user);
	User findByID(Long id);
	User updateUser(Long id, User user);
	void deleteUser(Long id);
	Optional<User> findByLastName(String lastName);
	Optional<User> findByUserID(String userID);
	Optional<User> findByEmail(String email);
	List<User> findByTeamID(Long teamID);
	List<User> findByTeamName(String teamName);
	List<User> findByRole(User.Role role);
	List<User> findAll();
}
