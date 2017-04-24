package io.egen.movieflix.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import io.egen.movieflix.entity.MovieAndTV;
import io.egen.movieflix.entity.User;
import io.egen.movieflix.entity.UserLogin;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public class UserRepositoryImp implements UserRepository {
	
    @PersistenceContext
	EntityManager em;
    
	@Override
	public User signUp(User user) {
		// TODO Auto-generated method stub
		 em.persist(user);
		 return user;
	}

//	@Override
//	public User login(UserLogin user) {
//		// TODO Auto-generated method stub
////		TypedQuery<User> query = em.createNamedQuery("User.validateLogin", User.class);
////	       query.setParameter("password", password); 
////	       emaild
////	       select u from USER where u.email = email;
////	       
////	       query.getResultList(); 
//		return null;
//		
//	
//	}

	@Override
public User logout(User user) {
		// TODO Auto-generated method stub
		return null;
	}
			

	@Override
	@Transactional
	public User editProfile(User user) {
		// TODO Auto-generated method stub
		return em.merge(user);
	}

	@Override
	public User findUser(String id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}
	@Override
	@Transactional
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		em.remove(user);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		System.out.println(email);
		TypedQuery<User> query = em.createNamedQuery("User.findEmail", User.class);
       query.setParameter("uemail", email);
		return query.getSingleResult();
	}

	

}
