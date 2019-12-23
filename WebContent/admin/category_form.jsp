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
<title>
<c:if test="${category !=null}">
Edit category
</c:if>
<c:if test="${category !=null}">
Create new category
</c:if>

</title>
</head>
<body>


	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">
			<c:if test="${category !=null}">
			Edit category
			
			</c:if>
			<c:if test="${category ==null}">
			Create category
			
			</c:if>
		
		
		
		</h2>
	</div>
	<div align="center">
	<c:if test="${category !=null}">
			<form action="update_category" method="post" id="userform">
			<input type="hidden" name="userId" value="${category.categoryId}">
			</c:if>
			<c:if test="${category ==null}">
		<form action="create_category" method="post" id="userform">
			</c:if>
			<table class="form">
				<tr>
					<td align="right">NAME:</td>
					<td align="left"><input type="text" id="name" name="name" size="20" value="${category.name}" /></td>
				</tr>
				<tr>
					<td>&nbsp;></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<button type="submit" value="save" /></td>
					<td><button type="button" value="cancel" onclick="javascript:history.go(-1);" /></td>
				</tr>
			</table>
		</form>

	</div>
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
function validateFormInput(){
	$(document).ready(function(){
	$("#userform").validate({
		rules:{
			name:{
				required:true,
				name:true
			},
		messages:{
			name:{
				required:"please enter name",
				email:"please enter an valid name"
			},
		}});
	}});
}


</script>
</body>
</html>

