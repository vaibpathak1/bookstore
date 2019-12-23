<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center">
	<img alt="Header" src="images/BookstoreAdminLogo.png">

	<div>
		Welecome, <c:out value="${sessionScope.useremail}"></c:out> | <a href="logout">Logout</a>
		<br/><br/>
	</div>
	<div id="headermenu">
	<div ><a href="list_users"><img src="../images/user.png"/><br/>Users</a></div>
	<div ><a href="list_category"><img src="../images/category.png"/><br/>Categories</a></div>
	<div ><a href="Books"><img src="../images/bookstack.png"/><br/>Books</a> </div>
	<div ><a href="Customer"><img src="../images/customer.png"/><br/>Customer</a></div>
	<div ><a href="Reviews"><img src="../images/review.png"/><br/>Reviews</a></div>
	<div ><a href="order"><img src="../images/order.png"/><br/>order</a></div>
	</div>
</div>