package com.ricardo.dsmovie.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ricardo.dsmovie.dto.MovieDTO;
import com.ricardo.dsmovie.dto.ScoreDTO;
import com.ricardo.dsmovie.entites.Movie;
import com.ricardo.dsmovie.entites.Score;
import com.ricardo.dsmovie.entites.User;
import com.ricardo.dsmovie.repositories.MovieRepository;
import com.ricardo.dsmovie.repositories.ScoreRepository;
import com.ricardo.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository MovieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
			
		}
		
		Movie movie = MovieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);

		double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum = sum + s.getValue();
			
		}
		
		double avg = sum / movie.getScores().size();
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = MovieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
	
	



}
