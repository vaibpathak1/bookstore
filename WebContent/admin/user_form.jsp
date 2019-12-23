<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<title>Create new User</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">
			<c:if test="${user !=null}">
			Edit user
			</c:if>
			<c:if test="${user ==null}">
			Create user
			</c:if>
		</h2>
	</div>
	<div align="center">
	<c:if test="${user !=null}">
			<form action="update_user" method="post" id="userform">
			<input type="hidden" name="userId" value="${user.userId}">
			</c:if>
			<c:if test="${user ==null}">
		<form action="create_user" method="post" id="userform">
			</c:if>
			<table class="form">
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" id="email" name="email" size="20" value="${users.email}" /></td>
				</tr>
				<tr>
					<td align="right">FullName:</td>
					<td align="left"><input type="text" id="fullname" name="fullname" size="20" value="${users.fullname}"/></td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password" name="password" size="20" value="${users.password}" /></td>
				</tr>
				<tr>
					<td>&nbsp;></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<button type="submit" value="save"/></td>
					<td><button type="button" value="cancel"/></td>

				</tr>
			</table>
		</form>
	

/* function validateFormInput(){
	
	var fieldEmail=document.getElementById("email");
	var fieldFullName=document.getElementById("fullname");
	var fieldPassword=document.getElementById("password");

	if(fieldEmail.value.length ==0){
		alert ("Email is required");
		fieldEmail.focus();
		return false;
	}
	if(fieldFullName.value.length ==0){
		alert ("FullName is required");
		fieldFullName.focus();
		return false;
	}
	if(fieldPassword.value.length ==0){
		alert ("Password is required");
		fieldPassword.focus();
		return false;
	}
	return true;
} */
	</div>
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">

$(document).ready(function(){
	$("#userform").validate({
	rules:{
		email:{
			required:true,
			email:true
		},
		fullname:"required",
		password:"required"
	},
	messages:{
		email:{
			required:"please enter email",
			email:"please enter an valid email"
		},
		fullname:"please enter fullname",
		password:"please enter password"
	}});
});
</script>
</body>
</html>

