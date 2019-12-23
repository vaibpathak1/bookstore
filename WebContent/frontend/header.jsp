<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<img alt="Header" src="images/BookstoreLogo.png">
	<div>
		<input type="text" name="keyword" size="50" /> 
		<input type="button" value="search"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <a href="Login">Sign In</a>
		 <a href="Register">Register</a>
		 <a href="Cart">Cart</a>
	</div>
	<div>
		<c:forEach var="category" items="${listCategory}" varStatus="status">
			<a href="view_category?id=${category.categoryId}">
			 <font size="+1"><b><c:out value=${category.name }/></b></font>
		</a>
		<c:if test="${not status.last}"></c:if>
		&nbsp; | &nbsp;
		</c:forEach>
	</div>
</div>