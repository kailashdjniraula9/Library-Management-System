<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.entities.Book" %>
	
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Add User</title>
  </head>
  <body>
  <% Book book = (Book)request.getAttribute("bookByIdList"); %>
  
  <h1 class="heading" align="center">Add new Book</h1>
    <form class="container" action="updateBook" method="post">
    <input type="hidden" name="id" value="<%=book.getId()%>">
  <div class="form-row ">
    <div class="form-group col-md-6">
      <label for="bookName">Book Name</label>
      <input type="text" class="form-control" id="bookName" name="bookName" value="<%=book.getBookName()%>">
    </div>
    <div class="form-group col-md-6">
      <label for="author">Author</label>
      <input type="text" class="form-control" id="author" name="author" value="<%=book.getAuthor()%>">
    </div>
     
      <div class="form-group col-md-6">
      <label for="publishedYear">Published Year</label>
      <input type="text" class="form-control" id="publishedYear" name="publishedYear" value="<%=book.getPublishedYear()%>">
    </div>
     <div class="form-group col-md-6">
      <label for="publisher">publisher</label>
      <input type="text" class="form-control" id="publisher" name="publisher" value="<%=book.getPublisher()%>">
    </div>
     <div class="form-group col-md-6">
      <label for="quantity">Quantity</label>
      <input type="text" class="form-control" id="quantity" name="quantity" value="<%=book.getQuantity()%>">
    </div>
     <div class="form-group col-md-6">
      
    </div>
  </div>
 

  <button type="submit" class="btn btn-success"  value="update book">Update Book</button>
<%--   <a class="btn btn-info" href="${pageContext.request.contextPath}/home.jsp" role="button">Go Back</a> --%>
</form>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>