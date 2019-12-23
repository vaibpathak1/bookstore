package com.bookstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.bookstore.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users>{

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	public Users create (Users users) {
		return super.create(users);
		
	}

	@Override
	public Users update(Users users) {
		return super.Update(users);
	}

	@Override
	public Users get(Object userId) {
		 return super.find(Users.class,userId);
	}

	@Override
	public void delete(Object id) {
		super.delete(Users.class, id);
	}

	@Override
	public List<Users> listAll() {
		return super.findWithNamedQuery("Users.findAll");
	}

	@Override
	public long count() {
		return super.count("Users.countAll");
	}
	
	public boolean checkLogin(String email, String password) {
		Map<String, Object> map = new HashMap<>();
		map.put("email", email);
		map.put("password", password);
		List<Users> findWithNamedQuery = super.findWithNamedQuery("Users.checkLogin",map);
		 if(findWithNamedQuery.size() == 1) {
				return true;
				 }
		return false;
			
	}
	
	public Users findByEmail(String email) {
		 List<Users> findWithNamedQuery = super.findWithNamedQuery("Users.findByEmail","email",email);
		 if(findWithNamedQuery !=null && findWithNamedQuery.size()>0) {
		return findWithNamedQuery.get(0);
		 }
		 return null;
	}

}
