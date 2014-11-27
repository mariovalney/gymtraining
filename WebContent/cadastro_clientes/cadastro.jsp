<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<%
String status = (String)request.getAttribute("status");
String nomeDoClienteo = (String)request.getAttribute("nomedocliente");
String emailDoCliente = (String)request.getAttribute("emaildocliente");
String idDoCliente = (String)request.getAttribute("iddocliente");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gym Training - Cadastro de Clientes</title>
	</head>

	<body>
		<h1>Cadastro de Clientes</h1>
		<a href="../">Voltar</a>
		<hr>
		<% if (status == "sucesso") { %>
		<h4>Novo Cliente Cadastrado:</h4>
		<p>Nome: <%= nomeDoClienteo %></p>
		<p>E-mail: <%= emailDoCliente %></p>
		<% } else if (status == "cadastrado") { %>
		<h4>Cliente Já Cadastrado:</h4>
		<p>Não foi possível cadastrar esse cliente pois ele já está cadastrado:</p>
		<p>Nome: <%= nomeDoClienteo %></p>
		<p>E-mail: <%= emailDoCliente %></p>
		<% } else if (status == "editado") { %>
		<h4>Cliente Editado com Sucesso:</h4>
		<p>Nome: <%= nomeDoClienteo %></p>
		<p>E-mail: <%= emailDoCliente %></p>
		<% } else { %>
		<h4>Houve um erro! :(</h4>
		<p>Entre em contato com o Desenvolvedor</p>
		<% } %>
	</body>
</html>