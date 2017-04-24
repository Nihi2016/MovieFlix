package io.egen.movieflix.service;

import io.egen.movieflix.entity.MovieAndTV;
import io.egen.movieflix.entity.Ratings;
import io.egen.movieflix.entity.User;
import io.egen.movieflix.exceptions.NotFoundException;
import io.egen.movieflix.repository.MovieAndTVRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class MovieAndTVServiceImp implements MovieAndTVService {

	@Autowired
	MovieAndTVRepository repository;
	@Override
	public List<MovieAndTV> viewAll() {
		// TODO Auto-generated method stub
		return repository.viewAll();
	}

	@Override
	public List<MovieAndTV> viewTopRatedMovies() {
		// TODO Auto-generated method stub
		return repository.viewTopRatedMovies();
	}

	@Override
	public List<MovieAndTV> viewTopRatedTVSeries() {
		// TODO Auto-generated method stub
		return repository.viewTopRatedTVSeries();
	}

	@Override
	public List<MovieAndTV> filterByType(String type) {
		// TODO Auto-generated method stub
		return repository.filterByType(type);
	}

	@Override
	public List<MovieAndTV> filterByYear() {
		// TODO Auto-generated method stub
		return repository.filterByYear();
	}

	@Override
	public List<MovieAndTV> filterByGenre(String genre) {
		// TODO Auto-generated method stub
		return repository.filterByGenre(genre);
	}

	@Override
	public List<MovieAndTV> sortByImdbRatings() {
		// TODO Auto-generated method stub
		return repository.sortByImdbRatings();
	}

	@Override
	public List<MovieAndTV> sortByImdbVotes() {
		// TODO Auto-generated method stub
		return repository.sortByImdbVotes();
	}

	@Override
	public MovieAndTV findOne(String id) {
		// TODO Auto-generated method stub
		MovieAndTV existing = repository.findOne(id);
		
		if(existing == null){
			throw new NotFoundException("Movie not found");
		}
		return existing;
	}
// Logic to update average rating of a movie/tvseries
	@Override
	@Transactional
	public MovieAndTV newRating(MovieAndTV mtv, double userRating) {
		// TODO Auto-generated method stub
		Ratings ratings = mtv.getRating();
		int noofRatings = ratings.getNoOfRatings();
		System.out.println(noofRatings);
		noofRatings+=1;
		ratings.setNoOfRatings(noofRatings);
		System.out.println(noofRatings);
		ratings.setAvgUserRating(userRating);
		System.out.println(ratings.toString());
		
		mtv.setRating(ratings);
		
		return repository.newRating(mtv);
	}

	@Override
	@Transactional
	public MovieAndTV newComment(String id, MovieAndTV mtv) {
		// TODO Auto-generated method stub
		return repository.newComment(mtv);
	}

	@Override
	@Transactional
	public MovieAndTV addNewTitle(MovieAndTV movie) {
		// TODO Auto-generated method stub
		System.out.println("in service:"+movie);
		return repository.addNewTitle(movie);
	}

	@Override
	@Transactional
	public MovieAndTV edit(String id, MovieAndTV movie) {
		// TODO Auto-generated method stub
        MovieAndTV existing = repository.findOne(id);
		
		if(existing == null){
			throw new NotFoundException("Movie not found");
		}
		return repository.edit(movie);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
     MovieAndTV existing = repository.findOne(id);
		
		if(existing == null){
			throw new NotFoundException("Movie not found");
		}
		repository.delete(existing);
	}

	@Override
	public List<MovieAndTV> findTitle(String title) {
		// TODO Auto-generated method stub
		return repository.findTitle(title);
		
	}

}
