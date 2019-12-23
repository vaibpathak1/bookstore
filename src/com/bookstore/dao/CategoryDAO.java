package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category>{

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Category update(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category get(Object categoryId) {
		 return super.find(Category.class,categoryId);
	}

	@Override
	public void delete(Object categoryId) {
		 super.delete(Category.class,categoryId);		
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public long count() {
		return super.count("Category.countAll");
	}

	public Category findByName(String name) {
		 List<Category> findWithNamedQuery = super.findWithNamedQuery("Category.findByName","name",name);
		 if(findWithNamedQuery !=null && findWithNamedQuery.size()>0) {
		return findWithNamedQuery.get(0);
		 }
		 return null;
	}

	
}
