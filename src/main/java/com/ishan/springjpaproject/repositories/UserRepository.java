package com.ishan.springjpaproject.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ishan.springjpaproject.entity.User;

@Repository
@Transactional
public class UserRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public User findById(long id) {
		User user = entityManager.find(User.class,id);
		return user;
	}
	
	public long insert(User user) {
		entityManager.persist(user);
		return user.getId();
	}
}
