<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Registrazione</title>
  <!-- Includi eventuali stili CSS -->
</head>
<body>

	<%@include file="template/header.jsp" %>

  <h1>Registrazione</h1>
  <form id="registrationForm" action="#">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <input type="submit" value="Registrati">
  </form>

  <script src="registrationController.js"></script>
</body>
</html>
