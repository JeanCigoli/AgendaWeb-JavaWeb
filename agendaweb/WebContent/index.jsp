<%@ page import="br.senai.sp.model.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<% 

	Usuario usuario = new Usuario();
	usuario = (Usuario)session.getAttribute("usuario");
	
	if (usuario != null){
		// CARREGAR A PÁGINA DO INDEX 
%>    
    
		<!DOCTYPE html>
		<html>
			<head>
				<meta charset="UTF-8">
				<title>Web Agenda</title>
				<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
			</head>
			<body>
			
				<!-- CABECALHO DA CLASSE  -->
				<nav class="navbar navbar-dark bg-info">
					<div class="container-fluid">
						<div class="navbar-header">
							<img src="./imagens/cloud64.png">
							<a class="navbar-brand" href="index.jsp"><h3>Web Agenda 1.0</h3></a>
						</div>
					</div>
				</nav>
				
				<div class="container mb-5">
					<div class="row mt-5">
					
						<div class="col-md-3">
						
							<div class="card">
								<div class="card-header text-white bg-dark"><img src="./imagens/user24.png" class="mr-2">Usuário</div>
								<div class="card-body text-center">
									<img src="./imagens/user64.png" >
									<h6 class="mt-3"><%= usuario.getNome()%></h6>
									<p><%= usuario.getEmail() %></p>
								</div>
								<div class="card-footer text-center">
									<a href="FinalizarSessaoServlet">Sair do Sistema</a>
								</div>
							</div>
							
							<div class="card mt-3">
								<div class="card-header text-white bg-dark"><img src="./imagens/menu24.png" class="mr-2">Menu</div>
									<div class="list-group">
		    						<a class="list-group-item" href="index.jsp"><img src="./imagens/home.png" class="mr-2">Home</a>
		    						<a class="list-group-item" href="meus_contatos.jsp"><img src="./imagens/tele.png" class="mr-2">Meus Contatos</a>
		    						<a class="list-group-item" href="compromisso.jsp"><img src="./imagens/comp.png" class="mr-2">Meus Compromissos</a>
		  						</div>
								<div class="card-footer"></div>
							</div>
							
						</div>
						
						<div class="col-md-9">
						
							<div class="card">
								<div class="card-header text-white bg-dark"><img src="./imagens/itens.png" class="mr-2">Bem-Vindo</div>
								<div class="card-body"></div>
								<div class="card-footer"></div>
							</div>
							
						</div>
					</div>
				</div>
				
				<footer class="bg-info">
						<hr>
						<h6 class="text-center">Desenvolvido por Cigoli Company - 2019</h6>
						<h6 class="text-center mb-3">Contato: jeancigoli30@gmail.com</h6>
						<hr>
				</footer>
		
				<script type="text/javascript" src="./jquery/jquery-3.4.0.min.js"></script>
				<script type="text/javascript" src="./bootstrapjs/bootstrap.min.js"></script>
			</body>
		</html>

<% } else {
		response.sendRedirect("login.html");
		}
	
	%>