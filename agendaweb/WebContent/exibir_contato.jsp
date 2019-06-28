<%@ page import="br.senai.sp.model.Contato"%>
<%@ page import="br.senai.sp.model.Tipo"%>
<%@ page import="br.senai.sp.model.Usuario" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 

	Usuario usuario = new Usuario();
	usuario = (Usuario)session.getAttribute("usuario");
	
	Contato contato = new Contato();
	contato = (Contato)request.getAttribute("contato");	
	if (usuario != null){
		// CARREGAR A PÁGINA DO INDEX 
%> 
    
			    
			    
			<!DOCTYPE html>
			<html>
				<head>
					<meta charset="UTF-8">
					<title>Insert title here</title>
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
										<p><%= usuario.getEmail()%></p>
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
									<div class="card-header text-white bg-dark"><img src="./imagens/itens.png" class="mr-2">Meus Contatos</div>
									<div class="card-body">
									
									
										<div class="alert alert-primary">
											<h5>Consultar Contato</h5>
										</div>
									
										<form id="formulario_cadastro" action="CadastroContatoServlet" method="post">
											<div id="alerta_erro">
				      					<ul id="lista_erros"></ul>
				      				</div>
											<div class="form-row  mt-2">
												<div class="form_group col-md-8">
													<label for="nome">Nome:</label>
													<input id="nome" class="form-control" type="text" name="txt_nome" value="<%= contato.getNome()%>">
												</div>
												<div class="form_group col-md-4">
													<label for="dataNascimento">Data Nasc.:</label>
													<input id="dataNascimento" class="form-control" type="date" name="txt_datanascimento" value="<%= contato.getDataNascimento()%>">
												</div>
											</div>
											<div class="form-row  mt-2">
												<div class="form_group col-md-6">
													<label for="email">E-mail:</label>
													<input id="email" class="form-control" type="email" name="txt_email" value="<%= contato.getEmail()%>">
												</div>
												<div class="form_group col-md-3">
													<label for="telefone">Telefone:</label>
													<input id="telefone" class="form-control" type="text" name="txt_telefone" value="<%= contato.getTelefone()%>">
												</div>
												<div class="form_group col-md-3">
													<label for="tipo_combo">Tipo:</label>
													<select id="tipo_combo" name="combo_tipo" class="form-control">
														<option value="<%= Tipo.SELECIONE %>">SELECIONE</option>
														<option <%= contato.getTipo().toString().equals("AMIGO") ? "selected" : "" %> value="<%= Tipo.AMIGO %>">AMIGO</option>
														<option <%= contato.getTipo().toString().equals("FAMILIA") ? "selected" : "" %> value="<%= Tipo.FAMILIA %>">FAMILIA</option>
														<option <%= contato.getTipo().toString().equals("PROFISSIONAL") ? "selected" : "" %> value="<%= Tipo.PROFISSIONAL %>">PROFISSIONAL</option>
													</select>
												</div>
											</div>
											<div class="form-row mt-2">
												<div class="form_group col-md-12">
													<label for="endereco">Endereço:</label>
													<input id="endereco" class="form-control" type="text" name="txt_endereco" value="<%= contato.getEndereco()%>">
												</div>
											</div>
											<div class="form-row">
												<div class="form_group col-md-12 text-right mt-3">
													<a class="btn btn-secondary" href="meus_contatos.jsp">Voltar à lista de contato!</a>
													
												</div>
											</div>
										</form>
									</div>
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
			
					<script type="text/javascript" src="./js/valida_contato.js"></script>
					<script type="text/javascript" src="./jquery/jquery-3.4.0.min.js"></script>
					<script type="text/javascript" src="./bootstrapjs/bootstrap.min.js"></script>
				</body>
			</html>

<% } else {
		response.sendRedirect("login.html");
		}
	
	%>