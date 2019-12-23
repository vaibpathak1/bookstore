<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/style.css">
<title>Manage user-Book store Adminstration</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">User Management</h2>
		<h3><a href="user_form.jsp">Create New User</a></h3>
	</div>
	<c:if test="${message !=null}">
	<div align="center">
			<h4><i>${message}</i></h4>
	</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Email</th>
				<th>Full Name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="user" items="${listUsers}" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${user.userId}</td>
					<td>${user.email}</td>
					<td>${user.fullName}</td>
					<td><a href="edit_user?id=${user.userId}">EDIT</a>
					<a href="javascript:void(0)" class="deletelink">DELETE</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
	$(document).ready(function(){
		$(".deletelink").each(function(){
			$(this).on("click",function(){
				userId=$(this).attr("id");
				if (confirm ("Are You sure you want to Delete with ID '+ userId'?"));
// 				window.location='delete_user?id=' + userId ;
			})
			
		}});
	
/* 	function confirmDelete(userId){
		if (confirm ("Are You sure you want to Delete with ID '+ userId'?"));
		window.location='delete_user?id=' + userId ;
	} */
	
	</script>
</body>
</html>