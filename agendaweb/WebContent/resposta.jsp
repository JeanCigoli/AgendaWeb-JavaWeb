<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
	<% 
		String nome = request.getParameter("nome");	
	
		String email = request.getParameter("email");	
		
		String senha = request.getParameter("senha");
		
		String confSenha = request.getParameter("conf_senha");	
	%>  
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Agenda Web</title>
		<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
	</head>
	<body>

		<h1><%= nome %></h1>
		<h2><%= email %></h2>
		<% if(senha.equals(confSenha)){ %>
			<h3><%= senha %></h3>
		<% } %>	
		
	</body>
</html>