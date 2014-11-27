<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<%
String status = (String)request.getAttribute("status");
String nomeDoExercicio = (String)request.getAttribute("nomedoexercicio");
String descricaoDoExercicio = (String)request.getAttribute("descricaodoexercicio");
String nomeDoCliente = (String)request.getAttribute("nomedocliente");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gym Training - Cadastro de Exercícios</title>
	</head>

	<body>
		<h1>Cadastro de Exercícios</h1>
		<a href="../">Voltar</a>
		<hr>
		<% if (status == "sucesso") { %>
		<h4>Exercício Cadastrado:</h4>
		<p>Nome do Exercicio: <%= nomeDoExercicio %></p>
		<p>Descrição do Exercicio:</p>
		<pre><%= descricaoDoExercicio %></pre>
		<p>Exercício cadastrado na lista de exercícios do cliente: <%= nomeDoCliente %> </p>
		<% } else { %>
		<h4>Houve um erro! :(</h4>
		<p>Entre em contato com o Desenvolvedor</p>
		<% } %>
	</body>
</html>