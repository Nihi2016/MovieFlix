package io.egen.movieflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.MovieAndTV;
import io.egen.movieflix.entity.User;
import io.egen.movieflix.entity.UserLogin;
import io.egen.movieflix.service.UserService;
@RestController
@RequestMapping(path = "user")
public class UserController {

	@Autowired
	UserService service;
	@RequestMapping(method=RequestMethod.POST,produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User signUp(@RequestBody User user){
		
		return service.signUp(user);
	}
	@RequestMapping(method=RequestMethod.POST,path ="/login",produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User login(@RequestBody UserLogin userLogin){
		System.out.println(userLogin);
		return service.login(userLogin);
	}
	
	//Can be handled in front end
//	public User logout(User user){
//		return service.logout(user);
//		
//	}
	@RequestMapping(method=RequestMethod.GET,path ="/{id}",produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findUser(@PathVariable("id")String id) {
		// TODO Auto-generated method stub
		return service.findUser(id);
	}
	@RequestMapping(method=RequestMethod.PUT,path ="/{id}",produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User editProfile(@PathVariable("id")String id, @RequestBody User user) {
			// TODO Auto-generated method stub
			return service.editProfile(id, user);
		
	}
	 @RequestMapping(method=RequestMethod.DELETE,path = "/{id}")
		public void deleteUser(@PathVariable("id")String id) {
			// TODO Auto-generated method stub
			service.deleteUser(id);
		}
}
