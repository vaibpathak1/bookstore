package com.bookstore.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CategoryDAOTest {
	private static EntityManagerFactory createEntityManagerFactory;
	private static EntityManager createEntityManager;
	private static CategoryDAO dao;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		createEntityManagerFactory = Persistence.createEntityManagerFactory("bookstore");
		createEntityManager = createEntityManagerFactory.createEntityManager();

		dao = new CategoryDAO(createEntityManager);

	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		createEntityManager.close();
		createEntityManagerFactory.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCategoryDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testListAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

}
