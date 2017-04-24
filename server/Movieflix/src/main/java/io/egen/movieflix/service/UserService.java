package io.egen.movieflix.service;

import io.egen.movieflix.entity.User;
import io.egen.movieflix.entity.UserLogin;

public interface UserService {
	
	public User signUp(User user);
	public User login(UserLogin userLogin);
	public User logout(User user);
	public User findUser(String id);
	public User editProfile(String id, User user);
	public void deleteUser(String id);

}
