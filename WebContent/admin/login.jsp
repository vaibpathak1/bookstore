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
<title>Admin</title>
</head>
<body>
<div align="center">
<h1>Book Store Adminstration</h1>
<h2>ADMIN LOGIN</h2>
	<div>
		<c:if test="${message !=null}">
	 	<div align="center">
		<h4><i>${message}</i></h4>
	</div>
		</c:if>

</div>

<form action="login" method="post" id="formlogin">
			<table class="form">
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" id="email" name="email" size="20" value="${users.email}" /></td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password" name="password" size="20" value="${users.password}" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<button type="submit">Login</button>
					</td>
					<td>
					<button>Login</button>
					</td>
				</tr>
				
			</table>
		</form>
</div>
	<script type="text/javascript">

$(document).ready(function(){
	$("#formlogin").validate({
	rules:{
		email:{
			required:true,
			email:true
		},
		password:"required"
	},
	messages:{
		email:{
			required:"please enter email",
			email:"please enter an valid email"
		},
		password:"please enter password"
	}});
});
</script>

</body>
</html>