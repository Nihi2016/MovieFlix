package io.egen.movieflix.controller;

import java.util.List;

import io.egen.movieflix.entity.MovieAndTV;
import io.egen.movieflix.entity.User;
import io.egen.movieflix.service.MovieAndTVService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "movieandtv")
public class MovieAndTVController {
	
	@Autowired
	MovieAndTVService service;
	
	@RequestMapping(method=RequestMethod.GET,produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieAndTV> viewAll() {
		// TODO Auto-generated method stub
		return service.viewAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/topmovies",produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieAndTV> viewTopRatedMovies() {
		// TODO Auto-generated method stub
		return service.viewTopRatedMovies();
	}	

	@RequestMapping(method=RequestMethod.GET,path ="/toptvseries",produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<MovieAndTV> viewTopRatedTVSeries() {
		// TODO Auto-generated method stub
		return service.viewTopRatedTVSeries();
	}
	
   @RequestMapping(method=RequestMethod.GET,path ="/type/{type}",produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
   public List<MovieAndTV> filterByType(@PathVariable("type") String type) {
		return service.filterByType(type);
	}
	

   @RequestMapping(method=RequestMethod.GET,path = "/year",produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieAndTV> filterByYear() {
	// TODO Auto-generated method stub
	return service.filterByYear(); 
  }

   @RequestMapping(method=RequestMethod.GET,path = "/genre/{genre}",produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieAndTV> filterByGenre(@PathVariable("genre")String genre) {
		// TODO Auto-generated method stub
		return service.filterByGenre(genre); 
	}
   
	@RequestMapping(method=RequestMethod.GET,path ="/imdbratings",produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieAndTV> sortByImdbRatings() {
		// TODO Auto-generated method stub
		return service.sortByImdbRatings();
	}

	@RequestMapping(method=RequestMethod.GET,path="/imdbvotes",produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieAndTV> sortByImdbVotes() {
		// TODO Auto-generated method stub
		return service.sortByImdbVotes();
	}
	@RequestMapping(method=RequestMethod.GET,path ="/{id}",produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieAndTV findOne(@PathVariable("id")String id) {
		// TODO Auto-generated method stub
		return service.findOne(id);
	}
	@RequestMapping(method=RequestMethod.PUT,path ="/rating/{userRating}",produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE,consumes= org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieAndTV newRating(@RequestBody MovieAndTV mtv, @PathVariable("userRating")double userRating) {
		// TODO Auto-generated method stub
		return service.newRating(mtv, userRating);
	}
	
	@RequestMapping(method=RequestMethod.PUT,path = "/comment/{id}",consumes= org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MovieAndTV newComment(@PathVariable("id")String id, @RequestBody MovieAndTV movie) {
	// TODO Auto-generated method stub
	return service.newComment(id,movie); 
} 
     @RequestMapping(method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE )
	public MovieAndTV addNewTitle(@RequestBody MovieAndTV movie) {
		// TODO Auto-generated method stub
    	// System.out.println(movie);
		return service.addNewTitle(movie);
	}

     @RequestMapping(method = RequestMethod.GET, path ="/title/{title}",produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
     public List<MovieAndTV> findTitle(@PathVariable("title")String title){
    	 return service.findTitle(title);
     }
     
     @RequestMapping(method=RequestMethod.PUT,path ="/{id}",produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieAndTV edit(@PathVariable("id")String id, @RequestBody MovieAndTV movie) {
		// TODO Auto-generated method stub
		return service.edit(id, movie);
	}
     @RequestMapping(method=RequestMethod.DELETE,path = "/{id}")
	public void delete(@PathVariable("id")String id) {
		// TODO Auto-generated method stub
		service.delete(id);
	}


}
