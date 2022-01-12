package com.ricardo.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardo.dsmovie.entites.Movie;
import com.ricardo.dsmovie.entites.Score;
import com.ricardo.dsmovie.entites.ScorePK;
import com.ricardo.dsmovie.entites.User;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
	

}
