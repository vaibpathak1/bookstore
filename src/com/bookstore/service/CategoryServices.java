package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

public class CategoryServices {
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private EntityManager entityManager;

	public CategoryServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		categoryDAO = new CategoryDAO(entityManager);
	}

	public void listCategory(String message) throws ServletException, IOException {
		List<Category> listcategory = categoryDAO.listAll();
		System.err.println("listcategory " + listcategory.size());
		request.setAttribute("listcategory", listcategory);
		if (message != null) {
			request.setAttribute("message", message);
		}
		String categoryListPage = "category_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(categoryListPage);
		dispatcher.forward(request, response);
	}

	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}

	public void createCategory() throws ServletException, IOException {
		System.out.println(request.getParameter("name"));
		String name = request.getParameter("name");
		Category findByName = categoryDAO.findByName(name);
		if (name != null) {
			String message = "Could not create category" + name + "already exists";
			request.setAttribute(message, "message");
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else {
			Category category = new Category();
			categoryDAO.create(category);
			listCategory("category created sucessfully now");
		}
	}

	public void editCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDAO.get(categoryId);
		
		String destPage = "category_form.jsp";
		
		if (category != null) {
			request.setAttribute("category", category);	
		} else {
			String message = "Could not find category with ID " + categoryId;
			request.setAttribute("message", message);
			destPage = "message.jsp";
		}			
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destPage);
		requestDispatcher.forward(request, response);
	}

	public void updateCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("name");

		Category category = categoryDAO.get(categoryId);
		Category findByName = categoryDAO.findByName(categoryName);

		if (findByName != null && findByName.getCategoryId() != category.getCategoryId()) {
			String message = "Could not Category user" + categoryName + "already exists";
			request.setAttribute(message, "message");
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else {
			Category categorys = new Category();
			categoryDAO.update(categorys);
			String message = "Category has been succesfully updated";
			listCategory(message);
		}
	}

	public void deletCategory() throws ServletException, IOException {
		Integer catId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDAO.get(catId);

		if (category != null) {
			String message = "Deleted Category Successfully with ID: " + catId;
			request.setAttribute("message", message);
			listCategory(message);
		} else {
			String message = "Category not found in DB";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);

		}
	}
	
}
