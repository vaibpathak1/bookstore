package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {

	private static EntityManagerFactory createEntityManagerFactory;
	private static EntityManager createEntityManager;
	private static UserDAO dao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		createEntityManagerFactory = Persistence.createEntityManagerFactory("bookstore");
		createEntityManager = createEntityManagerFactory.createEntityManager();

		dao = new UserDAO(createEntityManager);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		createEntityManager.close();
		createEntityManagerFactory.close();
	}

	/**
	 * Test method for
	 * {@link main.java.com.bookstore.dao.JpaDAO#create(java.lang.Object)}.
	 */
	@Test
	public void testCreateT() {
		Users users = new Users();
		users.setEmail("vaib@gmail.com");
		users.setFullName("Vaibhav");
		users.setPassword("vaibhav");
		Users create = dao.create(users);
		assertTrue(users.getUserId() > 0);
	}

	@Test
	public void TestUpdateUser() {
		Users users = new Users();
		users.setUserId(1);
		users.setEmail("vaib@gmail.com");
		users.setFullName("Vaibhav1");
		users.setPassword("vaibhav1");
		users = dao.update(users);
		String expected="vaibhav1";
		String result=users.getPassword();
		assertEquals(expected,result);		
		
	}
	
	@Test
	public void testGetUserFound() {
		Integer userid=1;
		Users users =dao.get(userid);
		if(users !=null) {
			System.err.println(users.getEmail());
		}
		
		assertNotNull(users);		
		
	}
	
	@Test
	public void testGetUserNotFound() {
		Integer userid=99;
		Users users =dao.get(userid);
		assertNull(users);		
		
	}
	@Test
	public void testDelete() {
		Integer userid=99;
		dao.delete(userid);
		Users users =dao.get(userid);
		assertNull(users);		
		
	}
	
	@Test
	public void testUserList() {
		List<Users> listUsers=dao.listAll();
		assertTrue(listUsers.size()>0);
		
	}

	
	@Test(expected=PersistenceException.class)
	public void testCreateUsersFieldNotSet() {
		Users users = new Users();
		Users create = dao.create(users);
		assertTrue(users.getUserId() > 0);
	}
}
