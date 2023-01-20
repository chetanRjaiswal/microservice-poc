package com.app.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	

}
