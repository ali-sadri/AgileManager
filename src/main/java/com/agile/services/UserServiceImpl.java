package com.agile.services;

import com.agile.model.User;
import com.agile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void createUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User findByID(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User updateUser(Long id, User user) {
		return userRepository.save(userRepository.findOne(id).updateFields
				(user));
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}

	@Override
	public Optional<User> findByLastName(String lastName) {
		return userRepository.findByLastName(lastName);
	}

	@Override
	public Optional<User> findByUserID(String userID) {
		return userRepository.findByUserID(userID);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findByTeamID(Long teamID) {
		return userRepository.findByTeamId(teamID);
	}

	@Override
	public List<User> findByTeamName(String teamName) {
		return userRepository.findByTeamName(teamName);
	}

	@Override
	public List<User> findByRole(User.Role role) {
		return userRepository.findByRole(role);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
