<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="entity.Product" %>

<%
   Product product = (Product) request.getAttribute("product");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
		<body>
			
			<%@include file="template/header.jsp" %>
			
			<div><%= product.getImage() %></div>
	
			<div>
				<%= product.getName() %>
				<%= product.getDescription() %>
				<%= product.getPrice() %>
				
				<form action=""></form>
				
			</div>
			
		</body>
</html>