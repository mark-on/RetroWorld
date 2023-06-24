<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
  <title>Login</title>
  <!-- Includi eventuali stili CSS -->
</head>
<body>

	<%@include file="template/header.jsp" %>

  <h1>Effettua il login</h1>
  <form id="loginForm" action="#">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <input type="submit" value="Login">
  </form>

  <script src="loginController.js"></script>
</body>
</html>
