package io.egen.movieflix.repository;

import io.egen.movieflix.entity.Comments;
import io.egen.movieflix.entity.Imdb;
import io.egen.movieflix.entity.MovieAndTV;
import io.egen.movieflix.entity.Ratings;
import io.egen.movieflix.entity.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class MovieAndTVRepositoryImp implements MovieAndTVRepository {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<MovieAndTV> viewAll() {
		// TODO Auto-generated method stub
		TypedQuery<MovieAndTV> query = em.createNamedQuery("MovieAndTV.viewAll", MovieAndTV.class);
		return query.getResultList();
	}

	@Override
	public List<MovieAndTV> viewTopRatedMovies() {
		// TODO Auto-generated method stub
		TypedQuery<MovieAndTV> query = em.createNamedQuery("MovieAndTV.viewTopRatedMovies", MovieAndTV.class);
		query.setParameter("mtype", "movie");
		return query.getResultList();
	}

	@Override
	public List<MovieAndTV> viewTopRatedTVSeries() {
		// TODO Auto-generated method stub
		TypedQuery<MovieAndTV> query = em.createNamedQuery("MovieAndTV.viewTopRatedTVSeries", MovieAndTV.class);
		query.setParameter("tvtype", "series");
		return query.getResultList();
	}

	@Override
	public List<MovieAndTV> filterByType(String type) {
		// TODO Auto-generated method stub
		TypedQuery<MovieAndTV> query = em.createNamedQuery("MovieAndTV.fliterByType", MovieAndTV.class);
		query.setParameter("mtvtype", type);
		return query.getResultList();
	}

	@Override
	public List<MovieAndTV> filterByYear() {
		// TODO Auto-generated method stub
		TypedQuery<MovieAndTV> query = em.createNamedQuery("MovieAndTV.filterByYear", MovieAndTV.class);
		return query.getResultList();
	}

	@Override
	public List<MovieAndTV> filterByGenre(String genre) {
		// TODO Auto-generated method stub
		TypedQuery<MovieAndTV> query = em.createNamedQuery("MovieAndTV.filterByGenre", MovieAndTV.class);
		query.setParameter("genre", genre);
		return query.getResultList();
	}

	@Override
	public List<MovieAndTV> sortByImdbRatings() {
		// TODO Auto-generated method stub
		TypedQuery<MovieAndTV> query = em.createNamedQuery("MovieAndTV.sortByImdbRating", MovieAndTV.class);
		return query.getResultList();
	}

	@Override
	public List<MovieAndTV> sortByImdbVotes() {
		// TODO Auto-generated method stub
		TypedQuery<MovieAndTV> query = em.createNamedQuery("MovieAndTV.sortByImdbVotes", MovieAndTV.class);
		return query.getResultList();
	}

	@Override
	public MovieAndTV findOne(String id) {
		// TODO Auto-generated method stub
		return em.find(MovieAndTV.class, id);
	}

	@Override
	@Transactional
	public MovieAndTV newRating(MovieAndTV mtv) {
		// TODO Auto-generated method stub
		return em.merge(mtv);
	}

	@Override
	@Transactional
	public MovieAndTV newComment(MovieAndTV mtv) {
		// TODO Auto-generated method stub
		return em.merge(mtv);
	}

	@Override
	@Transactional
	public MovieAndTV addNewTitle(MovieAndTV movie) {
		
		// TODO Auto-generated method stub
		Imdb imdb = movie.getImdb();
		em.persist(imdb);
		System.out.println("in repo"+movie);
		Ratings rating = movie.getRating();
		System.out.println(rating);
		em.persist(rating);
		
		List<Comments> comments = movie.getComments();
		for(Comments allComments : comments)
		{
		em.persist(allComments);
		}
		
		em.persist(movie);
		return movie;
	}

	@Override
	@Transactional
	public MovieAndTV edit(MovieAndTV movie) {
		// TODO Auto-generated method stub

		return em.merge(movie);
	}

	@Override
	@Transactional
	public void delete(MovieAndTV movie) {
		// TODO Auto-generated method stub

		em.remove(movie);
	}

	@Override
	public List<MovieAndTV> findTitle(String title) {
		// TODO Auto-generated method stub
		TypedQuery<MovieAndTV> query = em.createNamedQuery("MovieAndTV.findByTitle", MovieAndTV.class);
		query.setParameter("title",title);
		
		return query.getResultList();
	}

}
