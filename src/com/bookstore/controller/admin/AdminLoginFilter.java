package com.bookstore.controller.admin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminLoginFilter implements Filter {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginFilter (){
        super();
    }

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest)request;
		HttpSession session = httprequest.getSession(false);
		
		boolean loggedin = session !=null && session.getAttribute("email") != null;
		String loginUrl = httprequest.getContextPath() + "/admin/login";
		boolean loginRequest = httprequest.getRequestURI().equals(loginUrl);
		boolean loginPage = httprequest.getRequestURI().endsWith("login.jsp");
		
		if (loggedin && (loginRequest ||loginPage)) {
			request.getRequestDispatcher("/admin/").forward(request, response);
		}else if(loggedin || loginRequest) {
			chain.doFilter(request, response);
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

		
}
