<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Store Adminstration</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>AdminstrativeDashboard</h2>
	</div>
	<div align="center">
		<hr width="60%" />
		<h2>Quick Action:</h2>
		<b>  <a href="create_book">New Book</a> &nbsb; 
		     <a href="create_user">New User</a> &nbsb;
			 <a href="create_category">NewCategory</a> &nbsb; 
			 <a href="create_customer">New Customer</a> &nbsb;
		</b>
	</div>
	<div align="center">
		<hr width="60%" />
		<h2>QRecent Sales:</h2>
	</div>
	<div align="center">
		<hr width="60%" />
		<h2>Recent Review:</h2>
	</div>
	<div align="center">
		<hr width="60%" />
		<h2>Statistics:</h2>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>