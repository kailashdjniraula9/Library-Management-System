<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.library.entities.Book"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>List Books</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/home.css"
	rel="stylesheet">

</head>

<body>

	<div class="d-flex" id="wrapper">

		<!-- Sidebar -->
		<div class="bg-light border-right" id="sidebar-wrapper">
			<div class="sidebar-heading">Start Bootstrap</div>
			<div class="list-group list-group-flush">
				<a href="#" class="list-group-item list-group-item-action bg-light">Dashboard</a>
				<a href="${pageContext.request.contextPath}/view/addUser.jsp"
					class="list-group-item list-group-item-action bg-light">Add
					User</a> <a href="${pageContext.request.contextPath}/users"
					class="list-group-item list-group-item-action bg-light">View
					User</a> <a href="${pageContext.request.contextPath}/view/addBook.jsp"
					class="list-group-item list-group-item-action bg-light">Add
					Book</a> <a href="${pageContext.request.contextPath}/books"
					class="list-group-item list-group-item-action bg-light">View
					Book</a> <a href="#"
					class="list-group-item list-group-item-action bg-light">Profile</a>
				<hr>
			</div>
		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">

			<nav
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
				<button class="btn btn-primary" id="menu-toggle">Toggle
					Menu</button>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link">Welcome
								Home <span style="color: green;"> <%=session.getAttribute("sessionValue")%>
									&nbsp;&nbsp;&nbsp;
							</span>
						</a></li>
						<li class="nav-item active"><a href="index.jsp"
							class="btn btn-outline-info" role="button" aria-pressed="true"
							data-toggle="modal" data-target="#logoutModal">Logout</a></li>

					</ul>
				</div>
			</nav>
			<div class="alert alert-primary" role="alert" align="center">
				<%
					List<Book> books = (List<Book>) request.getAttribute("bookList");
				%>
				<p class="h4">
					Total Number of Users :
					<%=books.size()%>
				</p>
			</div>
			<div class="container-fluid">



				<table class="table table-bordered" style="text-align: center;">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Book Name</th>
							<th scope="col">Author</th>
							<th scope="col">Publisher</th>
							<th scope="col">Published Year</th>
							<th scope="col">Quantity</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Book book : books) {
						%>
						<tr>
							<td><%=book.getId()%></td>
							<td><%=book.getBookName()%></td>
							<td><%=book.getAuthor()%></td>
							<td><%=book.getPublisher()%></td>
							<td><%=book.getPublishedYear()%></td>
							<td><%=book.getQuantity()%></td>
							
							<td><a href="books/getBookEdit?id=<%=book.getId()%>"
								onclick="return confirm('Are you really going to modify this record ? ');" type="button"
								class="btn btn-outline-info" aria-pressed="true">Edit</a>
								 <a
								onclick="return confirm('Are you sure to delete this record ?');"
								href="deleteBook?id=<%=book.getId()%>" type="button"
								class="btn btn-outline-danger" aria-pressed="true">Delete</a> </td>
						</tr>

						

						<%
							}
						%>
					</tbody>
				</table>
			</div>
			<!-- /#page-content-wrapper -->

		</div>
		<!-- /#wrapper -->

		<!-- Modal -->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Logout Warning</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Are you sure you want to Logout?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
						<a href="index.jsp" type="button" class="btn btn-danger"
							aria-pressed="true">Logout</a>
					</div>
				</div>
			</div>
		</div>


		<!-- Bootstrap core JavaScript -->
		<script
			src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Menu Toggle Script -->
		<script>
			$("#menu-toggle").click(function(e) {
				e.preventDefault();
				$("#wrapper").toggleClass("toggled");
			});
		</script>
</body>

</html>
