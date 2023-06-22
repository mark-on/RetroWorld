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
			
			<div id="corpo-annuncio">
				<div id="img-ann"><%= product.getImage() %></div>
		
				<div id="acquisto">
					
					<div id="nome"><%= product.getName() %> </div>
					<div id="descrizione"> <%= product.getDescription() %> </div>
					<div id="prezzo"> <%= product.getPrice() %></div>
					
					<div id="form-acquisto">
						<form action="/carrello" method="post">
						
						    <label for="quantita">Quantità:</label>
						    <input type="number" id="quantita" name="quantita" required><br><br>
						
						    <input type="submit" value="Aggiungi al carrello">
					  </form>
					</div>
				</div>
			</div>
		</body>
</html>