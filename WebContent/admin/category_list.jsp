<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/style.css">
<title>Manage Category-Book store Adminstration</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">Category Management</h2>
		<h3>><a href="category_form.jsp">Create New Category</a></h3>
	</div>
	<c:if test="${message !=null}">
	<div align="center">
			<h4 class="message">${message}</h4>
	</div>
	</c:if>
	<div align="center">
		<table class="form">
				<th>Index</th>
				<th>ID</th>
				<th>Name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="category" items="${listcategory}" varStatus="status">
				<tr>
					<td>${status.index}</td>
			<tr>
					<td>${listcategory.categoryId}</td>
					<td>${listcategory.name}</td>
					<td><a href="edit_category?id=${category.categoryId}">EDIT</a>
					<a href="javascript:confirmDelete(${category.categoryId})">DELETE</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
	function confirmDelete(categoryId){
		confirm ("Are You sure you want to Delete with ID '+ categoryId'?");
		window.location='delete_user?id=' + categoryId ;
	}
	
	</script>
</body>
</html>