package com.ricardo.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardo.dsmovie.entites.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
