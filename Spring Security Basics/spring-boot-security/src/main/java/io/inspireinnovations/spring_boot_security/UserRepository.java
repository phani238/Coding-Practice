package io.inspireinnovations.spring_boot_security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.inspireinnovations.spring_boot_security.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findbyUserName(String userName);
}
