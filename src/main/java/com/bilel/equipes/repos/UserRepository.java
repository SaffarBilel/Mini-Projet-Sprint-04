package com.bilel.equipes.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bilel.equipes.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
		User findByUsername (String username);
		}


