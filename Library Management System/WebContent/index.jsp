<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Login Form</title>

  <link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/css/login.css">

</head>

<body>

  <div class="login">
    <div class="login-triangle"></div>

    <h2 class="login-header">Log in</h2>

    <form class="login-container" name="userLogin" method="post" action="userLogin">
    
    	<p style="color:red;" align="center">${errorMsg}</p>
      <p><input type="text" placeholder="Username" name="username"></p>
      <p><input type="password" placeholder="Password" name="password"></p>
      <p><input type="submit" value="Log in"></p>
    </form>
  </div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

</body>

</html>