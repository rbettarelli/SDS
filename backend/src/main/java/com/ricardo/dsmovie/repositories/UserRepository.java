package com.ricardo.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardo.dsmovie.entites.Movie;
import com.ricardo.dsmovie.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
