package io.egen.movieflix.repository;

import io.egen.movieflix.entity.User;
import io.egen.movieflix.entity.UserLogin;

public interface UserRepository {

	public User signUp(User user);
	//public User login(UserLogin user);
	public User logout(User user);
	public User findUser(String id);
	public User findByEmail(String email);
	public User editProfile(User user);
	public void deleteUser(User user);
}
