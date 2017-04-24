package io.egen.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.MovieAndTV;
import io.egen.movieflix.entity.User;
import io.egen.movieflix.entity.UserLogin;
import io.egen.movieflix.exceptions.AlreadyExistsException;
import io.egen.movieflix.exceptions.NotFoundException;
import io.egen.movieflix.repository.UserRepository;
@Service
public class UserServiceImp implements UserService{
@Autowired
	UserRepository repository;
	@Override
	@Transactional
	public User signUp(User user) {
		// TODO Auto-generated method stub
		User existing = repository.findUser(user.getEmailID());
		if(existing != null){
			throw new AlreadyExistsException("User already exists");
		}
		return repository.signUp(user);
	}

	@Override
	@Transactional
	public User login(UserLogin userLogin) {
		// TODO Auto-generated method stub
		//System.out.println("service" + userLogin.getUsername());
		User existing = repository.findByEmail(userLogin.getUsername());
		if (existing == null){
			throw new NotFoundException("User not found");
		}else{
			
			if(existing.getPassword().equals(userLogin.getPassword())){
			//System.out.println("password matched");
					return existing;
		}
			else{
				
				throw new NotFoundException("User not found");
			}
		}

	}

	@Override
	public User logout(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public User findUser(String id){
		User existing = repository.findUser(id);
		
		if(existing == null){
			throw new NotFoundException("User not found");
		}
		return existing;
	}
	@Override
	@Transactional
	public User editProfile(String id, User user) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
	        User existing = repository.findUser(id);
			
			if(existing == null){
				throw new NotFoundException("Movie not found");
			}
			return repository.editProfile(user);
	
	}

	@Override
	@Transactional
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
		 User existing = repository.findUser(id);
			
			if(existing == null){
				throw new NotFoundException("Movie not found");
			}
			repository.deleteUser(existing);
	}






}
