package com.agile.repository;

import com.agile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByLastName(String lastName);
	Optional<User> findByUserID(String userID);
	Optional<User> findByEmail(String email);
	List<User> findByTeamId(Long teamID);
	List<User> findByTeamName(String teamName);
	List<User> findByRole(User.Role role);
}
