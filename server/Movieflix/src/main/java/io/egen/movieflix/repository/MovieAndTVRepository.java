package io.egen.movieflix.repository;

import io.egen.movieflix.entity.MovieAndTV;
import io.egen.movieflix.entity.User;

import java.util.List;




public interface MovieAndTVRepository {

	 public List<MovieAndTV> viewAll();
	 public List<MovieAndTV> viewTopRatedMovies();
	 public List<MovieAndTV> viewTopRatedTVSeries();
	 public List<MovieAndTV> filterByType(String type);
	 public List<MovieAndTV> filterByYear();
	 public List<MovieAndTV> filterByGenre(String genre);
	 public List<MovieAndTV> sortByImdbRatings();
	 public List<MovieAndTV> sortByImdbVotes();
	 public MovieAndTV findOne(String id);
	 public MovieAndTV newRating(MovieAndTV mtv);
	 public  MovieAndTV newComment(MovieAndTV mtv);
	 public MovieAndTV addNewTitle(MovieAndTV movie);
	 public List<MovieAndTV> findTitle(String title);
	 public MovieAndTV edit(MovieAndTV movie);
	 public void delete(MovieAndTV movie);
}
